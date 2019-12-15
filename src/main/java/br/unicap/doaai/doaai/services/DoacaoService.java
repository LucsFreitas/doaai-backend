package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Doacao;

import java.util.List;

public interface DoacaoService {
    Doacao findById (Long id);

    List<Doacao> findAll ();

    List<Doacao> findPendings();

    List<Doacao> findByDonator(Long doadorId);

    Doacao create (Doacao doacao);

    Doacao donate (Long doacaoId, Long doadorId);
}
