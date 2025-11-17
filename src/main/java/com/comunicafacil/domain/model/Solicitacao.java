package com.comunicafacil.domain.model;
import com.comunicafacil.domain.enums.FormatoSaida;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class Solicitacao {
private Long id;
private Long conteudoId;
private Long usuarioId;
private LocalDateTime dataSolicitacao;
private List<FormatoSaida> formatos;
}
