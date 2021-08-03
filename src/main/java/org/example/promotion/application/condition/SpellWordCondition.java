package org.example.promotion.application.condition;

import org.example.promotion.core.Condition;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/7/27
 */
public class SpellWordCondition implements Condition {
    /**
     * 拼写的目标单词
     */
    private String word;

    public void setWord(String word) {
        if (word == null || word.trim().length() <= 0) {
            throw new RuntimeException("目标文字不正确");
        }
        this.word = word.trim();
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "org.example.promotion.application.condition.SpellWordCondition{" +
                "word='" + word + '\'' +
                '}';
    }
}
