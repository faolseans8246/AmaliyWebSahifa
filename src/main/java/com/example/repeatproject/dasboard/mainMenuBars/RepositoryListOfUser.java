package com.example.repeatproject.dasboard.mainMenuBars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryListOfUser extends JpaRepository<TableListOfUsers, Long>, CrudRepository<TableListOfUsers, Long> {
}
