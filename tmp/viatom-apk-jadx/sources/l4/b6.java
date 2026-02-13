package l4;

import com.uptodown.activities.PasswordRecoveryActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b6 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.v f10250a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.x f10251b;

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.x f10252c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.x f10253d;
    public /* synthetic */ Object e;
    public final /* synthetic */ PasswordRecoveryActivity f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b6(PasswordRecoveryActivity passwordRecoveryActivity, y6.c cVar) {
        super(cVar);
        this.f = passwordRecoveryActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return PasswordRecoveryActivity.n0(this.f, this);
    }
}
