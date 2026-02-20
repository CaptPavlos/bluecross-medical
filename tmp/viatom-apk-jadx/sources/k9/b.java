package k9;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c6.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import j.g;
import kotlin.jvm.internal.l;
import r7.i0;
import r7.v0;
import r7.y;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends l9.a {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f10107w = 0;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f10108m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f10109n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f10110o;

    /* renamed from: p, reason: collision with root package name */
    public CheckBox f10111p;

    /* renamed from: q, reason: collision with root package name */
    public Button f10112q;

    /* renamed from: r, reason: collision with root package name */
    public CardView f10113r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f10114s;
    public TextView t;

    /* renamed from: u, reason: collision with root package name */
    public NestedScrollView f10115u;

    /* renamed from: v, reason: collision with root package name */
    public d f10116v;

    public final void a(TextView textView, String str, String str2, boolean z9) {
        if (textView == null) {
            return;
        }
        textView.setText(str2);
        textView.setVisibility(z9 ? 0 : 8);
        textView.setOnClickListener(new b5.a(19, this, str));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
        d dVar = this.f10116v;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.CCPA, g.f9878a);
        ChoiceCmpCallback choiceCmpCallback = dVar.f10121b;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.f10116v = (d) new ViewModelProvider(viewModelStore, new i(6)).get(d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_ccpa_privacy, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        o8.c cVar;
        o8.i iVar;
        o8.c cVar2;
        o8.c cVar3;
        o8.i iVar2;
        o8.c cVar4;
        o8.c cVar5;
        o8.i iVar3;
        o8.c cVar6;
        o8.c cVar7;
        o8.c cVar8;
        TextView textView;
        view.getClass();
        super.onViewCreated(view, bundle);
        final boolean z9 = g.f9878a;
        this.f10108m = (LinearLayout) view.findViewById(R.id.container_ccpa_links);
        this.f10109n = (TextView) view.findViewById(R.id.tv_privacy_policy_link);
        this.f10110o = (TextView) view.findViewById(R.id.tv_delete_data_link);
        this.f10111p = (CheckBox) view.findViewById(R.id.chx_ccpa_consent);
        this.f10112q = (Button) view.findViewById(R.id.btn_ccpa_consent);
        this.f10113r = (CardView) view.findViewById(R.id.bottom_container);
        this.f10114s = (TextView) view.findViewById(R.id.tv_ccpa_content);
        this.t = (TextView) view.findViewById(R.id.tv_access_data_link);
        this.f10115u = (NestedScrollView) view.findViewById(R.id.sv_container);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.gbc_fragment_container);
        final int i10 = 1;
        if (g.f9878a) {
            getChildFragmentManager().beginTransaction().add(R.id.gbc_fragment_container, new j.d(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).addToBackStack(null).commit();
            d dVar = this.f10116v;
            if (dVar == null) {
                l.i("viewModel");
                throw null;
            }
            d0.i iVar4 = dVar.f10120a;
            iVar4.getClass();
            iVar4.q(92, true);
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView2 = this.f11096b;
        if (textView2 != null) {
            d dVar2 = this.f10116v;
            if (dVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String string = dVar2.f10122c.f7465a;
            if (string.length() == 0) {
                string = getString(R.string.ccpa_privacy_title);
                string.getClass();
            }
            textView2.setText(string);
        }
        d dVar3 = this.f10116v;
        if (dVar3 == null) {
            l.i("viewModel");
            throw null;
        }
        int length = dVar3.b().length();
        TextView textView3 = this.f10114s;
        if (length > 0) {
            if (textView3 != null) {
                d dVar4 = this.f10116v;
                if (dVar4 == null) {
                    l.i("viewModel");
                    throw null;
                }
                textView3.setText(l1.b.a(dVar4.b()));
            }
        } else if (textView3 != null) {
            textView3.setText(R.string.ccpa_content_message);
        }
        TextView textView4 = this.f10114s;
        String str = "";
        if (textView4 != null) {
            d dVar5 = this.f10116v;
            if (dVar5 == null) {
                l.i("viewModel");
                throw null;
            }
            textView4.append(g.f9878a ? dVar5.f.f11566b.f11561c : "");
        }
        TextView textView5 = this.f10114s;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (context != null && (textView = this.f10114s) != null) {
            textView.setLinkTextColor(ContextCompat.getColor(context, R.color.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f10108m;
        final int i11 = 0;
        if (linearLayout != null) {
            d dVar6 = this.f10116v;
            if (dVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            o8.i iVar5 = dVar6.f10123d;
            linearLayout.setVisibility((iVar5 == null || (cVar8 = iVar5.f11814b) == null || !cVar8.C) ? 0 : 8);
        }
        TextView textView6 = this.f10110o;
        d dVar7 = this.f10116v;
        if (dVar7 == null) {
            l.i("viewModel");
            throw null;
        }
        o8.i iVar6 = dVar7.f10123d;
        String str2 = (iVar6 == null || (cVar7 = iVar6.f11814b) == null) ? "" : cVar7.D;
        String strC = dVar7.c();
        d dVar8 = this.f10116v;
        if (dVar8 == null) {
            l.i("viewModel");
            throw null;
        }
        a(textView6, str2, strC, dVar8.c().length() > 0 && (iVar3 = dVar8.f10123d) != null && (cVar6 = iVar3.f11814b) != null && cVar6.D.length() > 0);
        TextView textView7 = this.t;
        d dVar9 = this.f10116v;
        if (dVar9 == null) {
            l.i("viewModel");
            throw null;
        }
        o8.i iVar7 = dVar9.f10123d;
        String str3 = (iVar7 == null || (cVar5 = iVar7.f11814b) == null) ? "" : cVar5.E;
        String strA = dVar9.a();
        d dVar10 = this.f10116v;
        if (dVar10 == null) {
            l.i("viewModel");
            throw null;
        }
        a(textView7, str3, strA, dVar10.a().length() > 0 && (iVar2 = dVar10.f10123d) != null && (cVar4 = iVar2.f11814b) != null && cVar4.E.length() > 0);
        TextView textView8 = this.f10109n;
        d dVar11 = this.f10116v;
        if (dVar11 == null) {
            l.i("viewModel");
            throw null;
        }
        o8.i iVar8 = dVar11.f10123d;
        if (iVar8 != null && (cVar3 = iVar8.f11814b) != null) {
            str = cVar3.F;
        }
        String strD = dVar11.d();
        d dVar12 = this.f10116v;
        if (dVar12 == null) {
            l.i("viewModel");
            throw null;
        }
        a(textView8, str, strD, dVar12.d().length() > 0 && (iVar = dVar12.f10123d) != null && (cVar2 = iVar.f11814b) != null && cVar2.F.length() > 0);
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: k9.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f10105b;

                {
                    this.f10105b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o8.c cVar9;
                    int i12 = i11;
                    boolean z10 = z9;
                    b bVar = this.f10105b;
                    switch (i12) {
                        case 0:
                            d dVar13 = bVar.f10116v;
                            if (dVar13 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.CCPA, z10);
                            ChoiceCmpCallback choiceCmpCallback = dVar13.f10121b;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            bVar.dismiss();
                            FragmentActivity activity = bVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        default:
                            d dVar14 = bVar.f10116v;
                            if (dVar14 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            d0.i iVar9 = dVar14.f10120a;
                            CheckBox checkBox = bVar.f10111p;
                            boolean zIsChecked = checkBox == null ? false : checkBox.isChecked();
                            int i13 = zIsChecked ? 2 : 1;
                            o8.i iVar10 = dVar14.f10123d;
                            d0.i.r(iVar9, 2, i13, l.a((iVar10 != null && (cVar9 = iVar10.f11814b) != null) ? cVar9.f11781d : null, "Y") ? 2 : 1);
                            o8.c cVar10 = i9.a.h().f11814b;
                            String str4 = cVar10.U;
                            if (str4 != null) {
                                iVar9.p(89, str4);
                            }
                            iVar9.p(90, cVar10.f11788o);
                            iVar9.q(91, g.f9878a);
                            ChoiceCmpCallback choiceCmpCallback2 = dVar14.f10121b;
                            if (choiceCmpCallback2 != null) {
                                choiceCmpCallback2.onCCPAConsentGiven(iVar9.t(37));
                            }
                            e eVar = i0.f12407a;
                            y.q(v0.f12442a, y7.d.f14116a, null, new c(dVar14, zIsChecked, null), 2);
                            if (z10) {
                                Fragment fragmentFindFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                                j.d dVar15 = fragmentFindFragmentByTag instanceof j.d ? (j.d) fragmentFindFragmentByTag : null;
                                if (dVar15 != null) {
                                    dVar15.a();
                                }
                            }
                            bVar.dismiss();
                            FragmentActivity activity2 = bVar.getActivity();
                            if (activity2 == null) {
                                return;
                            }
                            activity2.finish();
                            return;
                    }
                }
            });
            d dVar13 = this.f10116v;
            if (dVar13 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(dVar13.f10122c.f);
        }
        CheckBox checkBox = this.f10111p;
        if (checkBox != null) {
            d dVar14 = this.f10116v;
            if (dVar14 == null) {
                l.i("viewModel");
                throw null;
            }
            checkBox.setChecked(dVar14.f10120a.c(2, 3).equals("Y"));
        }
        Button button = this.f10112q;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this) { // from class: k9.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f10105b;

                {
                    this.f10105b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o8.c cVar9;
                    int i12 = i10;
                    boolean z10 = z9;
                    b bVar = this.f10105b;
                    switch (i12) {
                        case 0:
                            d dVar132 = bVar.f10116v;
                            if (dVar132 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.CCPA, z10);
                            ChoiceCmpCallback choiceCmpCallback = dVar132.f10121b;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            bVar.dismiss();
                            FragmentActivity activity = bVar.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        default:
                            d dVar142 = bVar.f10116v;
                            if (dVar142 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            d0.i iVar9 = dVar142.f10120a;
                            CheckBox checkBox2 = bVar.f10111p;
                            boolean zIsChecked = checkBox2 == null ? false : checkBox2.isChecked();
                            int i13 = zIsChecked ? 2 : 1;
                            o8.i iVar10 = dVar142.f10123d;
                            d0.i.r(iVar9, 2, i13, l.a((iVar10 != null && (cVar9 = iVar10.f11814b) != null) ? cVar9.f11781d : null, "Y") ? 2 : 1);
                            o8.c cVar10 = i9.a.h().f11814b;
                            String str4 = cVar10.U;
                            if (str4 != null) {
                                iVar9.p(89, str4);
                            }
                            iVar9.p(90, cVar10.f11788o);
                            iVar9.q(91, g.f9878a);
                            ChoiceCmpCallback choiceCmpCallback2 = dVar142.f10121b;
                            if (choiceCmpCallback2 != null) {
                                choiceCmpCallback2.onCCPAConsentGiven(iVar9.t(37));
                            }
                            e eVar = i0.f12407a;
                            y.q(v0.f12442a, y7.d.f14116a, null, new c(dVar142, zIsChecked, null), 2);
                            if (z10) {
                                Fragment fragmentFindFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                                j.d dVar15 = fragmentFindFragmentByTag instanceof j.d ? (j.d) fragmentFindFragmentByTag : null;
                                if (dVar15 != null) {
                                    dVar15.a();
                                }
                            }
                            bVar.dismiss();
                            FragmentActivity activity2 = bVar.getActivity();
                            if (activity2 == null) {
                                return;
                            }
                            activity2.finish();
                            return;
                    }
                }
            });
        }
        d9.d dVar15 = this.f11100j;
        if (dVar15 != null) {
            Integer num = dVar15.g;
            if (num != null) {
                int iIntValue = num.intValue();
                view.setBackgroundColor(iIntValue);
                CardView cardView = this.f10113r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(iIntValue);
                }
            }
            Integer num2 = dVar15.f7471a;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f10115u;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, iIntValue2);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar15.f7475i;
            if (num3 != null) {
                int iIntValue3 = num3.intValue();
                TextView textView9 = this.f10114s;
                if (textView9 != null) {
                    textView9.setTextColor(iIntValue3);
                }
                CheckBox checkBox2 = this.f10111p;
                if (checkBox2 != null) {
                    checkBox2.setTextColor(iIntValue3);
                }
                CheckBox checkBox3 = this.f10111p;
                if (checkBox3 != null) {
                    checkBox3.setButtonTintList(ColorStateList.valueOf(iIntValue3));
                }
            }
            Integer num4 = dVar15.f7478l;
            if (num4 != null) {
                int iIntValue4 = num4.intValue();
                TextView textView10 = this.f10114s;
                if (textView10 != null) {
                    textView10.setLinkTextColor(iIntValue4);
                }
                TextView textView11 = this.t;
                if (textView11 != null) {
                    textView11.setTextColor(iIntValue4);
                }
                TextView textView12 = this.f10110o;
                if (textView12 != null) {
                    textView12.setTextColor(iIntValue4);
                }
                TextView textView13 = this.f10109n;
                if (textView13 != null) {
                    textView13.setTextColor(iIntValue4);
                }
            }
            Integer num5 = dVar15.f7481o;
            if (num5 != null) {
                int iIntValue5 = num5.intValue();
                Button button2 = this.f10112q;
                if (button2 != null) {
                    button2.setBackgroundColor(iIntValue5);
                }
            }
            Integer num6 = dVar15.f7479m;
            if (num6 != null) {
                int iIntValue6 = num6.intValue();
                Button button3 = this.f10112q;
                if (button3 != null) {
                    button3.setTextColor(iIntValue6);
                }
            }
        }
        Typeface typeface = this.f11102l;
        if (typeface != null) {
            TextView textView14 = this.f10114s;
            if (textView14 != null) {
                textView14.setTypeface(typeface);
            }
            TextView textView15 = this.t;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f10110o;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f10109n;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            CheckBox checkBox4 = this.f10111p;
            if (checkBox4 != null) {
                checkBox4.setTypeface(typeface);
            }
            Button button4 = this.f10112q;
            if (button4 != null) {
                button4.setTypeface(typeface);
            }
        }
        d dVar16 = this.f10116v;
        if (dVar16 == null) {
            l.i("viewModel");
            throw null;
        }
        d0.i iVar9 = dVar16.f10120a;
        int i12 = iVar9.c(2, 3).equals("Y") ? 2 : 1;
        o8.i iVar10 = dVar16.f10123d;
        d0.i.r(iVar9, 2, i12, l.a((iVar10 != null && (cVar = iVar10.f11814b) != null) ? cVar.f11781d : null, "Y") ? 2 : 1);
        d dVar17 = this.f10116v;
        if (dVar17 != null) {
            dVar17.f10120a.q(77, true);
        } else {
            l.i("viewModel");
            throw null;
        }
    }
}
