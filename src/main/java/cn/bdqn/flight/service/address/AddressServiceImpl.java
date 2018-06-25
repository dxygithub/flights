package cn.bdqn.flight.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.flight.dao.address.AddressMapper;
import cn.bdqn.flight.pojo.Address;
/**
 * 航班地点service-impl
 * @author DELL
 *
 */
@Service("addressServiceImpl")
public class AddressServiceImpl implements IAddressService {
	
	@Resource(name="addressMapper")
	private AddressMapper addressMapper;
	
	/**
	 * 获取所有航班地点信息
	 * @return
	 */
	public List<Address> getAllAddress() {
		return this.addressMapper.getAllAddress();
	}

}
