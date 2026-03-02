package l9;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import b9.s;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends a {
    public static int y;

    /* renamed from: z, reason: collision with root package name */
    public static int f11122z;

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f11123m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f11124n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f11125o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f11126p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f11127q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f11128r;

    /* renamed from: s, reason: collision with root package name */
    public NestedScrollView f11129s;
    public RecyclerView t;

    /* renamed from: u, reason: collision with root package name */
    public e6.d f11130u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11131v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11132w;

    /* renamed from: x, reason: collision with root package name */
    public String f11133x;

    public final void a() {
        if (this.f11131v) {
            NestedScrollView nestedScrollView = this.f11129s;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            RecyclerView recyclerView = this.t;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            this.f11131v = false;
            return;
        }
        UUID uuid = s.f936a;
        StringBuilder sb = new StringBuilder();
        int i10 = f11122z;
        if (i10 == 0) {
            kotlin.jvm.internal.l.i("localSwitchItemType");
            throw null;
        }
        int iC = c.i.c(i10);
        int i11 = 6;
        if (iC != 5) {
            if (iC != 6) {
                i11 = 7;
                if (iC != 7) {
                    i11 = 3;
                }
            } else {
                i11 = 1;
            }
        }
        sb.append(a.a.d(i11));
        sb.append("-id:");
        sb.append(y);
        s.f937b.h("collapseElement", sb.toString());
        dismiss();
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.f11130u = (e6.d) new ViewModelProvider(viewModelStore, new c6.i(1)).get(e6.d.class);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        h hVar = context == null ? null : new h(context, this);
        if (hVar != null) {
            return hVar;
        }
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getClass();
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        return layoutInflater.inflate(R.layout.dialog_legal_detail, viewGroup, false);
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        String str;
        view.getClass();
        super.onViewCreated(view, bundle);
        TextView textView2 = this.f11096b;
        if (textView2 != null) {
            int i10 = f11122z;
            if (i10 == 0) {
                kotlin.jvm.internal.l.i("localSwitchItemType");
                throw null;
            }
            int iC = c.i.c(i10);
            if (iC != 4) {
                e6.d dVar = this.f11130u;
                if (iC != 5) {
                    if (iC != 6) {
                        if (dVar == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        str = dVar.f.e().f7540d;
                    } else {
                        if (dVar == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        str = dVar.f.e().f;
                    }
                } else {
                    if (dVar == null) {
                        kotlin.jvm.internal.l.i("viewModel");
                        throw null;
                    }
                    str = dVar.f.e().f;
                }
            } else {
                e6.d dVar2 = this.f11130u;
                if (dVar2 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                str = dVar2.f.e().f7540d;
            }
            textView2.setText(str);
        }
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            final int i11 = 0;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: l9.i

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ j f11121b;

                {
                    this.f11121b = this;
                }

                /* JADX WARN: Removed duplicated region for block: B:158:0x031c A[PHI: r8
                  0x031c: PHI (r8v8 java.util.ArrayList) = (r8v2 java.util.ArrayList), (r8v2 java.util.ArrayList), (r8v4 java.util.ArrayList), (r8v2 java.util.ArrayList) binds: [B:177:0x03a2, B:178:0x03a4, B:253:0x031c, B:156:0x0319] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void onClick(android.view.View r26) {
                    /*
                        Method dump skipped, instructions count: 1124
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: l9.i.onClick(android.view.View):void");
                }
            });
            e6.d dVar3 = this.f11130u;
            if (dVar3 == null) {
                kotlin.jvm.internal.l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(dVar3.f.e().f7547o);
        }
        this.f11123m = (ConstraintLayout) view.findViewById(R.id.legal_detail_container);
        this.f11124n = (TextView) view.findViewById(R.id.detail_legal_description_label);
        this.f11125o = (TextView) view.findViewById(R.id.detail_legal_description);
        this.f11126p = (TextView) view.findViewById(R.id.detail_description);
        this.f11127q = (TextView) view.findViewById(R.id.detail_title);
        this.f11128r = (TextView) view.findViewById(R.id.tv_show_partners);
        this.f11129s = (NestedScrollView) view.findViewById(R.id.sc_description_container);
        this.t = (RecyclerView) view.findViewById(R.id.rv_purpose_partners_list);
        e6.d dVar4 = this.f11130u;
        if (dVar4 == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        String str2 = dVar4.f.e().f7548p;
        if (str2.length() > 0) {
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new UnderlineSpan(), 0, str2.length(), 0);
            TextView textView3 = this.f11128r;
            if (textView3 != null) {
                textView3.setText(spannableString);
            }
        }
        TextView textView4 = this.f11128r;
        if (textView4 != null) {
            final int i12 = 1;
            textView4.setOnClickListener(new View.OnClickListener(this) { // from class: l9.i

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ j f11121b;

                {
                    this.f11121b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View v6) {
                    /*
                        Method dump skipped, instructions count: 1124
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: l9.i.onClick(android.view.View):void");
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView5 = this.f11127q;
            if (textView5 != null) {
                textView5.setText(arguments.getString(CampaignEx.JSON_KEY_TITLE, ""));
            }
            TextView textView6 = this.f11126p;
            if (textView6 != null) {
                textView6.setText(arguments.getString("description", ""));
            }
            TextView textView7 = this.f11125o;
            if (textView7 != null) {
                textView7.setText(arguments.getString("legal_description", ""));
            }
            TextView textView8 = this.f11124n;
            if (textView8 != null) {
                textView8.setText(arguments.getString("legal_description_label", ""));
            }
            this.f11132w = arguments.getBoolean("legitimate_interest", false);
            this.f11133x = arguments.getString("vendor_type_selected", "");
        }
        d9.d dVar5 = this.f11100j;
        if (dVar5 != null) {
            Integer num = dVar5.f7475i;
            if (num != null) {
                int iIntValue = num.intValue();
                TextView textView9 = this.f11127q;
                if (textView9 != null) {
                    textView9.setTextColor(iIntValue);
                }
                TextView textView10 = this.f11126p;
                if (textView10 != null) {
                    textView10.setTextColor(iIntValue);
                }
                TextView textView11 = this.f11125o;
                if (textView11 != null) {
                    textView11.setTextColor(iIntValue);
                }
                TextView textView12 = this.f11124n;
                if (textView12 != null) {
                    textView12.setTextColor(iIntValue);
                }
            }
            Integer num2 = dVar5.f7478l;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                TextView textView13 = this.f11128r;
                if (textView13 != null) {
                    textView13.setTextColor(iIntValue2);
                }
            }
            Integer num3 = dVar5.g;
            if (num3 != null) {
                int iIntValue3 = num3.intValue();
                ConstraintLayout constraintLayout = this.f11123m;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(iIntValue3);
                }
            }
        }
        Typeface typeface = this.f11101k;
        if (typeface != null && (textView = this.f11127q) != null) {
            textView.setTypeface(typeface);
        }
        Typeface typeface2 = this.f11102l;
        if (typeface2 == null) {
            return;
        }
        TextView textView14 = this.f11128r;
        if (textView14 != null) {
            textView14.setTypeface(typeface2);
        }
        TextView textView15 = this.f11126p;
        if (textView15 != null) {
            textView15.setTypeface(typeface2);
        }
        TextView textView16 = this.f11125o;
        if (textView16 != null) {
            textView16.setTypeface(typeface2);
        }
        TextView textView17 = this.f11124n;
        if (textView17 == null) {
            return;
        }
        textView17.setTypeface(typeface2);
    }
}
