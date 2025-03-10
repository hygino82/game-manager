package br.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class RequestConsoleDTO implements Serializable {

    private String name;
    private String company;
    private LocalDate releaseDate;
    private String imageUrl;
}
