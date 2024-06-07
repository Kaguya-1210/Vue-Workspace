package re.kaguya.ivos.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.kaguya.ivos.base.exception.ServiceException;
import re.kaguya.ivos.base.response.StatusCode;
import re.kaguya.ivos.user.mapper.UserMapper;
import re.kaguya.ivos.user.pojo.dto.UserLoginParam;
import re.kaguya.ivos.user.pojo.dto.UserSaveParam;
import re.kaguya.ivos.user.pojo.entity.User;
import re.kaguya.ivos.user.pojo.vo.UserVo;
import re.kaguya.ivos.user.service.UserService;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void saveUser(UserSaveParam userSaveParam) {
        User user = new User();
        BeanUtils.copyProperties(userSaveParam, user);
        if (user.getId() == null) {
            user.setPassword("123456");
            user.setCreateTime(new Date());
            userMapper.insert(user);
        }
    }

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
