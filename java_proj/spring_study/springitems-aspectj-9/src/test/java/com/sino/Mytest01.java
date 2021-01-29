package com.sino;

import com.sino.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest01 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取service
        BuyGoodsService service = (BuyGoodsService) context.getBean("buyService");
        System.out.println(service.getClass().getName());
        //调用方法
        service.buy(1001, 1000);
    }
}
