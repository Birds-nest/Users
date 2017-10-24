package com.dell.yikezhong.view.adapter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dell.yikezhong.R;
import com.dell.yikezhong.modle.bean.CrossTalkInfoBean;

import java.util.ArrayList;
import java.util.List;

import static com.dell.yikezhong.R.id.crosstalk_content;
import static com.dell.yikezhong.R.id.crosstalk_name;
import static com.dell.yikezhong.R.id.crosstalk_time;

/**
 * Created by pc on 2017/10/20.
 */

/**
 * 段子大布局的适配器
 */
public class CrossTalkAdapter extends BaseAdapter {
    private List<CrossTalkInfoBean.CharacterBean> list_crosstalk = new ArrayList<>();
    private Context context;
    ViewHolder holder;

    public CrossTalkAdapter(List<CrossTalkInfoBean.CharacterBean> list_crosstalk, Context context) {
        this.list_crosstalk = list_crosstalk;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_crosstalk != null ? list_crosstalk.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return list_crosstalk.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = View.inflate(context, R.layout.item_crosstalk, null);
            holder = new ViewHolder();
            holder.crosstalk_name = view.findViewById(crosstalk_name);
            holder.crosstalk_time = view.findViewById(crosstalk_time);
            holder.crosstalk_content = view.findViewById(crosstalk_content);
            holder.jia = view.findViewById(R.id.crosstalk_choices);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.crosstalk_name.setText(list_crosstalk.get(i).getUser().getUserName());
        holder.crosstalk_time.setText(list_crosstalk.get(i).getCharacter_uptime());
        holder.crosstalk_content.setText(list_crosstalk.get(i).getCharacter_content());

        View view2 = View.inflate(context, R.layout.anim, null);
        final PopupWindow popupWindow = new PopupWindow(view2, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);

        holder.jia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    PropertyValuesHolder pl = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
                    PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("rotation", 0f, -100f);
                    ObjectAnimator.ofPropertyValuesHolder(holder.jia, pl, p2).setDuration(800).start();
                    popupWindow.showAsDropDown(holder.jia, 0, -50);
                }
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ObjectAnimator anim = ObjectAnimator.ofFloat(holder.jia, "alpha", 0f, 1f);
                anim.setDuration(500);// 动画持续时间
                anim.start();
            }
        });


        return view;
    }

    class ViewHolder {
        TextView crosstalk_name;
        TextView crosstalk_time;
        TextView crosstalk_content;
        ImageView jia;
    }
}
