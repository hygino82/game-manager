package br.dev.hygino.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.dev.hygino.dto.GameDTO;
import br.dev.hygino.dto.GameInsertDTO;
import jakarta.validation.Valid;

public interface GameService {

	Page<GameDTO>  findAll(Pageable pageable);

	ResponseEntity<?> insert(@Valid GameInsertDTO dto);
}
