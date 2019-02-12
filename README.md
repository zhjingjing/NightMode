# NightMode
android 夜间模式实现
  首先设置apptheme

 <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.DayNight">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

 添加value-night路径，设置夜间模式下的color文件。
正常的color文件： 

<resources>
    <color name="colorPrimary">#008577</color>
    <color name="colorPrimaryDark">#00574B</color>
    <color name="colorAccent">#D81B60</color>

    <color name="text_color">#24256e</color>
</resources>

  夜间模式下的color文件：

<resources>
    <color name="colorPrimary">#008577</color>
    <color name="colorPrimaryDark">#00574B</color>
    <color name="colorAccent">#D81B60</color>

    <color name="text_color">#FFFFFF</color>
</resources>
 接着layout文件中textview设置文字颜色为text_color;

获取当前mode的值：

int currentMode=getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_MASK;
根据currentMode判断是否是夜间模式；

其中mode主要有四种：

public static final int MODE_NIGHT_NO = 1; //亮色(light)主题，不使用夜间模式
public static final int MODE_NIGHT_YES = 2;//暗色(dark)主题，使用夜间模式
public static final int MODE_NIGHT_AUTO = 0;//根据当前时间自动切换 亮色(light)/暗色(dark)主题
public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;//设置为跟随系统
这里只判断是否是夜间：

if (currentMode!=Configuration.UI_MODE_NIGHT_YES){
    //夜间模式
     AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }else {
          
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
}
recreate();


记得一定要添加recreat()方法。。。




但是这么写会有个问题。recreat()方法调用会闪屏。。

这里有俩方案，自己选择下：

1：在style中添加

<item name="android:windowAnimationStyle">@android:style/Animation.Toast</item>
2：不使用recreat()方法，重新startactivity并添加跳转动画。
