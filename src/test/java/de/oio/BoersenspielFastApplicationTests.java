package de.oio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.oio.model.Aktie;
import de.oio.model.Haendler;
import de.oio.repository.AktieRepository;
import de.oio.service.HaendlerService;
import de.oio.service.TransaktionService;

@SpringBootTest
class BoersenspielFastApplicationTests {
	
	@Autowired
	private HaendlerService haendlerService;
	
	@Autowired
	private TransaktionService transaktionService;
	
	@Autowired
	private AktieRepository aktieRepository;

	@Test
	void testAll() {
		Haendler haendler = haendlerService.registriere(5000000);
		
		Aktie aktie = new Aktie();
		aktie.setName("MLP");
		aktie.setKursInCent(100);
		Aktie aktieNachDemSpeichern = aktieRepository.save(aktie);
		
		transaktionService.handleAktie(haendler, aktie, 5, aktie.getKursInCent());
		
		assertEquals(-4, aktieRepository.findById(aktieNachDemSpeichern.getId()).get().getKursInCent());
		
	}

}
