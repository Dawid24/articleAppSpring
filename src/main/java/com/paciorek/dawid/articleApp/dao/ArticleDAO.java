package com.paciorek.dawid.articleApp.dao;

import com.paciorek.dawid.articleApp.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        String hg1 = "FROM Article as atc1 ORDER BY atc1.articleId";

        return entityManager.createQuery(hg1).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticleById(Article article) {
        Article artc1 = getArticleById(article.getArticleId());
        artc1.setTitle(article.getTitle());
        artc1.setCatecory(article.getCatecory());
    }

    @Override
    public void deleteArticleById(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean isExists(String title, String category) {

        String hg1 = "FROM Article as atc1 WHERE atc1.title = ? and atc1.category = ?";
        int count = entityManager.createQuery(hg1).setParameter(1, "title")
                .setParameter(2, category).getResultList().size();

        //0 to false
        // 0< true wieksze niz 0
        return count > 0 ? true : false;
    }
}
