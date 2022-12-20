package com.green.nowon.domain.dto.goods;

import java.util.ArrayList;
import java.util.List;

import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsImg;
import com.green.nowon.utils.MyFileUtils;

import lombok.Data;

@Data
public class GoodsInsertDTO {
	
	private long[]  categoryNo;
	
	private String title;
	private String content;
	private int price;
	private int stock;
	
	private String[] newName;
	private String[] orgName;
	
	private long size;
	
	public List<GoodsImg> toGoodsImgs(GoodsEntity goods,String url) {
		List<GoodsImg> imgs=new ArrayList<>();
		for(int i=0; i<orgName.length; i++) {
			if(orgName[i].equals("") || orgName[i]==null)continue;
			boolean def=false;
			if(i==0)def=true;
			GoodsImg ent=GoodsImg.builder()
					.url(url)
					.orgName(orgName[i])
					.newName(newName[i])
					.def(def)
					.goods(goods)//fk설정을 위한
					.size(size)
					.build();
			imgs.add(ent);
		}
		
		//temp 폴더 상위폴더인 upload로 이동
		MyFileUtils.moveUploadLocationFromTemp(newName,url);
		
		return imgs;
	}
	
	
	
	public GoodsEntity entity() {
		return GoodsEntity.builder()
				.title(title)
				.content(content)
				.price(price)
				.stock(stock)
			.build();
	}
	
}
