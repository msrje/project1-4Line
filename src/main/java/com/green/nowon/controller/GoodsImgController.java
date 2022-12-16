package com.green.nowon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.service.GoodsImgService;
	
@Controller
public class GoodsImgController {
	
	@Autowired
	private GoodsImgService service;
	
	@ResponseBody//응답데이터를 json타입으로 리턴합니다. 
	@PostMapping("/admin/temp-upload")
	public Map<String,String> tempUpload(MultipartFile gimg) {
		return service.fileTempUpload(gimg);
	}

}
