package a6;

import a3.x;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import c1.w4;
import com.google.android.gms.internal.measurement.j4;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.PreRegisterWorker;
import e5.a2;
import e5.b2;
import h5.g0;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f282a;

    /* renamed from: b, reason: collision with root package name */
    public int f283b;

    /* renamed from: c, reason: collision with root package name */
    public Object f284c;

    /* renamed from: d, reason: collision with root package name */
    public Object f285d;
    public /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i10, AppInstalledDetailsActivity appInstalledDetailsActivity, String str, h5.q qVar, y0 y0Var, w6.c cVar) {
        super(2, cVar);
        this.f282a = 7;
        this.f283b = i10;
        this.f285d = appInstalledDetailsActivity;
        this.f284c = str;
        this.e = qVar;
        this.f = y0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r14 == r8) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c5, code lost:
    
        if (r14 != r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00df, code lost:
    
        if (r14 != r8) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0100, code lost:
    
        if (r14 != r8) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0118, code lost:
    
        if (r14 != r8) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105 A[PHI: r0
      0x0105: PHI (r0v23 java.io.InputStream) = (r0v13 java.io.InputStream), (r0v19 java.io.InputStream), (r0v24 java.io.InputStream) binds: [B:40:0x00e5, B:52:0x011b, B:47:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object a(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.q.a(java.lang.Object):java.lang.Object");
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f282a) {
            case 0:
                return new q(this.f283b, (PreRegisterWorker) this.f285d, (h5.h) this.e, (g0) this.f, (String) this.f284c, cVar);
            case 1:
                q qVar = new q((String) this.f284c, (String) this.e, (Boolean) this.f, cVar);
                qVar.f285d = obj;
                return qVar;
            case 2:
                return new q((x) this.f284c, (kotlin.jvm.internal.v) this.f285d, (ArrayList) this.e, (kotlin.jvm.internal.x) this.f, cVar, 2);
            case 3:
                return new q((c5.t) this.e, (w4) this.f, cVar);
            case 4:
                return new q((d3.d) this.f284c, this.f285d, (a3.o) this.e, (n) this.f, cVar, 4);
            case 5:
                return new q((b2) this.f284c, (a2) this.f285d, (g0) this.f, (h5.h) this.e, cVar);
            case 6:
                q qVar2 = new q((x) this.f, (String) this.f284c, cVar);
                qVar2.e = obj;
                return qVar2;
            case 7:
                return new q(this.f283b, (AppInstalledDetailsActivity) this.f285d, (String) this.f284c, (h5.q) this.e, (y0) this.f, cVar);
            case 8:
                return new q(this.f285d, (String) this.f284c, this.e, this.f, cVar, 8);
            case 9:
                return new q((ArrayList) this.f284c, (DocumentFile) this.f285d, (b9.h) this.e, (FileExplorerActivity) this.f, cVar, 9);
            case 10:
                return new q((ArrayList) this.f284c, (File) this.f285d, (b9.h) this.e, (FileExplorerActivity) this.f, cVar, 10);
            case 11:
                return new q((FileExplorerActivity) this.e, (kotlin.jvm.internal.u) this.f, (String) this.f284c, cVar);
            case 12:
                return new q(this.f285d, (String) this.f284c, this.e, this.f, cVar, 12);
            case 13:
                return new q((File) this.f284c, (Uri) this.f285d, (d5.j) this.e, (FileExplorerActivity) this.f, cVar, 13);
            case 14:
                return new q(this.f285d, (String) this.f284c, this.e, this.f, cVar, 14);
            case 15:
                return new q((DocumentFile) this.f284c, (Uri) this.f285d, (d5.j) this.e, (FileExplorerActivity) this.f, cVar, 15);
            case 16:
                return new q((File) this.f285d, (File) this.e, (j4) this.f, cVar);
            default:
                return new q((z5.d) this.f284c, (w) this.f285d, (z5.c) this.e, (z5.c) this.f, cVar, 17);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f282a) {
            case 0:
                q qVar = (q) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar = s6.w.f12711a;
                qVar.invokeSuspend(wVar);
                break;
            case 7:
                q qVar2 = (q) create((r7.w) obj, (w6.c) obj2);
                s6.w wVar2 = s6.w.f12711a;
                qVar2.invokeSuspend(wVar2);
                break;
        }
        return ((q) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:193|(1:448)|(1:(1:(3:197|228|229)(2:198|498))(3:199|200|201))(3:202|203|(7:218|(1:220)(1:221)|222|225|(1:500)|228|229)(2:207|(2:209|499)))|210|441|211|225|(0)|228|229) */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04e1, code lost:
    
        r0 = com.inmobi.cmp.ChoiceCmp.INSTANCE.getCallback();
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x04e7, code lost:
    
        if (r0 == null) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04ea, code lost:
    
        r0.onCmpError(com.inmobi.cmp.model.ChoiceError.INVALID_JSON_FORMAT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x04ef, code lost:
    
        r0 = new d9.f();
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:500:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v40, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v57, types: [androidx.lifecycle.LiveDataScope] */
    /* JADX WARN: Type inference failed for: r1v59, types: [androidx.lifecycle.LiveDataScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v62, types: [androidx.lifecycle.LiveDataScope] */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i10, PreRegisterWorker preRegisterWorker, h5.h hVar, g0 g0Var, String str, w6.c cVar) {
        super(2, cVar);
        this.f282a = 0;
        this.f284c = str;
        this.f285d = preRegisterWorker;
        this.e = hVar;
        this.f283b = i10;
        this.f = g0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(x xVar, String str, w6.c cVar) {
        super(2, cVar);
        this.f282a = 6;
        this.f = xVar;
        this.f284c = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c5.t tVar, w4 w4Var, w6.c cVar) {
        super(2, cVar);
        this.f282a = 3;
        this.e = tVar;
        this.f = w4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.u uVar, String str, w6.c cVar) {
        super(2, cVar);
        this.f282a = 11;
        this.e = fileExplorerActivity;
        this.f = uVar;
        this.f284c = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b2 b2Var, a2 a2Var, g0 g0Var, h5.h hVar, w6.c cVar) {
        super(2, cVar);
        this.f282a = 5;
        this.f284c = b2Var;
        this.f285d = a2Var;
        this.f = g0Var;
        this.e = hVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(File file, File file2, j4 j4Var, w6.c cVar) {
        super(2, cVar);
        this.f282a = 16;
        this.f285d = file;
        this.e = file2;
        this.f = j4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, Object obj2, Object obj3, Object obj4, w6.c cVar, int i10) {
        super(2, cVar);
        this.f282a = i10;
        this.f284c = obj;
        this.f285d = obj2;
        this.e = obj3;
        this.f = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, String str, Object obj2, Object obj3, w6.c cVar, int i10) {
        super(2, cVar);
        this.f282a = i10;
        this.f285d = obj;
        this.f284c = str;
        this.e = obj2;
        this.f = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, String str2, Boolean bool, w6.c cVar) {
        super(2, cVar);
        this.f282a = 1;
        this.f284c = str;
        this.e = str2;
        this.f = bool;
    }
}
