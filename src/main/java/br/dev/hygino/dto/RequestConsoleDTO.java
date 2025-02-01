package br.dev.hygino.dto;

import br.dev.hygino.enums.Regiao;
import br.dev.hygino.enums.TipoControle;

public record RequestConsoleDTO( 
     String nome,
     Integer anoLancamento,
     boolean fullHd,
     Regiao regiao,
     TipoControle tipoControle) {
    
}
