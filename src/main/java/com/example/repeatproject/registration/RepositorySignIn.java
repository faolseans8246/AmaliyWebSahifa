package com.example.repeatproject.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySignIn extends JpaRepository<TableSignIn, Long>, CrudRepository<TableSignIn, Long> {
}
