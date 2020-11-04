package tody.prj.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import tody.prj.dao.BoardDAO;
import tody.prj.dao.BoardDAO_e;
import tody.prj.vo.BoardVO;
import tody.prjdoo.common.CommandMap;



@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="boardDAO")
    private BoardDAO boardDAO;

    @Inject BoardDAO_e boardDAO_e;
	// 댓글 조회
	@Override
	public List<BoardVO> excelList() throws Exception {
		return boardDAO_e.excelList();
	}


	
/*
	@Override
    public List<Map<String, Object>> selectBoardList(Criteria cri) {
        return boardDAO.selectBoardList(cri);
    }
*/

	@Override
	public Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardList(map);
	}

	
    

    @Override
    public void insertBoard(CommandMap commandMap) {
        // TODO Auto-generated method stub
        boardDAO.insertBoard(commandMap);
    }

    
    @Override
    public Map<String, Object> viewBoardDetail(Map<String, Object> map) {
        // TODO Auto-generated method stub
        boardDAO.updateHitBoard(map);
        Map<String, Object> detail = boardDAO.detailBoard(map);
        return detail;
    }

    
    
    @Override
    public Map<String, Object> selectBoardDetail(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return boardDAO.detailBoard(map);
    }
 
    
    
    @Override
    public void updateBoard(Map<String, Object> map,  HttpServletRequest request) {
    	System.out.println(" 서비스  게시글 수정 ");
        boardDAO.updateBoard(map);
        
    }

    
    @Override
    public void deleteBoard(Map<String, Object> map) {
        // TODO Auto-generated method stub
        boardDAO.deleteBoard(map);
    }
    
    
    
    // 게시몰 총 갯수 
    @Override
    public int countBoardListTotal() {
        return boardDAO.countBoardList();
    }




}
