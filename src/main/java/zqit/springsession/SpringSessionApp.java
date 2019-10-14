package zqit.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:zqit/springsession/pulgins/springSession/redis-config.properties", encoding = "utf-8")

@SpringBootApplication
public class SpringSessionApp  extends SpringBootServletInitializer //需要打包为war时， 继承SpringBootServletInitializer，同时重写configure方法
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringSessionApp.class);
    }
	
	public static void main(String[] args) {
        SpringApplication.run(SpringSessionApp.class, args);
    }
}
