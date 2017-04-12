<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
        #editor,.edit{
        	display:none
        }
    </style>
    <script type="text/javascript">
    var ue; 
    $(function(){  
    	$('#submit').click(function(){
    		if($('#submit').val()=='编辑'){
    			edit();
    			$('#submit').val('保存');
    		}else if($('#submit').val()=='保存'){
    			save();
    		}
    	});
    	if($('#articleid').val()==""){
    		$('#articleid').val(0);
    		$('.edit').css('display','block');
    		$('.info').css('display','none');
    		$('#showp').css('display','none');
    		$('.info').css('display','none');
    		$('.edit').css('display','block');
    		ue=UE.getEditor('editor');
    		$('#editor').css('display','block');
    		$('#submit').val('保存');
    		gettypes();
    	}else{
    		$('#style').val('update');
    		$.post('mvc/article/'+$('#articleid').val(),{},function(data){
        		if(data.content){
        			$('#pic').attr('src',data.picpath);
        			$('#editor').text(data.content);
        			$('#author').text(data.author.name);
        			$('#title').text(data.title);
        			$('#title-edit').val(data.title);
        			$('#picpath').val(data.picpath);
        			$('#deplaytime').text(data.deplaytime);
        			$('#pageview').text(data.pageview);
        			$('#atctype').text(data.atctype.tname);
        			$('#typeid').val(data.atctype.tid);
        			$('#show').append('<div id="showp">'+data.content+'</div>');
        		}   		
        	},'json');
    	} 	 	
    }); 
	function show(){
		$('#show').html(ue.getContent());
	}
	function edit(){
		$('#showp').css('display','none');
		$('#title').css('display','none');
		$('.edit').css('display','block');
		ue=UE.getEditor('editor');
		$('#editor').css('display','block');
		gettypes();
	}
	function save(){
		$.post('mvc/article/'+$("#style").val(),{
			'id':$('#articleid').val(),
			'title':$('#title-edit').val(),
			'content':ue.getContent(),
			'picpath':$('#picpath').val(),
			'atctype.tid':$('#type-edit').val()
		},function(data){
			if(data!="false"){
				location.href="mvc/article/look/"+data;
			}
		});
	}
	 function gettypes(){
  	   $.post('mvc/atc/all',{},function(data){
  		   $('#type-edit').html('');
  		   $(data).each(function(data){
  			   var str='<option value="'+this.tid+'">'+this.tname+'</option>';
  			   var $option=$(str);
  			   $('#type-edit').append($option);
  		   });
  		   $('#type-edit').val($('#typeid').val());
  	   },'json');
     }
   </script>
</head>
<body>
  <input type="hidden" id="articleid" value="${ID}"/>
  <input type="hidden" id="style" value="add"/>
  <input type="hidden" id="typeid" value="0"/>
  <input type="hidden" id="style" value="add"/>
  <div class="panel panel-danger col-xs-12">
     <div class="panel-body" id="show">
     <img src="#" class="img-rounded col-xs-5 info" id="pic">
     <div class="info"><h3 id="title"></h3></div><div class="edit">文章标题：<input type="text" id="title-edit"/></div>
     <div class="info">作者：<span id="author"></span></div>
     <div class="info">类别：<span id="atctype"></span></div><div class="edit">选择类别：<select id="type-edit"></select></div>
     <div class="info">浏览量：<span id="pageview"></span></div>
     <div class="info">发布时间：<span id="deplaytime"></span></div>
     <div class="edit">图片路径：<input type="text" id="picpath"/></div>
     </div> 
     <textarea id="editor"></textarea>
     <input type="button" value="编辑" id="submit"/>  
  </div>
</body>
</html>
