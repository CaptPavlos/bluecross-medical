package com.uptodown.gcm;

import a3.o;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import r7.i0;
import r7.y;
import w7.c;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f6688i = 0;
    public final c h = y.a(t1.M(y.c(), i0.f12407a));

    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(w2.q r21) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.gcm.MyFirebaseMessagingService.c(w2.q):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d(String str) {
        str.getClass();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        t1.R(applicationContext, "fcmToken", str);
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        t1.N(applicationContext2, "fcmTokenSent", false);
        y.q(this.h, null, null, new o(this, str, (w6.c) null, 11), 3);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        y.f(this.h);
    }
}
