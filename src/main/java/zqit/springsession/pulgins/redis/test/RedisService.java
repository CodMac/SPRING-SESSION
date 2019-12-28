package zqit.springsession.pulgins.redis.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import zqit.springsession.pulgins.redis.RedisUtils;

@Service
public class RedisService {
	
	@Autowired
	RedisUtils redisUtil;
	
	//--------redisUtil测试
	public String setRedisValue() {
		redisUtil.setObj("testString", "testA");
		System.out.println("设置(set)testString = testA");
		return "设置(set)testString = testA";
	}
	
	public String getRedisValue() {
		Object obj = redisUtil.getObj("testString");
		boolean empty = ObjectUtils.isEmpty(obj);
		obj = empty?"null":obj.toString();
		System.out.println("获取(get)testString = " + obj.toString());
		return "获取(get)testString = " + obj.toString();
	}
	
	public String delRedisValue() {
		redisUtil.delObj("testString");
		System.out.println("删除(del)testString");
		return "删除(del)testString";
	}
	
	//---------缓存功能测试 
	/**
	 * @Cacheable 可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的。
	 * <\t>对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。
	 * 
	 * @CachePut 可以声明一个方法支持缓存功能。
	 * <\t>与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	 *
	 * @CacheEvict 用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。
	 * 
	 * @Caching 可以让我们在一个方法或者类上同时指定多个Spring Cache相关的注解。其拥有三个属性：cacheable、put和evict，分别用于指定@Cacheable、@CachePut和@CacheEvict。
	 */
	
	/**
	 * 清除缓存
	 */
	@CacheEvict(value="methodCache", key="'users_'+#id")
    public String delById(Integer id) {
		@SuppressWarnings("deprecation")
		String data = "我执行了delById(),当前时间: " + new Date().toLocaleString();
        System.out.println(data);
		return data;
    }
	/**
     * 查询缓存
     */
    @Cacheable(cacheNames = "methodCache", key="'users_'+#id")
    public String getById(Integer id) {
    	@SuppressWarnings("deprecation")
    	String data = "我执行了getById(),当前时间: " + new Date().toLocaleString();
        System.out.println(data);
		return data;
    }
	
	
}
