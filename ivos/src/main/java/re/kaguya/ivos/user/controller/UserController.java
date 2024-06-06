package re.kaguya.ivos.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya.ivos.pojo.dto.UserLoginParam;
import re.kaguya.ivos.response.JsonResult;
import re.kaguya.ivos.user.mapper.UserMapper;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "用户模块", description = "管理用户")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("login")
    @Operation(summary = "用户登录")
    public JsonResult login(@RequestBody UserLoginParam userLoginParam) {
        log.debug("用户登录:" + userLoginParam);
        return JsonResult.ok();
    }


}
