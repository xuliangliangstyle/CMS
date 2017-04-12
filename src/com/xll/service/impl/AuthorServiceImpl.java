package com.xll.service.impl;
/**
 * AuthorService接口实现类
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xll.mapper.AuthorMapper;
import com.xll.po.Author;
import com.xll.service.AuthorService;
@Service(value="authorService")
public class AuthorServiceImpl implements AuthorService{
	@Resource
    AuthorMapper authorMapper;
	@Override
	public Author select_ID(Integer id) {
		return authorMapper.select_ID(id);
	}

}
