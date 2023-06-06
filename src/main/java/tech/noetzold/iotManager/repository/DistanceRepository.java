package tech.noetzold.iotManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.iotManager.model.Distance;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
