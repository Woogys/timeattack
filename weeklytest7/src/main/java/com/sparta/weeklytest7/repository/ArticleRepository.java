package com.sparta.weeklytest7.repository;

import com.sparta.weeklytest7.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}