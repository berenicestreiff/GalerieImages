package org.xstio.ImageManager.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.xstio.ImageManager.metier.Image;
import org.xstio.ImageManager.repositories.GalerieRepository;
import org.xstio.ImageManager.repositories.ImageDAO;
import org.xstio.ImageManager.repositories.ImageRepository;

import com.courtalon.springStrutsJpaExo4Form.metier.Illustration;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport {
	/*@Autowired
	private ImageRepository imageRepository;
	public ImageRepository getImageRepository() {return imageRepository;}
	public void setImageRepository(ImageRepository imageRepository) {this.imageRepository = imageRepository;}
	*/
	ImageDAO imageDAO;
	public ImageDAO getImageDAO() {return imageDAO;}
	public void setImageDAO(ImageDAO imageDAO) {this.imageDAO = imageDAO;}

	/*private GalerieRepository galerieRepository;
	private GalerieRepository getGalerieRepository() {return this.galerieRepository;}
	private void setGalerieRepository(GalerieRepository galerieRepository) {this.galerieRepository = galerieRepository;}
	*/
	
	private List<Image> images;
	public List<Image> getImages() {return images;}
	public void setImages(List<Image> images) {this.images = images;}
	
	private int galId;
	public int getGalId() {return galId;}
	public void setGalId(int galId) {this.galId = galId;}
	private int imageID;
	public int getImageID() {return imageID;}
	public void setImageID(int imageID) {this.imageID = imageID;}
	public String list() {
		images = imageDAO.findAll();
		return SUCCESS;
	}
	
	public String listGalerie() {
		images = imageDAO.findByGalerie(galId);
		return SUCCESS;
	}
	
	public String affiche() {
		Image a = imageDAO.findById(getImageID());
		File f = imageDAO.getFile(a);
		setImageContentType(a.getContentType());
		setImageFileName(a.getFileName());
		try {
			imageStream = new FileInputStream(f);
			return SUCCESS;
		} catch (FileNotFoundException e) {log.error(e);}
		return "error";
	}
}
