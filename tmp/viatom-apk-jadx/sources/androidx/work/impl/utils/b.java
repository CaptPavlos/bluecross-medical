package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f755a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f756b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f757c;

    public /* synthetic */ b(WorkManagerImpl workManagerImpl, String str) {
        this.f757c = workManagerImpl;
        this.f756b = str;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f755a) {
            case 0:
                return CancelWorkRunnable.forTag$lambda$3(this.f757c, this.f756b);
            default:
                return CancelWorkRunnable.forName$lambda$4(this.f756b, this.f757c);
        }
    }

    public /* synthetic */ b(String str, WorkManagerImpl workManagerImpl) {
        this.f756b = str;
        this.f757c = workManagerImpl;
    }
}
