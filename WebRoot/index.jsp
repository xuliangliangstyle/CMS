<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="SelfCalendar/Calendar/calendar.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script>
       $(function(){
    	  gettypes();
    	  getAll();
       });
       function order(str){
    	   $('#orderby').val(str);
    	   setPage(1);
    	   getAll();
       }
       function getAll(){
    	   $.post('mvc/article/all',{
    		   'page':$("#page").val(),
    		   'orderBy':$("#orderby").val(),
    		   'atctype.tid':$("#type").val(),
    		   'title':"%"+$("#query_title").val().trim()+"%",
    		   'starttime':$("#starttime").val().trim(),
    		   'endtime':$("#endtime").val().trim()
    	   },function(data){
    		   $('#articles').html('');
    		   var page=data[0].page;
    		   var pages=data[0].pages;
    		   $('.pagination').html('');
    			var str='<li><a href="javascript:setPage(1)">&laquo;</a></li>';
    			$('.pagination').append($(str));  		     			
    		   for(var i=(page-2);i<=(page*1+2);i++){
    			   if(i>=1&&i<=pages){
    				   var str='<li><a href="javascript:setPage('+i+')">'+i+'</a></li>';
    				   $('.pagination').append($(str));
    			   }
    		   }
          		var str2='<li><a href="javascript:setPage('+pages+')">&raquo;</a></li>';
          		$('.pagination').append($(str2));
    		   $(data[1]).each(function(i){
    			   var str='<div class="row"><div class="col-sm-4 col-md-3">';   			   
    		        str+='<a href="mvc/article/look/'+this.id+'" target="blank" class="thumbnail"><img src="'+this.picpath+'" alt="通用的">';
    		        str+='</a></div><div class="caption">';
    		        str+='<a href="mvc/article/look/'+this.id+'" target="blank"><h3>'+this.title+'</h3></a>';
    		        str+='文章分类：'+this.atctype.tname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
    		        str+='作者：'+this.author.name;
    		        str+='<br/>发布时间：'+this.deplaytime;
    		        str+='<br/>浏览量：'+this.pageview;
    		        str+='<p>'+this.description+'</p></div></div>';
    		       var $div=$(str);
    		       $('#articles').append($div);
    		   });
    	   },'json');
       }
       function gettypes(){
    	   $.post('mvc/atc/all',{},function(data){
    		   $('#types').html('<li><a href="javascript:type(0)">全部</a></li>');
    		   $(data).each(function(data){
    			   var str='<li><a href="javascript:type('+this.tid+')">'+this.tname+'</a></li>';
    			   var $li=$(str);
    			   $('#types').append($li);
    		   });
    	   },'json');
       }
       function type(str){
    	   $('#type').val(str);
    	   setPage(1);
    	   getAll();
       }
       function setPage(page){
    	   $('#page').val(page);
    	   getAll();
       }
       function back(){
    	   if($('#querybox').css('display')=="inline"){
    		   $('#querybox').css('display','none');
    		   $('#query_back').html('&raquo;&raquo;&raquo;');
    	   }else{
    		   $('#querybox').css('display','inline');
    		   $('#query_back').html('&laquo;&laquo;&laquo;');
    	   }
    	   
       }
    </script>
    <style>
    span{
      font-size: 30;
      color:blue
    }
    #querybox{
    	display:none
    }
    #form_demo{
        display:inline
    }
    </style>
  </head>
  
  <body>
  <input type="hidden" id="page" value="1"/>
  <input type="hidden" id="orderby" value="deplaytime_DESC"/>
  <input type="hidden" id="type" value="0"/>
  <nav class="navbar navbar-default" role="navigation">
  	<div class="nav-header">
  		<div>
  			<ul class="nav navbar-nav navbar-left">
  			  <span><em>CMS</em></span>
  			</ul>
  			<ul class="nav navbar-nav navbar-right">
  			  <li class="active"><a href="look.jsp" target="blank">添加文章</a></li>
  			  <li class="dropdown">
  			     <a href="#" class="dropdown-toggle" data-toggle="dropdown">类别
  			     <b class="caret"></b></a>
  			     <ul class="dropdown-menu" id="types">
  			     </ul>
  			  </li>
  			  <li class="dropdown">
  			     <a href="#" class="dropdown-toggle" data-toggle="dropdown">排行
  			     <b class="caret"></b></a>
  			     <ul class="dropdown-menu">
  			        <li><a href="javascript:order('deplaytime_DESC')">按发布时间</a></li>
  			  		<li><a href="javascript:order('pageview_DESC')">按浏览量</a></li>
  			     </ul>
  			  </li>
  			</ul>  		
  		</div>
  	</div>
  </nav>
  <div class="panel panel-danger">
     <div class="panel-heading">文章列表<a id="query_back" href="javascript:back()">&raquo;&raquo;&raquo;</a><div id="querybox"><form action="#" id="form_demo">起始时间：<input type="text" id="starttime" onfocus="useMyCalendar(this);"/>截止时间：<input type="text" id="endtime" onfocus="useMyCalendar(this);"/>标题：<input type="text" id="query_title"/>&nbsp;&nbsp;<input type="button" value="提交" onclick="javascript:getAll();"/>&nbsp;&nbsp;<input type="reset" value="清空"/></form></div></div>
     <div class="panel-body" id="articles"></div>
     <div align="center">  
     <ul class="pagination"></ul> 
     </div>
  </div>
  </body>
</html>
