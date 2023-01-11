package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User3DAO;
import kr.co.ch07.repository.User3Repo;
import kr.co.ch07.vo.User3VO;

@Service
public class User3Service {
	
	@Autowired
	private User3DAO dao;
	
	@Autowired
	private User3Repo repo;
	
	public void insertUser3(User3VO vo) {
		// Mybatis
		// dao.insertUser3();
		
		// JPA
		repo.save(vo);
	}
	
	public User3VO selectUser3(String uid) {
		// Mybatis
		// return dao.selectUser3(uid);
		
		// JPA
		return repo.findById(uid).get(); 
	}
	
	public List<User3VO> selectUser3s(){
		// Mybatis
		// return dao.selectUser3s();
		
		// JPA
		List<User3VO> users = repo.findAll();
		return users;
	}
	
	public void updateUser3(User3VO vo) {
		// Mybatis
		// dao.updateUser3(vo);
		
		// JPA
		repo.save(vo);
	}
	
	public void deleteUser3(String uid) {
		// Mybatis
		// dao.deleteUser3(uid);
		
		// JPA
		repo.deleteById(uid);
	}
	
	
}
