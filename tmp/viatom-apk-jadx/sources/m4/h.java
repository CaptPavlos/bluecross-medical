package m4;

import a3.x;
import a6.q;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStatVfs;
import android.view.View;
import androidx.documentfile.provider.DocumentFile;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.v;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11203b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11204c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f11205d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(Object obj, Object obj2, Serializable serializable, Object obj3, int i10) {
        this.f11202a = i10;
        this.f11203b = obj;
        this.f11204c = obj2;
        this.f11205d = serializable;
        this.e = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IOException, ErrnoException {
        int i10 = this.f11202a;
        Object obj = this.e;
        Serializable serializable = this.f11205d;
        Object obj2 = this.f11204c;
        Object obj3 = this.f11203b;
        switch (i10) {
            case 0:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj3;
                int i11 = PreferencesActivity.M;
                String string = preferencesActivity.getString(R.string.select_downloads_path);
                string.getClass();
                preferencesActivity.n0(string, (HashMap) obj2, ((v) serializable).f10136a, new a8.d(9, preferencesActivity, (x) obj));
                break;
            default:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) obj2;
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) serializable;
                d5.j jVar = (d5.j) obj;
                long usableSpace = 0;
                if (!(obj3 instanceof File)) {
                    if (!(obj3 instanceof DocumentFile)) {
                        int i12 = FileExplorerActivity.f6665q0;
                        break;
                    } else if (fileExplorerActivity.f6667k0 == null) {
                        if (fileExplorerActivity.f6666j0 == null) {
                            DocumentFile documentFile = fileExplorerActivity.P;
                            if (documentFile == null) {
                                File file = fileExplorerActivity.T;
                                if (file != null) {
                                    String absolutePath = file.getAbsolutePath();
                                    absolutePath.getClass();
                                    y7.e eVar = i0.f12407a;
                                    xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q(obj3, absolutePath, (Object) jVar, (Object) fileExplorerActivity, (w6.c) null, 14), 3);
                                    break;
                                }
                            } else {
                                Uri uri = documentFile.getUri();
                                uri.getClass();
                                y7.e eVar2 = i0.f12407a;
                                xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q((DocumentFile) obj3, uri, jVar, fileExplorerActivity, (w6.c) null, 15), 3);
                                break;
                            }
                        } else {
                            Context applicationContext = fileExplorerActivity.getApplicationContext();
                            applicationContext.getClass();
                            Uri uri2 = fileExplorerActivity.f6666j0;
                            uri2.getClass();
                            try {
                                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = applicationContext.getContentResolver().openFileDescriptor(uri2, CampaignEx.JSON_KEY_AD_R);
                                if (parcelFileDescriptorOpenFileDescriptor != null) {
                                    StructStatVfs structStatVfsFstatvfs = Os.fstatvfs(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                                    usableSpace = structStatVfsFstatvfs.f_bsize * structStatVfsFstatvfs.f_bavail;
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            DocumentFile documentFile2 = (DocumentFile) obj3;
                            if (usableSpace > documentFile2.length() * 2) {
                                Uri uri3 = fileExplorerActivity.f6666j0;
                                uri3.getClass();
                                y7.e eVar3 = i0.f12407a;
                                xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q(documentFile2, uri3, jVar, fileExplorerActivity, (w6.c) null, 15), 3);
                                break;
                            }
                        }
                    } else {
                        File file2 = fileExplorerActivity.T;
                        if (file2 == null) {
                            File externalStorageDirectory = Environment.getExternalStorageDirectory();
                            if (externalStorageDirectory != null) {
                                usableSpace = externalStorageDirectory.getUsableSpace();
                            }
                        } else {
                            usableSpace = file2.getUsableSpace();
                        }
                        DocumentFile documentFile3 = (DocumentFile) obj3;
                        if (usableSpace > documentFile3.length() * 2) {
                            String str = fileExplorerActivity.f6667k0;
                            str.getClass();
                            y7.e eVar4 = i0.f12407a;
                            xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q((Object) documentFile3, str, (Object) jVar, (Object) fileExplorerActivity, (w6.c) null, 14), 3);
                            break;
                        }
                    }
                } else if (fileExplorerActivity.f6667k0 == null) {
                    if (fileExplorerActivity.f6666j0 != null) {
                        Context applicationContext2 = fileExplorerActivity.getApplicationContext();
                        applicationContext2.getClass();
                        Uri uri4 = fileExplorerActivity.f6666j0;
                        uri4.getClass();
                        try {
                            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = applicationContext2.getContentResolver().openFileDescriptor(uri4, CampaignEx.JSON_KEY_AD_R);
                            if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                                StructStatVfs structStatVfsFstatvfs2 = Os.fstatvfs(parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor());
                                usableSpace = structStatVfsFstatvfs2.f_bsize * structStatVfsFstatvfs2.f_bavail;
                                parcelFileDescriptorOpenFileDescriptor2.close();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        File file3 = (File) obj3;
                        if (usableSpace > file3.length() * 2) {
                            Uri uri5 = fileExplorerActivity.f6666j0;
                            uri5.getClass();
                            y7.e eVar5 = i0.f12407a;
                            xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q(file3, uri5, jVar, fileExplorerActivity, (w6.c) null, 13), 3);
                            break;
                        }
                    }
                } else {
                    File file4 = fileExplorerActivity.T;
                    Long lValueOf = file4 != null ? Long.valueOf(file4.getUsableSpace()) : null;
                    lValueOf.getClass();
                    File file5 = (File) obj3;
                    if (lValueOf.longValue() > file5.length() * 2) {
                        String str2 = fileExplorerActivity.f6667k0;
                        str2.getClass();
                        y7.e eVar6 = i0.f12407a;
                        xVar.f10138a = y.q(y.a(y7.d.f14116a), null, null, new q((Object) file5, str2, (Object) jVar, (Object) fileExplorerActivity, (w6.c) null, 12), 3);
                        break;
                    }
                }
                break;
        }
    }
}
