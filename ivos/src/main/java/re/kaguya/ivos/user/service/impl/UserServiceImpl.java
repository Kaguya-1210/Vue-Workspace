package re.kaguya.ivos.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.kaguya.ivos.base.exception.ServiceException;
import re.kaguya.ivos.base.response.StatusCode;
import re.kaguya.ivos.user.mapper.UserMapper;
import re.kaguya.ivos.user.pojo.dto.UserLoginParam;
import re.kaguya.ivos.user.pojo.vo.UserVo;
import re.kaguya.ivos.user.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public UserVo login(UserLoginParam userLoginParam) {
        log.debug("登录业务参数:" + userLoginParam);
        UserVo userVo = userMapper.selectByUsername(userLoginParam.getUsername());
        if (userVo == null) {
            throw new ServiceException(StatusCode.USERNAME_ERROR);
        }
        if (!userVo.getPassword().equals(userLoginParam.getPassword())) {
            throw new ServiceException(StatusCode.PASSWORD_ERROR);
        }
        return userVo;
    }
}
