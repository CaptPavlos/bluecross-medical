package j4;

import android.content.Context;
import android.net.Uri;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends i {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f10006d = {"orientation"};

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10007c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Context context, int i10) {
        super(context, 0);
        this.f10007c = i10;
    }

    @Override // j4.i, j4.f0
    public final boolean b(c0 c0Var) {
        switch (this.f10007c) {
            case 0:
                Uri uri = (Uri) c0Var.f9925b;
                return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
            default:
                return "file".equals(((Uri) c0Var.f9925b).getScheme());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[PHI: r3
      0x0069: PHI (r3v14 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v15 android.database.Cursor) binds: [B:25:0x0078, B:16:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0133  */
    @Override // j4.i, j4.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j4.e0 e(j4.c0 r21, int r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.u.e(j4.c0, int):j4.e0");
    }
}
