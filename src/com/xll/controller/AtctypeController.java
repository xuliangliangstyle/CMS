package com.xll.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.po.Atctype;
import com.xll.service.AtcService;
import com.xll.util.JSONUtil;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="atc",produces="text/html;charset=utf-8")
public class AtctypeController {
	private final String FALSE="false";
	@Resource
	AtcService atcService;
	@Resource
	JSONUtil jsonUtil;
	@RequestMapping(value="all")
	@ResponseBody
	public String getAll() throws Exception{
		try {
			List<Atctype> types=atcService.queryAll();		
			return jsonUtil.toJSONArray(types).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FALSE;
		}
	}

}
