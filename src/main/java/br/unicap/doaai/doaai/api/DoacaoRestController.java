package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.domain.Doacao;
import br.unicap.doaai.doaai.domain.Usuario;
import br.unicap.doaai.doaai.services.DoacaoService;
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
    @ApiOperation(value = "Lista todos as doações pendentes")
    public ResponseEntity<List<Doacao>> findAll() {
        return ResponseEntity.ok().body(doacaoService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca detalhes de uma doação")
    public ResponseEntity<Doacao> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(doacaoService.findById(id));
    }

    @PutMapping
    @ApiOperation(value = "Cria uma nova doação")
    public ResponseEntity<Doacao> create (@RequestBody Doacao doacao) {
        return ResponseEntity.ok().body(doacaoService.create(doacao));
    }

    @PostMapping("/{id}/donate")
    @ApiOperation(value = "Vincula a doação a um doador")
    public ResponseEntity<Doacao> donate (@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario != null) {
            return ResponseEntity.ok().body(doacaoService.donate(id, usuario.getLogin()));
        }

        return ResponseEntity.badRequest().build();
    }
}
