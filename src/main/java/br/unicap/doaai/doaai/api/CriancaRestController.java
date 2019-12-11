package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.domain.Crianca;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.unicap.doaai.doaai.services.CriancaService;

import java.util.List;

@RestController
@RequestMapping(value = "/crianca")
public class CriancaRestController {

    @Autowired
    private CriancaService criancaService;

    @GetMapping
    @ApiOperation(value = "Busca todas as crianças")
    public ResponseEntity<List<Crianca>> findAll () {
        return ResponseEntity.ok().body(criancaService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca os detalhes de uma criança")
    public ResponseEntity<Crianca> findById (@PathVariable Long id) {
        return ResponseEntity.ok().body(criancaService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Cadastra uma nova criança")
    public ResponseEntity<Crianca> create (@RequestBody Crianca crianca) {
        return ResponseEntity.ok().body(criancaService.create(crianca));
    }
}
