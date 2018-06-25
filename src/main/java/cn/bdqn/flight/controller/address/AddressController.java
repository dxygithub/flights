package cn.bdqn.flight.controller.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.bdqn.flight.pojo.Address;
import cn.bdqn.flight.service.address.IAddressService;

/**
 * 航班地点controller
 * @author DELL
 *
 */
@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Resource(name="addressServiceImpl")
	private IAddressService addressService;
	
	/**
	 * 进入航班信息添加页面
	 * @return
	 */
	@RequestMapping("/getAllAddress")
	@ResponseBody
	public String getAllAddress() {
		List<Address> datas=this.addressService.getAllAddress();
		String json=JSON.toJSONString(datas);
		return json;
	}
}
