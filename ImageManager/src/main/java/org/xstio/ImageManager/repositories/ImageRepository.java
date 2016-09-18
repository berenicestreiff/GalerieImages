package org.xstio.ImageManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.xstio.ImageManager.metier.Image;

public interface ImageRepository extends CrudRepository<Image, Integer> {

}
