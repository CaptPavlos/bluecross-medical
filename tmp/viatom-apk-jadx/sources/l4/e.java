package l4;

import com.uptodown.activities.AppFilesActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppFilesActivity f10342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10343b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AppFilesActivity appFilesActivity, ArrayList arrayList, w6.c cVar) {
        super(2, cVar);
        this.f10342a = appFilesActivity;
        this.f10343b = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new e(this.f10342a, this.f10343b, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        e eVar = (e) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        eVar.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        s6.a.e(obj);
        int i10 = AppFilesActivity.L;
        AppFilesActivity appFilesActivity = this.f10342a;
        appFilesActivity.o0().f6961d.setAdapter(new n4.a(this.f10343b, appFilesActivity.K));
        appFilesActivity.o0().f6960c.setVisibility(8);
        return s6.w.f12711a;
    }
}
