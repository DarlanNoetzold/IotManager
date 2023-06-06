package tech.noetzold.iotManager.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.noetzold.iotManager.message.RabbitmqConstantes;
import tech.noetzold.iotManager.model.Distance;
import tech.noetzold.iotManager.service.DistanceService;

import javax.transaction.Transactional;

@Component
public class DistanceConsumer {

    @Autowired
    DistanceService distanceService;

    @Transactional
    @RabbitListener(queues = RabbitmqConstantes.QUEUE_DISTANCE)
    private void consumerAlert(String mensagem) throws JsonProcessingException {
        Distance distance = new ObjectMapper().readValue(mensagem, Distance.class);
        distanceService.saveDistance(distance);
    }
}
