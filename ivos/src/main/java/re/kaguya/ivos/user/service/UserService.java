package re.kaguya.ivos.user.service;

import re.kaguya.ivos.user.pojo.dto.UserLoginParam;
import re.kaguya.ivos.user.pojo.dto.UserQuery;
import re.kaguya.ivos.user.pojo.dto.UserSaveParam;
import re.kaguya.ivos.user.pojo.vo.UserVo;

import java.util.List;

public interface UserService {
    UserVo login(UserLoginParam userLoginParam);

    void saveUser(UserSaveParam userSaveParam);

    List<UserVo> selectUser(UserQuery userQuery);
}
