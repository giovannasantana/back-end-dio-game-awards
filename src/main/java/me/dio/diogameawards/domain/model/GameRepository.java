package me.dio.diogameawards.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	// Interface de acesso ao banco de dados
	// Consigo fazer todas as opeacoes do banco

}
