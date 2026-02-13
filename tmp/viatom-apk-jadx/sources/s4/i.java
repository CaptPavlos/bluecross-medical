package s4;

import androidx.documentfile.provider.DocumentFile;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12574a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocumentFile f12575b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f12576c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(DocumentFile documentFile, n nVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12574a = i10;
        this.f12575b = documentFile;
        this.f12576c = nVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12574a) {
            case 0:
                return new i(this.f12575b, this.f12576c, cVar, 0);
            case 1:
                return new i(this.f12575b, this.f12576c, cVar, 1);
            case 2:
                return new i(this.f12576c, this.f12575b, cVar, 2);
            default:
                return new i(this.f12576c, this.f12575b, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12574a) {
            case 0:
                i iVar = (i) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                iVar.invokeSuspend(wVar2);
                break;
            case 1:
                i iVar2 = (i) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                iVar2.invokeSuspend(wVar3);
                break;
        }
        return ((i) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        t4.a aVar;
        t4.a aVar2;
        switch (this.f12574a) {
            case 0:
                s6.a.e(obj);
                DocumentFile documentFile = this.f12575b;
                if (documentFile != null && (aVar = this.f12576c.f12596c) != null) {
                    aVar.J(documentFile);
                }
                break;
            case 1:
                s6.a.e(obj);
                DocumentFile documentFile2 = this.f12575b;
                if (documentFile2 != null && (aVar2 = this.f12576c.f12596c) != null) {
                    aVar2.J(documentFile2);
                }
                break;
            case 2:
                s6.a.e(obj);
                t4.a aVar3 = this.f12576c.f12596c;
                if (aVar3 != null) {
                    aVar3.v(this.f12575b);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.a aVar4 = this.f12576c.f12596c;
                if (aVar4 != null) {
                    aVar4.k(this.f12575b);
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(n nVar, DocumentFile documentFile, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12574a = i10;
        this.f12576c = nVar;
        this.f12575b = documentFile;
    }
}
