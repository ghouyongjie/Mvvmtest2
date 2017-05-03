package com.example.data.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.data.BR;

/**
 * Created by Administrator on 2016/10/31.
 */

public class Question {

    private String id;
    private String askName;
    private String content;
    private String title;
    private int price;

    public String getPrice() {
        return String.format("%.2f",price/100.0);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAskName() {
        return askName;
    }

    public void setAskName(String askName) {
        this.askName = askName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", askName='" + askName + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
