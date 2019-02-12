package com.project.nightmode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import com.project.nightmode.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ui_mode", Context.MODE_PRIVATE);

        boolean isNight=sharedPreferences.getBoolean("isNight",false);
        if (isNight){
            //夜间模式
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main);
        binding.setPresenter(this);
    }


    /**
     * 切换夜间模式
     */
    public void DayNightClicked(){
        int currentMode=getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_MASK;
        if (currentMode!=Configuration.UI_MODE_NIGHT_YES){

            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean("isNight",true);
            editor.commit();
            //夜间模式
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean("isNight",false);
            editor.commit();
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();

//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.anim_start,R.anim.anim_start);
//        finish();
    }


}
