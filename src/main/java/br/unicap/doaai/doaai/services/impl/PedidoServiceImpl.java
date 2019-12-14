package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Pedido;
import br.unicap.doaai.doaai.domain.Usuario;
import br.unicap.doaai.doaai.repositories.PedidoRepository;
import br.unicap.doaai.doaai.repositories.UsuarioRepository;
import br.unicap.doaai.doaai.services.CriancaService;
import br.unicap.doaai.doaai.services.LoginService;
import br.unicap.doaai.doaai.services.PedidoService;
import br.unicap.doaai.doaai.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CriancaService criancaService;

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                id + ", Tipo: " + Pedido.class.getName()));
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido create(Pedido pedido) {
        Pedido p = pedidoRepository.save(pedido);
        return pedidoRepository.findById(p.getId()).orElse(null);
    }

    @Override
    public Pedido donate(Long id, String login) {
        Usuario usuario = loginService.findByLogin(login);

        if (usuario == null) {
            throw  new RuntimeException("Usuario não encontrado.");
        }

        Pedido pedido = this.findById(id);
        pedido.setDoador(usuario.getDoador());

        return pedidoRepository.save(pedido);
    }
}
