package lk.ijse.pulsefit.classservice.repository;

import lk.ijse.pulsefit.classservice.entity.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<FitnessClass, Long> {
}
