package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f358a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f358a;
    }

    @Override // android.support.customtabs.c
    public final void extraCallback(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeString(str);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(3, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeString(str);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (Bundle) a4.d(parcelObtain2, Bundle.CREATOR);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityLayout(int i10, int i11, int i12, int i13, int i14, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeInt(i10);
            parcelObtain.writeInt(i11);
            parcelObtain.writeInt(i12);
            parcelObtain.writeInt(i13);
            parcelObtain.writeInt(i14);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(10, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityResized(int i10, int i11, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeInt(i10);
            parcelObtain.writeInt(i11);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(8, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMessageChannelReady(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMinimized(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(11, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onNavigationEvent(int i10, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeInt(i10);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onPostMessage(String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeString(str);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onRelationshipValidationResult(int i10, Uri uri, boolean z9, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            parcelObtain.writeInt(i10);
            a4.e(parcelObtain, uri, 0);
            parcelObtain.writeInt(z9 ? 1 : 0);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(6, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onUnminimized(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(12, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onWarmupCompleted(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(c.f359c);
            a4.e(parcelObtain, bundle, 0);
            this.f358a.transact(9, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
