package tech.noetzold.iotManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.iotManager.model.Humidity;

public interface HumidityRepository extends JpaRepository<Humidity, Long> {
}
