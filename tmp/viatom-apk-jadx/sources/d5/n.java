package d5;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7239a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7240b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7241c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7242d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public Object f7243i;

    /* renamed from: j, reason: collision with root package name */
    public Object f7244j;

    public n(Locale locale, y2.c cVar, d0.i iVar, c1.d0 d0Var, a4.f fVar) {
        this.f7239a = 4;
        this.f7240b = locale;
        this.f7243i = cVar;
        this.f7241c = iVar;
        this.f7242d = d0Var;
        this.e = fVar;
        this.g = new d9.g();
        this.h = new d9.k();
        this.f7244j = new d9.p(null, null, null, null, null, null, null, null, null, null, 1023);
    }

    public static n l(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.feed_item_comment_view, (ViewGroup) null, false);
        int i10 = R.id.iv_icon_feed_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon_feed_item);
        if (imageView != null) {
            i10 = R.id.iv_star1_review_feed_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star1_review_feed_item);
            if (imageView2 != null) {
                i10 = R.id.iv_star2_review_feed_item;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star2_review_feed_item);
                if (imageView3 != null) {
                    i10 = R.id.iv_star3_review_feed_item;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star3_review_feed_item);
                    if (imageView4 != null) {
                        i10 = R.id.iv_star4_review_feed_item;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star4_review_feed_item);
                        if (imageView5 != null) {
                            i10 = R.id.iv_star5_review_feed_item;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_star5_review_feed_item);
                            if (imageView6 != null) {
                                i10 = R.id.ll_stars_review_feed_item;
                                if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_stars_review_feed_item)) != null) {
                                    i10 = R.id.tv_app_name_feed_item;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_app_name_feed_item);
                                    if (textView != null) {
                                        i10 = R.id.tv_body_feed_item;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_body_feed_item);
                                        if (textView2 != null) {
                                            return new n((RelativeLayout) viewInflate, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    public static void m(String str, JSONObject jSONObject) {
        StringBuilder sbV = a3.a.v(str);
        sbV.append(jSONObject.toString());
        String string = sbV.toString();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", string, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(y6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof f9.d
            if (r0 == 0) goto L13
            r0 = r5
            f9.d r0 = (f9.d) r0
            int r1 = r0.f8135d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8135d = r1
            goto L18
        L13:
            f9.d r0 = new f9.d
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8133b
            int r1 = r0.f8135d
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            d5.n r0 = r0.f8132a
            s6.a.e(r5)     // Catch: d6.a -> L64
            goto L60
        L27:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            r5 = 0
            return r5
        L2e:
            s6.a.e(r5)
            java.lang.Object r5 = r4.f7241c     // Catch: d6.a -> L63
            d0.i r5 = (d0.i) r5     // Catch: d6.a -> L63
            java.lang.String r1 = "en"
            r3 = 33
            r5.p(r3, r1)     // Catch: d6.a -> L63
            d9.g r5 = new d9.g     // Catch: d6.a -> L63
            r5.<init>()     // Catch: d6.a -> L63
            r4.g = r5     // Catch: d6.a -> L63
            d9.k r5 = new d9.k     // Catch: d6.a -> L63
            r5.<init>()     // Catch: d6.a -> L63
            r4.h = r5     // Catch: d6.a -> L63
            java.lang.Object r5 = r4.f7242d     // Catch: d6.a -> L63
            c1.d0 r5 = (c1.d0) r5     // Catch: d6.a -> L63
            java.lang.String r1 = r4.h()     // Catch: d6.a -> L63
            r0.f8132a = r4     // Catch: d6.a -> L63
            r0.f8135d = r2     // Catch: d6.a -> L63
            java.lang.Object r5 = r5.k(r1, r0)     // Catch: d6.a -> L63
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L5f
            return r0
        L5f:
            r0 = r4
        L60:
            java.lang.String r5 = (java.lang.String) r5     // Catch: d6.a -> L64
            return r5
        L63:
            r0 = r4
        L64:
            java.lang.Object r5 = r0.f7241c
            d0.i r5 = (d0.i) r5
            r0 = 28
            java.lang.String r5 = r5.t(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.n.a(y6.c):java.lang.Object");
    }

    public String b() {
        if (((d9.g) this.g).f7505w.length() != 0) {
            return ((d9.g) this.g).f7505w;
        }
        d9.t tVar = (d9.t) this.f;
        if (tVar != null) {
            return tVar.f7584a.f7505w;
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Iterable, java.lang.Object] */
    public d9.i c() {
        String str;
        String strH0;
        String str2;
        String str3;
        String str4;
        String str5;
        d9.q qVar;
        String str6;
        d9.q qVar2;
        i();
        if (((d9.g) this.g).f7488a.length() == 0) {
            d9.t tVar = (d9.t) this.f;
            if (tVar == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str = tVar.f7584a.f7488a;
        } else {
            str = ((d9.g) this.g).f7488a;
        }
        String str7 = str;
        if (((d9.k) this.h).f7536p.isEmpty()) {
            d9.t tVar2 = (d9.t) this.f;
            if (tVar2 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            strH0 = t6.l.h0(tVar2.f7586c.f7536p, " ", null, null, null, 62);
        } else {
            strH0 = t6.l.h0(((d9.k) this.h).f7536p, " ", null, null, null, 62);
        }
        String str8 = strH0;
        if (((d9.g) this.g).e.length() == 0) {
            d9.t tVar3 = (d9.t) this.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str2 = tVar3.f7584a.e;
        } else {
            str2 = ((d9.g) this.g).e;
        }
        String str9 = str2;
        if (((d9.g) this.g).f7489b.length() == 0) {
            d9.t tVar4 = (d9.t) this.f;
            if (tVar4 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str3 = tVar4.f7584a.f7489b;
        } else {
            str3 = ((d9.g) this.g).f7489b;
        }
        String str10 = str3;
        if (((d9.g) this.g).f7491d.length() == 0) {
            d9.t tVar5 = (d9.t) this.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar5.f7584a.f7491d;
        } else {
            str4 = ((d9.g) this.g).f7491d;
        }
        String str11 = str4;
        if (((d9.g) this.g).f7500q.length() == 0) {
            d9.t tVar6 = (d9.t) this.f;
            if (tVar6 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str5 = tVar6.f7584a.f7500q;
        } else {
            str5 = ((d9.g) this.g).f7500q;
        }
        String str12 = str5;
        String str13 = "";
        if (((d9.p) this.f7244j).f7574j.isEmpty()) {
            d9.t tVar7 = (d9.t) this.f;
            if (tVar7 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            ArrayList arrayList = tVar7.f7585b.f7574j;
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            if (arrayList != null && (qVar2 = (d9.q) t6.l.c0(arrayList)) != null) {
                str13 = qVar2.f7576b;
            }
        } else {
            ArrayList arrayList2 = ((d9.p) this.f7244j).f7574j;
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 != null && (qVar = (d9.q) t6.l.c0(arrayList2)) != null) {
                str13 = qVar.f7576b;
            }
        }
        String str14 = str13;
        if (((d9.g) this.g).E.length() == 0) {
            d9.t tVar8 = (d9.t) this.f;
            if (tVar8 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str6 = tVar8.f7584a.E;
        } else {
            str6 = ((d9.g) this.g).E;
        }
        String str15 = str6;
        d9.t tVar9 = (d9.t) this.f;
        if (tVar9 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        d9.e eVar = tVar9.f7587d;
        d9.e eVar2 = new d9.e(eVar.f7483a, eVar.f7484b, eVar.f7485c, eVar.f7486d, eVar.e, eVar.f);
        d9.t tVar10 = (d9.t) this.f;
        if (tVar10 != null) {
            d9.a aVar = tVar10.e;
            return new d9.i(str7, str8, str9, str10, str11, str12, str14, str15, eVar2, new d9.a(aVar.f7461a, aVar.f7462b, aVar.f7463c, aVar.f7464d, aVar.e));
        }
        kotlin.jvm.internal.l.i("translationsText");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(y6.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof f9.e
            if (r0 == 0) goto L13
            r0 = r8
            f9.e r0 = (f9.e) r0
            int r1 = r0.f8139d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8139d = r1
            goto L18
        L13:
            f9.e r0 = new f9.e
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f8137b
            int r1 = r0.f8139d
            r2 = 2
            r3 = 28
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L3e
            if (r1 == r4) goto L36
            if (r1 != r2) goto L2f
            d5.n r0 = r0.f8136a
            s6.a.e(r8)
            goto L95
        L2f:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            r8 = 0
            return r8
        L36:
            d5.n r1 = r0.f8136a
            s6.a.e(r8)     // Catch: d6.a -> L3c
            goto L5f
        L3c:
            r8 = move-exception
            goto L7d
        L3e:
            s6.a.e(r8)
            java.lang.Object r8 = r7.f7243i     // Catch: d6.a -> L62
            y2.c r8 = (y2.c) r8     // Catch: d6.a -> L62
            boolean r8 = r8.v()     // Catch: d6.a -> L62
            if (r8 == 0) goto L65
            java.lang.Object r8 = r7.f7242d     // Catch: d6.a -> L62
            c1.d0 r8 = (c1.d0) r8     // Catch: d6.a -> L62
            java.lang.String r1 = r7.h()     // Catch: d6.a -> L62
            r0.f8136a = r7     // Catch: d6.a -> L62
            r0.f8139d = r4     // Catch: d6.a -> L62
            java.lang.Object r8 = r8.k(r1, r0)     // Catch: d6.a -> L62
            if (r8 != r5) goto L5e
            goto L93
        L5e:
            r1 = r7
        L5f:
            java.lang.String r8 = (java.lang.String) r8     // Catch: d6.a -> L3c
            goto La1
        L62:
            r8 = move-exception
            r1 = r7
            goto L7d
        L65:
            com.inmobi.cmp.ChoiceCmp r8 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: d6.a -> L62
            com.inmobi.cmp.ChoiceCmpCallback r8 = r8.getCallback()     // Catch: d6.a -> L62
            if (r8 != 0) goto L6e
            goto L73
        L6e:
            com.inmobi.cmp.model.ChoiceError r1 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: d6.a -> L62
            r8.onCmpError(r1)     // Catch: d6.a -> L62
        L73:
            java.lang.Object r8 = r7.f7241c     // Catch: d6.a -> L62
            d0.i r8 = (d0.i) r8     // Catch: d6.a -> L62
            java.lang.String r8 = r8.t(r3)     // Catch: d6.a -> L62
            r1 = r7
            goto La1
        L7d:
            int[] r6 = f9.c.f8131a
            com.inmobi.cmp.model.ChoiceError r8 = r8.f7454a
            int r8 = r8.ordinal()
            r8 = r6[r8]
            if (r8 != r4) goto L99
            r0.f8136a = r1
            r0.f8139d = r2
            java.lang.Object r8 = r1.a(r0)
            if (r8 != r5) goto L94
        L93:
            return r5
        L94:
            r0 = r1
        L95:
            java.lang.String r8 = (java.lang.String) r8
            r1 = r0
            goto La1
        L99:
            java.lang.Object r8 = r1.f7241c
            d0.i r8 = (d0.i) r8
            java.lang.String r8 = r8.t(r3)
        La1:
            java.lang.Object r0 = r1.f7241c
            d0.i r0 = (d0.i) r0
            r0.p(r3, r8)
            java.lang.Object r0 = r1.e
            a4.f r0 = (a4.f) r0
            java.lang.Object r8 = r0.c(r8)
            d9.t r8 = (d9.t) r8
            r1.f = r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.n.d(y6.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Iterable, java.lang.Object] */
    public d9.l e() {
        String str;
        String strH0;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        i();
        if (((d9.g) this.g).f7488a.length() == 0) {
            d9.t tVar = (d9.t) this.f;
            if (tVar == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str = tVar.f7584a.f7488a;
        } else {
            str = ((d9.g) this.g).f7488a;
        }
        if (((d9.k) this.h).f7536p.isEmpty()) {
            d9.t tVar2 = (d9.t) this.f;
            if (tVar2 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            strH0 = t6.l.h0(tVar2.f7586c.f7536p, " ", null, null, null, 62);
        } else {
            strH0 = t6.l.h0(((d9.k) this.h).f7536p, " ", null, null, null, 62);
        }
        if (((d9.g) this.g).f7501r.length() == 0) {
            d9.t tVar3 = (d9.t) this.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str2 = tVar3.f7584a.f7501r;
        } else {
            str2 = ((d9.g) this.g).f7501r;
        }
        if (((d9.g) this.g).Q.length() == 0) {
            d9.t tVar4 = (d9.t) this.f;
            if (tVar4 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str3 = tVar4.f7584a.Q;
        } else {
            str3 = ((d9.g) this.g).Q;
        }
        if (((d9.k) this.h).f.length() == 0) {
            d9.t tVar5 = (d9.t) this.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar5.f7586c.f;
        } else {
            str4 = ((d9.k) this.h).f;
        }
        if (((d9.g) this.g).f7498o.length() == 0) {
            d9.t tVar6 = (d9.t) this.f;
            if (tVar6 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str5 = tVar6.f7584a.f7498o;
        } else {
            str5 = ((d9.g) this.g).f7498o;
        }
        if (((d9.g) this.g).f7490c.length() == 0) {
            d9.t tVar7 = (d9.t) this.f;
            if (tVar7 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str6 = tVar7.f7584a.f7490c;
        } else {
            str6 = ((d9.g) this.g).f7490c;
        }
        if (((d9.g) this.g).f7499p.length() == 0) {
            d9.t tVar8 = (d9.t) this.f;
            if (tVar8 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str7 = tVar8.f7584a.f7499p;
        } else {
            str7 = ((d9.g) this.g).f7499p;
        }
        if (((d9.g) this.g).A.length() == 0) {
            d9.t tVar9 = (d9.t) this.f;
            if (tVar9 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str8 = tVar9.f7584a.A;
        } else {
            str8 = ((d9.g) this.g).A;
        }
        if (((d9.g) this.g).f7500q.length() == 0) {
            d9.t tVar10 = (d9.t) this.f;
            if (tVar10 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str9 = tVar10.f7584a.f7500q;
        } else {
            str9 = ((d9.g) this.g).f7500q;
        }
        if (((d9.k) this.h).f7529i.length() == 0) {
            d9.t tVar11 = (d9.t) this.f;
            if (tVar11 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str10 = tVar11.f7586c.f7529i;
        } else {
            str10 = ((d9.k) this.h).f7529i;
        }
        if (((d9.k) this.h).f7530j.length() == 0) {
            d9.t tVar12 = (d9.t) this.f;
            if (tVar12 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str11 = tVar12.f7586c.f7530j;
        } else {
            str11 = ((d9.k) this.h).f7530j;
        }
        if (((d9.k) this.h).f7531k.length() == 0) {
            d9.t tVar13 = (d9.t) this.f;
            if (tVar13 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str12 = tVar13.f7586c.f7531k;
        } else {
            str12 = ((d9.k) this.h).f7531k;
        }
        if (((d9.k) this.h).f7532l.length() == 0) {
            d9.t tVar14 = (d9.t) this.f;
            if (tVar14 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str13 = tVar14.f7586c.f7532l;
        } else {
            str13 = ((d9.k) this.h).f7532l;
        }
        String strB = b();
        String str15 = str13;
        if (((d9.g) this.g).B.length() == 0) {
            d9.t tVar15 = (d9.t) this.f;
            if (tVar15 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str14 = tVar15.f7584a.B;
        } else {
            str14 = ((d9.g) this.g).B;
        }
        String str16 = str14;
        d9.t tVar16 = (d9.t) this.f;
        if (tVar16 == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        String str17 = str2;
        String str18 = str4;
        String str19 = str6;
        String str20 = str8;
        String str21 = str10;
        String str22 = str12;
        return new d9.l(str, strH0, str17, str3, str18, str5, str19, str7, str20, str9, str21, str11, str22, str15, strB, str16, tVar16.f7587d, tVar16.e);
    }

    public d9.n f() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        i();
        if (((d9.k) this.h).f.length() == 0) {
            d9.t tVar = (d9.t) this.f;
            if (tVar == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str = tVar.f7586c.f;
        } else {
            str = ((d9.k) this.h).f;
        }
        if (((d9.g) this.g).D.length() == 0) {
            d9.t tVar2 = (d9.t) this.f;
            if (tVar2 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str2 = tVar2.f7584a.D;
        } else {
            str2 = ((d9.g) this.g).D;
        }
        if (((d9.k) this.h).f7526b.length() == 0) {
            d9.t tVar3 = (d9.t) this.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str3 = tVar3.f7586c.f7526b;
        } else {
            str3 = ((d9.k) this.h).f7526b;
        }
        if (((d9.g) this.g).f7500q.length() == 0) {
            d9.t tVar4 = (d9.t) this.f;
            if (tVar4 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar4.f7584a.f7500q;
        } else {
            str4 = ((d9.g) this.g).f7500q;
        }
        if (((d9.k) this.h).f7528d.length() == 0) {
            d9.t tVar5 = (d9.t) this.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str5 = tVar5.f7586c.f7528d;
        } else {
            str5 = ((d9.k) this.h).f7528d;
        }
        if (((d9.k) this.h).e.length() == 0) {
            d9.t tVar6 = (d9.t) this.f;
            if (tVar6 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str6 = tVar6.f7586c.e;
        } else {
            str6 = ((d9.k) this.h).e;
        }
        String str7 = str4;
        String str8 = str6;
        return new d9.n(str, str2, str3, str7, str5, str8, b());
    }

    public d9.m g() {
        String str;
        String upperCase;
        String upperCase2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Locale locale = (Locale) this.f7240b;
        i();
        if (((d9.g) this.g).Q.length() == 0) {
            d9.t tVar = (d9.t) this.f;
            if (tVar == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str = tVar.f7584a.Q;
        } else {
            str = ((d9.g) this.g).Q;
        }
        String str14 = str;
        if (((d9.g) this.g).f7501r.length() == 0) {
            d9.t tVar2 = (d9.t) this.f;
            if (tVar2 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            upperCase = tVar2.f7584a.f7501r.toUpperCase(locale);
            upperCase.getClass();
        } else {
            upperCase = ((d9.g) this.g).f7501r.toUpperCase(locale);
            upperCase.getClass();
        }
        String str15 = upperCase;
        if (((d9.g) this.g).f7502s.length() == 0) {
            d9.t tVar3 = (d9.t) this.f;
            if (tVar3 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            upperCase2 = tVar3.f7584a.f7502s.toUpperCase(locale);
            upperCase2.getClass();
        } else {
            upperCase2 = ((d9.g) this.g).f7502s.toUpperCase(locale);
            upperCase2.getClass();
        }
        String str16 = upperCase2;
        if (((d9.g) this.g).f7503u.length() == 0) {
            d9.t tVar4 = (d9.t) this.f;
            if (tVar4 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str2 = tVar4.f7584a.f7503u;
        } else {
            str2 = ((d9.g) this.g).f7503u;
        }
        String str17 = str2;
        if (((d9.g) this.g).t.length() == 0) {
            d9.t tVar5 = (d9.t) this.f;
            if (tVar5 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str3 = tVar5.f7584a.t;
        } else {
            str3 = ((d9.g) this.g).t;
        }
        String str18 = str3;
        if (((d9.g) this.g).f7504v.length() == 0) {
            d9.t tVar6 = (d9.t) this.f;
            if (tVar6 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str4 = tVar6.f7584a.f7504v;
        } else {
            str4 = ((d9.g) this.g).f7504v;
        }
        String str19 = str4;
        if (((d9.g) this.g).E.length() == 0) {
            d9.t tVar7 = (d9.t) this.f;
            if (tVar7 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str5 = tVar7.f7584a.E;
        } else {
            str5 = ((d9.g) this.g).E;
        }
        String str20 = str5;
        if (((d9.g) this.g).R.length() == 0) {
            d9.t tVar8 = (d9.t) this.f;
            if (tVar8 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str6 = tVar8.f7584a.R;
        } else {
            str6 = ((d9.g) this.g).R;
        }
        String str21 = str6;
        if (((d9.g) this.g).S.length() == 0) {
            d9.t tVar9 = (d9.t) this.f;
            if (tVar9 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str7 = tVar9.f7584a.S;
        } else {
            str7 = ((d9.g) this.g).S;
        }
        String str22 = str7;
        if (((d9.g) this.g).T.length() == 0) {
            d9.t tVar10 = (d9.t) this.f;
            if (tVar10 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str8 = tVar10.f7584a.T;
        } else {
            str8 = ((d9.g) this.g).T;
        }
        String str23 = str8;
        if (((d9.g) this.g).U.length() == 0) {
            d9.t tVar11 = (d9.t) this.f;
            if (tVar11 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str9 = tVar11.f7584a.U;
        } else {
            str9 = ((d9.g) this.g).U;
        }
        String str24 = str9;
        if (((d9.g) this.g).V.length() == 0) {
            d9.t tVar12 = (d9.t) this.f;
            if (tVar12 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str10 = tVar12.f7584a.V;
        } else {
            str10 = ((d9.g) this.g).V;
        }
        String str25 = str10;
        if (((d9.g) this.g).W.length() == 0) {
            d9.t tVar13 = (d9.t) this.f;
            if (tVar13 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str11 = tVar13.f7584a.W;
        } else {
            str11 = ((d9.g) this.g).W;
        }
        String str26 = str11;
        if (((d9.g) this.g).X.length() == 0) {
            d9.t tVar14 = (d9.t) this.f;
            if (tVar14 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str12 = tVar14.f7584a.X;
        } else {
            str12 = ((d9.g) this.g).X;
        }
        String str27 = str12;
        String strB = b();
        if (((d9.g) this.g).Y.length() == 0) {
            d9.t tVar15 = (d9.t) this.f;
            if (tVar15 == null) {
                kotlin.jvm.internal.l.i("translationsText");
                throw null;
            }
            str13 = tVar15.f7584a.Y;
        } else {
            str13 = ((d9.g) this.g).Y;
        }
        return new d9.m(str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str27, str24, str25, str26, strB, str13);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f7239a) {
        }
        return (RelativeLayout) this.f7240b;
    }

    public String h() {
        String strB0;
        Locale locale = (Locale) this.f7240b;
        String str = (r0.f.t() || r0.f.l()) ? i9.a.h().f11814b.Y.f11825c : i9.a.h().f11814b.Y.f11823a;
        String strK = r0.f.k();
        if (str == null) {
            strB0 = null;
        } else {
            String lowerCase = strK.toLowerCase(locale);
            lowerCase.getClass();
            strB0 = o7.u.b0(str, "${language}", lowerCase, false);
        }
        if (strB0 != null) {
            return strB0;
        }
        StringBuilder sb = new StringBuilder("https://cmp.inmobi.com/tcfv2/translations/");
        String lowerCase2 = strK.toLowerCase(locale);
        lowerCase2.getClass();
        sb.append(lowerCase2);
        sb.append(".json");
        return sb.toString();
    }

    public void i() {
        if (((d9.t) this.f) == null) {
            String strT = ((d0.i) this.f7241c).t(28);
            this.f = strT.length() > 0 ? (d9.t) ((a4.f) this.e).c(strT) : new d9.t();
        }
    }

    public e2.d j(int i10) {
        e2.d dVar = null;
        try {
            if (!c.i.a(2, i10)) {
                JSONObject jSONObjectB = ((y2.c) this.e).B();
                if (jSONObjectB != null) {
                    e2.d dVarA = ((y2.c) this.f7241c).A(jSONObjectB);
                    m("Loaded cached settings: ", jSONObjectB);
                    ((t3.h) this.f7242d).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (c.i.a(3, i10) || dVarA.f7633c >= jCurrentTimeMillis) {
                        try {
                            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                                Log.v("FirebaseCrashlytics", "Returning cached settings.", null);
                            }
                            return dVarA;
                        } catch (Exception e) {
                            e = e;
                            dVar = dVarA;
                            Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            return dVar;
                        }
                    }
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Cached settings have expired.", null);
                        return null;
                    }
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "No cached settings data found.", null);
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public e2.d k() {
        return (e2.d) ((AtomicReference) this.h).get();
    }

    public n(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, UsernameTextView usernameTextView) {
        this.f7239a = 0;
        this.f7240b = relativeLayout;
        this.f7243i = frameLayout;
        this.f7241c = imageView;
        this.f7242d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = textView;
        this.h = textView2;
        this.f7244j = usernameTextView;
    }

    public n(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2) {
        this.f7239a = 1;
        this.f7240b = relativeLayout;
        this.f7241c = imageView;
        this.f7242d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.f7243i = imageView5;
        this.f7244j = imageView6;
        this.g = textView;
        this.h = textView2;
    }

    public n(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, UsernameTextView usernameTextView) {
        this.f7239a = 2;
        this.f7240b = relativeLayout;
        this.f7241c = imageView;
        this.f7242d = imageView2;
        this.e = imageView3;
        this.f7243i = relativeLayout2;
        this.g = textView;
        this.h = textView2;
        this.f = textView3;
        this.f7244j = usernameTextView;
    }

    public n(Context context, e2.e eVar, t3.h hVar, y2.c cVar, y2.c cVar2, e2.a aVar, w1.s sVar) {
        this.f7239a = 3;
        AtomicReference atomicReference = new AtomicReference();
        this.h = atomicReference;
        this.f7244j = new AtomicReference(new h1.i());
        this.f7240b = context;
        this.f7243i = eVar;
        this.f7242d = hVar;
        this.f7241c = cVar;
        this.e = cVar2;
        this.f = aVar;
        this.g = sVar;
        atomicReference.set(c1.d0.n(hVar));
    }
}
