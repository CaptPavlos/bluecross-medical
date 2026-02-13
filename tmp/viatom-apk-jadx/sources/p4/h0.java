package p4;

import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public InstallerActivity f11963a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.x f11964b;

    /* renamed from: c, reason: collision with root package name */
    public int f11965c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f11966d;
    public final /* synthetic */ InstallerActivity e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(InstallerActivity installerActivity, y6.c cVar) {
        super(cVar);
        this.e = installerActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f11966d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.Q(0, this);
    }
}
