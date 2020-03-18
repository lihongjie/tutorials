Maven自定义插件开发

引入插件后执行命令
mvn counter:count 

传参
-Dproject.directory=${basedir}（必填） -Dtype=properties（选填，默认是java）
