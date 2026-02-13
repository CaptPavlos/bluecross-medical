package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatViewInflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LeanbackAppCompatViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    public View createView(Context context, String str, AttributeSet attributeSet) {
        str.getClass();
        if (str.equals("androidx.leanback.widget.GuidedActionEditText")) {
            return new GuidedActionAppCompatEditText(context, attributeSet);
        }
        return null;
    }
}
