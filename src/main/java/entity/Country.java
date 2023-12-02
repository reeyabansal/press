package entity;

import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<Article> articles;

    public Country(String name){
        this.name = name;
        articles = new ArrayList<>();
    }

    public void Setarticles(){

    }
    public ArrayList<Article> Getarticles(){
        return this.articles;
    }
}
