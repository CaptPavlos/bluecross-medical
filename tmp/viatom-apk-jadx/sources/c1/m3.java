package c1;

import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1333a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n3 f1334b;

    public m3(n3 n3Var, int i10) {
        this.f1333a = i10;
        switch (i10) {
            case 1:
                Objects.requireNonNull(n3Var);
                this.f1334b = n3Var;
                break;
            default:
                Objects.requireNonNull(n3Var);
                this.f1334b = n3Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1333a) {
            case 0:
                n3 n3Var = this.f1334b;
                n3Var.e = n3Var.f1370j;
                break;
            default:
                this.f1334b.f1370j = null;
                break;
        }
    }
}
