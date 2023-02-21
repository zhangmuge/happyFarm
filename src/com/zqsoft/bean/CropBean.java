package com.zqsoft.bean;

import java.util.ArrayList;
import java.util.List;

// 农作物类
public class CropBean{
	private int cropId;// 农作物编号
	private String cropName;// 农作物名称
	private String seedPic;// 农作物种子图片
	private int stage;// 农作物总的生长阶段
	private int sellPrice;// 农作物成熟之后的销售金币数
	private int price;// 农作物种子在商店中的购买金币数
	private int buyLevel;// 农作物种子在商店中的购买级别
	private List<String> allStagePic=new ArrayList<>();// 农作物所有阶段图
	private List<Integer> allStageTime=new ArrayList<>();// 农作物每个阶段需要的时间
	private String beginPic;// 开始播种时在土地上显示图片
	private String endPic;// 农作物摘取之后显示图片
	
	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getSeedPic() {
		return seedPic;
	}

	public void setSeedPic(String seedPic) {
		this.seedPic = seedPic;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBuyLevel() {
		return buyLevel;
	}

	public void setBuyLevel(int buyLevel) {
		this.buyLevel = buyLevel;
	}

	public List<String> getAllStagePic() {
		return allStagePic;
	}

	public void setAllStagePic(List<String> allStagePic) {
		this.allStagePic = allStagePic;
	}

	public List<Integer> getAllStageTime() {
		return allStageTime;
	}

	public void setAllStageTime(List<Integer> allStageTime) {
		this.allStageTime = allStageTime;
	}

	public String getBeginPic() {
		return beginPic;
	}

	public void setBeginPic(String beginPic) {
		this.beginPic = beginPic;
	}

	public String getEndPic() {
		return endPic;
	}

	public void setEndPic(String endPic) {
		this.endPic = endPic;
	}
	
}
