package x5;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13712a;

    public j(int i10) {
        this.f13712a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        Context context = view.getContext();
        context.getClass();
        String string = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("Language")) {
                string = sharedPreferences.getString("Language", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean zA = kotlin.jvm.internal.l.a(string, "ar");
        int i10 = this.f13712a;
        if (zA) {
            rect.right = i10;
            rect.left = 0;
            if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
                rect.left = i10;
                return;
            }
            return;
        }
        rect.left = i10;
        rect.right = 0;
        if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
            rect.right = i10;
        }
    }
}
