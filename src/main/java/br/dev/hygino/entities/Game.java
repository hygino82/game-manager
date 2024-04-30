package br.dev.hygino.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_game")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 3, max = 40)
    private String name;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Integer releaseYear;

    private String personalCode;

    @ManyToOne
    @JoinColumn(name = "console_id")
    @NotNull
    private Console console;

    @Temporal(TemporalType.TIMESTAMP)
    Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    Date updateAt;
}