package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.api.resources.Credential;
import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.unicap.doaai.doaai.services.LoginService;

@RestController
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Doador> login (@RequestBody Credential credential) {

        if (credential != null && credential.getLogin() != null) {
            Usuario usuario = loginService.login(credential.getLogin(), credential.getSenha());

            if (usuario != null) {
                return ResponseEntity.ok(usuario.getDoador());
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Doador> signup (@RequestBody Usuario user) {

        if (user == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(loginService.create(user));
    }
}

