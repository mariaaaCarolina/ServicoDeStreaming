package com.example.streaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.streaming.model.Videos;
import com.example.streaming.repository.VideosRepository;

@Service
public class VideosService {

    private final VideosRepository videosRepository;

    public VideosService(VideosRepository videoRepository) {
        this.videosRepository = videoRepository;
    }

    public List<Videos> listar() {
        return videosRepository.findAll();
    }

    public Videos salvar(Videos video) {
        return videosRepository.save(video);
    }

    public Optional<Videos> buscarPorId(Long id) {
        return videosRepository.findById(id);
    }

    public void deletar(Long id) {
        videosRepository.deleteById(id);
    }
}
