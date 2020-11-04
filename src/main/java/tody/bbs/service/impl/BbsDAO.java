package tody.bbs.service.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import tody.lovely.common.dao.AbstractDAO;



@Repository("bbsDAO")
public class BbsDAO extends AbstractDAO{
	
/*
	// 게시글 [이전] [다음] 10개씩 표시
	public List<BbsBean> getBbsList(int startRow, int endRow, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> bbsList = sqlsession.selectList("Bbs.listAll", pageMap);

		return bbsList;
	}
*/
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getBbsList(Map<String, Object> map) throws Exception{
		return (Map<String, Object>)selectPagingList("bbs.getBbsList", map);
	}
	
	
	
	
}
