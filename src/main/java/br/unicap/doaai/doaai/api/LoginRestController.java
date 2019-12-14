package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.api.resources.Credential;
import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Usuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.unicap.doaai.doaai.services.LoginService;

@RestController
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "Realiza o login do usuário")
    public ResponseEntity<Usuario> login (@RequestBody Credential credential) {

        if (credential != null && credential.getLogin() != null) {
            Usuario usuario = loginService.login(credential.getLogin(), credential.getSenha());

            if (usuario != null) {
                usuario.setSenha(null);
                usuario.setId(null);
                return ResponseEntity.ok(usuario);
            }
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/signup")
    @ApiOperation(value = "Cadastra um novo usuário")
    public ResponseEntity<Credential> signup (@RequestBody Usuario user) {

        if (user == null){
            return ResponseEntity.badRequest().build();
        }
        Usuario u = loginService.create(user);
        Credential credential = new Credential();
        credential.setLogin(u.getLogin());
        return ResponseEntity.ok(credential);
    }
}

