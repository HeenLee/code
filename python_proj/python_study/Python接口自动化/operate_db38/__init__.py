'''
Connection对象:
    Connection对象即为数据库连接对象，在python中可以使用pymysql.connect()方法创建Connection对象，该方法的常用参数如下：
    host：连接的数据库服务器主机名，默认为本地主机（localhost）；字符串类型（String） 。
    user：用户名，默认为当前用户；字符串类型（String） 。
    passwd：密码，无默认值；字符串类 （String）。
    db：数据库名称，无默认值；字符串类型（String） 。
    port：指定数据库服务器的连接端口，默认为3306；整型（int）。
    charset：连接字符集；字符串类型（String）

    Connection对象常用的方法如下：
    cursor()：使用当前连接创建并返回游标 。
    commit()：提交当前事务 。
    rollback()：回滚当前事务 。
    close()：关闭当前连接

Cursor对象
    Cursor对象即为游标对象，用于执行查询和获取结果，在python中可以使用conn.cursor()创建，conn为Connection对象。
    Cursor对象常用的方法和属性如下：
    execute()：执行数据库查询或命令，将结果从数据库获取到客户端
    fetchone()：获取结果集的下一行
     fetchmany()：获取结果集的下几行
     fetchall()：获取结果集中剩下的所有行
     close()：关闭当前游标对象
     rowcount：最近一次的execute返回数据的行数或受影响的行数
'''
