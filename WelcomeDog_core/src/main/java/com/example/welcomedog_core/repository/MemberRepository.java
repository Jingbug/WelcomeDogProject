package com.example.welcomedog_core.repository;


import com.example.welcomedog_core.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 회원 아이디로 정보 조회
    Optional<Member> findByMemberId(String memberId);

    // 아이디 존재여부 확인
    boolean existsByMemberId(String memberId);

    // 모든 사용자 조회
    ArrayList<Member> findAll();

    Optional<Member> findMemberByMemberSeq(Long memberSeq);
}