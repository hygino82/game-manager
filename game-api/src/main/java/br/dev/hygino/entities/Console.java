package br.dev.hygino.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.dev.hygino.dto.ConsoleInsertDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_console")
public class Console implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@NotBlank
	@Size(max = 100, min = 3)
	private String name;

	@NotNull
	Short releaseYear;

	private String imgUrl;

	private Instant createdAt;
	private Instant updatedAt;

	@OneToMany(mappedBy = "console")
	private List<Game> games = new ArrayList<>();

	public Console() {
	}

	public Console(ConsoleInsertDTO dto) {
		name = dto.name();
		releaseYear = dto.releaseYear();
		createdAt = Instant.now();
		imgUrl = dto.imgUrl();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Game> getGames() {
		return games;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Console other = (Console) obj;
		return Objects.equals(id, other.id);
	}
}
