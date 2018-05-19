package com.example.anujdawar.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class productListAdapter extends BaseAdapter{

    private Context mContext;
    private List<product> mProductList;

    public productListAdapter(Context mContext, List<product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.text_views, null);
        TextView tvCommand = (TextView) v.findViewById(R.id.commandID);
        TextView tvdev1 = (TextView) v.findViewById(R.id.tv_dev1ID);
        TextView tvdev2 = (TextView) v.findViewById(R.id.tv_dev2ID);
        TextView tvdev3 = (TextView) v.findViewById(R.id.tv_dev3ID);
        TextView tvdev4 = (TextView) v.findViewById(R.id.tv_dev4ID);
        TextView tvdev5 = (TextView) v.findViewById(R.id.tv_dev5ID);

        tvCommand.setText(mProductList.get(i).getMyCommand());
        tvdev1.setText(String.valueOf(mProductList.get(i).getDev1()));
        tvdev2.setText(String.valueOf(mProductList.get(i).getDev2()));
        tvdev3.setText(String.valueOf(mProductList.get(i).getDev3()));
        tvdev4.setText(String.valueOf(mProductList.get(i).getDev4()));
        tvdev5.setText(String.valueOf(mProductList.get(i).getDev5()));

        v.setTag(mProductList.get(i).getID());

        return v;
    }
}
