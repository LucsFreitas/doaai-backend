package br.unicap.doaai.doaai.api;

import br.unicap.doaai.doaai.api.resources.Credential;
import br.unicap.doaai.doaai.api.resources.User;
import br.unicap.doaai.doaai.domain.Usuario;
import br.unicap.doaai.doaai.services.UtilidadesServices;
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
    public ResponseEntity<String> login (@RequestBody Credential credential) {

        if (credential != null && !UtilidadesServices.isEmpty(credential.getLogin())
                && !UtilidadesServices.isEmpty(credential.getSenha()) ) {

            Usuario usuario = loginService.login(credential.getLogin(), credential.getSenha());
            if (usuario != null) {
                return ResponseEntity.ok(usuario.getDoador().getId().toString());
            }
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/signup")
    @ApiOperation(value = "Cadastra um novo usuário")
    public ResponseEntity signup (@RequestBody User user) {
        if (user == null){
            return ResponseEntity.badRequest().build();
        }
        loginService.create(user.toEntity());
        return ResponseEntity.noContent().build();
    }
}

