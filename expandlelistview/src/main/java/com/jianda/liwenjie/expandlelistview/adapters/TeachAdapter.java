package com.jianda.liwenjie.expandlelistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.jianda.liwenjie.expandlelistview.R;
import com.jianda.liwenjie.expandlelistview.model.Child;
import com.jianda.liwenjie.expandlelistview.model.Father;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liwenjie on 2016/3/7.
 */
public class TeachAdapter extends BaseExpandableListAdapter{
    private List<Father> data;
    private LayoutInflater inflater;

    public TeachAdapter(List<Father> data, Context context) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    //得到分组的个数
    @Override
    public int getGroupCount() {
        return data!=null?data.size():0;
    }

    //得到position对应组的孩子的个数  对应position中的childView的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return (data.get(groupPosition).getChildren())!=null?(data.get(groupPosition).getChildren().size()):0;
    }

    //根据groupPosition获取指定组
    @Override
    public Father getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    //根据groupPosition和childPosition获取对应的  child数据
    @Override
    public Child getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getChildren().get(childPosition);
    }

    //根据groupPosition获取groupId
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //根据groupPosition和childPosition获取childId
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //是否有固定的id
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //得到组的View
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.father,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //TODO 数据加载
        TextView groupName = (TextView) holder.getView(R.id.father);
        groupName.setText(getGroup(groupPosition).getName());

        return convertView;
    }

    //获取子View
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.child,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //TODO 数据加载
        TextView chileName = (TextView) holder.getView(R.id.child_view);
        chileName.setText(getChild(groupPosition,childPosition).getName());
        return convertView;
    }
    //根据groupPosition和childPosition获取的child是否可以被点击
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static class ViewHolder{
        //Item的ViewGroup
        private View itemView;
        //声明一个Map用来缓存已经findViewById 的View
        private Map<Integer,View> cacheViews = new HashMap<Integer,View>();
        private View view;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
        public  View getView(int resId){
            //如果map中含有resId这个件，我们就直接从map中取出
            if (cacheViews.containsKey(resId)){
                view = cacheViews.get(resId);
            }else {
                //如果map不包含resId，我们就findViewById，实例化View，实例化后存放到缓存的map中
                view = itemView.findViewById(resId);
                cacheViews.put(resId,view);
            }

            return view;
        }
    }
}
