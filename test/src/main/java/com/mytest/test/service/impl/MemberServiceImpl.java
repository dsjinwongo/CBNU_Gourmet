package com.mytest.test.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mytest.test.service.MemberService;
import com.mytest.test.dao.MemberDAO;
import com.mytest.test.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
    MemberDAO memberDao;
    
    // 01_01. 회원 로그인체크
    @Override
    public boolean loginCheck(MemberVO vo, HttpSession session) {
        boolean result = memberDao.loginCheck(vo);
        if (result) { // true일 경우 세션에 등록
            MemberVO vo2 = viewMember(vo);
            // 세션 변수 등록
            session.setAttribute("userId", vo2.getUserId());
            session.setAttribute("userName", vo2.getUserName());
        } 
        return result;
    }
    // 01_02. 회원 로그인 정보
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return memberDao.viewMember(vo);
    }
    // 02. 회원 로그아웃
    @Override
    public void logout(HttpSession session) {
        // 세션 변수 개별 삭제
        // session.removeAttribute("userId");
        // 세션 정보를 초기화 시킴
        session.invalidate();
    }
    
    @Override
    public List<MemberVO> memberList() {
        return memberDao.memberList();
    }
 
    @Override
    public void insertMember(MemberVO vo) {
    	memberDao.insertMember(vo);
    }
 
    @Override
    public MemberVO viewMember() {
        return null;
    }
 
    @Override
    public void deleteMember(String userId) {
        
    }
 
    @Override
    public void updateMember(MemberVO vo) {
        
    }
}
