package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import r0.f;
import r7.g;
import s6.w;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AdSelectionManagerImplCommon extends AdSelectionManager {
    private final android.adservices.adselection.AdSelectionManager mAdSelectionManager;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon", f = "AdSelectionManagerImplCommon.kt", l = {44}, m = "selectAds$suspendImpl")
    /* renamed from: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdSelectionManagerImplCommon.selectAds$suspendImpl(AdSelectionManagerImplCommon.this, (AdSelectionConfig) null, this);
        }
    }

    public AdSelectionManagerImplCommon(android.adservices.adselection.AdSelectionManager adSelectionManager) {
        adSelectionManager.getClass();
        this.mAdSelectionManager = adSelectionManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static /* synthetic */ Object getAdSelectionData$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, GetAdSelectionDataRequest getAdSelectionDataRequest, w6.c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.getAdSelectionData(adSelectionManagerImplCommon.mAdSelectionManager, getAdSelectionDataRequest, cVar);
        }
        a2.a.m("API is not available. Min version is API 31 ext 10");
        return null;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static /* synthetic */ Object persistAdSelectionResult$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, PersistAdSelectionResultRequest persistAdSelectionResultRequest, w6.c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.persistAdSelectionResult(adSelectionManagerImplCommon.mAdSelectionManager, persistAdSelectionResultRequest, cVar);
        }
        a2.a.m("API is not available. Min version is API 31 ext 10");
        return null;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object reportEvent$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportEventRequest reportEventRequest, w6.c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            Object objReportEvent = Ext8Impl.Companion.reportEvent(adSelectionManagerImplCommon.mAdSelectionManager, reportEventRequest, cVar);
            return objReportEvent == x6.a.f13718a ? objReportEvent : w.f12711a;
        }
        a2.a.m("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        return null;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object reportImpression$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportImpressionRequest reportImpressionRequest, w6.c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        adSelectionManagerImplCommon.getMAdSelectionManager().reportImpression(reportImpressionRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object selectAds$suspendImpl(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon r4, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig r5, w6.c r6) {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            s6.a.e(r6)
            goto L3e
        L25:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L2c:
            s6.a.e(r6)
            android.adservices.adselection.AdSelectionConfig r5 = r5.convertToAdServices$ads_adservices_release()
            r0.label = r2
            java.lang.Object r6 = r4.selectAdsInternal(r5, r0)
            x6.a r4 = x6.a.f13718a
            if (r6 != r4) goto L3e
            return r4
        L3e:
            android.adservices.adselection.AdSelectionOutcome r4 = androidx.privacysandbox.ads.adservices.adid.a.b(r6)
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r5 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.selectAds$suspendImpl(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig, w6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public final Object selectAdsInternal(android.adservices.adselection.AdSelectionConfig adSelectionConfig, w6.c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        getMAdSelectionManager().selectAds(adSelectionConfig, new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        return gVar.q();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static Object updateAdCounterHistogram$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, w6.c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            Object objUpdateAdCounterHistogram = Ext8Impl.Companion.updateAdCounterHistogram(adSelectionManagerImplCommon.mAdSelectionManager, updateAdCounterHistogramRequest, cVar);
            return objUpdateAdCounterHistogram == x6.a.f13718a ? objUpdateAdCounterHistogram : w.f12711a;
        }
        a2.a.m("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        return null;
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object getAdSelectionData(GetAdSelectionDataRequest getAdSelectionDataRequest, w6.c cVar) {
        return getAdSelectionData$suspendImpl(this, getAdSelectionDataRequest, cVar);
    }

    public final android.adservices.adselection.AdSelectionManager getMAdSelectionManager() {
        return this.mAdSelectionManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object persistAdSelectionResult(PersistAdSelectionResultRequest persistAdSelectionResultRequest, w6.c cVar) {
        return persistAdSelectionResult$suspendImpl(this, persistAdSelectionResultRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object reportEvent(ReportEventRequest reportEventRequest, w6.c cVar) {
        return reportEvent$suspendImpl(this, reportEventRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object reportImpression(ReportImpressionRequest reportImpressionRequest, w6.c cVar) {
        return reportImpression$suspendImpl(this, reportImpressionRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object selectAds(AdSelectionConfig adSelectionConfig, w6.c cVar) {
        return selectAds$suspendImpl(this, adSelectionConfig, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object updateAdCounterHistogram(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, w6.c cVar) {
        return updateAdCounterHistogram$suspendImpl(this, updateAdCounterHistogramRequest, cVar);
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

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object getAdSelectionData(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r6, w6.c r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    int r1 = r0.label
                    r2 = 1
                    if (r1 == 0) goto L35
                    if (r1 != r2) goto L2e
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adid.a.a(r5)
                    s6.a.e(r7)
                    goto L64
                L2e:
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    androidx.window.layout.c.g(r5)
                    r5 = 0
                    return r5
                L35:
                    s6.a.e(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r2
                    r7.g r7 = new r7.g
                    w6.c r0 = r0.f.F(r0)
                    r7.<init>(r2, r0)
                    r7.s()
                    android.adservices.adselection.GetAdSelectionDataRequest r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.arch.core.executor.a r0 = new androidx.arch.core.executor.a
                    r1 = 2
                    r0.<init>(r1)
                    android.os.OutcomeReceiver r1 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    r5.getAdSelectionData(r6, r0, r1)
                    java.lang.Object r7 = r7.q()
                    x6.a r5 = x6.a.f13718a
                    if (r7 != r5) goto L64
                    return r5
                L64:
                    android.adservices.adselection.GetAdSelectionDataOutcome r7 = (android.adservices.adselection.GetAdSelectionDataOutcome) r7
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome r5 = new androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome
                    r5.<init>(r7)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.getAdSelectionData(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest, w6.c):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object persistAdSelectionResult(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r6, w6.c r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    int r1 = r0.label
                    r2 = 1
                    if (r1 == 0) goto L35
                    if (r1 != r2) goto L2e
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adid.a.a(r5)
                    s6.a.e(r7)
                    goto L64
                L2e:
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    androidx.window.layout.c.g(r5)
                    r5 = 0
                    return r5
                L35:
                    s6.a.e(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r2
                    r7.g r7 = new r7.g
                    w6.c r0 = r0.f.F(r0)
                    r7.<init>(r2, r0)
                    r7.s()
                    android.adservices.adselection.PersistAdSelectionResultRequest r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.arch.core.executor.a r0 = new androidx.arch.core.executor.a
                    r1 = 2
                    r0.<init>(r1)
                    android.os.OutcomeReceiver r1 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    r5.persistAdSelectionResult(r6, r0, r1)
                    java.lang.Object r7 = r7.q()
                    x6.a r5 = x6.a.f13718a
                    if (r7 != r5) goto L64
                    return r5
                L64:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adid.a.b(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.persistAdSelectionResult(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest, w6.c):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object selectAds(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r6, w6.c r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.result
                    int r1 = r0.label
                    r2 = 1
                    if (r1 == 0) goto L35
                    if (r1 != r2) goto L2e
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r5 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adid.a.a(r5)
                    s6.a.e(r7)
                    goto L64
                L2e:
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    androidx.window.layout.c.g(r5)
                    r5 = 0
                    return r5
                L35:
                    s6.a.e(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r2
                    r7.g r7 = new r7.g
                    w6.c r0 = r0.f.F(r0)
                    r7.<init>(r2, r0)
                    r7.s()
                    android.adservices.adselection.AdSelectionFromOutcomesConfig r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.arch.core.executor.a r0 = new androidx.arch.core.executor.a
                    r1 = 2
                    r0.<init>(r1)
                    android.os.OutcomeReceiver r1 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    r5.selectAds(r6, r0, r1)
                    java.lang.Object r7 = r7.q()
                    x6.a r5 = x6.a.f13718a
                    if (r7 != r5) goto L64
                    return r5
                L64:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adid.a.b(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.selectAds(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig, w6.c):java.lang.Object");
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext8Impl {
        public static final Companion Companion = new Companion(null);

        private Ext8Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object reportEvent(android.adservices.adselection.AdSelectionManager adSelectionManager, ReportEventRequest reportEventRequest, w6.c cVar) {
                g gVar = new g(1, f.F(cVar));
                gVar.s();
                adSelectionManager.reportEvent(reportEventRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
                Object objQ = gVar.q();
                return objQ == x6.a.f13718a ? objQ : w.f12711a;
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object updateAdCounterHistogram(android.adservices.adselection.AdSelectionManager adSelectionManager, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, w6.c cVar) {
                g gVar = new g(1, f.F(cVar));
                gVar.s();
                adSelectionManager.updateAdCounterHistogram(updateAdCounterHistogramRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
                Object objQ = gVar.q();
                return objQ == x6.a.f13718a ? objQ : w.f12711a;
            }

            private Companion() {
            }
        }
    }

    @Override // androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object selectAds(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, w6.c cVar) {
        return selectAds$suspendImpl(this, adSelectionFromOutcomesConfig, cVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public static /* synthetic */ Object selectAds$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, w6.c cVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() < 10 && adServicesInfo.extServicesVersionS() < 10) {
            a2.a.m("API is not available. Min version is API 31 ext 10");
            return null;
        }
        return Ext10Impl.Companion.selectAds(adSelectionManagerImplCommon.mAdSelectionManager, adSelectionFromOutcomesConfig, cVar);
    }
}
