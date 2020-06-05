package pin.you.adver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pin.you.gou.mapper")

public class AppQuery {

	public static void main(String[] args) {
		SpringApplication.run(AppQuery.class, args);
	}


}
