package zqit.springsession.pulgins.redis.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zqit.springsession.pulgins.redis.test.RedisService;

@Controller
@RequestMapping("/redisTest")
public class RedisTestController {

	@Autowired
	RedisService redisService;
	
	// redis redisTemplate 测试
	@ResponseBody
	@GetMapping("/redisUtil-test")
	public String redisTest() {
		String setRedisValue = redisService.setRedisValue();
		String redisValue = redisService.getRedisValue();
		String delRedisValue = redisService.delRedisValue();
		String redisValue2 = redisService.getRedisValue();
		return setRedisValue+ " | " + redisValue + " | " + delRedisValue + " | " + redisValue2;
	}

	// 缓存测试
	@ResponseBody
	@GetMapping("/redisCacheTest-del")
	public String redisCacheTestDel(Integer id) {
		String setById = redisService.delById(id);
		return setById;
	}
	@ResponseBody
	@GetMapping("/redisCacheTest-get")
	public String redisCacheTestGet(Integer id) {
		String byId = redisService.getById(id);
		return byId;
	}

}
