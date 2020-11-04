package tody.lovely.dao;

import org.springframework.stereotype.Repository;

import tody.lovely.common.dao.AbstractDAO;
import tody.lovely.util.RegisterRequest;
import tody.lovely.vo.UserVO;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {

	public UserVO selectByEmail(String email) {
		return (UserVO) selectOne("user.selectByEmail", email);
	}

	public UserVO selectById(String id) {
		return (UserVO) selectOne("user.selectById", id);
	}

	public void insertUser(RegisterRequest regReq) {
		insert("user.register", regReq);
	}

	
	


}
