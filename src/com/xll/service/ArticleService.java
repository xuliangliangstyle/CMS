package com.xll.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.mapper.ArticleMapper;
import com.xll.po.Article;

/**
 * 文章业务逻辑层
 * @author Administrator
 *
 */
public interface ArticleService {
	/**
	 * 根据ID查询文章（包含作者）
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
