package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.domain.Crianca;
import br.unicap.doaai.doaai.domain.Doador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.unicap.doaai.doaai.services.DoadorService;

@RestController
@RequestMapping(value = "/doador")
public class DoadorRestController {

    @Autowired
    private DoadorService doadorService;

    @GetMapping("/{id}")
    public ResponseEntity<Doador> findById (@PathVariable Long id) {
        return ResponseEntity.ok().body(doadorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Doador> create (@RequestBody Doador doador) {
        return ResponseEntity.ok().body(doadorService.create(doador));
    }
}
