package com.example.streaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.streaming.model.Musicas;
import com.example.streaming.model.Playlist;
import com.example.streaming.model.Usuario;
import com.example.streaming.model.Videos;
import com.example.streaming.repository.MusicasRepository;
import com.example.streaming.repository.PlaylistRepository;
import com.example.streaming.repository.UsuarioRepository;
import com.example.streaming.repository.VideosRepository;

@SpringBootApplication
public class StreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamingApplication.class, args);
    }

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner runner(
            UsuarioRepository usuarioRepo,
            MusicasRepository musicaRepo,
            VideosRepository videoRepo,
            PlaylistRepository playlistRepo
    ) {
        return args -> {
            // Criar Usuário
            Usuario usuario = new Usuario(null, "João Silva", "joao@email.com", new ArrayList<>());
            usuario = usuarioRepo.save(usuario);

            // Criar Músicas
            Musicas musica1 = new Musicas(null, "Música A", "Pop", "https://musica-a.com", new ArrayList<>());
            Musicas musica2 = new Musicas(null, "Música B", "Rock", "https://musica-b.com", new ArrayList<>());
            musica1 = musicaRepo.save(musica1);
            musica2 = musicaRepo.save(musica2);

            // Criar Vídeos
            Videos video1 = new Videos(null, "Vídeo A", "Clipe musical", "https://video-a.com", new ArrayList<>());
            Videos video2 = new Videos(null, "Vídeo B", "Documentário", "https://video-b.com", new ArrayList<>());
            video1 = videoRepo.save(video1);
            video2 = videoRepo.save(video2);

            // Criar Playlist
            List<Musicas> musicas = Arrays.asList(musica1, musica2);
            List<Videos> videos = Arrays.asList(video1, video2);
            Playlist playlist = new Playlist(null, "Minha Playlist", usuario, videos, musicas);
            playlist = playlistRepo.save(playlist);

            // Adicionar playlist ao usuário e salvar
            usuario.getPlaylists().add(playlist);
            usuarioRepo.save(usuario);

            System.out.println("Usuário, músicas, vídeos e playlist criados com sucesso!");
        };
    }
}
