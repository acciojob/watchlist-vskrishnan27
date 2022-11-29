package com.driver;

public class Movie {
    private String name;
    private int durationinMinutes;
    private double imdbRating;

    public Movie() {
    }

    public Movie(String name, int durationinMinutes, double imdbRating) {
        this.name = name;
        this.durationinMinutes = durationinMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationinMinutes() {
        return durationinMinutes;
    }

    public void setDurationinMinutes(int durationinMinutes) {
        this.durationinMinutes = durationinMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

}
