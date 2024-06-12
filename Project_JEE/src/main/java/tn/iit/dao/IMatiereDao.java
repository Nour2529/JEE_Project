package tn.iit.dao;

import java.util.List;

import tn.iit.metier.entites.Matiere;





public interface IMatiereDao {
public Matiere save(Matiere m);
public List<Matiere> matiereParMC(String mc);
public Matiere getMatiere(Long id);
public Matiere updateMatiere(Matiere m);
public void deleteMatiere(Long id);
}
