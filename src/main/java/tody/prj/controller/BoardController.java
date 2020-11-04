package tody.prj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import tody.prj.service.BoardService;
import tody.prj.vo.BoardVO;
import tody.prjdoo.common.CommandMap;

@Controller
public class BoardController {
    
    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="boardService")
    private BoardService boardService;
    
    
    @RequestMapping(value = "/excelDown.do")
    public void excelDown(HttpServletResponse response, CommandMap commandMap, Map<String, Object> map,HttpServletRequest request) throws Exception {
    	ModelAndView mav = new ModelAndView("/board/boardList");
    	// 게시판 목록조회
      List<BoardVO> list = boardService.excelList();
      
      

      
      Map<String,Object> resultMap = boardService.selectBoardList(commandMap.getMap());
      
      mav.addObject("list", resultMap.get("result"));

      
      


      List<Map<String, Object>> list33 = (List<Map<String, Object>>) resultMap.get("result");
      
      System.out.println(" [ resultMap ] "+resultMap);

      for(Map<String, Object> map23 : list33) {
    	  System.out.println(".................................." + map23.get("IDX"));
    	  
      }
      System.out.println(" [ resultMap.get() ] "+ list33);
      
        // 워크북 생성
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("게시판");
        Row row = null;
        Cell cell = null;
        int rowNo = 0;


        // 테이블 헤더용 스타일
        CellStyle headStyle = wb.createCellStyle();

        // 가는 경계선을 가집니다.
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);


        // 배경색은 노란색입니다.
        headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 데이터는 가운데 정렬합니다.
        headStyle.setAlignment(HorizontalAlignment.CENTER);


        // 데이터용 경계 스타일 테두리만 지정
        CellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);


        // 헤더 생성
        row = sheet.createRow(rowNo++);
        
        cell = row.createCell(0);
        cell.setCellStyle(headStyle);
        cell.setCellValue("글번호");
        
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("제목");
        
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("작성자");
        
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("작성일");
        
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("조회수");
        
        
        
        // 데이터 부분 생성

        for(BoardVO vo : list) {

            row = sheet.createRow(rowNo++);

            cell = row.createCell(0);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getIdx());

            cell = row.createCell(1);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getTitle());

            cell = row.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getCrea_id());
            
            cell = row.createCell(3);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getCrea_date());
            
            cell = row.createCell(4);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getHit_cnt());
         
//            cell.setCellValue(""+resultMap.get("HIT_CNT"));


        }



        // 컨텐츠 타입과 파일명 지정
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=test.xls");

        // 엑셀 출력
        wb.write(response.getOutputStream());
        wb.close();

    }

    
/*    
    @RequestMapping(value="/board/boardList")
    public ModelAndView openBoardList(Criteria cri) throws Exception {
            
        ModelAndView mav = new ModelAndView("/board/boardList");
            
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(boardService.countBoardListTotal());
            
        List<Map<String,Object>> list = boardService.selectBoardList(cri);
        mav.addObject("list", list);
        mav.addObject("pageMaker", pageMaker);
            
        return mav;
            
    }
    
*/    
    
    @RequestMapping(value="/board/boardList")
    public ModelAndView openBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView mav = new ModelAndView("/board/boardList");
    	
    	Map<String,Object> resultMap = boardService.selectBoardList(commandMap.getMap());
    	
    	mav.addObject("paginationInfo", (PaginationInfo)resultMap.get("paginationInfo"));
    	mav.addObject("list", resultMap.get("result"));
    	
    	for (int i = 0; i < resultMap.size(); i++) {
    		
			
		}
  
    	return mav;
    }

   
    
    
    /*
     * 글쓰기 페이지 이동
    */
    @RequestMapping(value="/board/boardWrite")
    public String boardWrite() throws Exception {
        return "/board/boardWrite";
    }

    

 
    /*
     * 글쓰기 등록
     */ 
    @RequestMapping(value="/board/boardInsert")
    public ModelAndView boardInsert(CommandMap commandMap) throws Exception {
        ModelAndView mav = new ModelAndView("redirect:/board/boardList");
        boardService.insertBoard(commandMap);
        return mav;
    }
    
    
    
    @RequestMapping(value="/board/boardDetail")
    public ModelAndView boardDetail(CommandMap commandMap) throws Exception {
        
        ModelAndView mv = new ModelAndView("/board/boardDetail");
        Map<String, Object> detail = boardService.viewBoardDetail(commandMap.getMap());
        mv.addObject("detail",detail);
        
        
        return mv;
    }
    
    
    
    @RequestMapping(value="/board/boardUpdate")
    public ModelAndView boardUpdate(CommandMap commandMap) throws Exception {
        
        ModelAndView mv = new ModelAndView("/board/boardUpdate");
        Map<String, Object> detail = boardService.selectBoardDetail(commandMap.getMap());
        mv.addObject("detail",detail);
        return mv;
    }
    
    
    @RequestMapping(value="/board/boardUpdate", method=RequestMethod.POST)
    public ModelAndView boardUpdatePOST(CommandMap commandMap,  HttpServletRequest request) throws Exception {
    		System.out.println(" [  1. BoardController boardUpdatePOST  수정 ] ");
    	
        ModelAndView mv = new ModelAndView("redirect:/board/boardDetail");
        	System.out.println(" [  2. BoardController boardUpdatePOST  수정     mv  = ( " +  mv  +" ) ] ");
        
        mv.addObject("idx", commandMap.get("idx"));

        	System.out.println(" [  3. BoardController boardUpdatePOST  수정    mv  = ( " +  mv  +" ) ] ");
        
        boardService.updateBoard(commandMap.getMap(), request);
        	System.out.println(commandMap.get("idx"));
        	System.out.println(" [  4. BoardController boardUpdatePOST  수정    commandMap.getMap()  = ( " +  commandMap.getMap()  +" ) ] ");
        return mv;
    }
    
    

    @RequestMapping(value="/board/boardDelete")
    public ModelAndView boardDelete(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/board/boardList");
        boardService.deleteBoard(commandMap.getMap());
        return mv;
    }

   


   

}
