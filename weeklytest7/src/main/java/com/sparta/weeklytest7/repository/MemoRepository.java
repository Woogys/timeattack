package com.sparta.weeklytest7.repository;

import com.sparta.weeklytest7.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, String> {

}