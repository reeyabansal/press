package entity;

import DataAccess.NewsAPICountry;

import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<Article> articles;

    public Country(String name){
        this.name = name;
        articles = new ArrayList<>();
    }

    public void Setarticles(){
        NewsAPICountry news = new NewsAPICountry();
//        Updated create method to get n articles at once to reduce number of api calls; review later.
    }
    public ArrayList<Article> Getarticles(){
        return this.articles;
    }
}
