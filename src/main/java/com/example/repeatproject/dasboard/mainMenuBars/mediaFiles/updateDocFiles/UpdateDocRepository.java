package com.example.repeatproject.dasboard.mainMenuBars.mediaFiles.updateDocFiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UpdateDocRepository extends JpaRepository<TableUpdateDocFiles, Long>, CrudRepository<TableUpdateDocFiles, Long> {
}
