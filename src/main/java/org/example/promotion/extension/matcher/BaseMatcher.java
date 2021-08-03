package org.example.promotion.extension.matcher;

import org.example.promotion.core.Condition;
import org.example.promotion.core.Matcher;
import org.example.promotion.core.PromotionContext;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public abstract class BaseMatcher<C extends Condition, P extends PromotionContext> implements Matcher<C, P> {
    private Class<C> acceptConditionClass;
    private Class<P> acceptContextClass;

    public BaseMatcher(Class<C> acceptConditionClass, Class<P> acceptContextClass) {
        this.acceptConditionClass = acceptConditionClass;
        this.acceptContextClass = acceptContextClass;
    }

    @Override
    public boolean support(Condition condition, PromotionContext promotionContext) {
        if (condition == null || promotionContext == null) {
            return false;
        }

        if (condition.getClass().equals(acceptConditionClass) && (acceptContextClass == null || promotionContext.getClass().equals(acceptContextClass))) {
            return true;
        }
        return false;
    }

}
