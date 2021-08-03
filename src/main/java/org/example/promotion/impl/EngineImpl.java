package org.example.promotion.impl;

import org.example.promotion.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/29
 */
public class EngineImpl implements Engine {


    public PromotionResult execute(PromotionContext promotionContext, PromotionBill[] promBills, Matcher[] matchers) {
        if (promotionContext == null || promBills == null || promBills.length <= 0 || matchers == null || matchers.length <= 0) {
            return new PromotionResult(false);
        }
        List<Action> actionList = new ArrayList<Action>();
        for (PromotionBill bill : promBills) {
            for (Matcher matcher : matchers) {
                if (matcher.support(bill.getCondition(), promotionContext) &&
                        matcher.accept(bill.getCondition(), promotionContext)) {
                    actionList.add(bill.getAction());
                    break;
                }
            }
        }
        if (actionList.size() <= 0) {
            return new PromotionResult(false);
        }
        return new PromotionResult(true, actionList, promotionContext);
    }
}
