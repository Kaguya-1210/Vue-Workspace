package re.kaguya.ivos.user.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @Schema(name ="用户id")
    private Long id;
    @Schema(name = "用户名")
    private String username;
    @Schema(name = "用户密码")
    private String password;
    @Schema(name = "用户邮箱")
    private String email;
    @Schema(name = "用户电话")
    private String phone;
    @Schema(name = "用户年龄")
    private Integer age;
    @Schema(name = "用户性别")
    private String gender;
    @Schema(name = "用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Schema(name = "用户更新时间")
    private Date updateTime;
    @Schema(name = "用户状态")
    private String status;
    @Schema(name = "用户等级")
    private String level;
    @Schema(name ="用户领导人")
    private Long parentId;
}
