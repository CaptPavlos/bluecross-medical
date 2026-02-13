package l4;

import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.LanguageSettingsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f10419a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(LanguageSettingsActivity languageSettingsActivity, w6.c cVar) {
        super(2, cVar);
        this.f10419a = languageSettingsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new g1(this.f10419a, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        g1 g1Var = (g1) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        g1Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        s6.a.e(obj);
        int i10 = LanguageSettingsActivity.L;
        LanguageSettingsActivity languageSettingsActivity = this.f10419a;
        RecyclerView recyclerView = languageSettingsActivity.o0().f7382c;
        n4.o oVar = languageSettingsActivity.H;
        if (oVar == null) {
            kotlin.jvm.internal.l.i("adapter");
            throw null;
        }
        recyclerView.setAdapter(oVar);
        languageSettingsActivity.o0().f7381b.setVisibility(8);
        return s6.w.f12711a;
    }
}
