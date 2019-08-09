package bottomnavigationview.luo.com.bottomnavigationview02.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import bottomnavigationview.luo.com.bottomnavigationview02.MainActivity;
import bottomnavigationview.luo.com.bottomnavigationview02.R;
import bottomnavigationview.luo.com.bottomnavigationview02.adapter.WallpaperPaperAdapter;
import bottomnavigationview.luo.com.bottomnavigationview02.wallpaper.Fragment_Classification;
import bottomnavigationview.luo.com.bottomnavigationview02.wallpaper.Fragment_Local;
import bottomnavigationview.luo.com.bottomnavigationview02.wallpaper.Fragment_Recommend;

/**
 * Created by luo on 2019/7/2.
 */

public class WallpaperFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private MainActivity mainActivity;

    private View wallpaperView;
    private RadioButton mRecommend;
    private RadioButton mClassification;
    private RadioButton mLocal;
    private RadioGroup mWallpaperRg;
    private ViewPager mWallpaperVp;
    private List<Fragment> mList;

    private Fragment_Recommend fragment_recommend;
    private Fragment_Classification fragment_classification;
    private Fragment_Local fragment_local;

    private WallpaperPaperAdapter wallpaperPaperAdapter;
    private TextPaint textPaint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        wallpaperView = inflater.inflate(R.layout.fragment_wallpaper, container, false);
        initData();
        initView();
        return wallpaperView;
    }

    private void initView() {
        mRecommend = (RadioButton) wallpaperView.findViewById(R.id.recommend);
        mClassification = (RadioButton) wallpaperView.findViewById(R.id.classification);
        mLocal = (RadioButton) wallpaperView.findViewById(R.id.local);
        mWallpaperRg = (RadioGroup) wallpaperView.findViewById(R.id.wallpaper_rg);
        mWallpaperVp = (ViewPager) wallpaperView.findViewById(R.id.wallpaper_vp);

        mWallpaperRg.setOnCheckedChangeListener(this);

        mWallpaperVp.setAdapter(wallpaperPaperAdapter);
        mWallpaperVp.addOnPageChangeListener(this);
        mWallpaperVp.setOffscreenPageLimit(mList.size() - 1);
    }

    private void initData() {
        mList = new ArrayList<Fragment>();
        //实例化List数组
        fragment_recommend = new Fragment_Recommend();
        fragment_classification = new Fragment_Classification();
        fragment_local = new Fragment_Local();

        mList.add(fragment_recommend);
        mList.add(fragment_classification);
        mList.add(fragment_local);

        wallpaperPaperAdapter = new WallpaperPaperAdapter(getChildFragmentManager(), mList);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        clearState();
        switch (checkedId) {
            case R.id.recommend:
                Log.d("lcr", "mWallpaperVp 0 ->");
                mWallpaperVp.setCurrentItem(0);
                Log.d("lcr", "recommend ->");
                mRecommend.setTextColor(Color.BLACK);
                mRecommend.setTextSize(20);
                textPaint = mRecommend.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            case R.id.classification:
                Log.d("lcr", "mWallpaperVp 1 ->");
                mWallpaperVp.setCurrentItem(1);
                Log.d("lcr", "classification ->");
                mClassification.setTextColor(Color.BLACK);
                mClassification.setTextSize(20);
                textPaint = mClassification.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            case R.id.local:
                Log.d("lcr", "mWallpaperVp 2 ->");
                mWallpaperVp.setCurrentItem(2);
                Log.d("lcr", "local ->");
                mLocal.setTextColor(Color.BLACK);
                mLocal.setTextSize(20);
                textPaint = mLocal.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            default:
                break;

        }
    }

    //滑动过程中的动作
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //选择某个页面松手后会被调用
    @Override
    public void onPageSelected(int position) {
        clearState();
        switch (position) {
            case 0:
                mRecommend.setChecked(true);
                mRecommend.setTextColor(Color.BLACK);
                mRecommend.setTextSize(20);
                textPaint = mRecommend.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            case 1:
                mClassification.setChecked(true);
                mClassification.setTextColor(Color.BLACK);
                mClassification.setTextSize(20);
                textPaint = mClassification.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            case 2:
                mLocal.setChecked(true);
                mLocal.setTextColor(Color.BLACK);
                mLocal.setTextSize(20);
                textPaint = mLocal.getPaint();
                textPaint.setFakeBoldText(true);
                break;
            default:
                break;

        }
    }

    //手指放上去，松开，拖动都会被调用
    //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //初始化底部导航栏
    private void clearState() {
        mRecommend.setTextColor(getResources().getColor(R.color.wallpaper_title));
        mClassification.setTextColor(getResources().getColor(R.color.wallpaper_title));
        mLocal.setTextColor(getResources().getColor(R.color.wallpaper_title));

        mRecommend.setTextSize(16);
        mClassification.setTextSize(16);
        mLocal.setTextSize(16);

        textPaint = mRecommend.getPaint();
        textPaint.setFakeBoldText(false);

        textPaint = mClassification.getPaint();
        textPaint.setFakeBoldText(false);

        textPaint = mLocal.getPaint();
        textPaint.setFakeBoldText(false);
    }
}
