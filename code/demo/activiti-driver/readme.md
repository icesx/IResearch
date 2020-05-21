activiti-driver
=========
对activiti的高层封装，将原有的顺序调用执行方式，修改为面向对象的调用方式。

### 开发环境

需要安装插件
```
http://activiti.org/designer/update/
```
或者
```
/ministry-of-agriculture/doc/pig-transport/resources/eclipse-plugin/activiti-designer-5.18.0.zip
```
### 数据库
需要一张表存储每个task对应的action

```
create database activiti_driver;

GRANT  ALTER,USAGE,DROP,SELECT, INSERT, UPDATE, DELETE, CREATE,INDEX,SHOW VIEW ,CREATE TEMPORARY TABLES,EXECUTE ON activiti_driver.* TO 'bjrdc'@'%' IDENTIFIED BY  'xjgz@123';

```

### 基本概念

#### processDefine

> 声明的process，就是在bpmn文件中设置的processDefine。每个processDefine有一个processDefineId，对应于bpmn文件中的 id
>
> ```
> <process id="pigone" name="智猪one" isExecutable="true">
> ```
>
> 

#### processInstance

> 启动任务后的一个进程实例，processInstanceId,由activit自己创建

#### task

>对应与bpmn中的usertask
>
>```
><userTask id="SCJYBG" name="上传检疫报告"></userTask>
>```
>
>

#### assginee

>代理人，由activit维护的任务的执行人，可以使用该assginee查询其执行的任务以及任务所在的processinstance

#### variable

>

#### taskAction

> ​	对一个usertask的行为的封装，通过taskaction可以
>
> 1. 执行assginee动作
> 2. 获取上级变量
> 3. 响应事件
> 4. 使用spring注解的service处理业务
>
> ```
> 
> ```
>
> 

#### 