package com.geekbrains.spring2.persist.repo;

import com.geekbrains.spring2.persist.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
