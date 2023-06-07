package tech.noetzold.iotManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.iotManager.model.Temperature;
import tech.noetzold.iotManager.repository.TemperatureRepository;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;

    public Temperature saveTemperature(Temperature temperature){
        return temperatureRepository.save(temperature);
    }
}
