package cn.bdqn.flight.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * The persistent class for the flightinfo database table.
 * 
 */
public class Flightinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String filghtId;
	@JSONField(format="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date arriveTime;
	private Integer destination;
	private Integer origin;
	private String originInfo;
	private String destinationInfo;
	private BigDecimal price;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date takeOffTime;

	public String getOriginInfo() {
		return originInfo;
	}


	public void setOriginInfo(String originInfo) {
		this.originInfo = originInfo;
	}


	public String getDestinationInfo() {
		return destinationInfo;
	}


	public void setDestinationInfo(String destinationInfo) {
		this.destinationInfo = destinationInfo;
	}


	public Flightinfo() {
	}


	public String getFilghtId() {
		return this.filghtId;
	}

	public void setFilghtId(String filghtId) {
		this.filghtId = filghtId;
	}


	public Date getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}


	public Integer getDestination() {
		return this.destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}


	public Integer getOrigin() {
		return this.origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}


	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Date getTakeOffTime() {
		return this.takeOffTime;
	}

	public void setTakeOffTime(Date takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

}