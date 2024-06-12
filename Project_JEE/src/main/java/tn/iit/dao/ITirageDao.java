package tn.iit.dao;

import java.util.List;

import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Tirage;



public interface ITirageDao {
public Tirage save(Tirage t);
public List<Tirage> tirageParMC(String mc);
public Tirage getTirage(Long id);
public Tirage updateTirage(Tirage c);
public void deleteTirage(Long id);
}
