package tody.prj.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tody.prj.vo.BoardVO;

@Repository
public class BoardDAOImpl_e implements BoardDAO_e{
	
	
	
	@Inject
	private SqlSession sqlSession;
	
	// 댓글 조회
	@Override
	public List<BoardVO> excelList() throws Exception {
		return sqlSession.selectList("board.excelList");
	}

}
