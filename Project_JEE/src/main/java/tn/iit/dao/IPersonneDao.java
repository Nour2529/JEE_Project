package tn.iit.dao;

import java.util.List;

import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Personne;



public interface IPersonneDao {
public Personne save(Personne p);
public List<Personne> personneParMC(String mc);
public Personne getPersonne(Long id);
public Personne updatePersonne(Personne p);
public void deletePersonne(Long id);
}
