package l2;

import j$.util.DesugarTimeZone;
import j2.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements j2.f {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f10193a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        f10193a = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
    }

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        ((g) obj2).b(f10193a.format((Date) obj));
    }
}
