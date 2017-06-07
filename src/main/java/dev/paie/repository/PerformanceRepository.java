package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Performance;
import dev.paie.entite.RemunerationEmploye;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

}
