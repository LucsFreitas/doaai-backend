package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Doacao;

import java.util.List;

public interface DoacaoService {
    Doacao findById (Long id);

    List<Doacao> findAll ();

    Doacao create (Doacao doacao);

    Doacao donate (Long id, String login);
}
