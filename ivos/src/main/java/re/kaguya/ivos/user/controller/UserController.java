package re.kaguya.ivos.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya.ivos.user.pojo.dto.UserLoginParam;
import re.kaguya.ivos.base.response.JsonResult;
import re.kaguya.ivos.user.mapper.UserMapper;
import re.kaguya.ivos.user.pojo.dto.UserSaveParam;
import re.kaguya.ivos.user.pojo.entity.User;
import re.kaguya.ivos.user.pojo.vo.UserVo;
import re.kaguya.ivos.user.service.UserService;

import java.util.Date;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "用户模块", description = "管理用户")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    @Operation(summary = "用户登录")
    public JsonResult login(@RequestBody UserLoginParam userLoginParam) {
        UserVo login = userService.login(userLoginParam);
        log.debug("用户登录:" + userLoginParam);
        return JsonResult.ok(login);
    }


    @PostMapping("/save")
    @Operation(summary = "添加用户")
    public JsonResult saveUser(@RequestBody UserSaveParam userSaveParam) {
        log.debug(userSaveParam.toString());
        userService.saveUser(userSaveParam);
        return JsonResult.ok();
    }
}
