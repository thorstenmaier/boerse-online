package de.oio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DepotEintrag {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Aktie aktie;
	
	private int kaufkursInCent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aktie getAktie() {
		return aktie;
	}

	public void setAktie(Aktie aktie) {
		this.aktie = aktie;
	}

	public int getKaufkursInCent() {
		return kaufkursInCent;
	}

	public void setKaufkursInCent(int kaufkursInCent) {
		this.kaufkursInCent = kaufkursInCent;
	}
	
	
}
