package p4;

import android.net.Uri;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public InstallerActivity f11953a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f11954b;

    /* renamed from: c, reason: collision with root package name */
    public String f11955c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f11956d;
    public final /* synthetic */ InstallerActivity e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(InstallerActivity installerActivity, y6.c cVar) {
        super(cVar);
        this.e = installerActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f11956d = obj;
        this.f |= Integer.MIN_VALUE;
        return InstallerActivity.E(this.e, null, null, this);
    }
}
