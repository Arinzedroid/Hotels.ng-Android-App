package ng.hotels.android.app.adapters;

/**
 * Created by Arinze on 10/6/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ng.hotels.android.app.R;

public class HelpAdapter extends BaseAdapter {

    private  Context context;
    private String ArticleList[];
    private int Icons;
    private  LayoutInflater inflater;

    public HelpAdapter(Context applicationContext, String[] articleList) {
        this.context = applicationContext;
        this.ArticleList = articleList;
        //this.Icons = icons;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return ArticleList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layout_listview,null);
        TextView article =  view.findViewById(R.id.textView);
        ImageView icon =  view.findViewById(R.id.icon);
        article.setText(ArticleList[i]);
        icon.setImageResource(R.drawable.hotel_logo);
        return view;

    }
}