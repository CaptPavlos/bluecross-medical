package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import r0.f;
import r7.g;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    private final android.adservices.appsetid.AppSetIdManager mAppSetIdManager;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {38}, m = "getAppSetId$suspendImpl")
    /* renamed from: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSetIdManagerImplCommon.getAppSetId$suspendImpl(AppSetIdManagerImplCommon.this, this);
        }
    }

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager appSetIdManager) {
        appSetIdManager.getClass();
        this.mAppSetIdManager = appSetIdManager;
    }

    private final AppSetId convertResponse(android.adservices.appsetid.AppSetId appSetId) {
        if (appSetId.getScope() == 1) {
            String id = appSetId.getId();
            id.getClass();
            return new AppSetId(id, 1);
        }
        String id2 = appSetId.getId();
        id2.getClass();
        return new AppSetId(id2, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4, w6.c r5) {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon) r4
            s6.a.e(r5)
            goto L40
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L30:
            s6.a.e(r5)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r5 = r4.getAppSetIdAsyncInternal(r0)
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L40
            return r0
        L40:
            android.adservices.appsetid.AppSetId r5 = (android.adservices.appsetid.AppSetId) r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r4 = r4.convertResponse(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, w6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(w6.c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        this.mAppSetIdManager.getAppSetId(new a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        return gVar.q();
    }

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    @DoNotInline
    public Object getAppSetId(w6.c cVar) {
        return getAppSetId$suspendImpl(this, cVar);
    }
}
