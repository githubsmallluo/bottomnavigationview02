package bottomnavigationview.luo.com.bottomnavigationview02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

public class PhotoShowActivity extends AppCompatActivity {

    private PhotoView photoView;
    private String getUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_show);
        GetIntent();
        initView();
    }

    private void GetIntent() {
        final Intent getIntent = getIntent();
        getUrl = getIntent.getStringExtra("PhotoViewUrl");
    }

    private void initView() {
        photoView = (PhotoView) findViewById(R.id.photoView);
        Glide.with(this)
                .load(getUrl)
                .into(photoView);
    }
}
