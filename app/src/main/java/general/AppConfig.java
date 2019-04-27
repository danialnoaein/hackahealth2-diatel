package general;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class AppConfig {

    OnSearchDoneClickListener onSearchDoneClickListener;

    public static AppConfig getInstance() {
        return new AppConfig();
    }

    public AppConfig() {
    }

    public void configSoftKeyPad(final EditText search_input, final OnSearchDoneClickListener onSearchDoneClickListener) {

        search_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    if (search_input.length() > 2)
                        onSearchDoneClickListener.onSearchDoneClick(search_input);
                    //searchRequest(et_search.getText().toString(),user != null ? user.getId(): -1);
                    return true;
                }
                return true;
            }
        });
    }

    public interface OnSearchDoneClickListener {
        void onSearchDoneClick(EditText search_input);
    }

    public void setOnSearchDoneClickListener(OnSearchDoneClickListener onSearchDoneClickListener) {
        this.onSearchDoneClickListener = onSearchDoneClickListener;
    }

    public static String TodayString() {
        return String.format("%s\n%s", PersianCalendar.getInstance().getPersianWeekDayStr(), PersianCalendar.getInstance().getIranianDate());
    }


}

