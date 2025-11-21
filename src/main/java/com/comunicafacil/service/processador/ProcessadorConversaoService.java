package com.comunicafacil.service.processador;
import com.comunicafacil.domain.enums.FormatoSaida;
import com.comunicafacil.domain.enums.StatusConversao;
import com.comunicafacil.service.ConversaoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class ProcessadorConversaoService {
private final ConversaoService conversaoService;
public ProcessadorConversaoService(ConversaoService conversaoService) {
this.conversaoService = conversaoService;
}
// Método que simula o processamento (bloqueante aqui para simplicidade)
public void processar(Long conversaoId) {
conversaoService.atualizarStatus(conversaoId,
StatusConversao.PROCESSANDO);
try {
// Simula tempo de processamento
Thread.sleep(800);
// Resultado: para demo, AUDIO e LEGENDA sempre concluem, LIBRAS às
vezes falha
// Busca conversao para checar formato
var opt = conversaoService.buscar(conversaoId);
if (opt.isPresent()) {
var c = opt.get();
if (c.getFormato() == FormatoSaida.LIBRAS) {
// simular falha 30%
if (Math.random() < 0.3) {
c.setMotivoFalha("Avatar não encontrado");
conversaoService.atualizarStatus(conversaoId,
StatusConversao.FALHA);
return;
}
}
// sucesso
conversaoService.atualizarStatus(conversaoId,
StatusConversao.CONCLUIDO);
}
} catch (InterruptedException e) {
conversaoService.atualizarStatus(conversaoId,
StatusConversao.FALHA);
}
}
}