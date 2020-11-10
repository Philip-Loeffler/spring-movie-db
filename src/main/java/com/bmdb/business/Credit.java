package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Credit {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="movieID")
	private Movie movie;
	@ManyToOne
	//knows that the primary key of the actor is being joined to the credit table 
	@JoinColumn(name="ActorID")
	private Actor actor; 
	private String role;
	
	
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Credit(int id, Movie movie, Actor actor, String role) {
		super();
		this.id = id;
		this.movie = movie;
		this.actor = actor;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Actor getActor() {
		return actor;
	}


	public void setActor(Actor actor) {
		this.actor = actor;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	
}
