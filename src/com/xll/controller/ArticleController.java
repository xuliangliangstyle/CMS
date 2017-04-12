package com.xll.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.po.Article;
import com.xll.service.ArticleService;
import com.xll.util.JSONUtil;

/**
 * 文章控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="article",produces="text/html;charset=utf-8")
public class ArticleController {
	private final String FALSE="false";
	@Resource
	ArticleService articleService;
	@Resource
	JSONUtil jsonUtil;
	@RequestMapping(value="{ID}")
	@ResponseBody
	public String getArticleByID(@PathVariable(value="ID")Integer id){		
		try {
			Article article=articleService.select_ID(id);
			if(article!=null){
				return jsonUtil.toJSONObject(article).toString();
			}else{
				return FALSE;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return FALSE;
		}
	}
	@RequestMapping(value="look/{ID}")
	public String toLookArticle(@PathVariable(value="ID")Integer id,Model model){
		articleService.update_ID_pageview(id);
		model.addAttribute("ID",id);
		return "/look.jsp";
	}
	@RequestMapping(value="all")
	@ResponseBody
	public String getAll(Article article){
		try {
			List<Article> articles=articleService.dyQueryAll(article);
			int count=articleService.dyQueryAllCount(article);
			JSONArray jsons=new JSONArray();
			JSONObject json=new JSONObject();
			json.put("page", article.getPage());
			int pages=count/article.getPageSize();
			if(count%article.getPageSize()>0||pages==0){
				pages+=1;
			}
			json.put("pages",pages);
			jsons.put(json);
			jsons.put(jsonUtil.toJSONArray(articles));
			return jsons.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return FALSE;
		}
		
	}
	@RequestMapping(value="update")
	@ResponseBody
	public String update(Article article){
		try {
			int row=articleService.update_ID(article);
			return article.getId()+"";
		} catch (Exception e) {
			e.printStackTrace();
			return FALSE;
		}				
	}
	@RequestMapping(value="add")
	@ResponseBody
	public String add(Article article){
		article.setDeplaytime(new Date());
		try {
			int row=articleService.insert_tv(article);
			return article.getId()+"";
		} catch (Exception e) {
			e.printStackTrace();
			return FALSE;
		}				
	}
	

}
