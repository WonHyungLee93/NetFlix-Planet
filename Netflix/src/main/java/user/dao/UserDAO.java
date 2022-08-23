package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserProfileDTO;

public interface UserDAO {

	public UserDTO login(Map<String, String> map);

	public List<UserProfileDTO> getProfileList(Map<String, String> map);

	public UserProfileDTO getProfile(Map<String, String> map);

}
