package org.example.promotion.extension.matcher;

import org.example.promotion.core.Condition;
import org.example.promotion.core.Matcher;
import org.example.promotion.core.PromotionContext;
import org.example.promotion.extension.condition.CompositeCondition;
import org.example.promotion.extension.condition.Logical;
import org.example.promotion.extension.utils.MatcherUtil;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class CompositeMatcher extends BaseMatcher<CompositeCondition, PromotionContext> {


    public CompositeMatcher() {
        super(CompositeCondition.class, null);
    }

    @Override
    public boolean accept(CompositeCondition condition, PromotionContext promotionContext) {
        if (condition == null || condition.getConditionList() == null || condition.getConditionList().size() <= 0
            || promotionContext == null) {
            return false;
        }
        if (Logical.OR.equals(condition.getLogical())) {
            // 只要有一个true 就true
            boolean isSupport = false;
            for (Condition itemCondition : condition.getConditionList()) {
                for (Matcher matcher : MatcherUtil.getMatcherList()) {
                    if (!matcher.support(itemCondition, promotionContext)) {
                        continue;
                    }
                    if (matcher.accept(itemCondition, promotionContext)) {
                        return true;
                    }
                }
            }
            return isSupport;
        } else if (Logical.AND.equals(condition.getLogical())) {
            // 只要有一个false 就false
            boolean isSupport = false;
            for (Condition itemCondition : condition.getConditionList()) {
                for (Matcher matcher : MatcherUtil.getMatcherList()) {
                    if (!matcher.support(itemCondition, promotionContext)) {
                        continue;
                    }
                    if (!matcher.accept(itemCondition, promotionContext)) {
                        return false;
                    }
                    isSupport = true;
                }
            }
            return isSupport;
        } else {
            throw new RuntimeException("未实现该逻辑符");
        }
    }
}
