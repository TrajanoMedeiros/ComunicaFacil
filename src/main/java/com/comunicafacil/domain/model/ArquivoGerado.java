package com.comunicafacil.domain.model;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class ArquivoGerado {
private Long id;
private String caminho;
private String tipo; // ex: audio/mpeg
private LocalDateTime dataGeracao;
}
