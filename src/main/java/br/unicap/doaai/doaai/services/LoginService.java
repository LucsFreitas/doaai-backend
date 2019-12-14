package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Usuario;

public interface LoginService {

    Usuario login (String login, String senha);

    Usuario create (Usuario usuario);

    Usuario findByLogin (String login);
}
