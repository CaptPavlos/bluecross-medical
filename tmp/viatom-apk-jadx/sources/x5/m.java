package x5;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Html;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.UsernameEditActivity;
import java.util.ArrayList;
import org.xml.sax.XMLReader;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements Html.TagHandler {

    /* renamed from: a, reason: collision with root package name */
    public final UsernameEditActivity f13716a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13717b = new ArrayList();

    public m(UsernameEditActivity usernameEditActivity) {
        this.f13716a = usernameEditActivity;
    }

    @Override // android.text.Html.TagHandler
    public final void handleTag(boolean z9, String str, Editable editable, XMLReader xMLReader) {
        str.getClass();
        editable.getClass();
        xMLReader.getClass();
        if (str.equalsIgnoreCase("turbo")) {
            ArrayList arrayList = this.f13717b;
            if (z9) {
                arrayList.add(Integer.valueOf(editable.length()));
                return;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int iIntValue = ((Number) arrayList.remove(arrayList.size() - 1)).intValue();
            int length = editable.length();
            editable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f13716a, R.color.turbo_main)), iIntValue, length, 33);
            if (o4.b.f11719r != null) {
                Typeface typeface = o4.b.f11719r;
                typeface.getClass();
                editable.setSpan(new v5.f(typeface, 1), iIntValue, length, 33);
            }
        }
    }
}
