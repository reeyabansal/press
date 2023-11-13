package entity;

import DataAccess.NewsAPICaller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private ArrayList<Article> articles;

    public Country(String name){
        this.name = name;
        articles = new ArrayList<>();
    }

    public void Setarticles(){
        NewsAPICaller news = new NewsAPICaller();
        for(int i = 0; i < 5; i++) articles.add(news.createArticle(name, "Country"));
    }
    public ArrayList<Article> Getarticles(){
        return this.articles;
    }
}
