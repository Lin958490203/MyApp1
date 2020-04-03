package cn.edu.sdwu.android.classroom.sn170507180207.myapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ch4Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_2);

        //单选框
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.ch4_2_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i){
                //第二个参数代表当前选中的radiobutton的ID
                RadioButton radioButton=(RadioButton) findViewById(i);
                Object object=radioButton.getTag();
                TextView textView=(TextView)findViewById(R.id.ch4_2_tv);
                if(object!=null&&object.toString().equals("1")){
                    textView.setText("true");
                }else{
                    textView.setText("false");
                }
            }
        });
    }
}
