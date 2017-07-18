package jiyun.ytp.com.a20170629demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import jiyun.ytp.com.a20170629demo.User.User;

/**
 * Created by 因天鹏 on 2017/6/29.
 */

public class MainAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> mList;

    public MainAdapter(Context context, ArrayList<User> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainHolder mainHolder;
        if (convertView == null) {
            mainHolder = new MainHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            mainHolder.imageView = (ImageView) convertView.findViewById(R.id.list_item_image);
            mainHolder.name = (TextView) convertView.findViewById(R.id.list_item_name);
            mainHolder.number = (TextView) convertView.findViewById(R.id.list_item_number);
            mainHolder.address = (TextView) convertView.findViewById(R.id.list_item_address);
            convertView.setTag(mainHolder);
        } else {
            mainHolder = (MainHolder) convertView.getTag();
        }
        mainHolder.name.setText(mList.get(position).getName());
//        mainHolder.number.setText(mList.get(position).getAge());
        mainHolder.address.setText(mList.get(position).getAddress());
        return convertView;
    }

    class MainHolder {
        private TextView name, number,address;
        private ImageView imageView;
    }
}
