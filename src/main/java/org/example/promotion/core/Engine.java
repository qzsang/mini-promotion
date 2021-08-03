package org.example.promotion.core;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/29
 */
public interface Engine {

    /**
     * 促销活动计算
     * @param promotionContext
     * @param promBills
     * @param matchers
     * @return
     */
    PromotionResult execute(PromotionContext promotionContext, PromotionBill[] promBills , Matcher[] matchers);

}
