package com.paciorek.dawid.articleApp.service;

import com.paciorek.dawid.articleApp.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);

    //dodaj
    boolean addArticle(Article article);

    //update
    void updateArticleById(Article article);

    //delete
    void deleteArticleById(int articleId);

}
