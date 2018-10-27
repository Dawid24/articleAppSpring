package com.paciorek.dawid.articleApp.dao;

import com.paciorek.dawid.articleApp.model.Article;

import java.util.List;

public interface IArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);

    //dodaj
    void addArticle(Article article);

    //update
    void updateArticleById(Article article);

    //delete
    void deleteArticleById(int articleId);

    //isExists
    boolean isExists(String title, String category);
}
