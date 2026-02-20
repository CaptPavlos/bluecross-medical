package com.uptodown.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import v5.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AuthenticatorService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        IBinder iBinder = new d(this).getIBinder();
        iBinder.getClass();
        return iBinder;
    }
}
