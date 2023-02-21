package com.zqsoft.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.zqsoft.bean.CropBean;

// 解析农作物数据文件
public class CropDAO {
	public List<CropBean> getAllCrops(){
		List<CropBean> allCrops=new ArrayList<>();
		try {
			String filepath="resources/crops";
			File file=new File(filepath);
			String[] cropdirs=file.list();
			
			for(String str:cropdirs) {
				String path=filepath+"/"+str;
				Properties properties=new Properties();
			properties.load(new FileReader(path+"/cron.properties"));
			CropBean cropBean=new CropBean();
            cropBean.setCropId(Integer.parseInt(properties.getProperty("ITEM_ID")));
            cropBean.setCropName(properties.getProperty("ITEM_NAME"));
            cropBean.setPrice(Integer.parseInt(properties.getProperty("ITEM_PRICE")));
            cropBean.setSeedPic(path+"/"+properties.getProperty("ITEM_SEED_PIC"));
            cropBean.setStage(Integer.parseInt(properties.getProperty("ITEM_STAGE")));
            cropBean.setEndPic(path+"/"+properties.getProperty("ITEM_STAGE_END"));
            cropBean.setSellPrice(Integer.parseInt(properties.getProperty("ITEM_SELL_MONEY")));
            cropBean.setBeginPic(path+"/"+properties.getProperty("ITEM_STAGE_SEED"));
			List<String> pic=new ArrayList<>();
			List<Integer> time=new ArrayList<>();
			for(int i=1;i<=cropBean.getStage();i++)
				pic.add(path+"/"+properties.getProperty("ITEM_STAGE_"+i));

            time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_1")));
            time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_2")));
            time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_3")));
            time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_4")));
            if(properties.getProperty("ITEM_STAGE_NEXT_TIME_5")!=null)
                time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_5")));
            if(properties.getProperty("ITEM_STAGE_NEXT_TIME_6")!=null)
                time.add(Integer.parseInt(properties.getProperty("ITEM_STAGE_NEXT_TIME_6")));
            
			cropBean.setAllStagePic(pic);
			cropBean.setAllStageTime(time);
			cropBean.setBuyLevel(Integer.parseInt(properties.getProperty("ITEM_NEED_LEVEL")));
			allCrops.add(cropBean);
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return allCrops;
	}
}
