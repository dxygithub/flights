package cn.bdqn.flight.service.flight;

import java.util.List;

import javax.annotation.Resource;

import cn.bdqn.flight.dao.flight.FlightInfoMapper;
import org.springframework.stereotype.Service;

import cn.bdqn.flight.dao.flight.FlightInfoMapper;
import cn.bdqn.flight.pojo.Flightinfo;
import cn.bdqn.flight.util.PageTool;
import org.springframework.transaction.annotation.Transactional;

/**
 * 航班信息service-impl
 * @author DELL
 *
 */
@Service("flightServiceImpl")
@Transactional
public class FlightServiceImpl implements IFlightService {
	
	@Resource(name="flightInfoMapper")
	private FlightInfoMapper flightInfoMapper;
	
	/**
	 * 根据当前页码获取航班信息
	 * @param pageIndex:当前页码
	 * @param pageSize:每页显示的数据量
	 * @param start:起始地
	 * @param dest:目的地
	 *  @param startTime:出发日期
	 * @return
	 */
	public List<Flightinfo> flightinfosPage(Integer pageIndex, Integer pageSize, Integer start, Integer dest,
			String startTime) {
		return this.flightInfoMapper.flightinfosPage(pageIndex, pageSize, start, dest, startTime);
	}

	/**
	 * 获取航班信息总记录数
	 * @return
	 */
	public Integer getFlightDataCount(
			Integer start,
			Integer dest,
			String startTime) {
		return this.flightInfoMapper.getFlightDataCount(start, dest, startTime);
	}

	/**
	 * 保存航班信息
	 * @param flightinfo:pojo
	 * @return
	 */
	@Transactional
	public Integer saveFlightInfo(Flightinfo flightinfo) {
		return this.flightInfoMapper.saveFlightInfo(flightinfo);
	}

	/**
	 * 编辑航班信息
	 * @param flightinfo:pojo
	 * @return
	 */
	@Transactional
	public Integer editFlightInfo(Flightinfo flightinfo) {
		return this.flightInfoMapper.editFlightInfo(flightinfo);
	}

	/**
	 * 删除航班信息
	 * @param flightNo:航班号
	 * @return
	 */
	@Transactional
	public Integer delFlightInfo(String flightNo) {
		return this.flightInfoMapper.delFlightInfo(flightNo);
	}

	/**
	 * 获取当前页码实例
	 * @param pageIndex:当前页码
	 * @param pageSize:每页显示的数据量
	 * @param start:起始地
	 * @param dest:目的地
	 *  @param startTime:出发日期
	 * @return
	 */
	public PageTool<Flightinfo> getPageInfo(Integer pageIndex, Integer pageSize, Integer start, Integer dest,
			String startTime) {
		PageTool<Flightinfo> pageTool=new PageTool<Flightinfo>();
		pageTool.setPageIndex(pageIndex);
		pageTool.setPageSize(pageSize);
		pageTool.setDataCount(this.getFlightDataCount(start, dest, startTime));
		pageTool.setData_list(this.flightinfosPage((pageIndex-1)*pageSize, pageSize, start, dest, startTime));
		return pageTool;
	}

	/**
	 * 生成航班号码
	 * @return
	 */
	public String getPrimarykey() {
		String flightNo=this.flightInfoMapper.getPrimarykey();
		String number=flightNo.substring(2);//截取航班号中的数字
		Integer newNumber=Integer.parseInt(number)+1;
		String newString= String.format("%04d",newNumber);
		String newFlightNo=flightNo.substring(0,2)+newString;
		return newFlightNo;
	}

	/**
	 * 根据航班号获取航班信息
	 * @param flightNo
	 * @return
	 */
	public Flightinfo getFlightInfo(String flightNo) {
		return this.flightInfoMapper.getFlightInfo(flightNo);
	}

}
