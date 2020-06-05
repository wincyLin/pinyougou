package pin.you.brand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pin.you.gou.mapper")
public class BrandQuery {
	
	public static void main(String[] args) {
		SpringApplication.run(BrandQuery.class, args);
	}

}
