package b5;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import h5.h;
import l4.x4;
import n4.i;
import n4.k;
import n4.l;
import n4.r0;
import n4.t0;
import y5.h1;
import y5.j0;
import y5.j1;
import y5.k1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f846a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f847b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f848c;

    public /* synthetic */ c(int i10, Object obj, Object obj2) {
        this.f846a = i10;
        this.f847b = obj;
        this.f848c = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i10 = this.f846a;
        Object obj = this.f848c;
        Object obj2 = this.f847b;
        switch (i10) {
            case 0:
                d dVar = (d) obj2;
                int absoluteAdapterPosition = dVar.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition != -1) {
                    x4 x4Var = dVar.f849a;
                    x4Var.getClass();
                    FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) x4Var.f10987b;
                    r4.b bVar = fileExplorerActivity.M;
                    if (bVar != null) {
                        if (!bVar.f12376c) {
                            bVar.c(true);
                            r4.b bVar2 = fileExplorerActivity.M;
                            bVar2.getClass();
                            bVar2.b(absoluteAdapterPosition);
                            FileExplorerActivity.S(fileExplorerActivity);
                            break;
                        } else {
                            bVar.b(absoluteAdapterPosition);
                            r4.b bVar3 = fileExplorerActivity.M;
                            bVar3.getClass();
                            if (!bVar3.a().contains(obj)) {
                                fileExplorerActivity.W();
                                r4.b bVar4 = fileExplorerActivity.M;
                                bVar4.getClass();
                                bVar4.c(false);
                                break;
                            } else {
                                FileExplorerActivity.S(fileExplorerActivity);
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                AdvancedPreferencesActivity advancedPreferencesActivity = (AdvancedPreferencesActivity) obj2;
                int i11 = AdvancedPreferencesActivity.J;
                Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
                systemService.getClass();
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("identifier", (String) obj));
                advancedPreferencesActivity.C("identifier copiado al portapapeles");
                break;
            case 2:
                ((i) obj2).f11371b.c((h) obj);
                break;
            case 3:
                ((k) obj2).f11401c.c((h) obj);
                break;
            case 4:
                ((l) obj2).f11420c.c((h) obj);
                break;
            case 5:
                ((r0) obj2).f11473b.c((h) obj);
                break;
            case 6:
                ((t0) obj2).f11487b.c((h) obj);
                break;
            case 7:
                h hVar = (h) obj;
                g5.a aVar = ((y5.c) obj2).f13822c;
                if (aVar != null) {
                    aVar.c(hVar);
                    break;
                }
                break;
            case 8:
                ((j0) obj2).f13896c.c((h) obj);
                break;
            case 9:
                ((h1) obj2).f13876d.c((h) obj);
                break;
            case 10:
                ((j1) obj2).f13904d.c((h) obj);
                break;
            default:
                h hVar2 = (h) obj;
                g5.a aVar2 = ((k1) obj2).f13926c;
                if (aVar2 != null) {
                    aVar2.c(hVar2);
                    break;
                }
                break;
        }
        return true;
    }

    public /* synthetic */ c(Object obj, h hVar, int i10, int i11) {
        this.f846a = i11;
        this.f847b = obj;
        this.f848c = hVar;
    }
}
