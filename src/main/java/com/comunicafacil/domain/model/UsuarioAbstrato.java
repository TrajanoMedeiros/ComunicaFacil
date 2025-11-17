package com.comunicafacil.domain.model;
import lombok.Data;
@Data
public abstract class UsuarioAbstrato {
private Long id;
private String nome;
private String email;
// Preferencias simples como json ou campos separados
private String preferenciasAcessibilidade; // ex: JSON com velocidade,
corLegenda
}
