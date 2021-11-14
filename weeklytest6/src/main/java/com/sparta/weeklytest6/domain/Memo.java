package com.sparta.weeklytest6.domain;

import com.sparta.weeklytest6.dto.MemoDto;
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
@Entity // 테이블임을 나타냅니다.
public class Memo {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    public Memo(MemoDto memoDto) {
        this.content = memoDto.getContent();
    }
}