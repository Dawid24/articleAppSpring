package com.paciorek.dawid.articleApp.controller;


import com.paciorek.dawid.articleApp.model.Article;
import com.paciorek.dawid.articleApp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    //getArticleById

    @GetMapping("/articles/{id}")
    public Article getArticleById(@PathVariable(value = "id") int articleId) {
        return articleService.getArticleById(articleId);
    }

    //add Article
    @PostMapping("/articles")
    public void addArticle(Article article) {
        articleService.addArticle(article);
    }

    //update Article
        @PutMapping("/articles/{id}")
        public void updateArticleById(@PathVariable(value = "id") int articleId, @Valid @RequestBody Article articleDetails) {
        Article article = articleService.getArticleById(articleId);
        article.setTitle(articleDetails.getTitle());
        article.setCategory(articleDetails.getCategory());
        articleService.updateArticleById(article);
        //return article;
    }

    //delete Article
    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable(value = "id") int articleId) {
        articleService.deleteArticleById(articleId);
    }

}
