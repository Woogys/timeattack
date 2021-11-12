package com.sparta.weeklytest6.service;

import com.sparta.weeklytest6.domain.Test6;
import com.sparta.weeklytest6.domain.Test6Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class Test6Service {
    private final Test6Repository test6Repository;

    @Transactional
    public Long update(Long id, Test6RequestDto requestDto) {
        Test6 test6 = test6Repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")

        );
        test6.update(requestDto);
        return test6.getId();
    }
}
