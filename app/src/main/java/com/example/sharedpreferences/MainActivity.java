package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*三种创建SharedPreferences对象的方法
1.COntext类中的getSharedPreferences()方法，接收两个参数，第一个参数指定文件名（如果不存在则创建一个），第二个参数指定操作模式

2.Activity类中的getPreferences()方法，只接受一个操作模式参数，使用这个方法时会自动将当前活动类名作为SharedPreferences的文件名

3.PreferenceManager类中的getDefaultSharedPreferences()方法，是一个静态方法，接收一个Context参数，并自动使用当前程序的包名作为文件名，
得到对象之后开始向其中存储数据
    a.调用SP对象的Edit()方法，来获取SP.Editor对象
    b.向SharedPreferences.Editor对象中添加数据，添加数据使用putXxx()方法
    c.调用apply()方法提交数据
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = (Button)findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
                Toast.makeText(MainActivity.this,"Succeded",Toast.LENGTH_LONG).show();
            }
        });

        Button restorData = (Button)findViewById(R.id.restore_data);
        restorData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age",0);
                boolean married = pref.getBoolean("married", false);
                Log.d("MainActivity","name is " + name);
                Log.d("MainActivity","age is " + age);
                Log.d("MainActivity","married is " + married);
            }
        });
    }
}
