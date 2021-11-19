package com.sparta.weeklytest7.service;

import com.sparta.weeklytest7.domain.Memo;
import com.sparta.weeklytest7.dto.MemoDto;
import com.sparta.weeklytest7.repository.MemoRepository;
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