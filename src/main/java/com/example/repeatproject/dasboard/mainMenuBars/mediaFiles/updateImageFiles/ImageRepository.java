package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateImageFiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<TableImage, Long>, CrudRepository<TableImage, Long> {
}
