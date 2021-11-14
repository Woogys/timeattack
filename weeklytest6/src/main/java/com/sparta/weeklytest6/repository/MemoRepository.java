package com.sparta.weeklytest6.repository;

import com.sparta.weeklytest6.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemoRepository extends JpaRepository<Memo, String> {

}