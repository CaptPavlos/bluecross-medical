package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.EditText;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface ImeKeyMonitor {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface ImeKeyListener {
        boolean onKeyPreIme(EditText editText, int i10, KeyEvent keyEvent);
    }

    void setImeKeyListener(ImeKeyListener imeKeyListener);
}
