package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.bean.UserProfileDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO login(Map<String, String> map) {
		return sqlSession.selectOne("userSQL.login",map);
	}

	@Override

	public String signUpCheck(UserDTO userDTO) {
		return sqlSession.selectOne("userSQL.signUpCheck", userDTO);
	}

	@Override
	public void signUp(UserDTO userDTO) {
		sqlSession.insert("userSQL.signUp" , userDTO);
	}

	@Override
	public String emailCheck(String user_email) {
		return sqlSession.selectOne("userSQL.emailCheck", user_email);
	}

	public List<UserProfileDTO> getProfileList(Map<String, String> map) {
		return sqlSession.selectList("userSQL.getProfileList",map);
	}

	@Override
	public UserProfileDTO getProfile(Map<String, String> map) {
		return sqlSession.selectOne("userSQL.getProfile",map);
	}

}
