package com.zqsoft.bean;

import com.zqsoft.guiHelper.bean.ShopItem;

// 商店明细类
public class ShopItemBean implements ShopItem{
	private int itemBuyLevel;
	private String itemName;
	private String itemPic;
	private String itemPrice;
	
	public ShopItemBean(CropBean cropBean) {
		this.itemBuyLevel=cropBean.getBuyLevel();
		this.itemName=cropBean.getCropName();
		this.itemPic=cropBean.getSeedPic();
		this.itemPrice=cropBean.getPrice()+"";
	}

	@Override
	public int buyItem(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doBuyItem(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getItemBuyLevel() {
		// TODO Auto-generated method stub
		return this.itemBuyLevel;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return this.itemName;
	}

	@Override
	public String getItemPic() {
		// TODO Auto-generated method stub
		return this.itemPic;
	}

	@Override
	public String getItemPrice() {
		// TODO Auto-generated method stub
		return this.itemPrice;
	}

	@Override
	public boolean itemClick() {
		// TODO Auto-generated method stub
		return false;
	}
}
