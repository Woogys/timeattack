package com.sparta.weeklytest7.repository;

import com.sparta.weeklytest7.domain.Article;
import com.sparta.weeklytest7.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}