package case1;

import org.example.promotion.application.action.SpellWordAction;
import org.example.promotion.application.condition.SpellWordCondition;
import org.example.promotion.application.context.OrderContext;
import org.example.promotion.core.PromotionBill;
import org.example.promotion.core.PromotionResult;
import org.example.promotion.extension.bill.BasePromotionBill;
import org.example.promotion.extension.condition.CompositeCondition;
import org.example.promotion.extension.condition.Logical;
import org.example.promotion.extension.utils.EngineUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PromotionApplicationTests {

    /**
     * 测试常规的促销匹配活动
     */
    @Test
    void baseCaseTest() {
        // 创建促销单 Start
        // 条件
        SpellWordCondition condition = new SpellWordCondition();
        condition.setWord("新年快乐");
        // 行为
        SpellWordAction action = new SpellWordAction();
        action.setDiscountRate(BigDecimal.valueOf(0.5));
        // 组装成促销单
        BasePromotionBill d;
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

        // 开始执行 不满足条件测试
        PromotionResult promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);

        // 开始执行 满足条件测试
        OrderContext.Goods goods2 = new OrderContext.Goods();
        goods2.setName("年膏");
        goodsList.add(goods2);

        promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);
    }


    /**
     * 组合条件用例
     */
    @Test
    void compositeCaseTest() {
        // 创建促销单 Start
        // 条件  a and (b or c)

        SpellWordCondition condition1 = new SpellWordCondition();
        condition1.setWord("A");
        SpellWordCondition condition2 = new SpellWordCondition();
        condition2.setWord("B");
        SpellWordCondition condition3 = new SpellWordCondition();
        condition3.setWord("C");

//        a and (b or c)
        CompositeCondition condition = new CompositeCondition(Logical.OR, condition2, condition3);
        CompositeCondition rootCondition = new CompositeCondition(Logical.AND, condition, condition1);


        // 行为
        SpellWordAction action = new SpellWordAction();
        action.setDiscountRate(BigDecimal.valueOf(0.5));
        // 组装成促销单
        BasePromotionBill d;
        PromotionBill promotionBill = new BasePromotionBill(rootCondition, action);
        // 创建促销单 End

        // 创建订单上下文 Start
        OrderContext orderBill = new OrderContext();
        // 设置商品
        List<OrderContext.Goods> goodsList = new ArrayList<OrderContext.Goods>();
        OrderContext.Goods goods1 = new OrderContext.Goods();
        goods1.setName("A果");
        goodsList.add(goods1);
        orderBill.setGoodsList(goodsList);
        // 创建订单上下文 END

        // 开始执行 不满足条件测试
        PromotionResult promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);


        // 开始执行 满足条件测试
        OrderContext.Goods goods2 = new OrderContext.Goods();
        goods2.setName("B果");
        goodsList.add(goods2);

        promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);

        goods2.setName("C果");
        promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);

        goods2.setName("D果");
        promResult = EngineUtil.execute(orderBill, promotionBill);
        System.out.println(promResult);
    }
}
