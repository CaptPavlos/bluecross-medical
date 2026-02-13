package a9;

import g7.p;
import java.io.IOException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w;
import z8.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f351b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f352c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b0 f353d;
    public final /* synthetic */ w e;
    public final /* synthetic */ w f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(u uVar, long j10, w wVar, b0 b0Var, w wVar2, w wVar3) {
        super(2);
        this.f350a = uVar;
        this.f351b = j10;
        this.f352c = wVar;
        this.f353d = b0Var;
        this.e = wVar2;
        this.f = wVar3;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 1) {
            u uVar = this.f350a;
            if (uVar.f10135a) {
                com.google.gson.internal.a.m("bad zip: zip64 extra repeated");
                return null;
            }
            uVar.f10135a = true;
            if (jLongValue < this.f351b) {
                com.google.gson.internal.a.m("bad zip: zip64 extra too short");
                return null;
            }
            w wVar = this.f352c;
            long longLe = wVar.f10137a;
            b0 b0Var = this.f353d;
            if (longLe == 4294967295L) {
                longLe = b0Var.readLongLe();
            }
            wVar.f10137a = longLe;
            w wVar2 = this.e;
            wVar2.f10137a = wVar2.f10137a == 4294967295L ? b0Var.readLongLe() : 0L;
            w wVar3 = this.f;
            wVar3.f10137a = wVar3.f10137a == 4294967295L ? b0Var.readLongLe() : 0L;
        }
        return s6.w.f12711a;
    }
}
