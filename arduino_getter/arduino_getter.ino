#include <NewPing.h>
#include <DHT.h>

#define TRIGGER_PIN 3
#define ECHO_PIN 2
#define DHT_PIN 8

NewPing sonar(TRIGGER_PIN, ECHO_PIN);
DHT dht(DHT_PIN, DHT11);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  delay(2000);  // Aguarda 2 segundos para evitar leituras muito frequentes

  // Mede a distância com o sensor ultrassônico
  unsigned int distance = sonar.ping_cm();

  // Lê a temperatura e a umidade do sensor DHT11
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  // Exibe os valores no monitor serial
  Serial.print("Distancia: ");
  Serial.print(distance);
  Serial.print(" \t");

  Serial.print("Temperatura: ");
  Serial.print(temperature);
  Serial.print(" \t");

  Serial.print("Umidade: ");
  Serial.print(humidity);
  Serial.println(" ");
}
