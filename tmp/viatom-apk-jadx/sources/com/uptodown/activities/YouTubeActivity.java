package com.uptodown.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import d5.j1;
import g4.a;
import i4.i;
import l4.b;
import l4.qc;
import l4.w;
import l4.x2;
import org.json.JSONException;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class YouTubeActivity extends w {
    public static final /* synthetic */ int J = 0;
    public final m H = new m(new x2(this, 24));
    public final b I = new b(this, 7);

    public final j1 n0() {
        return (j1) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws JSONException {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7141a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Window window = getWindow();
        window.getClass();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            window.getDecorView().setSystemUiVisibility(4);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
        getOnBackPressedDispatcher().addCallback(this, this.I);
        Intent intent = getIntent();
        String string = (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("id_youtube")) ? null : extras.getString("id_youtube");
        if (string == null || string.length() == 0) {
            finish();
            return;
        }
        a aVar = new a(this);
        aVar.b(1, "controls");
        aVar.b(1, "fs");
        n0().f7143c.a(new qc(0, this, string), new g4.b(aVar.f8228a));
        n0().f7143c.f6628a.add(new i(this, 1));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        n0().f7143c.b();
    }
}
