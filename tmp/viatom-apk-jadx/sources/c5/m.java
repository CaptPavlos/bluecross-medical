package c5;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import c1.w4;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import e5.c1;
import h5.h1;
import h5.o0;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import l4.bc;
import l4.ib;
import l4.k5;
import l4.k8;
import l4.p2;
import l4.p4;
import l4.pa;
import l4.q4;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1724b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1725c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ArrayList arrayList, w4 w4Var, p2 p2Var, w6.c cVar) {
        super(2, cVar);
        this.f1723a = 20;
        this.f1724b = arrayList;
        this.f1726d = w4Var;
        this.f1725c = p2Var;
    }

    private final Object a(Object obj) {
        ApplicationInfo applicationInfoB;
        ArrayList arrayListT;
        v5.g gVar = (v5.g) this.f1726d;
        s6.a.e(obj);
        h5.f fVar = (h5.f) this.f1724b;
        if (fVar.f8535p == 0) {
            try {
                PackageManager packageManager = (PackageManager) this.f1725c;
                String str = fVar.f8526c;
                str.getClass();
                applicationInfoB = l5.a.b(packageManager, str, 128);
            } catch (PackageManager.NameNotFoundException unused) {
                applicationInfoB = null;
            }
            if (fVar.f8538s == null && fVar.f8535p == 0) {
                if (applicationInfoB != null) {
                    fVar.f8538s = l5.y(applicationInfoB.sourceDir);
                }
                if (fVar.f8538s != null) {
                    gVar.getClass();
                    ContentValues contentValues = new ContentValues();
                    String str2 = fVar.f8538s;
                    if (str2 != null) {
                        contentValues.put("sha256", str2);
                    }
                    String[] strArr = {fVar.f8526c};
                    SQLiteDatabase sQLiteDatabase = gVar.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.update("apps", contentValues, "packagename=?", strArr);
                } else {
                    fVar.f8535p = 1;
                    gVar.b0(fVar);
                }
            }
        }
        if (fVar.f8535p == 0 && (arrayListT = gVar.t(fVar)) != null) {
            Iterator it = arrayListT.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                h5.w wVar = (h5.w) next;
                String str3 = wVar.f8783c;
                if (str3 != null && wVar.f8781a == null) {
                    wVar.f8781a = l5.y(str3);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("sha256", wVar.f8781a);
                    String[] strArr2 = {wVar.f8783c};
                    SQLiteDatabase sQLiteDatabase2 = gVar.f13150a;
                    sQLiteDatabase2.getClass();
                    sQLiteDatabase2.update("app_files", contentValues2, "path=?", strArr2);
                }
            }
        }
        return s6.w.f12711a;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1723a) {
            case 0:
                return new m((t) this.f1724b, (kotlin.jvm.internal.x) this.f1725c, (w4) this.f1726d, cVar, 0);
            case 1:
                return new m((g5.w) this.f1724b, (ArrayList) this.f1725c, (kotlin.jvm.internal.v) this.f1726d, cVar, 1);
            case 2:
                return new m((Context) this.f1724b, (h5.h) this.f1725c, (c1) this.f1726d, cVar, 2);
            case 3:
                return new m((Activity) this.f1724b, (String) this.f1725c, (String) this.f1726d, cVar, 3);
            case 4:
                return new m((AppInstalledDetailsActivity) this.f1724b, (y0) this.f1725c, (h5.q) this.f1726d, cVar, 4);
            case 5:
                return new m((kotlin.jvm.internal.x) this.f1725c, (File) this.f1724b, (l4.w) this.f1726d, cVar);
            case 6:
                return new m((l4.w) this.f1724b, (o0) this.f1725c, (g7.a) this.f1726d, cVar, 6);
            case 7:
                return new m((FreeUpSpaceActivity) this.f1724b, (String) this.f1725c, (String) this.f1726d, cVar, 7);
            case 8:
                return new m((MainActivity) this.f1724b, (ArrayList) this.f1725c, (ArrayList) this.f1726d, cVar, 8);
            case 9:
                return new m((MyApps) this.f1724b, (String) this.f1725c, (String) this.f1726d, cVar, 9);
            case 10:
                return new m((q4) this.f1724b, (String) this.f1725c, (p4) this.f1726d, cVar, 10);
            case 11:
                return new m((Context) this.f1724b, (h5.b0) this.f1725c, (String) this.f1726d, cVar, 11);
            case 12:
                return new m((k5) this.f1724b, (String) this.f1725c, (Context) this.f1726d, cVar, 12);
            case 13:
                return new m((ReviewsActivity) this.f1724b, (String) this.f1725c, (k8) this.f1726d, cVar, 13);
            case 14:
                return new m((String) this.f1724b, (Updates) this.f1725c, (String) this.f1726d, cVar, 14);
            case 15:
                return new m((Updates) this.f1724b, (Boolean) this.f1725c, (Integer) this.f1726d, cVar, 15);
            case 16:
                return new m((ArrayList) this.f1724b, (ArrayList) this.f1725c, (ArrayList) this.f1726d, cVar, 16);
            case 17:
                return new m((pa) this.f1724b, (Context) this.f1725c, (h5.j) this.f1726d, cVar, 17);
            case 18:
                return new m((UserDeviceDetailsActivity) this.f1724b, (h1) this.f1725c, (ib) this.f1726d, cVar, 18);
            case 19:
                return new m((UsernameEditActivity) this.f1724b, (ArrayList) this.f1725c, (bc) this.f1726d, cVar, 19);
            case 20:
                return new m((ArrayList) this.f1724b, (w4) this.f1726d, (p2) this.f1725c, cVar);
            case 21:
                return new m((TvSearchFragment) this.f1724b, (String) this.f1725c, (ArrayList) this.f1726d, cVar, 21);
            case 22:
                return new m((h5.f) this.f1724b, (PackageManager) this.f1725c, (v5.g) this.f1726d, cVar, 22);
            case 23:
                return new m((Context) this.f1724b, (String) this.f1725c, (g7.a) this.f1726d, cVar, 23);
            case 24:
                return new m((t4.d) this.f1724b, (File) this.f1725c, (ArrayList) this.f1726d, cVar, 24);
            default:
                return new m((kotlin.jvm.internal.u) this.f1724b, (kotlin.jvm.internal.u) this.f1725c, (t4.d) this.f1726d, cVar, 25);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1723a) {
            case 0:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 1:
                m mVar = (m) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                mVar.invokeSuspend(wVar2);
                return wVar2;
            case 2:
                m mVar2 = (m) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                mVar2.invokeSuspend(wVar3);
                return wVar3;
            case 3:
                m mVar3 = (m) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                mVar3.invokeSuspend(wVar4);
                return wVar4;
            case 4:
                m mVar4 = (m) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                mVar4.invokeSuspend(wVar5);
                return wVar5;
            case 5:
                m mVar5 = (m) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                mVar5.invokeSuspend(wVar6);
                return wVar6;
            case 6:
                m mVar6 = (m) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                mVar6.invokeSuspend(wVar7);
                return wVar7;
            case 7:
                m mVar7 = (m) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                mVar7.invokeSuspend(wVar8);
                return wVar8;
            case 8:
                m mVar8 = (m) create(wVar, cVar);
                s6.w wVar9 = s6.w.f12711a;
                mVar8.invokeSuspend(wVar9);
                return wVar9;
            case 9:
                m mVar9 = (m) create(wVar, cVar);
                s6.w wVar10 = s6.w.f12711a;
                mVar9.invokeSuspend(wVar10);
                return wVar10;
            case 10:
                m mVar10 = (m) create(wVar, cVar);
                s6.w wVar11 = s6.w.f12711a;
                mVar10.invokeSuspend(wVar11);
                return wVar11;
            case 11:
                m mVar11 = (m) create(wVar, cVar);
                s6.w wVar12 = s6.w.f12711a;
                mVar11.invokeSuspend(wVar12);
                return wVar12;
            case 12:
                m mVar12 = (m) create(wVar, cVar);
                s6.w wVar13 = s6.w.f12711a;
                mVar12.invokeSuspend(wVar13);
                return wVar13;
            case 13:
                m mVar13 = (m) create(wVar, cVar);
                s6.w wVar14 = s6.w.f12711a;
                mVar13.invokeSuspend(wVar14);
                return wVar14;
            case 14:
                m mVar14 = (m) create(wVar, cVar);
                s6.w wVar15 = s6.w.f12711a;
                mVar14.invokeSuspend(wVar15);
                return wVar15;
            case 15:
                m mVar15 = (m) create(wVar, cVar);
                s6.w wVar16 = s6.w.f12711a;
                mVar15.invokeSuspend(wVar16);
                return wVar16;
            case 16:
                m mVar16 = (m) create(wVar, cVar);
                s6.w wVar17 = s6.w.f12711a;
                mVar16.invokeSuspend(wVar17);
                return wVar17;
            case 17:
                m mVar17 = (m) create(wVar, cVar);
                s6.w wVar18 = s6.w.f12711a;
                mVar17.invokeSuspend(wVar18);
                return wVar18;
            case 18:
                m mVar18 = (m) create(wVar, cVar);
                s6.w wVar19 = s6.w.f12711a;
                mVar18.invokeSuspend(wVar19);
                return wVar19;
            case 19:
                m mVar19 = (m) create(wVar, cVar);
                s6.w wVar20 = s6.w.f12711a;
                mVar19.invokeSuspend(wVar20);
                return wVar20;
            case 20:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 21:
                m mVar20 = (m) create(wVar, cVar);
                s6.w wVar21 = s6.w.f12711a;
                mVar20.invokeSuspend(wVar21);
                return wVar21;
            case 22:
                m mVar21 = (m) create(wVar, cVar);
                s6.w wVar22 = s6.w.f12711a;
                mVar21.invokeSuspend(wVar22);
                return wVar22;
            case 23:
                m mVar22 = (m) create(wVar, cVar);
                s6.w wVar23 = s6.w.f12711a;
                mVar22.invokeSuspend(wVar23);
                return wVar23;
            case 24:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                m mVar23 = (m) create(wVar, cVar);
                s6.w wVar24 = s6.w.f12711a;
                mVar23.invokeSuspend(wVar24);
                return wVar24;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:234:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011a  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 3276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, Object obj2, Object obj3, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1723a = i10;
        this.f1724b = obj;
        this.f1725c = obj2;
        this.f1726d = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(kotlin.jvm.internal.x xVar, File file, l4.w wVar, w6.c cVar) {
        super(2, cVar);
        this.f1723a = 5;
        this.f1725c = xVar;
        this.f1724b = file;
        this.f1726d = wVar;
    }
}
