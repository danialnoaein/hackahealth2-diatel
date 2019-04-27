package hackahealth.diatel;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapters.FragmentPagerVpAdapter;
import fragments.firstvisit_fragments.SlideFourFragment;
import fragments.firstvisit_fragments.SlideOneFragment;
import fragments.firstvisit_fragments.SlideThreeFragment;
import fragments.firstvisit_fragments.SlideTwoFragment;
import general.SharedPrefHandler;
import general.ViewPager;

public class FirstVisitActivity extends AppCompatActivity {

    Context context;
    ViewPager vp_slides;
    List<Fragment> fragments = new ArrayList<>();
    LinearLayout ll_next_fragment;

    // shared pref
    SharedPrefHandler sharedPrefHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_visit);
        changeStatusBarColor();

        // Checking for first time launch - before calling setContentView()
//        sharedPrefHandler = new SharedPrefHandler();
//        if (!SharedPrefHandler.getBooleanPreference(getContext() , "isFirstVisit" , true)) {
//            finish();
//        }

        findViews();
        onClick();
        initPager();


    }

    private void initPager() {

        fragments.add(SlideOneFragment.newInstance());
        fragments.add(SlideTwoFragment.newInstance());
        fragments.add(SlideThreeFragment.newInstance());
        fragments.add(SlideFourFragment.newInstance());
        vp_slides.setAdapter(new FragmentPagerVpAdapter(getSupportFragmentManager(), fragments, new String[]{}));

    }


    private void findViews() {
        vp_slides = findViewById(R.id.vp_slides);
        ll_next_fragment = findViewById(R.id.ll_next_fragment);
    }

    private void onClick() {
        ll_next_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (vp_slides.getCurrentItem() == 2){
                    ll_next_fragment.setVisibility(View.GONE);
                    vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                }else{
                    vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                }

            }
        });
    }


    public Context getContext() {
        return context;
    }

    private void changeStatusBarColor(){
        Window window = FirstVisitActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(FirstVisitActivity.this.getResources().getColor(R.color.colorSuccess));
        }

    }
}
