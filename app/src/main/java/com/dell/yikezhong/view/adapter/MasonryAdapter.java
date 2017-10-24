package com.dell.yikezhong.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.dell.yikezhong.R;
import com.dell.yikezhong.modle.bean.IHotBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：王有为
 * 时间：2017/10/19.
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.ViewHolder> {
    private Context context;
    private List<IHotBean.美女Bean> mList;
    private List<Integer> mHeights;
    ImageLoader imageLoader;
    DisplayImageOptions options;
    private OnItemClickListener mListener;
    public MasonryAdapter(Context context, List<IHotBean.美女Bean> mList) {
        this.context = context;
        this.mList = mList;
        getRandomHeight(this.mList);
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);

        //将configuration配置到imageloader中
        imageLoader= ImageLoader.getInstance();
        imageLoader.init(configuration);

        options=new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .build();
    }
    public interface OnItemClickListener{
        void ItemClickListener(View view,int postion);
        void ItemLongClickListener(View view,int postion);
    }
    public void setOnClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
    public void getRandomHeight(List<IHotBean.美女Bean> mList){
        mHeights = new ArrayList<>();
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_text,parent,false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ViewGroup.LayoutParams params =  holder.mImageView.getLayoutParams();//得到item的LayoutParams布局参数
        params.height = mHeights.get(position);//把随机的高度赋予itemView布局
        holder.itemView.setLayoutParams(params);

            ImageLoader.getInstance().displayImage(mList.get(position).getImg(),
                    holder.mImageView, options);


        if(mListener!=null){//如果设置了监听那么它就不为空，然后回调相应的方法
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemClickListener(holder.itemView,pos);//把事件交给我们实现的接口那里处理
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        ImageView mImageView;

        public ViewHolder(View view){
            //需要设置super
            super(view);
            mImageView=view.findViewById(R.id.imageview);
        }
    }

    public List<IHotBean.美女Bean> getList() {
        return mList;
    }


}
