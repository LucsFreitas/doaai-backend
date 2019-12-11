package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Crianca;
import org.springframework.beans.factory.annotation.Autowired;
import br.unicap.doaai.doaai.repositories.CriancaRepository;
import br.unicap.doaai.doaai.services.CriancaService;
import br.unicap.doaai.doaai.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriancaServiceImpl implements CriancaService {

    @Autowired
    private CriancaRepository criancaRepository;

    @Override
    public Crianca findById(Long id) {
        Optional<Crianca> crianca = criancaRepository.findById(id);
        return crianca.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                id + ", Tipo: " + Crianca.class.getName()));
    }

    @Override
    public List<Crianca> findAll() {
        return criancaRepository.findAll();
    }

    @Override
    public Crianca create(Crianca crianca) {
        return criancaRepository.save(crianca);
    }
}
