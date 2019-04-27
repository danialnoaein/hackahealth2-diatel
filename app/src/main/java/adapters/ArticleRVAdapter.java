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

import java.util.List;

import hackahealth.diatel.R;
import models.Article;

public class ArticleRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<Article> list, filterList;
//    CategoryPackageFilter filter;

    public ArticleRVAdapter() {
    }

    public ArticleRVAdapter(Context context, List<Article> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.filterList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.layout_rv_item_article, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final ViewHolder viewHolder = (ViewHolder) holder;
        final Article article = list.get(position);

        viewHolder.tv_title.setText(article.getTitle());
        //viewHolder.tv_description.setText(media.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imv_logo_media;
        TextView tv_title, tv_date;

        public ViewHolder(View itemView) {
            super(itemView);

            //imv_logo_media = itemView.findViewById(R.id.imv_logo_media);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date = itemView.findViewById(R.id.tv_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition(), list.get(getAdapterPosition()));
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, Article article);
    }

    public ArticleRVAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }
}