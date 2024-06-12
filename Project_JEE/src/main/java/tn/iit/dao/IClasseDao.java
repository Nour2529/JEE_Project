package tn.iit.dao;

import java.util.List;

import tn.iit.metier.entites.Classe;



public interface IClasseDao {
public Classe save(Classe c);
public List<Classe> classeParMC(String mc);
public Classe getClasse(Long id);
public Classe updateClasse(Classe c);
public void deleteClasse(Long id);
}
