package a6;

import a3.x;
import android.content.BroadcastReceiver;
import c1.w4;
import c5.b0;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.workers.MyAppUpdatedWorker;
import com.uptodown.workers.PreRegisterWorker;
import d5.x0;
import l4.b2;
import l4.d6;
import l4.n5;
import org.json.JSONException;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f274a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f275b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, w6.c cVar, int i10) {
        super(2, cVar);
        this.f274a = i10;
        this.f275b = obj;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f274a) {
            case 0:
                return new n((MyAppUpdatedWorker) this.f275b, cVar, 0);
            case 1:
                return new n((PreRegisterWorker) this.f275b, cVar, 1);
            case 2:
                return new n((x) this.f275b, cVar, 2);
            case 3:
                return new n((c5.t) this.f275b, cVar, 3);
            case 4:
                return new n((e0.n) this.f275b, cVar, 4);
            case 5:
                return new n((w2.r) this.f275b, cVar, 5);
            case 6:
                return new n((g5.q) this.f275b, cVar, 6);
            case 7:
                return new n((b0) this.f275b, cVar, 7);
            case 8:
                return new n((n5) this.f275b, cVar, 8);
            case 9:
                return new n((b0) this.f275b, cVar, 9);
            case 10:
                return new n((w4) this.f275b, cVar, 10);
            case 11:
                return new n((x) this.f275b, cVar, 11);
            case 12:
                return new n((n5) this.f275b, cVar, 12);
            case 13:
                n nVar = new n(2, cVar);
                nVar.f275b = obj;
                return nVar;
            case 14:
                return new n((d3.g) this.f275b, cVar, 14);
            case 15:
                return new n((BroadcastReceiver.PendingResult) this.f275b, cVar, 15);
            case 16:
                return new n((UptodownApp) this.f275b, cVar, 16);
            case 17:
                return new n((AppFilesActivity) this.f275b, cVar, 17);
            case 18:
                return new n((FreeUpSpaceActivity) this.f275b, cVar, 18);
            case 19:
                return new n((b2) this.f275b, cVar, 19);
            case 20:
                return new n((d6) this.f275b, cVar, 20);
            case 21:
                return new n((x0) this.f275b, cVar, 21);
            case 22:
                return new n((UserAvatarActivity) this.f275b, cVar, 22);
            case 23:
                return new n((ConfirmationIntentWrapperActivity) this.f275b, cVar, 23);
            case 24:
                return new n((InstallerActivity) this.f275b, cVar, 24);
            default:
                return new n((b9.h) this.f275b, cVar, 25);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        switch (this.f274a) {
            case 0:
                n nVar = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar = s6.w.f12711a;
                nVar.invokeSuspend(wVar);
                return wVar;
            case 1:
                n nVar2 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar2 = s6.w.f12711a;
                nVar2.invokeSuspend(wVar2);
                return wVar2;
            case 2:
                n nVar3 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar3 = s6.w.f12711a;
                nVar3.invokeSuspend(wVar3);
                return wVar3;
            case 3:
                n nVar4 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar4 = s6.w.f12711a;
                nVar4.invokeSuspend(wVar4);
                return wVar4;
            case 4:
                n nVar5 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar5 = s6.w.f12711a;
                nVar5.invokeSuspend(wVar5);
                return wVar5;
            case 5:
                n nVar6 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar6 = s6.w.f12711a;
                nVar6.invokeSuspend(wVar6);
                return wVar6;
            case 6:
                n nVar7 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar7 = s6.w.f12711a;
                nVar7.invokeSuspend(wVar7);
                return wVar7;
            case 7:
                n nVar8 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar8 = s6.w.f12711a;
                nVar8.invokeSuspend(wVar8);
                return wVar8;
            case 8:
                n nVar9 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar9 = s6.w.f12711a;
                nVar9.invokeSuspend(wVar9);
                return wVar9;
            case 9:
                n nVar10 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar10 = s6.w.f12711a;
                nVar10.invokeSuspend(wVar10);
                return wVar10;
            case 10:
                n nVar11 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar11 = s6.w.f12711a;
                nVar11.invokeSuspend(wVar11);
                return wVar11;
            case 11:
                n nVar12 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar12 = s6.w.f12711a;
                nVar12.invokeSuspend(wVar12);
                return wVar12;
            case 12:
                n nVar13 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar13 = s6.w.f12711a;
                nVar13.invokeSuspend(wVar13);
                return wVar13;
            case 13:
                n nVar14 = (n) create((String) obj, (w6.c) obj2);
                s6.w wVar14 = s6.w.f12711a;
                nVar14.invokeSuspend(wVar14);
                return wVar14;
            case 14:
                return ((n) create((d3.g) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
            case 15:
                n nVar15 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar15 = s6.w.f12711a;
                nVar15.invokeSuspend(wVar15);
                return wVar15;
            case 16:
                n nVar16 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar16 = s6.w.f12711a;
                nVar16.invokeSuspend(wVar16);
                return wVar16;
            case 17:
                n nVar17 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar17 = s6.w.f12711a;
                nVar17.invokeSuspend(wVar17);
                return wVar17;
            case 18:
                n nVar18 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar18 = s6.w.f12711a;
                nVar18.invokeSuspend(wVar18);
                return wVar18;
            case 19:
                n nVar19 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar19 = s6.w.f12711a;
                nVar19.invokeSuspend(wVar19);
                return wVar19;
            case 20:
                n nVar20 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar20 = s6.w.f12711a;
                nVar20.invokeSuspend(wVar20);
                return wVar20;
            case 21:
                n nVar21 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar21 = s6.w.f12711a;
                nVar21.invokeSuspend(wVar21);
                return wVar21;
            case 22:
                n nVar22 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar22 = s6.w.f12711a;
                nVar22.invokeSuspend(wVar22);
                return wVar22;
            case 23:
                n nVar23 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar23 = s6.w.f12711a;
                nVar23.invokeSuspend(wVar23);
                return wVar23;
            case 24:
                n nVar24 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar24 = s6.w.f12711a;
                nVar24.invokeSuspend(wVar24);
                return wVar24;
            default:
                n nVar25 = (n) create((w) obj, (w6.c) obj2);
                s6.w wVar25 = s6.w.f12711a;
                nVar25.invokeSuspend(wVar25);
                return wVar25;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x03e9 A[Catch: Exception -> 0x03fe, TryCatch #2 {Exception -> 0x03fe, blocks: (B:142:0x03e3, B:144:0x03e9, B:145:0x03f0, B:147:0x03f6, B:150:0x0400), top: B:314:0x03e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x07be  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i10, w6.c cVar) {
        super(i10, cVar);
        this.f274a = 13;
    }
}
