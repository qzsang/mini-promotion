package org.example.promotion.extension.condition;

import org.example.promotion.core.Condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合条件
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class CompositeCondition implements Condition {
    /**
     * 条件列表
     */
    private List<Condition> conditionList = new ArrayList<>();
    /**
     * 逻辑运算符
     */
    private Logical logical = Logical.AND;

    public CompositeCondition(Logical logical, Condition... conditions) {
        if (logical != null) {
            this.logical = logical;
        }
        if (conditions != null) {
            this.conditionList.addAll(Arrays.asList(conditions));
        }
    }
    /**
     * 添加促销条件。
     *
     * @param conditions
     */
    public void addCondition(Condition... conditions) {
        if (conditions != null) {
            for (Condition cond : conditions) {
                this.conditionList.add(cond);
            }
        }
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public Logical getLogical() {
        return logical;
    }

    public static CompositeCondition and(Condition... conditions) {
        return new CompositeCondition(Logical.AND, conditions);
    }

    @SuppressWarnings({
            "rawtypes", "unchecked" })
    public static CompositeCondition or(Condition... conditions) {
        return new CompositeCondition(Logical.OR, conditions);
    }


}
