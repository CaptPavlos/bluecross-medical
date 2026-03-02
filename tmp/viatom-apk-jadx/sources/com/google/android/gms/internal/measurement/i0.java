package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends y implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1988a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1989b;

    public i0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.f1988a = new AtomicReference();
    }

    public static final Object d(Class cls, Bundle bundle) {
        Object obj;
        if (bundle == null || (obj = bundle.get(CampaignEx.JSON_KEY_AD_R)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", "Unexpected object type. Expected, Received: " + cls.getCanonicalName() + ", " + obj.getClass().getCanonicalName(), e);
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) z.a(parcel, Bundle.CREATOR);
        z.d(parcel);
        u(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle c(long j10) {
        Bundle bundle;
        AtomicReference atomicReference = this.f1988a;
        synchronized (atomicReference) {
            if (!this.f1989b) {
                try {
                    atomicReference.wait(j10);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f1988a.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.n0
    public final void u(Bundle bundle) {
        AtomicReference atomicReference = this.f1988a;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.f1989b = true;
                } finally {
                    this.f1988a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
