package p4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 implements t4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11925a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5.j f11926b;

    public /* synthetic */ b0(d5.j jVar, int i10) {
        this.f11925a = i10;
        this.f11926b = jVar;
    }

    @Override // t4.c
    public final void a(int i10) {
        switch (this.f11925a) {
            case 0:
                ((u4.e) ((ArrayList) this.f11926b.f7136d).get(i10)).f12905b = !((u4.e) ((ArrayList) r0.f7136d).get(i10)).f12905b;
                break;
            default:
                ((u4.e) ((ArrayList) this.f11926b.g).get(i10)).f12905b = !((u4.e) ((ArrayList) r0.g).get(i10)).f12905b;
                break;
        }
    }
}
