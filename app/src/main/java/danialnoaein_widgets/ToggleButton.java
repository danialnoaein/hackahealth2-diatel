package danialnoaein_widgets;

import android.content.Context;
import android.util.AttributeSet;

import general.Fonts;

/**
 * Created by AMz on 7/21/2016.
 */
public class ToggleButton extends android.widget.ToggleButton {
    public ToggleButton(Context context) {
        super(context);
        if(!isInEditMode())this.setTypeface(new Fonts(context, "shabnam_num_fa").getTypeface());
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode())this.setTypeface(new Fonts(context, "shabnam_num_fa").getTypeface());
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!isInEditMode())this.setTypeface(new Fonts(context, "shabnam_num_fa").getTypeface());
    }
}
