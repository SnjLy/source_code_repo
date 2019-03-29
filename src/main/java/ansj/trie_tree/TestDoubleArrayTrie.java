package ansj.trie_tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Package: ansj.trie_tree
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 20/03/2019.
 */
@RunWith(JUnit4.class)
public class TestDoubleArrayTrie {

    /**
     * 检索key的前缀命中了词典中的哪些词<br>
     * key的前缀有多个，所以有可能命中词典中的多个词
     */
    @Test
    public void testPrefixMatch() {
        DoubleArrayTrie adt = new DoubleArrayTrie();
        List<String> list = new ArrayList<String>();
        list.add("阿胶");
        list.add("阿拉伯");
        list.add("阿拉伯人");
        list.add("埃及");
        // 所有词必须先排序
        Collections.sort(list);
        // 构建DoubleArrayTrie
        adt.build(list);
        String key = "阿拉伯人";
        // 检索key的前缀命中了词典中的哪些词
        List<Integer> rect = adt.commonPrefixSearch(key);
        for (int index : rect) {
            System.out.println("前缀  " + list.get(index) + " matched");
        }
        System.out.println("=================");
    }

    /**
     * 检索key是否完全命中了词典中的某个词
     */
    @Test
    public void testFullMatch() {
        DoubleArrayTrie adt = new DoubleArrayTrie();
        List<String> list = new ArrayList<String>();
        list.add("阿胶");
        list.add("阿拉伯");
        list.add("阿拉伯人");
        list.add("埃及");
        // 所有词必须先排序
        Collections.sort(list);
        // 构建DoubleArrayTrie
        adt.build(list);
        String key = "阿拉";
        // 检索key是否完全命中了词典中的某个词
        int index = adt.exactMatchSearch(key);
        if (index >= 0) {
            System.out.println(key + " match " + list.get(index));
        } else {
            System.out.println(key + " not match any term");
        }
        key = "阿拉伯";
        index = adt.exactMatchSearch(key);
        if (index >= 0) {
            System.out.println(key + " match " + list.get(index));
        } else {
            System.out.println(key + " not match any term");
        }
        key = "阿拉伯人";
        index = adt.exactMatchSearch(key);
        if (index >= 0) {
            System.out.println(key + " match " + list.get(index));
        } else {
            System.out.println(key + " not match any term");
        }
        System.out.println("=================");
    }
}
