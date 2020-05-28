package de.oio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Haendler {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DepotEintrag> depotEintraege = new ArrayList<>();
	
	private int kontostandInCent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DepotEintrag> getDepotEintraege() {
		return depotEintraege;
	}

	public void setDepotEintraege(List<DepotEintrag> depotEintraege) {
		this.depotEintraege = depotEintraege;
	}

	public int getKontostandInCent() {
		return kontostandInCent;
	}

	public void setKontostandInCent(int kontostandInCent) {
		this.kontostandInCent = kontostandInCent;
	}
	
	
}
