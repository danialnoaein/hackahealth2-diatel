package custom_widgets;

import android.content.Context;
import android.util.AttributeSet;

import general.Fonts;

/**
 * Created by AMz on 7/21/2016.
 */
public class TextViewBoldNumEn extends android.support.v7.widget.AppCompatTextView {
    public TextViewBoldNumEn(Context context) {
        super(context);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold_num_en").getTypeface());

    }

    public TextViewBoldNumEn(Context context, AttributeSet attrs) {
        super(context, attrs);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold_num_en").getTypeface());
    }

    public TextViewBoldNumEn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /*if(!isInEditMode())*/this.setTypeface(new Fonts(context, "shabnam_bold_num_en").getTypeface());
    }

}
