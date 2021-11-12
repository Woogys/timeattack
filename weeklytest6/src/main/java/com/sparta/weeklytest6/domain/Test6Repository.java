package com.sparta.weeklytest6.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface Test6Repository extends JpaRepository<Test6, Long> {
    List<Test6> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime modifiedAt, LocalDateTime modifiedAt2);
}