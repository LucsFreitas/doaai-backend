package br.unicap.doaai.doaai.repositories;

import br.unicap.doaai.doaai.domain.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {
}