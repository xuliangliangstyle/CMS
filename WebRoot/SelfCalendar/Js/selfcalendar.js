       window.onload=function(){
    	      getCalendarTime();
           };
        function getCurrentDays(year,month){
         	  var day_31=[1,3,5,7,8,10,12];
         	  var currentDays=30;
         	  if(month==2){
         		  if((year%4==0&&year%100!=0)||(year%400==0)){
         	    		currentDays=29;
         	    	}
         	    	currentDays=28;
         	  }else{
         		  for(var i=0;i<day_31.length;i++){
             		  if(day_31[i]==month){
             			  currentDays=31;
             			  break;
             		  }
             	  }
         	  }
         	 return currentDays;	  
           }
         function getLastMonthDays(year,month){
         	month=month-1;
         	if(month==0){
         		month=12;
         		year=year-1;
         	}
         	return getCurrentDays(year,month);
         }
           function getIndex(year,month){
         	  var strTime=year+"-"+month+"-1";
         	  var time=new Date(strTime);
         	  var index=time.getDay();
              return index;
           }
       function getCalendarTime(){
    	   var time=document.getElementById("current_time");
    	   var span=document.getElementById("CalendarSpan");
    	   var now=new Date();
		   var year=now.getFullYear();
		   var month=(now.getMonth()+1);
		   var date=now.getDate();
		   var bo="false";
    	   if(span.innerHTML!=""){
    	       year=span.innerHTML.substring(0,4);
    	       month=span.innerHTML.substring(5,span.innerHTML.lastIndexOf("月"));
    	   }else{
    		   time.value=year+"-"+month+"-"+date; 
    		   span.innerHTML=year+"年"+month+"月";
    	   }
    	   if(span.innerHTML.substring(0,4)==time.value.substring(0,4)&&span.innerHTML.substring(5,span.innerHTML.indexOf("月"))==time.value.substring(5,time.value.lastIndexOf("-"))){
		    	bo="true";
		    }
            var currentDays=getCurrentDays(year,month);
            var lastDays=getLastMonthDays(year,month);
            var index=getIndex(year,month);
    			    var run=(lastDays-index+1);
    			    if(index==0){
    			    	run=run-7;
    			    }
    			    var body=document.getElementById("calendarbody");
    			    var count=(body.rows.length-1);
    			    for(var i=1;i<count;i++){
    			    	body.deleteRow(1);
    			    }
    			    var j=1;
    			    do{
    			    	var row=body.insertRow(body.rows.length-1);
    			    	for(var i=0;i<7;i++){
        			    	var cell=row.insertCell(i);
        			    	if(run<=lastDays){
        			    		cell.innerHTML=run;
        			    		cell.className="lastCurrentCalendar";
        			    	}else{
        			    		if(run<=(lastDays+currentDays)){       			    			
        			    			if((run-lastDays)==(time.value.substring(time.value.lastIndexOf("-")*1+1))&&bo=="true"){
        			    				cell.innerHTML="<strong>"+(run-lastDays)+"</strong>";
        			    				cell.className="currentDayCalendar";
        			    				document.getElementById("dayCheck").value=time.value.substring(time.value.lastIndexOf("-")*1+1);
        			    			}else{
        			    				cell.innerHTML=run-lastDays;
        			    				cell.className="currentCalendar";
        			    			}	
        			    		}else{
        			    			cell.innerHTML=run-lastDays-currentDays;
        			    			cell.className="nextCurrentCalendar";
        			    		}
        			    		
        			    	}    	
        			    	run=(run*1+1);
        			    }
    			    	j=(j+1);
    			    }while(j<7);
    			    var current=document.getElementsByClassName("currentCalendar");
    			       for(var i=0;i<current.length;i++){
    			    	   current[i].onmouseover=function(){
    		    			   this.style.backgroundColor="#999";
    		    		   };
    		    		   current[i].onmouseout=function(){
    		    			   this.style.backgroundColor="";		  
    		    		   };
    		    		   current[i].onclick=function(){
    		    			   for(var i=0;i<current.length;i++){
    		    				   current[i].style.border=""; 
    		    				   var currentday=document.getElementsByClassName("currentDayCalendar");
    		    				   if(currentday.length>0){
    		    					   currentday[0].style.border="";
    		    				   }
    		    			   }
    		    			   this.style.border="1px solid blue";
    		    			   var daylog=document.getElementById("dayCheck");
    		    			   daylog.value=this.innerHTML; 
    		    		   };   
    			       }
    			    var currentday=document.getElementsByClassName("currentDayCalendar");
    			    if(currentday.length>0){
    			    	 currentday[0].onmouseover=function(){
  		    			   this.style.backgroundColor="#999";
  		    		   };
  		    		   currentday[0].onmouseout=function(){
  		    			   this.style.backgroundColor="";		  
  		    		   };
  		    		   currentday[0].onclick=function(){
  		    			   for(var i=0;i<current.length;i++){
  		    				   current[i].style.border="";
  		    			   }
  		    			   this.style.border="1px solid blue";
  		    			   var daylog=document.getElementById("dayCheck");
  		    			   daylog.value=this.innerHTML.substring((this.innerHTML.indexOf(">")*1+1),this.innerHTML.lastIndexOf("<"));
  		    		   }
    			    }	      
    		    	var last=document.getElementsByClassName("lastCurrentCalendar");
    		    	   for(var i=0;i<last.length;i++){
    		    		   last[i].onmouseover=function(){
    		    			   if(this.type=="undefined"){
    		    				   this.style.backgroundColor="#999";
    		    			   }  
    		    		   };
    		    		   last[i].onmouseout=function(){
    		    			   this.style.backgroundColor="";		  
    		    		   };
    		    		   last[i].onclick=function(){
    		    			   if(month!=1){
    		    				   span.innerHTML=year+"年"+(month-1)+"月";
    		    			   }else{
    		    				   span.innerHTML=(year-1)+"年12月";
    		    			   }
    		    			   getCalendarTime();
    		    		   };
    		    	   }
    		    	var next=document.getElementsByClassName("nextCurrentCalendar");
    		    	  for(var i=0;i<next.length;i++){
    		    		  next[i].onmouseover=function(){
    		    			  if(this.type=="undefined"){
    		    				  this.style.backgroundColor="#999";
    		    			  }	   
   		    		      };
   		    		      next[i].onmouseout=function(){
   		    			   this.style.backgroundColor="";		  
   		    		      };
 		    		      next[i].onclick=function(){	
 		    		    	  if(month!=12){
 		    		    		 span.innerHTML=year+"年"+(month*1+1)+"月";
 		    		    	  }else{
 		    		    		  span.innerHTML=(year*1+1)+"年1月";
 		    		    	  }
 		    			      getCalendarTime();
 		    		     };
 		    	      }
    		    	var lastYear=document.getElementsByClassName("lastYearCalendar")[0];
    		    	lastYear.onclick=function(){
    		    		span.innerHTML=(year-1)+"年"+month+"月";
    		    		getCalendarTime();
    		    	};
    		    	var nextYear=document.getElementsByClassName("nextYearCalendar")[0];
    		    	nextYear.onclick=function(){
    		    		span.innerHTML=(year*1+1)+"年"+month+"月";
    		    		getCalendarTime();
    		    	};
    		 
    	   
       };
       function giveCalendarTime(obj){
    	   var str=document.getElementById("CalendarSpan").innerHTML;
    	   var daycheck=document.getElementById("dayCheck");
    	   var year=str.substring(0,4);
    	   var month=str.substring(5,str.indexOf("月"));
    	   var day=daycheck.value;
    	   obj.value=year+"-"+month+"-"+day;
       }
       function useMyCalendar(obj){
    	   var time=document.getElementById("current_time");
    	   var span=document.getElementById("CalendarSpan");
    	   var now=new Date();
		   var year=now.getFullYear();
		   var month=(now.getMonth()+1);
		   var table=document.getElementById("superTable");
		   span.innerHTML=year+"年"+month+"月";
		   getCalendarTime();
    	   var top=obj.offsetTop;
    	   var width=obj.offsetWidth;
    	   var left=obj.offsetLeft;
    	   var height=obj.offsetHeight;
    	   var newobj=obj;
           while(newobj.offsetParent!=document.body){
        	   newobj=newobj.offsetParent;
        	   top=(top*1+newobj.offsetTop*1);
        	   left=(left*1+newobj.offsetLeft*1);
           }
           if(left<1000){
        	   left=(left*1+width*1);
           }else{
        	   top=(top*1+height*1);
           }
           
    	   var table=document.getElementById("superTable");
    	   table.style.display="block";
    	   table.style.top=top;
    	   table.style.left=left;
    	   var subOk=document.getElementsByClassName("subOk");
    	   subOk[0].onclick=function(){
    		   table.style.display="none";
    		   giveCalendarTime(obj);
    	   };
    	   subOk[1].onclick=function(){
    		   table.style.display="none";
    	   };
       }
       
       