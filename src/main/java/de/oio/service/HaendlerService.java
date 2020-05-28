package de.oio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.oio.model.Haendler;
import de.oio.repository.HaendlerRepository;

@Component
//@Service
public class HaendlerService {

	@Autowired
	private HaendlerRepository haendlerRepository;

	public Haendler registriere(int kontostandInCent) {
		Haendler h = new Haendler();
		h.setKontostandInCent(kontostandInCent);
		return haendlerRepository.save(h);
	}
}
