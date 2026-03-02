package l9;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        String str;
        String str2;
        String str3;
        String str4;
        parcel.getClass();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        if (string2 == null) {
            string2 = "";
        }
        String string3 = parcel.readString();
        if (string3 == null) {
            string3 = "";
        }
        String string4 = parcel.readString();
        if (string4 == null) {
            string4 = "";
        }
        String string5 = parcel.readString();
        if (string5 == null) {
            String str5 = string4;
            str4 = "";
            str = string2;
            str2 = string3;
            str3 = str5;
        } else {
            str = string2;
            str2 = string3;
            str3 = string4;
            str4 = string5;
        }
        return new f(string, str, str2, str3, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        return new f[i10];
    }
}
