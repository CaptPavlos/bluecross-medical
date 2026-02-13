package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.measurement.a4;
import f0.b;
import g0.i;
import g0.l;
import i0.k;
import i0.y;
import j0.a;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Status extends a implements i, ReflectedParcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int f1858a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1859b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f1860c;

    /* renamed from: d, reason: collision with root package name */
    public final b f1861d;
    public static final Status e = new Status(0, null, null, null);
    public static final Status f = new Status(14, null, null, null);
    public static final Status g = new Status(8, null, null, null);
    public static final Status h = new Status(15, null, null, null);

    /* renamed from: i, reason: collision with root package name */
    public static final Status f1857i = new Status(16, null, null, null);

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new l(0);

    public Status(int i10, String str, PendingIntent pendingIntent, b bVar) {
        this.f1858a = i10;
        this.f1859b = str;
        this.f1860c = pendingIntent;
        this.f1861d = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1858a == status.f1858a && y.j(this.f1859b, status.f1859b) && y.j(this.f1860c, status.f1860c) && y.j(this.f1861d, status.f1861d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1858a), this.f1859b, this.f1860c, this.f1861d});
    }

    public final String toString() {
        k kVar = new k(this);
        String strF = this.f1859b;
        if (strF == null) {
            int i10 = this.f1858a;
            switch (i10) {
                case -1:
                    strF = "SUCCESS_CACHE";
                    break;
                case 0:
                    strF = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strF = a3.a.f(i10, "unknown status code: ");
                    break;
                case 2:
                    strF = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strF = "SERVICE_DISABLED";
                    break;
                case 4:
                    strF = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strF = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strF = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strF = "NETWORK_ERROR";
                    break;
                case 8:
                    strF = "INTERNAL_ERROR";
                    break;
                case 10:
                    strF = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strF = "ERROR";
                    break;
                case 14:
                    strF = "INTERRUPTED";
                    break;
                case 15:
                    strF = "TIMEOUT";
                    break;
                case 16:
                    strF = "CANCELED";
                    break;
                case 17:
                    strF = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strF = "DEAD_CLIENT";
                    break;
                case 19:
                    strF = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strF = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strF = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strF = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        kVar.d(strF, "statusCode");
        kVar.d(this.f1860c, "resolution");
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f1858a);
        a4.F(parcel, 2, this.f1859b);
        a4.E(parcel, 3, this.f1860c, i10);
        a4.E(parcel, 4, this.f1861d, i10);
        a4.M(parcel, I);
    }

    @Override // g0.i
    public final Status getStatus() {
        return this;
    }
}
