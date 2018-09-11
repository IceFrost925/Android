package ljx.com.oncespance;

import android.app.ActionBar;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class TouchActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        imageView = findViewById(R.id.iv_img);
        textView = findViewById(R.id.tv_img_location);
        imageView.setOnTouchListener(this);
//        sendNormalNotification();
        sendNormalNotification2();
//        sendNormalNotification3();
    }

    private float deltaX;
    private float deltaY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float X = event.getX();
        float Y = event.getY();
        textView.setText(getResources().getString(R.string.location, X, Y));
//        textView.setText(String.format(getResources().getString(R.string.location,X,Y)));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();
        //当触屏按下的时候计算所在点的位置（X，Y）的偏移
        //当触点移动时计算与按下时的位置的偏移，将图标的参数LayoutPatams更改为移动后的偏移，重绘图片


        //让图片在可是区域活动 1.先获得区域大小 ，然后做判断
        Rect rect = new Rect();
        getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(rect);


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                deltaX = X - params.leftMargin;
                deltaY = Y - params.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                float distanceX = X - deltaX;
                float distanceY = Y - deltaY;
                //判断时候超出边界
                if (distanceX >= rect.left && distanceX <= rect.right && distanceY >= rect.top &&
                        distanceY <= rect.bottom) {
                    params.leftMargin = (int) distanceX;
                    params.topMargin = (int) distanceY;
                    v.setLayoutParams(params);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        v.invalidate();
        return true;
    }


    private long startTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - startTime > 2000) {
                Toast.makeText(TouchActivity.this, "在按一次退出", Toast.LENGTH_SHORT).show();
                startTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
        }
        return true;
    }

    public void sendNormalNotification() {
        //创建通知
        Notification.Builder builder = null;
        //自定义通知  针对8.0  /挂在Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel notificationChannel = new NotificationChannel("normal", "正常通知", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(TouchActivity.this, id);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        } else {
            builder = new Notification.Builder(TouchActivity.this);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        }
        //发送
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(1, builder.build());
        }
    }

    //折叠通知
    public void sendNormalNotification2() {
        //创建通知
        Notification.Builder builder = null;
        //自定义通知  针对8.0  /挂在Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel notificationChannel = new NotificationChannel("normal", "正常通知", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(TouchActivity.this, id);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        } else {
            builder = new Notification.Builder(TouchActivity.this);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        }
        //利用remoteVIews显示自定义通知的视图
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_fold);
        RemoteViews remoteViews_s = new RemoteViews(getPackageName(), R.layout.statusbar);
        Notification notification = builder.build();
        notification.contentView = remoteViews_s;
        notification.bigContentView = remoteViews;
        //发送
        notification.flags = Notification.FLAG_SHOW_LIGHTS;
        manager.notify(1, notification);
    }

    //悬挂通知
    public void sendNormalNotification3() {
        //创建通知
        Notification.Builder builder = null;
        //自定义通知  针对8.0  /挂在Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "normal";
            NotificationChannel notificationChannel = new NotificationChannel("normal", "正常通知", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(TouchActivity.this, id);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setFullScreenIntent(pendingIntent,true)       //悬挂式通知设定
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        } else {
            builder = new Notification.Builder(TouchActivity.this);
            builder.setSmallIcon(R.drawable.avatar_ljx)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_ljx))
                    .setContentTitle("普通通知")
                    .setContentText("通知内容")
                    .setFullScreenIntent(pendingIntent,true)       //悬挂式通知设定
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
      }
       /*   //利用remoteVIews显示自定义通知的视图
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_fold);
        Notification notification = builder.build();
        notification.contentView =
                notification.bigContentView = remoteViews;*/
        //发送
        Intent hIntent = new Intent();
        hIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hIntent.setClass(this, MainActivity.class);

        PendingIntent hangIntent = PendingIntent.getActivity(TouchActivity.this,0,hIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setFullScreenIntent(hangIntent,true);
        manager.notify(1, builder.build());
    }
}
