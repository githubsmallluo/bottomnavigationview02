package bottomnavigationview.luo.com.bottomnavigationview02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import bottomnavigationview.luo.com.bottomnavigationview02.R;

/**
 * Created by Administrator on 2019/7/12.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.VH> {

    private View mView;
    private VH mVH;
    private List<String> mList;
    private Context mContext;

    private OnItemClickListener listener;
    private OnItemLongClickListener longClickListener;

    public RecommendAdapter(Context context, List<String> list) {
        this.mList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
        mVH = new VH(mView);
        return mVH;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final int itemposition = position;
        Glide.with(mContext).load(mList.get(position)).into(holder.itemimage);
        holder.itemimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(itemposition);
                }
            }
        });
        holder.itemimage.setOnLongClickListener(new View.OnLongClickListener() {
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
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        public ImageView itemimage;

        public VH(View itemView) {
            super(itemView);
            itemimage = (ImageView) itemView.findViewById(R.id.recommend_image);
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
