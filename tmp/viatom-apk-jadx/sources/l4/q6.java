package l4;

import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q6 implements g5.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10764b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v5.m f10765c;

    public /* synthetic */ q6(PublicProfileActivity publicProfileActivity, v5.m mVar, int i10) {
        this.f10763a = i10;
        this.f10764b = publicProfileActivity;
        this.f10765c = mVar;
    }

    @Override // g5.b, g5.p
    public final void a(int i10) {
        switch (this.f10763a) {
            case 0:
                v5.l lVar = (v5.l) this.f10765c;
                this.f10764b.Z(((h5.h) ((y6) lVar.f13168a).f11029a.get(i10)).f8566a, ((h5.h) ((y6) lVar.f13168a).f11029a.get(i10)).e);
                break;
            default:
                v5.l lVar2 = (v5.l) this.f10765c;
                this.f10764b.Z(((h5.h) ((ArrayList) lVar2.f13168a).get(i10)).f8566a, ((h5.h) ((ArrayList) lVar2.f13168a).get(i10)).e);
                break;
        }
    }

    @Override // g5.b, g5.p
    public final void d(int i10) {
        int i11 = this.f10763a;
    }

    private final void b(int i10) {
    }

    private final void c(int i10) {
    }
}
