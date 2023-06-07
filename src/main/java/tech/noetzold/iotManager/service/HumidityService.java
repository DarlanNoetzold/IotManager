package tech.noetzold.iotManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.iotManager.model.Humidity;
import tech.noetzold.iotManager.repository.HumidityRepository;

@Service
public class HumidityService {

    @Autowired
    HumidityRepository humidityRepository;

    public Humidity saveHumidity(Humidity humidity){
        return humidityRepository.save(humidity);
    }
}
