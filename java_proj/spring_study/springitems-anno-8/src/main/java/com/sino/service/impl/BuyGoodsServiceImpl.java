package com.sino.service.impl;

import com.sino.dao.GoodsDao;
import com.sino.dao.SaleDao;
import com.sino.domain.Goods;
import com.sino.domain.Sale;
import com.sino.exep.NotEnoughException;
import com.sino.service.BuyGoodsService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
   private SaleDao saleDao;
   private GoodsDao goodsDao;

    /**
     *rollbackFor：表示发生指定的异常一定回滚。
     * 处理逻辑是：
     *  1）spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中。如果
     *    异常在rollback列表中，不管是什么类型的异常，一定回滚
     *   2）如果抛出的异常不在rollback列表中，spring会判断异常是不是RuntimeException
     *   如果是一定回滚。
     *
     * @param goodsId
     * @param nums
     */
/*    @Transactional(  全部是默认值
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )*/
     //使用的是事务控制默认值，默认的传播行为
    //默认抛出运行时异常，回滚事务
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("===buy方法的开始====");
        //记录销售信息，向sale表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if(goods == null){
            //商品不存在
            throw new NullPointerException("goodsId商品不存在");
        }else if (goods.getAmount() < nums){
            //商品库存不足
            throw new NotEnoughException("库存不足");
        }

        //修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("buy方法结束====");

    }

   public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


}
