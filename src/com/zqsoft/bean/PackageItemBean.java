package com.zqsoft.bean;

import com.zqsoft.guiHelper.bean.PackageItem;

// 包裹明细
public class PackageItemBean implements PackageItem{
	private CropBean cropBean=new CropBean();// 种子信息来源
	private int ItemCount;// 种子数量
	
	@Override
	public void cancelClick() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return ItemCount;
	}
	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return cropBean.getCropName();
	}
	@Override
	public String getItemPic() {
		// TODO Auto-generated method stub
		return cropBean.getSeedPic();
	}
	@Override
	public boolean itemClick() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCropId() {
		return cropBean.getCropId();
	}
	
	public void setItemCount(int Item_count) {
		this.ItemCount=Item_count;
	}
	
	public void setCropBeanId(int id) {
		this.cropBean.setCropId(id);
	}
}
