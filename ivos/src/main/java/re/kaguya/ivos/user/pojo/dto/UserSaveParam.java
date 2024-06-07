package re.kaguya.ivos.user.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/*
  username:'',
  phone:'',
  email:'',
  age:'',
  level:'',
  parentId:'',
  gender:'',
  status:''
 */
@Data
public class UserSaveParam {
    @Schema(name = "用户id")
    private Long id;
    @Schema(name = "用户名")
    private String username;
    @Schema(name = "用户邮箱")
    private String email;
    @Schema(name = "用户电话")
    private String phone;
    @Schema(name = "用户年龄")
    private Integer age;
    @Schema(name = "用户性别")
    private String gender;
    @Schema(name = "用户状态")
    private String status;
    @Schema(name = "用户等级")
    private String level;
    @Schema(name = "用户上级领导")
    private Long parentId;
}
