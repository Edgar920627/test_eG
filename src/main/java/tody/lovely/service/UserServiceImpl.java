package tody.lovely.service;
 
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tody.lovely.dao.UserDAO;
import tody.lovely.exception.AlreadyExistingEmailException;
import tody.lovely.exception.AlreadyExistingIdException;
import tody.lovely.exception.IdPasswordNotMatchingException;
import tody.lovely.util.AuthInfo;
import tody.lovely.util.LoginCommand;
import tody.lovely.util.RegisterRequest;
import tody.lovely.vo.UserVO;

 
@Service("userService")
public class UserServiceImpl implements UserService {
 
	   @Resource(name="userDAO")
	    private UserDAO userDAO;
	 
    @Override
    public void register(RegisterRequest regReq) throws Exception {
        UserVO email = userDAO.selectByEmail(regReq.getEmail());
        if(email!=null) {
            throw new AlreadyExistingEmailException(regReq.getEmail()+" is duplicate email.");
        }
        UserVO id = userDAO.selectById(regReq.getId());
        if(id!=null) {
            throw new AlreadyExistingIdException(regReq.getId()+" is duplicate id.");
        }
        userDAO.insertUser(regReq);
    }
    
    
 
    @Override
    public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
        UserVO user = userDAO.selectById(loginCommand.getId());
        if(user == null) {
            throw new IdPasswordNotMatchingException();
        }
        if(!user.matchPassword(loginCommand.getPw())) {
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(user.getID(), user.getNAME(), user.getGRADE());
    }



}
