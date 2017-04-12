package com.xll.mapper;

import java.util.List;

import com.xll.po.Article;

/**
 * 文章持久层接口
 * @author Administrator
 *
 */

public interface ArticleMapper {
	/**
	 * 根据ID查询文章信息（包含作者）
	 * @param id
	 * @return Article
	 */
	Article select_ID(Integer id);
	/**
	 * 动态查询全部
	 * @param article
	 * @return List<Article>
	 */
	List<Article> dyQueryAll(Article article);
	/**
	 * 修改文章
	 * @param article
	 * @return int
	 */
	int update_ID(Article article);
	/**
	 * 添加文章
	 * @param article
	 * @return int
	 */
	int insert_tv(Article article);
	/**
	 * 更新浏览量
	 * @param id
	 * @return int
	 */
	int update_ID_pageview(Integer id);
	/**
	 * 动态查询条数
	 * @param article
	 * @return int
	 */
	int dyQueryAllCount(Article article);

}
