package com.dhee.six.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 企业实体类
 * 作者：尹希栋，李治鑫，贺丽萍，葛文涛
 * 完成时间：2019/08/15
 */
public class Corporate {
	
	
	@Override
	public String toString() {
		return "Corporate [corporate_id=" + corporate_id + ", corporate_name=" + corporate_name
				+ ", corporate_legal_person=" + corporate_legal_person + ", corporate_scope=" + corporate_scope
				+ ", scope_name=" + scope_name + ", corporate_base=" + corporate_base + ", base_name=" + base_name
				+ ", corporate_time=" + corporate_time + ", corporate_phone=" + corporate_phone
				+ ", corporate_textarea=" + corporate_textarea + ", corporate_state=" + corporate_state
				+ ", corporate_click=" + corporate_click + ", corporate_apply_time=" + corporate_apply_time
				+ ", corporate_address=" + corporate_address + ", corporate_logo_path=" + corporate_logo_path
				+ ", corporate_logo_name=" + corporate_logo_name + "]";
	}
	/*企业id*/
	private String corporate_id;
	/*企业id*/
	private List<Qa> qa;
	/*企业账户名*/
	private String corporate_username;
	/*企业账户密码*/
	private String corporate_password;
	/*企业名*/
	private String corporate_name;
	/*企业法人名*/
	private String corporate_legal_person;
	/*企业经营范围id*/
	private String corporate_scope;
	/*企业经营范围名*/
	private String scope_name;
	/*企业所属基地id*/
	private String corporate_base;
	/*企业所属基地名*/
	private String base_name;
	/*企业成立时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date corporate_time;
	/*企业成立时间*/
	private String corporate_time_toString;
	/*企业电话*/
	private String corporate_phone;
	/*企业电话区号*/
	private String corporate_area;
	/*企业电话后八位*/
	private String corporate_number;
	/*企业简介*/
	private String corporate_textarea;
	/*企业审核状态*/
	private int corporate_state;
	/*企业注册时间字符串*/
	private String corporate_apply_time_toString;
	/*企业点击量*/
	private int corporate_click;
	/*企业注册时间*/
	private Date corporate_apply_time;
	/*企业地址*/
	private String corporate_address;
	/*企业logo路径*/
	private String corporate_logo_path;
	/*企业logo名*/
	private String corporate_logo_name;
	
	public String getCorporate_time_toString() {
		if(corporate_time!=null){
			return new SimpleDateFormat("yyyy-MM-dd").format(corporate_time);
		}
		return null;
	}
	public String getCorporate_apply_time_toString() {
		if(corporate_apply_time!=null){
			return new SimpleDateFormat("yyyy-MM-dd").format(corporate_apply_time);
		}
		return null;
	}
	public void setCorporate_time_toString(String corporate_time_toString) {
		this.corporate_time_toString = corporate_time_toString;
	}
	public String getCorporate_id() {
		return corporate_id;
	}
	public void setCorporate_id(String corporate_id) {
		this.corporate_id = corporate_id;
	}
	public String getScope_name() {
		return scope_name;
	}
	public void setScope_name(String scope_name) {
		this.scope_name = scope_name;
	}
	public String getBase_name() {
		return base_name;
	}
	public void setBase_name(String base_name) {
		this.base_name = base_name;
	}
	public String getCorporate_username() {
		return corporate_username;
	}
	public void setCorporate_username(String corporate_username) {
		this.corporate_username = corporate_username;
	}
	public String getCorporate_password() {
		return corporate_password;
	}
	
	public String getCorporate_area() {
		return corporate_area;
	}
	public void setCorporate_area(String corporate_area) {
		this.corporate_area = corporate_area;
	}
	public String getCorporate_number() {
		return corporate_number;
	}
	public void setCorporate_number(String corporate_number) {
		this.corporate_number = corporate_number;
	}
	public void setCorporate_password(String corporate_password) {
		this.corporate_password = corporate_password;
	}
	public String getCorporate_name() {
		return corporate_name;
	}
	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}
	
	public int getCorporate_click() {
		return corporate_click;
	}
	public void setCorporate_click(int corporate_click) {
		this.corporate_click = corporate_click;
	}
	public String getCorporate_legal_person() {
		return corporate_legal_person;
	}
	public void setCorporate_legal_person(String corporate_legal_person) {
		this.corporate_legal_person = corporate_legal_person;
	}
	public String getCorporate_scope() {
		return corporate_scope;
	}
	public void setCorporate_scope(String corporate_scope) {
		this.corporate_scope = corporate_scope;
	}
	public String getCorporate_base() {
		return corporate_base;
	}
	public void setCorporate_base(String corporate_base) {
		this.corporate_base = corporate_base;
	}
	public Date getCorporate_time() {
		return corporate_time;
	}
	public void setCorporate_time(Date corporate_time) {
		this.corporate_time = corporate_time;
	}
	public String getCorporate_phone() {
		return corporate_phone;
	}
	public void setCorporate_phone(String corporate_phone) {
		this.corporate_phone = corporate_phone;
	}
	public String getCorporate_textarea() {
		return corporate_textarea;
	}
	public void setCorporate_textarea(String corporate_textarea) {
		this.corporate_textarea = corporate_textarea;
	}
	public int getCorporate_state() {
		return corporate_state;
	}
	public void setCorporate_state(int corporate_state) {
		this.corporate_state = corporate_state;
	}
	public Date getCorporate_apply_time() {
		return corporate_apply_time;
	}
	public void setCorporate_apply_time(Date corporate_apply_time) {
		this.corporate_apply_time = corporate_apply_time;
	}
	public String getCorporate_address() {
		return corporate_address;
	}
	public void setCorporate_address(String corporate_address) {
		this.corporate_address = corporate_address;
	}
	public String getCorporate_logo_path() {
		return corporate_logo_path;
	}
	public void setCorporate_logo_path(String corporate_logo_path) {
		this.corporate_logo_path = corporate_logo_path;
	}
	public String getCorporate_logo_name() {
		return corporate_logo_name;
	}
	public void setCorporate_logo_name(String corporate_logo_name) {
		this.corporate_logo_name = corporate_logo_name;
	}
	public List<Qa> getQa() {
		return qa;
	}
	public void setQa(List<Qa> qa) {
		this.qa = qa;
	}
	

	
}
