import serial
import pika

# Configurações do RabbitMQ
rabbitmq_host = 'localhost'
rabbitmq_username = 'guest'
rabbitmq_password = 'guest'

# Configurações das filas
queue_distance = 'distance'
queue_temperature = 'temperature'
queue_humidity = 'humidity'

# Configuração da porta serial
serial_port = '/dev/ttyACM0'
baud_rate = 9600

# Conecta ao RabbitMQ
credentials = pika.PlainCredentials(rabbitmq_username, rabbitmq_password)
parameters = pika.ConnectionParameters(host=rabbitmq_host, credentials=credentials)
connection = pika.BlockingConnection(parameters)
channel = connection.channel()

# Cria as filas no RabbitMQ
channel.queue_declare(queue=queue_distance)
channel.queue_declare(queue=queue_temperature)
channel.queue_declare(queue=queue_humidity)

# Conecta à porta serial
ser = serial.Serial(serial_port, baud_rate)

# Lê e envia os dados para as filas
while True:
    try:
        # Lê uma linha do monitor serial
        line = ser.readline().decode().strip()
        print(line)

        # Divide a linha em valores separados
        values = line.split('\t')
        if len(values) == 3:
            distance = values[0].split(':')[1].strip()
            temperature = values[1].split(':')[1].strip()
            humidity = values[2].split(':')[1].strip()

            # Envia os valores para as filas correspondentes
            channel.basic_publish(exchange='', routing_key=queue_distance, body=distance)
            channel.basic_publish(exchange='', routing_key=queue_temperature, body=temperature)
            channel.basic_publish(exchange='', routing_key=queue_humidity, body=humidity)

    except KeyboardInterrupt:
        # Fecha a conexão com o RabbitMQ e a porta serial
        connection.close()
        ser.close()
        break

