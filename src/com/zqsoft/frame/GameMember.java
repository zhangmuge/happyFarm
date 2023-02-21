package com.zqsoft.frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zqsoft.bean.CropBean;
import com.zqsoft.bean.ShopItemBean;
import com.zqsoft.bean.UserBean;
import com.zqsoft.bean.UserData;
import com.zqsoft.dao.CropDAO;
import com.zqsoft.dao.PackageDAO;
import com.zqsoft.guiHelper.FaceHelper;
import com.zqsoft.guiHelper.GameHelper;
import com.zqsoft.guiHelper.bean.PackageItem;
import com.zqsoft.guiHelper.bean.ShopItem;

// 存放用户相关数据
public class GameMember {
	private static GameHelper gameHelper = new GameHelper();
	public static UserBean loginUser;
	public static UserData userData;
	private static List<CropBean> allcropBean=null;
	public static List<PackageItem> allUserPackages=null;// 保存当前用户的包裹信息

	public static void main(String[] args) {
		loadUserWin();
		loadUserData();
		loadBackGround();
		loadShop();
		loadUserPackage();
	}

	/**
	 * 用于加载登陆窗口
	 */
	public static void loadUserWin(){
		UserWin userWin=new UserWin();
		gameHelper.loadMod(userWin);
	}

	/**
	 * 加载用户游戏数据
	 */
	public static void loadUserData() {
		FaceHelper.setExp(String.valueOf(userData.getExp()));
		FaceHelper.setLevel(String.valueOf(userData.getUserLevel()));
		FaceHelper.setMoney(String.valueOf(userData.getMoney()));
		FaceHelper.setBoardText(loginUser.getNotice());
	}

	/**
	 * 用户加载游戏背景
	 */
	public static void loadBackGround() {
		List<String> list=new ArrayList<String>();
		list.add("resources/background/1.png");
		list.add("resources/background/2.png");
		list.add("resources/background/3.png");
		list.add("resources/background/4.png");
		gameHelper.setBackground(list);
	}

	/**
	 * 加载商店明细信息
	 */
	public static void loadShop() {
		List<ShopItem> list=new ArrayList<>();
		CropDAO cropDAO=new CropDAO();
		allcropBean=cropDAO.getAllCrops();
		for(CropBean c:allcropBean) {
			ShopItemBean shopItemBean=new ShopItemBean(c);
			list.add(shopItemBean);
		}
		Collections.sort(list, new Comparator<ShopItem>() {
			public int compare(ShopItem o1,ShopItem o2) {
				if(o1.getItemBuyLevel()!=o2.getItemBuyLevel())
					return o1.getItemBuyLevel()-o2.getItemBuyLevel();
				return Integer.parseInt(o1.getItemPrice())-Integer.parseInt(o2.getItemPrice());
			}
		});
		gameHelper.setShopItemList(list);
	}
	
	/**
	 * 获取农作物对象
	 */
	public static CropBean getCropBean(int cropId) {
		for(CropBean cropBean:allcropBean) {
			if(cropId==cropBean.getCropId()) 
				return cropBean;
		}
		return null;
	}
	
	/**
	 * 加载用户的包裹信息
	 */
	public static void loadUserPackage() {
		PackageDAO packageDAO=new PackageDAO();
		allUserPackages=packageDAO.getUserPackage(Integer.parseInt(loginUser.getUserId()));
		gameHelper.setPackageItemList(allUserPackages);
	}
}
