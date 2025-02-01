package br.dev.hygino.dto;

import br.dev.hygino.entities.Console;
import br.dev.hygino.enums.Regiao;
import br.dev.hygino.enums.TipoControle;

public record ResponseConsoleDTO( 
     Long id,
     String nome,
     Integer anoLancamento,
     boolean fullHd,
     Regiao regiao,
     TipoControle tipoControle) {

          public ResponseConsoleDTO(Console entity){
               this(
                    entity.getId(), 
                    entity.getNome(),
                    entity.getAnoLancamento(), 
                    entity.isFullHd(), 
                    entity.getRegiao(), 
                    entity.getTipoControle()
               );
          }
}
