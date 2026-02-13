package p4;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11936a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11937b;

    public /* synthetic */ e(FileExplorerActivity fileExplorerActivity, int i10) {
        this.f11936a = i10;
        this.f11937b = fileExplorerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f11936a;
        w6.c cVar = null;
        FileExplorerActivity fileExplorerActivity = this.f11937b;
        switch (i10) {
            case 0:
                AlertDialog alertDialog = fileExplorerActivity.f11942a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                fileExplorerActivity.B();
                break;
            case 1:
                SearchView searchView = fileExplorerActivity.E;
                if (searchView != null) {
                    searchView.setIconified(false);
                    break;
                }
                break;
            case 2:
                RelativeLayout relativeLayout = fileExplorerActivity.F;
                relativeLayout.getClass();
                if (relativeLayout.getVisibility() != 0) {
                    view.animate().rotation(180.0f).start();
                    RelativeLayout relativeLayout2 = fileExplorerActivity.F;
                    relativeLayout2.getClass();
                    relativeLayout2.setVisibility(0);
                    break;
                } else {
                    view.animate().rotation(0.0f).start();
                    RelativeLayout relativeLayout3 = fileExplorerActivity.F;
                    relativeLayout3.getClass();
                    relativeLayout3.setVisibility(8);
                    break;
                }
            case 3:
                fileExplorerActivity.U = !fileExplorerActivity.U;
                fileExplorerActivity.Z();
                fileExplorerActivity.b0();
                break;
            case 4:
                fileExplorerActivity.U = !fileExplorerActivity.U;
                fileExplorerActivity.Z();
                boolean z9 = fileExplorerActivity.U;
                RadioButton radioButton = fileExplorerActivity.H;
                if (!z9) {
                    radioButton.getClass();
                    radioButton.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_size_asc_on));
                    RadioButton radioButton2 = fileExplorerActivity.G;
                    radioButton2.getClass();
                    radioButton2.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_az_asc_off));
                    RadioButton radioButton3 = fileExplorerActivity.I;
                    radioButton3.getClass();
                    radioButton3.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_date_asc_off));
                    break;
                } else {
                    radioButton.getClass();
                    radioButton.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_size_desc_on));
                    RadioButton radioButton4 = fileExplorerActivity.G;
                    radioButton4.getClass();
                    radioButton4.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_az_desc_off));
                    RadioButton radioButton5 = fileExplorerActivity.I;
                    radioButton5.getClass();
                    radioButton5.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_date_desc_off));
                    break;
                }
            case 5:
                fileExplorerActivity.U = !fileExplorerActivity.U;
                fileExplorerActivity.Z();
                boolean z10 = fileExplorerActivity.U;
                RadioButton radioButton6 = fileExplorerActivity.I;
                if (!z10) {
                    radioButton6.getClass();
                    radioButton6.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_date_asc_on));
                    RadioButton radioButton7 = fileExplorerActivity.H;
                    radioButton7.getClass();
                    radioButton7.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_size_asc_off));
                    RadioButton radioButton8 = fileExplorerActivity.G;
                    radioButton8.getClass();
                    radioButton8.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_az_asc_off));
                    break;
                } else {
                    radioButton6.getClass();
                    radioButton6.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_date_desc_on));
                    RadioButton radioButton9 = fileExplorerActivity.H;
                    radioButton9.getClass();
                    radioButton9.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_size_desc_off));
                    RadioButton radioButton10 = fileExplorerActivity.G;
                    radioButton10.getClass();
                    radioButton10.setBackground(ContextCompat.getDrawable(fileExplorerActivity, R.drawable.core_vector_sort_az_desc_off));
                    break;
                }
            case 6:
                AlertDialog alertDialog2 = fileExplorerActivity.J;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 7:
                fileExplorerActivity.U = !fileExplorerActivity.U;
                fileExplorerActivity.Z();
                fileExplorerActivity.b0();
                break;
            case 8:
                AlertDialog alertDialog3 = fileExplorerActivity.J;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                fileExplorerActivity.finish();
                break;
            case 9:
                AlertDialog alertDialog4 = fileExplorerActivity.J;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
            case 10:
                int i11 = FileExplorerActivity.f6665q0;
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                intent.addFlags(195);
                intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
                intent.putExtra("android.content.extra.FANCY", true);
                intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
                fileExplorerActivity.f11950m.launch(intent);
                break;
            case 11:
                int i12 = FileExplorerActivity.f6665q0;
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(r7.y.a(y7.d.f14116a), null, null, new m(fileExplorerActivity, cVar, 2), 3);
                AlertDialog alertDialog5 = fileExplorerActivity.J;
                alertDialog5.getClass();
                alertDialog5.dismiss();
                break;
            case 12:
                AlertDialog alertDialog6 = fileExplorerActivity.J;
                alertDialog6.getClass();
                alertDialog6.dismiss();
                break;
            case 13:
                int i13 = FileExplorerActivity.f6665q0;
                Intent intent2 = new Intent(fileExplorerActivity.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                intent2.putExtra("select_path", 1);
                fileExplorerActivity.f6671p0.launch(intent2);
                break;
            case 14:
                AlertDialog alertDialog7 = fileExplorerActivity.J;
                alertDialog7.getClass();
                alertDialog7.dismiss();
                break;
            case 15:
                int i14 = FileExplorerActivity.f6665q0;
                Intent intent3 = new Intent();
                DocumentFile documentFile = fileExplorerActivity.P;
                if (documentFile == null) {
                    File file = fileExplorerActivity.T;
                    file.getClass();
                    if (!file.canWrite()) {
                        String string = fileExplorerActivity.getString(R.string.core_msg_cannot_write_path);
                        string.getClass();
                        fileExplorerActivity.C(string);
                        break;
                    } else {
                        File file2 = fileExplorerActivity.T;
                        file2.getClass();
                        intent3.putExtra("path_selected", file2.getAbsolutePath()).getClass();
                    }
                } else if (!documentFile.canWrite()) {
                    String string2 = fileExplorerActivity.getString(R.string.core_msg_cannot_write_path);
                    string2.getClass();
                    fileExplorerActivity.C(string2);
                    break;
                } else {
                    DocumentFile documentFile2 = fileExplorerActivity.P;
                    documentFile2.getClass();
                    intent3.setData(documentFile2.getUri());
                }
                intent3.putExtra("sdcard_selected", fileExplorerActivity.V);
                fileExplorerActivity.setResult(145, intent3);
                fileExplorerActivity.finish();
                break;
            case 16:
                int i15 = FileExplorerActivity.f6665q0;
                fileExplorerActivity.finish();
                break;
            case 17:
                int i16 = FileExplorerActivity.f6665q0;
                fileExplorerActivity.finish();
                break;
            default:
                int i17 = FileExplorerActivity.f6665q0;
                fileExplorerActivity.a0();
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory != null) {
                    fileExplorerActivity.T = externalStorageDirectory;
                    fileExplorerActivity.P = null;
                }
                fileExplorerActivity.Y(true);
                break;
        }
    }
}
