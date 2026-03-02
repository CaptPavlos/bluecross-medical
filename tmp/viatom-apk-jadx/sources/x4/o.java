package x4;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.u f13635a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.u f13636b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f13637c;

    /* renamed from: d, reason: collision with root package name */
    public ZipFile f13638d;
    public Object e;
    public Object f;
    public String g;
    public kotlin.jvm.internal.x h;

    /* renamed from: i, reason: collision with root package name */
    public FileOutputStream f13639i;

    /* renamed from: j, reason: collision with root package name */
    public kotlin.jvm.internal.v f13640j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f13641k;

    /* renamed from: l, reason: collision with root package name */
    public int f13642l;

    /* renamed from: m, reason: collision with root package name */
    public int f13643m;

    /* renamed from: n, reason: collision with root package name */
    public int f13644n;

    /* renamed from: o, reason: collision with root package name */
    public long f13645o;

    /* renamed from: p, reason: collision with root package name */
    public long f13646p;

    /* renamed from: q, reason: collision with root package name */
    public int f13647q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ File f13648r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ t3.h f13649s;
    public final /* synthetic */ File t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ t4.d f13650u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(File file, t3.h hVar, File file2, t4.d dVar, w6.c cVar) {
        super(2, cVar);
        this.f13648r = file;
        this.f13649s = hVar;
        this.t = file2;
        this.f13650u = dVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new o(this.f13648r, this.f13649s, this.t, this.f13650u, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((o) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:291|105|(6:(2:107|(4:326|111|331|330)(2:329|110))(2:328|113)|269|121|122|123|(1:327)(4:126|127|332|330))|114|267|115|(1:117)|118|119|120) */
    /* JADX WARN: Can't wrap try/catch for region: R(10:324|281|133|279|134|265|135|283|137|(16:313|139|140|141|303|142|143|144|257|145|146|147|148|249|149|(1:152))(2:159|319)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:33|271|34|(4:297|37|38|35)|334|40|41|(2:295|42)|(3:259|44|(9:46|47|305|48|49|(9:293|51|(0)(1:54)|168|160|169|295|42|(0))|57|58|(6:309|60|61|287|62|(15:93|88|307|94|95|261|96|97|247|98|99|333|(6:251|100|101|(18:103|277|104|291|105|(2:107|(4:326|111|331|330)(2:329|110))(2:328|113)|114|267|115|(1:117)|118|119|120|269|121|122|123|(1:327)(4:126|127|332|330))(12:324|132|281|133|279|134|265|135|136|283|137|(16:313|139|140|141|303|142|143|144|257|145|146|147|148|249|149|(1:152))(2:159|319))|196|(2:198|(4:200|(1:339)|203|341)(6:204|(3:206|(2:209|207)|321)|210|(1:340)|213|342))(8:214|(2:216|(2:(5:221|275|222|223|219)|322))|227|(3:229|(2:232|230)|323)|233|(1:336)|236|237))|125|335)(16:64|(5:66|67|68|315|69)(1:73)|74|255|75|76|77|311|78|79|80|301|81|82|83|(1:337)(16:86|87|88|307|94|95|261|96|97|247|98|99|333|(7:251|100|101|(0)(0)|196|(0)(0)|330)|125|335)))(9:166|263|167|168|160|169|295|42|(0))))|174|285|175|(3:192|196|(0)(0))(7:179|(1:181)|182|183|289|184|(1:338)(5:187|188|189|196|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0420, code lost:
    
        r7 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x058e, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:293:0x01fe, B:57:0x021e], limit reached: 336 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x042b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v35, types: [int] */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37, types: [byte[], java.io.FileOutputStream, java.lang.Object, java.lang.String, java.util.ArrayList, java.util.zip.ZipFile, kotlin.jvm.internal.u, kotlin.jvm.internal.v, kotlin.jvm.internal.x, w6.c] */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r15v22, types: [b2.a, byte[], java.io.FileOutputStream, java.lang.Object, java.lang.String, java.util.ArrayList, java.util.zip.ZipFile, kotlin.jvm.internal.u, kotlin.jvm.internal.v, kotlin.jvm.internal.x, w6.c] */
    /* JADX WARN: Type inference failed for: r15v23, types: [b2.a, byte[], java.io.FileOutputStream, java.lang.Object, java.lang.String, java.util.ArrayList, java.util.zip.ZipFile, kotlin.jvm.internal.u, kotlin.jvm.internal.v, kotlin.jvm.internal.x, w6.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x0490 -> B:153:0x049b). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
