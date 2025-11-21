package com.comunicafacil.service;
import com.comunicafacil.domain.model.Conteudo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class ConteudoService {
private final Map<Long, Conteudo> db = new HashMap<>();
private final AtomicLong seq = new AtomicLong(1);
public Conteudo salvar(Conteudo c) {
if (c.getId() == null) c.setId(seq.getAndIncrement());
c.setDataUpload(LocalDateTime.now());
db.put(c.getId(), c);
return c;
}
public Optional<Conteudo> buscar(Long id) { return
Optional.ofNullable(db.get(id)); }
public List<Conteudo> listar() { return new ArrayList<>(db.values()); }
}
