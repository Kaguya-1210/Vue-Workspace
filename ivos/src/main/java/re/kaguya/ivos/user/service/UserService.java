package re.kaguya.ivos.user.service;

import re.kaguya.ivos.user.pojo.dto.UserLoginParam;
import re.kaguya.ivos.user.pojo.vo.UserVo;

public interface UserService {
    UserVo login(UserLoginParam userLoginParam);
}
