package re.kaguya.ivos.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("re.kaguya.ivos.user.mapper")
public class MybatisConfig {
}