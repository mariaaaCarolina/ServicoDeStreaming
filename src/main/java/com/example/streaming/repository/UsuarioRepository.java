package com.example.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.streaming.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}