package org.xstio.ImageManager.repositories;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.xstio.ImageManager.metier.Image;
import org.xstio.ImageManager.utils.FileStorageManager;

public class ImageDAOImpl implements ImageDAO {
	@PersistenceContext
	EntityManager em;
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}

	private FileStorageManager fileStorageManager;
	public FileStorageManager getFileStorageManager() {return fileStorageManager;}
	public void setFileStorageManager(FileStorageManager fileStorageManager) {this.fileStorageManager = fileStorageManager;}
	
	@Override
	public List<Image> findAll() {
		return em.createQuery("FROM Image", Image.class).getResultList();
	}

	@Override
	public List<Image> findByTag(int tid) {
		return null;
	}
	@Override
	public List<Image> findByGalerie(int gid) {
		TypedQuery<Image> tq = em.createQuery("SELECT i FROM Image WHERE galerie = :gid", Image.class);
		tq.setParameter(1, gid);
		return tq.getResultList();
	}

	@Override
	public Image findById(int id) {
		TypedQuery<Image> tq = em.createQuery("SELECT i FROM Image WHERE galerie = :id", Image.class);
		tq.setParameter(1, id);
		return tq.getSingleResult();
	}
	
	@Override
	@Transactional
	public Image save(Image i, File f) {
		Image existing = em.find(Image.class, i.getId());
		if (existing == null) {
			em.persist(i);
			// stockage effectif du fichier
			fileStorageManager.saveFile("img", i.getId(), f);
			return i;
		}
		else {
			existing = em.merge(i);
			fileStorageManager.saveFile("img", existing.getId(), f);
			return existing;
		}
	}
	
	@Override
	public File getFile(Image i) {
		Optional<File> f = fileStorageManager.getFile("Illustration", i.getId());
		if( f.isPresent())
			return f.get();
		else
			return null;
	}
}
