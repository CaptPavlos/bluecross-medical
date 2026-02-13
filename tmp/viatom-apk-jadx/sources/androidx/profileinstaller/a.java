package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f597a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f598b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f599c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f600d;

    public /* synthetic */ a(int i10, Object obj, int i11, Object obj2) {
        this.f597a = i11;
        this.f598b = obj;
        this.f599c = i10;
        this.f600d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f597a) {
            case 0:
                ((ProfileInstaller.DiagnosticsCallback) this.f598b).onResultReceived(this.f599c, this.f600d);
                break;
            case 1:
                ((ProfileInstaller.DiagnosticsCallback) this.f598b).onDiagnosticReceived(this.f599c, this.f600d);
                break;
            default:
                ((DeviceProfileWriter) this.f598b).lambda$result$0(this.f599c, this.f600d);
                break;
        }
    }
}
