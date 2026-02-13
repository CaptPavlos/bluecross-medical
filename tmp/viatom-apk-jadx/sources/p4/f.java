package p4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c1.w4;
import com.uptodown.R;
import java.io.File;
import java.util.regex.Pattern;
import l4.a4;
import l4.r3;
import l4.u4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public AlertDialog f11942a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f11943b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f11944c;

    /* renamed from: d, reason: collision with root package name */
    public RadioButton f11945d;
    public RadioButton e;
    public CheckBox f;
    public CheckBox g;
    public TextView h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f11946i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f11947j;

    /* renamed from: k, reason: collision with root package name */
    public String f11948k;

    /* renamed from: l, reason: collision with root package name */
    public final ActivityResultLauncher f11949l;

    /* renamed from: m, reason: collision with root package name */
    public final ActivityResultLauncher f11950m;

    /* renamed from: n, reason: collision with root package name */
    public final ActivityResultLauncher f11951n;

    /* renamed from: o, reason: collision with root package name */
    public final ActivityResultLauncher f11952o;

    public f() {
        final int i10 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: p4.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f11919b;

            {
                this.f11919b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                boolean zMatches;
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i10) {
                    case 0:
                        f fVar = this.f11919b;
                        if (fVar.n()) {
                            fVar.w();
                            return;
                        } else {
                            fVar.u();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            f fVar2 = this.f11919b;
                            if (data2 == null) {
                                fVar2.r();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer numValueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (numValueOf != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = fVar2.getContentResolver();
                            numValueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, numValueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                patternCompile.getClass();
                                zMatches = patternCompile.matcher(path).matches();
                            } else {
                                zMatches = false;
                            }
                            if (zMatches) {
                                fVar2.s();
                                return;
                            } else {
                                fVar2.t();
                                return;
                            }
                        }
                        return;
                    case 2:
                        this.f11919b.y();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            String string = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            f fVar3 = this.f11919b;
                            fVar3.f11948k = string;
                            Intent data5 = activityResult.getData();
                            fVar3.f11947j = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (fVar3.f11948k != null) {
                                String str = fVar3.f11948k;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = fVar3.h;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(fVar3.f11948k);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = fVar3.f11946i;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = fVar3.f11946i;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = fVar3.f11946i;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            fVar3.f11947j = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            fVar3.f11948k = lastPathSegment != null ? lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1) : null;
                            boolean zA = kotlin.jvm.internal.l.a(fVar3.f11947j, Boolean.TRUE);
                            TextView textView5 = fVar3.h;
                            if (zA) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.sd_card) + '/' + fVar3.f11948k);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.internal_storage) + '/' + fVar3.f11948k);
                            }
                            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(fVar3, data7);
                            if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists() && documentFileFromSingleUri.isDirectory() && documentFileFromSingleUri.canWrite()) {
                                TextView textView6 = fVar3.f11946i;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = fVar3.f11946i;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f11949l = activityResultLauncherRegisterForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: p4.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f11919b;

            {
                this.f11919b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                boolean zMatches;
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i11) {
                    case 0:
                        f fVar = this.f11919b;
                        if (fVar.n()) {
                            fVar.w();
                            return;
                        } else {
                            fVar.u();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            f fVar2 = this.f11919b;
                            if (data2 == null) {
                                fVar2.r();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer numValueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (numValueOf != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = fVar2.getContentResolver();
                            numValueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, numValueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                patternCompile.getClass();
                                zMatches = patternCompile.matcher(path).matches();
                            } else {
                                zMatches = false;
                            }
                            if (zMatches) {
                                fVar2.s();
                                return;
                            } else {
                                fVar2.t();
                                return;
                            }
                        }
                        return;
                    case 2:
                        this.f11919b.y();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            String string = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            f fVar3 = this.f11919b;
                            fVar3.f11948k = string;
                            Intent data5 = activityResult.getData();
                            fVar3.f11947j = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (fVar3.f11948k != null) {
                                String str = fVar3.f11948k;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = fVar3.h;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(fVar3.f11948k);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = fVar3.f11946i;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = fVar3.f11946i;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = fVar3.f11946i;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            fVar3.f11947j = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            fVar3.f11948k = lastPathSegment != null ? lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1) : null;
                            boolean zA = kotlin.jvm.internal.l.a(fVar3.f11947j, Boolean.TRUE);
                            TextView textView5 = fVar3.h;
                            if (zA) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.sd_card) + '/' + fVar3.f11948k);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.internal_storage) + '/' + fVar3.f11948k);
                            }
                            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(fVar3, data7);
                            if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists() && documentFileFromSingleUri.isDirectory() && documentFileFromSingleUri.canWrite()) {
                                TextView textView6 = fVar3.f11946i;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = fVar3.f11946i;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.f11950m = activityResultLauncherRegisterForActivityResult2;
        final int i12 = 2;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: p4.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f11919b;

            {
                this.f11919b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                boolean zMatches;
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i12) {
                    case 0:
                        f fVar = this.f11919b;
                        if (fVar.n()) {
                            fVar.w();
                            return;
                        } else {
                            fVar.u();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            f fVar2 = this.f11919b;
                            if (data2 == null) {
                                fVar2.r();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer numValueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (numValueOf != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = fVar2.getContentResolver();
                            numValueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, numValueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                patternCompile.getClass();
                                zMatches = patternCompile.matcher(path).matches();
                            } else {
                                zMatches = false;
                            }
                            if (zMatches) {
                                fVar2.s();
                                return;
                            } else {
                                fVar2.t();
                                return;
                            }
                        }
                        return;
                    case 2:
                        this.f11919b.y();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            String string = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            f fVar3 = this.f11919b;
                            fVar3.f11948k = string;
                            Intent data5 = activityResult.getData();
                            fVar3.f11947j = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (fVar3.f11948k != null) {
                                String str = fVar3.f11948k;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = fVar3.h;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(fVar3.f11948k);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = fVar3.f11946i;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = fVar3.f11946i;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = fVar3.f11946i;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            fVar3.f11947j = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            fVar3.f11948k = lastPathSegment != null ? lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1) : null;
                            boolean zA = kotlin.jvm.internal.l.a(fVar3.f11947j, Boolean.TRUE);
                            TextView textView5 = fVar3.h;
                            if (zA) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.sd_card) + '/' + fVar3.f11948k);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.internal_storage) + '/' + fVar3.f11948k);
                            }
                            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(fVar3, data7);
                            if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists() && documentFileFromSingleUri.isDirectory() && documentFileFromSingleUri.canWrite()) {
                                TextView textView6 = fVar3.f11946i;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = fVar3.f11946i;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult3.getClass();
        this.f11951n = activityResultLauncherRegisterForActivityResult3;
        final int i13 = 3;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: p4.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f11919b;

            {
                this.f11919b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                boolean zMatches;
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i13) {
                    case 0:
                        f fVar = this.f11919b;
                        if (fVar.n()) {
                            fVar.w();
                            return;
                        } else {
                            fVar.u();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            f fVar2 = this.f11919b;
                            if (data2 == null) {
                                fVar2.r();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer numValueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (numValueOf != null) {
                                numValueOf = Integer.valueOf(numValueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = fVar2.getContentResolver();
                            numValueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, numValueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                patternCompile.getClass();
                                zMatches = patternCompile.matcher(path).matches();
                            } else {
                                zMatches = false;
                            }
                            if (zMatches) {
                                fVar2.s();
                                return;
                            } else {
                                fVar2.t();
                                return;
                            }
                        }
                        return;
                    case 2:
                        this.f11919b.y();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            String string = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            f fVar3 = this.f11919b;
                            fVar3.f11948k = string;
                            Intent data5 = activityResult.getData();
                            fVar3.f11947j = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (fVar3.f11948k != null) {
                                String str = fVar3.f11948k;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = fVar3.h;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(fVar3.f11948k);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = fVar3.f11946i;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = fVar3.f11946i;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = fVar3.f11946i;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            fVar3.f11947j = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            fVar3.f11948k = lastPathSegment != null ? lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1) : null;
                            boolean zA = kotlin.jvm.internal.l.a(fVar3.f11947j, Boolean.TRUE);
                            TextView textView5 = fVar3.h;
                            if (zA) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.sd_card) + '/' + fVar3.f11948k);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(fVar3.getString(R.string.internal_storage) + '/' + fVar3.f11948k);
                            }
                            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(fVar3, data7);
                            if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists() && documentFileFromSingleUri.isDirectory() && documentFileFromSingleUri.canWrite()) {
                                TextView textView6 = fVar3.f11946i;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = fVar3.f11946i;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        activityResultLauncherRegisterForActivityResult4.getClass();
        this.f11952o = activityResultLauncherRegisterForActivityResult4;
    }

    public final void A() {
        try {
            int i10 = Build.VERSION.SDK_INT;
            ActivityResultLauncher activityResultLauncher = this.f11951n;
            if (i10 < 26) {
                activityResultLauncher.launch(new Intent("android.settings.SECURITY_SETTINGS"));
                return;
            }
            activityResultLauncher.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final void B() {
        if (Build.VERSION.SDK_INT < 30) {
            if (m()) {
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        } else {
            if (Environment.isExternalStorageManager()) {
                if (m()) {
                    return;
                }
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
                return;
            }
            try {
                this.f11949l.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + getPackageName())));
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
            }
        }
    }

    public final void C(String str) {
        str.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new u4(this, str, null, 17), 2);
    }

    public final void D(String str, String str2, long j10, String str3, boolean z9) {
        String strC;
        String str4;
        long jD;
        RadioButton radioButton = this.f11944c;
        if (radioButton == null) {
            kotlin.jvm.internal.l.i("rbAppName");
            throw null;
        }
        if (!radioButton.isChecked()) {
            str = str2 != null ? str2 : getPackageName();
        } else if (str == null) {
            str = getString(R.string.app_name);
            str.getClass();
        }
        CheckBox checkBox = this.f;
        if (checkBox == null) {
            kotlin.jvm.internal.l.i("cbVersioncode");
            throw null;
        }
        if (checkBox.isChecked()) {
            if (j10 > -1) {
                str = str + '_' + j10;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append('_');
                try {
                    PackageManager packageManager = getPackageManager();
                    packageManager.getClass();
                    String packageName = getPackageName();
                    packageName.getClass();
                    jD = x4.d.d(l5.a.f(packageManager, packageName, 0));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    jD = 0;
                }
                sb.append(jD);
                str = sb.toString();
            }
        }
        CheckBox checkBox2 = this.g;
        if (checkBox2 == null) {
            kotlin.jvm.internal.l.i("cbVersionname");
            throw null;
        }
        if (checkBox2.isChecked()) {
            if (str3 != null) {
                str = str + '_' + str3;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('_');
                try {
                    PackageManager packageManager2 = getPackageManager();
                    packageManager2.getClass();
                    String packageName2 = getPackageName();
                    packageName2.getClass();
                    str4 = l5.a.f(packageManager2, packageName2, 0).versionName;
                } catch (PackageManager.NameNotFoundException e3) {
                    e3.printStackTrace();
                    str4 = null;
                }
                sb2.append(str4);
                str = sb2.toString();
            }
        }
        if (z9) {
            RadioButton radioButton2 = this.e;
            if (radioButton2 == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            strC = radioButton2.isChecked() ? a3.a.C(str, ".xapk") : a3.a.C(str, ".apks");
        } else {
            strC = a3.a.C(str, ".apk");
        }
        TextView textView = this.f11943b;
        if (textView != null) {
            textView.setText(strC);
        } else {
            kotlin.jvm.internal.l.i("tvResult");
            throw null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = o4.b.g;
            context = r0.f.h(context);
        }
        super.attachBaseContext(context);
    }

    public final void i(final String str, final String str2, final long j10, final String str3, final boolean z9) {
        Window window;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        AlertDialog alertDialog = this.f11942a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_path, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.tv_title_dialog_path)).setTypeface(o4.b.f11719r);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_path_dialog_path);
        this.h = textView;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvPath");
            throw null;
        }
        textView.setTypeface(o4.b.f11720s);
        try {
            sharedPreferences2 = getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences2.contains("sdcard_as_backup_storage") ? sharedPreferences2.getBoolean("sdcard_as_backup_storage", false) : false;
        TextView textView2 = this.h;
        if (z10) {
            if (textView2 == null) {
                kotlin.jvm.internal.l.i("tvPath");
                throw null;
            }
            textView2.setText(getString(R.string.sd_card) + '/' + new w4(this, 3, false).f());
        } else {
            if (textView2 == null) {
                kotlin.jvm.internal.l.i("tvPath");
                throw null;
            }
            textView2.setText(new w4(this, 3, false).f());
        }
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_error_path);
        this.f11946i = textView3;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvErrorPath");
            throw null;
        }
        textView3.setTypeface(o4.b.f11720s);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rl_path_dialog);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new r3((a4) this, 10));
        }
        ((TextView) viewInflate.findViewById(R.id.tv_name_format_dialog_path)).setTypeface(o4.b.f11719r);
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.id.rg_name_format);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.rb_option_appname);
        this.f11944c = radioButton;
        if (radioButton == null) {
            kotlin.jvm.internal.l.i("rbAppName");
            throw null;
        }
        radioButton.setTypeface(o4.b.f11720s);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.rb_option_packagename);
        this.f11945d = radioButton2;
        if (radioButton2 == null) {
            kotlin.jvm.internal.l.i("rbPackagename");
            throw null;
        }
        radioButton2.setTypeface(o4.b.f11720s);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.cb_versioncode);
        this.f = checkBox;
        if (checkBox == null) {
            kotlin.jvm.internal.l.i("cbVersioncode");
            throw null;
        }
        checkBox.setTypeface(o4.b.f11720s);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.cb_versionname);
        this.g = checkBox2;
        if (checkBox2 == null) {
            kotlin.jvm.internal.l.i("cbVersionname");
            throw null;
        }
        checkBox2.setTypeface(o4.b.f11720s);
        w4 w4Var = new w4(this, 3, false);
        RadioButton radioButton3 = this.f11944c;
        if (radioButton3 == null) {
            kotlin.jvm.internal.l.i("rbAppName");
            throw null;
        }
        radioButton3.setChecked(w4Var.g("app_name_included", true));
        RadioButton radioButton4 = this.f11945d;
        if (radioButton4 == null) {
            kotlin.jvm.internal.l.i("rbPackagename");
            throw null;
        }
        radioButton4.setChecked(w4Var.g("packagename_included", false));
        CheckBox checkBox3 = this.f;
        if (checkBox3 == null) {
            kotlin.jvm.internal.l.i("cbVersioncode");
            throw null;
        }
        checkBox3.setChecked(w4Var.g("versioncode_included", true));
        CheckBox checkBox4 = this.g;
        if (checkBox4 == null) {
            kotlin.jvm.internal.l.i("cbVersionname");
            throw null;
        }
        checkBox4.setChecked(w4Var.g("versionname_included", false));
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_extension_dialog_path);
        RadioGroup radioGroup2 = (RadioGroup) viewInflate.findViewById(R.id.rg_extension);
        this.e = (RadioButton) viewInflate.findViewById(R.id.rb_xapk_extension);
        if (z9) {
            textView4.setTypeface(o4.b.f11719r);
            RadioButton radioButton5 = this.e;
            if (radioButton5 == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            radioButton5.setTypeface(o4.b.f11720s);
            RadioButton radioButton6 = this.e;
            if (radioButton6 == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            radioButton6.setText(".xapk");
            View viewFindViewById = viewInflate.findViewById(R.id.rb_apks_extension);
            viewFindViewById.getClass();
            RadioButton radioButton7 = (RadioButton) viewFindViewById;
            radioButton7.setTypeface(o4.b.f11720s);
            radioButton7.setText(".apks");
            try {
                sharedPreferences = getSharedPreferences("CoreSettings", 0);
            } catch (Exception unused2) {
            }
            String string = sharedPreferences.contains("xapk_extension") ? sharedPreferences.getString("xapk_extension", ".xapk") : ".xapk";
            if (string != null && !o7.u.c0(string, ".", false)) {
                string = ".".concat(string);
            }
            RadioButton radioButton8 = this.e;
            if (radioButton8 == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            radioButton8.setChecked(o7.u.Z(string, ".xapk", true));
            if (this.e == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            radioButton7.setChecked(!r1.isChecked());
        } else {
            textView4.setVisibility(8);
            radioGroup2.setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.tv_result_title_dialog_path)).setTypeface(o4.b.f11720s);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_result_dialog_path);
        this.f11943b = textView5;
        if (textView5 == null) {
            kotlin.jvm.internal.l.i("tvResult");
            throw null;
        }
        textView5.setTypeface(o4.b.f11719r);
        D(str, str2, j10, str3, z9);
        CheckBox checkBox5 = this.f;
        if (checkBox5 == null) {
            kotlin.jvm.internal.l.i("cbVersioncode");
            throw null;
        }
        final a4 a4Var = (a4) this;
        final int i10 = 1;
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: p4.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                switch (i10) {
                    case 0:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                    default:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                }
            }
        });
        CheckBox checkBox6 = this.g;
        if (checkBox6 == null) {
            kotlin.jvm.internal.l.i("cbVersionname");
            throw null;
        }
        final int i11 = 0;
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: p4.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                switch (i11) {
                    case 0:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                    default:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: p4.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i12) {
                switch (i11) {
                    case 0:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                    default:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                }
            }
        });
        final int i12 = 1;
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: p4.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i122) {
                switch (i12) {
                    case 0:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                    default:
                        a4Var.D(str, str2, j10, str3, z9);
                        break;
                }
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.tv_ok_dialog_path);
        viewFindViewById2.getClass();
        TextView textView6 = (TextView) viewFindViewById2;
        textView6.setTypeface(o4.b.f11719r);
        textView6.setOnClickListener(new r3(a4Var, 8));
        View viewFindViewById3 = viewInflate.findViewById(R.id.tv_cancel_dialog_path);
        viewFindViewById3.getClass();
        TextView textView7 = (TextView) viewFindViewById3;
        textView7.setTypeface(o4.b.f11719r);
        textView7.setOnClickListener(new r3(a4Var, 9));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        this.f11942a = alertDialogCreate;
        if (alertDialogCreate != null && (window = alertDialogCreate.getWindow()) != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog2 = this.f11942a;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
    }

    public final void j(String str) {
        AlertDialog alertDialog = this.f11942a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_accept, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_accept_msg);
        textView.setTypeface(o4.b.f11720s);
        if (str == null) {
            textView.setText(getString(R.string.error_unknown));
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new d(this, 2));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        this.f11942a = builder.create();
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.f11942a;
        alertDialog2.getClass();
        Window window = alertDialog2.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        AlertDialog alertDialog3 = this.f11942a;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    public final void k() {
        try {
            if (o()) {
                return;
            }
            AlertDialog alertDialog = this.f11942a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_title_accept_cancel, (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_title);
            textView.setTypeface(o4.b.f11719r);
            textView.setText(getString(R.string.title_unknown_source_dialog, getString(R.string.app_name)));
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_dialog_msg);
            textView2.setTypeface(o4.b.f11720s);
            textView2.setText(getString(R.string.msg_install_from_unknown_source, getString(R.string.app_name)));
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
            textView3.setTypeface(o4.b.f11719r);
            textView3.setOnClickListener(new d(this, 0));
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_cancel_option);
            textView4.setTypeface(o4.b.f11719r);
            textView4.setOnClickListener(new d(this, 1));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(viewInflate);
            AlertDialog alertDialogCreate = builder.create();
            this.f11942a = alertDialogCreate;
            alertDialogCreate.getClass();
            Window window = alertDialogCreate.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            if (isFinishing()) {
                return;
            }
            AlertDialog alertDialog2 = this.f11942a;
            alertDialog2.getClass();
            alertDialog2.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean m() {
        return Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean n() {
        return Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : m();
    }

    public final boolean o() {
        return Build.VERSION.SDK_INT < 26 ? Settings.Secure.getInt(getContentResolver(), "install_non_market_apps", 0) == 1 : getPackageManager().canRequestPackageInstalls();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!o4.b.f11713l) {
            o4.b.f11713l = true;
            Configuration configuration = getResources().getConfiguration();
            o4.b.f11712k = (configuration.screenLayout & 15) >= 3 && configuration.smallestScreenWidthDp >= 600;
        }
        if (o4.b.f11712k) {
            setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 645) {
            if (iArr.length != 0 && iArr[0] == 0) {
                x();
                return;
            } else {
                v();
                return;
            }
        }
        if (i10 != 646) {
            return;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            q();
        } else {
            p();
        }
    }

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract void w();

    public final void z() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 646);
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("CoreSettings", 0).edit();
            editorEdit.putBoolean("notification_permission_request", true);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void p() {
    }

    public void q() {
    }

    public void v() {
    }

    public void x() {
    }

    public void y() {
    }
}
