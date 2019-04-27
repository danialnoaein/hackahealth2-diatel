package hackahealth.diatel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import adapters.ArticleRVAdapter;
import models.Article;

public class ArticlesActivity extends AppCompatActivity {

    Context context;
    ImageButton ib_back;
    RecyclerView rv_articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        findViews();
        onClick();
        initArticles();
    }

    private void findViews() {
        ib_back = findViewById(R.id.ib_back);
        rv_articles = findViewById(R.id.rv_articles);
    }

    private void onClick(){
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Context getContext() {
        return context;
    }

    private void initArticles() {
        final List<Article> articleList = Article.getArticles();
        rv_articles.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        rv_articles.setAdapter(new ArticleRVAdapter(getContext(),articleList).setOnItemClickListener(new ArticleRVAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position, Article article) {
//                Intent intent = new Intent( getContext() , ArticlesActivity.class);
//                intent.putExtra("CATEGORY_ID", article.getId());
//                intent.putExtra("CATEGORY_TITLE", article.getTitle());
//                startActivity(intent );
//            }
//        }));
    }
}
