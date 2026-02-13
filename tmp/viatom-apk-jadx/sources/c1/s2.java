package c1;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1452a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1453b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1454c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f1455d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public s2(c3 c3Var, AtomicReference atomicReference, String str, String str2, boolean z9) {
        this.e = atomicReference;
        this.f1453b = str;
        this.f1454c = str2;
        this.f1455d = z9;
        Objects.requireNonNull(c3Var);
        this.f = c3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0105 A[Catch: RuntimeException -> 0x00df, TRY_ENTER, TryCatch #2 {RuntimeException -> 0x00df, blocks: (B:53:0x0105, B:55:0x0110, B:58:0x011d, B:60:0x0123, B:62:0x013d, B:64:0x0146, B:67:0x014e, B:70:0x0167, B:72:0x0176, B:71:0x016e, B:73:0x0189, B:75:0x018f, B:77:0x0195, B:79:0x019b, B:81:0x01a1, B:83:0x01a9, B:85:0x01b1, B:87:0x01b7, B:88:0x01c9, B:26:0x0090, B:28:0x0096, B:30:0x00a0, B:32:0x00a6, B:34:0x00ac, B:36:0x00b2, B:38:0x00ba, B:40:0x00c2, B:42:0x00ca, B:44:0x00d2, B:48:0x00e6, B:50:0x00f4), top: B:104:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014e A[Catch: RuntimeException -> 0x00df, TryCatch #2 {RuntimeException -> 0x00df, blocks: (B:53:0x0105, B:55:0x0110, B:58:0x011d, B:60:0x0123, B:62:0x013d, B:64:0x0146, B:67:0x014e, B:70:0x0167, B:72:0x0176, B:71:0x016e, B:73:0x0189, B:75:0x018f, B:77:0x0195, B:79:0x019b, B:81:0x01a1, B:83:0x01a9, B:85:0x01b1, B:87:0x01b7, B:88:0x01c9, B:26:0x0090, B:28:0x0096, B:30:0x00a0, B:32:0x00a6, B:34:0x00ac, B:36:0x00b2, B:38:0x00ba, B:40:0x00c2, B:42:0x00ca, B:44:0x00d2, B:48:0x00e6, B:50:0x00f4), top: B:104:0x0090 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.s2.run():void");
    }

    public s2(y2 y2Var, boolean z9, Uri uri, String str, String str2) {
        this.f1455d = z9;
        this.e = uri;
        this.f1453b = str;
        this.f1454c = str2;
        this.f = y2Var;
    }

    public s2(x3 x3Var, d5 d5Var, boolean z9, u uVar, Bundle bundle) {
        this.e = d5Var;
        this.f1455d = z9;
        this.f1453b = uVar;
        this.f1454c = bundle;
        Objects.requireNonNull(x3Var);
        this.f = x3Var;
    }

    public s2(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n0 n0Var, String str, String str2, boolean z9) {
        this.e = n0Var;
        this.f1453b = str;
        this.f1454c = str2;
        this.f1455d = z9;
        this.f = appMeasurementDynamiteService;
    }
}
