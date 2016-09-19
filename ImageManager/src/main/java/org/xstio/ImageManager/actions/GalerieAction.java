package org.xstio.ImageManager.actions;

import java.util.List;

import org.xstio.ImageManager.metier.Galerie;
import org.xstio.ImageManager.repositories.GalerieDAO;

import com.opensymphony.xwork2.ActionSupport;

public class GalerieAction extends ActionSupport {
	private GalerieDAO galerieDAO;
	public GalerieDAO getGalerieDAO() {return galerieDAO;}
	public void setGalerieDAO(GalerieDAO galerieDAO) {this.galerieDAO = galerieDAO;}
	
	List<Galerie> galeries;
	public List<Galerie> getGaleries() {return galeries;}
	public void setGaleries(List<Galerie> galeries) {this.galeries = galeries;}
	
	public String list() {
		galeries = galerieDAO.findAll();
		
		return SUCCESS;
	}
}
