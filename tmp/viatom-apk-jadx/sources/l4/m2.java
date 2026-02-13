package l4;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10618a;

    /* renamed from: b, reason: collision with root package name */
    public int f10619b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10620c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m2(MainActivity mainActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10618a = i10;
        this.f10620c = mainActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10618a) {
            case 0:
                return new m2(this.f10620c, cVar, 0);
            case 1:
                return new m2(this.f10620c, cVar, 1);
            case 2:
                return new m2(this.f10620c, cVar, 2);
            case 3:
                return new m2(this.f10620c, cVar, 3);
            case 4:
                return new m2(this.f10620c, cVar, 4);
            case 5:
                return new m2(this.f10620c, cVar, 5);
            default:
                return new m2(this.f10620c, cVar, 6);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10618a) {
        }
        return ((m2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j10;
        int i10 = this.f10618a;
        MainActivity mainActivity = this.f10620c;
        int i11 = 0;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        switch (i10) {
            case 0:
                int i12 = this.f10619b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    MainActivity mainActivity2 = this.f10620c;
                    SharedPreferences sharedPreferences = mainActivity2.getSharedPreferences("SettingsPreferences", 0);
                    try {
                        j10 = sharedPreferences.getLong("getLastTimePendingDialogShown", 0L);
                    } catch (ClassCastException unused) {
                        try {
                            long j11 = sharedPreferences.getInt("getLastTimePendingDialogShown", -1);
                            try {
                                SharedPreferences.Editor editorEdit = mainActivity2.getSharedPreferences("SettingsPreferences", 0).edit();
                                editorEdit.putLong("getLastTimePendingDialogShown", j11);
                                editorEdit.apply();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            j10 = j11;
                        } catch (ClassCastException unused2) {
                            j10 = 0;
                        }
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i13 = MainActivity.B0;
                    v5.g gVarL = v5.g.f13148u.l(mainActivity2);
                    gVarL.a();
                    ArrayList arrayListF = gVarL.F();
                    gVarL.b();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = arrayListF.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        h5.q qVar = (h5.q) next;
                        if (qVar.o() && qVar.f8702c == 0 && qVar.c()) {
                            arrayList.add(qVar);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        j10 = 0;
                    }
                    if (j10 + 86400000 < jCurrentTimeMillis) {
                        ArrayList arrayListZ = com.google.android.gms.internal.measurement.l5.z(mainActivity2);
                        if (!arrayListZ.isEmpty() || !arrayList.isEmpty()) {
                            y7.e eVar = r7.i0.f12407a;
                            s7.c cVar = w7.n.f13548a;
                            c5.m mVar = new c5.m(mainActivity2, arrayListZ, arrayList, null, 8);
                            this.f10619b = 1;
                            if (r7.y.z(mVar, cVar, this) == aVar) {
                            }
                        }
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 1:
                int i14 = this.f10619b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    this.f10619b = 1;
                    int i15 = MainActivity.B0;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ = r7.y.z(new n2(mainActivity, objArr == true ? 1 : 0, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i14 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 2:
                int i16 = this.f10619b;
                if (i16 == 0) {
                    s6.a.e(obj);
                    Context applicationContext = mainActivity.getApplicationContext();
                    applicationContext.getClass();
                    c5.b0 b0Var = new c5.b0(applicationContext, false);
                    this.f10619b = 1;
                    y7.e eVar3 = r7.i0.f12407a;
                    Object objZ2 = r7.y.z(new a6.n(b0Var, objArr2 == true ? 1 : 0, 7), y7.d.f14116a, this);
                    if (objZ2 != aVar) {
                        objZ2 = wVar;
                    }
                    if (objZ2 == aVar) {
                    }
                } else if (i16 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 3:
                int i17 = this.f10619b;
                if (i17 == 0) {
                    s6.a.e(obj);
                    this.f10619b = 1;
                    int i18 = MainActivity.B0;
                    y7.e eVar4 = r7.i0.f12407a;
                    Object objZ3 = r7.y.z(new n2(mainActivity, objArr3 == true ? 1 : 0, i11), y7.d.f14116a, this);
                    if (objZ3 != aVar) {
                        objZ3 = wVar;
                    }
                    if (objZ3 == aVar) {
                    }
                } else if (i17 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 4:
                int i19 = this.f10619b;
                if (i19 == 0) {
                    ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                    ArrayList arrayListD = r0.f.D(mainActivity);
                    v5.g gVarL2 = v5.g.f13148u.l(mainActivity);
                    gVarL2.a();
                    ArrayList arrayListV = gVarL2.v();
                    Iterator it2 = arrayListD.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        File file = (File) next2;
                        Iterator it3 = arrayListV.iterator();
                        it3.getClass();
                        Object[] objArr6 = false;
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            next3.getClass();
                            if (((h5.l) next3).b().equalsIgnoreCase(file.getAbsolutePath())) {
                                objArr6 = true;
                            }
                        }
                        if (objArr6 == false) {
                            String name = file.getName();
                            name.getClass();
                            String strC = r0.f.C(name);
                            if (strC != null && strC.length() != 0) {
                                arrayListA.add(file);
                                String absolutePath = file.getAbsolutePath();
                                absolutePath.getClass();
                                String strValueOf = String.valueOf(file.lastModified());
                                strValueOf.getClass();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, absolutePath);
                                contentValues.put("date", strValueOf);
                                SQLiteDatabase sQLiteDatabase = gVarL2.f13150a;
                                sQLiteDatabase.getClass();
                                sQLiteDatabase.insert("deep_link_files", null, contentValues);
                                file.delete();
                            }
                        }
                    }
                    gVarL2.b();
                    if (!arrayListA.isEmpty() && !mainActivity.isFinishing()) {
                        y7.e eVar5 = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        a6.j jVar = new a6.j((Object) mainActivity, (Object) arrayListA, (w6.c) (objArr4 == true ? 1 : 0), 26);
                        this.f10619b = 1;
                        if (r7.y.z(jVar, cVar2, this) == aVar) {
                        }
                    }
                } else if (i19 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 5:
                int i20 = this.f10619b;
                if (i20 == 0) {
                    s6.a.e(obj);
                    MainActivity mainActivity3 = this.f10620c;
                    if (mainActivity3.getApplicationContext() != null) {
                        Context applicationContext2 = mainActivity3.getApplicationContext();
                        applicationContext2.getClass();
                        int size = com.google.android.gms.internal.measurement.l5.z(applicationContext2).size();
                        Context applicationContext3 = mainActivity3.getApplicationContext();
                        applicationContext3.getClass();
                        v5.g gVarL3 = v5.g.f13148u.l(applicationContext3);
                        gVarL3.a();
                        ArrayList arrayListF2 = gVarL3.F();
                        gVarL3.b();
                        Iterator it4 = arrayListF2.iterator();
                        it4.getClass();
                        int i21 = 0;
                        while (it4.hasNext()) {
                            Object next4 = it4.next();
                            next4.getClass();
                            h5.q qVar2 = (h5.q) next4;
                            if (qVar2.o() && qVar2.f8702c == 0 && qVar2.c()) {
                                i21++;
                            }
                        }
                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                        xVar.f10138a = ContextCompat.getDrawable(mainActivity3, R.drawable.vector_user_profile);
                        h5.e1 e1VarH = h5.c1.h(mainActivity3);
                        if (e1VarH != null) {
                            String str = e1VarH.f8514c;
                            String strO = str != null ? a3.a.o(a3.a.v(str), UptodownApp.N, ":webp") : null;
                            if (strO != null && strO.length() != 0) {
                                try {
                                    j4.d0 d0VarE = j4.y.d().e(h5.c1.e(e1VarH.f8514c));
                                    float f = UptodownApp.E;
                                    d0VarE.g(k4.c.y(mainActivity3));
                                    Bitmap bitmapC = d0VarE.c();
                                    bitmapC.getClass();
                                    Resources resources = mainActivity3.getResources();
                                    resources.getClass();
                                    xVar.f10138a = new BitmapDrawable(resources, bitmapC);
                                } catch (IOException unused3) {
                                }
                            }
                        }
                        y7.e eVar6 = r7.i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        w2 w2Var = new w2(mainActivity3, xVar, i21, size, null);
                        this.f10619b = 1;
                        if (r7.y.z(w2Var, cVar3, this) == aVar) {
                        }
                    }
                } else if (i20 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i22 = this.f10619b;
                if (i22 == 0) {
                    s6.a.e(obj);
                    this.f10619b = 1;
                    if (r7.y.h(1000L, this) == aVar) {
                    }
                } else if (i22 == 1) {
                    s6.a.e(obj);
                } else if (i22 != 2) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                this.f10619b = 2;
                int i23 = MainActivity.B0;
                y7.e eVar7 = r7.i0.f12407a;
                Object objZ4 = r7.y.z(new m2(mainActivity, objArr5 == true ? 1 : 0, 5), y7.d.f14116a, this);
                if (objZ4 != aVar) {
                    objZ4 = wVar;
                }
                if (objZ4 == aVar) {
                }
                break;
        }
        return wVar;
    }
}
