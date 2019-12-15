package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.domain.Doador;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.unicap.doaai.doaai.services.DoadorService;

import java.util.List;

@RestController
@RequestMapping(value = "/doador")
public class DoadorRestController {

    @Autowired
    private DoadorService doadorService;

    @GetMapping()
    @ApiOperation(value = "Busca todos os doadores")
    public ResponseEntity<List<Doador>> findAll () {
        return ResponseEntity.ok().body(doadorService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca detalhes de um doador")
    public ResponseEntity<Doador> findById (@PathVariable Long id) {
        return ResponseEntity.ok().body(doadorService.findById(id));
    }

    @PutMapping
    @ApiOperation(value = "Cadastra um novo doador")
    public ResponseEntity<Doador> create (@RequestBody Doador doador) {
        return ResponseEntity.ok().body(doadorService.create(doador));
    }
}
