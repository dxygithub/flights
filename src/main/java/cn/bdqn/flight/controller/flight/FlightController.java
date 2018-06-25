package cn.bdqn.flight.controller.flight;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.bdqn.flight.service.flight.IFlightService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import ch.qos.logback.classic.Logger;
import cn.bdqn.flight.pojo.Flightinfo;
import cn.bdqn.flight.service.flight.IFlightService;
import cn.bdqn.flight.util.PageTool;

/**
 * 航班信息controller
 * @author DELL
 *
 */
@Controller
@RequestMapping("/flight")
public class FlightController {
	Logger logger=(Logger)LoggerFactory.getLogger(FlightController.class);
	@Resource(name="flightServiceImpl")
	private IFlightService flightService;
	
	
	/**
	 * 进入航班信息首页
	 * @return
	 */
	@RequestMapping("/index.htm")
	public String inIndexPage() {
		return "index";
	}
	
	/**
	 * 自动生成航班号
	 * @return
	 */
	@RequestMapping("/getFlightNo")
	@ResponseBody
	public String getFlightNo() {
		String newFlightNo=this.flightService.getPrimarykey();//获取自动生成的航班号码
		return newFlightNo;
	}
	
	/**
	 * 根据航班号获取航班信息
	 * @return
	 */
	@RequestMapping("/getFlight")
	@ResponseBody
	public String getFlight(@RequestParam("flightNo")String flightNo) {
		Flightinfo flightinfo=this.flightService.getFlightInfo(flightNo);
		String json=JSON.toJSONString(flightinfo);
		return json;
	}
	
	/**
	 * 获取当前页码航班信息
	 * @return
	 */
	@RequestMapping("/getPageInfo")
	@ResponseBody
	public String getPageInfo(
			@RequestParam(value="pageIndex",required=false)Integer pageIndex,
			@RequestParam(value="start",required=false)Integer start,
			@RequestParam(value="dest",required=false)Integer dest,
			@RequestParam(value="startTime",required=false)String startTime) {
		logger.info("======================start======================");
		Long startTimes=System.currentTimeMillis();//获取方法开始毫秒数
		PageTool<Flightinfo> pageTool=this.flightService.getPageInfo(pageIndex,5, start, dest, startTime);
		String json=JSON.toJSONString(pageTool);
		Long endTimes=System.currentTimeMillis();//获取方法结束毫秒数a
		logger.error("test error!!!");
		logger.debug("constTimes:[{}ms]",startTimes-endTimes);//输出方法执行时长
		logger.info("======================end======================");
		return json;
	}
	
	/**
	 * 保存航班信息
	 * @return
	 */
	@RequestMapping("/saveFlightInfo")
	@ResponseBody
	public String saveFlightIn4fo(Flightinfo flightinfo) {
		String json="";
		Integer result=this.flightService.saveFlightInfo(flightinfo);
		if(result>0) {
			json="ok";
		}else {
			json="no";
		}
		return json;
	}
	
	/**
	 * 编辑航班信息
	 * @param flightinfo
	 * @return
	 */
	@RequestMapping("/editFlightInfo")
	@ResponseBody
	public String editFlightInfo(Flightinfo flightinfo) {
		String json="";
		Integer result=this.flightService.editFlightInfo(flightinfo);
		if(result>0) {
			json="ok";
		}else {
			json="no";
		}
		return json;
	}
	
	/**
	 * 删除航班信息
	 * @return
	 */
	@RequestMapping("/delFlightInfo")
	@ResponseBody
	public String delFlightInfo(@RequestParam("flightNo")String flightNo) {
		String json="";
		Integer result=this.flightService.delFlightInfo(flightNo);
		if(result>0) {
			json="ok";
		}else {
			json="no";
		}
		return json;
	}
	
}
