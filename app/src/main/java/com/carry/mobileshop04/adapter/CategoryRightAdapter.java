package com.carry.mobileshop04.adapter;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carry.mobileshop04.R;
import com.carry.mobileshop04.http.entity.CategoryEntity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class CategoryRightAdapter extends RecyclerView.Adapter<CategoryRightAdapter.RightViewHolder> implements View.OnClickListener {
    private final List<CategoryEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;

    public CategoryRightAdapter(Activity activity, List<CategoryEntity> data){
        this.datas = data;
        this.mContext = activity;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category_right,parent,false);
        view.setOnClickListener(this);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        CategoryEntity entity = datas.get(position);
        holder.itemView.setTag(position);
        ImageLoader.getInstance().displayImage(entity.getImage(), holder.iv_image);
        holder.tv_name.setText(entity.getName());
    }

    @Override
    public int getItemCount() {
        if (datas != null){
            return datas.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null){
            int position = (int)v.getTag();
            CategoryEntity entity = datas.get(position);
            onItemClickListener.onItemClick(v, position, entity);
        }
    }
    public class RightViewHolder extends RecyclerView.ViewHolder{
        public final TextView tv_name;
        public final ImageView iv_image;

        public RightViewHolder(View itemView){
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_image = itemView.findViewById(R.id.iv_image);
        }
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        this.onItemClickListener = l;
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position, CategoryEntity entity);
    }

}
