# """
# Python的logging模块提供了通用的日志系统，可以方便第三方模块或者是应用使用。这个模块提供不同的日志级别，
#  并可以采用不同的方式记录日志，比如文件，HTTP GET/POST，SMTP，Socket等，甚至可以自己实现具体的日志记录方式。
#     logging模块与log4j的机制是一样的，只是具体的实现细节不同。模块提供logger，handler，filter，formatter。
# logger
# 提供日志接口，供应用代码使用。logger最长用的操作有两类：配置和发送日志消息。可以通过logging.getLogger(name)
# 获取logger对象，如果不指定name则返回root对象，多次使用相同的name调用getLogger方法返回同一个logger对象。
#
# handler
# 将日志记录（log record）发送到合适的目的地（destination），比如文件，socket等。一个logger对象可以通过addHandler
# 方法添加0到多个handler，每个handler又可以定义不同日志级别，以实现日志分级过滤显示。
#
# filter
# 提供一种优雅的方式决定一个日志记录是否发送到handler。
#
# formatter
# 指定日志记录输出的具体格式。formatter的构造方法需要两个参数：消息的格式字符串和日期字符串，这两个参数都是可选的。
#
# 与log4j类似，logger，handler和日志消息的调用可以有具体的日志级别（Level），只有在日志消息的级别大于logger和
# handler的级别。
#
# logging模块是Python内置的标准模块，主要用于输出运行日志，可以设置输出日志的等级、日志保存路径、日志文件回滚等；
# 相比print，具备如下优点：
#
# 可以通过设置不同的日志等级，在release版本中只输出重要信息，而不必显示大量的调试信息；
# print将所有信息都输出到标准输出中，严重影响开发者从标准输出中查看其它数据；logging则可以由开发者决定将信息输出
# 到什么地方，以及怎么输出
# """