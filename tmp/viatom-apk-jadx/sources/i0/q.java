package i0;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8939a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f8940b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8941c;

    public /* synthetic */ q(Intent intent, Object obj, int i10) {
        this.f8939a = i10;
        this.f8940b = intent;
        this.f8941c = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [h0.f, java.lang.Object] */
    public final void a() {
        switch (this.f8939a) {
            case 0:
                Intent intent = this.f8940b;
                if (intent != null) {
                    ((GoogleApiActivity) this.f8941c).startActivityForResult(intent, 2);
                    break;
                }
                break;
            default:
                Intent intent2 = this.f8940b;
                if (intent2 != null) {
                    this.f8941c.a(intent2, 2);
                    break;
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
