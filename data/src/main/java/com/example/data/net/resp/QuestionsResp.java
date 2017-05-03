package com.example.data.net.resp;

import com.example.data.entity.Question;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public class QuestionsResp {

    private int error = -1;
    private String msg = "nodata";
    private List<Question> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Question> getData() {
        return data;
    }

    public void setData(List<Question> data) {
        this.data = data;
    }
}
