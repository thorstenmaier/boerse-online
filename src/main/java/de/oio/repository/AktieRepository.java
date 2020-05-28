package de.oio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.oio.model.Aktie;

public interface AktieRepository extends JpaRepository<Aktie, Long> {

}
