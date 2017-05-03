package com.example.administrator.mvvmtest.customview;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2016/11/1.
 */

public class ProgressUtil {

    private Context context;
    private ProgressDialog progressDialog;

    public ProgressUtil(Context context){
        this.context =context;
    }

    public void showProgressDialog() {
        if (null == context) {
            return;
        }
        if (null == progressDialog) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void showProgressDialog(String title) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle(title);
        progressDialog.show();
    }

    public void closeProgerssDialog() {
        if (null != progressDialog && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

}
