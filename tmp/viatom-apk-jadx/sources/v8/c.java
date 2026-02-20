package v8;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import z8.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public final b0 f13211b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13210a = new ArrayList();
    public b[] e = new b[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f13212c = 4096;

    /* renamed from: d, reason: collision with root package name */
    public int f13213d = 4096;

    public c(r rVar) {
        this.f13211b = new b0(rVar);
    }

    public final int a(int i10) {
        int i11;
        int i12 = 0;
        if (i10 > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i11 = this.f;
                if (length < i11 || i10 <= 0) {
                    break;
                }
                int i13 = this.e[length].f13209c;
                i10 -= i13;
                this.h -= i13;
                this.g--;
                i12++;
            }
            b[] bVarArr = this.e;
            System.arraycopy(bVarArr, i11 + 1, bVarArr, i11 + 1 + i12, this.g);
            this.f += i12;
        }
        return i12;
    }

    public final z8.l b(int i10) throws IOException {
        if (i10 >= 0) {
            b[] bVarArr = d.f13214a;
            if (i10 <= bVarArr.length - 1) {
                return bVarArr[i10].f13207a;
            }
        }
        int length = this.f + 1 + (i10 - d.f13214a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.e;
            if (length < bVarArr2.length) {
                return bVarArr2[length].f13207a;
            }
        }
        p8.u.n(i10 + 1, "Header index too large ");
        return null;
    }

    public final void c(b bVar) {
        this.f13210a.add(bVar);
        int i10 = bVar.f13209c;
        int i11 = this.f13213d;
        if (i10 > i11) {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i10) - i11);
        int i12 = this.g + 1;
        b[] bVarArr = this.e;
        if (i12 > bVarArr.length) {
            b[] bVarArr2 = new b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.f = this.e.length - 1;
            this.e = bVarArr2;
        }
        int i13 = this.f;
        this.f = i13 - 1;
        this.e[i13] = bVar;
        this.g++;
        this.h += i10;
    }

    public final z8.l d() {
        b0 b0Var = this.f13211b;
        byte b10 = b0Var.readByte();
        int i10 = b10 & 255;
        boolean z9 = (b10 & 128) == 128;
        int iE = e(i10, 127);
        if (!z9) {
            return b0Var.readByteString(iE);
        }
        y yVar = y.f13293d;
        long j10 = iE;
        b0Var.require(j10);
        byte[] byteArray = b0Var.f14457b.readByteArray(j10);
        yVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e0.o oVar = yVar.f13294a;
        e0.o oVar2 = oVar;
        int i11 = 0;
        int i12 = 0;
        for (byte b11 : byteArray) {
            i11 = (i11 << 8) | (b11 & 255);
            i12 += 8;
            while (i12 >= 8) {
                oVar2 = ((e0.o[]) oVar2.f7622c)[(i11 >>> (i12 - 8)) & 255];
                if (((e0.o[]) oVar2.f7622c) == null) {
                    byteArrayOutputStream.write(oVar2.f7620a);
                    i12 -= oVar2.f7621b;
                    oVar2 = oVar;
                } else {
                    i12 -= 8;
                }
            }
        }
        while (i12 > 0) {
            e0.o oVar3 = ((e0.o[]) oVar2.f7622c)[(i11 << (8 - i12)) & 255];
            e0.o[] oVarArr = (e0.o[]) oVar3.f7622c;
            int i13 = oVar3.f7621b;
            if (oVarArr != null || i13 > i12) {
                break;
            }
            byteArrayOutputStream.write(oVar3.f7620a);
            i12 -= i13;
            oVar2 = oVar;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        z8.l lVar = z8.l.f14487d;
        byteArray2.getClass();
        return new z8.l(Arrays.copyOf(byteArray2, byteArray2.length));
    }

    public final int e(int i10, int i11) {
        int i12 = i10 & i11;
        if (i12 < i11) {
            return i12;
        }
        int i13 = 0;
        while (true) {
            byte b10 = this.f13211b.readByte();
            int i14 = b10 & 255;
            if ((b10 & 128) == 0) {
                return i11 + (i14 << i13);
            }
            i11 += (b10 & 127) << i13;
            i13 += 7;
        }
    }
}
