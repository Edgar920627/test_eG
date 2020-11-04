package tody.bbs.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import tody.bbs.service.impl.BbsDAO;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {

    Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="bbsDAO")
    private BbsDAO bbsDAO;
    
    
	@Override
	public Map<String, Object> getBbsList(Map<String, Object> map) throws Exception {
		return bbsDAO.getBbsList(map);
	}
	
	
}
