package me.dio.diogameawards.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.diogameawards.domain.model.Game;
import me.dio.diogameawards.domain.model.GameRepository;
import me.dio.diogameawards.service.GameService;
import me.dio.diogameawards.service.exception.BusinessException;
import me.dio.diogameawards.service.exception.NoContentExeption;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired // Da acesso ao repository que foi definido, instanciando
	private GameRepository repository;
	
	@Override
	public List<Game> findAll() {
		List<Game> games = repository.findAll();
		return games;
	}

	@Override
	public Game findById(Long id) {
		Optional<Game> game = repository.findById(id);
		return game.orElseThrow(() -> new NoContentExeption()); // tratando a excessão sem o if e else
	}

	@Override
	public void insert(Game game) {
		repository.save(game);
	}

	@Override
	public void update(Long id, Game game) {
		Game gameDb = findById(id);
		if(gameDb.getId().equals(game.getId())) {
			repository.save(game);
		}else {
			throw new BusinessException("Os Id's para alteração são diferentes");
		}
	}

	@Override
	public void delete(Long id) {
		Game gameDb = findById(id);
		repository.delete(gameDb);
		//Geralmente inativa o dado e não o exclui de verdade
		
	}
	
}
