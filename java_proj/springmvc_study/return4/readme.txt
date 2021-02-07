处理器方法的返回值表示请求的处理结果
1.ModelAndView  有数据和视图，对视图执行forward
2.String 表示视图。可以是逻辑名称，也可以是完整视图路径
3.void 不能表示数据，也不能表示视图。
    在处理ajax的时候，可以使用void返回值。通过HttpServletResponse输出数据。响应ajax请求。
    ajax请求服务器端返回的就是数据，和视图无关。
4.Object 例如，String Integer Map List  Student等等都是对象。
        对象有属性，属性就是数据。所有返回Object表示数据，不与视图无关。需要使用@ResponseBody注解
        可以使用对象表示的数据，响应ajax请求。
    现在做ajax，主要使用json数据格式。实现步骤：
       1.加入处理json依赖。springmvc默认使用jackson
       2.在springmvc配置文件中加入<mvc:annotation-driven>注解驱动
         json = om.writeValueAsString(student)
       3.在处理器方法上面加入@ResponseBody注解
         response.setContentType()
         PrintWriter pw = response.getWriter()
         pw.println(json);
      springmvc处理器方法 返回Object，可以转为json输出到浏览器，响应ajax的内部原理
      1.<mvc:annotation-driven>注解驱动
        注解驱动实现的功能是完成java对象到json，xml，text，二进制等数据格式的转换
        <mvc:annotation-driven>在加入到springmvc配置文件后，会自动创建HttpMessageConveter接口
        接口的7个实现类对象。包括MappingJack2HttpMessageConverter(使用jackson工具库中的ObjectMapper实现java对象转为字符串的)
        MappingJack2HttpMessageConverter 处理json数据的
        StringHttpMessageConverter处理字符串的
        HttpMessageConveter接口：消息转换器。
        功能：定义了Java对象转为json，xml等数据格式的方法。这个接口有很多的实现类。
                这些实现类完成了java到json, java对象到xml，java对象到二进制数据的转换
        2.@ResponseBody注解
        放在处理器方法的上面，通过HttpServletResponse输出数据，响应ajax请求的
