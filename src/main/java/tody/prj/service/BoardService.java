package tody.prj.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import tody.prj.vo.BoardVO;
import tody.prjdoo.common.CommandMap;

public interface BoardService {
	
	// 댓글 조회
	public List<BoardVO> excelList() throws Exception;
	
//	List<Map<String, Object>> selectBoardList(Criteria cri);

//	목록  전자페이징
	
	
	Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(CommandMap commandMap);

	Map<String, Object> viewBoardDetail(Map<String, Object> map);

	Map<String, Object> selectBoardDetail(Map<String, Object> map);

	void updateBoard(Map<String, Object> map, HttpServletRequest request);

	void deleteBoard(Map<String, Object> map);

	// 게시몰 총 갯수
	int countBoardListTotal();

}
