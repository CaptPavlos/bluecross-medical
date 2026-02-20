package q8;

import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f12286a;

    public a(String str, Object... objArr) {
        byte[] bArr = c.f12289a;
        this.f12286a = String.format(Locale.US, str, objArr);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f12286a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
