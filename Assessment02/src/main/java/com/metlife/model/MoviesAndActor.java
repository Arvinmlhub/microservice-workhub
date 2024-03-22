package com.metlife.model;

import lombok.Data;
@Data
public class MoviesAndActor {


    private String moviesName;

    private String actorName;


    private String avaliableLanguage;

    private String moviesCategory;
    public MoviesAndActor(){}
    public MoviesAndActor(String moviesName, String actorName, String avaliableLanguage, String moviesCategory) {
        this.moviesName = moviesName;
        this.actorName = actorName;
        this.avaliableLanguage = avaliableLanguage;
        this.moviesCategory = moviesCategory;
    }

    public String getMoviesName() {
        return moviesName;
    }

    public void setMoviesName(String moviesName) {
        this.moviesName = moviesName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getAvaliableLanguage() {
        return avaliableLanguage;
    }

    public void setAvaliableLanguage(String avaliableLanguage) {
        this.avaliableLanguage = avaliableLanguage;
    }

    public String getMoviesCategory() {
        return moviesCategory;
    }

    public void setMoviesCategory(String moviesCategory) {
        this.moviesCategory = moviesCategory;
    }
}
