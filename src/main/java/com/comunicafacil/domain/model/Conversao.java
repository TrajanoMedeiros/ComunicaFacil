package com.comunicafacil.domain.model;
import com.comunicafacil.domain.enums.FormatoSaida;
import com.comunicafacil.domain.enums.StatusConversao;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Conversao {
private Long id;
private Long solicitacaoId;
private FormatoSaida formato;
private StatusConversao status;
private String motivoFalha;
private Long arquivoGeradoId;
private LocalDateTime dataInicio;
private LocalDateTime dataFim;
}
