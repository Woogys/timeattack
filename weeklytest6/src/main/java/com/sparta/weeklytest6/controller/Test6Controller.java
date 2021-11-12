package com.sparta.weeklytest6.controller;

import com.sparta.weeklytest6.domain.Test6;
import com.sparta.weeklytest6.domain.Test6Repository;
import com.sparta.weeklytest6.dto.Test6RequestDto;
import com.sparta.weeklytest6.service.Test6Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Test6Controller {
    private final Test6Repository test6Repository;
    private final Test6Service test6Service;

    @GetMapping("/api/memos")
    public List<Test6> getMemos() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return test6Repository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PostMapping("/api/memos")
    public Test6 createMemo(@RequestBody Test6RequestDto requestDto) {
        Test6 memo = new Test6(requestDto);
        return Test6Repository.save(memo);
    }

}
}
