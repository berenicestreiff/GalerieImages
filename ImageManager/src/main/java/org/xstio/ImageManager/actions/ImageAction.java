package org.xstio.ImageManager.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.xstio.ImageManager.metier.Image;
import org.xstio.ImageManager.repositories.GalerieRepository;
import org.xstio.ImageManager.repositories.ImageDAO;
import org.xstio.ImageManager.repositories.ImageRepository;

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

	private File image; // le fichier temporaire uploadé
	private String imageContentType; // type du fichier uploadé
	private String imageFileName; // le nom du fichier original
	
	public void setImage(File image) {this.image = image;}
	public void setImageContentType(String imageContentType) {this.imageContentType = imageContentType;}
	public void setImageFileName(String imageFileName) {this.imageFileName = imageFileName;}
	public String getImageContentType() {return imageContentType;}
	public String getImageFileName() {return imageFileName;}
	private InputStream imageStream;
	public InputStream getImageStream() {
		return imageStream;
	}
	private String description;
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
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
		images = imageDAO.findByGalerie(getGalId());
		return SUCCESS;
	}

	public String edit() {
		return SUCCESS;
	}

	public String save() {
		System.out.println("nom image uploadée = " + imageFileName);
		System.out.println("content type image uploadée = " + imageContentType);
		System.out.println("chemin du fichier temporaire uplaodé = " + image.getAbsolutePath()
		+ " " + image.getName());
		imageDAO.save(new Image(0, "image", getDescription(), new Date(), imageFileName, imageContentType), image);
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
		} catch (FileNotFoundException e) {System.out.println(e);;}
		return "error";
	}
}
