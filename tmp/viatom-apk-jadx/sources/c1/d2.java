package c1;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d2 extends com.google.android.gms.internal.measurement.y implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final v4 f1108a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f1109b;

    /* renamed from: k, reason: collision with root package name */
    public String f1110k;

    public d2(v4 v4Var) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        i0.y.g(v4Var);
        this.f1108a = v4Var;
        this.f1110k = null;
    }

    @Override // c1.i0
    public final void A(d5 d5Var, d dVar) {
        d(d5Var);
        H(new y1((Object) this, d5Var, (Object) dVar, 4));
    }

    @Override // c1.i0
    public final void C(d5 d5Var) {
        d(d5Var);
        H(new w1(this, d5Var, 0));
    }

    @Override // c1.i0
    public final i D(d5 d5Var) {
        d(d5Var);
        String str = d5Var.f1114a;
        i0.y.d(str);
        v4 v4Var = this.f1108a;
        try {
            return (i) v4Var.b().o(new v1(this, d5Var, 1)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            v4Var.a().f.d(w0.o(str), "Failed to get consent. appId", e);
            return new i(null);
        }
    }

    @Override // c1.i0
    public final byte[] F(v vVar, String str) {
        i0.y.d(str);
        i0.y.g(vVar);
        G(str, true);
        v4 v4Var = this.f1108a;
        u0 u0Var = v4Var.a().f1544m;
        u1 u1Var = v4Var.f1525l;
        q0 q0Var = u1Var.f1480j;
        String str2 = vVar.f1505a;
        u0Var.c(q0Var.a(str2), "Log and bundle. event");
        v4Var.f().getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) v4Var.b().o(new m1(this, vVar, str)).get();
            if (bArr == null) {
                v4Var.a().f.c(w0.o(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            v4Var.f().getClass();
            v4Var.a().f1544m.e("Log and bundle processed. event, size, time_ms", u1Var.f1480j.a(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            v4Var.a().f.e("Failed to log and bundle. appId, event, error", w0.o(str), u1Var.f1480j.a(str2), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            v4Var.a().f.e("Failed to log and bundle. appId, event, error", w0.o(str), u1Var.f1480j.a(str2), e);
            return null;
        }
    }

    public final void G(String str, boolean z9) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        v4 v4Var = this.f1108a;
        if (zIsEmpty) {
            v4Var.a().f.b("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z9) {
            try {
                if (this.f1109b == null) {
                    boolean z10 = true;
                    if (!"com.google.android.gms".equals(this.f1110k) && !n0.b.b(v4Var.f1525l.f1475a, Binder.getCallingUid()) && !f0.h.a(v4Var.f1525l.f1475a).b(Binder.getCallingUid())) {
                        z10 = false;
                    }
                    this.f1109b = Boolean.valueOf(z10);
                }
                if (this.f1109b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                v4Var.a().f.c(w0.o(str), "Measurement Service called with invalid calling package. appId");
                throw e;
            }
        }
        if (this.f1110k == null) {
            Context context = v4Var.f1525l.f1475a;
            int callingUid = Binder.getCallingUid();
            int i10 = f0.g.e;
            if (n0.b.d(context, callingUid, str)) {
                this.f1110k = str;
            }
        }
        if (str.equals(this.f1110k)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    public final void H(Runnable runnable) {
        v4 v4Var = this.f1108a;
        if (v4Var.b().m()) {
            runnable.run();
        } else {
            v4Var.b().p(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        boolean z9;
        List list;
        v4 v4Var = this.f1108a;
        ArrayList arrayList = null;
        k0 j0Var = null;
        m0 l0Var = null;
        switch (i10) {
            case 1:
                v vVar = (v) com.google.android.gms.internal.measurement.z.a(parcel, v.CREATOR);
                d5 d5Var = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                o(vVar, d5Var);
                parcel2.writeNoException();
                return true;
            case 2:
                y4 y4Var = (y4) com.google.android.gms.internal.measurement.z.a(parcel, y4.CREATOR);
                d5 d5Var2 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                y(y4Var, d5Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                d5 d5Var3 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                C(d5Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                v vVar2 = (v) com.google.android.gms.internal.measurement.z.a(parcel, v.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                i0.y.g(vVar2);
                i0.y.d(string);
                G(string, true);
                H(new y1(this, vVar2, string, 2));
                parcel2.writeNoException();
                return true;
            case 6:
                d5 d5Var4 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                g(d5Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                d5 d5Var5 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                Object[] objArr = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.z.d(parcel);
                d(d5Var5);
                String str = d5Var5.f1114a;
                i0.y.g(str);
                try {
                    List<z4> list2 = (List) v4Var.b().n(new v1(this, str, 0)).get();
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (z4 z4Var : list2) {
                        if (objArr != false || !b5.F(z4Var.f1631c)) {
                            arrayList2.add(new y4(z4Var));
                        }
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e) {
                    e = e;
                    v4Var.a().f.d(w0.o(str), "Failed to get user properties. appId", e);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                } catch (ExecutionException e3) {
                    e = e3;
                    v4Var.a().f.d(w0.o(str), "Failed to get user properties. appId", e);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                v vVar3 = (v) com.google.android.gms.internal.measurement.z.a(parcel, v.CREATOR);
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                byte[] bArrF = F(vVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrF);
                return true;
            case 10:
                long j10 = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                k(j10, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                d5 d5Var6 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                String strR = r(d5Var6);
                parcel2.writeNoException();
                parcel2.writeString(strR);
                return true;
            case 12:
                e eVar = (e) com.google.android.gms.internal.measurement.z.a(parcel, e.CREATOR);
                d5 d5Var7 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                q(eVar, d5Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                e eVar2 = (e) com.google.android.gms.internal.measurement.z.a(parcel, e.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                i0.y.g(eVar2);
                i0.y.g(eVar2.f1136c);
                i0.y.d(eVar2.f1134a);
                G(eVar2.f1134a, true);
                H(new k1.a(this, new e(eVar2), 4, false));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2275a;
                z9 = parcel.readInt() != 0;
                d5 d5Var8 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                List listI = i(string6, string7, z9, d5Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listI);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = com.google.android.gms.internal.measurement.z.f2275a;
                z9 = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.z.d(parcel);
                List listF = f(string8, string9, string10, z9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listF);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                d5 d5Var9 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                List listS = s(string11, string12, d5Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listS);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                List listM = m(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listM);
                return true;
            case 18:
                d5 d5Var10 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                p(d5Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                d5 d5Var11 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                x(bundle, d5Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                d5 d5Var12 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                t(d5Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                d5 d5Var13 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                i iVarD = D(d5Var13);
                parcel2.writeNoException();
                if (iVarD == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                iVarD.writeToParcel(parcel2, 1);
                return true;
            case 24:
                d5 d5Var14 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                d(d5Var14);
                String str2 = d5Var14.f1114a;
                i0.y.g(str2);
                if (v4Var.e0().q(null, f0.Z0)) {
                    try {
                        list = (List) v4Var.b().o(new a2(this, d5Var14, bundle2, 0)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e7) {
                        v4Var.a().f.d(w0.o(str2), "Failed to get trigger URIs. appId", e7);
                        list = Collections.EMPTY_LIST;
                    }
                } else {
                    try {
                        list = (List) v4Var.b().n(new a2(this, d5Var14, bundle2, 1)).get();
                    } catch (InterruptedException | ExecutionException e10) {
                        v4Var.a().f.d(w0.o(str2), "Failed to get trigger URIs. appId", e10);
                        list = Collections.EMPTY_LIST;
                    }
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(list);
                return true;
            case 25:
                d5 d5Var15 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                j(d5Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                d5 d5Var16 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                h(d5Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                d5 d5Var17 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                v(d5Var17);
                parcel2.writeNoException();
                return true;
            case 29:
                d5 d5Var18 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                o4 o4Var = (o4) com.google.android.gms.internal.measurement.z.a(parcel, o4.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    l0Var = iInterfaceQueryLocalInterface instanceof m0 ? (m0) iInterfaceQueryLocalInterface : new l0(strongBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback", 0);
                }
                com.google.android.gms.internal.measurement.z.d(parcel);
                z(d5Var18, o4Var, l0Var);
                parcel2.writeNoException();
                return true;
            case 30:
                d5 d5Var19 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                d dVar = (d) com.google.android.gms.internal.measurement.z.a(parcel, d.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                A(d5Var19, dVar);
                parcel2.writeNoException();
                return true;
            case 31:
                d5 d5Var20 = (d5) com.google.android.gms.internal.measurement.z.a(parcel, d5.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    j0Var = iInterfaceQueryLocalInterface2 instanceof k0 ? (k0) iInterfaceQueryLocalInterface2 : new j0(strongBinder2, "com.google.android.gms.measurement.internal.ITriggerUrisCallback", 0);
                }
                com.google.android.gms.internal.measurement.z.d(parcel);
                w(d5Var20, bundle3, j0Var);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void c(Runnable runnable) {
        v4 v4Var = this.f1108a;
        if (v4Var.b().m()) {
            runnable.run();
        } else {
            v4Var.b().r(runnable);
        }
    }

    public final void d(d5 d5Var) {
        i0.y.g(d5Var);
        String str = d5Var.f1114a;
        i0.y.d(str);
        G(str, false);
        this.f1108a.k0().k(d5Var.f1115b);
    }

    @Override // c1.i0
    public final List f(String str, String str2, String str3, boolean z9) {
        G(str, true);
        v4 v4Var = this.f1108a;
        try {
            List<z4> list = (List) v4Var.b().n(new z1(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (z4 z4Var : list) {
                if (z9 || !b5.F(z4Var.f1631c)) {
                    arrayList.add(new y4(z4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            v4Var.a().f.d(w0.o(str), "Failed to get user properties as. appId", e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e3) {
            e = e3;
            v4Var.a().f.d(w0.o(str), "Failed to get user properties as. appId", e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // c1.i0
    public final void g(d5 d5Var) {
        d(d5Var);
        H(new w1(this, d5Var, 2));
    }

    @Override // c1.i0
    public final void h(d5 d5Var) {
        i0.y.d(d5Var.f1114a);
        i0.y.g(d5Var.f1128s);
        c(new w1(this, d5Var, 5));
    }

    @Override // c1.i0
    public final List i(String str, String str2, boolean z9, d5 d5Var) {
        d(d5Var);
        String str3 = d5Var.f1114a;
        i0.y.g(str3);
        v4 v4Var = this.f1108a;
        try {
            List<z4> list = (List) v4Var.b().n(new z1(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (z4 z4Var : list) {
                if (z9 || !b5.F(z4Var.f1631c)) {
                    arrayList.add(new y4(z4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            v4Var.a().f.d(w0.o(str3), "Failed to query user properties. appId", e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e3) {
            e = e3;
            v4Var.a().f.d(w0.o(str3), "Failed to query user properties. appId", e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // c1.i0
    public final void j(d5 d5Var) {
        i0.y.d(d5Var.f1114a);
        i0.y.g(d5Var.f1128s);
        c(new w1(this, d5Var, 6));
    }

    @Override // c1.i0
    public final void k(long j10, String str, String str2, String str3) {
        H(new x1(this, str2, str3, str, j10, 0));
    }

    @Override // c1.i0
    public final List m(String str, String str2, String str3) {
        G(str, true);
        v4 v4Var = this.f1108a;
        try {
            return (List) v4Var.b().n(new z1(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e) {
            v4Var.a().f.c(e, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // c1.i0
    public final void o(v vVar, d5 d5Var) {
        i0.y.g(vVar);
        d(d5Var);
        H(new y1(this, vVar, d5Var, 1));
    }

    @Override // c1.i0
    public final void p(d5 d5Var) {
        String str = d5Var.f1114a;
        i0.y.d(str);
        G(str, false);
        H(new w1(this, d5Var, 3));
    }

    @Override // c1.i0
    public final void q(e eVar, d5 d5Var) {
        i0.y.g(eVar);
        i0.y.g(eVar.f1136c);
        d(d5Var);
        e eVar2 = new e(eVar);
        eVar2.f1134a = d5Var.f1114a;
        H(new y1(this, eVar2, d5Var, 0));
    }

    @Override // c1.i0
    public final String r(d5 d5Var) {
        d(d5Var);
        v4 v4Var = this.f1108a;
        try {
            return (String) v4Var.b().n(new v1(v4Var, d5Var)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            v4Var.a().f.d(w0.o(d5Var.f1114a), "Failed to get app instance id. appId", e);
            return null;
        }
    }

    @Override // c1.i0
    public final List s(String str, String str2, d5 d5Var) {
        d(d5Var);
        String str3 = d5Var.f1114a;
        i0.y.g(str3);
        v4 v4Var = this.f1108a;
        try {
            return (List) v4Var.b().n(new z1(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e) {
            v4Var.a().f.c(e, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // c1.i0
    public final void t(d5 d5Var) {
        i0.y.d(d5Var.f1114a);
        i0.y.g(d5Var.f1128s);
        c(new w1(this, d5Var, 4));
    }

    @Override // c1.i0
    public final void v(d5 d5Var) {
        d(d5Var);
        H(new w1(this, d5Var, 1));
    }

    @Override // c1.i0
    public final void w(d5 d5Var, Bundle bundle, k0 k0Var) {
        d(d5Var);
        String str = d5Var.f1114a;
        i0.y.g(str);
        this.f1108a.b().p(new b2(this, d5Var, bundle, k0Var, str));
    }

    @Override // c1.i0
    public final void x(Bundle bundle, d5 d5Var) {
        d(d5Var);
        String str = d5Var.f1114a;
        i0.y.g(str);
        H(new c2(this, bundle, str, d5Var));
    }

    @Override // c1.i0
    public final void y(y4 y4Var, d5 d5Var) {
        i0.y.g(y4Var);
        d(d5Var);
        H(new y1(this, y4Var, d5Var, 3));
    }

    @Override // c1.i0
    public final void z(d5 d5Var, o4 o4Var, m0 m0Var) {
        d(d5Var);
        String str = d5Var.f1114a;
        i0.y.g(str);
        this.f1108a.b().p(new c2(this, str, o4Var, m0Var, 0));
    }
}
