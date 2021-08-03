package case1;

import org.example.promotion.core.Action;

import java.math.BigDecimal;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/27
 */
public class SpellWordAction implements Action {
    /**
     * 目标折扣
     */
    private BigDecimal discountRate;

    public void setDiscountRate(BigDecimal discountRate) {
        if (discountRate == null || discountRate.doubleValue() < 0
                || discountRate.doubleValue() >= 1) {
            throw new RuntimeException("折扣范围不正确");
        }
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "case1.SpellWordAction{" +
                "discountRate=" + discountRate +
                '}';
    }
}
