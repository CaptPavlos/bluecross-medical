package c;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.R;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class g extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f958a;

    /* renamed from: b, reason: collision with root package name */
    public final b f959b;

    /* renamed from: c, reason: collision with root package name */
    public final String f960c;

    /* renamed from: d, reason: collision with root package name */
    public final String f961d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;

    /* renamed from: i, reason: collision with root package name */
    public final Typeface f962i;

    /* renamed from: j, reason: collision with root package name */
    public final Typeface f963j;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ g(java.util.ArrayList r14, c.b r15, java.lang.String r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.Integer r19, java.lang.Integer r20, android.graphics.Typeface r21, android.graphics.Typeface r22, int r23) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            java.lang.String r6 = ""
            if (r1 == 0) goto La
            r5 = r6
            goto Lc
        La:
            r5 = r16
        Lc:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L13
            r8 = r2
            goto L15
        L13:
            r8 = r18
        L15:
            r1 = r0 & 64
            if (r1 == 0) goto L1b
            r9 = r2
            goto L1d
        L1b:
            r9 = r19
        L1d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L2c
            r11 = r2
            r3 = r14
            r4 = r15
            r7 = r17
            r10 = r20
            r12 = r22
            r2 = r13
            goto L37
        L2c:
            r11 = r21
            r2 = r13
            r3 = r14
            r4 = r15
            r7 = r17
            r10 = r20
            r12 = r22
        L37:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.g.<init>(java.util.ArrayList, c.b, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, android.graphics.Typeface, android.graphics.Typeface, int):void");
    }

    public final void a() {
        this.f958a.add(0, new h(new k8.d(), null, 2, 0, null, null, R.styleable.ConstraintSet_transitionPathRotate));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f958a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i.c(((h) this.f958a.get(i10)).f966c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) throws Resources.NotFoundException {
        viewHolder.getClass();
        if (!(viewHolder instanceof f)) {
            if (viewHolder instanceof c) {
                c cVar = (c) viewHolder;
                String str = this.f960c;
                str.getClass();
                TextView textView = cVar.f945d;
                textView.setText(str);
                Integer num = cVar.f942a;
                if (num != null) {
                    textView.setTextColor(num.intValue());
                }
                Typeface typeface = cVar.f944c;
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
                Integer num2 = cVar.f943b;
                if (num2 == null) {
                    return;
                }
                int iIntValue = num2.intValue();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(2.0f);
                gradientDrawable.setStroke(4, iIntValue);
                textView.setBackground(gradientDrawable);
                return;
            }
            if (viewHolder instanceof d) {
                d dVar = (d) viewHolder;
                String str2 = ((h) this.f958a.get(i10)).f;
                str2.getClass();
                TextView textView2 = dVar.f949d;
                textView2.setText(str2);
                Integer num3 = dVar.f946a;
                if (num3 != null) {
                    textView2.setTextColor(num3.intValue());
                }
                Typeface typeface2 = dVar.f948c;
                if (typeface2 != null) {
                    textView2.setTypeface(typeface2);
                }
                Integer num4 = dVar.f947b;
                if (num4 == null) {
                    return;
                }
                dVar.e.setBackgroundColor(num4.intValue());
                return;
            }
            if (viewHolder instanceof a) {
                a aVar = (a) viewHolder;
                String str3 = ((h) this.f958a.get(i10)).f;
                str3.getClass();
                TextView textView3 = aVar.f941d;
                textView3.setText(str3);
                Integer num5 = aVar.f938a;
                if (num5 != null) {
                    textView3.setTextColor(num5.intValue());
                }
                Typeface typeface3 = aVar.f940c;
                if (typeface3 != null) {
                    textView3.setTypeface(typeface3);
                }
                Integer num6 = aVar.f939b;
                if (num6 == null) {
                    return;
                }
                aVar.e.setBackgroundColor(num6.intValue());
                return;
            }
            return;
        }
        final f fVar = (f) viewHolder;
        final h hVar = (h) this.f958a.get(i10);
        SwitchCompat switchCompat = fVar.h;
        Typeface typeface4 = fVar.f;
        Integer num7 = fVar.f954b;
        hVar.getClass();
        final String str4 = this.f961d;
        str4.getClass();
        TextView textView4 = fVar.g;
        k8.d dVar2 = hVar.f964a;
        String string = dVar2.f10089b;
        Integer num8 = hVar.g;
        String str5 = hVar.f;
        string.getClass();
        str5.getClass();
        if (num8 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" (");
            sb.append(num8);
            sb.append(' ');
            String lowerCase = str5.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            sb.append(lowerCase);
            sb.append(')');
            string = sb.toString();
        }
        textView4.setText(string);
        if (num7 != null) {
            textView4.setTextColor(num7.intValue());
        }
        textView4.setOnClickListener(new b5.a(3, fVar, hVar));
        if (typeface4 != null) {
            textView4.setTypeface(typeface4);
        }
        if (hVar.f965b == null) {
            switchCompat.setVisibility(8);
        } else {
            switchCompat.setVisibility(0);
            Boolean bool = hVar.f965b;
            switchCompat.setChecked(bool == null ? false : bool.booleanValue());
        }
        switchCompat.setContentDescription(dVar2.f10089b);
        switchCompat.setText((switchCompat.isChecked() || !hVar.e) ? "" : str4);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                f fVar2 = fVar;
                fVar2.getClass();
                String str6 = str4;
                str6.getClass();
                Boolean boolValueOf = Boolean.valueOf(z9);
                h hVar2 = hVar;
                hVar2.f965b = boolValueOf;
                fVar2.f953a.h(hVar2);
                boolean z10 = hVar2.e;
                SwitchCompat switchCompat2 = fVar2.h;
                if (switchCompat2.isChecked() || !z10) {
                    str6 = "";
                }
                switchCompat2.setText(str6);
            }
        });
        Integer num9 = fVar.f955c;
        if (num9 != null) {
            int iIntValue2 = num9.intValue();
            Integer num10 = fVar.f956d;
            if (num10 != null) {
                int iIntValue3 = num10.intValue();
                switchCompat.setThumbTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[0]}, new int[]{iIntValue2, iIntValue3}));
                switchCompat.setTrackTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[0]}, new int[]{ColorUtils.setAlphaComponent(iIntValue2, 128), ColorUtils.setAlphaComponent(iIntValue3, 128)}));
            }
        }
        if (num7 != null) {
            switchCompat.setTextColor(num7.intValue());
        }
        if (typeface4 != null) {
            switchCompat.setTypeface(typeface4);
        }
        Integer num11 = fVar.e;
        if (num11 == null) {
            return;
        }
        fVar.f957i.setBackgroundColor(num11.intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        Typeface typeface = this.f963j;
        Integer num = this.h;
        Integer num2 = this.e;
        if (i10 == 1) {
            View viewB = i.b(viewGroup, com.uptodown.R.layout.list_item_switch_description, viewGroup, false);
            viewB.getClass();
            return new c(viewB, num2, num, typeface);
        }
        if (i10 == 2) {
            View viewB2 = i.b(viewGroup, com.uptodown.R.layout.list_item_switch_label, viewGroup, false);
            viewB2.getClass();
            return new d(viewB2, num2, num, this.f962i);
        }
        if (i10 == 3) {
            View viewB3 = i.b(viewGroup, com.uptodown.R.layout.list_item_non_switch, viewGroup, false);
            viewB3.getClass();
            return new a(viewB3, num2, num, typeface);
        }
        View viewB4 = i.b(viewGroup, com.uptodown.R.layout.list_item_switch, viewGroup, false);
        viewB4.getClass();
        return new f(viewB4, this.f959b, this.e, this.f, this.g, this.h, this.f963j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        viewHolder.getClass();
        if (viewHolder instanceof f) {
            ((f) viewHolder).h.setOnCheckedChangeListener(null);
        }
        super.onViewRecycled(viewHolder);
    }

    public g(ArrayList arrayList, b bVar, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface, Typeface typeface2) {
        str.getClass();
        str2.getClass();
        this.f958a = arrayList;
        this.f959b = bVar;
        this.f960c = str;
        this.f961d = str2;
        this.e = num;
        this.f = num2;
        this.g = num3;
        this.h = num4;
        this.f962i = typeface;
        this.f963j = typeface2;
        if (str.length() > 0) {
            a();
        }
    }
}
