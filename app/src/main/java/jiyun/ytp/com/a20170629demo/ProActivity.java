package jiyun.ytp.com.a20170629demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by 因天鹏 on 2017/6/29.
 */

public class ProActivity extends Activity {
    //    private Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Intent intent = new Intent(ProActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
        ProgressDialog dialog = new ProgressDialog(this);
        dialog = new ProgressDialog(ProActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
        dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        dialog.setTitle("正在读取数据...");
        dialog.setMax(100);
        dialog.show();
        final ProgressDialog finalDialog = dialog;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(500);
                        // 更新进度条的进度,可以在子线程中更新进度条进度
                        finalDialog.incrementProgressBy(10);
                        // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式
                        i += 10;

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                // 在进度条走完时删除Dialog
                finalDialog.dismiss();

                Intent intent = new Intent(ProActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();

    }
}
