package a3;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f174a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f175b;

    /* renamed from: c, reason: collision with root package name */
    public Object f176c;

    /* renamed from: d, reason: collision with root package name */
    public Object f177d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f178i;

    /* renamed from: j, reason: collision with root package name */
    public Object f179j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(Context context, DocumentFile documentFile, ArrayList arrayList, x4.y yVar, b9.h hVar, w6.c cVar) {
        super(2, cVar);
        this.f = context;
        this.g = documentFile;
        this.h = arrayList;
        this.f178i = yVar;
        this.f179j = hVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f174a) {
            case 0:
                return new w0((y0) this.e, (t0) this.f178i, cVar);
            default:
                return new w0((Context) this.f, (DocumentFile) this.g, (ArrayList) this.h, (x4.y) this.f178i, (b9.h) this.f179j, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f174a) {
        }
        return ((w0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(1:(1:(1:(1:(1:(2:11|49)(1:12))(4:13|42|29|(3:31|(1:34)|(0)(3:37|38|(0)(4:41|42|29|(5:43|(1:45)|46|(0)|49)(0))))(0)))(3:14|38|(0)))(5:15|27|28|29|(0)(0)))(1:16))(2:17|(0))|97|20|(1:22)(1:27)|28|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a2, code lost:
    
        r2 = r7.i0.f12407a;
        r2 = w7.n.f13548a;
        r11 = new a6.n(r10, null, 25);
        r24.f175b = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
    
        if (r7.y.z(r11, r2, r24) == r3) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0260  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0144 -> B:42:0x0149). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.w0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(y0 y0Var, t0 t0Var, w6.c cVar) {
        super(2, cVar);
        this.e = y0Var;
        this.f178i = t0Var;
    }
}
