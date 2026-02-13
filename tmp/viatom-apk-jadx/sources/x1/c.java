package x1;

import android.os.Looper;
import kotlin.jvm.internal.k;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c extends k implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13574a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i10, Object obj, Class cls, String str, String str2, int i11, int i12) {
        super(i10, obj, cls, str, str2, i11);
        this.f13574a = i12;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f13574a) {
            case 0:
                ((d) this.receiver).getClass();
                String name = Thread.currentThread().getName();
                name.getClass();
                return Boolean.valueOf(m.d0(name, "Firebase Background Thread #", false));
            case 1:
                ((d) this.receiver).getClass();
                String name2 = Thread.currentThread().getName();
                name2.getClass();
                return Boolean.valueOf(m.d0(name2, "Firebase Blocking Thread #", false));
            default:
                ((d) this.receiver).getClass();
                return Boolean.valueOf(!Looper.getMainLooper().isCurrentThread());
        }
    }
}
