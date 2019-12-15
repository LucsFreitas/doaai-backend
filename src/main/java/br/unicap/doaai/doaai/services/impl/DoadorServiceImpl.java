package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Doador;
import org.springframework.beans.factory.annotation.Autowired;
import br.unicap.doaai.doaai.repositories.DoadorRepository;
import br.unicap.doaai.doaai.services.DoadorService;
import br.unicap.doaai.doaai.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorServiceImpl implements DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    @Override
    public Doador findById(Long id) {
        Optional<Doador> doador = doadorRepository.findById(id);
        return doador.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                id + ", Tipo: " + Doador.class.getName()));
    }

    @Override
    public List<Doador> findAll() {
        return doadorRepository.findAll();
    }

    @Override
    public Doador create(Doador doador) {
        return doadorRepository.save(doador);
    }
}
