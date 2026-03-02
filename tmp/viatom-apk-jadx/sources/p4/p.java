package p4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public FileExplorerActivity f12005a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12006b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f12007c;

    /* renamed from: d, reason: collision with root package name */
    public int f12008d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FileExplorerActivity fileExplorerActivity, y6.c cVar) {
        super(cVar);
        this.f12007c = fileExplorerActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12006b = obj;
        this.f12008d |= Integer.MIN_VALUE;
        return FileExplorerActivity.M(this.f12007c, this);
    }
}
