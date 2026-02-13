package l4;

import android.content.DialogInterface;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10538a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10539b;

    public /* synthetic */ k(Object obj, int i10) {
        this.f10538a = i10;
        this.f10539b = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f10538a) {
            case 0:
                ((g7.a) this.f10539b).invoke();
                break;
            default:
                ((a4) this.f10539b).O = false;
                break;
        }
    }
}
