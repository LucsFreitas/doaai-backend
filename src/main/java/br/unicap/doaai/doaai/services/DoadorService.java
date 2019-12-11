package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Doador;

public interface DoadorService {

    Doador findById(Long id);

    Doador create(Doador doador);
}