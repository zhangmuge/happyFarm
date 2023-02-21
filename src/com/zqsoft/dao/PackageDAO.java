package com.zqsoft.dao;

import java.util.ArrayList;
import java.util.List;

import com.zqsoft.bean.PackageItemBean;
import com.zqsoft.guiHelper.bean.PackageItem;
import com.zqsoft.utils.FileUtils;

// 解析用户包裹数据文件
public class PackageDAO {
	
	public List<PackageItem> getUserPackage(int userId){
		List<PackageItem> userPackages=new ArrayList<>();
		String filepath="user/userdetails/"+userId+"_package.txt";
		List<String> list=FileUtils.readFile(filepath);

		for(String str:list) {
			String[] tmp=str.split(":");
			int id=Integer.parseInt(tmp[0]);
			int count=Integer.parseInt(tmp[1]);
			PackageItemBean item=new PackageItemBean();
			item.setCropBeanId(id);
			item.setItemCount(count);
			userPackages.add(item);
		}
		
		return userPackages;
	}

}
