package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.MemberRepo;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberRepo repo;
	
	public void insertMember(MemberVO vo) {
		repo.save(vo);
	}
	public MemberVO selectMember(String uid) {
		MemberVO member = repo.findById(uid).get();
		return member;
	}
	public List<MemberVO> selectMembers(){
		List<MemberVO> members = repo.findAll();
		return members;
	}
	public void updateMember(MemberVO vo) {
		repo.save(vo);
	}
	public void deleteMember(String uid) {
		repo.deleteById(uid);
	}
}
