package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.api.resources.Credential;
import br.unicap.doaai.doaai.domain.Doacao;
import br.unicap.doaai.doaai.services.DoacaoService;
import br.unicap.doaai.doaai.services.UtilidadesServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doacao")
public class DoacaoRestController {

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping
    @ApiOperation(value = "Lista todos as doações")
    public ResponseEntity<List<Doacao>> findAll(@RequestParam(value="doadorId", required=false) Long doadorId) {
        if (doadorId != null) {
            return getDonationsByDoador(doadorId);
        }
        return ResponseEntity.ok().body(doacaoService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca detalhes de uma doação")
    public ResponseEntity<Doacao> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(doacaoService.findById(id));
    }

    @GetMapping("/pendentes")
    @ApiOperation(value = "Busca todas as doações pendentes")
    public ResponseEntity<List<Doacao>> findPendingDonations() {
        return ResponseEntity.ok().body(doacaoService.findPendings());
    }

    @PutMapping
    @ApiOperation(value = "Cria uma nova doação")
    public ResponseEntity<Doacao> create (@RequestBody Doacao doacao) {
        return ResponseEntity.ok().body(doacaoService.create(doacao));
    }

    @PostMapping("/{doacaoId}/doar")
    @ApiOperation(value = "Vincula a doação a um doador")
    public ResponseEntity<Doacao> donate (@PathVariable Long doacaoId, @RequestBody Credential credential) {
        if (credential != null) {
            return ResponseEntity.ok().body(doacaoService.donate(doacaoId, credential.getDoadorId()));
        }

        return ResponseEntity.badRequest().build();
    }

    private ResponseEntity<List<Doacao>> getDonationsByDoador(Long doadorId) {
        if (doadorId == null){
            throw new RuntimeException("Doador inválido");
        }
        List<Doacao> lista = doacaoService.findByDonator(doadorId);
        return ResponseEntity.ok().body(lista);
    }
}
