package com.example.Clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Clinica.clases.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
}