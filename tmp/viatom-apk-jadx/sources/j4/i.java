package j4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.util.List;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class i extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9977a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f9978b;

    public /* synthetic */ i(Context context, int i10) {
        this.f9977a = i10;
        this.f9978b = context;
    }

    @Override // j4.f0
    public boolean b(c0 c0Var) {
        switch (this.f9977a) {
            case 0:
                return "content".equals(((Uri) c0Var.f9925b).getScheme());
            default:
                if (c0Var.f9926c != 0) {
                    return true;
                }
                return "android.resource".equals(((Uri) c0Var.f9925b).getScheme());
        }
    }

    @Override // j4.f0
    public e0 e(c0 c0Var, int i10) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        Resources resources;
        int i11 = this.f9977a;
        Context context = this.f9978b;
        switch (i11) {
            case 0:
                return new e0(t1.T(context.getContentResolver().openInputStream((Uri) c0Var.f9925b)), 2);
            default:
                StringBuilder sb = l0.f9987a;
                int i12 = c0Var.f9926c;
                Uri uri = (Uri) c0Var.f9925b;
                if (i12 != 0 || uri == null) {
                    resources = context.getResources();
                } else {
                    String authority = uri.getAuthority();
                    if (authority == null) {
                        z8.f.e(uri, "No package provided: ");
                        return null;
                    }
                    try {
                        resources = context.getPackageManager().getResourcesForApplication(authority);
                    } catch (PackageManager.NameNotFoundException unused) {
                        z8.f.e(uri, "Unable to obtain resources for package: ");
                        return null;
                    }
                }
                int identifier = c0Var.f9926c;
                if (identifier == 0 && uri != null) {
                    String authority2 = uri.getAuthority();
                    if (authority2 == null) {
                        z8.f.e(uri, "No package provided: ");
                        return null;
                    }
                    List<String> pathSegments = uri.getPathSegments();
                    if (pathSegments == null || pathSegments.isEmpty()) {
                        z8.f.e(uri, "No path segments: ");
                        return null;
                    }
                    if (pathSegments.size() == 1) {
                        try {
                            identifier = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused2) {
                            z8.f.e(uri, "Last path segment is not a resource ID: ");
                            return null;
                        }
                    } else {
                        if (pathSegments.size() != 2) {
                            z8.f.e(uri, "More than two path segments: ");
                            return null;
                        }
                        identifier = resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                    }
                }
                BitmapFactory.Options optionsC = f0.c(c0Var);
                if (optionsC != null && optionsC.inJustDecodeBounds) {
                    BitmapFactory.decodeResource(resources, identifier, optionsC);
                    f0.a(c0Var.f9927d, c0Var.e, optionsC.outWidth, optionsC.outHeight, optionsC, c0Var);
                }
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, identifier, optionsC);
                if (bitmapDecodeResource != null) {
                    return new e0(bitmapDecodeResource, null, 2, 0);
                }
                androidx.window.layout.c.k("bitmap == null");
                return null;
        }
    }
}
