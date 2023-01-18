package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.repository.UserRepo;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private UserRepo repo;
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	};
	
	public int insertUser(UserVO vo) {
		// 여기서 pass를 BCrypt암호로 바꿔줌
		String pass = vo.getPass2();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		vo.setPass(encoder.encode(pass));
		
		int result = dao.insertUser(vo);
		
		return result;
	}
	
	public int countUser(String uid) {
		return repo.countByUid(uid);
		
	}
	
	public int countNick(String nick) {
		return repo.countByNick(nick);
	}
	
	public int countHp(String hp) {
		return repo.countByHp(hp);
	}
	
	// 로그인
	public int selectUser(UserVO vo) {
		String uid = vo.getUid();
		String pass = vo.getPass();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		int result = dao.countUser(vo);
		
		return result;
	}

}
