package com.sparta.weeklytest6.domain;

import com.sparta.weeklytest6.dto.Test6RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity // 테이블임을 나타냅니다.
public class Test6 extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.

    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String user;

    @Column(nullable = false)
    private String contents;

    public Test6(String user, String contents) {
        this.user = user;
        this.contents = contents;
    }

    public Test6(Test6RequestDto requestDto) {
        this.user = requestDto.getUser();
        this.contents = requestDto.getContents();
    }

    public void update(Test6RequestDto requestDto){
        this.user = requestDto.getUser();
        this.contents = requestDto.getContents();
    }
}