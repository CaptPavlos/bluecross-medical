package c5;

import android.content.Context;
import c1.w4;
import com.google.android.gms.internal.measurement.j4;
import com.uptodown.activities.PasswordRecoveryActivity;
import h5.p0;
import java.io.Serializable;
import java.util.ArrayList;
import l4.pa;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1660c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1661d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, kotlin.jvm.internal.x xVar, String str, j4 j4Var, w6.c cVar) {
        super(2, cVar);
        this.f1658a = 11;
        this.f1659b = context;
        this.f1661d = xVar;
        this.f1660c = str;
        this.e = j4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1658a) {
            case 0:
                return new c(this.f1659b, this.f1660c, this.f1661d, this.e, cVar, 0);
            case 1:
                return new c((w2.r) this.f1659b, (h5.k) this.f1660c, (w4) this.f1661d, (v5.g) this.e, cVar, 1);
            case 2:
                return new c(this.f1659b, this.f1660c, this.e, (Serializable) this.f1661d, cVar, 2);
            case 3:
                return new c(this.f1659b, this.f1660c, this.f1661d, this.e, cVar, 3);
            case 4:
                return new c(this.f1659b, this.f1660c, this.f1661d, this.e, cVar, 4);
            case 5:
                return new c(this.f1659b, this.f1660c, this.e, (Serializable) this.f1661d, cVar, 5);
            case 6:
                return new c(this.f1659b, this.f1660c, this.e, (Serializable) this.f1661d, cVar, 6);
            case 7:
                return new c((l4.w) this.f1659b, (String) this.f1660c, (g7.a) this.f1661d, (g7.a) this.e, cVar, 7);
            case 8:
                return new c((kotlin.jvm.internal.x) this.f1661d, (PasswordRecoveryActivity) this.f1659b, (kotlin.jvm.internal.x) this.f1660c, (kotlin.jvm.internal.x) this.e, cVar);
            case 9:
                return new c((kotlin.jvm.internal.v) this.e, (p0) this.f1659b, (PasswordRecoveryActivity) this.f1660c, (kotlin.jvm.internal.x) this.f1661d, cVar);
            case 10:
                return new c((Context) this.f1659b, (ArrayList) this.f1660c, (ArrayList) this.f1661d, (pa) this.e, cVar, 10);
            case 11:
                return new c((Context) this.f1659b, (kotlin.jvm.internal.x) this.f1661d, (String) this.f1660c, (j4) this.e, cVar);
            default:
                return new c(this.f1659b, this.f1660c, this.f1661d, this.e, cVar, 12);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1658a) {
            case 0:
                return ((c) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 1:
                return ((c) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 2:
                return ((c) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 3:
                c cVar2 = (c) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                cVar2.invokeSuspend(wVar2);
                return wVar2;
            case 4:
                c cVar3 = (c) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                cVar3.invokeSuspend(wVar3);
                return wVar3;
            case 5:
                c cVar4 = (c) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                cVar4.invokeSuspend(wVar4);
                return wVar4;
            case 6:
                c cVar5 = (c) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                cVar5.invokeSuspend(wVar5);
                return wVar5;
            case 7:
                c cVar6 = (c) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                cVar6.invokeSuspend(wVar6);
                return wVar6;
            case 8:
                c cVar7 = (c) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                cVar7.invokeSuspend(wVar7);
                return wVar7;
            case 9:
                c cVar8 = (c) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                cVar8.invokeSuspend(wVar8);
                return wVar8;
            case 10:
                c cVar9 = (c) create(wVar, cVar);
                s6.w wVar9 = s6.w.f12711a;
                cVar9.invokeSuspend(wVar9);
                return wVar9;
            case 11:
                c cVar10 = (c) create(wVar, cVar);
                s6.w wVar10 = s6.w.f12711a;
                cVar10.invokeSuspend(wVar10);
                return wVar10;
            default:
                c cVar11 = (c) create(wVar, cVar);
                s6.w wVar11 = s6.w.f12711a;
                cVar11.invokeSuspend(wVar11);
                return wVar11;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0405  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 1490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Serializable serializable, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1658a = i10;
        this.f1659b = obj;
        this.f1660c = obj2;
        this.e = obj3;
        this.f1661d = serializable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1658a = i10;
        this.f1659b = obj;
        this.f1660c = obj2;
        this.f1661d = obj3;
        this.e = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.jvm.internal.v vVar, p0 p0Var, PasswordRecoveryActivity passwordRecoveryActivity, kotlin.jvm.internal.x xVar, w6.c cVar) {
        super(2, cVar);
        this.f1658a = 9;
        this.e = vVar;
        this.f1659b = p0Var;
        this.f1660c = passwordRecoveryActivity;
        this.f1661d = xVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.jvm.internal.x xVar, PasswordRecoveryActivity passwordRecoveryActivity, kotlin.jvm.internal.x xVar2, kotlin.jvm.internal.x xVar3, w6.c cVar) {
        super(2, cVar);
        this.f1658a = 8;
        this.f1661d = xVar;
        this.f1659b = passwordRecoveryActivity;
        this.f1660c = xVar2;
        this.e = xVar3;
    }
}
