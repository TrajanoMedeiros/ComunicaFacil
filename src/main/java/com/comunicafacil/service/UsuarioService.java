package com.comunicafacil.service;
import com.comunicafacil.domain.model.Cidadao;
import com.comunicafacil.domain.model.UsuarioAbstrato;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class UsuarioService {
private final Map<Long, UsuarioAbstrato> usuarios = new HashMap<>();
private final AtomicLong seq = new AtomicLong(1);
public UsuarioAbstrato salvar(UsuarioAbstrato u) {
if (u.getId() == null) u.setId(seq.getAndIncrement());
usuarios.put(u.getId(), u);
return u;
}
public Optional<UsuarioAbstrato> buscar(Long id) {
return Optional.ofNullable(usuarios.get(id));
}
public List<UsuarioAbstrato> listar() { return new
ArrayList<>(usuarios.values()); }
}