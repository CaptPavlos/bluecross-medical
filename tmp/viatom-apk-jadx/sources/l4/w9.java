package l4;

import com.uptodown.activities.Updates;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w9 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f10961a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f10962b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f10963c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f10964d;
    public ArrayList e;
    public int f;
    public boolean g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f10965i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y9 f10966j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Updates f10967k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w9(boolean z9, y9 y9Var, Updates updates, w6.c cVar) {
        super(2, cVar);
        this.f10965i = z9;
        this.f10966j = y9Var;
        this.f10967k = updates;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new w9(this.f10965i, this.f10966j, this.f10967k, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((w9) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Updates updates;
        ArrayList arrayList;
        ArrayList arrayList2;
        int iIndexOf;
        Object objB;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        Updates updates2;
        int applicationEnabledSetting;
        boolean zBooleanValue;
        Object objA;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        y9 y9Var = this.f10966j;
        u7.m0 m0Var = y9Var.f11047a;
        int i10 = this.h;
        Updates updates3 = this.f10967k;
        int i11 = 1;
        x6.a aVar = x6.a.f13718a;
        if (i10 == 0) {
            s6.a.e(obj);
            if (this.f10965i) {
                m0Var.getClass();
                m0Var.g(null, v5.j.f13166a);
            }
            ArrayList arrayListI = v5.a.i(updates3);
            v5.g gVarL = v5.g.f13148u.l(updates3);
            gVarL.a();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            ArrayList arrayList12 = new ArrayList();
            Iterator it = arrayListI.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                h5.f fVar = (h5.f) next;
                x6.a aVar2 = aVar;
                if (fVar.f8541w <= 0 || !fVar.b(updates3)) {
                    aVar = aVar2;
                } else {
                    int i12 = fVar.f8532m;
                    h5.e eVar = h5.e.f8506a;
                    if (i12 == i11) {
                        fVar.g = eVar;
                        arrayList11.add(fVar);
                        aVar = aVar2;
                    } else {
                        String str = fVar.f8526c;
                        str.getClass();
                        h5.y0 y0VarM = gVarL.M(str);
                        if (y0VarM == null) {
                            updates2 = updates3;
                            long j10 = fVar.f8534o;
                            long j11 = fVar.f8537r;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (j11 != j10 && jCurrentTimeMillis - j10 < 604800000) {
                                fVar.g = h5.e.f8507b;
                                arrayList12.add(fVar);
                            }
                        } else {
                            updates2 = updates3;
                            if (y0VarM.f == 1) {
                                arrayList11.add(fVar);
                            } else {
                                fVar.g = eVar;
                                String str2 = fVar.f8526c;
                                str2.getClass();
                                try {
                                    applicationEnabledSetting = updates2.getPackageManager().getApplicationEnabledSetting(str2);
                                } catch (Error e) {
                                    e.printStackTrace();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                                    arrayList10.add(fVar);
                                } else if (y0VarM.f == 0) {
                                    arrayList9.add(fVar);
                                }
                            }
                        }
                        if (y0VarM != null && y0VarM.e == 0) {
                            y0VarM.e = 1;
                            gVarL.c0(y0VarM);
                        }
                        aVar = aVar2;
                        updates3 = updates2;
                        i11 = 1;
                    }
                }
            }
            updates = updates3;
            x6.a aVar3 = aVar;
            com.google.android.gms.internal.measurement.l5.J(arrayList9, updates);
            t6.q.W(arrayList12, new com.google.android.material.button.a(new e5.u0(8), 6));
            com.google.android.gms.internal.measurement.l5.J(arrayList11, updates);
            com.google.android.gms.internal.measurement.l5.J(arrayList10, updates);
            ArrayList arrayListO = gVarL.O();
            gVarL.b();
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            int size = arrayListO.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj2 = arrayListO.get(i13);
                i13++;
                h5.y0 y0Var = (h5.y0) obj2;
                int size2 = arrayList9.size();
                int i14 = 0;
                while (i14 < size2) {
                    Object obj3 = arrayList9.get(i14);
                    int i15 = i14 + 1;
                    int i16 = size;
                    h5.f fVar2 = (h5.f) obj3;
                    int i17 = i13;
                    if (kotlin.jvm.internal.l.a(y0Var.f8795b, fVar2.f8526c)) {
                        arrayList2.add(y0Var);
                        arrayList.add(new n4.u0(fVar2, y0Var));
                    }
                    i14 = i15;
                    size = i16;
                    i13 = i17;
                }
            }
            if (arrayList.size() > 1) {
                t6.q.W(arrayList, new a9.i(12));
            }
            Iterator it2 = arrayList.iterator();
            it2.getClass();
            while (true) {
                if (!it2.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next2 = it2.next();
                next2.getClass();
                n4.u0 u0Var = (n4.u0) next2;
                if (kotlin.jvm.internal.l.a(u0Var.f11493a.f8526c, updates.getPackageName())) {
                    iIndexOf = arrayList.indexOf(u0Var);
                    break;
                }
            }
            if (iIndexOf > 0) {
                arrayList.add(0, arrayList.remove(iIndexOf));
            }
            this.f10961a = arrayList10;
            this.f10962b = arrayList11;
            this.f10963c = arrayList12;
            this.f10964d = arrayList;
            this.e = arrayList2;
            this.f = iIndexOf;
            this.h = 1;
            objB = y9.b(y9Var, arrayListO, arrayList9, this);
            aVar = aVar3;
            if (objB != aVar) {
                arrayList3 = arrayList10;
                arrayList4 = arrayList11;
                arrayList5 = arrayList12;
            }
            return aVar;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            zBooleanValue = this.g;
            ArrayList arrayList13 = this.f10964d;
            ArrayList arrayList14 = this.f10963c;
            ArrayList arrayList15 = this.f10962b;
            arrayList8 = this.f10961a;
            s6.a.e(obj);
            arrayList6 = arrayList14;
            arrayList7 = arrayList15;
            arrayList = arrayList13;
            objA = obj;
            v5.l lVar = new v5.l(new u9(arrayList, arrayList8, arrayList7, arrayList6, new t9(zBooleanValue, ((Boolean) objA).booleanValue())));
            m0Var.getClass();
            m0Var.g(null, lVar);
            return s6.w.f12711a;
        }
        int i18 = this.f;
        arrayList2 = this.e;
        ArrayList arrayList16 = this.f10964d;
        arrayList5 = this.f10963c;
        arrayList4 = this.f10962b;
        arrayList3 = this.f10961a;
        s6.a.e(obj);
        iIndexOf = i18;
        updates = updates3;
        arrayList = arrayList16;
        objB = obj;
        zBooleanValue = ((Boolean) objB).booleanValue();
        this.f10961a = arrayList3;
        this.f10962b = arrayList4;
        this.f10963c = arrayList5;
        this.f10964d = arrayList;
        this.e = null;
        this.f = iIndexOf;
        this.g = zBooleanValue;
        this.h = 2;
        objA = y9.a(y9Var, updates, arrayList2, zBooleanValue, this);
        if (objA != aVar) {
            arrayList6 = arrayList5;
            arrayList7 = arrayList4;
            arrayList8 = arrayList3;
            v5.l lVar2 = new v5.l(new u9(arrayList, arrayList8, arrayList7, arrayList6, new t9(zBooleanValue, ((Boolean) objA).booleanValue())));
            m0Var.getClass();
            m0Var.g(null, lVar2);
            return s6.w.f12711a;
        }
        return aVar;
    }
}
