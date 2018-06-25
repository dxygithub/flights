package cn.bdqn.flight.service.flight;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.flight.pojo.Flightinfo;
import cn.bdqn.flight.util.PageTool;

/**
 * 航班信息I-service
 * @author DELL
 *
 */
public interface IFlightService {
	
	/**
	 * 根据当前页码获取航班信息
	 * @param pageIndex:当前页码
	 * @param pageSize:每页显示的数据量
	 * @param start:起始地
	 * @param dest:目的地
	 *  @param startTime:出发日期
	 * @return
	 */
	List<Flightinfo> flightinfosPage(
            Integer pageIndex,
            Integer pageSize,
            Integer start,
            Integer dest,
            String startTime);
	
	/**
	 * 获取航班信息总记录数
	 * @return
	 */
	Integer getFlightDataCount(
            Integer start,
            Integer dest,
            String startTime);
	
	/**
	 * 保存航班信息
	 * @param flightinfo:pojo
	 * @return
	 */
	Integer saveFlightInfo(Flightinfo flightinfo);
	
	/**
	 * 编辑航班信息
	 * @param flightinfo:pojo
	 * @return
	 */
	Integer editFlightInfo(Flightinfo flightinfo);
	
	/**
	 * 删除航班信息
	 * @param flightNo:航班号
	 * @return
	 */
	Integer delFlightInfo(String flightNo);
	
	/**
	 * 获取当前页码实例
	 * @param pageIndex:当前页码
	 * @param pageSize:每页显示的数据量
	 * @param start:起始地
	 * @param dest:目的地
	 *  @param startTime:出发日期
	 * @return
	 */
	PageTool<Flightinfo> getPageInfo(
            Integer pageIndex,
            Integer pageSize,
            Integer start,
            Integer dest,
            String startTime);
	
	/**
	 * 生成航班号码
	 * @return
	 */
	String getPrimarykey();
	
	/**
	 * 根据航班号获取航班信息
	 * @param flightNo
	 * @return
	 */
	Flightinfo getFlightInfo(String flightNo);
}
