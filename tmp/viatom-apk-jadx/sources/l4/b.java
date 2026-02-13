package l4;

import android.content.res.Resources;
import android.os.Environment;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends OnBackPressedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10235a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p4.f f10236b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(p4.f fVar, int i10) {
        super(true);
        this.f10235a = i10;
        this.f10236b = fVar;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() throws Resources.NotFoundException {
        int i10 = this.f10235a;
        int i11 = 1;
        p4.f fVar = this.f10236b;
        switch (i10) {
            case 0:
                AppDetailActivity appDetailActivity = (AppDetailActivity) fVar;
                ArrayList arrayList = appDetailActivity.K;
                ArrayList arrayList2 = appDetailActivity.J;
                ArrayList arrayList3 = appDetailActivity.I;
                z5.d dVar = appDetailActivity.E;
                if (dVar == null || !dVar.b(appDetailActivity)) {
                    if (arrayList2.size() > 0) {
                        arrayList2.remove(t6.m.P(arrayList2));
                        if (arrayList2.size() == 0 && appDetailActivity.H != null && arrayList3.size() == 1) {
                            appDetailActivity.finish();
                        } else {
                            appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                        }
                    } else if (arrayList.size() > 0) {
                        arrayList.remove(t6.m.P(arrayList));
                        appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                    } else if (arrayList3.size() > 0) {
                        arrayList3.remove(t6.m.P(arrayList3));
                        appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                        if (arrayList3.size() == 0) {
                            appDetailActivity.finish();
                        }
                    } else {
                        appDetailActivity.finish();
                    }
                    if (arrayList3.size() > 0) {
                        ((e5.j0) t6.l.i0(arrayList3)).p0(appDetailActivity);
                        break;
                    }
                }
                break;
            case 1:
                ((Gallery) fVar).finish();
                break;
            case 2:
                LoginActivity loginActivity = (LoginActivity) fVar;
                int i12 = LoginActivity.P;
                if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                    loginActivity.finish();
                    break;
                } else {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setInterpolator(new AccelerateInterpolator());
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setAnimationListener(new t1(loginActivity, i11));
                    ((LinearLayout) loginActivity.v0().f7403d.f7082b).startAnimation(alphaAnimation);
                    break;
                }
            case 3:
                MainActivity mainActivity = (MainActivity) fVar;
                ArrayList arrayList4 = mainActivity.f6642m0;
                z5.d dVar2 = mainActivity.E;
                if (dVar2 == null || !dVar2.b(mainActivity)) {
                    boolean zPopBackStackImmediate = mainActivity.getSupportFragmentManager().popBackStackImmediate();
                    int backStackEntryCount = mainActivity.getSupportFragmentManager().getBackStackEntryCount();
                    if (zPopBackStackImmediate && backStackEntryCount >= 0) {
                        boolean z9 = mainActivity.G0() instanceof e5.j0;
                        RelativeLayout relativeLayout = mainActivity.W;
                        if (!z9) {
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(8);
                            }
                            if (mainActivity.G0() == null || (mainActivity.G0() instanceof e5.t1) || (mainActivity.G0() instanceof e5.n1) || (mainActivity.G0() instanceof e5.d1)) {
                                mainActivity.X0();
                                break;
                            }
                        } else {
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(0);
                            }
                            Fragment fragmentG0 = mainActivity.G0();
                            fragmentG0.getClass();
                            ((e5.j0) fragmentG0).p0(mainActivity);
                            break;
                        }
                    } else {
                        RelativeLayout relativeLayout2 = mainActivity.W;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(8);
                        }
                        int size = arrayList4.size();
                        if (size <= 0) {
                            if (!MainActivity.w0(mainActivity)) {
                                mainActivity.finish();
                                break;
                            } else {
                                RelativeLayout relativeLayout3 = mainActivity.P;
                                if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
                                    mainActivity.z0();
                                    break;
                                } else {
                                    ViewPager2 viewPager2 = mainActivity.U;
                                    if (viewPager2 != null && viewPager2.getCurrentItem() == 0) {
                                        mainActivity.finish();
                                        break;
                                    } else {
                                        mainActivity.C0(0);
                                        break;
                                    }
                                }
                            }
                        } else {
                            Fragment fragment = (Fragment) t6.l.i0(arrayList4);
                            arrayList4.remove(size - 1);
                            if (!(fragment instanceof e5.n1)) {
                                if (!MainActivity.w0(mainActivity)) {
                                    mainActivity.finish();
                                    break;
                                } else {
                                    RelativeLayout relativeLayout4 = mainActivity.P;
                                    if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
                                        mainActivity.z0();
                                        break;
                                    } else {
                                        ViewPager2 viewPager22 = mainActivity.U;
                                        if (viewPager22 != null && viewPager22.getCurrentItem() == 0) {
                                            mainActivity.finish();
                                            break;
                                        } else {
                                            mainActivity.C0(0);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                h5.k kVar = ((e5.n1) fragment).f7765a;
                                if (kVar != null && kVar.f8632a == 523) {
                                    mainActivity.C0(1);
                                    break;
                                } else {
                                    mainActivity.C0(0);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 4:
                MyDownloads myDownloads = (MyDownloads) fVar;
                n4.b bVar = myDownloads.J;
                if (bVar != null && bVar.f11301c) {
                    myDownloads.u0();
                    break;
                } else {
                    myDownloads.finish();
                    break;
                }
                break;
            case 5:
                Updates updates = (Updates) fVar;
                if (!updates.Y.isEmpty()) {
                    updates.Y = new ArrayList();
                    updates.P0();
                    break;
                } else {
                    updates.finish();
                    break;
                }
            case 6:
                ((UserDeviceDetailsActivity) fVar).finish();
                break;
            case 7:
                ((YouTubeActivity) fVar).finish();
                break;
            case 8:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) fVar;
                r4.b bVar2 = fileExplorerActivity.M;
                if (bVar2 != null && bVar2.f12376c) {
                    bVar2.c(false);
                    fileExplorerActivity.W();
                    break;
                } else {
                    DocumentFile documentFile = fileExplorerActivity.P;
                    if (documentFile == null) {
                        File file = fileExplorerActivity.T;
                        if (file != null && !file.equals(Environment.getExternalStorageDirectory())) {
                            File file2 = fileExplorerActivity.T;
                            file2.getClass();
                            String name = file2.getName();
                            File file3 = fileExplorerActivity.T;
                            file3.getClass();
                            File parentFile = file3.getParentFile();
                            if (parentFile == null) {
                                FileExplorerActivity.J(fileExplorerActivity);
                                break;
                            } else {
                                fileExplorerActivity.T = parentFile;
                                fileExplorerActivity.P = null;
                                FileExplorerActivity.R(fileExplorerActivity);
                                fileExplorerActivity.X(name);
                                SearchView searchView = fileExplorerActivity.E;
                                if (searchView != null) {
                                    fileExplorerActivity.V(searchView);
                                    break;
                                }
                            }
                        } else {
                            FileExplorerActivity.J(fileExplorerActivity);
                            break;
                        }
                    } else {
                        String name2 = documentFile.getName();
                        DocumentFile documentFile2 = fileExplorerActivity.P;
                        documentFile2.getClass();
                        DocumentFile parentFile2 = documentFile2.getParentFile();
                        if (parentFile2 == null) {
                            FileExplorerActivity.J(fileExplorerActivity);
                            break;
                        } else {
                            fileExplorerActivity.P = parentFile2;
                            fileExplorerActivity.T = null;
                            FileExplorerActivity.R(fileExplorerActivity);
                            fileExplorerActivity.X(name2);
                            SearchView searchView2 = fileExplorerActivity.E;
                            if (searchView2 != null) {
                                fileExplorerActivity.V(searchView2);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                int i13 = InstallerActivity.f6676m0;
                ((InstallerActivity) fVar).F();
                break;
        }
    }
}
