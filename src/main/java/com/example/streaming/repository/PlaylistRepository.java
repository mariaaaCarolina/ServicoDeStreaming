package com.example.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.streaming.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
