package com.xll.mapper;
/**
 * 作者持久层接口
 */


import com.xll.po.Author;

public interface AuthorMapper {
	/**
	 * 根据ID查询作者信息
	 * @param id
	 * @return Author
	 */
	Author select_ID(Integer id);

}
