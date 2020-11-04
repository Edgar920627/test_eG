package tody.prj.vo;

public class BoardVO {
	
/*	  
 * 	  IDX NUMBER(11) PRIMARY KEY, 
	  PRE_IDX NUMBER(11) DEFAULT NULL,
	  TITLE varchar2(100) NOT NULL,
	  CONTENTS varchar2(4000) NOT NULL,
	  HIT_CNT NUMBER(11) NOT NULL,
	  DEL_CHK char(1) DEFAULT 'N',
	  CREA_DATE DATE DEFAULT SYSDATE NOT NULL,
	  CREA_ID varchar2(30) NOT NULL
*/
	

	private int idx;
	private int pre_idx;
	private String title;
	private String contents;
	private int hit_cnt;
	private String del_chk;
	private String crea_date;
	private String crea_id;
	
	
	
	public String getCrea_id() {
		return crea_id;
	}
	public void setCrea_id(String crea_id) {
		this.crea_id = crea_id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPre_idx() {
		return pre_idx;
	}
	public void setPre_idx(int pre_idx) {
		this.pre_idx = pre_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit_cnt() {
		return hit_cnt;
	}
	public void setHit_cnt(int hit_cnt) {
		this.hit_cnt = hit_cnt;
	}
	public String getDel_chk() {
		return del_chk;
	}
	public void setDel_chk(String del_chk) {
		this.del_chk = del_chk;
	}
	public String getCrea_date() {
		return crea_date;
	}
	public void setCrea_date(String crea_date) {
		this.crea_date = crea_date;
	}
	
	
	
	
	
	
	
}
