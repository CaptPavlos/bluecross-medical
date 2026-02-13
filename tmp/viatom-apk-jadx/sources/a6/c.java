package a6;

import a3.x;
import androidx.lifecycle.LiveDataScope;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.ContactUsActivity;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.PasswordRecoveryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.workers.AppInstalledWorker;
import com.uptodown.workers.AppUpdatedWorker;
import com.uptodown.workers.TrackingWorker;
import e5.t1;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f247a;

    /* renamed from: b, reason: collision with root package name */
    public int f248b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f249c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f247a = i10;
        this.f249c = obj;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f247a) {
            case 0:
                return new c((AppInstalledWorker) this.f249c, cVar, 0);
            case 1:
                return new c((AppUpdatedWorker) this.f249c, cVar, 1);
            case 2:
                return new c((TrackingWorker) this.f249c, cVar, 2);
            case 3:
                c cVar2 = new c(2, cVar);
                cVar2.f249c = obj;
                return cVar2;
            case 4:
                return new c((x) this.f249c, cVar, 4);
            case 5:
                return new c((w2.r) this.f249c, cVar, 5);
            case 6:
                return new c((c5.t) this.f249c, cVar, 6);
            case 7:
                return new c((c6.h) this.f249c, cVar, 7);
            case 8:
                return new c((t1) this.f249c, cVar, 8);
            case 9:
                return new c((e6.d) this.f249c, cVar, 9);
            case 10:
                return new c((k6.d) this.f249c, cVar, 10);
            case 11:
                return new c((l.e) this.f249c, cVar, 11);
            case 12:
                return new c((AppDetailActivity) this.f249c, cVar, 12);
            case 13:
                return new c((AppFilesActivity) this.f249c, cVar, 13);
            case 14:
                return new c((w) this.f249c, cVar, 14);
            case 15:
                return new c((ContactUsActivity) this.f249c, cVar, 15);
            case 16:
                return new c((LanguageSettingsActivity) this.f249c, cVar, 16);
            case 17:
                return new c((MyApps) this.f249c, cVar, 17);
            case 18:
                return new c((MyDownloads) this.f249c, cVar, 18);
            case 19:
                return new c((MyStatsActivity) this.f249c, cVar, 19);
            case 20:
                return new c((OldVersionsActivity) this.f249c, cVar, 20);
            case 21:
                return new c((OrganizationActivity) this.f249c, cVar, 21);
            case 22:
                return new c((PasswordEditActivity) this.f249c, cVar, 22);
            case 23:
                return new c((PasswordRecoveryActivity) this.f249c, cVar, 23);
            case 24:
                return new c((PreregistrationActivity) this.f249c, cVar, 24);
            case 25:
                return new c((PublicListActivity) this.f249c, cVar, 25);
            case 26:
                return new c((RollbackActivity) this.f249c, cVar, 26);
            case 27:
                return new c((SearchActivity) this.f249c, cVar, 27);
            case 28:
                return new c((SecurityActivity) this.f249c, cVar, 28);
            default:
                return new c((Updates) this.f249c, cVar, 29);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f247a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                c cVar = new c(2, (w6.c) obj2);
                cVar.f249c = (LiveDataScope) obj;
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 18:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 19:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 20:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 21:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 22:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 23:
                break;
            case 24:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 25:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 26:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 27:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            case 28:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
            default:
                ((c) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
                break;
        }
        return x6.a.f13718a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:312|(2:314|(1:318))(11:320|(2:322|(1:324))|325|(3:327|(2:330|(1:332)(2:333|(1:335)(2:336|(1:338)(2:339|(1:341)))))|342)|343|(1:345)|346|522|347|(1:349)(1:351)|(3:353|516|354))|319|325|(0)|343|(0)|346|522|347|(0)(0)|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:327:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0716 A[Catch: Exception -> 0x071b, TRY_LEAVE, TryCatch #5 {Exception -> 0x071b, blocks: (B:347:0x070c, B:349:0x0716), top: B:522:0x070c }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0a0b  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0a1a A[Catch: Exception -> 0x0a1f, TRY_LEAVE, TryCatch #1 {Exception -> 0x0a1f, blocks: (B:489:0x0a10, B:491:0x0a1a), top: B:514:0x0a10 }] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0a23  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i10, w6.c cVar) {
        super(i10, cVar);
        this.f247a = 3;
    }
}
