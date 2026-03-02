package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() { // from class: com.mbridge.msdk.foundation.same.report.BatchReportMessage.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BatchReportMessage[] newArray(int i10) {
            return new BatchReportMessage[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f3773a;

    /* renamed from: b, reason: collision with root package name */
    private long f3774b;

    /* renamed from: c, reason: collision with root package name */
    private String f3775c;

    public BatchReportMessage(Parcel parcel) {
        this.f3775c = parcel.readString();
        this.f3773a = parcel.readString();
        this.f3774b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f3773a;
    }

    public long getTimestamp() {
        return this.f3774b;
    }

    public String getUuid() {
        return this.f3775c;
    }

    public void setReportMessage(String str) {
        this.f3773a = str;
    }

    public void setTimestamp(long j10) {
        this.f3774b = j10;
    }

    public void setUuid(String str) {
        this.f3775c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f3775c);
        parcel.writeString(this.f3773a);
        parcel.writeLong(this.f3774b);
    }

    public BatchReportMessage(String str, String str2, long j10) {
        this.f3775c = str;
        this.f3773a = str2;
        this.f3774b = j10;
    }
}
