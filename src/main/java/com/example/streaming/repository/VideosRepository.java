package com.example.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.streaming.model.Videos;

public interface VideosRepository extends JpaRepository<Videos, Long> {
}