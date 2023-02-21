package com.zqsoft.bean;

import com.zqsoft.guiHelper.net.bean.UserItem;

// 用户基本信息类
public class UserBean implements UserItem{
	private String userId;// 用户编号
	private String userName;// 用户登录名
	private String password;// 登陆密码
	private String nickName;// 昵称
	private String userModText;// 个性签名
	private String pic;// 用户头像
	private String notice;// 用户公告信息
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setUserModText(String userModText) {
		this.userModText = userModText;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Override
	public String getNickName() {
		// TODO Auto-generated method stub
		return nickName;
	}
	@Override
	public String getPic() {
		// TODO Auto-generated method stub
		return pic;
	}
	@Override
	public String getUserModText() {
		// TODO Auto-generated method stub
		return userModText;
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public void itemClick() {
		// TODO Auto-generated method stub
		
	}
	
	
}
