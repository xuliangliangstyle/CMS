package com.xll.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.mapper.AtcMapper;
import com.xll.po.Atctype;
import com.xll.service.AtcService;

/**
 * 类别实体类
 * @author Administrator
 *
 */
@Service(value="atcService")
public class AtcServiceImpl implements AtcService{
	@Resource
    AtcMapper atcMapper;
	@Override
	public Atctype select_ID(Integer id) {
		// TODO Auto-generated method stub
		return atcMapper.select_ID(id);
	}

	@Override
	public List<Atctype> queryAll() {
		// TODO Auto-generated method stub
		return atcMapper.queryAll();
	}

}
