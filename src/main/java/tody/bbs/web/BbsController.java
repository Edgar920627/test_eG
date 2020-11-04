package tody.bbs.web;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tody.prjdoo.common.CommandMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import tody.bbs.service.BbsService;


/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
@Controller
public class BbsController {

	

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */

	
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="bbsService")
    private BbsService bbsService;
	
	
    /*
     * 목록 페이지 이동
    */
    @RequestMapping(value="/bbs/bbs")
    public String bbsList() throws Exception {
        return "/bbs/bbsList";
    }
	
    
    @RequestMapping(value="/bbs/bbsList")
    public ModelAndView openBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView mav = new ModelAndView("/bbs/bbsList");
    	
    	Map<String,Object> resultMap = bbsService.getBbsList(commandMap.getMap());
    	
    	mav.addObject("paginationInfo", (PaginationInfo)resultMap.get("paginationInfo"));
    	mav.addObject("list", resultMap.get("result"));
    	
    	for (int i = 0; i < resultMap.size(); i++) {
    		
			
		}
  
    	return mav;
    }
    
    
	
	
}


