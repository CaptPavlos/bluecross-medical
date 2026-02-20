package e0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import h1.p;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements h1.a, h1.h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d f7596b = new d(0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d f7597c = new d(1);

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d f7598d = new d(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7599a;

    public /* synthetic */ d(int i10) {
        this.f7599a = i10;
    }

    @Override // h1.a
    public Object a(p pVar) throws IOException {
        switch (this.f7599a) {
            case 0:
                if (pVar.i()) {
                    return (Bundle) pVar.g();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(pVar.f())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", pVar.f());
            default:
                Intent intent = (Intent) ((Bundle) pVar.g()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
        }
    }

    @Override // h1.h
    public p y(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i10 = b.h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? r0.f.x(bundle) : r0.f.x(null);
    }
}
