package kr.co.farmstory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    public int insertUser(UserDAO dao);
    public int selectUser();
}
