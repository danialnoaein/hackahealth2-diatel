package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import hackahealth.diatel.R;

public class MenuRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<MenuItem> list;

    private int defaultBackgroundColor = android.R.color.white;
    private int selectedBackgroundColor = R.color.grey_5;

    private int defaultForegroundColor = R.color.grey_40;
    private int selectedForegroundColor = android.R.color.black;

    public MenuRVAdapter() {
    }

    public MenuRVAdapter(Context context, List<MenuItem> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = inflater.inflate(R.layout.layout_rv_menu_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_title.setText(menuItem.getTitle());
        viewHolder.tv_title.setVisibility(menuItem.getTitle() != null ? View.VISIBLE : View.GONE);
        //viewHolder.tv_title.setTypeface(menuItem.isSelected() ? new Fonts(context, Fonts.BOLD_FONT).getTypeface() : new Fonts(context, Fonts.DEFAULT_FONT).getTypeface());
        viewHolder.tv_title.setTextColor(context.getResources().getColor(menuItem.isSelected() ? (menuItem.getSelectedForegroundColor() > 0 ? menuItem.getSelectedForegroundColor() : selectedForegroundColor) : (menuItem.getDefaultForegroundColor() > 0 ? menuItem.getDefaultForegroundColor() : defaultForegroundColor)));
        viewHolder.imv_icon.setImageResource(menuItem.isSelected() ? menuItem.getSelectedDrawableRes() > 0 ? menuItem.getSelectedDrawableRes() : menuItem.getDrawableRes() : menuItem.getDrawableRes());
        viewHolder.itemView.setBackgroundResource(menuItem.isSelected() ? (menuItem.getSelectedBackgroundColor() > 0 ? menuItem.getSelectedBackgroundColor() : selectedBackgroundColor) : (menuItem.getDefaultBackgroundColor() > 0 ? menuItem.getDefaultBackgroundColor() : defaultBackgroundColor));
        if (menuItem.getBackgroundDrawableRes() > 0)
            viewHolder.ll_item_container.setBackgroundResource(menuItem.getBackgroundDrawableRes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_icon;
        TextView tv_title;
        LinearLayout ll_item_container;

        public ViewHolder(View itemView) {
            super(itemView);

            imv_icon = itemView.findViewById(R.id.imv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
            ll_item_container = itemView.findViewById(R.id.ll_item_container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuItem menuItem = list.get(getAdapterPosition());
                    onItemClickListener.onItemClick(getAdapterPosition(), list.get(getAdapterPosition()));
                    if (menuItem.getFragment() != null) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setSelected(false);
                        }
                        menuItem.setSelected(true);
                        list.set(getAdapterPosition(), menuItem);
                        notifyDataSetChanged();
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, MenuItem menuItem);
    }

    public MenuRVAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    public class MenuItem {
        int tabIndex, drawableRes, selectedDrawableRes, backgroundDrawableRes, defaultBackgroundColor, selectedBackgroundColor, defaultForegroundColor, selectedForegroundColor;
        String title;
        Fragment fragment;
        boolean isSelected;

        public MenuItem() {
        }

        public MenuItem(int tabIndex, int drawableRes, int selectedDrawableRes, int defaultBackgroundColor, int selectedBackgroundColor, int defaultForegroundColor, int selectedForegroundColor, String title, Fragment fragment, boolean isSelected) {
            this.tabIndex = tabIndex;
            this.drawableRes = drawableRes;
            this.selectedDrawableRes = selectedDrawableRes;
            this.defaultBackgroundColor = defaultBackgroundColor;
            this.selectedBackgroundColor = selectedBackgroundColor;
            this.defaultForegroundColor = defaultForegroundColor;
            this.selectedForegroundColor = selectedForegroundColor;
            this.title = title;
            this.fragment = fragment;
            this.isSelected = isSelected;
        }

        public MenuItem(int tabIndex, int drawableRes, String title, Fragment fragment, boolean isSelected) {
            this.tabIndex = tabIndex;
            this.drawableRes = drawableRes;
            this.title = title;
            this.fragment = fragment;
            this.isSelected = isSelected;
        }

        public MenuItem(int tabIndex, int drawableRes, int selectedDrawableRes, String title, Fragment fragment, boolean isSelected) {
            this.tabIndex = tabIndex;
            this.drawableRes = drawableRes;
            this.selectedDrawableRes = selectedDrawableRes;
            this.title = title;
            this.fragment = fragment;
            this.isSelected = isSelected;
        }

        public int getTabIndex() {
            return tabIndex;
        }

        public void setTabIndex(int tabIndex) {
            this.tabIndex = tabIndex;
        }

        public int getDrawableRes() {
            return drawableRes;
        }

        public void setDrawableRes(int drawableRes) {
            this.drawableRes = drawableRes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSelectedDrawableRes() {
            return selectedDrawableRes;
        }

        public MenuItem setSelectedDrawableRes(int selectedDrawableRes) {
            this.selectedDrawableRes = selectedDrawableRes;
            return this;
        }

        public int getDefaultBackgroundColor() {
            return defaultBackgroundColor;
        }

        public MenuItem setDefaultBackgroundColor(int defaultBackgroundColor) {
            this.defaultBackgroundColor = defaultBackgroundColor;
            return this;
        }

        public int getSelectedBackgroundColor() {
            return selectedBackgroundColor;
        }

        public MenuItem setSelectedBackgroundColor(int selectedBackgroundColor) {
            this.selectedBackgroundColor = selectedBackgroundColor;
            return this;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public int getDefaultForegroundColor() {
            return defaultForegroundColor;
        }

        public MenuItem setDefaultForegroundColor(int defaultForegroundColor) {
            this.defaultForegroundColor = defaultForegroundColor;
            return this;
        }

        public int getSelectedForegroundColor() {
            return selectedForegroundColor;
        }

        public MenuItem setSelectedForegroundColor(int selectedForegroundColor) {
            this.selectedForegroundColor = selectedForegroundColor;
            return this;
        }

        public int getBackgroundDrawableRes() {
            return backgroundDrawableRes;
        }

        public MenuItem setBackgroundDrawableRes(int backgroundDrawableRes) {
            this.backgroundDrawableRes = backgroundDrawableRes;
            return this;
        }
    }
}
