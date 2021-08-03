package org.example.promotion.extension.utils;

import org.example.promotion.core.*;
import org.example.promotion.core.impl.EngineImpl;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class EngineUtil {
    private static Engine engine;

    /**
     * 得到实例
     * @return
     */
    public static Engine getEngineInstance() {
        if (engine == null) {
            synchronized (Engine.class) {
                if (engine == null) {
                    engine = new EngineImpl();
                }
            }
        }
        return engine;
    }

    /**
     * 执行促销引擎
     * @param promotionContext
     * @param promBills
     * @return
     */
    public static PromotionResult execute(PromotionContext promotionContext, PromotionBill... promBills) {
        Engine engine = EngineUtil.getEngineInstance();
        return engine.execute(promotionContext, promBills, MatcherUtil.getMatcherList().toArray(new Matcher[0]));
    }

}
