package kr.co.sboard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Mapper
@Repository
public interface UserDAO {
	
	// insert쓴 이유 메서드를 실행했을 때 DB에서 영향을 받아서 값이 바뀌는 행의 갯수만큼
	public int insertUser(UserVO vo);
	public TermsVO selectTerms();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
	

}
