package com.imooc.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.common.utils.IMoocJSONResult;
import com.imooc.web.service.BuyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description: 订购商品controller
 */
@Controller
@Api(value = "下单控制器", description = "购买信息")
public class BuyController {
	
	@Autowired
	private BuyService buyService;
	
	@RequestMapping("/index")
	@ApiOperation(value = "首页", notes = "首页")
	public String index() {
		return "index";
	}
	
	@GetMapping("/buy")
	@ApiOperation(value = "购买", notes = "buy")
	@ResponseBody
	public IMoocJSONResult doGetlogin(String itemId) {
		
		if (StringUtils.isNotBlank(itemId)) {
			buyService.doBuyItem(itemId);
		} else {
			return IMoocJSONResult.errorMsg("商品id不能为空");
		}
		
		return IMoocJSONResult.ok();
	}
	
}
