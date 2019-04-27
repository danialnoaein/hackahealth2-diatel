package hackahealth.diatel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;
import java.util.List;

import adapters.MenuRVAdapter;
import fragments.main_fragments.CheckupFragment;
import fragments.main_fragments.RegimeFragment;
import fragments.main_fragments.ReminderFragment;
import fragments.main_fragments.TrainCenterFragment;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    private RecyclerView rv_bottom_nv;
    private FragNavController frgNavController;
    private List<MenuRVAdapter.MenuItem> listBottomNv = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupBottomNv();
        initFragments(savedInstanceState);
        onClick();
    }

    private void findViews() {
        rv_bottom_nv = findViewById(R.id.rv_bottom_nv);
    }

    private void setupBottomNv() {

        listBottomNv.add(0, new MenuRVAdapter().new MenuItem(FragNavController.TAB1, R.drawable.ic_reading, R.drawable.ic_reading_primary, R.color.white, R.color.white, R.color.grey_30, R.color.colorPrimary, "آموزش", TrainCenterFragment.newInstance(), false));
        listBottomNv.add(1, new MenuRVAdapter().new MenuItem(FragNavController.TAB2, R.drawable.ic_alarm_bell, R.drawable.ic_alarm_bell_primary, R.color.white, R.color.white, R.color.grey_30, R.color.colorPrimary, "یادآور", ReminderFragment.newInstance(), false));
        listBottomNv.add(2, new MenuRVAdapter().new MenuItem(FragNavController.TAB3, R.drawable.ic_dish, R.drawable.ic_dish_primary, R.color.white, R.color.white, R.color.grey_30, R.color.colorPrimary, "تغذیه", RegimeFragment.newInstance(), false));
        listBottomNv.add(3, new MenuRVAdapter().new MenuItem(FragNavController.TAB4, R.drawable.ic_glucose_meter, R.drawable.ic_glucose_meter_primary, R.color.white, R.color.white, R.color.grey_30, R.color.colorPrimary, "چکاپ", CheckupFragment.newInstance(), true));

        rv_bottom_nv.setLayoutManager(new GridLayoutManager(getContext(), listBottomNv.size()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        final MenuRVAdapter bottomNvAdapter = new MenuRVAdapter(getContext(), listBottomNv);
        rv_bottom_nv.setAdapter(bottomNvAdapter);
        bottomNvAdapter.notifyDataSetChanged();
        bottomNvAdapter.setOnItemClickListener(new MenuRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, MenuRVAdapter.MenuItem menuItem) {
                frgNavController.switchTab(menuItem.getTabIndex());
            }
        });

    }


    private void initFragments(Bundle savedInstanceState) {

        frgNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.fl_fragment_container).transactionListener(new FragNavController.TransactionListener() {
            @Override
            public void onTabTransaction(Fragment fragment, int i) {
                if (getSupportActionBar() != null && frgNavController != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(!frgNavController.isRootFragment());
                }
            }

            @Override
            public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
                if (getSupportActionBar() != null && frgNavController != null) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(!frgNavController.isRootFragment());
                }
            }
        }).rootFragmentListener(new FragNavController.RootFragmentListener() {
            @Override
            public Fragment getRootFragment(int index) {
                return listBottomNv.get(index).getFragment();
            }
        }, listBottomNv.size()).build();

        frgNavController.switchTab(FragNavController.TAB4);

    }

    private void onClick(){

    }

    public Context getContext() {
        return context;
    }
}

