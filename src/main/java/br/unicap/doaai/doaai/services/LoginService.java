package br.unicap.doaai.doaai.services;

import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Usuario;

public interface LoginService {

    Usuario login (String login, String senha);

    Usuario create (Usuario usuario);

    Usuario findByLogin (String login);

    Doador findDonatorByLogin(String login);
}
