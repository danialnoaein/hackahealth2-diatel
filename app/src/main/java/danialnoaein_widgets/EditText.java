package danialnoaein_widgets;

import android.content.Context;
import android.util.AttributeSet;

import general.Fonts;

/**
 * Created by AMz on 7/21/2016.
 */
public class EditText extends android.support.v7.widget.AppCompatEditText {
    public EditText(Context context) {
        super(context);
        this.setTypeface(new Fonts(context, "shabnam").getTypeface());
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(new Fonts(context, "shabnam").getTypeface());
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(new Fonts(context, "shabnam").getTypeface());
    }
}
