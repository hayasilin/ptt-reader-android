package com.cracktheterm.pttreader;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kuan-weilin on 3/18/18.
 */

public class HotArticle implements Serializable {

    String hot_num = "";
    String bi = "";
    String ti = "";
    String ai = "";
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
