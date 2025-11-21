package com.comunicafacil.service;
import com.comunicafacil.domain.enums.FormatoSaida;
import com.comunicafacil.domain.enums.StatusConversao;
import com.comunicafacil.domain.model.Conversao;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class ConversaoService {
private final Map<Long, Conversao> db = new HashMap<>();
private final AtomicLong seq = new AtomicLong(1);
public Conversao criar(Long solicitacaoId, FormatoSaida formato) {
Conversao c = new Conversao();
c.setId(seq.getAndIncrement());
c.setSolicitacaoId(solicitacaoId);
c.setFormato(formato);
c.setStatus(StatusConversao.PENDENTE);
c.setDataInicio(LocalDateTime.now());
db.put(c.getId(), c);
return c;
}
public void atualizarStatus(Long id, StatusConversao status) {
Conversao c = db.get(id);
if (c != null) {
c.setStatus(status);
if (status == StatusConversao.CONCLUIDO || status ==
StatusConversao.FALHA) {
c.setDataFim(LocalDateTime.now());
}
}
}
public Optional<Conversao> buscar(Long id) { return
Optional.ofNullable(db.get(id)); }
public List<Conversao> listarPorSolicitacao(Long solicitacaoId) {
List<Conversao> out = new ArrayList<>();
for (Conversao c : db.values()) if
(Objects.equals(c.getSolicitacaoId(), solicitacaoId)) out.add(c);
return out;
}
}
