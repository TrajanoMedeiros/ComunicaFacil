package com.comunicafacil.controller;
import com.comunicafacil.domain.enums.FormatoSaida;
import com.comunicafacil.domain.model.Solicitacao;
import com.comunicafacil.domain.model.Conversao;
import com.comunicafacil.service.ConteudoService;
import com.comunicafacil.service.ConversaoService;
import com.comunicafacil.service.UsuarioService;
import com.comunicafacil.service.processador.ProcessadorConversaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController {
private final ConversaoService conversaoService;
private final ProcessadorConversaoService processador;
public SolicitacaoController(ConversaoService conversaoService,
ProcessadorConversaoService processador) {
this.conversaoService = conversaoService;
this.processador = processador;
}
@PostMapping("/criar")
public ResponseEntity<String> criar(@RequestBody Solicitacao solicitacao) {
// para cada formato na solicitacao, cria uma conversao e processa
(sincrono neste skeleton)
for (FormatoSaida f : solicitacao.getFormatos()) {
var c = conversaoService.criar(solicitacao.getId(), f);
processador.processar(c.getId());
}
return ResponseEntity.ok("Solicitação criada e conversões iniciadas");
}
@GetMapping("/conversoes/{solicitacaoId}")
public ResponseEntity<List<Conversao>> porSolicitacao(@PathVariable Long
solicitacaoId) {
return
ResponseEntity.ok(conversaoService.listarPorSolicitacao(solicitacaoId));
}
}