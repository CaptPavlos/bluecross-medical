package h0;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8354a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f8354a) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return new StringBuilder("Picasso-");
            case 2:
                return new Random();
            case 3:
                return 0L;
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(q8.c.e);
                return simpleDateFormat;
        }
    }
}
