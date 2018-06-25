package cn.bdqn.flight.service.address;

import java.util.List;

import cn.bdqn.flight.pojo.Address;

/**
 * 航班地点I-service
 * @author DELL
 *
 */
public interface IAddressService {
	/**
	 * 获取所有航班地点信息
	 * @return
	 */
	List<Address> getAllAddress();
}
