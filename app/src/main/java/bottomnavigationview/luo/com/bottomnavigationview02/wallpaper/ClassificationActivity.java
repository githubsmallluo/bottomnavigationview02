package bottomnavigationview.luo.com.bottomnavigationview02.wallpaper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bottomnavigationview.luo.com.bottomnavigationview02.PhotoShowActivity;
import bottomnavigationview.luo.com.bottomnavigationview02.R;
import bottomnavigationview.luo.com.bottomnavigationview02.adapter.RecommendAdapter;
import bottomnavigationview.luo.com.bottomnavigationview02.bean.BaseResponse;
import bottomnavigationview.luo.com.bottomnavigationview02.http.GetRequestInterface;
import bottomnavigationview.luo.com.bottomnavigationview02.http.NetWorkManager;
import bottomnavigationview.luo.com.bottomnavigationview02.utils.Tools;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/8/5.
 */
public class ClassificationActivity extends AppCompatActivity {

    private static final String TAG = "ClassificationActivity";

    private int TypeNum = 0;
    private int getNum = 0;
    private ImageView mTypeReturn;
    private TextView mTypeText;
    private RecyclerView mTypeRv;

    private GridLayoutManager gridLayoutManager;
    private RecommendAdapter Adapter;
    private List<String> mListUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        init();
        GetIntent();
        initData();
        Request();
        initView();
    }

    private void init() {
        mTypeReturn = (ImageView) findViewById(R.id.type_return);
        mTypeText = (TextView) findViewById(R.id.type_text);
        mTypeRv = (RecyclerView) findViewById(R.id.type_rv);
    }

    private void GetIntent() {
        final Intent getIntent = getIntent();
        getNum = getIntent.getIntExtra("ClassificationNum", 0);

        switch (getNum) {
            case 1:
                TypeNum = Tools.Game;
                mTypeText.setText(R.string.games);
                break;
            case 2:
                TypeNum = Tools.Beautiful_Girl;
                mTypeText.setText(R.string.beautiful_girl);
                break;
            case 3:
                TypeNum = Tools.Scenery;
                mTypeText.setText(R.string.scenery);
                break;
            case 4:
                TypeNum = Tools.Visual_Creativity;
                mTypeText.setText(R.string.visual_creativity);
                break;
            case 5:
                TypeNum = Tools.Star;
                mTypeText.setText(R.string.star);
                break;
            case 6:
                TypeNum = Tools.Car;
                mTypeText.setText(R.string.car);
                break;
            case 7:
                TypeNum = Tools.Animal;
                mTypeText.setText(R.string.animal);
                break;
            case 8:
                TypeNum = Tools.Small_Fresh;
                mTypeText.setText(R.string.small_fresh);
                break;
            case 9:
                TypeNum = Tools.Sports;
                mTypeText.setText(R.string.sports);
                break;
            case 10:
                TypeNum = Tools.Military;
                mTypeText.setText(R.string.military);
                break;
            case 11:
                TypeNum = Tools.Cartoon;
                mTypeText.setText(R.string.cartoon);
                break;
            case 12:
                TypeNum = Tools.Emotion;
                mTypeText.setText(R.string.emotion);
                break;
            case 13:
                TypeNum = Tools.Written_Words;
                mTypeText.setText(R.string.written_words);
                break;
            default:
                break;
        }
    }

    private void initData() {
        mListUrl = new ArrayList<>();
        Adapter = new RecommendAdapter(this, mListUrl);
        gridLayoutManager = new GridLayoutManager(this, 2);
    }

    private void Request() {
        NetWorkManager.getInstance().init();
        GetRequestInterface request = NetWorkManager.getRequest();

        Log.d("lcr", "TypeNum = " + TypeNum);
        Call<BaseResponse> call = request.getCall(Tools.WallPaperAndroid,
                Tools.GetAppsByCategory,
                TypeNum,
                0,
                99);

        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                Log.d(TAG, "onResponse: " + response.body());
                BaseResponse baseResponse = response.body();
                if (baseResponse == null) {
                    return;
                }
                for (BaseResponse.DataBean data : baseResponse.getData()) {
                    Log.d(TAG, "data.getUrl() = " + data.getUrl());
                    Log.d(TAG, "data.getC_t() = " + data.getC_t());
                    Log.d(TAG, "data.getPid() = " + data.getPid());
                    Log.d(TAG, "data.getFav_total() = " + data.getFav_total());
                    mListUrl.add(data.getUrl());
                }
                Adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "retrofit  is error");
            }
        });
    }

    private void initView() {
        mTypeRv.setLayoutManager(gridLayoutManager);
        mTypeRv.setAdapter(Adapter);

        Adapter.setOnItemClickListener(new RecommendAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("lcr", " listurl = " + mListUrl.get(position));
                Intent mIntent = new Intent(ClassificationActivity.this, PhotoShowActivity.class);
                mIntent.putExtra("PhotoViewUrl", mListUrl.get(position));
                ClassificationActivity.this.startActivity(mIntent);
            }
        });

        mTypeReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
