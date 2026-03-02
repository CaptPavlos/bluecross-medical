package androidx.privacysandbox.ads.adservices.signals;

import android.adservices.signals.UpdateSignalsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import r0.f;
import r7.g;
import s6.w;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@ExperimentalFeatures.Ext12OptIn
@RequiresExtension(extension = 1000000, version = 12)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ProtectedSignalsManagerImpl extends ProtectedSignalsManager {
    private final android.adservices.signals.ProtectedSignalsManager protectedSignalsManager;

    public ProtectedSignalsManagerImpl(android.adservices.signals.ProtectedSignalsManager protectedSignalsManager) {
        protectedSignalsManager.getClass();
        this.protectedSignalsManager = protectedSignalsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.signals.UpdateSignalsRequest convertUpdateRequest(UpdateSignalsRequest updateSignalsRequest) {
        android.adservices.signals.UpdateSignalsRequest updateSignalsRequestBuild = new UpdateSignalsRequest.Builder(updateSignalsRequest.getUpdateUri()).build();
        updateSignalsRequestBuild.getClass();
        return updateSignalsRequestBuild;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public static Object updateSignals$suspendImpl(ProtectedSignalsManagerImpl protectedSignalsManagerImpl, UpdateSignalsRequest updateSignalsRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        protectedSignalsManagerImpl.protectedSignalsManager.updateSignals(protectedSignalsManagerImpl.convertUpdateRequest(updateSignalsRequest), new a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : w.f12711a;
    }

    @Override // androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public Object updateSignals(UpdateSignalsRequest updateSignalsRequest, c cVar) {
        return updateSignals$suspendImpl(this, updateSignalsRequest, cVar);
    }
}
