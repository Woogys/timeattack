package com.sparta.weeklytestspring.service;

import com.sparta.weeklytestspring.domain.Article;
import com.sparta.weeklytestspring.domain.Comment;
import com.sparta.weeklytestspring.domain.Tag;
import com.sparta.weeklytestspring.dto.ArticleCommentRequestDto;
import com.sparta.weeklytestspring.dto.ArticleRequestDto;
import com.sparta.weeklytestspring.repository.ArticleRepository;
import com.sparta.weeklytestspring.repository.CommentRepository;
import com.sparta.weeklytestspring.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;

    @Transactional
    public Article setArticle(ArticleRequestDto articleRequestDto, MultipartFile multipartFile){

        Article article = new Article(articleRequestDto);
        articleRepository.save(article);

        List<String> items = Arrays.asList(articleRequestDto.getTags().split("\\s*,\\s*"));
        List<Tag> tags = items.stream().map(tag -> new Tag(tag, article)).collect(Collectors.toList());
        tagRepository.saveAll(tags);

        if (multipartFile == null) { // 처음 등록할 때 사진 선택하지 않으면 기본 이미지 저장
            article.setPostImage("https://dk9q1cr2zzfmc.cloudfront.net/img/default.jpg");
        } else { // 사진 선택하면 S3에 저장 + DB에 클라우드 프론트 url 저장
            String reviewImgUrl = s3Manager.upload(multipartFile, "reviewImg"); // 클라우드 프론트 url
            article.setPostImage(reviewImgUrl);
        }
       articleRepository.save(article);
        return Article.ok(article);

        return article;
    }

    public Article getArticle(Long id){
        return articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }

    public List<Article> getArticles(String searchTag){
        if(searchTag.isEmpty()){
            return articleRepository.findAll();
        } else {
            return articleRepository.findAllByTagsName(searchTag);
        }
    }

    @Transactional
    public void setArticleComment(ArticleCommentRequestDto articleCommentRequestDto){
        Article article = articleRepository.findById(articleCommentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(articleCommentRequestDto, article);
        commentRepository.save(comment);
    }
}
