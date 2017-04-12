package com.xll.service;
/**
 * 类别业务逻辑层
 */

import java.util.List;

import com.xll.po.Atctype;

public interface AtcService {
	/**
	 * 根据ID查询分类
	 * @param id
	 * @return Atc_type
	 */
	Atctype select_ID(Integer id);
	/**
	 * 查询全部
	 * @return List<Atctype>
	 */
	List<Atctype> queryAll();

}
