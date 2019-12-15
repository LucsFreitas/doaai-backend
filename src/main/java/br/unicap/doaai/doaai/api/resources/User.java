package br.unicap.doaai.doaai.api.resources;

import br.unicap.doaai.doaai.domain.Doador;
import br.unicap.doaai.doaai.domain.Usuario;

public class User {
    private String login;

    private String senha;

    private String nome;

    private Integer idade;

    private String bairro;

    private String cpf;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario toEntity() {
        Doador doador = new Doador();
        doador.setNome(this.nome);
        doador.setIdade(this.idade);
        doador.setCpf(this.cpf);
        doador.setBairro(this.bairro);

        Usuario usuario = new Usuario();
        usuario.setLogin(this.login);
        usuario.setSenha(this.senha);
        usuario.setDoador(doador);

        return usuario;
    }
}
