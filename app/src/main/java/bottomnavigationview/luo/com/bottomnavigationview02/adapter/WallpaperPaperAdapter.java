package bottomnavigationview.luo.com.bottomnavigationview02.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by luo on 2019/7/3.
 */

public class WallpaperPaperAdapter extends FragmentPagerAdapter{

    private List<Fragment> mList;

    public WallpaperPaperAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
}
