package l4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10941a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f10942b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10943c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10944d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(MainActivity mainActivity, kotlin.jvm.internal.x xVar, int i10, int i11, w6.c cVar) {
        super(2, cVar);
        this.f10944d = mainActivity;
        this.e = xVar;
        this.f10942b = i10;
        this.f10943c = i11;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10941a) {
            case 0:
                return new w2((MainActivity) this.f10944d, (kotlin.jvm.internal.x) this.e, this.f10942b, this.f10943c, cVar);
            case 1:
                return new w2((MyDownloads) this.e, this.f10943c, cVar);
            default:
                return new w2(this.f10943c, (SearchActivity) this.f10944d, (String) this.e, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10941a) {
        }
        return ((w2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        ImageView imageView;
        h5.q qVar;
        Object objZ;
        int i10 = this.f10941a;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        Object obj2 = this.e;
        int i11 = this.f10943c;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                MainActivity mainActivity = (MainActivity) this.f10944d;
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) obj2;
                Drawable drawable = (Drawable) xVar.f10138a;
                int i12 = this.f10942b + i11;
                boolean z9 = i12 > 0;
                int i13 = MainActivity.B0;
                if (!mainActivity.isFinishing() && (imageView = mainActivity.f6648s0) != null) {
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                    }
                    ImageView imageView2 = mainActivity.f6649t0;
                    if (z9) {
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                    } else if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                }
                e5.m1 m1Var = mainActivity.l0;
                if (m1Var == null) {
                    break;
                } else {
                    Drawable drawable2 = (Drawable) xVar.f10138a;
                    boolean z10 = i12 > 0;
                    if (m1Var.isAdded()) {
                        if (drawable2 != null) {
                            m1Var.a().f7210b.setImageDrawable(drawable2);
                        }
                        if (!z10) {
                            m1Var.a().f7211c.setVisibility(8);
                            break;
                        } else {
                            m1Var.a().f7211c.setVisibility(0);
                            break;
                        }
                    }
                }
                break;
            case 1:
                MyDownloads myDownloads = (MyDownloads) obj2;
                int i14 = this.f10942b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    n4.b bVar = myDownloads.J;
                    bVar.getClass();
                    Object obj3 = bVar.f11300b.get(i11);
                    obj3.getClass();
                    qVar = (h5.q) obj3;
                    q4 q4VarQ0 = myDownloads.q0();
                    this.f10944d = qVar;
                    this.f10942b = 1;
                    q4VarQ0.getClass();
                    y7.e eVar = r7.i0.f12407a;
                    objZ = r7.y.z(new a6.j((Object) qVar, (Context) myDownloads, cVar, 29), y7.d.f14116a, this);
                    if (objZ == aVar) {
                    }
                } else if (i14 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    qVar = (h5.q) this.f10944d;
                    s6.a.e(obj);
                    objZ = obj;
                }
                if (((Boolean) objZ).booleanValue()) {
                    n4.b bVar2 = myDownloads.J;
                    bVar2.getClass();
                    bVar2.f11300b.remove(qVar);
                    n4.b bVar3 = myDownloads.J;
                    bVar3.getClass();
                    bVar3.notifyItemRemoved(i11);
                    n4.b bVar4 = myDownloads.J;
                    bVar4.getClass();
                    if (bVar4.f11300b.isEmpty()) {
                        myDownloads.p0().h.setVisibility(0);
                    }
                }
                break;
            default:
                SearchActivity searchActivity = (SearchActivity) this.f10944d;
                int i15 = this.f10942b;
                if (i15 == 0) {
                    s6.a.e(obj);
                    this.f10942b = 1;
                    if (r7.y.h(i11 * 1000, this) == aVar) {
                    }
                } else if (i15 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                int i16 = SearchActivity.Q;
                b9 b9VarP0 = searchActivity.p0();
                String strN0 = SearchActivity.n0(searchActivity, (String) obj2);
                b9VarP0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(b9VarP0);
                y7.e eVar2 = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(b9VarP0, searchActivity, strN0, 0, (w6.c) null), 2);
                break;
        }
        return wVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(int i10, SearchActivity searchActivity, String str, w6.c cVar) {
        super(2, cVar);
        this.f10943c = i10;
        this.f10944d = searchActivity;
        this.e = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(MyDownloads myDownloads, int i10, w6.c cVar) {
        super(2, cVar);
        this.e = myDownloads;
        this.f10943c = i10;
    }
}
