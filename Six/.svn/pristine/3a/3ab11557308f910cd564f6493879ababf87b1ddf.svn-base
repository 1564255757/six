package com.dhee.six.vo;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 公告实体类
 * 作者：赵禹博
 * 完成：2018-08-15
 */
public class Notices {
	/*公告id*/
	private String notice_id;
	/*公告标题*/
	private String notice_title;
	/*公告发布时间*/
	private Date notice_time;
	private String notice_time_toString;
	/*公告内容*/
	private String notice_context;
	public String getNotice_time_toString() {
		if(notice_time!=null){
			return new SimpleDateFormat("yyyy-MM-dd").format(notice_time);
		}
		return notice_time_toString;
	}
	public void setNotice_time_toString(String notice_time_toString) {
		this.notice_time_toString = notice_time_toString;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	public String getNotice_context() {
		return notice_context;
	}
	public void setNotice_context(String notice_context) {
		this.notice_context = notice_context;
	}
	

}
