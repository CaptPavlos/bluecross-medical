package l4;

import com.uptodown.activities.AppFilesActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f10309a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10310b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppFilesActivity f10311c;

    /* renamed from: d, reason: collision with root package name */
    public int f10312d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AppFilesActivity appFilesActivity, y6.c cVar) {
        super(cVar);
        this.f10311c = appFilesActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10310b = obj;
        this.f10312d |= Integer.MIN_VALUE;
        return AppFilesActivity.n0(this.f10311c, this);
    }
}
