package com.xll.po;

import java.util.Date;

import com.xll.util.queryUtil;


/**
 * 文章实体类
 * @author Administrator
 *
 */
public class Article extends queryUtil{
	private int id;//文章ID
	private String title;//文章标题
	private String content;//文章内容
	private Date deplaytime;//文章发布时间
	private int state;//文章状态
	private Author author;//作者
	private int pageview;//浏览量
	private String description;//描述
	private Atctype atctype;//分类
	private String picpath;//封面路径
	public Atctype getAtctype() {
		return atctype;
	}
	public void setAtctype(Atctype atctype) {
		this.atctype = atctype;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDeplaytime() {
		return deplaytime;
	}
	public void setDeplaytime(Date deplaytime) {
		this.deplaytime = deplaytime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
