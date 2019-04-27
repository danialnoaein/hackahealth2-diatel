package danialnoaein_widgets;

import android.content.Context;
import android.util.AttributeSet;

import general.Fonts;

/**
 * Created by AMz on 7/21/2016.
 */
public class TextViewBold extends android.support.v7.widget.AppCompatTextView {
    public TextViewBold(Context context) {
        super(context);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold").getTypeface());

    }

    public TextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold").getTypeface());
    }

    public TextViewBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold").getTypeface());
    }

}
