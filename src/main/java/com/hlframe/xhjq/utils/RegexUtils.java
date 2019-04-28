package com.hlframe.xhjq.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * company:华量软件有限公司
 * author:fanjh
 * data:2018.11.20
 */
public class RegexUtils {
    private List list;

    /**
     * 获取中括号内的字符串(含中括号),例如: (jdj---[aaa,bbb]ooo;) 转化后 [aaa,bbb]
     * @param words
     * @return
     */
    public static String getStringWithBracket(String words){
        List<String> list=new ArrayList<String>();
        Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
        Matcher m = p.matcher(words);
        while(m.find()){
            list.add(m.group().substring(1, m.group().length()-1));
        }
        return list.toString();
    }

    /**
     * 获取中括号内的字符串(不含中括号),例如: (jdj---[aaa,bbb]aty;) 转化后 aaa,bbb
     * @param words
     * @return
     */
    public static String getStringWithoutBracket(String words){
        List<String> list=new ArrayList<String>();
        Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
        Matcher m = p.matcher(words);
        while(m.find()){
            list.add(m.group().substring(1, m.group().length()-1));
        }
        return list.toString().substring(1,list.toString().length()-1);
    }
}
