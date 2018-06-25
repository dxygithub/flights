package cn.bdqn.flight.util;
/**
 * redis-util
 * @author DELL
 *
 */

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;

public class JedisUtil {
	
	private JedisPool jedisPool;

	/**
	 * 获取redis连接池
	 * @return
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	/**
	 * 设置redis连接池
	 * @param jedisPool
	 */
	public void setJedisPool(JedisPoolWriper jedisPool) {
		this.jedisPool = jedisPool.getJedisPool();
	}
	
	/**
	 * 获取redis连接池中的jedis对象
	 * @return
	 */
	public Jedis getJedis() {
		return this.jedisPool.getResource();
	}
	
	//------------------------------------------------Keys内部类--------------------------------------------------
	public class 	Keys{
		
		/**
		 * 清空所有key
		 * @return
		 */
		public String flushAll() {
			Jedis jedis=getJedis();
			String satra=jedis.flushAll();
			jedis.close();
			return satra;
		}
		
		/**
		 * 删除keys对应记录，可以是多个key
		 * @param keys
		 * @return
		 */
		public Long del(String... keys ) {
			Jedis jedis=getJedis();
			Long count=jedis.del(keys);
			jedis.close();
			return count;
		}
		
		/**
		 * 判断key是否存在
		 * @param key
		 * @return
		 */
		public Boolean exists(String key) {
			Jedis jedis=getJedis();
			Boolean result=jedis.exists(key);
			jedis.close();
			return result;
		}
		
		/**
		 * 查找所有匹配给定的模式的键
		 * @param pattern
		 * @return
		 */
		public Set<String> keys(String pattern){
			Jedis jedis=getJedis();
			Set<String> set=jedis.keys(pattern);
			jedis.close();
			return set;
		}
		
	}
	
	//------------------------------------------------Strings内部类--------------------------------------------------
	public class Strings{
		
		/**
		 * 根据key获取记录
		 * @param key
		 * @return
		 */
		public String get(String key) {
			Jedis jedis=getJedis();
			String value=jedis.get(key);
			jedis.close();
			return value;
		}
		
		/**
		 * 添加记录，如果有会覆盖原有的value
		 * @param key
		 * @param value
		 * @return
		 */
		public String set(String key,String value) {
			return set(SafeEncoder.encode(key), SafeEncoder.encode(value));
		}
		
		/**
		 * 添加记录，如果有会覆盖原有的value
		 * @param key
		 * @param value
		 * @return
		 */
		public String set(byte[] key,byte[] value) {
			Jedis jedis=getJedis();
			String statr=jedis.set(key, value);
			jedis.close();
			return statr;
		}
	}
}
