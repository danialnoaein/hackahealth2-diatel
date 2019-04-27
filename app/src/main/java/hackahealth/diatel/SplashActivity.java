package hackahealth.diatel;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.ybq.android.spinkit.SpinKitView;

import net.cachapa.expandablelayout.ExpandableLayout;

public class SplashActivity extends AppCompatActivity {

    Context context = this;
    ExpandableLayout exp_diatel, exp_magical;
    SpinKitView pb_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        findViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exp_diatel.expand();
            }
        }, 1000);

        exp_diatel.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                if (state == ExpandableLayout.State.EXPANDED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            exp_magical.expand();
                        }
                    }, 500);
                }
            }
        });
        exp_magical.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, final int state) {
                if (state == ExpandableLayout.State.EXPANDED) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getContext(), FirstVisitActivity.class));
                            finish();
                        }
                    }, 1000);

                }
            }
        });
    }

    private void findViews() {
        exp_diatel = findViewById(R.id.exp_diatel);
        exp_magical = findViewById(R.id.exp_magical);
        pb_loading = findViewById(R.id.pb_loading);
    }

    public Context getContext() {
        return context;
    }
}
