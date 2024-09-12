package br.dev.hygino.manager.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tb_game")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public final class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotBlank
    @Size(min = 3, max = 40)
    private String personalCode;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "console_id")
    @NotNull
    private Console console;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
