package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class a {

        /* renamed from: b, reason: collision with root package name */
        private final String f3974b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f3975c;

        public a(String str, boolean z9) {
            this.f3974b = str;
            this.f3975c = z9;
        }

        public final String a() {
            return this.f3974b;
        }

        public final boolean b() {
            return this.f3975c;
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            androidx.window.layout.c.g("Cannot be called from the main thread");
            return null;
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        ServiceConnectionC0033b serviceConnectionC0033b = new ServiceConnectionC0033b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, serviceConnectionC0033b, 1)) {
            com.google.gson.internal.a.m("Google Play connection failed");
            return null;
        }
        try {
            try {
                c cVar = new c(serviceConnectionC0033b.a());
                return new a(cVar.a(), cVar.a(true));
            } catch (Exception e) {
                throw e;
            }
        } finally {
            context.unbindService(serviceConnectionC0033b);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    public final class ServiceConnectionC0033b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f3976a;

        /* renamed from: c, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f3978c;

        private ServiceConnectionC0033b() {
            this.f3978c = new LinkedBlockingQueue<>(1);
            this.f3976a = false;
        }

        public final IBinder a() throws InterruptedException {
            if (this.f3976a) {
                p8.u.e();
                return null;
            }
            this.f3976a = true;
            return this.f3978c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f3978c.put(iBinder);
            } catch (InterruptedException e) {
                af.b("AdvertisingIdClient", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class c implements IInterface {

        /* renamed from: b, reason: collision with root package name */
        private IBinder f3980b;

        public c(IBinder iBinder) {
            this.f3980b = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3980b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Throwable th) {
                try {
                    af.b("AdvertisingIdClient", th.getMessage());
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f3980b;
        }

        public final boolean a(boolean z9) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z10 = false;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z9 ? 1 : 0);
                this.f3980b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() != 0) {
                    z10 = true;
                }
            } finally {
                try {
                    return z10;
                } finally {
                }
            }
            return z10;
        }
    }
}
