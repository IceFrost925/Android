package ljx.com.weatherapp.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import ljx.com.weatherapp.R;
import static android.view.Gravity.CENTER_HORIZONTAL;


public class MainPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private List<Integer> viewListId;
    private Context context;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public MainPagerAdapter(Context context, List<View> viewList, List<Integer> viewListId) {
        this.context = context;
        this.viewList = viewList;
        this.viewListId = viewListId;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("SSSS", String.valueOf(position));
        View view = LayoutInflater.from(context).inflate(viewListId.get(position),null);
        for (int i = 0; i < 3; i++) {
            LinearLayout weatherLayout = view.findViewById(R.id.day_weather_layout);
            /*dayView.imageView = view.findViewById(R.id.day_weather_img);
            dayView.textViewDate = view.findViewById(R.id.day_weather_date);
            dayView.textViewTemp = view.findViewById(R.id.day_weather_temp);
            dayView.textViewWind = view.findViewById(R.id.day_weather_wind);
            dayView.textViewStatus = view.findViewById(R.id.day_weather_status);*/
            LinearLayout lin1 = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.WRAP_CONTENT,1);
            lin1.setGravity(CENTER_HORIZONTAL);
            lin1.setOrientation(LinearLayout.VERTICAL);

            lin1.setLayoutParams(params);
            TextView textViewDate = new TextView(context);
            TextView textViewTemp = new TextView(context);
            TextView textViewStatus = new TextView(context);
            TextView textViewWind = new TextView(context);
            ImageView imageView = new ImageView(context);

            //给viewHoder赋值
            imageView.setImageResource(R.drawable.biz_plugin_weather_qing);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(120,120);
            params1.setMargins(-80,10,0,0);

            imageView.setLayoutParams(params1);
            textViewDate.setText("星期四");
            textViewTemp.setText("22℃~29℃");
            textViewWind.setText("风力3级");
            textViewStatus.setText("阴");
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
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}