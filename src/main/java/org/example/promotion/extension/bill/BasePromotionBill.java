package org.example.promotion.extension.bill;

import org.example.promotion.Action;
import org.example.promotion.Condition;
import org.example.promotion.PromotionBill;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class BasePromotionBill implements PromotionBill {
    private Condition condition;
    private Action action;


    public BasePromotionBill(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public Action getAction() {
        return action;
    }
}
