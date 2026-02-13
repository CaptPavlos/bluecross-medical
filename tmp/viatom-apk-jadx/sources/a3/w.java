package a3;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements c3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f171a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f172b;

    /* renamed from: c, reason: collision with root package name */
    public final p6.a f173c;

    public w(c3.c cVar, d0.i iVar) {
        this.f171a = 2;
        this.f173c = cVar;
        this.f172b = iVar;
    }

    @Override // p6.a
    public final Object get() {
        DataStore dataStoreCreate;
        switch (this.f171a) {
            case 0:
                Context context = (Context) this.f172b.f6781b;
                w6.h hVar = (w6.h) this.f173c.get();
                context.getClass();
                hVar.getClass();
                d3.h hVar2 = d3.h.f6819a;
                ReplaceFileCorruptionHandler replaceFileCorruptionHandler = new ReplaceFileCorruptionHandler(new q(0));
                w7.c cVarA = r7.y.a(hVar);
                r rVar = new r(context, 0);
                t6.t tVar = t6.t.f12808a;
                try {
                    System.loadLibrary("datastore_shared_counter");
                    dataStoreCreate = MultiProcessDataStoreFactory.INSTANCE.create(hVar2, replaceFileCorruptionHandler, tVar, cVarA, rVar);
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    dataStoreCreate = DataStoreFactory.INSTANCE.create(hVar2, replaceFileCorruptionHandler, tVar, cVarA, rVar);
                }
                if (dataStoreCreate != null) {
                    return dataStoreCreate;
                }
                androidx.window.layout.c.k("Cannot return null from a non-@Nullable @Provides method");
                return null;
            case 1:
                return new j0((Context) this.f172b.f6781b, (p1) this.f173c.get());
            default:
                return new d3.d((c) this.f173c.get(), (w6.h) this.f172b.f6781b);
        }
    }

    public /* synthetic */ w(d0.i iVar, c3.c cVar, int i10) {
        this.f171a = i10;
        this.f172b = iVar;
        this.f173c = cVar;
    }
}
