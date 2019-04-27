package general;

import android.content.Context;
import android.graphics.Typeface;

public class Fonts {

    private Typeface typeface;

    public Fonts(Context context, String font) {
        // TODO Auto-generated constructor stub
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + font+".ttf");
    }

    public Typeface getTypeface() {
        return typeface;
    }
}
