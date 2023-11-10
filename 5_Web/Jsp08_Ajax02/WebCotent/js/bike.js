/**
 * 
 */

 $(function(){
	 parseJson();
 })
 
 function parseJson(){
	 $.getJSON("json/bike.json",function(data){
		 $.ajax({
			 url:"bike.do?command=datasave",
			 method:"post",
			 data:{"obj":JSON.stringify(data)}, // json에 있는 데이터가 string형식으로 바뀌고 obj타입으로 저장된다
			 success:function(msg){
				 console.log(msg);
				 
				 if(msg){
					 $.each(data,function(key,val){
						if(key=="DESCRIPTION"){ // 테이블헤더(컬럼)을 생성
							$("table").attr("border","1");
							$("thead").append(
								"<tr>"+
								"<th>"+val.ADDR_GU+"</th>"+
								"<th>"+val.CONTENT_ID+"</th>"+
								"<th>"+val.CONTENT_NM+"</th>"+
								"<th>"+val.NEW_ADDR+"</th>"+
								"<th>"+val.CRADLE_COUNT+"</th>"+
								"<th>"+val.LONGITUDE+"</th>"+
								"<th>"+val.LATITUDE+"</th>"+
								"</tr>"
								);
						} else{
							for(let i=0; i<val.length; i++){ // 테이블바디(로우 : 테이블데이터)를 화면에 출력
								let tmp=val[i];
								
								$('tbody').append(
									"<tr>"+
									"<td>"+tmp.addr_gu+"</td>"+
									"<td>"+tmp.content_id+"</td>"+
									"<td>"+tmp.content_nm+"</td>"+
									"<td>"+tmp.new_addr+"</td>"+
									"<td>"+tmp.cradle_count+"</td>"+
									"<td>"+tmp.longitude+"</td>"+
									"<td>"+tmp.latitude+"</td>"+
									"</tr>"
								);
								
							}
						}
						 
					 });
				 }
			 },
			 error:function(){
				 alert("실패");
			 }
		 })
	 }); // json데이터를 가지고온다
 }