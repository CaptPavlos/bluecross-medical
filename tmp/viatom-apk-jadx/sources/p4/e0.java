package p4;

import android.net.Uri;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11938a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f11939b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11940c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f11941d;
    public final /* synthetic */ Uri e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(InstallerActivity installerActivity, Uri uri, String str, w6.c cVar) {
        super(2, cVar);
        this.f11941d = installerActivity;
        this.e = uri;
        this.f11940c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11938a) {
            case 0:
                return new e0(this.f11941d, this.e, this.f11940c, cVar);
            default:
                return new e0(this.f11940c, this.f11941d, this.e, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11938a) {
        }
        return ((e0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.e0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(String str, InstallerActivity installerActivity, Uri uri, w6.c cVar) {
        super(2, cVar);
        this.f11940c = str;
        this.f11941d = installerActivity;
        this.e = uri;
    }
}
