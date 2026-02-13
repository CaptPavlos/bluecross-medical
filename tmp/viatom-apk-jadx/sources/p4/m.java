package p4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11991a;

    /* renamed from: b, reason: collision with root package name */
    public int f11992b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11993c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FileExplorerActivity fileExplorerActivity, int i10, w6.c cVar) {
        super(2, cVar);
        this.f11991a = 3;
        this.f11993c = fileExplorerActivity;
        this.f11992b = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11991a) {
            case 0:
                return new m(this.f11993c, cVar, 0);
            case 1:
                return new m(this.f11993c, cVar, 1);
            case 2:
                return new m(this.f11993c, cVar, 2);
            case 3:
                return new m(this.f11993c, this.f11992b, cVar);
            default:
                return new m(this.f11993c, cVar, 4);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11991a) {
            case 0:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 1:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 2:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            case 3:
                m mVar = (m) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                mVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                return ((m) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f11991a;
        s6.w wVar = s6.w.f12711a;
        FileExplorerActivity fileExplorerActivity = this.f11993c;
        x6.a aVar = x6.a.f13718a;
        switch (i10) {
            case 0:
                int i11 = this.f11992b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f11992b = 1;
                    if (FileExplorerActivity.K(fileExplorerActivity, this) == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 1:
                int i12 = this.f11992b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f11992b = 1;
                    if (FileExplorerActivity.M(fileExplorerActivity, this) == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 2:
                int i13 = this.f11992b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    this.f11992b = 1;
                    if (FileExplorerActivity.N(fileExplorerActivity, this) == aVar) {
                        break;
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 3:
                s6.a.e(obj);
                r4.b bVar = fileExplorerActivity.M;
                bVar.getClass();
                bVar.notifyItemRemoved(this.f11992b);
                break;
            default:
                int i14 = this.f11992b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    this.f11992b = 1;
                    if (FileExplorerActivity.Q(fileExplorerActivity, this) == aVar) {
                        break;
                    }
                } else if (i14 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
        }
        return wVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(FileExplorerActivity fileExplorerActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11991a = i10;
        this.f11993c = fileExplorerActivity;
    }
}
