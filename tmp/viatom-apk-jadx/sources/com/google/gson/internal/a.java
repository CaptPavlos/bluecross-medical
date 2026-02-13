package com.google.gson.internal;

import a3.z0;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.datatransport.TransportRegistrar;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import z1.n2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements m, m.e, q1.d, OnApplyWindowInsetsListener, ActivityResultCallback, m.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2473a;

    public /* synthetic */ a(int i10) {
        this.f2473a = i10;
    }

    public static /* synthetic */ void b() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void e(int i10, String str) throws ParserException {
        throw new ParserException(str + i10);
    }

    public static /* synthetic */ void f(int i10, StringBuilder sb) {
        sb.append(i10);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void i(String str) throws ParserException {
        throw new ParserException(str);
    }

    public static /* synthetic */ void j(Throwable th) {
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void k() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void l(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void n(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void o(String str) {
        throw new NoSuchElementException(str);
    }

    @Override // m.e
    public Object apply(Object obj) {
        d2.a.f6788b.getClass();
        return a2.b.f21a.w((n2) obj).getBytes(Charset.forName(C.UTF8_NAME));
    }

    @Override // q1.d
    public Object c(z0 z0Var) {
        switch (this.f2473a) {
            case 9:
                return TransportRegistrar.lambda$getComponents$0(z0Var);
            case 10:
                return TransportRegistrar.lambda$getComponents$1(z0Var);
            default:
                return TransportRegistrar.lambda$getComponents$2(z0Var);
        }
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        switch (this.f2473a) {
            case 0:
                return new LinkedHashSet();
            case 1:
                return new TreeSet();
            default:
                return new ArrayDeque();
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        switch (this.f2473a) {
            case 19:
                int i10 = RecommendedActivity.Z;
                activityResult.getResultCode();
                break;
            default:
                int i11 = WishlistActivity.Z;
                activityResult.getResultCode();
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f2473a) {
            case 18:
                view.getClass();
                windowInsetsCompat.getClass();
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                insets.getClass();
                view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
                return windowInsetsCompat;
            case 21:
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                insets2.getClass();
                view.getClass();
                view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
                return windowInsetsCompat;
            default:
                int i10 = FileExplorerActivity.f6665q0;
                view.getClass();
                windowInsetsCompat.getClass();
                Insets insets3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                insets3.getClass();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    androidx.window.layout.c.k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    return null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = insets3.left;
                marginLayoutParams.bottomMargin = insets3.bottom;
                marginLayoutParams.rightMargin = insets3.right;
                marginLayoutParams.topMargin = insets3.top;
                view.setLayoutParams(marginLayoutParams);
                return WindowInsetsCompat.CONSUMED;
        }
    }

    @Override // m.g
    public void a(Exception exc) {
    }
}
