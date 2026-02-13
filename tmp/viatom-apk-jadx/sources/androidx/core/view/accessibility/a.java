package androidx.core.view.accessibility;

import android.view.contentcapture.ContentCaptureSession;
import androidx.fragment.app.Fragment;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ContentCaptureSession a(Object obj) {
        return (ContentCaptureSession) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(int i10, int i11) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i10) + ((Object) " at index ") + i11);
    }

    public static /* synthetic */ void e(int i10, int i11, Object obj, String str) {
        throw new IllegalArgumentException(str + i10 + obj + i11);
    }

    public static /* synthetic */ void f(int i10, String str) {
        throw new IllegalArgumentException(str + i10);
    }

    public static /* synthetic */ void h(Fragment fragment, String str) {
        throw new IllegalStateException(str + ((Object) fragment.toString()) + ((Object) " is already attached to a FragmentManager."));
    }

    public static /* synthetic */ void i(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void j(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void k(String str, int i10, Object obj, int i11, Object obj2) {
        throw new IllegalStateException(str + i10 + obj + i11 + obj2);
    }

    public static /* synthetic */ void l(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void n(String str, Object obj, Throwable th) {
        throw new RuntimeException(str + obj, th);
    }

    public static /* synthetic */ void o(String str, Object[] objArr) {
        throw new ArrayIndexOutOfBoundsException(String.format(str, objArr));
    }

    public static /* synthetic */ void q(Object obj, String str, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void r(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static /* synthetic */ void s(Object obj, String str, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void t(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }
}
