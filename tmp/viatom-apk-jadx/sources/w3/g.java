package w3;

import android.view.View;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f13507b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13508a = new ArrayList();

    static {
        Pattern.compile("^[a-zA-Z0-9 ]+$");
    }

    public final f a(View view) {
        ArrayList arrayList = this.f13508a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            f fVar = (f) obj;
            if (fVar.f13504a.get() == view) {
                return fVar;
            }
        }
        return null;
    }
}
