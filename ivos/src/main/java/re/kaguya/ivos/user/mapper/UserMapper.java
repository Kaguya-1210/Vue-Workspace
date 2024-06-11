package re.kaguya.ivos.user.mapper;

import org.springframework.stereotype.Repository;
import re.kaguya.ivos.user.pojo.dto.UserQuery;
import re.kaguya.ivos.user.pojo.entity.User;
import re.kaguya.ivos.user.pojo.vo.UserVo;

import java.util.List;

@Repository
public interface UserMapper {

    UserVo selectByUsername(String username);

    void insert(User user);

    List<UserVo> selectUser(UserQuery userQuery);
}
