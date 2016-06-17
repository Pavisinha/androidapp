package com.sinha.pavi.swp.adapter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinha.pavi.swp.Ism;
import com.sinha.pavi.swp.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by pavitrasinha on 14-06-2016.
 */
public class Sm extends BaseAdapter {



     private Context context;
    private List<Ism> item1;

    public Sm(Context context, List<Ism> item1) {
        this.context = context;
        this.item1 = item1;
    }

    @Override
    public int getCount() {



        return item1.size();
    }

    @Override
    public Object getItem(int position) {
        return item1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        View v=View.inflate(context, R.layout.ism,null);
        ImageView img=(ImageView)v.findViewById(R.id.iv);
        TextView txv=(TextView)v.findViewById(R.id.tv);
        Ism item=item1.get(position);
        img.setImageResource(item.getImgId());
        txv.setText(item.getTitle());



        return v;
    }
}
