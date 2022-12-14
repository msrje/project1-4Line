package com.green.nowon.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.service.GoodsImgService;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsimgServiceProcess implements GoodsImgService {

	@Value("${file.location.temp}")
	private String locationTemp;
	
	@Override
	public Map<String, String> fileTempUpload(MultipartFile gimg) {

		return MyFileUtils.fileUpload(gimg, locationTemp);
	}




}
