package tech.noetzold.iotManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.iotManager.model.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
}
