package com.dhee.six.vo;

public class Qa {
	
	
	@Override
	public String toString() {
		return "Qa [id=" + id + ", question_id=" + question_id + ", question_answer=" + question_answer
				+ ", question_name=" + question_name + ", user_id=" + user_id + "]";
	}
	private String id;
	private String question_id;
	private String question_answer;
	private String question_name;
	private String user_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	
	
	

}
