package cn.edu.sdwu.android.classroom.sn170507180207.myapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch51);

    }
    public void toast1(View view){
        Toast.makeText(this,"toast1",Toast.LENGTH_LONG).show();
    }
    public void toast2(View view){
        Toast toast=Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);//设置显示的位置
        toast.show();//显示
    }
    public void toast3(View view){
        //加载自定义的布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.layout_toast,null);

        //设置显示文本
        TextView textView=(TextView) view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");

        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面样式
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);
        //在构造器中，完成通知各种属性的设置
        builder.setContentText("title");
        builder.setContentTitle("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源

        Intent intent=new Intent(this,Ch6Activity1.class);//点击通知之后，跳转的界面
        PendingIntent pendingIntent=PendingIntent.getActivity(this,101,intent,PendingIntent.FLAG_CANCEL_CURRENT);//这个类代表待办通知
        builder.setContentIntent(pendingIntent);
        //调用build方法 完成构造
        Notification notification=builder.build();
        //使用NotificationManager,发送通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification); //第一个参数为编号 (标记)
    }
    public void cancel_notification(View view){
        //使用NotificationManager 取消通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }
    public void alert_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //在构造器中设置对话框的属性
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        //确认按钮
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击按键后的处理
                Toast.makeText(Ch5Activity1.this,"confirm",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"exit",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"cancel",Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();


    }
}
