package j;

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
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import c.h;
import c6.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.Regulations;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import kotlin.jvm.internal.l;
import r7.i0;
import r7.v0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b extends l9.a implements c.b {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f9861q = 0;

    /* renamed from: m, reason: collision with root package name */
    public TextView f9862m;

    /* renamed from: n, reason: collision with root package name */
    public Button f9863n;

    /* renamed from: o, reason: collision with root package name */
    public NestedScrollView f9864o;

    /* renamed from: p, reason: collision with root package name */
    public c f9865p;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onCancel(dialogInterface);
        c cVar = this.f9865p;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
        ChoiceCmpCallback choiceCmpCallback = cVar.f9867b;
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
        this.f9865p = (c) new ViewModelProvider(viewModelStore, new i(4)).get(c.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.gbc_privacy_screen, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f9862m = (TextView) view.findViewById(R.id.tv_gbc_description);
        this.f9863n = (Button) view.findViewById(R.id.btn_save_and_exit);
        this.f9864o = (NestedScrollView) view.findViewById(R.id.sv_container);
        getChildFragmentManager().beginTransaction().add(R.id.gbc_fragment_container, new d(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).addToBackStack(null).commit();
        TextView textView3 = this.f11096b;
        if (textView3 != null) {
            c cVar = this.f9865p;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            String string = cVar.f9868c.f11566b.f11559a;
            if (string.length() == 0) {
                string = getString(R.string.we_value_your_privacy);
                string.getClass();
            }
            textView3.setText(string);
        }
        TextView textView4 = this.f9862m;
        if (textView4 != null) {
            c cVar2 = this.f9865p;
            if (cVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String string2 = cVar2.f9868c.f11566b.f11561c;
            if (string2.length() == 0) {
                string2 = getString(R.string.gbc_description);
                string2.getClass();
            }
            textView4.setText(string2);
        }
        TextView textView5 = this.f9862m;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (context != null && (textView2 = this.f9862m) != null) {
            textView2.setLinkTextColor(ContextCompat.getColor(context, R.color.colorBlueAccent));
        }
        Button button = this.f9863n;
        if (button != null) {
            c cVar3 = this.f9865p;
            if (cVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String string3 = cVar3.f9868c.f11566b.f11562d;
            if (string3.length() == 0) {
                string3 = getString(R.string.save_and_exit);
                string3.getClass();
            }
            button.setText(string3);
        }
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            final int i10 = 0;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: j.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f9860b;

                {
                    this.f9860b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i11 = i10;
                    b bVar = this.f9860b;
                    switch (i11) {
                        case 0:
                            c cVar4 = bVar.f9865p;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
                            ChoiceCmpCallback choiceCmpCallback = cVar4.f9867b;
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
                            Fragment fragmentFindFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                            d dVar = fragmentFindFragmentByTag instanceof d ? (d) fragmentFindFragmentByTag : null;
                            if (dVar != null) {
                                dVar.a();
                            }
                            if (bVar.f9865p == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            y7.e eVar = i0.f12407a;
                            y.q(v0.f12442a, y7.d.f14116a, null, new b.l(2, null, 2), 2);
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
        Button button2 = this.f9863n;
        if (button2 != null) {
            final int i11 = 1;
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: j.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f9860b;

                {
                    this.f9860b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i112 = i11;
                    b bVar = this.f9860b;
                    switch (i112) {
                        case 0:
                            c cVar4 = bVar.f9865p;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            DisplayInfo displayInfo = new DisplayInfo(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
                            ChoiceCmpCallback choiceCmpCallback = cVar4.f9867b;
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
                            Fragment fragmentFindFragmentByTag = bVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                            d dVar = fragmentFindFragmentByTag instanceof d ? (d) fragmentFindFragmentByTag : null;
                            if (dVar != null) {
                                dVar.a();
                            }
                            if (bVar.f9865p == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            y7.e eVar = i0.f12407a;
                            y.q(v0.f12442a, y7.d.f14116a, null, new b.l(2, null, 2), 2);
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
        d9.d dVar = this.f11100j;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = dVar.f7471a;
            if (num2 != null) {
                int iIntValue = num2.intValue();
                NestedScrollView nestedScrollView = this.f9864o;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, iIntValue);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar.f7475i;
            if (num3 != null) {
                int iIntValue2 = num3.intValue();
                TextView textView6 = this.f9862m;
                if (textView6 != null) {
                    textView6.setTextColor(iIntValue2);
                }
            }
            Integer num4 = dVar.f7481o;
            if (num4 != null) {
                int iIntValue3 = num4.intValue();
                Button button3 = this.f9863n;
                if (button3 != null) {
                    button3.setBackgroundColor(iIntValue3);
                }
            }
            Integer num5 = dVar.f7479m;
            if (num5 != null) {
                int iIntValue4 = num5.intValue();
                Button button4 = this.f9863n;
                if (button4 != null) {
                    button4.setTextColor(iIntValue4);
                }
            }
        }
        Typeface typeface = this.f11102l;
        if (typeface == null || (textView = this.f9862m) == null) {
            return;
        }
        textView.setTypeface(typeface);
    }

    @Override // c.b
    public final void g(h hVar) {
    }

    @Override // c.b
    public final void h(h hVar) {
    }
}
