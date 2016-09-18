package org.xstio.ImageManager.repositories;

import java.io.File;
import java.util.List;

import org.xstio.ImageManager.metier.Image;

public interface ImageDAO {
	List<Image> findAll();
	List<Image> findByTag(int tid);
	List<Image> findByGalerie(int gid);
	Image findById(int id);
	Image save(Image i, File f);
	File getFile(Image i);
}
