package com.android.tonight8.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import com.android.tonight8.ui.activity.other.CaptureActivity;

/**
 * @author liuzhao
 * @Description：Intent管理类
 * @date 2015-3-7下午5:20:48
 */
public class IntentUtils {

    /**
     * @Description：打电话（直接拨打）
     * @date 2015-3-7下午5:20:40
     * @author liuzhao
     */
    public static void startCallPhone(Context context, String phoneNumber) {
        context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + phoneNumber)));
    }

    /**
     * @Description：打电话（跳转到拨号界面）
     * @date 2015-3-7下午5:20:40
     * @author liuzhao
     */
    public static void showCallPhoneDialog(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                + phoneNumber));

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * @Description：打电话（跳转到联系人界面）
     * @date 2015-3-7下午5:20:40
     * @author liuzhao
     */
    public static void startContactsPage(Context context, String phoneNumber) {
        Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + phoneNumber));
        context.startActivity(intentPhone);
    }

    /**
     * @Description：跳转到二维码扫描界面
     * @date 2015-3-18下午12:02:53
     * @author liuzhao
     */
    public static void startQRScanCodeActivity(Activity activity,
                                               int requestCode) {
        Intent intent = new Intent();
        // google对4.4的uri做了点改动 为了适配多种手机 需要做一个判断版本
        if (Build.VERSION.SDK_INT < 19) {
            intent.setAction(Intent.ACTION_GET_CONTENT);
        } else {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
        }
        // intent.setClass(activity, MipcaActivityCapture.class);
        intent.setClass(activity, CaptureActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * @Description：录视频
     * @date 2015-3-7下午5:20:40
     * @author liuzhao
     */
    public static void startVideo(Context context, int requestCode) {
        String VIDEO_UNSPECIFIED = "video/*";
        //视频
        Intent innerIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        innerIntent.putExtra(android.provider.MediaStore.EXTRA_SIZE_LIMIT,
                768000);
        //设置视频时间 毫秒单位
        innerIntent.putExtra(
                android.provider.MediaStore.EXTRA_DURATION_LIMIT, 45000);
        ((Activity) context).startActivityForResult(innerIntent, requestCode);
    }

    /**
     * @Description：录音
     * @date 2015-3-7下午5:20:40
     * @author liuzhao
     */
    public static void startAudio(Context context, int requestCode) {
        String AUDIO_AMR = "audio/amr";
        //录音
        Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

}
