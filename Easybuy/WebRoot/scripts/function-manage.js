// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "deleteUser.action?id="+id;
	}
}

function DeleteNews(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "deleteNews.action?id="+id;
	}
}