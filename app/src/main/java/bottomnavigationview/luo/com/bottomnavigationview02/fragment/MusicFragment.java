package bottomnavigationview.luo.com.bottomnavigationview02.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bottomnavigationview.luo.com.bottomnavigationview02.R;

/**
 * Created by Administrator on 2019/7/2.
 */

public class MusicFragment extends Fragment {

    private View musicView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        musicView = inflater.inflate(R.layout.fragment_music, container, false);
        return musicView;
    }
}
