package f0;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;
import i0.y;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends j0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f7990a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7991b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f7992c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7993d;
    public static final b e = new b(0);

    @NonNull
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.f(23);

    public b(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f7990a = i10;
        this.f7991b = i11;
        this.f7992c = pendingIntent;
        this.f7993d = str;
    }

    public static String b(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return a3.a.g(i10, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f7991b == bVar.f7991b && y.j(this.f7992c, bVar.f7992c) && y.j(this.f7993d, bVar.f7993d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7991b), this.f7992c, this.f7993d});
    }

    public final String toString() {
        i0.k kVar = new i0.k(this);
        kVar.d(b(this.f7991b), "statusCode");
        kVar.d(this.f7992c, "resolution");
        kVar.d(this.f7993d, "message");
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f7990a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f7991b);
        a4.E(parcel, 3, this.f7992c, i10);
        a4.F(parcel, 4, this.f7993d);
        a4.M(parcel, I);
    }

    public b(int i10) {
        this(1, i10, null, null);
    }

    public b(int i10, PendingIntent pendingIntent) {
        this(1, i10, pendingIntent, null);
    }
}
