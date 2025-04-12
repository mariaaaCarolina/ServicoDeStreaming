package com.example.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.streaming.model.Musicas;

public interface MusicasRepository extends JpaRepository<Musicas, Long> {
}
