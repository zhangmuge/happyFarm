package com.zqsoft.dao;

import java.util.List;

import com.zqsoft.bean.UserData;
import com.zqsoft.utils.FileUtils;

// 用户游戏数据对象的读写操作
public class UserDataDAO {
	
	public UserData getUserData(String userId) {
		String filepath="user/userdetails/"+userId+"_data.txt";
		UserData userData=new UserData();
		
		List<String> list=FileUtils.readFile(filepath);
		if(list.size()==0) {
			userData.setExp(0);
			userData.setMoney(200);
			FileUtils.writeFile(filepath,0+";"+200);
		}
		else {
			String str=list.get(0);
			String[] t=str.split(";");
			userData.setExp(Integer.parseInt(t[0]));
			userData.setMoney(Integer.parseInt(t[1]));
		}

		return userData;
	}
	
	public void updateUserData(UserData data)
    {
        String userid=data.getUserId()+"";
        String filepath="user/userDetails/"+userid+"_data.txt";
        FileUtils.clearFile(filepath);
        String t=data.toString();
        FileUtils.writeFile(filepath,t);
    }
}
