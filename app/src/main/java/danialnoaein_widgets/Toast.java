package danialnoaein_widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.HashMap;
import java.util.Map;

import hackahealth.diatel.R;


/**
 * Created by AMz on 11/4/2016.
 */

public class Toast {

    String text;
    Context context;

    public static final int TOAST_TYPE_SUCCESS = 1;
    public static final int TOAST_TYPE_DEFAULT = 2;
    public static final int TOAST_TYPE_ERROR = 3;

    public static Toast makeTEXT(Context context, String text, int toastType) {
        Toast toast = new Toast(context, text, toastType);
        return toast;
    }

    public Toast(Context context, String text, int type) {
        this.text = text;
        this.context = context;
        android.widget.Toast toast = new android.widget.Toast(context);
        View toastView = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null);
        LinearLayout ll_toast = toastView.findViewById(R.id.ll_toast);
        ll_toast.setBackgroundResource(toastColor(type));
        TextView tv_toast = toastView.findViewById(R.id.tv_toast);
        tv_toast.setText(text);
        toast.setView(toastView);
        toast.setDuration(android.widget.Toast.LENGTH_LONG);
        toast.show();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int toastColor(int type)
    {
        Map<Integer,Integer> toastColors = new HashMap<>();
        toastColors.put(TOAST_TYPE_SUCCESS,R.drawable.success_background);
        toastColors.put(TOAST_TYPE_DEFAULT,R.drawable.primary_background);
        toastColors.put(TOAST_TYPE_ERROR,R.drawable.error_background);
        return toastColors.get(type);
    }
}
