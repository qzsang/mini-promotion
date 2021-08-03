package case1;

import org.example.promotion.*;
import org.example.promotion.extension.bill.BasePromotionBill;
import org.example.promotion.impl.EngineImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PromotionApplicationTests {

    /**
     * 测试常规的促销匹配活动
     */
    @Test
    void contextLoads() {
        // 创建促销单 Start
        // 条件
        SpellWordCondition condition = new SpellWordCondition();
        condition.setWord("新年快乐");
        // 行为
        SpellWordAction action = new SpellWordAction();
        action.setDiscountRate(BigDecimal.valueOf(0.5));
        // 组装成促销单
        PromotionBill promotionBill = new BasePromotionBill(condition, action);
        // 创建促销单 End

        // 创建订单上下文 Start
        OrderContext orderBill = new OrderContext();
        // 设置商品
        List<OrderContext.Goods> goodsList = new ArrayList<OrderContext.Goods>();
        OrderContext.Goods goods1 = new OrderContext.Goods();
        goods1.setName("最新款的肥仔快乐水");
        goodsList.add(goods1);
        orderBill.setGoodsList(goodsList);
        // 创建订单上下文 END

        //设置匹配器 Start

        //设置匹配器 End

        // 开始执行 不满足条件测试
        Engine engine = new EngineImpl();
        PromotionResult promResult = engine.execute(
                orderBill,
                new PromotionBill[] {promotionBill},
                new Matcher[] {new SpellWordMatcher()});
        System.out.println(promResult);


        // 开始执行 满足条件测试
        OrderContext.Goods goods2 = new OrderContext.Goods();
        goods2.setName("年膏");
        goodsList.add(goods2);
        promResult = engine.execute(
                orderBill,
                new PromotionBill[] {promotionBill},
                new Matcher[] {new SpellWordMatcher()});
        System.out.println(promResult);
    }


}
