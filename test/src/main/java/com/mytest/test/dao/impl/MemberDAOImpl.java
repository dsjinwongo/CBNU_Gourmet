package com.mytest.test.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mytest.test.dao.MemberDAO;
import com.mytest.test.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	 // SqlSession 객체를 스프핑에서 생성하여 주입
    // 의존관계 주입(Dependency Injection), 느슨한 결합
    @Inject
    SqlSession sqlSession; // mybatis 실행 객체
    
    // 01_01. 회원 로그인체크
    @Override
    public boolean loginCheck(MemberVO vo) {
        String name = sqlSession.selectOne("member.loginCheck", vo);
        return (name == null) ? false : true;
    }
    // 01_02. 회원 로그인 정보
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return sqlSession.selectOne("member.viewMember", vo);
    }
    // 02. 회원 로그아웃
    @Override
    public void logout(HttpSession session) {
    }
    
    @Override
    public List<MemberVO> memberList() {
        return sqlSession.selectList("member.memberList");
    }
 
    @Override
    public void insertMember(MemberVO vo) {
    	sqlSession.insert("member.insertMember", vo);
    }
 
    @Override
    public MemberVO viewMember() {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public void deleteMember(String userId) {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public void updateMember(MemberVO vo) {
        // TODO Auto-generated method stub
 
    }
}
