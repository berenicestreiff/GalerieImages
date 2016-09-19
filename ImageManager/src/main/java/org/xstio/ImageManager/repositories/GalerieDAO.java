package org.xstio.ImageManager.repositories;

import java.util.List;

import org.xstio.ImageManager.metier.Galerie;

public interface GalerieDAO {
	List<Galerie> findAll();
	Galerie findById(int id);
}
