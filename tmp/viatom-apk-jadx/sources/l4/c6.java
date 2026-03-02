package l4;

import com.uptodown.activities.PasswordRecoveryActivity;
import java.io.File;
import java.io.Serializable;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c6 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10290a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10291b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10292c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f10293d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c6(PasswordRecoveryActivity passwordRecoveryActivity, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.x xVar2, kotlin.jvm.internal.x xVar3, kotlin.jvm.internal.v vVar, w6.c cVar) {
        super(2, cVar);
        this.f10292c = passwordRecoveryActivity;
        this.f10293d = xVar;
        this.e = xVar2;
        this.f = xVar3;
        this.g = vVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10290a) {
            case 0:
                return new c6((PasswordRecoveryActivity) this.f10292c, (kotlin.jvm.internal.x) this.f10293d, (kotlin.jvm.internal.x) this.e, (kotlin.jvm.internal.x) this.f, (kotlin.jvm.internal.v) this.g, cVar);
            default:
                return new c6((File) this.f10293d, (String) this.e, (ZipOutputStream) this.f, (x4.y) this.g, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10290a) {
        }
        return ((c6) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
    
        if (r2 != r5) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c6.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c6(File file, String str, ZipOutputStream zipOutputStream, x4.y yVar, w6.c cVar) {
        super(2, cVar);
        this.f10293d = file;
        this.e = str;
        this.f = zipOutputStream;
        this.g = yVar;
    }
}
