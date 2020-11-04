package tody.prj.dao;

import java.util.List;

import tody.prj.vo.BoardVO;

public interface BoardDAO_e {
	// 댓글 조회
	public List<BoardVO> excelList() throws Exception;
	
}
