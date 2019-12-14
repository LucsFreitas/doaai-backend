package br.unicap.doaai.doaai.services.impl;

import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import br.unicap.doaai.doaai.repositories.UsuarioRepository;
import br.unicap.doaai.doaai.services.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario login(String login, String senha) {
        Usuario user = usuarioRepository.findByLogin(login)
                .orElse(null);

        return  user != null && user.getSenha().equals(senha) ? user : null;
    }

    @Override
    public Usuario create(Usuario usuario) {
        Usuario existente = findByLogin(usuario.getLogin());

        if (existente != null) {
            throw  new RuntimeException("Login já utilizado");
        }

        if (usuario.getLogin() == null || usuario.getSenha() == null || usuario.getDoador() == null) {
            throw  new RuntimeException("O Login, Senha e o Doador devem ser informados.");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login).orElse(null);
    }
}
