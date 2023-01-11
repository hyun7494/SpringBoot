package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User2DAO;
import kr.co.ch07.repository.User2Repo;
import kr.co.ch07.vo.User2VO;

@Service
public class User2Service {
	
	// Mybatis용
	@Autowired
	private User2DAO dao;
	
	// JPA용
	@Autowired
	private User2Repo repo;
	
	public void insertUser2(User2VO vo) {
		// Mybatis
		// dao.insertUser2();
		
		// JPA
		repo.save(vo);
	}
	
	public User2VO selectUser2(String uid) {
		// Mybatis
		// return dao.selectUser2(uid);
		
		// JPA
		return repo.findById(uid).get();
	}
	
	public List<User2VO> selectUser2s(){
		// Mybatis
		// return dao.selectUser2s();
		
		// JPA
		List<User2VO> users = repo.findAll();
		return users;
		
	}
	
	public void updateUser2(User2VO vo) {
		// Mybatis
		// dao.updateUser2(vo);
		
		// JPA
		repo.save(vo);
	}
	
	public void deleteUser2(String uid) {
		// Mybatis
		// dao.deleteUser2(uid);
		
		// JPA
		repo.deleteById(uid);
	}
	
	
}
