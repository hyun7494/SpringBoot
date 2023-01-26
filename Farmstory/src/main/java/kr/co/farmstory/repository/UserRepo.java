package kr.co.farmstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.farmstory.entity.UserEntity;
public interface UserRepo extends JpaRepository<UserEntity, String>{
//                                                         첫번째 자료형을 두번째에 적어야함
	// CountBy가 안떠서 지어서 사용하려고
	public int countByUid(String uid);
	
	public int countByNick(String nick);
	
	public int countByHp(String hp);
}
