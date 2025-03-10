package br.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Console")
@Table(name = "Console")
public class Console implements Serializable {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String company;
    private LocalDate releaseDate;
    private String imageUrl;
}
