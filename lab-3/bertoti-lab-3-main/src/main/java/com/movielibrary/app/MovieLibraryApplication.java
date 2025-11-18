package com.movielibrary.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class MovieLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieLibraryApplication.class, args);
	}

}

@CrossOrigin(origins = {"http://localhost:8080","http://127.0.0.1:5500"})
@RestController
@RequestMapping("/movies")
class MovieController {
	private List<Movie> movies = new ArrayList<>();

	public MovieController() {
		movies.addAll(List.of(
				new Movie("O Poderoso Chefão", "Drama", 1972, 5),
				new Movie("Matrix", "Ficção Científica", 1999, 5),
				new Movie("Interestelar", "Ficção Científica", 2014, 4),
				new Movie("Cidade de Deus", "Drama", 2002, 5)
		));
	}

	@GetMapping
	Iterable<Movie> getMovies() {
		return movies;
	}

	@GetMapping("/{id}")
	Optional<Movie> getMovieById(@PathVariable String id) {
		for (Movie m: movies) {
			if (m.getId().equals(id)) {
				return Optional.of(m);
			}
		}
		return Optional.empty();
	}

	@PostMapping
	Movie createMovie(@RequestBody Movie movie) {
		movies.add(movie);
		return movie;
	}

	@PutMapping("/{id}")
	ResponseEntity<Movie> updateMovie(@PathVariable String id,
									  @RequestBody Movie movie) {
		int movieIndex = -1;

		for (Movie m: movies) {
			if (m.getId().equals(id)) {
				movieIndex = movies.indexOf(m);
				movies.set(movieIndex, movie);
			}
		}

		return (movieIndex == -1) ?
				new ResponseEntity<>(createMovie(movie), HttpStatus.CREATED) :
				new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteMovie(@PathVariable String id) {
		movies.removeIf(m -> m.getId().equals(id));
	}
}

class Movie {
	private final String id;
	private String title;
	private String genre;
	private int year;
	private int rating;

	public Movie(String id, String title, String genre, int year, int rating) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.rating = rating;
	}

	public Movie(String title, String genre, int year, int rating) {
		this(UUID.randomUUID().toString(), title, genre, year, rating);
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}