package com.zqsoft.frame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.zqsoft.bean.UserBean;
import com.zqsoft.dao.UserDAO;
import com.zqsoft.dao.UserDataDAO;
import com.zqsoft.guiHelper.net.bean.UserItem;
import com.zqsoft.guiHelper.net.bean.UserWindow;
import com.zqsoft.utils.FileUtils;

public class UserWin implements UserWindow {	
	private List<UserBean> allUsers;
	UserDAO userDAO=new UserDAO();
	
	public UserWin() {
		allUsers=userDAO.getAllUsers();
	}
	
	@Override
	public boolean changePassword(String uN, String oP, String nP, String cP) {
		// TODO Auto-generated method stub
		if(!GameMember.loginUser.getPassword().equals(oP)) {
			JOptionPane.showMessageDialog(null,"旧密码不正确");
			return false;
		}
		if(nP.length()<6||nP.length()>12) {
			JOptionPane.showMessageDialog(null,"密码长度必须在6-12位之间");
			return false;
		}
		if(!cP.equals(nP)) {
			JOptionPane.showMessageDialog(null,"确认密码必须和密码相同");
			return false;
		}
		for(UserBean user:allUsers) {
			if(user.getUserName().equals(uN)) {
				user.setPassword(nP);
				userDAO.saveUser(allUsers);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean changeUserInfo(String uN, String uMT, String nN, String hP, String notice) {
		// TODO Auto-generated method stub
		allUsers.remove(GameMember.loginUser);
		GameMember.loginUser.setUserModText(uMT);
		GameMember.loginUser.setUserName(uN);
		GameMember.loginUser.setNickName(nN);
		GameMember.loginUser.setPic(hP); 
		GameMember.loginUser.setNotice(notice);
		allUsers.add(GameMember.loginUser);
		userDAO.saveUser(allUsers);
		return true;
	}

	@Override
	public List<String> getUserFaceList() {
		// TODO Auto-generated method stub
		String filepath="resources/head";
		File file=new File(filepath);
		String[] names=file.list();
		List<String> list=new ArrayList<String>();
		for(String str:names) {
			String t=filepath+"/"+str;
			list.add(t);
		}
		return list;
	}

	@Override
	public List<UserItem> getUserList() {
		// TODO Auto-generated method stub
		List<UserItem> users=new ArrayList<UserItem>();
		for(UserBean user:allUsers) {
			users.add(user);
		}
		users.remove(GameMember.loginUser);
		users.add(0,GameMember.loginUser);
		return users;
	}

	@Override
	public boolean loginCheckUser(String uN, String pw) {
		// TODO Auto-generated method stub
		if(uN.length()<3||uN.length()>10){
			JOptionPane.showMessageDialog(null,"用户名长度必须在3-10位之间");
			return false;
		}
		if(pw.length()<6||pw.length()>12){
			JOptionPane.showMessageDialog(null,"密码长度必须在6-12位之间");
			return false;
		}
		for(UserBean user:allUsers) {
			if(user.getUserName().equals(uN)) {
				if(user.getPassword().equals(pw)) {
					GameMember.loginUser=user;
					UserDataDAO userDataDAO=new UserDataDAO();
					GameMember.userData=userDataDAO.getUserData(user.getUserId());
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null,"密码不正确，请重新输入");
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"用户名不存在，请重新输入");
		return false;
	}

	@Override
	public boolean registerUser(String uN, String pw, String cP) {
		// TODO Auto-generated method stub
		if(uN.length()<3||uN.length()>10){
			JOptionPane.showMessageDialog(null,"用户名长度必须在3-10位之间");
			return false;
		}
		if(pw.length()<6||pw.length()>12){
			JOptionPane.showMessageDialog(null,"密码长度必须在6-12位之间");
			return false;
		}
		if(!pw.equals(cP)) {
			JOptionPane.showMessageDialog(null,"确认密码必须和密码相同");
			return false;
		}
		for(UserBean user:allUsers)
			if(user.getUserName().equals(uN)) {
				JOptionPane.showMessageDialog(null,"该用户名已经被注册");
				return false;
			}
		UserBean user=new UserBean();
		user.setUserName(uN);
		user.setNickName(uN);
		user.setPassword(pw);
		user.setPic("resources/head/1-1.GIF");
		user.setNotice("翔哥菜地");
		user.setUserModText("空");
		Random r=new Random();
		int id=r.nextInt(1000000);
		user.setUserId(id+"");
		allUsers.add(user);
		UserDAO userDAO=new UserDAO();
		userDAO.saveUser(allUsers);
		String path="user/userdetails/"+id+"_package.txt";
		String str="1:6\n3:11";
		FileUtils.writeFile(path, str);
		return true;
	}
}
