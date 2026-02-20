package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import g7.p;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        fragment.getClass();
        str.getClass();
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        fragment.getClass();
        str.getClass();
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        fragment.getClass();
        str.getClass();
        bundle.getClass();
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final p pVar) {
        fragment.getClass();
        str.getClass();
        pVar.getClass();
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String str2, @NonNull Bundle bundle) {
                str2.getClass();
                bundle.getClass();
                pVar.invoke(str2, bundle).getClass();
            }
        });
    }
}
