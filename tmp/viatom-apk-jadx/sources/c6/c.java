package c6;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import com.uptodown.R;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends l9.a {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f1780x = 0;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f1781m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f1782n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f1783o;

    /* renamed from: p, reason: collision with root package name */
    public Button f1784p;

    /* renamed from: q, reason: collision with root package name */
    public Button f1785q;

    /* renamed from: r, reason: collision with root package name */
    public CardView f1786r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f1787s;
    public TextView t;

    /* renamed from: u, reason: collision with root package name */
    public NestedScrollView f1788u;

    /* renamed from: v, reason: collision with root package name */
    public k9.d f1789v;

    /* renamed from: w, reason: collision with root package name */
    public h f1790w;

    public final void a(TextView textView, String str, String str2, boolean z9) {
        if (textView == null) {
            return;
        }
        textView.setText(str2);
        textView.setVisibility(z9 ? 0 : 8);
        textView.setOnClickListener(new b5.a(4, this, str));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
        h hVar = this.f1790w;
        if (hVar == null) {
            l.i("mspaViewModel");
            throw null;
        }
        DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, j.g.f9878a);
        ChoiceCmpCallback choiceCmpCallback = hVar.f1811c;
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
        this.f1789v = (k9.d) new ViewModelProvider(viewModelStore, new i(6)).get(k9.d.class);
        ViewModelStore viewModelStore2 = getViewModelStore();
        viewModelStore2.getClass();
        this.f1790w = (h) new ViewModelProvider(viewModelStore2, new i(0)).get(h.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_mspa_privacy, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        o8.i iVar;
        o8.c cVar;
        o8.c cVar2;
        o8.i iVar2;
        o8.c cVar3;
        o8.c cVar4;
        o8.i iVar3;
        o8.c cVar5;
        o8.c cVar6;
        o8.c cVar7;
        TextView textView;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f1781m = (LinearLayout) view.findViewById(R.id.container_ccpa_links);
        this.f1782n = (TextView) view.findViewById(R.id.tv_privacy_policy_link);
        this.f1783o = (TextView) view.findViewById(R.id.tv_delete_data_link);
        this.t = (TextView) view.findViewById(R.id.tv_access_data_link);
        this.f1786r = (CardView) view.findViewById(R.id.bottom_container);
        this.f1787s = (TextView) view.findViewById(R.id.tv_ccpa_content);
        this.f1788u = (NestedScrollView) view.findViewById(R.id.sv_container);
        this.f1784p = (Button) view.findViewById(R.id.btn_preferences);
        this.f1785q = (Button) view.findViewById(R.id.btn_confirm);
        h hVar = this.f1790w;
        if (hVar == null) {
            l.i("mspaViewModel");
            throw null;
        }
        m8.e.i(hVar.f1809a);
        TextView textView2 = this.f11096b;
        if (textView2 != null) {
            k9.d dVar = this.f1789v;
            if (dVar == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            String string = dVar.f10122c.f7465a;
            if (string.length() == 0) {
                string = getString(R.string.ccpa_privacy_title);
                string.getClass();
            }
            textView2.setText(string);
        }
        k9.d dVar2 = this.f1789v;
        if (dVar2 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        int length = dVar2.b().length();
        TextView textView3 = this.f1787s;
        if (length > 0) {
            if (textView3 != null) {
                k9.d dVar3 = this.f1789v;
                if (dVar3 == null) {
                    l.i("ccpaViewModel");
                    throw null;
                }
                textView3.setText(l1.b.a(dVar3.b()));
            }
        } else if (textView3 != null) {
            textView3.setText(R.string.ccpa_content_message);
        }
        TextView textView4 = this.f1787s;
        String str = "";
        if (textView4 != null) {
            k9.d dVar4 = this.f1789v;
            if (dVar4 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            textView4.append(j.g.f9878a ? dVar4.f.f11566b.f11561c : "");
        }
        TextView textView5 = this.f1787s;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (context != null && (textView = this.f1787s) != null) {
            textView.setLinkTextColor(ContextCompat.getColor(context, R.color.colorBlueAccent));
        }
        LinearLayout linearLayout = this.f1781m;
        boolean z9 = false;
        if (linearLayout != null) {
            k9.d dVar5 = this.f1789v;
            if (dVar5 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            o8.i iVar4 = dVar5.f10123d;
            linearLayout.setVisibility((iVar4 == null || (cVar7 = iVar4.f11814b) == null || !cVar7.C) ? 0 : 8);
        }
        TextView textView6 = this.f1783o;
        k9.d dVar6 = this.f1789v;
        if (dVar6 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        o8.i iVar5 = dVar6.f10123d;
        String str2 = (iVar5 == null || (cVar6 = iVar5.f11814b) == null) ? "" : cVar6.D;
        String strC = dVar6.c();
        k9.d dVar7 = this.f1789v;
        if (dVar7 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        a(textView6, str2, strC, dVar7.c().length() > 0 && (iVar3 = dVar7.f10123d) != null && (cVar5 = iVar3.f11814b) != null && cVar5.D.length() > 0);
        TextView textView7 = this.t;
        k9.d dVar8 = this.f1789v;
        if (dVar8 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        o8.i iVar6 = dVar8.f10123d;
        String str3 = (iVar6 == null || (cVar4 = iVar6.f11814b) == null) ? "" : cVar4.E;
        String strA = dVar8.a();
        k9.d dVar9 = this.f1789v;
        if (dVar9 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        a(textView7, str3, strA, dVar9.a().length() > 0 && (iVar2 = dVar9.f10123d) != null && (cVar3 = iVar2.f11814b) != null && cVar3.E.length() > 0);
        TextView textView8 = this.f1782n;
        k9.d dVar10 = this.f1789v;
        if (dVar10 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        o8.i iVar7 = dVar10.f10123d;
        if (iVar7 != null && (cVar2 = iVar7.f11814b) != null) {
            str = cVar2.F;
        }
        String strD = dVar10.d();
        k9.d dVar11 = this.f1789v;
        if (dVar11 == null) {
            l.i("ccpaViewModel");
            throw null;
        }
        if (dVar11.d().length() > 0 && (iVar = dVar11.f10123d) != null && (cVar = iVar.f11814b) != null && cVar.F.length() > 0) {
            z9 = true;
        }
        a(textView8, str, strD, z9);
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            final int i10 = 0;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: c6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ c f1777b;

                {
                    this.f1777b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction fragmentTransactionBeginTransaction;
                    FragmentTransaction fragmentTransactionAdd;
                    int i11 = i10;
                    c cVar8 = this.f1777b;
                    switch (i11) {
                        case 0:
                            h hVar2 = cVar8.f1790w;
                            if (hVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, j.g.f9878a);
                            ChoiceCmpCallback choiceCmpCallback = hVar2.f1811c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            cVar8.dismiss();
                            FragmentActivity activity = cVar8.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            h hVar3 = cVar8.f1790w;
                            if (hVar3 != null) {
                                hVar3.a().observe(cVar8, new b(cVar8, 0));
                                return;
                            } else {
                                l.i("mspaViewModel");
                                throw null;
                            }
                        default:
                            FragmentActivity activity2 = cVar8.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction()) == null || (fragmentTransactionAdd = fragmentTransactionBeginTransaction.add(new f(), "d0.b")) == null) {
                                return;
                            }
                            fragmentTransactionAdd.commit();
                            return;
                    }
                }
            });
            k9.d dVar12 = this.f1789v;
            if (dVar12 == null) {
                l.i("ccpaViewModel");
                throw null;
            }
            imageView.setContentDescription(dVar12.f10122c.f);
        }
        Button button = this.f1785q;
        if (button != null) {
            final int i11 = 1;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: c6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ c f1777b;

                {
                    this.f1777b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction fragmentTransactionBeginTransaction;
                    FragmentTransaction fragmentTransactionAdd;
                    int i112 = i11;
                    c cVar8 = this.f1777b;
                    switch (i112) {
                        case 0:
                            h hVar2 = cVar8.f1790w;
                            if (hVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, j.g.f9878a);
                            ChoiceCmpCallback choiceCmpCallback = hVar2.f1811c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            cVar8.dismiss();
                            FragmentActivity activity = cVar8.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            h hVar3 = cVar8.f1790w;
                            if (hVar3 != null) {
                                hVar3.a().observe(cVar8, new b(cVar8, 0));
                                return;
                            } else {
                                l.i("mspaViewModel");
                                throw null;
                            }
                        default:
                            FragmentActivity activity2 = cVar8.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction()) == null || (fragmentTransactionAdd = fragmentTransactionBeginTransaction.add(new f(), "d0.b")) == null) {
                                return;
                            }
                            fragmentTransactionAdd.commit();
                            return;
                    }
                }
            });
        }
        Button button2 = this.f1784p;
        if (button2 != null) {
            final int i12 = 2;
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: c6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ c f1777b;

                {
                    this.f1777b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentManager supportFragmentManager;
                    FragmentTransaction fragmentTransactionBeginTransaction;
                    FragmentTransaction fragmentTransactionAdd;
                    int i112 = i12;
                    c cVar8 = this.f1777b;
                    switch (i112) {
                        case 0:
                            h hVar2 = cVar8.f1790w;
                            if (hVar2 == null) {
                                l.i("mspaViewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed US regulations screen", Regulations.MSPA, j.g.f9878a);
                            ChoiceCmpCallback choiceCmpCallback = hVar2.f1811c;
                            if (choiceCmpCallback != null) {
                                choiceCmpCallback.onCMPUIStatusChanged(displayInfo);
                            }
                            cVar8.dismiss();
                            FragmentActivity activity = cVar8.getActivity();
                            if (activity == null) {
                                return;
                            }
                            activity.finish();
                            return;
                        case 1:
                            h hVar3 = cVar8.f1790w;
                            if (hVar3 != null) {
                                hVar3.a().observe(cVar8, new b(cVar8, 0));
                                return;
                            } else {
                                l.i("mspaViewModel");
                                throw null;
                            }
                        default:
                            FragmentActivity activity2 = cVar8.getActivity();
                            if (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null || (fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction()) == null || (fragmentTransactionAdd = fragmentTransactionBeginTransaction.add(new f(), "d0.b")) == null) {
                                return;
                            }
                            fragmentTransactionAdd.commit();
                            return;
                    }
                }
            });
        }
        d9.d dVar13 = this.f11100j;
        if (dVar13 != null) {
            Integer num = dVar13.g;
            if (num != null) {
                int iIntValue = num.intValue();
                view.setBackgroundColor(iIntValue);
                CardView cardView = this.f1786r;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(iIntValue);
                }
            }
            Integer num2 = dVar13.f7471a;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                NestedScrollView nestedScrollView = this.f1788u;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, iIntValue2);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar13.f7475i;
            if (num3 != null) {
                int iIntValue3 = num3.intValue();
                TextView textView9 = this.f1787s;
                if (textView9 != null) {
                    textView9.setTextColor(iIntValue3);
                }
            }
            Integer num4 = dVar13.f7478l;
            if (num4 != null) {
                int iIntValue4 = num4.intValue();
                TextView textView10 = this.f1787s;
                if (textView10 != null) {
                    textView10.setLinkTextColor(iIntValue4);
                }
                TextView textView11 = this.t;
                if (textView11 != null) {
                    textView11.setTextColor(iIntValue4);
                }
                TextView textView12 = this.f1783o;
                if (textView12 != null) {
                    textView12.setTextColor(iIntValue4);
                }
                TextView textView13 = this.f1782n;
                if (textView13 != null) {
                    textView13.setTextColor(iIntValue4);
                }
            }
            Integer num5 = dVar13.f7481o;
            if (num5 != null) {
                int iIntValue5 = num5.intValue();
                Button button3 = this.f1784p;
                if (button3 != null) {
                    button3.setBackgroundColor(iIntValue5);
                }
                Button button4 = this.f1785q;
                if (button4 != null) {
                    button4.setBackgroundColor(iIntValue5);
                }
            }
            Integer num6 = dVar13.f7479m;
            if (num6 != null) {
                int iIntValue6 = num6.intValue();
                Button button5 = this.f1784p;
                if (button5 != null) {
                    button5.setTextColor(iIntValue6);
                }
                Button button6 = this.f1785q;
                if (button6 != null) {
                    button6.setTextColor(iIntValue6);
                }
            }
        }
        Typeface typeface = this.f11102l;
        if (typeface != null) {
            TextView textView14 = this.f1787s;
            if (textView14 != null) {
                textView14.setTypeface(typeface);
            }
            TextView textView15 = this.t;
            if (textView15 != null) {
                textView15.setTypeface(typeface);
            }
            TextView textView16 = this.f1783o;
            if (textView16 != null) {
                textView16.setTypeface(typeface);
            }
            TextView textView17 = this.f1782n;
            if (textView17 != null) {
                textView17.setTypeface(typeface);
            }
            Button button7 = this.f1785q;
            if (button7 != null) {
                button7.setTypeface(typeface);
            }
            Button button8 = this.f1784p;
            if (button8 != null) {
                button8.setTypeface(typeface);
            }
        }
        h hVar2 = this.f1790w;
        if (hVar2 == null) {
            l.i("mspaViewModel");
            throw null;
        }
        if (!m8.e.f11252d) {
            hVar2.c();
        }
        m8.e.f11252d = true;
        i9.a.j().q(67, true);
        if (this.f1790w == null) {
            l.i("mspaViewModel");
            throw null;
        }
        if (j.g.f9878a) {
            i9.a.j().q(92, true);
        }
    }
}
