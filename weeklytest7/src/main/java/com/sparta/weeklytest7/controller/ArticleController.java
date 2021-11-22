package com.sparta.weeklytest7.controller;

import com.sparta.weeklytest7.domain.Article;
import com.sparta.weeklytest7.dto.ArticleCommentRequestDto;
import com.sparta.weeklytest7.dto.ArticleRequestDto;
import com.sparta.weeklytest7.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public Article setArticle(@RequestBody ArticleRequestDto articleRequestDto){
        return articleService.setArticle(articleRequestDto);
    }

    @GetMapping("/articles")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }


    @PostMapping("/article/comment")
    public void  setArticleComment(@RequestBody ArticleCommentRequestDto articleCommentRequestDto){
        articleService.setArticleComment(articleCommentRequestDto);
    }
}
