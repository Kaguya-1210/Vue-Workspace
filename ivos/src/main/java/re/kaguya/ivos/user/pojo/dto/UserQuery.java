package re.kaguya.ivos.user.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class UserQuery {
    @Schema(name ="用户id")
    private Long id;
    @Schema(name = "用户名")
    private String username;
    private Date updateTime;
    @Schema(name = "用户状态")
    private String status;
    @Schema(name = "用户等级")
    private String level;
    @Schema(name ="用户领导人")
    private Long parentId;
}
