package com.gilberto.capsula_do_tempo.service;

import com.gilberto.capsula_do_tempo.dto.NovaCapsulaDTO;
import com.gilberto.capsula_do_tempo.models.Capsula;
import com.gilberto.capsula_do_tempo.repository.CapsulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CapsulaService {
    private final CapsulaRepository repository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public Capsula salvarCapsula(NovaCapsulaDTO dto) throws IOException {
        String caminhoImagem = salvarImagem(dto.imagem());

        Capsula capsula = Capsula.builder()
                .nome(dto.nome())
                .email(dto.email())
                .mensagem(dto.mensagem())
                .dataEntrega(dto.dataEntrega())
                .caminhoImagem(caminhoImagem)
                .dataCriacao(LocalDateTime.now())
                .entregue(false)
                .build();

        return  repository.save(capsula);
    }

    private String salvarImagem(MultipartFile imagem) throws IOException {
        if (imagem.isEmpty()) return null;

        String nomeUnico = UUID.randomUUID() + "_" + imagem.getOriginalFilename();
        Path destino = Paths.get(uploadDir).resolve(nomeUnico);
        Files.createDirectories(destino.getParent());
        imagem.transferTo(destino.toFile());

        return destino.toString();
    }
}
