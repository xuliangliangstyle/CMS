package com.xll.mapper;

import java.util.List;

import com.xll.po.Atctype;

/**
 * 文章分类持久层接口
 * @author Administrator
 *
 */

public interface AtcMapper {
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
