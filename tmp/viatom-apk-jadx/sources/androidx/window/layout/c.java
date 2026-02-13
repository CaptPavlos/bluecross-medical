package androidx.window.layout;

import android.text.Editable;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.ListenableWorker;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.internal.measurement.u6;
import com.google.android.gms.internal.measurement.w5;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.e;
import com.google.gson.internal.l;
import com.google.gson.internal.m;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements CallbackToFutureAdapter.Resolver, Function, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f659a;

    public /* synthetic */ c(int i10) {
        this.f659a = i10;
    }

    public static /* synthetic */ void b() {
        throw new u6();
    }

    public static /* synthetic */ void c(int i10, int i11) {
        StringBuilder sb = new StringBuilder(i10);
        sb.append((Object) "serialized size must be non-negative, was ");
        sb.append(i11);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void e(int i10, Object obj, int i11, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(i10);
        sb.append((Object) " parameters found ");
        sb.append(i11);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void f(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void g(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void h(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void k(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void l(Object obj, String str) {
        throw new e(str + ((Object) obj.toString()));
    }

    public static /* synthetic */ void m(String str) throws w5 {
        throw new w5(str);
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ListenableWorker.lambda$getForegroundInfoAsync$0(completer);
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        switch (this.f659a) {
            case 24:
                return new l(true);
            case 25:
                return new LinkedHashMap();
            case 26:
                return new TreeMap();
            case 27:
                return new ConcurrentHashMap();
            case 28:
                return new ConcurrentSkipListMap();
            default:
                return new ArrayList();
        }
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }
}
