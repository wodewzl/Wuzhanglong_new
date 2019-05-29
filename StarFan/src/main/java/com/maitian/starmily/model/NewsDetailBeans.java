package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class NewsDetailBeans extends BaseVO {

    /**
     * obj : {"news":{"newsId":3835,"userId":4337,"title":"星米粒团队test","createTime":1557106887000,"adImg":null,"count":428,"status":0,"top":1,"hot":0,"content":"<h1 id=\"dblog-\">OneBlog简介<\/h1>\n<p>OneBlog是一款简洁美观、自适应的Java博客系统。使用springboot开发，前端使用Bootstrap。支持移动端自适应，配有完备的前台和后台管理功能。<\/p>\n<p><strong>网站预览<\/strong>    <\/p>\n<p><a href=\"https://www.zhyd.me\">https://www.zhyd.me<\/a>  <\/p>\n<p><strong>开源地址<\/strong>   <\/p>\n<ol>\n<li><a href=\"https://gitee.com/yadong.zhang/DBlog\">Gitee<\/a>    <\/li>\n<li><a href=\"https://github.com/zhangyd-c/DBlog\">Github<\/a>    <\/li>\n<\/ol>\n<h2 id=\"-\">写在前面的话<\/h2>\n<p>ps: 虽然我知道，大部分人都是来了<strong>直接下载源代码<\/strong>后就潇洒的离开，并且只有等到下次<strong>突然想到<\/strong>\u201c我天~~我得去看看OneBlog这烂项目更新新功能了吗\u201d的时候才会重新来到这儿，即使你重新来过，我估计你也只有两个选择：    <\/p>\n<p>发现更新代码了 --&gt; 下载源码后重复上面的步骤<br>发现没更新代码 --&gt; 直接关闭浏览器<\/p>\n<p>虽然我知道现实就是如此的残酷，但我还是要以我萤虫之力对各位到来的同仁发出一声诚挚的嘶吼：<\/p>\n<p><strong>如果喜欢，请多多分享！！多多Star！！fork可以，但还是请star一下！！<\/strong><\/p>\n<h3 id=\"-\">开发环境<\/h3>\n<table>\n<thead>\n<tr>\n<th>工具<\/th>\n<th>版本或描述<\/th>\n<\/tr>\n<\/thead>\n<tbody>\n<tr>\n<td>OS<\/td>\n<td>Windows 7<\/td>\n<\/tr>\n<tr>\n<td>JDK<\/td>\n<td>1.7+<\/td>\n<\/tr>\n<tr>\n<td>IDE<\/td>\n<td>IntelliJ IDEA 2017.3<\/td>\n<\/tr>\n<tr>\n<td>Maven<\/td>\n<td>3.3.1<\/td>\n<\/tr>\n<tr>\n<td>MySQL<\/td>\n<td>5.6.4<\/td>\n<\/tr>\n<\/tbody>\n<\/table>\n<h3 id=\"-\">模块划分<\/h3>\n<table>\n<thead>\n<tr>\n<th>模块<\/th>\n<th>释义<\/th>\n<\/tr>\n<\/thead>\n<tbody>\n<tr>\n<td>blog-core<\/td>\n<td>核心业务类模块，提供基本的数据操作、工具处理等<\/td>\n<\/tr>\n<tr>\n<td>blog-admin<\/td>\n<td>后台管理模块<\/td>\n<\/tr>\n<tr>\n<td>blog-web<\/td>\n<td>前台模块<\/td>\n<\/tr>\n<\/tbody>\n<\/table>\n<h3 id=\"-\">技术栈<\/h3>\n<ul>\n<li>Springboot 1.5.9<\/li>\n<li>Apache Shiro 1.2.2<\/li>\n<li>Logback<\/li>\n<li>Redis<\/li>\n<li>Lombok<\/li>\n<li>Websocket<\/li>\n<li>MySQL、Mybatis、Mapper、Pagehelper<\/li>\n<li>Freemarker<\/li>\n<li>Bootstrap 3.3.0<\/li>\n<li>wangEditor<\/li>\n<li>jQuery 1.11.1、jQuery Lazyload 1.9.7、fancybox、iCheck<\/li>\n<li>阿里云OSS<\/li>\n<li>kaptcha<\/li>\n<li>Qiniu<\/li>\n<li>...<\/li>\n<\/ul>\n<h3 id=\"-\">使用方法<\/h3>\n<ol>\n<li>使用IDE导入本项目<\/li>\n<li>新建数据库<code>CREATE DATABASE dblog;<\/code><\/li>\n<li>导入数据库<code>docs/db/dblog.sql<\/code><\/li>\n<li>修改(<code>resources/application.yml<\/code>)配置文件<ol>\n<li>数据库链接属性(可搜索<code>datasource<\/code>或定位到L.19) <\/li>\n<li>redis配置(可搜索<code>redis<\/code>或定位到L.69)<\/li>\n<li>mail配置(可搜索<code>mail<\/code>或定位到L.89)<\/li>\n<li>【<a href=\"http://qiniu.com\">七牛云<\/a>】配置(见sys<em>config表中qiniu<\/em>*开头的字段)<br>注：因为系统存在redis缓存，如果是第一次使用，可以直接修改sys_config表内容，如果不是第一次用，建议使用admin项目中的<code>系统配置<\/code>页面修改相关配置内容<\/li>\n<\/ol>\n<\/li>\n<li>运行项目(三种方式)<ol>\n<li>项目根目录下执行<code>mvn -X clean package -Dmaven.test.skip=true<\/code>编译打包，然后执行<code>java -jar target/blog-web.jar<\/code><\/li>\n<li>项目根目录下执行<code>mvn springboot:run<\/code><\/li>\n<li>直接运行<code>BlogWebApplication.java<\/code><\/li>\n<\/ol>\n<\/li>\n<li>浏览器访问<code>http://127.0.0.1:8443<\/code><\/li>\n<\/ol>\n<p><strong>后台用户<\/strong><\/p>\n<p><em>超级管理员<\/em>： 账号：root  密码：123456  （本地测试使用这个账号，admin没设置权限）<\/p>\n<p><em>普通管理员<\/em>： 账号：admin  密码：123456<\/p>\n<p><em>评论审核管理员<\/em>： 账号：comment-admin  密码：123456<\/p>\n<p>注：后台用户的创建，尽可能做到<strong>权限最小化<\/strong><\/p>\n<p>更多详情，请参考【<a href=\"https://gitee.com/yadong.zhang/DBlog/wikis\">Wiki<\/a>】<\/p>\n"},"likeStatus":1,"idols":[{"id":2,"idolName":"迪丽热巴","nickname":"胖巴","alias":"胖巴别名","groups":null,"iconUrl":"F1EB4FF6-47C7-4912-831E-BB28EB471EFB","backUrl":"BB350951-F1D1-4157-8B49-D8A6FE32238D","info":"我是胖巴","createTime":null}],"favoriateStatus":1,"newsComment":{"pageNum":1,"pageSize":10,"size":7,"orderBy":"a.like_count DESC,a.create_time DESC","startRow":1,"endRow":7,"total":7,"pages":1,"list":[{"icon_url":"38D2D985-C517-4020-846B-9D65E392F6DC","newsId":3835,"replyMsg":"完美","createTime":1558286601000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","commentId":45,"likeCount":0,"likeStatus":0,"userName":"阿杜","userId":4338},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"就是说","createTime":1557916025000,"commentReply":null,"nickname":"星米粒","commentId":44,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"光谷","createTime":1557915834000,"commentReply":null,"nickname":"星米粒","commentId":43,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"痛恨","createTime":1557915678000,"commentReply":null,"nickname":"星米粒","commentId":42,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"哈哈哈有点想","createTime":1557915359000,"commentReply":null,"nickname":"星米粒","commentId":37,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557732251000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"666","fromNickname":"阿杜","createTime":1558334109000,"replyId":36,"commentId":36,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"555","fromNickname":"阿杜","createTime":1558334033000,"replyId":35,"commentId":36,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"大攀","commentId":36,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557158395000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":3,"pages":2,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"nickname":"大攀","commentId":35,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * news : {"newsId":3835,"userId":4337,"title":"星米粒团队test","createTime":1557106887000,"adImg":null,"count":428,"status":0,"top":1,"hot":0,"content":"<h1 id=\"dblog-\">OneBlog简介<\/h1>\n<p>OneBlog是一款简洁美观、自适应的Java博客系统。使用springboot开发，前端使用Bootstrap。支持移动端自适应，配有完备的前台和后台管理功能。<\/p>\n<p><strong>网站预览<\/strong>    <\/p>\n<p><a href=\"https://www.zhyd.me\">https://www.zhyd.me<\/a>  <\/p>\n<p><strong>开源地址<\/strong>   <\/p>\n<ol>\n<li><a href=\"https://gitee.com/yadong.zhang/DBlog\">Gitee<\/a>    <\/li>\n<li><a href=\"https://github.com/zhangyd-c/DBlog\">Github<\/a>    <\/li>\n<\/ol>\n<h2 id=\"-\">写在前面的话<\/h2>\n<p>ps: 虽然我知道，大部分人都是来了<strong>直接下载源代码<\/strong>后就潇洒的离开，并且只有等到下次<strong>突然想到<\/strong>\u201c我天~~我得去看看OneBlog这烂项目更新新功能了吗\u201d的时候才会重新来到这儿，即使你重新来过，我估计你也只有两个选择：    <\/p>\n<p>发现更新代码了 --&gt; 下载源码后重复上面的步骤<br>发现没更新代码 --&gt; 直接关闭浏览器<\/p>\n<p>虽然我知道现实就是如此的残酷，但我还是要以我萤虫之力对各位到来的同仁发出一声诚挚的嘶吼：<\/p>\n<p><strong>如果喜欢，请多多分享！！多多Star！！fork可以，但还是请star一下！！<\/strong><\/p>\n<h3 id=\"-\">开发环境<\/h3>\n<table>\n<thead>\n<tr>\n<th>工具<\/th>\n<th>版本或描述<\/th>\n<\/tr>\n<\/thead>\n<tbody>\n<tr>\n<td>OS<\/td>\n<td>Windows 7<\/td>\n<\/tr>\n<tr>\n<td>JDK<\/td>\n<td>1.7+<\/td>\n<\/tr>\n<tr>\n<td>IDE<\/td>\n<td>IntelliJ IDEA 2017.3<\/td>\n<\/tr>\n<tr>\n<td>Maven<\/td>\n<td>3.3.1<\/td>\n<\/tr>\n<tr>\n<td>MySQL<\/td>\n<td>5.6.4<\/td>\n<\/tr>\n<\/tbody>\n<\/table>\n<h3 id=\"-\">模块划分<\/h3>\n<table>\n<thead>\n<tr>\n<th>模块<\/th>\n<th>释义<\/th>\n<\/tr>\n<\/thead>\n<tbody>\n<tr>\n<td>blog-core<\/td>\n<td>核心业务类模块，提供基本的数据操作、工具处理等<\/td>\n<\/tr>\n<tr>\n<td>blog-admin<\/td>\n<td>后台管理模块<\/td>\n<\/tr>\n<tr>\n<td>blog-web<\/td>\n<td>前台模块<\/td>\n<\/tr>\n<\/tbody>\n<\/table>\n<h3 id=\"-\">技术栈<\/h3>\n<ul>\n<li>Springboot 1.5.9<\/li>\n<li>Apache Shiro 1.2.2<\/li>\n<li>Logback<\/li>\n<li>Redis<\/li>\n<li>Lombok<\/li>\n<li>Websocket<\/li>\n<li>MySQL、Mybatis、Mapper、Pagehelper<\/li>\n<li>Freemarker<\/li>\n<li>Bootstrap 3.3.0<\/li>\n<li>wangEditor<\/li>\n<li>jQuery 1.11.1、jQuery Lazyload 1.9.7、fancybox、iCheck<\/li>\n<li>阿里云OSS<\/li>\n<li>kaptcha<\/li>\n<li>Qiniu<\/li>\n<li>...<\/li>\n<\/ul>\n<h3 id=\"-\">使用方法<\/h3>\n<ol>\n<li>使用IDE导入本项目<\/li>\n<li>新建数据库<code>CREATE DATABASE dblog;<\/code><\/li>\n<li>导入数据库<code>docs/db/dblog.sql<\/code><\/li>\n<li>修改(<code>resources/application.yml<\/code>)配置文件<ol>\n<li>数据库链接属性(可搜索<code>datasource<\/code>或定位到L.19) <\/li>\n<li>redis配置(可搜索<code>redis<\/code>或定位到L.69)<\/li>\n<li>mail配置(可搜索<code>mail<\/code>或定位到L.89)<\/li>\n<li>【<a href=\"http://qiniu.com\">七牛云<\/a>】配置(见sys<em>config表中qiniu<\/em>*开头的字段)<br>注：因为系统存在redis缓存，如果是第一次使用，可以直接修改sys_config表内容，如果不是第一次用，建议使用admin项目中的<code>系统配置<\/code>页面修改相关配置内容<\/li>\n<\/ol>\n<\/li>\n<li>运行项目(三种方式)<ol>\n<li>项目根目录下执行<code>mvn -X clean package -Dmaven.test.skip=true<\/code>编译打包，然后执行<code>java -jar target/blog-web.jar<\/code><\/li>\n<li>项目根目录下执行<code>mvn springboot:run<\/code><\/li>\n<li>直接运行<code>BlogWebApplication.java<\/code><\/li>\n<\/ol>\n<\/li>\n<li>浏览器访问<code>http://127.0.0.1:8443<\/code><\/li>\n<\/ol>\n<p><strong>后台用户<\/strong><\/p>\n<p><em>超级管理员<\/em>： 账号：root  密码：123456  （本地测试使用这个账号，admin没设置权限）<\/p>\n<p><em>普通管理员<\/em>： 账号：admin  密码：123456<\/p>\n<p><em>评论审核管理员<\/em>： 账号：comment-admin  密码：123456<\/p>\n<p>注：后台用户的创建，尽可能做到<strong>权限最小化<\/strong><\/p>\n<p>更多详情，请参考【<a href=\"https://gitee.com/yadong.zhang/DBlog/wikis\">Wiki<\/a>】<\/p>\n"}
         * likeStatus : 1
         * idols : [{"id":2,"idolName":"迪丽热巴","nickname":"胖巴","alias":"胖巴别名","groups":null,"iconUrl":"F1EB4FF6-47C7-4912-831E-BB28EB471EFB","backUrl":"BB350951-F1D1-4157-8B49-D8A6FE32238D","info":"我是胖巴","createTime":null}]
         * favoriateStatus : 1
         * newsComment : {"pageNum":1,"pageSize":10,"size":7,"orderBy":"a.like_count DESC,a.create_time DESC","startRow":1,"endRow":7,"total":7,"pages":1,"list":[{"icon_url":"38D2D985-C517-4020-846B-9D65E392F6DC","newsId":3835,"replyMsg":"完美","createTime":1558286601000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","commentId":45,"likeCount":0,"likeStatus":0,"userName":"阿杜","userId":4338},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"就是说","createTime":1557916025000,"commentReply":null,"nickname":"星米粒","commentId":44,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"光谷","createTime":1557915834000,"commentReply":null,"nickname":"星米粒","commentId":43,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"痛恨","createTime":1557915678000,"commentReply":null,"nickname":"星米粒","commentId":42,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"哈哈哈有点想","createTime":1557915359000,"commentReply":null,"nickname":"星米粒","commentId":37,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557732251000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"666","fromNickname":"阿杜","createTime":1558334109000,"replyId":36,"commentId":36,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"555","fromNickname":"阿杜","createTime":1558334033000,"replyId":35,"commentId":36,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"大攀","commentId":36,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557158395000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":3,"pages":2,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"nickname":"大攀","commentId":35,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
         */

        private NewsBean news;
        private int likeStatus;
        private int favoriateStatus;
        private NewsCommentBean newsComment;
        private List<IdolsBean> idols;

        public NewsBean getNews() {
            return news;
        }

        public void setNews(NewsBean news) {
            this.news = news;
        }

        public int getLikeStatus() {
            return likeStatus;
        }

        public void setLikeStatus(int likeStatus) {
            this.likeStatus = likeStatus;
        }

        public int getFavoriateStatus() {
            return favoriateStatus;
        }

        public void setFavoriateStatus(int favoriateStatus) {
            this.favoriateStatus = favoriateStatus;
        }

        public NewsCommentBean getNewsComment() {
            return newsComment;
        }

        public void setNewsComment(NewsCommentBean newsComment) {
            this.newsComment = newsComment;
        }

        public List<IdolsBean> getIdols() {
            return idols;
        }

        public void setIdols(List<IdolsBean> idols) {
            this.idols = idols;
        }

        public static class NewsBean {
            /**
             * newsId : 3835
             * userId : 4337
             * title : 星米粒团队test
             * createTime : 1557106887000
             * adImg : null
             * count : 428
             * status : 0
             * top : 1
             * hot : 0
             * content : <h1 id="dblog-">OneBlog简介</h1>
             <p>OneBlog是一款简洁美观、自适应的Java博客系统。使用springboot开发，前端使用Bootstrap。支持移动端自适应，配有完备的前台和后台管理功能。</p>
             <p><strong>网站预览</strong>    </p>
             <p><a href="https://www.zhyd.me">https://www.zhyd.me</a>  </p>
             <p><strong>开源地址</strong>   </p>
             <ol>
             <li><a href="https://gitee.com/yadong.zhang/DBlog">Gitee</a>    </li>
             <li><a href="https://github.com/zhangyd-c/DBlog">Github</a>    </li>
             </ol>
             <h2 id="-">写在前面的话</h2>
             <p>ps: 虽然我知道，大部分人都是来了<strong>直接下载源代码</strong>后就潇洒的离开，并且只有等到下次<strong>突然想到</strong>“我天~~我得去看看OneBlog这烂项目更新新功能了吗”的时候才会重新来到这儿，即使你重新来过，我估计你也只有两个选择：    </p>
             <p>发现更新代码了 --&gt; 下载源码后重复上面的步骤<br>发现没更新代码 --&gt; 直接关闭浏览器</p>
             <p>虽然我知道现实就是如此的残酷，但我还是要以我萤虫之力对各位到来的同仁发出一声诚挚的嘶吼：</p>
             <p><strong>如果喜欢，请多多分享！！多多Star！！fork可以，但还是请star一下！！</strong></p>
             <h3 id="-">开发环境</h3>
             <table>
             <thead>
             <tr>
             <th>工具</th>
             <th>版本或描述</th>
             </tr>
             </thead>
             <tbody>
             <tr>
             <td>OS</td>
             <td>Windows 7</td>
             </tr>
             <tr>
             <td>JDK</td>
             <td>1.7+</td>
             </tr>
             <tr>
             <td>IDE</td>
             <td>IntelliJ IDEA 2017.3</td>
             </tr>
             <tr>
             <td>Maven</td>
             <td>3.3.1</td>
             </tr>
             <tr>
             <td>MySQL</td>
             <td>5.6.4</td>
             </tr>
             </tbody>
             </table>
             <h3 id="-">模块划分</h3>
             <table>
             <thead>
             <tr>
             <th>模块</th>
             <th>释义</th>
             </tr>
             </thead>
             <tbody>
             <tr>
             <td>blog-core</td>
             <td>核心业务类模块，提供基本的数据操作、工具处理等</td>
             </tr>
             <tr>
             <td>blog-admin</td>
             <td>后台管理模块</td>
             </tr>
             <tr>
             <td>blog-web</td>
             <td>前台模块</td>
             </tr>
             </tbody>
             </table>
             <h3 id="-">技术栈</h3>
             <ul>
             <li>Springboot 1.5.9</li>
             <li>Apache Shiro 1.2.2</li>
             <li>Logback</li>
             <li>Redis</li>
             <li>Lombok</li>
             <li>Websocket</li>
             <li>MySQL、Mybatis、Mapper、Pagehelper</li>
             <li>Freemarker</li>
             <li>Bootstrap 3.3.0</li>
             <li>wangEditor</li>
             <li>jQuery 1.11.1、jQuery Lazyload 1.9.7、fancybox、iCheck</li>
             <li>阿里云OSS</li>
             <li>kaptcha</li>
             <li>Qiniu</li>
             <li>...</li>
             </ul>
             <h3 id="-">使用方法</h3>
             <ol>
             <li>使用IDE导入本项目</li>
             <li>新建数据库<code>CREATE DATABASE dblog;</code></li>
             <li>导入数据库<code>docs/db/dblog.sql</code></li>
             <li>修改(<code>resources/application.yml</code>)配置文件<ol>
             <li>数据库链接属性(可搜索<code>datasource</code>或定位到L.19) </li>
             <li>redis配置(可搜索<code>redis</code>或定位到L.69)</li>
             <li>mail配置(可搜索<code>mail</code>或定位到L.89)</li>
             <li>【<a href="http://qiniu.com">七牛云</a>】配置(见sys<em>config表中qiniu</em>*开头的字段)<br>注：因为系统存在redis缓存，如果是第一次使用，可以直接修改sys_config表内容，如果不是第一次用，建议使用admin项目中的<code>系统配置</code>页面修改相关配置内容</li>
             </ol>
             </li>
             <li>运行项目(三种方式)<ol>
             <li>项目根目录下执行<code>mvn -X clean package -Dmaven.test.skip=true</code>编译打包，然后执行<code>java -jar target/blog-web.jar</code></li>
             <li>项目根目录下执行<code>mvn springboot:run</code></li>
             <li>直接运行<code>BlogWebApplication.java</code></li>
             </ol>
             </li>
             <li>浏览器访问<code>http://127.0.0.1:8443</code></li>
             </ol>
             <p><strong>后台用户</strong></p>
             <p><em>超级管理员</em>： 账号：root  密码：123456  （本地测试使用这个账号，admin没设置权限）</p>
             <p><em>普通管理员</em>： 账号：admin  密码：123456</p>
             <p><em>评论审核管理员</em>： 账号：comment-admin  密码：123456</p>
             <p>注：后台用户的创建，尽可能做到<strong>权限最小化</strong></p>
             <p>更多详情，请参考【<a href="https://gitee.com/yadong.zhang/DBlog/wikis">Wiki</a>】</p>

             */

            private int newsId;
            private int userId;
            private String title;
            private long createTime;
            private Object adImg;
            private int count;
            private int status;
            private int top;
            private int hot;
            private String content;

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getAdImg() {
                return adImg;
            }

            public void setAdImg(Object adImg) {
                this.adImg = adImg;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class NewsCommentBean {
            /**
             * pageNum : 1
             * pageSize : 10
             * size : 7
             * orderBy : a.like_count DESC,a.create_time DESC
             * startRow : 1
             * endRow : 7
             * total : 7
             * pages : 1
             * list : [{"icon_url":"38D2D985-C517-4020-846B-9D65E392F6DC","newsId":3835,"replyMsg":"完美","createTime":1558286601000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","commentId":45,"likeCount":0,"likeStatus":0,"userName":"阿杜","userId":4338},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"就是说","createTime":1557916025000,"commentReply":null,"nickname":"星米粒","commentId":44,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"光谷","createTime":1557915834000,"commentReply":null,"nickname":"星米粒","commentId":43,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"痛恨","createTime":1557915678000,"commentReply":null,"nickname":"星米粒","commentId":42,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"哈哈哈有点想","createTime":1557915359000,"commentReply":null,"nickname":"星米粒","commentId":37,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557732251000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"666","fromNickname":"阿杜","createTime":1558334109000,"replyId":36,"commentId":36,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"555","fromNickname":"阿杜","createTime":1558334033000,"replyId":35,"commentId":36,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"大攀","commentId":36,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557158395000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":3,"pages":2,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"nickname":"大攀","commentId":35,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337}]
             * firstPage : 1
             * prePage : 0
             * nextPage : 0
             * lastPage : 1
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private String orderBy;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int firstPage;
            private int prePage;
            private int nextPage;
            private int lastPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private List<ListBeanX> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getOrderBy() {
                return orderBy;
            }

            public void setOrderBy(String orderBy) {
                this.orderBy = orderBy;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBeanX {
                /**
                 * icon_url : 38D2D985-C517-4020-846B-9D65E392F6DC
                 * newsId : 3835
                 * replyMsg : 完美
                 * createTime : 1558286601000
                 * commentReply : {"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]}
                 * nickname : 阿杜
                 * commentId : 45
                 * likeCount : 0
                 * likeStatus : 0
                 * userName : 阿杜
                 * userId : 4338
                 */

                private String icon_url;
                private int newsId;
                private String replyMsg;
                private long createTime;
                private CommentReplyBean commentReply;
                private String nickname;
                private int commentId;
                private int likeCount;
                private int likeStatus;
                private String userName;
                private int userId;

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getNewsId() {
                    return newsId;
                }

                public void setNewsId(int newsId) {
                    this.newsId = newsId;
                }

                public String getReplyMsg() {
                    return replyMsg;
                }

                public void setReplyMsg(String replyMsg) {
                    this.replyMsg = replyMsg;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public CommentReplyBean getCommentReply() {
                    return commentReply;
                }

                public void setCommentReply(CommentReplyBean commentReply) {
                    this.commentReply = commentReply;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getLikeStatus() {
                    return likeStatus;
                }

                public void setLikeStatus(int likeStatus) {
                    this.likeStatus = likeStatus;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public static class CommentReplyBean {
                    /**
                     * pageNum : 1
                     * pageSize : 2
                     * size : 2
                     * orderBy : null
                     * startRow : 1
                     * endRow : 2
                     * total : 6
                     * pages : 3
                     * list : [{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}]
                     * firstPage : 1
                     * prePage : 0
                     * nextPage : 2
                     * lastPage : 3
                     * isFirstPage : true
                     * isLastPage : false
                     * hasPreviousPage : false
                     * hasNextPage : true
                     * navigatePages : 8
                     * navigatepageNums : [1,2,3]
                     */

                    private int pageNum;
                    private int pageSize;
                    private int size;
                    private Object orderBy;
                    private int startRow;
                    private int endRow;
                    private int total;
                    private int pages;
                    private int firstPage;
                    private int prePage;
                    private int nextPage;
                    private int lastPage;
                    private boolean isFirstPage;
                    private boolean isLastPage;
                    private boolean hasPreviousPage;
                    private boolean hasNextPage;
                    private int navigatePages;
                    private List<ListBean> list;
                    private List<Integer> navigatepageNums;

                    public int getPageNum() {
                        return pageNum;
                    }

                    public void setPageNum(int pageNum) {
                        this.pageNum = pageNum;
                    }

                    public int getPageSize() {
                        return pageSize;
                    }

                    public void setPageSize(int pageSize) {
                        this.pageSize = pageSize;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public Object getOrderBy() {
                        return orderBy;
                    }

                    public void setOrderBy(Object orderBy) {
                        this.orderBy = orderBy;
                    }

                    public int getStartRow() {
                        return startRow;
                    }

                    public void setStartRow(int startRow) {
                        this.startRow = startRow;
                    }

                    public int getEndRow() {
                        return endRow;
                    }

                    public void setEndRow(int endRow) {
                        this.endRow = endRow;
                    }

                    public int getTotal() {
                        return total;
                    }

                    public void setTotal(int total) {
                        this.total = total;
                    }

                    public int getPages() {
                        return pages;
                    }

                    public void setPages(int pages) {
                        this.pages = pages;
                    }

                    public int getFirstPage() {
                        return firstPage;
                    }

                    public void setFirstPage(int firstPage) {
                        this.firstPage = firstPage;
                    }

                    public int getPrePage() {
                        return prePage;
                    }

                    public void setPrePage(int prePage) {
                        this.prePage = prePage;
                    }

                    public int getNextPage() {
                        return nextPage;
                    }

                    public void setNextPage(int nextPage) {
                        this.nextPage = nextPage;
                    }

                    public int getLastPage() {
                        return lastPage;
                    }

                    public void setLastPage(int lastPage) {
                        this.lastPage = lastPage;
                    }

                    public boolean isIsFirstPage() {
                        return isFirstPage;
                    }

                    public void setIsFirstPage(boolean isFirstPage) {
                        this.isFirstPage = isFirstPage;
                    }

                    public boolean isIsLastPage() {
                        return isLastPage;
                    }

                    public void setIsLastPage(boolean isLastPage) {
                        this.isLastPage = isLastPage;
                    }

                    public boolean isHasPreviousPage() {
                        return hasPreviousPage;
                    }

                    public void setHasPreviousPage(boolean hasPreviousPage) {
                        this.hasPreviousPage = hasPreviousPage;
                    }

                    public boolean isHasNextPage() {
                        return hasNextPage;
                    }

                    public void setHasNextPage(boolean hasNextPage) {
                        this.hasNextPage = hasNextPage;
                    }

                    public int getNavigatePages() {
                        return navigatePages;
                    }

                    public void setNavigatePages(int navigatePages) {
                        this.navigatePages = navigatePages;
                    }

                    public List<ListBean> getList() {
                        return list;
                    }

                    public void setList(List<ListBean> list) {
                        this.list = list;
                    }

                    public List<Integer> getNavigatepageNums() {
                        return navigatepageNums;
                    }

                    public void setNavigatepageNums(List<Integer> navigatepageNums) {
                        this.navigatepageNums = navigatepageNums;
                    }

                    public static class ListBean {
                        /**
                         * toIcon : 38D2D985-C517-4020-846B-9D65E392F6DC
                         * fromUserId : 4344
                         * fromIcon : 60BAA0B7-42AC-42D3-A6A9-E9AB556BF274
                         * likeCount : 0
                         * toUserId : 4338
                         * toNickname : 阿杜
                         * fromUserName : 星米粒3
                         * replyMsg : 再测试下下
                         * fromNickname : 星米粒
                         * createTime : 1558452837000
                         * replyId : 42
                         * commentId : 45
                         * toUserName : 阿杜
                         * likeStatus : 0
                         */

                        private String toIcon;
                        private int fromUserId;
                        private String fromIcon;
                        private int likeCount;
                        private int toUserId;
                        private String toNickname;
                        private String fromUserName;
                        private String replyMsg;
                        private String fromNickname;
                        private long createTime;
                        private int replyId;
                        private int commentId;
                        private String toUserName;
                        private int likeStatus;

                        public String getToIcon() {
                            return toIcon;
                        }

                        public void setToIcon(String toIcon) {
                            this.toIcon = toIcon;
                        }

                        public int getFromUserId() {
                            return fromUserId;
                        }

                        public void setFromUserId(int fromUserId) {
                            this.fromUserId = fromUserId;
                        }

                        public String getFromIcon() {
                            return fromIcon;
                        }

                        public void setFromIcon(String fromIcon) {
                            this.fromIcon = fromIcon;
                        }

                        public int getLikeCount() {
                            return likeCount;
                        }

                        public void setLikeCount(int likeCount) {
                            this.likeCount = likeCount;
                        }

                        public int getToUserId() {
                            return toUserId;
                        }

                        public void setToUserId(int toUserId) {
                            this.toUserId = toUserId;
                        }

                        public String getToNickname() {
                            return toNickname;
                        }

                        public void setToNickname(String toNickname) {
                            this.toNickname = toNickname;
                        }

                        public String getFromUserName() {
                            return fromUserName;
                        }

                        public void setFromUserName(String fromUserName) {
                            this.fromUserName = fromUserName;
                        }

                        public String getReplyMsg() {
                            return replyMsg;
                        }

                        public void setReplyMsg(String replyMsg) {
                            this.replyMsg = replyMsg;
                        }

                        public String getFromNickname() {
                            return fromNickname;
                        }

                        public void setFromNickname(String fromNickname) {
                            this.fromNickname = fromNickname;
                        }

                        public long getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(long createTime) {
                            this.createTime = createTime;
                        }

                        public int getReplyId() {
                            return replyId;
                        }

                        public void setReplyId(int replyId) {
                            this.replyId = replyId;
                        }

                        public int getCommentId() {
                            return commentId;
                        }

                        public void setCommentId(int commentId) {
                            this.commentId = commentId;
                        }

                        public String getToUserName() {
                            return toUserName;
                        }

                        public void setToUserName(String toUserName) {
                            this.toUserName = toUserName;
                        }

                        public int getLikeStatus() {
                            return likeStatus;
                        }

                        public void setLikeStatus(int likeStatus) {
                            this.likeStatus = likeStatus;
                        }
                    }
                }
            }
        }

        public static class IdolsBean {
            /**
             * id : 2
             * idolName : 迪丽热巴
             * nickname : 胖巴
             * alias : 胖巴别名
             * groups : null
             * iconUrl : F1EB4FF6-47C7-4912-831E-BB28EB471EFB
             * backUrl : BB350951-F1D1-4157-8B49-D8A6FE32238D
             * info : 我是胖巴
             * createTime : null
             */

            private int id;
            private String idolName;
            private String nickname;
            private String alias;
            private Object groups;
            private String iconUrl;
            private String backUrl;
            private String info;
            private Object createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIdolName() {
                return idolName;
            }

            public void setIdolName(String idolName) {
                this.idolName = idolName;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public Object getGroups() {
                return groups;
            }

            public void setGroups(Object groups) {
                this.groups = groups;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getBackUrl() {
                return backUrl;
            }

            public void setBackUrl(String backUrl) {
                this.backUrl = backUrl;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }
        }
    }
}
