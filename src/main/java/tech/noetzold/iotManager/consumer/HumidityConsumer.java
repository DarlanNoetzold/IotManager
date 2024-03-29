package tech.noetzold.iotManager.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.noetzold.iotManager.message.RabbitmqConstantes;
import tech.noetzold.iotManager.model.Humidity;
import tech.noetzold.iotManager.service.HumidityService;

import javax.transaction.Transactional;

@Component
public class HumidityConsumer {

    @Autowired
    HumidityService humidityService;

    @Transactional
    @RabbitListener(queues = RabbitmqConstantes.QUEUE_HUMIDITY)
    private void consumerHumidity(String mensagem) throws JsonProcessingException {
        Humidity humidity = new ObjectMapper().readValue(mensagem, Humidity.class);
        humidityService.saveHumidity(humidity);
    }
}
