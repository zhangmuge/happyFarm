package com.zqsoft.bean;

// 用户游戏数据对象
public class UserData {
	private int exp;// 经验
	private int money;// 金币
	private int userId;// 用户id
	
	// 根据用户经验计算用户的游戏等级
	public int getUserLevel() {
		return 0;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
