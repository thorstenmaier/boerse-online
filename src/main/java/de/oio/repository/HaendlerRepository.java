package de.oio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.oio.model.Haendler;

public interface HaendlerRepository extends JpaRepository<Haendler, Long> {

}
