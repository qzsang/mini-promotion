package org.example.promotion.application.context;

import org.example.promotion.core.PromotionContext;

import java.util.List;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class OrderContext implements PromotionContext {
    /**
     * ๅๅๅ่กจ
     */
    List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public static class Goods {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "org.example.promotion.application.context.OrderContext{" +
                "goodsList=" + goodsList +
                '}';
    }
}
