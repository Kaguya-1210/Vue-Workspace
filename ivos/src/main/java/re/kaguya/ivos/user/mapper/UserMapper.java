package re.kaguya.ivos.user.mapper;

import org.springframework.stereotype.Repository;
import re.kaguya.ivos.user.pojo.entity.User;
import re.kaguya.ivos.user.pojo.vo.UserVo;

@Repository
public interface UserMapper {

    UserVo selectByUsername(String username);

    void insert(User user);

}
