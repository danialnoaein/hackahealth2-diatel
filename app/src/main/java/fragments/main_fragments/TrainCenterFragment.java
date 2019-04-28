package fragments.main_fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import adapters.ArticleCategoriesRVAdapter;
import hackahealth.diatel.R;
import models.ArticleCategory;

public class TrainCenterFragment extends Fragment {

    LinearLayout ll_load_data;
    RecyclerView rv_article_categories;
    public static TrainCenterFragment newInstance() {
        Bundle args = new Bundle();
        TrainCenterFragment fragment = new TrainCenterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main_train_center, container, false);
        findViews(fragmentView);
        return fragmentView;
    }

    private void findViews(View fragmentView) {
        rv_article_categories = fragmentView.findViewById(R.id.rv_article_categories);
        ll_load_data = fragmentView.findViewById(R.id.ll_load_data);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArticleCategories();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ll_load_data.setVisibility(View.GONE);
            }
        }, 2000);
    }

    private void initArticleCategories() {
        final List<ArticleCategory> categoryList = ArticleCategory.getArticleCategories();
        rv_article_categories.setLayoutManager(new GridLayoutManager(getContext(),2));
        rv_article_categories.setAdapter(new ArticleCategoriesRVAdapter(getContext(),categoryList).setOnItemClickListener(new ArticleCategoriesRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ArticleCategory articleCategory) {
//                Intent intent = new Intent( getContext() , ArticlesActivity.class);
//                intent.putExtra("CATEGORY_ID", articleCategory.getId());
//                intent.putExtra("CATEGORY_TITLE", articleCategory.getTitle());
//                startActivity(intent );
            }
        }));
    }


}

