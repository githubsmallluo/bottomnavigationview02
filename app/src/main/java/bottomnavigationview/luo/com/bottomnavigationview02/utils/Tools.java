package bottomnavigationview.luo.com.bottomnavigationview02.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;

/**
 * Created by luo on 2019/7/30.
 */

public class Tools {

    public static final String WallPaperAndroid = "WallPaperAndroid";
    public static final String GetAppsByCategory = "getAppsByCategory";
    public static final int Daily_Selection = 1;
    public static final int Game = 5;
    public static final int Beautiful_Girl = 6;
    public static final int Scenery = 9;
    public static final int Visual_Creativity = 10;
    public static final int Star = 11;
    public static final int Car = 12;
    public static final int Animal = 14;
    public static final int Small_Fresh = 15;
    public static final int Sports = 16;
    public static final int Military = 22;
    public static final int Cartoon = 26;
    public static final int Emotion = 30;
    public static final int Written_Words = 35;

    /**
     * 解决setImageResource如果如果图片超过1m会出现oom的问题
     *
     * @param context
     * @param resId
     * @return
     */
    public static Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
