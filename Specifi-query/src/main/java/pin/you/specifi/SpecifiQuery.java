package pin.you.specifi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pin.you.gou.mapper")
public class SpecifiQuery {
	

	public static void main(String[] args) {
		SpringApplication.run(SpecifiQuery.class, args);
	}

	
	

}
