package x4;

import android.app.Activity;
import android.content.pm.PackageInfo;
import p4.d0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public String f13623a;

    /* renamed from: b, reason: collision with root package name */
    public PackageInfo f13624b;

    /* renamed from: c, reason: collision with root package name */
    public int f13625c;

    /* renamed from: d, reason: collision with root package name */
    public int f13626d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Activity f;
    public final /* synthetic */ d0 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, Activity activity, d0 d0Var, w6.c cVar) {
        super(2, cVar);
        this.e = str;
        this.f = activity;
        this.g = d0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new i(this.e, this.f, this.g, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e0, code lost:
    
        if (r0 == r9) goto L87;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0133 A[Catch: Exception -> 0x0138, TryCatch #5 {Exception -> 0x0138, blocks: (B:88:0x01e3, B:84:0x01cb, B:56:0x011c, B:58:0x0133, B:61:0x013b, B:63:0x0176, B:67:0x0183, B:69:0x018b, B:73:0x01a4, B:78:0x01b3, B:81:0x01c0, B:52:0x010b, B:85:0x01ce), top: B:106:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018b A[Catch: Exception -> 0x0138, TRY_LEAVE, TryCatch #5 {Exception -> 0x0138, blocks: (B:88:0x01e3, B:84:0x01cb, B:56:0x011c, B:58:0x0133, B:61:0x013b, B:63:0x0176, B:67:0x0183, B:69:0x018b, B:73:0x01a4, B:78:0x01b3, B:81:0x01c0, B:52:0x010b, B:85:0x01ce), top: B:106:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b3 A[Catch: Exception -> 0x0138, TRY_LEAVE, TryCatch #5 {Exception -> 0x0138, blocks: (B:88:0x01e3, B:84:0x01cb, B:56:0x011c, B:58:0x0133, B:61:0x013b, B:63:0x0176, B:67:0x0183, B:69:0x018b, B:73:0x01a4, B:78:0x01b3, B:81:0x01c0, B:52:0x010b, B:85:0x01ce), top: B:106:0x001a }] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13, types: [u4.a] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2, types: [u4.a] */
    /* JADX WARN: Type inference failed for: r16v1, types: [w6.c] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
