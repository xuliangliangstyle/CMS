package com.xll.po;

import java.util.Date;

import com.xll.util.queryUtil;


/**
 * 作者实体类
 * @author Administrator
 *
 */
public class Author extends queryUtil{
	private int id;//作者ID
	private String name;//作者名字
	private int age;//年龄
	private int sex;//性别
	private Date createtime;//注册时间
	private int deplaycount;//发布条数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getDeplaycount() {
		return deplaycount;
	}
	public void setDeplaycount(int deplaycount) {
		this.deplaycount = deplaycount;
	}
	

}
