package com.paciorek.dawid.articleApp.service;

import com.paciorek.dawid.articleApp.dao.IArticleDAO;
import com.paciorek.dawid.articleApp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDAO iArticleDAO;

    @Override
    public List<Article> getAllArticles() {
        return iArticleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public boolean addArticle(Article article) {
        if (iArticleDAO.isExists(article.getTitle(), article.getCatecory())) {
            return false;
        } else {
            iArticleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticleById(Article article) {
        iArticleDAO.updateArticleById(article);
    }

    @Override
    public void deleteArticleById(int articleId) {
        iArticleDAO.deleteArticleById(articleId);
    }
}
