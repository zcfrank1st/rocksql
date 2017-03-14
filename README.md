Rocksql
========

A sql wrapper project for rocksdb

TODO

1. 定义存储模型  /tablename/primarykey/column    value
2. parser转换


Tips

[Support SQL]

sql contain pk

all value are saved as string

    create table A (
        key string,
        a string,
        b string
    )
    
    drop table A
    
    select a, b from A where key = ""
    
    insert into A (key, a, b) values ("key", "aa", "bb")
    
    update A set a = "aa" where key = "key111" 

