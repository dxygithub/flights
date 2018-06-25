package cn.bdqn.flight.pojo;

import java.io.Serializable;


/**
 * The persistent class for the address database table.
 * 
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String addressName;

	public Address() {
	}


	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

}