package br.dev.hygino.manager.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_console")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Console {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private String company;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;

	private String imageUrl;
}
