package f0;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import i0.y;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class m extends u0.b implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final int f8022b;

    public m(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 2);
        y.b(bArr.length == 25);
        this.f8022b = Arrays.hashCode(bArr);
    }

    public static byte[] J(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            u.h(e);
            return null;
        }
    }

    @Override // u0.b
    public final boolean H(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 == 1) {
            q0.a aVarI = I();
            parcel2.writeNoException();
            x0.a.c(parcel2, aVarI);
            return true;
        }
        if (i10 != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.f8022b);
        return true;
    }

    public final q0.a I() {
        return new q0.b(K());
    }

    public abstract byte[] K();

    public final boolean equals(Object obj) {
        q0.a aVarI;
        if (obj != null && (obj instanceof m)) {
            try {
                m mVar = (m) obj;
                if (mVar.f8022b == this.f8022b && (aVarI = mVar.I()) != null) {
                    return Arrays.equals(K(), (byte[]) q0.b.J(aVarI));
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8022b;
    }
}
