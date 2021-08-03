package org.example.promotion.core;

import java.util.List;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/29
 */
public class PromotionResult {
    boolean success;
    List<Action> actionList;
    PromotionContext promotionContext;

    public PromotionResult(boolean success) {
        this.success = success;
    }

    public PromotionResult(boolean success, List<Action> actionList, PromotionContext promotionContext) {
        this.success = success;
        this.actionList = actionList;
        this.promotionContext = promotionContext;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public PromotionContext getPromotionContext() {
        return promotionContext;
    }

    public void setPromotionContext(PromotionContext promotionContext) {
        this.promotionContext = promotionContext;
    }

    @Override
    public String toString() {
        return "PromotionResult{" +
                "success=" + success +
                ", actionList=" + actionList +
                ", promotionContext=" + promotionContext +
                '}';
    }
}
