package com.cracktheterm.pttreader;

import org.junit.Test;
import static org.junit.Assert.*;

public class HotArticleTests {
    @Test
    public void testHotArticle() {
        HotArticle sut = new HotArticle();
        sut.hot_num = "84";
        sut.author = "leopika.";
        sut.title = "[問卦] 這是不是今日最好看的影片";
        sut.board_name = "Gossiping";
        sut.desc = "這是不是今日最好看的影片 從37分開始 可以看盡人生百態 這部影片我會一直保存下去 給我的子子孫孫觀看…";
        sut.url = "http://disp.cc/b/163-c04v";

        HotArticle expected = new HotArticle();
        expected.hot_num = "84";
        expected.author = "leopika.";
        expected.title = "[問卦] 這是不是今日最好看的影片";
        expected.board_name = "Gossiping";
        expected.desc = "這是不是今日最好看的影片 從37分開始 可以看盡人生百態 這部影片我會一直保存下去 給我的子子孫孫觀看…";
        expected.url = "http://disp.cc/b/163-c04v";

        assertEquals(expected.hot_num, sut.hot_num);
        assertEquals(expected.author, sut.author);
        assertEquals(expected.title, sut.title);
        assertEquals(expected.board_name, sut.board_name);
        assertEquals(expected.desc, sut.desc);
        assertEquals(expected.url, sut.url);
    }
}
