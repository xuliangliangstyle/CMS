package com.xll.service.impl;
/**
 * ArticleService实现类
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.mapper.ArticleMapper;
import com.xll.po.Article;
import com.xll.service.ArticleService;
@Service(value="articleService")
public class ArticleServiceImpl implements ArticleService{
	@Resource
    ArticleMapper articleMapper;
	@Override
	public Article select_ID(Integer id) {
		return articleMapper.select_ID(id);
	}
	@Override
	public List<Article> dyQueryAll(Article article) {
		return articleMapper.dyQueryAll(article);
	}
	@Override
	public int update_ID(Article article) {
		return articleMapper.update_ID(article);
	}
	@Override
	public int insert_tv(Article article) {
		return articleMapper.insert_tv(article);
	}
	@Override
	public int update_ID_pageview(Integer id) {
		return articleMapper.update_ID_pageview(id);
	}
	@Override
	public int dyQueryAllCount(Article article) {
		return articleMapper.dyQueryAllCount(article);
	}

}
