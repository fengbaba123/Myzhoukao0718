package jiyun.ytp.com.a20170629demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import jiyun.ytp.com.a20170629demo.User.DaoMaster;
import jiyun.ytp.com.a20170629demo.User.DaoSession;
import jiyun.ytp.com.a20170629demo.User.User;
import jiyun.ytp.com.a20170629demo.User.UserDao;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private MainAdapter adapter;
    private ArrayList<User> mList;
    private UserDao userDao;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.main_list);
        listView.setOnItemClickListener(this);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MainActivity.this, "ytp", null);
        DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(null, 0, "姓名" + i, i, "地址" + i);
            userDao.insert(user);
            mList.add(user);
        }
        adapter = new MainAdapter(MainActivity.this, mList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        //TODO 下面注释的dialog不能dismiss
//        final AlertDialog.Builder dialog = new AlertDialog.Builder(
//                MainActivity.this);
//        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog, null);
//        dialog.setView(view1);
//        Button button = (Button) view1.findViewById(R.id.dialog_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mList.remove(mList.get(position));
//                userDao.deleteByKey(mList.get(position).getId());
//                adapter.notifyDataSetChanged();
//                handler.sendEmptyMessage(0);
////                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
        //TODO 这个就是不太好看  选哪个你自己看
        Dialog dialog = new AlertDialog.Builder(MainActivity.this)
//                .setNegativeButton("quxiao", null)
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mList.remove(mList.get(position));
                        userDao.deleteByKey(mList.get(position).getId());
                        handler.sendEmptyMessage(0);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        dialog.show();
    }
}
