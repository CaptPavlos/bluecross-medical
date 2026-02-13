package p4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.documentfile.provider.DocumentFile;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements ActivityResultCallback, Toolbar.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11962a;

    public /* synthetic */ h(FileExplorerActivity fileExplorerActivity) {
        this.f11962a = fileExplorerActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        Bundle extras;
        ActivityResult activityResult = (ActivityResult) obj;
        int i10 = FileExplorerActivity.f6665q0;
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("path_selected");
            FileExplorerActivity fileExplorerActivity = this.f11962a;
            fileExplorerActivity.f6667k0 = string;
            if (string != null) {
                fileExplorerActivity.f6666j0 = null;
                TextView textView = fileExplorerActivity.C;
                if (textView != null) {
                    textView.setText(string);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
            }
            Intent data2 = activityResult.getData();
            Uri data3 = data2 != null ? data2.getData() : null;
            if (data3 != null) {
                fileExplorerActivity.f6666j0 = data3;
                fileExplorerActivity.f6667k0 = null;
                String lastPathSegment = data3.getLastPathSegment();
                lastPathSegment.getClass();
                String strSubstring = lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1);
                TextView textView2 = fileExplorerActivity.C;
                if (textView2 == null) {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
                textView2.setText(fileExplorerActivity.getString(R.string.sd_card) + '/' + strSubstring);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        EditText editText;
        boolean z9;
        AlertDialog alertDialog;
        EditText editText2;
        String string;
        int i10;
        AlertDialog alertDialog2;
        int i11 = FileExplorerActivity.f6665q0;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        final FileExplorerActivity fileExplorerActivity = this.f11962a;
        int i12 = 1;
        Integer numValueOf = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (itemId != R.id.action_create) {
            if (itemId == R.id.action_delete) {
                AlertDialog alertDialog3 = fileExplorerActivity.J;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                View viewInflate = fileExplorerActivity.getLayoutInflater().inflate(R.layout.dialog_accept_cancel, (ViewGroup) null, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_dialog_msg);
                textView.setTypeface(o4.b.f11720s);
                Context context = textView.getContext();
                r4.b bVar = fileExplorerActivity.M;
                if (bVar != null) {
                    boolean[] zArr = bVar.f12377d;
                    if (zArr != null) {
                        i10 = 0;
                        for (boolean z10 : zArr) {
                            if (z10) {
                                i10++;
                            }
                        }
                    } else {
                        i10 = 0;
                    }
                    numValueOf = Integer.valueOf(i10);
                }
                textView.setText(context.getString(R.string.core_delete_x_files, String.valueOf(numValueOf)));
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_accept_option);
                textView2.setText(fileExplorerActivity.getString(R.string.option_button_delete));
                textView2.setTypeface(o4.b.f11719r);
                textView2.setOnClickListener(new e(fileExplorerActivity, 11));
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_cancel_option);
                textView3.setText(fileExplorerActivity.getString(R.string.option_button_cancel));
                textView3.setTypeface(o4.b.f11719r);
                textView3.setOnClickListener(new e(fileExplorerActivity, 12));
                AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
                builder.setView(viewInflate);
                AlertDialog alertDialogCreate = builder.create();
                fileExplorerActivity.J = alertDialogCreate;
                alertDialogCreate.getClass();
                Window window = alertDialogCreate.getWindow();
                if (window != null) {
                    a3.a.A(window, 0);
                }
                AlertDialog alertDialog4 = fileExplorerActivity.J;
                alertDialog4.getClass();
                alertDialog4.show();
                return true;
            }
            if (itemId != R.id.action_compress) {
                if (itemId == R.id.action_copy) {
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new m(fileExplorerActivity, (w6.c) (objArr2 == true ? 1 : 0), 0), 3);
                    return true;
                }
                if (itemId == R.id.action_cut) {
                    fileExplorerActivity.X = true;
                    y7.e eVar2 = r7.i0.f12407a;
                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new m(fileExplorerActivity, (w6.c) (objArr == true ? 1 : 0), i12), 3);
                    return true;
                }
                if (itemId != R.id.action_paste) {
                    return true;
                }
                if (fileExplorerActivity.T != null) {
                    ArrayList arrayList = fileExplorerActivity.W;
                    arrayList.getClass();
                    File file = fileExplorerActivity.T;
                    file.getClass();
                    new s4.n(arrayList, file, fileExplorerActivity.f6668m0, fileExplorerActivity.X, fileExplorerActivity);
                    return true;
                }
                if (fileExplorerActivity.P == null) {
                    return true;
                }
                ArrayList arrayList2 = fileExplorerActivity.W;
                arrayList2.getClass();
                DocumentFile documentFile = fileExplorerActivity.P;
                documentFile.getClass();
                new s4.n(arrayList2, documentFile, fileExplorerActivity.f6668m0, fileExplorerActivity.X, fileExplorerActivity);
                return true;
            }
            if (!fileExplorerActivity.isFinishing()) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(fileExplorerActivity);
                LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
                layoutInflater.getClass();
                View viewInflate2 = layoutInflater.inflate(R.layout.dialog_compress_files, (ViewGroup) null, false);
                ((TextView) viewInflate2.findViewById(R.id.tv_dialog_title_compress)).setTypeface(o4.b.f11719r);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.tv_dialog_file_name_compress);
                textView4.setTypeface(o4.b.f11720s);
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate2.findViewById(R.id.rl_dialog_file_name_compress);
                EditText editText3 = (EditText) viewInflate2.findViewById(R.id.et_dialog_file_name_compress);
                editText3.setTypeface(o4.b.f11720s);
                TextView textView5 = (TextView) viewInflate2.findViewById(R.id.tv_dialog_file_name_extension);
                textView5.setTypeface(o4.b.f11720s);
                textView5.setText(".zip");
                ((TextView) viewInflate2.findViewById(R.id.tv_dialog_selected_files_title)).setTypeface(o4.b.f11720s);
                TextView textView6 = (TextView) viewInflate2.findViewById(R.id.tv_dialog_selected_files);
                textView6.setTypeface(o4.b.f11720s);
                TextView textView7 = (TextView) viewInflate2.findViewById(R.id.tv_progress_count_files);
                textView7.setTypeface(o4.b.f11719r);
                TextView textView8 = (TextView) viewInflate2.findViewById(R.id.tv_accept_option_compress);
                textView8.setTypeface(o4.b.f11719r);
                TextView textView9 = (TextView) viewInflate2.findViewById(R.id.tv_cancel_option_compress);
                textView9.setTypeface(o4.b.f11719r);
                ProgressBar progressBar = (ProgressBar) viewInflate2.findViewById(R.id.pb_dialog_compress);
                r4.b bVar2 = fileExplorerActivity.M;
                bVar2.getClass();
                final ArrayList arrayListA = bVar2.a();
                final ArrayList arrayList3 = new ArrayList();
                if (arrayListA.isEmpty()) {
                    editText = editText3;
                    z9 = 1;
                } else {
                    Iterator it = arrayListA.iterator();
                    it.getClass();
                    String str = "";
                    while (it.hasNext()) {
                        int i13 = i12;
                        Object next = it.next();
                        next.getClass();
                        if (next instanceof File) {
                            StringBuilder sbV = a3.a.v(str);
                            editText2 = editText3;
                            sbV.append(((File) next).getName());
                            sbV.append('\n');
                            string = sbV.toString();
                            arrayList3.add(next);
                        } else {
                            editText2 = editText3;
                            if (next instanceof DocumentFile) {
                                StringBuilder sbV2 = a3.a.v(str);
                                sbV2.append(((DocumentFile) next).getName());
                                sbV2.append('\n');
                                string = sbV2.toString();
                            } else {
                                i12 = i13;
                                editText3 = editText2;
                            }
                        }
                        str = string;
                        i12 = i13;
                        editText3 = editText2;
                    }
                    editText = editText3;
                    z9 = i12;
                    textView6.setText(str);
                }
                final kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                final EditText editText4 = editText;
                final b9.h hVar = new b9.h(progressBar, textView7, editText4, fileExplorerActivity, textView8, textView4, relativeLayout, textView9);
                textView8.setOnClickListener(new View.OnClickListener() { // from class: p4.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws IOException, ErrnoException {
                        String mimeTypeFromExtension;
                        int i14 = FileExplorerActivity.f6665q0;
                        EditText editText5 = editText4;
                        int length = editText5.getText().toString().length();
                        FileExplorerActivity fileExplorerActivity2 = fileExplorerActivity;
                        if (length <= 0) {
                            String string2 = fileExplorerActivity2.getString(R.string.core_compress_dialog_file_name_empty);
                            string2.getClass();
                            fileExplorerActivity2.C(string2);
                            return;
                        }
                        ArrayList arrayList4 = arrayListA;
                        if (arrayList4.isEmpty()) {
                            return;
                        }
                        File file2 = fileExplorerActivity2.T;
                        kotlin.jvm.internal.x xVar2 = xVar;
                        b9.h hVar2 = hVar;
                        if (file2 != null) {
                            long usableSpace = file2.getUsableSpace();
                            ArrayList arrayList5 = arrayList3;
                            int size = arrayList5.size();
                            int i15 = 0;
                            long length2 = 0;
                            while (i15 < size) {
                                Object obj = arrayList5.get(i15);
                                i15++;
                                length2 = ((File) obj).length() + length2;
                            }
                            if (usableSpace <= length2 * 2) {
                                String string3 = fileExplorerActivity2.getString(R.string.error_not_enough_space);
                                string3.getClass();
                                fileExplorerActivity2.C(string3);
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            File file3 = fileExplorerActivity2.T;
                            sb.append(file3 != null ? file3.getAbsolutePath() : null);
                            sb.append('/');
                            sb.append((Object) editText5.getText());
                            sb.append(".zip");
                            File file4 = new File(sb.toString());
                            if (file4.exists()) {
                                String string4 = fileExplorerActivity2.getString(R.string.core_compress_dialog_file_name_already_exists, editText5.getText());
                                string4.getClass();
                                fileExplorerActivity2.C(string4);
                                return;
                            } else {
                                Activity activity = o4.b.g;
                                r0.f.q(fileExplorerActivity2, editText5);
                                y7.e eVar3 = r7.i0.f12407a;
                                xVar2.f10138a = r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.q(arrayList5, file4, hVar2, fileExplorerActivity2, (w6.c) null, 10), 3);
                                return;
                            }
                        }
                        if (fileExplorerActivity2.P != null) {
                            ArrayList arrayList6 = new ArrayList();
                            Iterator it2 = arrayList4.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                if (next2 instanceof DocumentFile) {
                                    arrayList6.add(next2);
                                }
                            }
                            Context applicationContext = fileExplorerActivity2.getApplicationContext();
                            applicationContext.getClass();
                            DocumentFile documentFile2 = fileExplorerActivity2.P;
                            documentFile2.getClass();
                            long jC = x4.d.c(applicationContext, documentFile2);
                            int size2 = arrayList6.size();
                            int i16 = 0;
                            long length3 = 0;
                            while (i16 < size2) {
                                Object obj2 = arrayList6.get(i16);
                                i16++;
                                length3 = ((DocumentFile) obj2).length() + length3;
                            }
                            if (jC > length3 * 2) {
                                String str2 = ((Object) editText5.getText()) + ".zip";
                                DocumentFile documentFile3 = fileExplorerActivity2.P;
                                documentFile3.getClass();
                                DocumentFile[] documentFileArrListFiles = documentFile3.listFiles();
                                documentFileArrListFiles.getClass();
                                boolean z11 = false;
                                for (DocumentFile documentFile4 : documentFileArrListFiles) {
                                    if (kotlin.jvm.internal.l.a(documentFile4.getName(), str2)) {
                                        String string5 = fileExplorerActivity2.getString(R.string.core_compress_dialog_file_name_already_exists, editText5.getText());
                                        string5.getClass();
                                        fileExplorerActivity2.C(string5);
                                        z11 = true;
                                    }
                                }
                                if (z11) {
                                    return;
                                }
                                Activity activity2 = o4.b.g;
                                r0.f.q(fileExplorerActivity2, editText5);
                                DocumentFile documentFile5 = fileExplorerActivity2.P;
                                documentFile5.getClass();
                                String strSubstring = o7.m.k0(str2, ".", 0, false, 6) > 0 ? str2.substring(o7.m.m0(".", str2, 6) + 1) : "";
                                if (strSubstring.equalsIgnoreCase("xapk")) {
                                    mimeTypeFromExtension = "application/xapk-package-archive";
                                } else {
                                    MimeTypeMap singleton = MimeTypeMap.getSingleton();
                                    Locale locale = Locale.getDefault();
                                    locale.getClass();
                                    String lowerCase = strSubstring.toLowerCase(locale);
                                    lowerCase.getClass();
                                    mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                                    if (mimeTypeFromExtension == null) {
                                        mimeTypeFromExtension = "application/octet-stream";
                                    }
                                }
                                DocumentFile documentFileCreateFile = documentFile5.createFile(mimeTypeFromExtension, str2);
                                documentFileCreateFile.getClass();
                                y7.e eVar4 = r7.i0.f12407a;
                                xVar2.f10138a = r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.q(arrayList6, documentFileCreateFile, hVar2, fileExplorerActivity2, (w6.c) null, 9), 3);
                            }
                        }
                    }
                });
                textView9.setOnClickListener(new j(xVar, fileExplorerActivity, 0));
                builder2.setView(viewInflate2);
                fileExplorerActivity.J = builder2.create();
                if (fileExplorerActivity.isFinishing() || (alertDialog = fileExplorerActivity.J) == null) {
                    return z9;
                }
                Window window2 = alertDialog.getWindow();
                if (window2 != null) {
                    a3.a.A(window2, 0);
                }
                AlertDialog alertDialog5 = fileExplorerActivity.J;
                alertDialog5.getClass();
                alertDialog5.show();
                return z9;
            }
        } else if (!fileExplorerActivity.isFinishing()) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(fileExplorerActivity);
            LayoutInflater layoutInflater2 = fileExplorerActivity.getLayoutInflater();
            layoutInflater2.getClass();
            View viewInflate3 = layoutInflater2.inflate(R.layout.dialog_create, (ViewGroup) null, false);
            ((TextView) viewInflate3.findViewById(R.id.tv_dialog_title_create)).setTypeface(o4.b.f11719r);
            ((TextView) viewInflate3.findViewById(R.id.tv_dialog_file_name_create)).setTypeface(o4.b.f11720s);
            EditText editText5 = (EditText) viewInflate3.findViewById(R.id.et_dialog_file_name_create);
            editText5.setTypeface(o4.b.f11720s);
            TextView textView10 = (TextView) viewInflate3.findViewById(R.id.tv_accept_option_create);
            textView10.setTypeface(o4.b.f11719r);
            TextView textView11 = (TextView) viewInflate3.findViewById(R.id.tv_cancel_option_create);
            textView11.setTypeface(o4.b.f11719r);
            textView10.setOnClickListener(new f5(16, editText5, fileExplorerActivity));
            textView11.setOnClickListener(new e(fileExplorerActivity, 6));
            builder3.setView(viewInflate3);
            fileExplorerActivity.J = builder3.create();
            if (!fileExplorerActivity.isFinishing() && (alertDialog2 = fileExplorerActivity.J) != null) {
                Window window3 = alertDialog2.getWindow();
                if (window3 != null) {
                    a3.a.A(window3, 0);
                }
                AlertDialog alertDialog6 = fileExplorerActivity.J;
                alertDialog6.getClass();
                alertDialog6.show();
                return true;
            }
        }
        return true;
    }
}
