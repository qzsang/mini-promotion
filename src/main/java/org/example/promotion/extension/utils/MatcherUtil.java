package org.example.promotion.extension.utils;

import org.example.promotion.core.Matcher;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author qzs
 * @email 631706099@qq.com
 * @date 2021/8/3
 */
public class MatcherUtil {

    private static List<Matcher> matcherList;
    private static final String SCAN_PACKAGE = "org.example.promotion";

    public static List<Matcher> getMatcherList () {
        if (matcherList == null) {
            synchronized (MatcherUtil.class) {
                if (matcherList == null) {
                    // 实例化Reflections，并指定要扫描的包名
                    Reflections reflections = new Reflections(SCAN_PACKAGE);
                    Set<Class<? extends Matcher>> subTypes = reflections.getSubTypesOf(Matcher.class);
                    matcherList = new ArrayList<>(subTypes.size());
                    for (Class clazz : subTypes) {
                        if (Modifier.isAbstract(clazz.getModifiers())) {
                            continue;
                        }
                        try {
                            matcherList.add((Matcher) clazz.newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                            throw new RuntimeException("matcher实例化失败");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            throw new RuntimeException("matcher实例化失败");
                        }
                    }
                }
            }
        }
        return matcherList;
    }


}
