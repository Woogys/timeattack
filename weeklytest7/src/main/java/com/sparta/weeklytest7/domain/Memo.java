package com.sparta.weeklytest7.domain;

import com.sparta.weeklytest7.dto.MemoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Memo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    public Memo(MemoDto memoDto) {
        this.content = memoDto.getContent();
    }
}
