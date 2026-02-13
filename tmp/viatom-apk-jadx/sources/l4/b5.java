package l4;

import com.uptodown.activities.NotificationsRegistryActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b5 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f10246a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10247b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f10248c;

    /* renamed from: d, reason: collision with root package name */
    public int f10249d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(NotificationsRegistryActivity notificationsRegistryActivity, y6.c cVar) {
        super(cVar);
        this.f10248c = notificationsRegistryActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10247b = obj;
        this.f10249d |= Integer.MIN_VALUE;
        return NotificationsRegistryActivity.o0(this.f10248c, 0, this);
    }
}
