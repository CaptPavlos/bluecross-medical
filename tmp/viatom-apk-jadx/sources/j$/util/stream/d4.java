package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public final class d4 extends w3 {
    public final /* synthetic */ int h;

    public /* synthetic */ d4(int i10) {
        this.h = i10;
    }

    @Override // j$.util.stream.w3
    public final r4 Z() {
        switch (this.h) {
            case 0:
                return new v4();
            case 1:
                return new t4();
            case 2:
                return new w4();
            default:
                return new u4();
        }
    }

    @Override // j$.util.stream.w3, j$.util.stream.f8
    public final Object a(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case 0:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 1:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            default:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
        }
        return (Long) super.a(aVar, spliterator);
    }

    @Override // j$.util.stream.w3, j$.util.stream.f8
    public final Object b(a aVar, Spliterator spliterator) {
        switch (this.h) {
            case 0:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 1:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
            default:
                if (!z6.SIZED.j(aVar.f)) {
                    break;
                } else {
                    break;
                }
        }
        return (Long) super.b(aVar, spliterator);
    }

    @Override // j$.util.stream.w3, j$.util.stream.f8
    public final int f() {
        switch (this.h) {
        }
        return z6.f9828r;
    }
}
