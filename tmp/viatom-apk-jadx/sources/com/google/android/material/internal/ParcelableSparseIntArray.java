package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.google.android.material.internal.ParcelableSparseIntArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableSparseIntArray createFromParcel(@NonNull Parcel parcel) {
            int i10 = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i10);
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i11 = 0; i11 < i10; i11++) {
                parcelableSparseIntArray.put(iArr[i11], iArr2[i11]);
            }
            return parcelableSparseIntArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public ParcelableSparseIntArray[] newArray(int i10) {
            return new ParcelableSparseIntArray[i10];
        }
    };

    public ParcelableSparseIntArray(@NonNull SparseIntArray sparseIntArray) {
        for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
            put(sparseIntArray.keyAt(i10), sparseIntArray.valueAt(i10));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i11 = 0; i11 < size(); i11++) {
            iArr[i11] = keyAt(i11);
            iArr2[i11] = valueAt(i11);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }

    public ParcelableSparseIntArray(int i10) {
        super(i10);
    }

    public ParcelableSparseIntArray() {
    }
}
