package androidx.activity.result;

import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f429a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f430b;

    public /* synthetic */ a(int i10, l lVar) {
        this.f429a = i10;
        this.f430b = lVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        switch (this.f429a) {
            case 0:
                this.f430b.invoke(obj);
                break;
            default:
                this.f430b.invoke(obj);
                break;
        }
    }
}
