package com.example.welcomedog_web.service;


import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Member;

public interface MemberService {
    // 회원가입
    void join(MemberDTO.Request request);

    // 로그인 기능
    Member login(MemberDTO.Request request);

    // 회원 존재여부 확인
    boolean findMember(String memberId);

    // 회원 삭제 or 탈퇴
    void delete(String memberId);

    // MemberId로 상세정보 조회
    MemberDTO.Response memberDetail(String memberId);

}
