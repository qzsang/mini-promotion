package org.example.promotion.application.context.matcher; /**
 * 版权所有(C)，上海勾芒信息科技，2016，所有权利保留。
 * 
 * 项目名：	gomore-promotion
 * 文件名：	CountCaculator.java
 * 模块说明：	
 * 修改历史：
 * 2016年11月2日 - Debenson - 创建。
 */

import org.example.promotion.application.condition.SpellWordCondition;
import org.example.promotion.application.context.OrderContext;
import org.example.promotion.extension.matcher.BaseMatcher;
import java.util.List;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/27
 */
public class SpellWordMatcher extends BaseMatcher<SpellWordCondition, OrderContext> {

  public SpellWordMatcher() {
    super(SpellWordCondition.class, OrderContext.class);
  }


  @Override
  public boolean accept(SpellWordCondition condition, OrderContext promotionContext) {
    boolean accept = false;
    if (condition == null || condition.getWord().length() <= 0 ||
            promotionContext == null || promotionContext.getGoodsList() == null || promotionContext.getGoodsList().size() <= 0) {
      return accept;
    }
    // 得到列表
    List<OrderContext.Goods> detailList =  promotionContext.getGoodsList();
    StringBuilder stringBuilder = new StringBuilder();
    detailList.forEach(item -> {
      if (item != null  && item.getName() != null) {
        stringBuilder.append(item.getName());
      }
    });
    String goodsNameAppendString = stringBuilder.toString();

    accept = true;
    // 如果有其中一个字不存在 则表示不符合
    for (char c : condition.getWord().toCharArray()) {
      if (goodsNameAppendString.indexOf(c) < 0) {
        accept = false;
        break;
      }
    }
    return accept;
  }

}
