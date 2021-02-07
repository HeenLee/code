接收请求的参数
接收请求参数，使用处理器方法的形参
1）HttpServletRequest
2) HttpServletResponse
3) HttpSession
4）用户提交的数据
接收用户提交的参数:
1.逐个接收
2.对象接收

注意：
提交请求参数时，get请求方法中文没有乱码
使用post提交请求，中文有乱码，需要使用过滤器处理乱码

过滤器可以自定义，也可以使用框架中提供的过滤器。CharacterEncodingFilter