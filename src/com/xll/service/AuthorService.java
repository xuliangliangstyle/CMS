package com.xll.service;

import com.xll.po.Author;

/**
 * 作者业务逻辑层接口
 * @author Administrator
 *
 */

public interface AuthorService {
	/**
	 * 根据ID查询作者
	 * @param id
	 * @return Author
	 */
	Author select_ID(Integer id);

}
