package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MovieRepository {

    Map<Movie, String> listOfMovies = new HashMap<>();
    Map<Director, List<Movie>> directorMovieList = new HashMap<>();

    public void addMovieToDB(Movie movie) {
        listOfMovies.put(movie, null);
    }

    public void addDirectorToDB(Director director) {
        directorMovieList.put(director, new ArrayList<>());
    }

    public void pairMovieAndDirector(String movieName, String directorName) {
        for (Movie x : listOfMovies.keySet()) {
            if (x.getName().equals(movieName)) {
                listOfMovies.put(x, directorName);
                return;
            }
        }
    }

    public Movie findByMovieName(String movieName) {
        for (Movie x : listOfMovies.keySet()) {
            if (x.getName().equals(movieName)) {
                return x;
            }
        }
        return new Movie();
    }

    public Director findByDirectorName(String directorName) {
        for (Director x : directorMovieList.keySet()) {
            if (x.getName().equals(directorName)) {
                return x;
            }
        }
        return new Director();
    }

    public List<String> getAllMoviesOfDirector(String directorName) {
        List<String> movieList = new ArrayList<>();
        for (Movie x : listOfMovies.keySet()) {
            if (listOfMovies.get(x).equals(directorName))
                movieList.add(x.getName());
        }
        return movieList;
    }

    public List<String> getAllMovies() {
        List<String> movieList = new ArrayList<>();
        for (Movie x : listOfMovies.keySet()) {
            movieList.add(x.getName());
        }
        return movieList;
    }

    public void deleteDirectorAndItsMoviesFromDB(String directorName) {
        for (Director x : directorMovieList.keySet()) {
            if (x.getName().equals(directorName)) {
                for (Movie movie : directorMovieList.get(x)) {
                    directorMovieList.remove(movie);
                }
                return;
            }
        }
    }

    public void DeleteAllDirectorRecordFromDB() {
        for (Director x : directorMovieList.keySet()) {
            for (Movie movie : directorMovieList.get(x)) {
                listOfMovies.remove(movie);
            }
        }
    }

}
