package com.google.android.gms.internal.measurement;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Parcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 extends y implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k1.a f1899a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(y0 y0Var, k1.a aVar) {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
        this.f1899a = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) throws Resources.NotFoundException, PackageManager.NameNotFoundException, NumberFormatException, ClassNotFoundException {
        if (i10 != 2) {
            return false;
        }
        e();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p0
    public final void e() throws Resources.NotFoundException, PackageManager.NameNotFoundException, NumberFormatException, ClassNotFoundException {
        this.f1899a.run();
    }
}
