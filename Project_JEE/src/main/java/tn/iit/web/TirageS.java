package tn.iit.web;

import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Tirage;

public class TirageS {
	private String motCle;
	List<Tirage> tirage = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Tirage> getTirage() {
		return tirage;
	}
	public void setTirage(List<Tirage> tirage) {
		this.tirage = tirage;
	}
	
	

}