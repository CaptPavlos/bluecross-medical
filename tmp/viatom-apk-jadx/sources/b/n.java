package b;

import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.core.activities.InstallerActivity;
import g7.p;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class n extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f801a;

    /* renamed from: b, reason: collision with root package name */
    public int f802b;

    /* renamed from: c, reason: collision with root package name */
    public int f803c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f804d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(NotificationsRegistryActivity notificationsRegistryActivity, int i10, w6.c cVar) {
        super(2, cVar);
        this.f801a = 1;
        this.f804d = notificationsRegistryActivity;
        this.f803c = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f801a) {
            case 0:
                return new n((o) this.f804d, cVar, 0);
            case 1:
                return new n((NotificationsRegistryActivity) this.f804d, this.f803c, cVar);
            default:
                return new n((InstallerActivity) this.f804d, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f801a) {
        }
        return ((n) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[Catch: Exception -> 0x001f, LOOP:0: B:18:0x0051->B:20:0x0055, LOOP_END, TryCatch #0 {Exception -> 0x001f, blocks: (B:8:0x001b, B:25:0x0085, B:17:0x0035, B:18:0x0051, B:20:0x0055, B:21:0x006d, B:14:0x0029), top: B:137:0x0015 }] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0084 -> B:25:0x0085). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f801a = i10;
        this.f804d = obj;
    }
}
