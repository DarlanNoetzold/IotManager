package tech.noetzold.iotManager.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.noetzold.iotManager.message.RabbitmqConstantes;
import tech.noetzold.iotManager.model.Temperature;
import tech.noetzold.iotManager.service.TemperatureService;

import javax.transaction.Transactional;

@Component
public class TemperatureConsumer {

    @Autowired
    TemperatureService temperatureService;

    @Transactional
    @RabbitListener(queues = RabbitmqConstantes.QUEUE_TEMPERATURE)
    private void consumerTemperature(String mensagem) throws JsonProcessingException {
        Temperature temperature = new ObjectMapper().readValue(mensagem, Temperature.class);
        temperatureService.saveTemperature(temperature);
    }
}
