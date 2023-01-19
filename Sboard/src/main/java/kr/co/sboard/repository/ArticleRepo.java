package kr.co.sboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.sboard.vo.ArticleVO;

public interface ArticleRepo extends JpaRepository<ArticleVO, Integer>{


}
