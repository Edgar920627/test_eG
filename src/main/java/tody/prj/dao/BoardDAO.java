package tody.prj.dao;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import tody.lovely.common.dao.AbstractDAO;
import tody.prj.vo.BoardVO;
import tody.prjdoo.common.CommandMap;
 
/*
 * 
	AbstractDAO는 직접 만든 클래스를 상속받은 것이다. AbstarctDAO를 상속받지 않아도 된다.
	상속 받지 않고 싶으면 AbstractDAO에 구현된 기능들을 바로 여기 DAO에 구현하면 된다.
	AbstarctDAO에 관한 내용은 
	https://to-dy.tistory.com/27?category=700248
	 여기를 참고하자!
*/
@Repository("boardDAO")
public class BoardDAO extends AbstractDAO{
	
//	@SuppressWarnings("unchecked")
//	public List<Map<String, Object>> selectBoardList(Criteria cri) {
//	    return (List<Map<String,Object>>)selectList("board.selectBoardList", cri);
//	}
    
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception{
		return (Map<String, Object>)selectPagingList("board.selectBoardList", map);
	}


	
    public void insertBoard(CommandMap commandMap) {
        // TODO Auto-generated method stub
        insert("board.insertBoard", commandMap.getMap());        
    }

    
    @SuppressWarnings("unchecked")
    public Map<String, Object> detailBoard(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return (Map<String, Object>) selectOne("board.detailBoard", map);
    }
 
    public void updateHitBoard(Map<String, Object> map) {
        update("board.updateHitBoard", map);
    }

    
    public void updateBoard(Map<String, Object> map) {
    	System.out.println(" DAO  updateBoard  진입");
        update("board.updateBoard",map);
    }

    
    public void deleteBoard(Map<String, Object> map) {
        // TODO Auto-generated method stub
        update("board.deleteBoard", map);
    }


    
    // 게시물 총 갯수
    public int countBoardList(){
        return (Integer) selectOne("board.countBoardList");
    }


 
    
    
 
}
