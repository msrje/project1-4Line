package com.green.nowon.domain.dto.admin;

import com.green.nowon.domain.entity.GoodsImgEntity;

import lombok.Getter;

@Getter
public class GoodsImgDTO {
	
	private long fno;
	private String orgName;
	private String newName;
	private String url;
	private long size;
	//편의필드
	private String imgUri;
	
	public GoodsImgDTO(GoodsImgDTO e) {
		this.fno = e.getFno();
		this.orgName = e.getOrgName();
		this.newName = e.getNewName();
		this.url = e.getUrl();
		this.size = e.getSize();
		
		this.imgUri = url+newName;
	}


}
