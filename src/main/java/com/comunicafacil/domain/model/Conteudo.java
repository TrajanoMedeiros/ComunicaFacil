package com.comunicafacil.domain.model;
import com.comunicafacil.domain.enums.TipoConteudo;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Conteudo {
private Long id;
private String nomeArquivo;
private TipoConteudo tipo;
private String caminho; // caminho no servidor
private Long usuarioEnvioId;
private LocalDateTime dataUpload;
}
