//renderHeader
//渲染头部导航栏
function renderHeader(selector,userRole){
	let h = '<li><a class="title_index" href="index.html">首页</a></li>'
	h+='<li><a class="title_resource_list" href="resource_list.html">资源</a></li>'
	if(userRole == 'teacher' || userRole=='admin'){
		h+='<li><a class="title_upload_resource" href="upload_resource.html">上传资源</a></li>'
		h+='<li><a class="title_my_resource" href="my_resource.html">我的资源</a></li>'
	}
    if(userRole=='admin'){
	    h+='<li><a class="title_resource_manage" href="resource_manage.html">资源管理</a></li>'
	    h+='<li><a class="title_resource_statics" href="resource_statics.html">统计</a></li>'
    }  
	h+='<li><a class="title_question_list" href="question_list.html">题库</a></li>'
	if(userRole=='admin'){
		h+='<li><a class="title_question_create" href="question_create.html">题库生成</a></li>'
	}
	 h+='<li style="float:right;border-left:1px solid white;"><a href="login.html">退出登陆</a></li>'
    selector.html(h)
}

function authCheck(){
	if(!!!sessionStorage.getItem('id')){
		window.location.href = 'login.html'
		return true;
	}
	return false;
}