package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDAO {
    public int insertArticle(ArticleVO vo);
    public int insertFile(FileVO vo);
    public int selectCountTotal();
    public ArticleVO selectArticle(int no);
    public List<ArticleVO> selectArticles(String cate);
    public FileVO selectFile(int fno);
    public int updateFileDownload(int fno);
    public int updateArticle(ArticleVO vo);
    public int deleteArticle(int no);

}
