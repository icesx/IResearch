pt-flow
=========
工作流相关代码
### 开发环境

编辑流程bpmn文件，需要安装插件
```
http://activiti.org/designer/update/
```
或者
/ministry-of-agriculture/doc/pig-transport/resources/eclipse-plugin/activiti-designer-5.18.0.zip

### 数据库

GRANT  ALTER,USAGE,DROP,SELECT, INSERT, UPDATE, DELETE, CREATE,INDEX,SHOW VIEW ,CREATE TEMPORARY TABLES,EXECUTE ON activiti_driver.* TO 'bjrdc'@'%' IDENTIFIED BY  'xjgz@123';
### 几个问题

1. 用户权限如何与activiti对接？
2. 流程修改的成本,如果简单的修改流程？
3. 数据如何反馈出来？如何向下兼容？如何考虑多地域的流程不同之后导致的兼容问题？