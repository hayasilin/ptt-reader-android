package com.cracktheterm.pttreader;

import java.io.Serializable;

/**
 * Created by kuan-weilin on 3/18/18.
 */

public class HotArticle implements Serializable {

    String hot_num = "";
    String author = "";
    String title = "";
    String board_name = "";
    String desc = "";
    String url = "";

    public HotArticle(){
        super();
    }

    @Override
    public String toString(){
        return this.title;
    }
}
