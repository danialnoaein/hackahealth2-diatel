package adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import hackahealth.diatel.R;
import models.ArticleCategory;

public class ArticleCategoriesRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<ArticleCategory> list, filterList;

    public ArticleCategoriesRVAdapter() {
    }

    public ArticleCategoriesRVAdapter(Context context, List<ArticleCategory> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.filterList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView;
        itemView = inflater.inflate(R.layout.layout_rv_item_article_category, viewGroup, false);
        return new ViewHolder(itemView);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final ArticleCategory articleCategory = list.get(position);
        final ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(context).load(articleCategory.getImageUrl()).into(viewHolder.imv_poster);
        viewHolder.tv_title.setText(articleCategory.getTitle());
        viewHolder.id = articleCategory.getId();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        int id;
        ImageView imv_poster;
        TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            imv_poster = itemView.findViewById(R.id.imv_poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition(), list.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, ArticleCategory articleCategory);
    }

    public ArticleCategoriesRVAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }
}