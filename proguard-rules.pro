# 添加项目特定的混淆规则
# 保留库模块的公共API
-keep class com.pic.preview.** { *; }
-keep interface com.pic.preview.** { *; }

# 保留注解
-keepattributes *Annotation*

# 保留数据绑定
-keep class androidx.databinding.** { *; }
-keep class * extends androidx.databinding.DataBinderMapper { *; }
-keep class * extends androidx.databinding.DataBindingComponent { *; }

# 保留Kotlin相关
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# 保留协程
-keep class kotlinx.coroutines.** { *; }

# 保留View相关的类和方法
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# 保留自定义View的getter和setter
-keepclassmembers class * extends android.view.View {
   void set*(***);
   *** get*();
}

# 保留Parcelable实现类
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}