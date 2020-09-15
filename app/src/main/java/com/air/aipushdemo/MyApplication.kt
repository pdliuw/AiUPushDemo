package com.air.aipushdemo

import android.app.Application
import android.util.Log
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent

/**
 * <p>
 * Created by air on 2020/9/14.
 * </p>
 */

/**
 * 经过多次的测试，得出如下结论：
 * 1、必须在这里初始化（Application），在其他（Activity）中初始化后出现一直'收不到消息'
 */
class MyApplication :Application(){
    private val TAG: String = "MyApplication"
    override fun onCreate() {
        super.onCreate()




        // 在此处调用基础组件包提供的初始化函数 相应信息可在应用管理 -> 应用信息 中找到 http://message.umeng.com/list/apps
        // 参数一：当前上下文context；
        // 参数二：应用申请的Appkey（需替换）；
        // 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机；
        // 参数五：Push推送业务的secret 填充Umeng Message Secret对应信息（需替换）
//        UMConfigure.init(this, "应用申请的Appkey", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "Push推送业务的secret 填充Umeng Message Secret对应信息");
        UMConfigure.init(this, "5f5f474d596d4d1c91f5fa92", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "d78fee08ea5f1605de82708f34463f05")

        //获取消息推送代理示例

        //获取消息推送代理示例
        val mPushAgent: PushAgent = PushAgent.getInstance(this)
//        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SERVER); //服务端控制声音


        //注册推送服务，每次调用register方法都会回调该接口
        //        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SERVER); //服务端控制声音


        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(object : IUmengRegisterCallback {
            override fun onSuccess(deviceToken: String) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG, "注册成功：deviceToken：-------->  $deviceToken")
            }

            override fun onFailure(s: String, s1: String) {
                Log.e(TAG, "注册失败：-------->  s:$s,s1:$s1")
            }
        })
    }
}