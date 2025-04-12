package com.example.streaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.streaming.model.Playlist;
import com.example.streaming.repository.PlaylistRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> listar() {
        return playlistRepository.findAll();
    }

    public Playlist salvar(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Optional<Playlist> buscarPorId(Long id) {
        return playlistRepository.findById(id);
    }

    public void deletar(Long id) {
        playlistRepository.deleteById(id);
    }
}
