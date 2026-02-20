package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TrackGroupArray implements Parcelable {
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator<TrackGroupArray>() { // from class: com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TrackGroupArray[] newArray(int i10) {
            return new TrackGroupArray[i10];
        }
    };

    public TrackGroupArray(Parcel parcel) {
        int i10 = parcel.readInt();
        this.length = i10;
        this.trackGroups = new TrackGroup[i10];
        for (int i11 = 0; i11 < this.length; i11++) {
            this.trackGroups[i11] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroupArray.class == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            if (this.length == trackGroupArray.length && Arrays.equals(this.trackGroups, trackGroupArray.trackGroups)) {
                return true;
            }
        }
        return false;
    }

    public final TrackGroup get(int i10) {
        return this.trackGroups[i10];
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public final int indexOf(TrackGroup trackGroup) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (this.trackGroups[i10] == trackGroup) {
                return i10;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.length == 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.length);
        for (int i11 = 0; i11 < this.length; i11++) {
            parcel.writeParcelable(this.trackGroups[i11], 0);
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }
}
