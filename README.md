### sql_learn

由于电脑性能问题，并未使用MySQL，而是使用sqlite。



SQL语句：

```sqlite
#建表
create table student(
    sno INTEGER PRIMARY KEY not null,
    name VARCHAR(20) not null,
    age INTEGER not null
);
#插入
insert into student (sno, name, age) values (110,'yaoyi',20);
#查询
select name,age from student where sno=110;
#修改
update student set age=16 where sno=110;
```

