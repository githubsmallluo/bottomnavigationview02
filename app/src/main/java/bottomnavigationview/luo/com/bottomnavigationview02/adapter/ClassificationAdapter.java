package bottomnavigationview.luo.com.bottomnavigationview02.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import bottomnavigationview.luo.com.bottomnavigationview02.R;
import bottomnavigationview.luo.com.bottomnavigationview02.utils.Tools;

/**
 * Created by luo on 2019/7/31.
 */

public class ClassificationAdapter extends RecyclerView.Adapter<ClassificationAdapter.VH> {

    private View mView;
    private VH mVH;
    private List<Integer> mListImage;
    private List<String> mListText;
    private Context mContext;
    private Bitmap bitmapImage;

    private OnItemClickListener listener;
    private OnItemLongClickListener longClickListener;

    public ClassificationAdapter(Context context, List<Integer> listimage, List<String> listtext) {
        this.mListImage = listimage;
        this.mListText = listtext;
        this.mContext = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classification, parent, false);
        mVH = new VH(mView);
        return mVH;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final int itemposition = position;
        bitmapImage = Tools.readBitMap(mContext, mListImage.get(position));
        holder.itemimage.setImageBitmap(bitmapImage);
        holder.itemtext.setText(mListText.get(position));

        holder.itemlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(itemposition);
                }
            }
        });
        holder.itemlayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    longClickListener.onClick(itemposition);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListImage.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        public ImageView itemimage;
        public TextView itemtext;
        public RelativeLayout itemlayout;

        public VH(View itemView) {
            super(itemView);
            itemimage = (ImageView) itemView.findViewById(R.id.classification_image);
            itemtext = (TextView) itemView.findViewById(R.id.classification_text);
            itemlayout = (RelativeLayout) itemView.findViewById(R.id.classification_layout);
        }
    }

    //点击接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    //公共的点击方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    //长按的点击接口
    public interface OnItemLongClickListener {
        void onClick(int position);
    }

    //长按的公共的接口
    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

}
