package br.unicap.doaai.doaai.repositories;

import br.unicap.doaai.doaai.domain.Doacao;
import br.unicap.doaai.doaai.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    List<Doacao> findByDoador (Doador doador);
}
