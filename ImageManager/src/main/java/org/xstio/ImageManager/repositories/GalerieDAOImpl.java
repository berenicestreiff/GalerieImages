package org.xstio.ImageManager.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.xstio.ImageManager.metier.Galerie;

public class GalerieDAOImpl implements GalerieDAO {
	@PersistenceContext
	EntityManager em;
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	
	@Override
	public List<Galerie> findAll() {
		return em.createQuery("FROM Galerie", Galerie.class).getResultList();
	}

	@Override
	public Galerie findById(int id) {
		TypedQuery<Galerie> tq = em.createQuery("SELECT g FROM Galerie AS g WHERE g.id = :id", Galerie.class);
		tq.setParameter("id", id);
		return tq.getSingleResult();
	}

}
