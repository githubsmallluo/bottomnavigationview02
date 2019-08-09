package bottomnavigationview.luo.com.bottomnavigationview02.wallpaper;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bottomnavigationview.luo.com.bottomnavigationview02.R;
import bottomnavigationview.luo.com.bottomnavigationview02.adapter.ClassificationAdapter;

/**
 * Created by Administrator on 2019/7/2.
 */

public class Fragment_Classification extends Fragment {

    private View myView;

    private int[] iconImage = {R.drawable.icon_game, R.drawable.icon_beautifulgirl, R.drawable.icon_scenery,
            R.drawable.icon_visualcreativity, R.drawable.icon_star, R.drawable.icon_car, R.drawable.icon_animal,
            R.drawable.icon_smallfresh, R.drawable.icon_sports, R.drawable.icon_military,
            R.drawable.icon_cartoon, R.drawable.icon_emotion, R.drawable.icon_writtenwords};
    private String[] iconText;

    private List<Integer> iconList;
    private List<String> textList;
    private RecyclerView classificationRv;
    private GridLayoutManager gridLayoutManager;
    private ClassificationAdapter classificationAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.wallpaper_classification, container, false);
        iconList = new ArrayList<>();
        textList = new ArrayList<>();
        initDate();
        initView();
        return myView;
    }

    private void initDate() {
        Resources res = getResources();
        iconText = res.getStringArray(R.array.classificationText);

        for (int i = 0; i < iconImage.length; i++) {
            iconList.add(iconImage[i]);
        }
        for (int j = 0; j < iconText.length; j++) {
            textList.add(iconText[j]);
        }
    }

    private void initView() {
        classificationRv = (RecyclerView) myView.findViewById(R.id.classification_rv);

        classificationAdapter = new ClassificationAdapter(myView.getContext(), iconList, textList);
        gridLayoutManager = new GridLayoutManager(myView.getContext(), 2);

        classificationRv.setLayoutManager(gridLayoutManager);
        classificationRv.setAdapter(classificationAdapter);

        classificationAdapter.setOnItemClickListener(new ClassificationAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent mIntent = new Intent(getContext(), ClassificationActivity.class);
                mIntent.putExtra("ClassificationNum", position + 1);
                getContext().startActivity(mIntent);
            }
        });
    }
}
