package com.sparta.weeklytest7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ArticleRequestDto {
    private String title;
    private String content;
}