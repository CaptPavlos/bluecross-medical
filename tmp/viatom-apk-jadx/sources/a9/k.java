package a9;

import g7.p;
import java.io.IOException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.x;
import s6.w;
import z8.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f356c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f357d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(b0 b0Var, x xVar, x xVar2, x xVar3) {
        super(2);
        this.f354a = b0Var;
        this.f355b = xVar;
        this.f356c = xVar2;
        this.f357d = xVar3;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 21589) {
            if (jLongValue < 1) {
                com.google.gson.internal.a.m("bad zip: extended timestamp extra too short");
                return null;
            }
            byte b10 = this.f354a.readByte();
            boolean z9 = (b10 & 1) == 1;
            boolean z10 = (b10 & 2) == 2;
            boolean z11 = (b10 & 4) == 4;
            long j10 = z9 ? 5L : 1L;
            if (z10) {
                j10 += 4;
            }
            if (z11) {
                j10 += 4;
            }
            if (jLongValue < j10) {
                com.google.gson.internal.a.m("bad zip: extended timestamp extra too short");
                return null;
            }
            if (z9) {
                this.f355b.f10138a = Long.valueOf(r2.readIntLe() * 1000);
            }
            if (z10) {
                this.f356c.f10138a = Long.valueOf(r2.readIntLe() * 1000);
            }
            if (z11) {
                this.f357d.f10138a = Long.valueOf(r2.readIntLe() * 1000);
            }
        }
        return w.f12711a;
    }
}
