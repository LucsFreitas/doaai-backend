package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.domain.Crianca;
import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Pedido;
import br.unicap.doaai.doaai.domain.Usuario;
import br.unicap.doaai.doaai.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> create (@RequestBody Pedido pedido) {
        return ResponseEntity.ok().body(pedidoService.create(pedido));
    }

    @PostMapping("/{id}/donate")
    public ResponseEntity<Pedido> donate (@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario != null) {
            return ResponseEntity.ok().body(pedidoService.donate(id, usuario.getLogin()));
        }

        return ResponseEntity.badRequest().build();
    }
}
