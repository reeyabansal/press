package entity;

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
        for(int i = 0; i < 5; i++){
            /*To be un commented when article is made*/

            //articles.add(Article.FindArticles(name));
        }
    }
    public ArrayList<Article> Getarticles(){
        return this.articles;
    }
}
