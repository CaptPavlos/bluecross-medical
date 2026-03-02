package com.uptodown.core.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.inputmethod.a;
import o4.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ConfirmationIntentWrapperActivity extends AppCompatActivity {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f6662c = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6663a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityResultLauncher f6664b;

    public ConfirmationIntentWrapperActivity() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 22));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f6664b = activityResultLauncherRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        intent.getClass();
        try {
            this.f6664b.launch((Intent) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent", Intent.class) : intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent")));
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (!this.f6663a) {
            b.f11717p = null;
        }
        super.onDestroy();
    }
}
