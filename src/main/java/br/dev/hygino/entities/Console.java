package br.dev.hygino.entities;

import java.io.Serializable;

import br.dev.hygino.enums.Regiao;
import br.dev.hygino.enums.TipoControle;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_console")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Console implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer anoLancamento;

    private boolean fullHd;

    private Regiao regiao;

    private TipoControle tipoControle;
}