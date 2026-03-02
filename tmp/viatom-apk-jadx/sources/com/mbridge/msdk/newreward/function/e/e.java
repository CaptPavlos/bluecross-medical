package com.mbridge.msdk.newreward.function.e;

import com.mbridge.msdk.newreward.a.b.g;
import com.mbridge.msdk.newreward.a.b.h;
import com.mbridge.msdk.newreward.a.b.j;
import com.mbridge.msdk.newreward.a.b.k;
import com.mbridge.msdk.newreward.a.b.n;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, b> f4977a = new HashMap<>();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f4978a;

        /* renamed from: b, reason: collision with root package name */
        private final e f4979b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4980c;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, e eVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f4978a = bVar;
            this.f4979b = eVar;
            this.f4980c = bVar2;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = this.f4978a;
            com.mbridge.msdk.newreward.a.b.b bVar3 = this.f4980c;
            if (!this.f4979b.f4977a.containsKey(bVar2.f()) || this.f4979b.f4977a.get(bVar2.f()) == null || ((b) this.f4979b.f4977a.get(bVar2.f())).a()) {
                boolean zY = bVar2.y();
                e eVar = this.f4979b;
                if (!zY) {
                    if (eVar.f4977a.containsKey(bVar2.f()) && this.f4979b.f4977a.get(bVar2.f()) != null) {
                        ((b) this.f4979b.f4977a.get(bVar2.f())).a(true);
                    }
                    bVar3.reqFailed(bVar);
                    return;
                }
                if (eVar.f4977a.containsKey(bVar2.f()) && this.f4979b.f4977a.get(bVar2.f()) != null) {
                    ((b) this.f4979b.f4977a.get(bVar2.f())).b(true);
                }
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.g(), 3, this.f4978a);
                bVar3.reqSuccessful(bVar2);
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4978a;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4980c;
            if ((!this.f4979b.f4977a.containsKey(bVar.f()) || this.f4979b.f4977a.get(bVar.f()) == null || ((b) this.f4979b.f4977a.get(bVar.f())).a()) && bVar.y()) {
                if (this.f4979b.f4977a.containsKey(bVar.f()) && this.f4979b.f4977a.get(bVar.f()) != null) {
                    ((b) this.f4979b.f4977a.get(bVar.f())).b(true);
                }
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 3, this.f4978a);
                bVar2.reqSuccessful(bVar);
            }
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        this.f4977a.put(bVar.f(), new b());
        a aVar = new a(bVar, this, bVar2);
        try {
            new com.mbridge.msdk.newreward.a.b.d().a(bVar, aVar);
        } catch (IOException e) {
            aVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e.getMessage()));
        }
        for (com.mbridge.msdk.newreward.function.c.a.a aVar2 : bVar.u()) {
            a aVar3 = new a(bVar, this, bVar2);
            try {
                new n().a(aVar2, aVar3);
            } catch (IOException e3) {
                aVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e3.getMessage()));
            }
            a aVar4 = new a(bVar, this, bVar2);
            try {
                new com.mbridge.msdk.newreward.a.b.e().a(aVar2, aVar4);
            } catch (IOException e7) {
                aVar4.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e7.getMessage()));
            }
            a aVar5 = new a(bVar, this, bVar2);
            try {
                new com.mbridge.msdk.newreward.a.b.f().a(aVar2, aVar5);
            } catch (IOException e10) {
                aVar5.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e10.getMessage()));
            }
            a aVar6 = new a(bVar, this, bVar2);
            try {
                new h().a(aVar2, aVar6);
            } catch (IOException e11) {
                aVar6.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e11.getMessage()));
            }
            a aVar7 = new a(bVar, this, bVar2);
            try {
                new j().a(aVar2, aVar7);
            } catch (IOException e12) {
                aVar7.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e12.getMessage()));
            }
            a aVar8 = new a(bVar, this, bVar2);
            try {
                new g().a(aVar2, aVar8);
            } catch (IOException e13) {
                aVar8.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e13.getMessage()));
            }
            a aVar9 = new a(bVar, this, bVar2);
            try {
                new k().a(aVar2, aVar9);
            } catch (IOException e14) {
                aVar9.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e14.getMessage()));
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f4981a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f4982b;

        private b() {
            this.f4981a = false;
            this.f4982b = false;
        }

        public final boolean a() {
            return (this.f4981a || this.f4982b) ? false : true;
        }

        public final void b(boolean z9) {
            this.f4981a = z9;
        }

        public final void a(boolean z9) {
            this.f4982b = z9;
        }
    }
}
