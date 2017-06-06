package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

}
