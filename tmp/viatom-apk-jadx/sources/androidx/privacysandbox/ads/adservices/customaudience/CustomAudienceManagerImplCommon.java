package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r0.f;
import r7.g;
import s6.w;
import w6.c;
import x6.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {
    private final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

    public CustomAudienceManagerImplCommon(android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
        customAudienceManager.getClass();
        this.customAudienceManager = customAudienceManager;
    }

    private final List<AdData> convertAds(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<androidx.privacysandbox.ads.adservices.common.AdData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    private final android.adservices.customaudience.CustomAudience convertCustomAudience(CustomAudience customAudience) {
        CustomAudience.Builder trustedBiddingData = new CustomAudience.Builder().setActivationTime(TimeConversions.convert(customAudience.getActivationTime())).setAds(convertAds(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(customAudience.getBuyer().convertToAdServices$ads_adservices_release()).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(TimeConversions.convert(customAudience.getExpirationTime())).setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals()));
        AdSelectionSignals userBiddingSignals = customAudience.getUserBiddingSignals();
        android.adservices.customaudience.CustomAudience customAudienceBuild = trustedBiddingData.setUserBiddingSignals(userBiddingSignals != null ? userBiddingSignals.convertToAdServices$ads_adservices_release() : null).build();
        customAudienceBuild.getClass();
        return customAudienceBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
        android.adservices.customaudience.JoinCustomAudienceRequest joinCustomAudienceRequestBuild = new JoinCustomAudienceRequest.Builder().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
        joinCustomAudienceRequestBuild.getClass();
        return joinCustomAudienceRequestBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.adservices.customaudience.LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
        android.adservices.customaudience.LeaveCustomAudienceRequest leaveCustomAudienceRequestBuild = new LeaveCustomAudienceRequest.Builder().setBuyer(leaveCustomAudienceRequest.getBuyer().convertToAdServices$ads_adservices_release()).setName(leaveCustomAudienceRequest.getName()).build();
        leaveCustomAudienceRequestBuild.getClass();
        return leaveCustomAudienceRequestBuild;
    }

    private final android.adservices.customaudience.TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
        if (trustedBiddingData == null) {
            return null;
        }
        return new TrustedBiddingData.Builder().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object fetchAndJoinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            Object objFetchAndJoinCustomAudience = Ext10Impl.Companion.fetchAndJoinCustomAudience(customAudienceManagerImplCommon.customAudienceManager, fetchAndJoinCustomAudienceRequest, cVar);
            return objFetchAndJoinCustomAudience == a.f13718a ? objFetchAndJoinCustomAudience : w.f12711a;
        }
        a2.a.m("API is not available. Min version is API 31 ext 10");
        return null;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object joinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        customAudienceManagerImplCommon.getCustomAudienceManager().joinCustomAudience(customAudienceManagerImplCommon.convertJoinRequest(joinCustomAudienceRequest), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == a.f13718a ? objQ : w.f12711a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object leaveCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        customAudienceManagerImplCommon.getCustomAudienceManager().leaveCustomAudience(customAudienceManagerImplCommon.convertLeaveRequest(leaveCustomAudienceRequest), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == a.f13718a ? objQ : w.f12711a;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object fetchAndJoinCustomAudience(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
        return fetchAndJoinCustomAudience$suspendImpl(this, fetchAndJoinCustomAudienceRequest, cVar);
    }

    public final android.adservices.customaudience.CustomAudienceManager getCustomAudienceManager() {
        return this.customAudienceManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, c cVar) {
        return joinCustomAudience$suspendImpl(this, joinCustomAudienceRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, c cVar) {
        return leaveCustomAudience$suspendImpl(this, leaveCustomAudienceRequest, cVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        private Ext10Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object fetchAndJoinCustomAudience(android.adservices.customaudience.CustomAudienceManager customAudienceManager, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, c cVar) {
                g gVar = new g(1, f.F(cVar));
                gVar.s();
                customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
                Object objQ = gVar.q();
                return objQ == a.f13718a ? objQ : w.f12711a;
            }

            private Companion() {
            }
        }
    }
}
