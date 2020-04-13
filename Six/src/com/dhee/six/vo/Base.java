package com.dhee.six.vo;
/**
 * 基地实体类
 * 作者：尹希栋，李治鑫，贺丽萍，葛文涛
 * 完成时间：2019/08/15
 */
public class Base {
	
	@Override
	public String toString() {
		return "Base [base_id=" + base_id + ", base_name=" + base_name + ", base_city=" + base_city + ", city_name="
				+ city_name + ", base_textarea=" + base_profile + "]";
	}
	/*基地id*/
	private String base_id;
	/*基地名字*/
	private String base_name;
	/*基地城市外键*/
	private String base_city;
	/*基地城市名字*/
	private String city_name;
	/*基地简介*/
	private String base_profile;
	public String getBase_id() {
		return base_id;
	}
	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}
	public String getBase_name() {
		return base_name;
	}
	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}
	public String getBase_city() {
		return base_city;
	}
	public void setBase_city(String base_city) {
		this.base_city = base_city;
	}
	public String getBase_profile() {
		return base_profile;
	}
	public void setBase_profile(String base_profile) {
		this.base_profile = base_profile;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	
	

}
