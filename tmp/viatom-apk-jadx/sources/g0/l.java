package g0;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.a4;
import h5.c0;
import h5.e1;
import h5.f1;
import h5.h0;
import h5.h1;
import h5.j1;
import h5.l1;
import h5.m0;
import h5.q;
import h5.r;
import h5.s;
import h5.t0;
import h5.u0;
import h5.v;
import h5.y0;
import i0.f0;
import i0.m;
import i0.n;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8196a;

    public /* synthetic */ l(int i10) {
        this.f8196a = i10;
    }

    public static void a(i0.g gVar, Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        int i11 = gVar.f8893a;
        a4.O(parcel, 1, 4);
        parcel.writeInt(i11);
        int i12 = gVar.f8894b;
        a4.O(parcel, 2, 4);
        parcel.writeInt(i12);
        int i13 = gVar.f8895c;
        a4.O(parcel, 3, 4);
        parcel.writeInt(i13);
        a4.F(parcel, 4, gVar.f8896d);
        a4.D(parcel, 5, gVar.e);
        a4.G(parcel, 6, gVar.f, i10);
        a4.C(7, gVar.g, parcel);
        a4.E(parcel, 8, gVar.h, i10);
        a4.G(parcel, 10, gVar.f8897i, i10);
        a4.G(parcel, 11, gVar.f8898j, i10);
        boolean z9 = gVar.f8899k;
        a4.O(parcel, 12, 4);
        parcel.writeInt(z9 ? 1 : 0);
        int i14 = gVar.f8900l;
        a4.O(parcel, 13, 4);
        parcel.writeInt(i14);
        boolean z10 = gVar.f8901m;
        a4.O(parcel, 14, 4);
        parcel.writeInt(z10 ? 1 : 0);
        a4.F(parcel, 15, gVar.f8902n);
        a4.M(parcel, I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f8196a) {
            case 0:
                int iQ = a.a.Q(parcel);
                String strT = null;
                f0.b bVar = null;
                int iL = 0;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iQ) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        iL = a.a.L(parcel, i10);
                    } else if (c10 == 2) {
                        strT = a.a.t(parcel, i10);
                    } else if (c10 == 3) {
                        pendingIntent = (PendingIntent) a.a.s(parcel, i10, PendingIntent.CREATOR);
                    } else if (c10 != 4) {
                        a.a.O(parcel, i10);
                    } else {
                        bVar = (f0.b) a.a.s(parcel, i10, f0.b.CREATOR);
                    }
                }
                a.a.y(parcel, iQ);
                return new Status(iL, strT, pendingIntent, bVar);
            case 1:
                parcel.getClass();
                h5.f fVar = new h5.f();
                fVar.f8524a = -1L;
                fVar.f8527d = -1L;
                h5.e eVar = h5.e.f8507b;
                fVar.g = eVar;
                fVar.y = -1;
                fVar.f8524a = parcel.readLong();
                fVar.f8525b = parcel.readString();
                fVar.f8526c = parcel.readString();
                fVar.f8527d = parcel.readLong();
                fVar.e = parcel.readString();
                fVar.f = parcel.readString();
                int i11 = parcel.readInt();
                if (i11 == 0) {
                    fVar.g = h5.e.f8506a;
                } else if (i11 != 1) {
                    fVar.g = h5.e.f8508c;
                } else {
                    fVar.g = eVar;
                }
                fVar.h = parcel.readInt();
                fVar.f8528i = parcel.readInt();
                fVar.f8529j = parcel.readInt();
                fVar.f8530k = parcel.readInt();
                fVar.f8531l = parcel.readString();
                fVar.f8532m = parcel.readInt();
                fVar.f8533n = parcel.readLong();
                fVar.f8534o = parcel.readLong();
                fVar.f8535p = parcel.readInt();
                fVar.f8536q = parcel.readString();
                fVar.f8537r = parcel.readLong();
                fVar.f8538s = parcel.readString();
                fVar.t = parcel.readInt();
                fVar.f8541w = parcel.readLong();
                fVar.f8542x = parcel.readInt();
                fVar.B = parcel.readInt() == 1;
                return fVar;
            case 2:
                parcel.getClass();
                return new h5.h(parcel);
            case 3:
                parcel.getClass();
                h5.k kVar = new h5.k((int) (0 == true ? 1 : 0), (String) null, 7);
                kVar.f8632a = parcel.readInt();
                kVar.f8633b = parcel.readString();
                kVar.f8634c = parcel.readString();
                kVar.f8635d = parcel.readInt() == 1;
                kVar.e = parcel.readInt() == 1;
                kVar.f = parcel.readInt();
                kVar.g = parcel.readInt();
                kVar.h = parcel.createTypedArrayList(h5.k.CREATOR);
                return kVar;
            case 4:
                parcel.getClass();
                q qVar = new q();
                qVar.f8700a = -1;
                qVar.f8703d = 1;
                qVar.e = -1L;
                qVar.h = -1L;
                qVar.f8712q = -1L;
                qVar.f8714s = -1L;
                qVar.t = -1L;
                qVar.f8716v = new ArrayList();
                qVar.f8700a = parcel.readInt();
                qVar.f8701b = parcel.readString();
                qVar.f8702c = parcel.readInt();
                qVar.f8703d = parcel.readInt();
                qVar.e = parcel.readLong();
                qVar.f = parcel.readString();
                qVar.g = parcel.readInt();
                qVar.h = parcel.readLong();
                qVar.f8704i = parcel.readInt();
                qVar.f8705j = parcel.readString();
                qVar.f8706k = parcel.readString();
                qVar.f8707l = parcel.readInt();
                qVar.f8708m = parcel.readString();
                qVar.f8709n = parcel.readString();
                qVar.f8710o = parcel.readLong();
                qVar.f8711p = parcel.createStringArrayList();
                parcel.readTypedList(qVar.f8716v, r.CREATOR);
                qVar.f8712q = parcel.readLong();
                qVar.f8713r = parcel.readInt();
                return qVar;
            case 5:
                parcel.getClass();
                r rVar = new r();
                rVar.f8720a = -1L;
                rVar.f8721b = -1L;
                rVar.f8722c = -1L;
                rVar.e = -1L;
                rVar.f8720a = parcel.readLong();
                rVar.f8721b = parcel.readLong();
                rVar.f8722c = parcel.readLong();
                rVar.f8723d = parcel.readString();
                rVar.e = parcel.readLong();
                rVar.f = parcel.readLong();
                rVar.g = parcel.readString();
                rVar.h = parcel.readString();
                rVar.f8724i = parcel.readInt();
                rVar.f8725j = parcel.readLong();
                return rVar;
            case 6:
                parcel.getClass();
                s sVar = new s();
                sVar.f8730a = -1;
                sVar.f8730a = parcel.readInt();
                sVar.f8731b = parcel.readLong();
                sVar.f8732c = parcel.readString();
                return sVar;
            case 7:
                parcel.getClass();
                v vVar = new v();
                vVar.f8758a = parcel.readLong();
                vVar.f8759b = parcel.readString();
                vVar.f8760c = parcel.readLong();
                vVar.f8761d = parcel.readString();
                vVar.e = parcel.readInt();
                vVar.f = parcel.readString();
                vVar.g = parcel.readInt();
                vVar.h = parcel.readString();
                vVar.f8762i = parcel.readString();
                vVar.f8763j = parcel.readString();
                vVar.f8764k = parcel.readLong();
                vVar.f8765l = parcel.readString();
                vVar.f8766m = parcel.readInt();
                vVar.f8767n = parcel.readString();
                vVar.f8768o = parcel.readLong();
                vVar.f8769p = parcel.readString();
                vVar.f8770q = parcel.readString();
                vVar.f8771r = parcel.readLong();
                vVar.f8772s = parcel.readLong();
                vVar.t = parcel.readString();
                vVar.f8773u = parcel.readString();
                vVar.f8774v = parcel.readString();
                vVar.f8775w = parcel.readString();
                vVar.f8776x = parcel.readInt();
                return vVar;
            case 8:
                parcel.getClass();
                c0 c0Var = new c0();
                c0Var.f8486b = -1L;
                c0Var.f8488d = -1L;
                c0Var.f8489i = new ArrayList();
                c0Var.f8485a = parcel.readString();
                c0Var.f8487c = parcel.readString();
                c0Var.f8488d = parcel.readLong();
                c0Var.e = parcel.readString();
                c0Var.f = parcel.readString();
                c0Var.g = parcel.readString();
                c0Var.f8486b = parcel.readLong();
                return c0Var;
            case 9:
                parcel.getClass();
                h0 h0Var = new h0();
                h0Var.f8601a = parcel.readString();
                h0Var.f8602b = parcel.readInt();
                h0Var.f8603c = parcel.readInt();
                h0Var.f8604d = parcel.readString();
                h0Var.e = parcel.readInt();
                return h0Var;
            case 10:
                parcel.getClass();
                m0 m0Var = new m0();
                m0Var.f8657a = parcel.readLong();
                m0Var.e = parcel.readLong();
                m0Var.f8658b = parcel.readString();
                m0Var.f8659c = parcel.readString();
                m0Var.f8660d = parcel.readString();
                m0Var.f = parcel.readString();
                m0Var.g = parcel.readString();
                m0Var.h = parcel.readInt();
                m0Var.f8661i = parcel.readInt();
                m0Var.f8662j = parcel.readInt();
                m0Var.f8663k = parcel.readString();
                m0Var.f8664l = parcel.readInt();
                return m0Var;
            case 11:
                parcel.getClass();
                t0 t0Var = new t0();
                t0Var.f8739a = parcel.readLong();
                t0Var.e = parcel.readLong();
                t0Var.f8741c = parcel.readString();
                t0Var.f8740b = parcel.readString();
                t0Var.f8742d = parcel.readString();
                t0Var.f = parcel.readString();
                t0Var.g = parcel.readInt();
                t0Var.h = parcel.readInt();
                t0Var.f8743i = parcel.readString();
                t0Var.f8744j = parcel.readInt();
                t0Var.f8745k = parcel.readInt();
                t0Var.f8746l = parcel.readString();
                t0Var.f8747m = parcel.readInt();
                t0Var.f8748n = parcel.readString();
                t0Var.f8749o = parcel.readInt();
                return t0Var;
            case 12:
                parcel.getClass();
                u0 u0Var = new u0();
                u0Var.f8754a = parcel.readString();
                u0Var.f8755b = parcel.readInt();
                u0Var.f8756c = parcel.readInt();
                u0Var.f8757d = parcel.readInt();
                return u0Var;
            case 13:
                parcel.getClass();
                return new y0(parcel);
            case 14:
                parcel.getClass();
                e1 e1Var = new e1();
                e1Var.e = -1L;
                e1Var.f = "type0";
                e1Var.f8516i = -1;
                e1Var.f8512a = parcel.readString();
                e1Var.f8513b = parcel.readString();
                e1Var.f8514c = parcel.readString();
                e1Var.f8515d = parcel.readString();
                e1Var.f8520m = parcel.readString();
                e1Var.f = parcel.readString();
                e1Var.e = parcel.readLong();
                e1Var.g = parcel.readString();
                e1Var.f8521n = parcel.readInt() == 1;
                e1Var.h = parcel.readInt();
                e1Var.f8519l = parcel.readString();
                e1Var.f8516i = parcel.readInt();
                e1Var.f8517j = parcel.readInt();
                e1Var.f8518k = parcel.readInt();
                e1Var.f8522o = parcel.readInt() == 1;
                e1Var.f8523p = parcel.readInt() == 1;
                return e1Var;
            case 15:
                parcel.getClass();
                f1 f1Var = new f1();
                f1Var.f8546a = parcel.readString();
                f1Var.f8547b = parcel.readInt();
                f1Var.f8548c = parcel.readInt();
                f1Var.f8549d = parcel.readInt();
                f1Var.e = parcel.readInt();
                f1Var.f = parcel.readInt();
                f1Var.g = parcel.readInt();
                f1Var.h = parcel.readInt();
                return f1Var;
            case 16:
                parcel.getClass();
                return new h1(parcel);
            case 17:
                parcel.getClass();
                j1 j1Var = new j1();
                j1Var.f8628a = parcel.readLong();
                j1Var.f8629b = parcel.readString();
                j1Var.f8631d = parcel.readInt();
                j1Var.e = parcel.readInt();
                j1Var.f8630c = parcel.readInt();
                j1Var.f = parcel.readInt();
                return j1Var;
            case 18:
                parcel.getClass();
                l1 l1Var = new l1();
                l1Var.f8650a = parcel.readString();
                l1Var.f8651b = parcel.readString();
                return l1Var;
            case 19:
                int iQ2 = a.a.Q(parcel);
                ArrayList arrayListV = null;
                int iL2 = 0;
                while (parcel.dataPosition() < iQ2) {
                    int i12 = parcel.readInt();
                    char c11 = (char) i12;
                    if (c11 == 1) {
                        iL2 = a.a.L(parcel, i12);
                    } else if (c11 != 2) {
                        a.a.O(parcel, i12);
                    } else {
                        arrayListV = a.a.v(parcel, i12, i0.j.CREATOR);
                    }
                }
                a.a.y(parcel, iQ2);
                return new n(iL2, arrayListV);
            case 20:
                int iQ3 = a.a.Q(parcel);
                int iL3 = -1;
                int iL4 = 0;
                int iL5 = 0;
                int iL6 = 0;
                int iL7 = 0;
                String strT2 = null;
                String strT3 = null;
                long jM = 0;
                long jM2 = 0;
                while (parcel.dataPosition() < iQ3) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 1:
                            iL4 = a.a.L(parcel, i13);
                            break;
                        case 2:
                            iL5 = a.a.L(parcel, i13);
                            break;
                        case 3:
                            iL6 = a.a.L(parcel, i13);
                            break;
                        case 4:
                            jM = a.a.M(parcel, i13);
                            break;
                        case 5:
                            jM2 = a.a.M(parcel, i13);
                            break;
                        case 6:
                            strT2 = a.a.t(parcel, i13);
                            break;
                        case 7:
                            strT3 = a.a.t(parcel, i13);
                            break;
                        case '\b':
                            iL7 = a.a.L(parcel, i13);
                            break;
                        case '\t':
                            iL3 = a.a.L(parcel, i13);
                            break;
                        default:
                            a.a.O(parcel, i13);
                            break;
                    }
                }
                a.a.y(parcel, iQ3);
                return new i0.j(iL4, iL5, iL6, jM, jM2, strT2, strT3, iL7, iL3);
            case 21:
                int iQ4 = a.a.Q(parcel);
                Account account = null;
                int iL8 = 0;
                int iL9 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < iQ4) {
                    int i14 = parcel.readInt();
                    char c12 = (char) i14;
                    if (c12 == 1) {
                        iL8 = a.a.L(parcel, i14);
                    } else if (c12 == 2) {
                        account = (Account) a.a.s(parcel, i14, Account.CREATOR);
                    } else if (c12 == 3) {
                        iL9 = a.a.L(parcel, i14);
                    } else if (c12 != 4) {
                        a.a.O(parcel, i14);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) a.a.s(parcel, i14, GoogleSignInAccount.CREATOR);
                    }
                }
                a.a.y(parcel, iQ4);
                return new i0.r(iL8, account, iL9, googleSignInAccount);
            case 22:
                int iQ5 = a.a.Q(parcel);
                int iL10 = 0;
                boolean zI = false;
                boolean zI2 = false;
                IBinder iBinderK = null;
                f0.b bVar2 = null;
                while (parcel.dataPosition() < iQ5) {
                    int i15 = parcel.readInt();
                    char c13 = (char) i15;
                    if (c13 == 1) {
                        iL10 = a.a.L(parcel, i15);
                    } else if (c13 == 2) {
                        iBinderK = a.a.K(parcel, i15);
                    } else if (c13 == 3) {
                        bVar2 = (f0.b) a.a.s(parcel, i15, f0.b.CREATOR);
                    } else if (c13 == 4) {
                        zI = a.a.I(parcel, i15);
                    } else if (c13 != 5) {
                        a.a.O(parcel, i15);
                    } else {
                        zI2 = a.a.I(parcel, i15);
                    }
                }
                a.a.y(parcel, iQ5);
                return new i0.s(iL10, iBinderK, bVar2, zI, zI2);
            case 23:
                int iQ6 = a.a.Q(parcel);
                int iL11 = 0;
                int iL12 = 0;
                int iL13 = 0;
                boolean zI3 = false;
                boolean zI4 = false;
                while (parcel.dataPosition() < iQ6) {
                    int i16 = parcel.readInt();
                    char c14 = (char) i16;
                    if (c14 == 1) {
                        iL11 = a.a.L(parcel, i16);
                    } else if (c14 == 2) {
                        zI3 = a.a.I(parcel, i16);
                    } else if (c14 == 3) {
                        zI4 = a.a.I(parcel, i16);
                    } else if (c14 == 4) {
                        iL12 = a.a.L(parcel, i16);
                    } else if (c14 != 5) {
                        a.a.O(parcel, i16);
                    } else {
                        iL13 = a.a.L(parcel, i16);
                    }
                }
                a.a.y(parcel, iQ6);
                return new m(iL11, iL12, iL13, zI3, zI4);
            case 24:
                int iQ7 = a.a.Q(parcel);
                Bundle bundleR = null;
                i0.f fVar2 = null;
                int iL14 = 0;
                f0.d[] dVarArr = null;
                while (parcel.dataPosition() < iQ7) {
                    int i17 = parcel.readInt();
                    char c15 = (char) i17;
                    if (c15 == 1) {
                        bundleR = a.a.r(parcel, i17);
                    } else if (c15 == 2) {
                        dVarArr = (f0.d[]) a.a.u(parcel, i17, f0.d.CREATOR);
                    } else if (c15 == 3) {
                        iL14 = a.a.L(parcel, i17);
                    } else if (c15 != 4) {
                        a.a.O(parcel, i17);
                    } else {
                        fVar2 = (i0.f) a.a.s(parcel, i17, i0.f.CREATOR);
                    }
                }
                a.a.y(parcel, iQ7);
                f0 f0Var = new f0();
                f0Var.f8887a = bundleR;
                f0Var.f8888b = dVarArr;
                f0Var.f8889c = iL14;
                f0Var.f8890d = fVar2;
                return f0Var;
            case 25:
                int iQ8 = a.a.Q(parcel);
                m mVar = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean zI5 = false;
                boolean zI6 = false;
                int iL15 = 0;
                while (parcel.dataPosition() < iQ8) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            mVar = (m) a.a.s(parcel, i18, m.CREATOR);
                            break;
                        case 2:
                            zI5 = a.a.I(parcel, i18);
                            break;
                        case 3:
                            zI6 = a.a.I(parcel, i18);
                            break;
                        case 4:
                            int iN = a.a.N(parcel, i18);
                            int iDataPosition = parcel.dataPosition();
                            if (iN != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition + iN);
                                break;
                            } else {
                                iArrCreateIntArray = null;
                                break;
                            }
                        case 5:
                            iL15 = a.a.L(parcel, i18);
                            break;
                        case 6:
                            int iN2 = a.a.N(parcel, i18);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iN2 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + iN2);
                                break;
                            } else {
                                iArrCreateIntArray2 = null;
                                break;
                            }
                        default:
                            a.a.O(parcel, i18);
                            break;
                    }
                }
                a.a.y(parcel, iQ8);
                return new i0.f(mVar, zI5, zI6, iArrCreateIntArray, iL15, iArrCreateIntArray2);
            case 26:
                int iQ9 = a.a.Q(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = i0.g.f8891o;
                String strT4 = null;
                IBinder iBinderK2 = null;
                Account account2 = null;
                String strT5 = null;
                int iL16 = 0;
                int iL17 = 0;
                int iL18 = 0;
                boolean zI7 = false;
                int iL19 = 0;
                boolean zI8 = false;
                f0.d[] dVarArr2 = i0.g.f8892p;
                f0.d[] dVarArr3 = dVarArr2;
                while (parcel.dataPosition() < iQ9) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 1:
                            iL16 = a.a.L(parcel, i19);
                            break;
                        case 2:
                            iL17 = a.a.L(parcel, i19);
                            break;
                        case 3:
                            iL18 = a.a.L(parcel, i19);
                            break;
                        case 4:
                            strT4 = a.a.t(parcel, i19);
                            break;
                        case 5:
                            iBinderK2 = a.a.K(parcel, i19);
                            break;
                        case 6:
                            scopeArr = (Scope[]) a.a.u(parcel, i19, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = a.a.r(parcel, i19);
                            break;
                        case '\b':
                            account2 = (Account) a.a.s(parcel, i19, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            a.a.O(parcel, i19);
                            break;
                        case '\n':
                            dVarArr2 = (f0.d[]) a.a.u(parcel, i19, f0.d.CREATOR);
                            break;
                        case 11:
                            dVarArr3 = (f0.d[]) a.a.u(parcel, i19, f0.d.CREATOR);
                            break;
                        case '\f':
                            zI7 = a.a.I(parcel, i19);
                            break;
                        case '\r':
                            iL19 = a.a.L(parcel, i19);
                            break;
                        case 14:
                            zI8 = a.a.I(parcel, i19);
                            break;
                        case 15:
                            strT5 = a.a.t(parcel, i19);
                            break;
                    }
                }
                a.a.y(parcel, iQ9);
                return new i0.g(iL16, iL17, iL18, strT4, iBinderK2, scopeArr, bundle, account2, dVarArr2, dVarArr3, zI7, iL19, zI8, strT5);
            default:
                int iQ10 = a.a.Q(parcel);
                Bundle bundleR2 = null;
                while (parcel.dataPosition() < iQ10) {
                    int i20 = parcel.readInt();
                    if (((char) i20) != 2) {
                        a.a.O(parcel, i20);
                    } else {
                        bundleR2 = a.a.r(parcel, i20);
                    }
                }
                a.a.y(parcel, iQ10);
                return new w2.q(bundleR2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        switch (this.f8196a) {
            case 0:
                return new Status[i10];
            case 1:
                return new h5.f[i10];
            case 2:
                return new h5.h[i10];
            case 3:
                return new h5.k[i10];
            case 4:
                return new q[i10];
            case 5:
                return new r[i10];
            case 6:
                return new s[i10];
            case 7:
                return new v[i10];
            case 8:
                return new c0[i10];
            case 9:
                return new h0[i10];
            case 10:
                return new m0[i10];
            case 11:
                return new t0[i10];
            case 12:
                return new u0[i10];
            case 13:
                return new y0[i10];
            case 14:
                return new e1[i10];
            case 15:
                return new f1[i10];
            case 16:
                return new h1[i10];
            case 17:
                return new j1[i10];
            case 18:
                return new l1[i10];
            case 19:
                return new n[i10];
            case 20:
                return new i0.j[i10];
            case 21:
                return new i0.r[i10];
            case 22:
                return new i0.s[i10];
            case 23:
                return new m[i10];
            case 24:
                return new f0[i10];
            case 25:
                return new i0.f[i10];
            case 26:
                return new i0.g[i10];
            default:
                return new w2.q[i10];
        }
    }
}
