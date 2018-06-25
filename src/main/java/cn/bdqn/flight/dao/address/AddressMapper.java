package cn.bdqn.flight.dao.address;


import java.util.List;

import cn.bdqn.flight.pojo.Address;
/**
 * 地址信息I-dao
 * @author DELL
 *
 */
public interface AddressMapper {
	/**
	 * 获取所有航班地点信息
	 * @return
	 */
	List<Address> getAllAddress();
}
