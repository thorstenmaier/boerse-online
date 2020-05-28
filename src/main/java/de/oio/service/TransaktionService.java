package de.oio.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.oio.model.Aktie;
import de.oio.model.DepotEintrag;
import de.oio.model.Haendler;
import de.oio.repository.AktieRepository;
import de.oio.repository.HaendlerRepository;

@Component
public class TransaktionService {
	
	@Autowired
	private AktieRepository aktieRepository;
	
	@Autowired
	private HaendlerRepository haendlerRepository;
	
    @PersistenceContext
    private EntityManager entityManager;

	public List<Aktie> getAlleAktien() {
		return aktieRepository.findAll();
	}
	
	@Transactional
	public boolean handleAktie(Haendler haendler, Aktie aktie, int anzahl, int kursInCent) {
		Aktie aktieInJpaSession = aktieRepository.findById(aktie.getId()).orElse(null);
		Haendler haendlerInJpaSession = haendlerRepository.findById(haendler.getId()).orElse(null);
		
		if (anzahl > 0) {			
			DepotEintrag depotEintrag = new DepotEintrag();
			depotEintrag.setAktie(aktieInJpaSession);
			depotEintrag.setKaufkursInCent(aktieInJpaSession.getKursInCent());
			haendlerInJpaSession.getDepotEintraege().add(depotEintrag);
			
			// TODO Preis der Aktie anpassen
			
			// Kontostand anpassen
			int alterKontostand = haendlerInJpaSession.getKontostandInCent();
			haendlerInJpaSession.setKontostandInCent(alterKontostand - (anzahl * aktieInJpaSession.getKursInCent()));
		}
		
		return true;
	}
}
