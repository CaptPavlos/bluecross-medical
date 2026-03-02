package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f751a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f752b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f753c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f754d;

    public /* synthetic */ a(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl, int i10) {
        this.f751a = i10;
        this.f752b = workDatabase;
        this.f753c = str;
        this.f754d = workManagerImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f751a) {
            case 0:
                CancelWorkRunnable.forNameInline$lambda$5(this.f752b, this.f753c, this.f754d);
                break;
            default:
                CancelWorkRunnable.forTag$lambda$3$lambda$2(this.f752b, this.f753c, this.f754d);
                break;
        }
    }
}
