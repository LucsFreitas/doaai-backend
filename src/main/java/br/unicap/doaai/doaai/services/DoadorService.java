package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Doador;

import java.util.List;

public interface DoadorService {

    Doador findById(Long id);

    Doador create(Doador doador);

    List<Doador> findAll();
}