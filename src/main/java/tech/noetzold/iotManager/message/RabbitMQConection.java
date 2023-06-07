package tech.noetzold.iotManager.message;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;
@Component
public class RabbitMQConection {
    private static final String NOME_EXCHANGE = "amq.direct";

    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    private void adiciona(){
        DirectExchange troca = this.trocaDireta();
        Queue distanceQueue = this.fila(RabbitmqConstantes.QUEUE_DISTANCE);
        Queue humidityQueue = this.fila(RabbitmqConstantes.QUEUE_HUMIDITY);
        Queue temperatureQueue = this.fila(RabbitmqConstantes.QUEUE_TEMPERATURE);


        Binding distanceBinding = this.relacionamento(distanceQueue, troca);
        Binding humidityBinding= this.relacionamento(humidityQueue, troca);
        Binding temperatureBinding = this.relacionamento(temperatureQueue, troca);

        //Criando as filas no RabbitMQ
        this.amqpAdmin.declareQueue(distanceQueue);
        this.amqpAdmin.declareQueue(humidityQueue);
        this.amqpAdmin.declareQueue(temperatureQueue);

        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(distanceBinding);
        this.amqpAdmin.declareBinding(humidityBinding);
        this.amqpAdmin.declareBinding(temperatureBinding);
    }
}
