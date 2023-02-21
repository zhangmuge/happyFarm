package com.zqsoft.dao;

import java.util.ArrayList;
import java.util.List;

import com.zqsoft.bean.UserBean;
import com.zqsoft.utils.FileUtils;

// 用户基本信息读写操作
public class UserDAO {
	private String fileName="user/userDataBase.txt";
	
	// 读取用户基本信息文本文件，所有的用户信息
	public List<UserBean> getAllUsers(){
		List<UserBean> allUsers=new ArrayList<UserBean>();
		List<String> list=FileUtils.readFile(fileName);
		for(String str:list) {
			UserBean user=new UserBean();
			String[] t=str.split(";");
			user.setUserId(t[0]);// 用户编号
			user.setUserName(t[1]);// 用户登录名
			user.setPassword(t[2]);// 登陆密码
			user.setNickName(t[3]);// 昵称
			user.setUserModText(t[4]);// 个性签名
			user.setPic(t[5]);// 用户头像
			user.setNotice(t[6]);//用户公告信息
			allUsers.add(user);
		}

		return allUsers;
	}
	
	// 保存所有用户信息
	public void saveUser(List<UserBean> allUsers) {	
		String str="";
		for(UserBean user:allUsers) {
			str+= user.getUserId()+";"+user.getUserName()+";"+user.getPassword()+
					";"+user.getNickName()+";"+user.getUserModText()+
					";"+user.getPic()+";"+user.getNotice()+"\n";
		}
		FileUtils.writeFile(fileName,str);
		return;
	}
}
