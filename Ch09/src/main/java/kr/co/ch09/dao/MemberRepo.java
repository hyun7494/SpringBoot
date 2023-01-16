package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.MemberVO;

@Mapper
@Repository
public interface MemberRepo extends JpaRepository<MemberVO, String>{
	

	

}
