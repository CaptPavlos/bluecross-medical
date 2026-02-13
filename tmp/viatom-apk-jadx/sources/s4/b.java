package s4;

import c1.g1;
import com.uptodown.R;
import l4.a4;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12538a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g1 f12539b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u4.b f12540c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i10, g1 g1Var, u4.b bVar, w6.c cVar) {
        super(2, cVar);
        this.f12538a = i10;
        this.f12539b = g1Var;
        this.f12540c = bVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12538a) {
            case 0:
                return new b(0, this.f12539b, this.f12540c, cVar);
            case 1:
                return new b(1, this.f12539b, this.f12540c, cVar);
            case 2:
                return new b(2, this.f12539b, this.f12540c, cVar);
            case 3:
                return new b(3, this.f12539b, this.f12540c, cVar);
            default:
                return new b(4, this.f12539b, this.f12540c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12538a) {
            case 0:
                b bVar = (b) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                bVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                b bVar2 = (b) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                bVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                b bVar3 = (b) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                bVar3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                b bVar4 = (b) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                bVar4.invokeSuspend(wVar5);
                return wVar5;
            default:
                b bVar5 = (b) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                bVar5.invokeSuspend(wVar6);
                return wVar6;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12538a) {
            case 0:
                s6.a.e(obj);
                d0.i iVar = (d0.i) this.f12539b.f1232d;
                this.f12540c.getClass();
                a4 a4Var = (a4) iVar.f6781b;
                a4Var.j(a4Var.getString(R.string.backup_no_free_space));
                break;
            case 1:
                s6.a.e(obj);
                d0.i iVar2 = (d0.i) this.f12539b.f1232d;
                this.f12540c.getClass();
                a4 a4Var2 = (a4) iVar2.f6781b;
                a4Var2.j(a4Var2.getString(R.string.backup_no_free_space));
                break;
            case 2:
                s6.a.e(obj);
                d0.i iVar3 = (d0.i) this.f12539b.f1232d;
                this.f12540c.getClass();
                a4 a4Var3 = (a4) iVar3.f6781b;
                a4Var3.j(a4Var3.getString(R.string.core_msg_cannot_write_path));
                break;
            case 3:
                s6.a.e(obj);
                a4 a4Var4 = (a4) ((d0.i) this.f12539b.f1232d).f6781b;
                a4Var4.j(a4Var4.getString(R.string.backup_no_free_space));
                break;
            default:
                s6.a.e(obj);
                a4 a4Var5 = (a4) ((d0.i) this.f12539b.f1232d).f6781b;
                a4Var5.j(a4Var5.getString(R.string.core_msg_cannot_write_path));
                break;
        }
        return s6.w.f12711a;
    }
}
