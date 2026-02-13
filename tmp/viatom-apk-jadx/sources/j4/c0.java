package j4;

import android.net.Uri;
import j$.util.DesugarCollections;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9924a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9925b;

    /* renamed from: c, reason: collision with root package name */
    public int f9926c;

    /* renamed from: d, reason: collision with root package name */
    public int f9927d;
    public int e;
    public boolean f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9928i;

    public c0(Uri uri, int i10, ArrayList arrayList, int i11, int i12, boolean z9, int i13, int i14) {
        this.f9924a = 1;
        this.f9925b = uri;
        this.f9926c = i10;
        if (arrayList == null) {
            this.f9928i = null;
        } else {
            this.f9928i = DesugarCollections.unmodifiableList(arrayList);
        }
        this.f9927d = i11;
        this.e = i12;
        this.f = z9;
        this.g = i13;
        this.h = i14;
    }

    public void a(int i10) {
        int i11;
        if (i10 > 0) {
            int length = ((v8.b[]) this.f9928i).length - 1;
            int i12 = 0;
            while (true) {
                i11 = this.e;
                if (length < i11 || i10 <= 0) {
                    break;
                }
                int i13 = ((v8.b[]) this.f9928i)[length].f13209c;
                i10 -= i13;
                this.h -= i13;
                this.g--;
                i12++;
                length--;
            }
            v8.b[] bVarArr = (v8.b[]) this.f9928i;
            int i14 = i11 + 1;
            System.arraycopy(bVarArr, i14, bVarArr, i14 + i12, this.g);
            v8.b[] bVarArr2 = (v8.b[]) this.f9928i;
            int i15 = this.e + 1;
            Arrays.fill(bVarArr2, i15, i15 + i12, (Object) null);
            this.e += i12;
        }
    }

    public boolean b() {
        return (this.f9927d == 0 && this.e == 0) ? false : true;
    }

    public void c(v8.b bVar) {
        int i10 = bVar.f13209c;
        int i11 = this.f9927d;
        if (i10 > i11) {
            Arrays.fill((v8.b[]) this.f9928i, (Object) null);
            this.e = ((v8.b[]) this.f9928i).length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i10) - i11);
        int i12 = this.g + 1;
        v8.b[] bVarArr = (v8.b[]) this.f9928i;
        if (i12 > bVarArr.length) {
            v8.b[] bVarArr2 = new v8.b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.e = ((v8.b[]) this.f9928i).length - 1;
            this.f9928i = bVarArr2;
        }
        int i13 = this.e;
        this.e = i13 - 1;
        ((v8.b[]) this.f9928i)[i13] = bVar;
        this.g++;
        this.h += i10;
    }

    public boolean d() {
        return b();
    }

    public void e(int i10, int i11) {
        if (i10 < 0) {
            com.google.gson.internal.a.n("Width must be positive number or 0.");
            return;
        }
        if (i11 < 0) {
            com.google.gson.internal.a.n("Height must be positive number or 0.");
        } else if (i11 == 0 && i10 == 0) {
            com.google.gson.internal.a.n("At least one dimension has to be positive number.");
        } else {
            this.f9927d = i10;
            this.e = i11;
        }
    }

    public void f(z8.l lVar) throws EOFException {
        z8.i iVar = (z8.i) this.f9925b;
        v8.y.f13293d.getClass();
        long j10 = 0;
        long j11 = 0;
        for (int i10 = 0; i10 < lVar.e(); i10++) {
            j11 += v8.y.f13292c[lVar.j(i10) & 255];
        }
        if (((int) ((j11 + 7) >> 3)) >= lVar.e()) {
            g(lVar.e(), 127, 0);
            iVar.i(lVar);
            return;
        }
        z8.i iVar2 = new z8.i();
        v8.y.f13293d.getClass();
        int i11 = 0;
        for (int i12 = 0; i12 < lVar.e(); i12++) {
            int iJ = lVar.j(i12) & 255;
            int i13 = v8.y.f13291b[iJ];
            byte b10 = v8.y.f13292c[iJ];
            j10 = (j10 << b10) | i13;
            i11 += b10;
            while (i11 >= 8) {
                i11 -= 8;
                iVar2.k((int) (j10 >> i11));
            }
        }
        if (i11 > 0) {
            iVar2.k((int) ((j10 << (8 - i11)) | (255 >>> i11)));
        }
        z8.l byteString = iVar2.readByteString(iVar2.f14479b);
        g(byteString.e(), 127, 128);
        iVar.i(byteString);
    }

    public void g(int i10, int i11, int i12) {
        z8.i iVar = (z8.i) this.f9925b;
        if (i10 < i11) {
            iVar.k(i10 | i12);
            return;
        }
        iVar.k(i12 | i11);
        int i13 = i10 - i11;
        while (i13 >= 128) {
            iVar.k(128 | (i13 & 127));
            i13 >>>= 7;
        }
        iVar.k(i13);
    }

    public String toString() {
        switch (this.f9924a) {
            case 1:
                int i10 = this.f9927d;
                List<i0> list = (List) this.f9928i;
                StringBuilder sb = new StringBuilder("Request{");
                int i11 = this.f9926c;
                if (i11 > 0) {
                    sb.append(i11);
                } else {
                    sb.append((Uri) this.f9925b);
                }
                if (list != null && !list.isEmpty()) {
                    for (i0 i0Var : list) {
                        sb.append(' ');
                        sb.append(i0Var.key());
                    }
                }
                if (i10 > 0) {
                    sb.append(" resize(");
                    sb.append(i10);
                    sb.append(',');
                    sb.append(this.e);
                    sb.append(')');
                }
                if (this.f) {
                    sb.append(" centerCrop");
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public c0(z8.i iVar) {
        this.f9924a = 2;
        this.f9926c = Integer.MAX_VALUE;
        this.f9928i = new v8.b[8];
        this.e = 7;
        this.g = 0;
        this.h = 0;
        this.f9927d = 4096;
        this.f9925b = iVar;
    }
}
