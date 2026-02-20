package p4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public FileExplorerActivity f11999a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f12001c;

    /* renamed from: d, reason: collision with root package name */
    public int f12002d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FileExplorerActivity fileExplorerActivity, y6.c cVar) {
        super(cVar);
        this.f12001c = fileExplorerActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12000b = obj;
        this.f12002d |= Integer.MIN_VALUE;
        return FileExplorerActivity.K(this.f12001c, this);
    }
}
