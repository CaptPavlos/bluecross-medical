package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.q;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class i {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f5460a;

        /* renamed from: b, reason: collision with root package name */
        final ad f5461b;

        private a(String str, ad adVar) {
            this.f5460a = str;
            this.f5461b = adVar;
        }
    }

    public static byte[] a(InputStream inputStream, int i10, c cVar, q qVar) throws Throwable {
        byte[] bArrA;
        l lVar = new l(cVar, i10);
        if (qVar != null) {
            qVar.f(0L);
        }
        try {
            bArrA = cVar.a(1024);
            while (true) {
                try {
                    int i11 = inputStream.read(bArrA);
                    if (i11 == -1) {
                        break;
                    }
                    lVar.write(bArrA, 0, i11);
                    if (qVar != null) {
                        qVar.f(qVar.f() + i11);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            ae.a("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.a(bArrA);
                    lVar.close();
                    throw th;
                }
            }
            byte[] byteArray = lVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                ae.a("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.a(bArrA);
            lVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }
}
