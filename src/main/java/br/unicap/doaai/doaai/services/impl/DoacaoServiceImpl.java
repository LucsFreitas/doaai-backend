package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Doacao;
import br.unicap.doaai.doaai.domain.Usuario;
import br.unicap.doaai.doaai.repositories.DoacaoRepository;
import br.unicap.doaai.doaai.services.CriancaService;
import br.unicap.doaai.doaai.services.LoginService;
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
    private LoginService loginService;

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
    public Doacao create(Doacao doacao) {
        Doacao p = doacaoRepository.save(doacao);
        return doacaoRepository.findById(p.getId()).orElse(null);
    }

    @Override
    public Doacao donate(Long id, String login) {
        Usuario usuario = loginService.findByLogin(login);

        if (usuario == null) {
            throw  new RuntimeException("Usuario não encontrado.");
        }

        Doacao doacao = this.findById(id);
        doacao.setDoador(usuario.getDoador());

        return doacaoRepository.save(doacao);
    }
}
