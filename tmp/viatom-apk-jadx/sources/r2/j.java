package r2;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f12362b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: c, reason: collision with root package name */
    public static j f12363c;

    /* renamed from: a, reason: collision with root package name */
    public final t3.h f12364a;

    public j(t3.h hVar) {
        this.f12364a = hVar;
    }

    public final boolean a(s2.b bVar) {
        if (TextUtils.isEmpty(bVar.f12524c)) {
            return true;
        }
        long j10 = bVar.f + bVar.e;
        this.f12364a.getClass();
        return j10 < (System.currentTimeMillis() / 1000) + 3600;
    }
}
