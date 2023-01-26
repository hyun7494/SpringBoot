package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDAO {
    public int insertArticle(ArticleVO vo);
    public int insertFile(FileVO vo);
    public int selectCountTotal(String cate);
    public ArticleVO selectArticle(int no);
    public List<ArticleVO> selectArticles(@Param("cate") String cate, @Param("start") int start);    public FileVO selectFile(int fno);
    public int updateFileDownload(int fno);
    public int updateArticle(ArticleVO vo);
    public int deleteArticle(int no);

}
