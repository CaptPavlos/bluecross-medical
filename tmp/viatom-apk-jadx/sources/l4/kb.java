package l4;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import com.inmobi.cmp.presentation.components.CmpActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class kb extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10573a;

    /* renamed from: b, reason: collision with root package name */
    public int f10574b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10575c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb(int i10, t4.d dVar, w6.c cVar) {
        super(2, cVar);
        this.f10573a = 12;
        this.f10575c = dVar;
        this.f10574b = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10573a) {
            case 0:
                return new kb((UserDevicesActivity) this.f10575c, cVar, 0);
            case 1:
                return new kb((UsernameEditActivity) this.f10575c, cVar, 1);
            case 2:
                return new kb((VirusTotalReport) this.f10575c, cVar, 2);
            case 3:
                return new kb((WishlistActivity) this.f10575c, cVar, 3);
            case 4:
                return new kb((CmpActivity) this.f10575c, cVar, 4);
            case 5:
                return new kb((l9.c) this.f10575c, cVar, 5);
            case 6:
                return new kb((p2) this.f10575c, cVar, 6);
            case 7:
                return new kb((InstallerActivity) this.f10575c, cVar, 7);
            case 8:
                return new kb((c1.g1) this.f10575c, cVar, 8);
            case 9:
                return new kb((TvMyDownloadsFragment) this.f10575c, cVar, 9);
            case 10:
                return new kb((TvOldVersionsFragment) this.f10575c, cVar, 10);
            case 11:
                return new kb((u7.o) this.f10575c, cVar, 11);
            default:
                return new kb(this.f10574b, (t4.d) this.f10575c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10573a) {
            case 0:
                ((kb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 1:
                ((kb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 2:
                ((kb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
            case 3:
                ((kb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return ((kb) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZ;
        d9.d dVar;
        int i10 = this.f10573a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        Object obj2 = this.f10575c;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                UserDevicesActivity userDevicesActivity = (UserDevicesActivity) obj2;
                int i11 = this.f10574b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                u7.m0 m0Var = ((ob) userDevicesActivity.I.getValue()).f10699b;
                jb jbVar = new jb(userDevicesActivity);
                this.f10574b = 1;
                m0Var.collect(jbVar, this);
                return aVar;
            case 1:
                UsernameEditActivity usernameEditActivity = (UsernameEditActivity) obj2;
                int i12 = this.f10574b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i13 = UsernameEditActivity.K;
                u7.m0 m0Var2 = ((bc) usernameEditActivity.I.getValue()).f10268b;
                a3.f1 f1Var = new a3.f1(usernameEditActivity, 17);
                this.f10574b = 1;
                m0Var2.collect(f1Var, this);
                return aVar;
            case 2:
                VirusTotalReport virusTotalReport = (VirusTotalReport) obj2;
                int i14 = this.f10574b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i15 = VirusTotalReport.J;
                u7.m0 m0Var3 = virusTotalReport.o0().f10473b;
                a3.f1 f1Var2 = new a3.f1(virusTotalReport, 18);
                this.f10574b = 1;
                m0Var3.collect(f1Var2, this);
                return aVar;
            case 3:
                WishlistActivity wishlistActivity = (WishlistActivity) obj2;
                int i16 = this.f10574b;
                if (i16 != 0) {
                    if (i16 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i17 = WishlistActivity.Z;
                u7.m0 m0Var4 = wishlistActivity.C0().f10743b;
                a3.f1 f1Var3 = new a3.f1(wishlistActivity, 19);
                this.f10574b = 1;
                m0Var4.collect(f1Var3, this);
                return aVar;
            case 4:
                CmpActivity cmpActivity = (CmpActivity) obj2;
                int i18 = this.f10574b;
                if (i18 == 0) {
                    s6.a.e(obj);
                    l9.c cVar2 = cmpActivity.f2617a;
                    if (cVar2 == null) {
                        return wVar;
                    }
                    this.f10574b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    objZ = r7.y.z(new kb(cVar2, cVar, 5), y7.d.f14116a, this);
                    if (objZ == aVar) {
                        return aVar;
                    }
                } else {
                    if (i18 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                    objZ = obj;
                }
                i9.a.e = (d9.d) objZ;
                int i19 = CmpActivity.f2616b;
                Bundle extras = cmpActivity.getIntent().getExtras();
                String string = extras == null ? null : extras.getString("EXTRA_ACTION");
                if (string != null) {
                    int iHashCode = string.hashCode();
                    b9.d dVar2 = b9.d.CCPA;
                    if (iHashCode != -2113348999) {
                        if (iHashCode != -1969243076) {
                            if (iHashCode != 1166950650) {
                                if (iHashCode == 1517267649 && string.equals("ACTION_SHOW_CCPA_SCREEN")) {
                                    if (cmpActivity.isFinishing()) {
                                        return wVar;
                                    }
                                    ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                                    if (!choiceCmp.isViewModelAvailable$app_release()) {
                                        ChoiceCmpCallback callback = choiceCmp.getCallback();
                                        if (callback != null) {
                                            callback.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                                        }
                                        cmpActivity.finish();
                                        return wVar;
                                    }
                                    boolean z9 = j.g.f9878a;
                                    cmpActivity.i(dVar2, false);
                                    FragmentManager supportFragmentManager = cmpActivity.getSupportFragmentManager();
                                    supportFragmentManager.getClass();
                                    if (!supportFragmentManager.isDestroyed() && !supportFragmentManager.isStateSaved()) {
                                        supportFragmentManager.beginTransaction().add(new k9.b(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B).commit();
                                    }
                                    ChoiceCmpCallback callback2 = choiceCmp.getCallback();
                                    if (callback2 == null) {
                                        return wVar;
                                    }
                                    callback2.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.CCPA, z9));
                                    return wVar;
                                }
                            } else if (string.equals("ACTION_SHOW_CMP_DIALOG")) {
                                Bundle extras2 = cmpActivity.getIntent().getExtras();
                                boolean z10 = extras2 != null ? extras2.getBoolean("EXTRA_FORCE", false) : false;
                                d9.i iVarC = i9.a.m().c();
                                if (iVarC.f7512a.length() <= 0 || iVarC.f7513b.length() <= 0 || iVarC.f7514c.length() <= 0 || iVarC.f7515d.length() <= 0) {
                                    ChoiceCmpCallback callback3 = ChoiceCmp.INSTANCE.getCallback();
                                    if (callback3 != null) {
                                        callback3.onCmpError(ChoiceError.MISSING_INIT_SCREEN_TEXTS);
                                    }
                                    cmpActivity.finish();
                                    return wVar;
                                }
                                boolean z11 = j.g.f9878a;
                                cmpActivity.i(b9.d.GDPR, !z10);
                                m6.e eVar2 = new m6.e();
                                String simpleName = m6.e.class.getSimpleName();
                                if (!cmpActivity.isFinishing()) {
                                    FragmentManager supportFragmentManager2 = cmpActivity.getSupportFragmentManager();
                                    supportFragmentManager2.getClass();
                                    if (!supportFragmentManager2.isDestroyed() && !supportFragmentManager2.isStateSaved()) {
                                        eVar2.show(supportFragmentManager2, simpleName);
                                    }
                                }
                                l9.c cVar3 = cmpActivity.f2617a;
                                if (cVar3 == null) {
                                    kotlin.jvm.internal.l.i("viewModel");
                                    throw null;
                                }
                                d0.i iVar = cVar3.f11104a;
                                iVar.q(75, true);
                                if (j.g.f9878a) {
                                    iVar.q(92, true);
                                }
                                ChoiceCmpCallback callback4 = ChoiceCmp.INSTANCE.getCallback();
                                if (callback4 == null) {
                                    return wVar;
                                }
                                callback4.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.VISIBLE, "GDPR screen shown", Regulations.GDPR, z11));
                                return wVar;
                            }
                        } else if (string.equals("ACTION_SHOW_GBC_SCREEN")) {
                            if (cmpActivity.isFinishing()) {
                                return wVar;
                            }
                            ChoiceCmp choiceCmp2 = ChoiceCmp.INSTANCE;
                            if (!choiceCmp2.isViewModelAvailable$app_release()) {
                                ChoiceCmpCallback callback5 = choiceCmp2.getCallback();
                                if (callback5 != null) {
                                    callback5.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                                }
                                cmpActivity.finish();
                                return wVar;
                            }
                            cmpActivity.i(b9.d.NR, false);
                            FragmentManager supportFragmentManager3 = cmpActivity.getSupportFragmentManager();
                            supportFragmentManager3.getClass();
                            if (!supportFragmentManager3.isDestroyed() && !supportFragmentManager3.isStateSaved()) {
                                supportFragmentManager3.beginTransaction().add(new j.b(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B).commit();
                            }
                            ChoiceCmpCallback callback6 = choiceCmp2.getCallback();
                            if (callback6 == null) {
                                return wVar;
                            }
                            callback6.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.VISIBLE, "GBC screen shown", Regulations.NA, true));
                            return wVar;
                        }
                    } else if (string.equals("ACTION_SHOW_US_REGULATION_SCREEN")) {
                        Bundle extras3 = cmpActivity.getIntent().getExtras();
                        boolean z12 = extras3 == null ? false : extras3.getBoolean("EXTRA_FORCE", false);
                        if (cmpActivity.isFinishing()) {
                            return wVar;
                        }
                        ChoiceCmp choiceCmp3 = ChoiceCmp.INSTANCE;
                        if (!choiceCmp3.isViewModelAvailable$app_release()) {
                            ChoiceCmpCallback callback7 = choiceCmp3.getCallback();
                            if (callback7 != null) {
                                callback7.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                            }
                            cmpActivity.finish();
                            return wVar;
                        }
                        boolean z13 = j.g.f9878a;
                        l9.c cVar4 = cmpActivity.f2617a;
                        if (cVar4 == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        if (cVar4.f11106c.f11814b.M && kotlin.jvm.internal.l.a(i9.a.f9113m, DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
                            cmpActivity.i(dVar2, false);
                            FragmentManager supportFragmentManager4 = cmpActivity.getSupportFragmentManager();
                            supportFragmentManager4.getClass();
                            if (!supportFragmentManager4.isDestroyed() && !supportFragmentManager4.isStateSaved()) {
                                supportFragmentManager4.beginTransaction().add(new k9.b(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B).commit();
                            }
                            ChoiceCmpCallback callback8 = choiceCmp3.getCallback();
                            if (callback8 == null) {
                                return wVar;
                            }
                            callback8.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.CCPA, z13));
                            return wVar;
                        }
                        cmpActivity.i(b9.d.MSPA, !z12);
                        FragmentManager supportFragmentManager5 = cmpActivity.getSupportFragmentManager();
                        supportFragmentManager5.getClass();
                        if (!supportFragmentManager5.isDestroyed() && !supportFragmentManager5.isStateSaved()) {
                            supportFragmentManager5.beginTransaction().add(new c6.c(), "c").commit();
                        }
                        ChoiceCmpCallback callback9 = choiceCmp3.getCallback();
                        if (callback9 == null) {
                            return wVar;
                        }
                        callback9.onCMPUIStatusChanged(new DisplayInfo(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.MSPA, z13));
                        return wVar;
                    }
                }
                cmpActivity.finish();
                return wVar;
            case 5:
                int i20 = this.f10574b;
                if (i20 != 0) {
                    if (i20 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                a4.f fVar = ((l9.c) obj2).f11105b;
                this.f10574b = 1;
                ChoiceColor choiceColor = (ChoiceColor) fVar.f218b;
                if (choiceColor != null) {
                    dVar = new d9.d(choiceColor.getDividerColor(), choiceColor.getTabBackgroundColor(), choiceColor.getSearchBarBackgroundColor(), choiceColor.getSearchBarForegroundColor(), choiceColor.getToggleActiveColor(), choiceColor.getToggleInactiveColor(), choiceColor.getGlobalBackgroundColor(), choiceColor.getTitleTextColor(), choiceColor.getBodyTextColor(), choiceColor.getTabTextColor(), choiceColor.getMenuTextColor(), choiceColor.getLinkTextColor(), choiceColor.getButtonTextColor(), choiceColor.getButtonDisabledTextColor(), choiceColor.getButtonBackgroundColor(), choiceColor.getButtonDisabledBackgroundColor());
                } else {
                    ChoiceColor choiceColor2 = (ChoiceColor) fVar.f219c;
                    dVar = choiceColor2 != null ? new d9.d(choiceColor2.getDividerColor(), choiceColor2.getTabBackgroundColor(), choiceColor2.getSearchBarBackgroundColor(), choiceColor2.getSearchBarForegroundColor(), choiceColor2.getToggleActiveColor(), choiceColor2.getToggleInactiveColor(), choiceColor2.getGlobalBackgroundColor(), choiceColor2.getTitleTextColor(), choiceColor2.getBodyTextColor(), choiceColor2.getTabTextColor(), choiceColor2.getMenuTextColor(), choiceColor2.getLinkTextColor(), choiceColor2.getButtonTextColor(), choiceColor2.getButtonDisabledTextColor(), choiceColor2.getButtonBackgroundColor(), choiceColor2.getButtonDisabledBackgroundColor()) : null;
                }
                return dVar == aVar ? aVar : dVar;
            case 6:
                int i21 = this.f10574b;
                if (i21 == 0) {
                    s6.a.e(obj);
                    this.f10574b = 1;
                    y7.e eVar3 = r7.i0.f12407a;
                    return r7.y.z(new c5.g((p2) obj2, null), y7.d.f14116a, this) == aVar ? aVar : wVar;
                }
                if (i21 == 1) {
                    s6.a.e(obj);
                    return wVar;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                int i22 = this.f10574b;
                if (i22 != 0) {
                    if (i22 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.f10574b = 1;
                int i23 = InstallerActivity.f6676m0;
                y7.e eVar4 = r7.i0.f12407a;
                Object objZ2 = r7.y.z(new b.n((InstallerActivity) obj2, cVar, 2), y7.d.f14116a, this);
                if (objZ2 != aVar) {
                    objZ2 = wVar;
                }
                return objZ2 == aVar ? aVar : wVar;
            case 8:
                int i24 = this.f10574b;
                if (i24 != 0) {
                    if (i24 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.f10574b = 1;
                kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                uVar.f10135a = true;
                y7.e eVar5 = r7.i0.f12407a;
                Object objZ3 = r7.y.z(new p4.i0((c1.g1) obj2, uVar, cVar, 6), y7.d.f14116a, this);
                if (objZ3 != aVar) {
                    objZ3 = wVar;
                }
                return objZ3 == aVar ? aVar : wVar;
            case 9:
                int i25 = this.f10574b;
                if (i25 != 0) {
                    if (i25 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.f10574b = 1;
                ArrayList arrayList = new ArrayList();
                y7.e eVar6 = r7.i0.f12407a;
                Object objZ4 = r7.y.z(new p4.i0((TvMyDownloadsFragment) obj2, arrayList, cVar, 10), y7.d.f14116a, this);
                if (objZ4 != aVar) {
                    objZ4 = wVar;
                }
                return objZ4 == aVar ? aVar : wVar;
            case 10:
                int i26 = this.f10574b;
                if (i26 == 0) {
                    s6.a.e(obj);
                    this.f10574b = 1;
                    return TvOldVersionsFragment.b((TvOldVersionsFragment) obj2, this) == aVar ? aVar : wVar;
                }
                if (i26 == 1) {
                    s6.a.e(obj);
                    return wVar;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 11:
                int i27 = this.f10574b;
                if (i27 != 0) {
                    if (i27 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                this.f10574b = 1;
                Object objCollect = ((u7.o) obj2).collect(v7.k.f13194a, this);
                if (objCollect != aVar) {
                    objCollect = wVar;
                }
                return objCollect == aVar ? aVar : wVar;
            default:
                s6.a.e(obj);
                t4.d dVar3 = (t4.d) obj2;
                if (dVar3 == null) {
                    return null;
                }
                dVar3.c(this.f10574b);
                return wVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kb(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10573a = i10;
        this.f10575c = obj;
    }
}
