package com.qiein.erp.pk.util;

import java.util.List;

/**
 * author ：xiangliang 2018/11/18
 */
public class ListUtil {
    /**
     * 根据keys 批量remove list中的元素
     * @param list
     * @param keys
     */
    public static void removeKeys(List<?> list,List<Integer> keys){
        int count=0;
        for(int i:keys){
            i-=count;
            list.remove(i);
            count++;
        }
    }
}
