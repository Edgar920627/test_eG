package tody.lovely.service;

import tody.lovely.util.AuthInfo;
import tody.lovely.util.LoginCommand;
import tody.lovely.util.RegisterRequest;

public interface UserService {
	
    void register(RegisterRequest regReq) throws Exception;
    
    AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;


 
}

