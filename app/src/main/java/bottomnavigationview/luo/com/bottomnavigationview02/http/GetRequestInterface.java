package bottomnavigationview.luo.com.bottomnavigationview02.http;

import bottomnavigationview.luo.com.bottomnavigationview02.bean.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by luo on 2019/7/8.
 */

public interface GetRequestInterface {
    /**
     * http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAppsByCategory&cid=1&start=0&count=99
     *  cid：类别id,类别已知：
     *  start：跳过的记录数
     *  count：返回的数量
     *  1：每日精选
     *  5：游戏
     *  6：美女
     *  9：风景
     *  10：视觉创意
     *  11：明星影视
     *  12：汽车
     *  14：萌宠动物
     *  15：小清新
     *  16：体育
     *  22：军事
     *  26：动漫卡通
     *  30：情感
     *  35：文字
     *
     *
     * 解析
     * total：返回数据数量
     * data：返回的数据
     * pid：
     * cid：类别ID
     * url：壁纸地址
     * fav_total：收藏数
     */

    public static String HOST = "http://wallpaper.apc.360.cn/";

    @GET("index.php")
    Call<BaseResponse> getCall(@Query("c") String WallPaperAndroid, @Query("a") String getAppsByCategory,
                               @Query("cid") int cid, @Query("start") int start, @Query("count") int count);
}
