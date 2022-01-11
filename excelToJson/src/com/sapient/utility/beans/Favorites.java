package com.sapient.utility.beans;

import java.util.Set;

public class Favorites {
	
	private Set<Activities> activities;
	private Set<Books> books;
	private Set<Interests> interests;
	private Set<Movies> movies;
	private Set<Music> music;
	private Set<Television> television;
	
	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorites(Set<Activities> activities, Set<Books> books, Set<Interests> interests, Set<Movies> movies,
			Set<Music> music, Set<Television> television) {
		super();
		this.activities = activities;
		this.books = books;
		this.interests = interests;
		this.movies = movies;
		this.music = music;
		this.television = television;
	}

	public Set<Activities> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activities> activities) {
		this.activities = activities;
	}

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}

	public Set<Interests> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interests> interests) {
		this.interests = interests;
	}

	public Set<Movies> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}

	public Set<Music> getMusic() {
		return music;
	}

	public void setMusic(Set<Music> music) {
		this.music = music;
	}

	public Set<Television> getTelevision() {
		return television;
	}

	public void setTelevision(Set<Television> television) {
		this.television = television;
	}
	
	

}
