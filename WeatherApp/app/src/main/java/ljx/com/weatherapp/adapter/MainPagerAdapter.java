package ljx.com.weatherapp.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import ljx.com.weatherapp.R;
import ljx.com.weatherapp.model.Futures;
import ljx.com.weatherapp.utils.WeekUtil;

import static android.view.Gravity.CENTER_HORIZONTAL;


public class MainPagerAdapter extends PagerAdapter{
    private List<View> viewList;
    private List<Integer> viewListId;
    private Context context;
    private List<Futures> list;

    public MainPagerAdapter(Context context, List<View> viewList, List<Integer> viewListId,List<Futures> list) {
        this.context = context;
        this.viewList = viewList;
        this.viewListId = viewListId;
        this.list = list;

    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("SSSS", String.valueOf(position));
        View view = LayoutInflater.from(context).inflate(viewListId.get(position),null);
        for (Futures futures : list) {
            LinearLayout weatherLayout = view.findViewById(R.id.day_weather_layout);
            LinearLayout lin1 = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(400, LinearLayout.LayoutParams.WRAP_CONTENT,1);
            lin1.setGravity(CENTER_HORIZONTAL);
            lin1.setOrientation(LinearLayout.VERTICAL);
            lin1.setLayoutParams(params);
            TextView textViewDate = new TextView(context);
            TextView textViewTemp = new TextView(context);
            TextView textViewStatus = new TextView(context);
            TextView textViewWind = new TextView(context);
            ImageView imageView = new ImageView(context);
            String status ="status" + futures.getCond_code_d();
            int resID = container.getResources().getIdentifier(status, "drawable","ljx.com.weatherapp");
            //给viewHoder赋值
            imageView.setImageResource(resID);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(120,120);
            params1.setMargins(-80,10,0,0);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setLayoutParams(params1);
            Log.d("XXXXX",futures.toString());
            WeekUtil weekUtil = new WeekUtil();
            String week = weekUtil.getWeek(futures.getDate());
            textViewDate.setText(week);
            textViewTemp.setText(futures.getTmp_min()+"℃~"+futures.getTmp_max()+"℃");
            textViewWind.setText("风力"+futures.getWind_sc()+"级");
            textViewStatus.setText(futures.getCond_txt_d());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textViewDate.setTextAppearance(R.style.myTextView);
                textViewTemp.setTextAppearance(R.style.myTextView);
                textViewWind.setTextAppearance(R.style.myTextView);
                textViewStatus.setTextAppearance(R.style.myTextView);
            }

            lin1.addView(textViewDate);
            lin1.addView(imageView);
            lin1.addView(textViewTemp);
            lin1.addView(textViewWind);
            lin1.addView(textViewStatus);
            weatherLayout.addView(lin1);
            view.setTag(weatherLayout);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView(this.viewList.get(position));
    }
}