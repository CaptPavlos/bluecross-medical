package z5;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g7.p;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14444a;

    /* renamed from: b, reason: collision with root package name */
    public final View f14445b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f14446c;

    /* renamed from: d, reason: collision with root package name */
    public final p f14447d;

    public n(Context context, View view, HashMap map, p pVar) {
        this.f14444a = context;
        this.f14445b = view;
        this.f14446c = map;
        this.f14447d = pVar;
    }

    public final void a() {
        Context context = this.f14444a;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.uptodown_dropdown_menu, (ViewGroup) null, false);
        if (((RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.recycler_view)) == null) {
            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.recycler_view)));
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) viewInflate;
        linearLayout.getClass();
        View view = this.f14445b;
        boolean z9 = true;
        PopupWindow popupWindow = new PopupWindow((View) linearLayout, view.getWidth(), -2, true);
        float f = UptodownApp.E;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            float f10 = UptodownApp.E;
            linearLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.show_dropdown_menu));
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(0);
        }
        View viewFindViewById = linearLayout.findViewById(R.id.recycler_view);
        viewFindViewById.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        m mVar = new m(this.f14446c, new j(this, popupWindow));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mVar);
        popupWindow.setElevation(10.0f);
        popupWindow.showAsDropDown(view);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: z5.k
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Context context2 = this.f14439a.f14444a;
                float f11 = UptodownApp.E;
                boolean z10 = true;
                try {
                    SharedPreferences sharedPreferences2 = context2.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences2.contains("animations")) {
                        z10 = sharedPreferences2.getBoolean("animations", true);
                    }
                } catch (Exception unused2) {
                }
                LinearLayout linearLayout2 = linearLayout;
                if (!z10) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                float f12 = UptodownApp.E;
                linearLayout2.startAnimation(AnimationUtils.loadAnimation(context2, R.anim.hide_dropdown_menu));
                linearLayout2.setVisibility(8);
            }
        });
    }
}
