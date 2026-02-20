package h4;

import java.util.ArrayList;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8443a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8444b;

    public /* synthetic */ a(d dVar, int i10) {
        this.f8443a = i10;
        this.f8444b = dVar;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f8443a) {
            case 0:
                ArrayList arrayList = this.f8444b.f8450b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((i4.b) obj).a();
                }
                break;
            default:
                ArrayList arrayList2 = this.f8444b.f8450b;
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    ((i4.b) obj2).getClass();
                }
                break;
        }
        return w.f12711a;
    }
}
