package org.xstio.ImageManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.xstio.ImageManager.metier.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {

}
