package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends y6.h implements g7.p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, w6.c cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // g7.p
    public final Object invoke(n7.h hVar, w6.c cVar) {
        return ((ViewKt$allViews$1) create(hVar, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i10 = this.label;
        Object obj3 = x6.a.f13718a;
        if (i10 == 0) {
            s6.a.e(obj);
            n7.h hVar = (n7.h) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = hVar;
            this.label = 1;
            hVar.a(view, this);
            return obj3;
        }
        Object obj4 = w.f12711a;
        if (i10 != 1) {
            if (i10 == 2) {
                s6.a.e(obj);
                return obj4;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n7.h hVar2 = (n7.h) this.L$0;
        s6.a.e(obj);
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            n7.f descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            hVar2.getClass();
            Iterator it = descendants.iterator();
            n7.g gVar = (n7.g) hVar2;
            if (it.hasNext()) {
                gVar.f11582c = it;
                gVar.f11580a = 2;
                gVar.f11583d = this;
                obj2 = obj3;
            } else {
                obj2 = obj4;
            }
            if (obj2 != obj3) {
                obj2 = obj4;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return obj4;
    }
}
