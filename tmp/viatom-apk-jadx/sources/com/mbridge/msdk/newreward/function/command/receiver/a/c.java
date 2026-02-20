package com.mbridge.msdk.newreward.function.command.receiver.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.a.a f4811a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.receiver.a.a f4812b;

    /* renamed from: c, reason: collision with root package name */
    private b f4813c;

    /* renamed from: d, reason: collision with root package name */
    private d f4814d;
    private boolean e = false;
    private boolean f = false;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b, reason: collision with root package name */
        private final c f4818b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4819c;

        public a(c cVar, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4818b = cVar;
            this.f4819c = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            if (bVar.a() == 1) {
                if (!c.this.f4812b.a() || !c.this.f4813c.a() || this.f4818b.f) {
                    return;
                } else {
                    this.f4818b.f = true;
                }
            }
            this.f4819c.reqFailed(bVar);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void reqSuccessful(Object obj) {
            if (this.f4818b.e) {
                return;
            }
            this.f4818b.e = true;
            this.f4819c.reqSuccessful(obj);
        }
    }

    public c(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f4811a = aVar;
    }

    public final void a(e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        int iC = eVar.c();
        if (iC == 1) {
            if (this.f4812b == null) {
                a();
            }
            this.f4812b.a(eVar, new a(this, bVar));
        } else if (iC == 2) {
            if (this.f4814d == null) {
                this.f4814d = new d();
            }
            this.f4814d.a(eVar, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.command.receiver.a.c.1
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar2) {
                    com.mbridge.msdk.newreward.a.b.b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.reqFailed(bVar2);
                    }
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void reqSuccessful(Object obj) {
                    com.mbridge.msdk.newreward.a.b.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.reqSuccessful(obj);
                    }
                }
            });
        } else {
            if (iC != 3) {
                return;
            }
            if (this.f4813c == null) {
                this.f4813c = new b(this.f4811a);
            }
            this.f4813c.a(eVar, new a(this, bVar));
        }
    }

    private void a() {
        this.f4812b = new com.mbridge.msdk.newreward.function.command.receiver.a.a(this.f4811a);
    }

    public final boolean a(e eVar) {
        if (eVar.c() == 1) {
            if (this.f4812b == null) {
                a();
            }
            return this.f4812b.a(eVar.a(), eVar, eVar.b());
        }
        if (eVar.c() == 2) {
            if (this.f4814d == null) {
                this.f4814d = new d();
            }
            return this.f4814d.a(eVar);
        }
        if (eVar.c() != 3) {
            return false;
        }
        if (this.f4813c == null) {
            this.f4813c = new b(this.f4811a);
        }
        return true;
    }
}
