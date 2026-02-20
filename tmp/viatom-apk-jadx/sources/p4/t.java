package p4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public FileExplorerActivity f12015a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12016b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f12017c;

    /* renamed from: d, reason: collision with root package name */
    public int f12018d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(FileExplorerActivity fileExplorerActivity, y6.c cVar) {
        super(cVar);
        this.f12017c = fileExplorerActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12016b = obj;
        this.f12018d |= Integer.MIN_VALUE;
        return FileExplorerActivity.Q(this.f12017c, this);
    }
}
