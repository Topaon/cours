package fr.inetum.tp.services;

import java.util.ArrayList;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;

public interface IStagiaireService {
	ArrayList<Stagiaire> allStagiaire();
	void removeStagiaire(Stagiaire s);
	void addStagiaire(Stagiaire stagiaire, Adresse adresse);
	Stagiaire getStagiaire(int id);
}
