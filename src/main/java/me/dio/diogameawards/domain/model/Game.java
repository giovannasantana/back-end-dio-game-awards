package me.dio.diogameawards.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "GAMES") // representar a classe como uma tabela no bd
public class Game {
	
	@Id
	// Incrementar de chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Long com L aceita o null
	private String name;
	@Column(length = 500)
	private String description;
	private String cover;
	private long votes; // long l o valor default é 0

	//Getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}


}
