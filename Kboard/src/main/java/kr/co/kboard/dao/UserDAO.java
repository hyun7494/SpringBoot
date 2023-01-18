package kr.co.kboard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {

	public void insertUser();
	public void selectUser();
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
}
