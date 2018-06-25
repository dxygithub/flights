package cn.bdqn.flight.util;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * jedis连接池类
 * @author DELL
 *
 */
public class JedisPoolWriper {
	//redis连接池对象
	private JedisPool jedisPool;
	
	/**
	 * 获取redis连接池对象
	 * @return
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	/**
	 * 注入连接池对象
	 * @param jedisPool
	 */
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	//注入redis连接池对象
	public JedisPoolWriper(final JedisPoolConfig poolConfig,final String host,final int port,final int timeout,final String password) {
		try {
			this.jedisPool=new JedisPool(poolConfig,host,port,timeout,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
