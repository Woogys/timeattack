package com.sparta.weeklytest6.service;

import com.sparta.weeklytest6.domain.Memo;
import com.sparta.weeklytest6.dto.MemoDto;
import com.sparta.weeklytest6.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public Memo createMemo(MemoDto memoDto) {
        Memo memo = new Memo(memoDto);
        memoRepository.save(memo);
        return memo;
    }
}
