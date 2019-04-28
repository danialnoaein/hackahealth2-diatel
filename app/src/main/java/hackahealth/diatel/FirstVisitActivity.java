package hackahealth.diatel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.FragmentPagerVpAdapter;
import danialnoaein_widgets.ViewPager;
import fragments.firstvisit_fragments.SlideFourFragment;
import fragments.firstvisit_fragments.SlideOneFragment;
import fragments.firstvisit_fragments.SlideThreeFragment;
import fragments.firstvisit_fragments.SlideTwoFragment;
import general.SharedPrefHandler;

import static danialnoaein_widgets.Toast.TOAST_TYPE_DEFAULT;
import static danialnoaein_widgets.Toast.TOAST_TYPE_ERROR;

public class FirstVisitActivity extends AppCompatActivity {

    Context context;
    ViewPager vp_slides;
    List<Fragment> fragments = new ArrayList<>();
    LinearLayout ll_next_fragment;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    //    Shared Pref Keys
    String NAME_KEY = "name";
    String AGE_KEY = "age";
    String GENDER_KEY = "gender";

    String WEIGHT_KEY = "weight";
    String HEIGHT_KEY = "height";

    String HAVE_DIABET_KEY = "have_diabet";

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

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        editor.clear();
        editor.apply();

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

                switch ( vp_slides.getCurrentItem() ){
                    case 0:
                        if (sharedPref.getString(NAME_KEY,"").equals("") || sharedPref.getInt(AGE_KEY,0) == 0 || sharedPref.getInt(GENDER_KEY,2) == 2){
                            showError();
                        }else{
                            vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                        }
                        break;
                    case 1:
                        if (sharedPref.getInt(WEIGHT_KEY,0) == 0 || sharedPref.getInt(HEIGHT_KEY,0) == 0){
                            showError();
                        }else{
                            vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                        }
                        break;
                    case 2:
                        if ( sharedPref.getInt(HAVE_DIABET_KEY,2) == 2 ){
                            showError();
                        }else{
                            vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                            ll_next_fragment.setVisibility(View.GONE);
                        }
                        break;
                    case 3:
                        if (false){
                            showError();
                        }
                        break;

                }

            }
        });
    }

    private void showError() {
        Toast.makeText(getApplicationContext() , "لطفا اطلاعات این صفحه را تکمیل کنید" , Toast.LENGTH_SHORT).show();
    }

    public Context getContext() {
        return context;
    }

    private void changeStatusBarColor(){
        Window window = FirstVisitActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(FirstVisitActivity.this.getResources().getColor(R.color.firstVisitSlideBackground));
        }

    }
}
