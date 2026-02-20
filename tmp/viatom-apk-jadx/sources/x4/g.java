package x4;

import com.google.android.gms.internal.measurement.j4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f13609a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13610b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13611c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.x f13612d;
    public Serializable e;
    public Object f;
    public Object g;
    public Iterator h;

    /* renamed from: i, reason: collision with root package name */
    public int f13613i;

    /* renamed from: j, reason: collision with root package name */
    public int f13614j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13615k;

    /* renamed from: l, reason: collision with root package name */
    public int f13616l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j4 f13617m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13618n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j4 j4Var, ArrayList arrayList, w6.c cVar) {
        super(2, cVar);
        this.f13617m = j4Var;
        this.f13618n = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new g(this.f13617m, this.f13618n, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((g) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:65|(3:67|(1:69)(1:71)|(4:73|(1:75)(1:76)|77|(2:79|244)(19:80|81|82|(3:286|126|(6:128|129|294|(4:132|(2:293|244)(1:295)|130|277)|292|139))|144|(4:148|(3:150|(1:158)(1:157)|159)|160|(1:162))|163|(1:165)|(1:167)|168|279|169|(13:172|263|173|174|273|175|(1:177)|178|182|183|184|185|170)|296|201|(1:203)(1:204)|205|(4:208|268|209|(7:261|211|212|215|216|(1:218)|219)(1:224))|244)))|124|(0)|144|(5:146|148|(0)|160|(0))|163|(0)|(0)|168|279|169|(1:170)|296|201|(0)(0)|205|(0)|244) */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x046b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x046c, code lost:
    
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x046f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0532, code lost:
    
        if (r0 == r11) goto L244;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0383 A[Catch: all -> 0x03ab, Exception -> 0x03b0, TRY_LEAVE, TryCatch #29 {Exception -> 0x03b0, all -> 0x03ab, blocks: (B:130:0x037d, B:132:0x0383), top: B:277:0x037d }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03d2 A[Catch: all -> 0x03b9, Exception -> 0x03bd, TryCatch #24 {Exception -> 0x03bd, all -> 0x03b9, blocks: (B:144:0x03c1, B:146:0x03d2, B:148:0x03d6, B:150:0x03da, B:152:0x03e7, B:154:0x03ed, B:159:0x03f9, B:160:0x03fc, B:162:0x0400, B:163:0x0404, B:165:0x040a, B:167:0x0410, B:168:0x0413, B:126:0x0345, B:128:0x034b), top: B:286:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03da A[Catch: all -> 0x03b9, Exception -> 0x03bd, TryCatch #24 {Exception -> 0x03bd, all -> 0x03b9, blocks: (B:144:0x03c1, B:146:0x03d2, B:148:0x03d6, B:150:0x03da, B:152:0x03e7, B:154:0x03ed, B:159:0x03f9, B:160:0x03fc, B:162:0x0400, B:163:0x0404, B:165:0x040a, B:167:0x0410, B:168:0x0413, B:126:0x0345, B:128:0x034b), top: B:286:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0400 A[Catch: all -> 0x03b9, Exception -> 0x03bd, TryCatch #24 {Exception -> 0x03bd, all -> 0x03b9, blocks: (B:144:0x03c1, B:146:0x03d2, B:148:0x03d6, B:150:0x03da, B:152:0x03e7, B:154:0x03ed, B:159:0x03f9, B:160:0x03fc, B:162:0x0400, B:163:0x0404, B:165:0x040a, B:167:0x0410, B:168:0x0413, B:126:0x0345, B:128:0x034b), top: B:286:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x040a A[Catch: all -> 0x03b9, Exception -> 0x03bd, TryCatch #24 {Exception -> 0x03bd, all -> 0x03b9, blocks: (B:144:0x03c1, B:146:0x03d2, B:148:0x03d6, B:150:0x03da, B:152:0x03e7, B:154:0x03ed, B:159:0x03f9, B:160:0x03fc, B:162:0x0400, B:163:0x0404, B:165:0x040a, B:167:0x0410, B:168:0x0413, B:126:0x0345, B:128:0x034b), top: B:286:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0410 A[Catch: all -> 0x03b9, Exception -> 0x03bd, TryCatch #24 {Exception -> 0x03bd, all -> 0x03b9, blocks: (B:144:0x03c1, B:146:0x03d2, B:148:0x03d6, B:150:0x03da, B:152:0x03e7, B:154:0x03ed, B:159:0x03f9, B:160:0x03fc, B:162:0x0400, B:163:0x0404, B:165:0x040a, B:167:0x0410, B:168:0x0413, B:126:0x0345, B:128:0x034b), top: B:286:0x0345 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0433 A[Catch: all -> 0x046b, Exception -> 0x046f, TRY_LEAVE, TryCatch #28 {Exception -> 0x046f, all -> 0x046b, blocks: (B:169:0x0420, B:170:0x042d, B:172:0x0433, B:185:0x0467, B:199:0x047d, B:200:0x0480, B:201:0x0481, B:205:0x0497), top: B:279:0x0420 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x050e A[Catch: all -> 0x0505, Exception -> 0x050a, TRY_ENTER, TRY_LEAVE, TryCatch #17 {all -> 0x0505, blocks: (B:209:0x04e4, B:211:0x04ec, B:215:0x04f7, B:224:0x050e, B:214:0x04f3), top: B:268:0x04e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0587 A[DONT_GENERATE, PHI: r0
      0x0587: PHI (r0v123 android.content.pm.PackageInstaller$Session) = (r0v120 android.content.pm.PackageInstaller$Session), (r0v127 android.content.pm.PackageInstaller$Session) binds: [B:251:0x05d0, B:240:0x0585] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0345 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v129 */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v135 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v54, types: [w6.h] */
    /* JADX WARN: Type inference failed for: r0v70, types: [int] */
    /* JADX WARN: Type inference failed for: r0v87, types: [w6.h] */
    /* JADX WARN: Type inference failed for: r2v0, types: [r7.t, w6.g] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.x] */
    /* JADX WARN: Type inference failed for: r2v34, types: [kotlin.jvm.internal.x] */
    /* JADX WARN: Type inference failed for: r2v37, types: [kotlin.jvm.internal.x] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 1524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
