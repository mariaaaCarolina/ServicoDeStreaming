package com.example.streaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.streaming.model.Musicas;
import com.example.streaming.repository.MusicasRepository;

@Service
public class MusicasService {

    private final MusicasRepository musicasRepository;

    public MusicasService(MusicasRepository musicaRepository) {
        this.musicasRepository = musicaRepository;
    }

    public List<Musicas> listar() {
        return musicasRepository.findAll();
    }

    public Musicas salvar(Musicas musica) {
        return musicasRepository.save(musica);
    }

    public Optional<Musicas> buscarPorId(Long id) {
        return musicasRepository.findById(id);
    }

    public void deletar(Long id) {
        musicasRepository.deleteById(id);
    }
}
