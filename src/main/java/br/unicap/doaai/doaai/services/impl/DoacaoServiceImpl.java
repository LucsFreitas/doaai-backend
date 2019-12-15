package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Doacao;
import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.repositories.DoacaoRepository;
import br.unicap.doaai.doaai.services.CriancaService;
import br.unicap.doaai.doaai.services.DoadorService;
import br.unicap.doaai.doaai.services.DoacaoService;
import br.unicap.doaai.doaai.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoServiceImpl implements DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private CriancaService criancaService;

    @Override
    public Doacao findById(Long id) {
        Optional<Doacao> doacao = doacaoRepository.findById(id);
        return doacao.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                id + ", Tipo: " + Doacao.class.getName()));
    }

    @Override
    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    @Override
    public List<Doacao> findPendings() {
        return this.doacaoRepository.findByDoador(null);
    }

    @Override
    public List<Doacao> findByDonator(Long doadorId) {
        Doador doador = new Doador();
        doador.setId(doadorId);

        return this.doacaoRepository.findByDoador(doador);
    }

    @Override
    public Doacao create(Doacao doacao) {
        Doacao p = doacaoRepository.save(doacao);
        return doacaoRepository.findById(p.getId()).orElse(null);
    }

    @Override
    public Doacao donate(Long doacaoId, Long doadorId) {
        Doador doador = doadorService.findById(doadorId);

        if (doador == null) {
            throw  new RuntimeException("Usuario não encontrado.");
        }

        Doacao doacao = this.findById(doacaoId);
        doacao.setDoador(doador);
        return doacaoRepository.save(doacao);
    }
}
