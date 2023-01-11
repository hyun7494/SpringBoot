package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User4DAO;
import kr.co.ch07.repository.User4Repo;
import kr.co.ch07.vo.User4VO;

@Service
public class User4Service {
	
	@Autowired
	private User4DAO dao;
	
	@Autowired
	private User4Repo repo;
	
	public void insertUser4(User4VO vo) {
		// dao.insertUser4();
		
		repo.save(vo);
	}
	
	public User4VO selectUser4(String uid) {
		// return dao.selectUser4(uid);
		
		return repo.findById(uid).get();
		
	}
	
	public List<User4VO> selectUser4s(){
		// return dao.selectUser4s();
		
		List<User4VO> users = repo.findAll();
		return users;
	}
	
	public void updateUser4(User4VO vo) {
		// dao.updateUser4(vo);
		repo.save(vo);
	}
	
	public void deleteUser4(String uid) {
		// dao.deleteUser4(uid);
		repo.deleteById(uid);
	}
	
	
}
