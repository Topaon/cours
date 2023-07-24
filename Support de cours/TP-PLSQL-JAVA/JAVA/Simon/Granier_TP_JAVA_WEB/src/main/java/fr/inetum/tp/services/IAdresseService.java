package fr.inetum.tp.services;

import java.util.ArrayList;

import fr.inetum.tp.entites.Adresse;

public interface IAdresseService {
	ArrayList<Adresse> allAdresse();
	Adresse readAdresse(int id);
	Adresse addAdresse(Adresse a);
}