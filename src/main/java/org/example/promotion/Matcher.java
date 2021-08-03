/**
 * 版权所有(C)，上海勾芒信息科技，2016，所有权利保留。
 * 
 * 项目名：	gomore-promotion
 * 文件名：	Caculator.java
 * 模块说明：	
 * 修改历史：
 * 2016年9月23日 - Debenson - 创建。
 */
package org.example.promotion;


/**
 * 促销条件计算器。
 * 
 */
public interface Matcher<C extends Condition, P extends PromotionContext> {

  /**
   * 判断是否支持计算当前促销条件。
   * 
   */
  boolean support(Condition condition, PromotionContext promotionContext);

  /**
   * 计算是否接受促销。
   * 
   * @return 促销计算结果。
   */
  boolean accept(C condition, P promotionContext);

}
