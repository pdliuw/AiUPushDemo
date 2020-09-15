# 友盟推送 Demo




<details>
<summary>Proguard</summary>

在"proguard-rules.pro"文件中添加：


```

        #（友盟推送--start）
        -dontwarn com.umeng.**
        -dontwarn com.taobao.**
        -dontwarn anet.channel.**
        -dontwarn anetwork.channel.**
        -dontwarn org.android.**
        -dontwarn org.apache.thrift.**
        -dontwarn com.xiaomi.**
        -dontwarn com.huawei.**
        -dontwarn com.meizu.**
        
        -keepattributes *Annotation*
        
        -keep class com.taobao.** {*;}
        -keep class org.android.** {*;}
        -keep class anet.channel.** {*;}
        -keep class com.umeng.** {*;}
        -keep class com.xiaomi.** {*;}
        -keep class com.huawei.** {*;}
        -keep class com.meizu.** {*;}
        -keep class org.apache.thrift.** {*;}
        
        -keep class com.alibaba.sdk.android.**{*;}
        -keep class com.ut.**{*;}
        -keep class com.ta.**{*;}
        ##（根据'友盟官方文档'操作后：启动混淆后会导致启动App时崩溃闪退，加入此代码可解决此问题（此代码"友盟官方"没有提供！太坑了😭）-start）
        -keep class com.uc.**{*;}
        ##（根据'友盟官方文档'操作后：启动混淆后会导致启动App时崩溃闪退，加入此代码可解决此问题（此代码"友盟官方"没有提供！太坑了😭）-end）
        
        -keep public class **.R$*{
           public static final int *;
        }
        
        # yourpackage : 项目的packageName/applicationId
        -keep public class yourpackage.R$*{
           public static final int *;
        }
        -keepclassmembers class * {
           public <init>(org.json.JSONObject);
        }
        #（友盟推送--end）

```

</details>