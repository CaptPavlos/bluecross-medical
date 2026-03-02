package androidx.profileinstaller;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f603a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f604b;

    public /* synthetic */ c(Context context, int i10) {
        this.f603a = i10;
        this.f604b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f603a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.f604b);
                break;
            default:
                ProfileInstaller.writeProfile(this.f604b);
                break;
        }
    }
}
