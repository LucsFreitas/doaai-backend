package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Crianca;

import java.util.List;

public interface CriancaService {

    Crianca findById (Long id);

    List<Crianca> findAll ();

    Crianca create (Crianca crianca);
}
