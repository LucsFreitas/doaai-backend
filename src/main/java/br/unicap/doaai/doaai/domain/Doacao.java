package br.unicap.doaai.doaai.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Doacao {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @OneToOne
    private Crianca crianca;

    @ManyToOne
    private Doador doador;

    @Column(columnDefinition="TEXT")
    private String textoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public String getTextoPedido() {
        return textoPedido;
    }

    public void setTextoPedido(String textoPedido) {
        this.textoPedido = textoPedido;
    }
}
