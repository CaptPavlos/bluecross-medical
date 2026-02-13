package h4;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8445a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8446b;

    public /* synthetic */ b(d dVar, int i10) {
        this.f8445a = i10;
        this.f8446b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8445a) {
            case 0:
                ArrayList arrayList = this.f8446b.f8450b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((i4.b) obj).a();
                }
                break;
            default:
                ArrayList arrayList2 = this.f8446b.f8450b;
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    ((i4.b) obj2).getClass();
                }
                break;
        }
    }
}
