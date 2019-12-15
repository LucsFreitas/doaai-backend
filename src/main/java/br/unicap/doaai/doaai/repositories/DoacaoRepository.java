package br.unicap.doaai.doaai.repositories;

import br.unicap.doaai.doaai.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}
