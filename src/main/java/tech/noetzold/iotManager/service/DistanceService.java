package tech.noetzold.iotManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.iotManager.model.Distance;
import tech.noetzold.iotManager.repository.DistanceRepository;

@Service
public class DistanceService {

    @Autowired
    DistanceRepository distanceRepository;

    public Distance saveDistance(Distance distance){
        return distanceRepository.save(distance);
    }
}
