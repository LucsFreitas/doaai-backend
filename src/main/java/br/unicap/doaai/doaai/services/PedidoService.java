package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido findById (Long id);

    List<Pedido> findAll ();

    Pedido create (Pedido pedido);

    Pedido donate (Long id,  String login);
}
