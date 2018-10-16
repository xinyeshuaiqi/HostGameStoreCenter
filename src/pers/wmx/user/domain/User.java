package pers.wmx.user.domain;

import java.util.HashSet;
import java.util.Set;

import pers.wmx.reply.domain.Reply;

public class User {
	
	private int id; // �û����
	private String username; // �û�����
	private String password; // �û�����
	private String gender; // �û��Ա�
	private String email; // �û�����
	private String telephone; // �û���ϵ�绰
	private String activeCode; // ������   
	private String role; // �û���ɫ
	private int state; // �û�״̬      Ĭ��Ϊ0��δ��������Ϊ1
	
	//һ�Զ�
	private Set<Reply> replySet = new HashSet<Reply>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Set<Reply> getReplySet() {
		return replySet;
	}
	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}
	
	
}
