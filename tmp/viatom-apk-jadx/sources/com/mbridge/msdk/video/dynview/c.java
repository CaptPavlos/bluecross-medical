package com.mbridge.msdk.video.dynview;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f5691a;

    /* renamed from: b, reason: collision with root package name */
    private String f5692b;

    /* renamed from: c, reason: collision with root package name */
    private int f5693c;

    /* renamed from: d, reason: collision with root package name */
    private float f5694d;
    private float e;
    private int f;
    private int g;
    private View h;

    /* renamed from: i, reason: collision with root package name */
    private List<CampaignEx> f5695i;

    /* renamed from: j, reason: collision with root package name */
    private int f5696j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5697k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f5698l;

    /* renamed from: m, reason: collision with root package name */
    private int f5699m;

    /* renamed from: n, reason: collision with root package name */
    private String f5700n;

    /* renamed from: o, reason: collision with root package name */
    private int f5701o;

    /* renamed from: p, reason: collision with root package name */
    private int f5702p;

    /* renamed from: q, reason: collision with root package name */
    private String f5703q;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        b a(float f);

        b a(int i10);

        b a(Context context);

        b a(View view);

        b a(String str);

        b a(List<CampaignEx> list);

        b a(boolean z9);

        c a();

        b b(float f);

        b b(int i10);

        b b(String str);

        b b(List<String> list);

        b c(int i10);

        b c(String str);

        b d(int i10);

        b e(int i10);

        b f(int i10);

        b g(int i10);
    }

    private c(a aVar) {
        this.e = aVar.e;
        this.f5694d = aVar.f5707d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.f5691a = aVar.f5704a;
        this.f5692b = aVar.f5705b;
        this.f5693c = aVar.f5706c;
        this.h = aVar.h;
        this.f5695i = aVar.f5708i;
        this.f5696j = aVar.f5709j;
        this.f5697k = aVar.f5710k;
        this.f5698l = aVar.f5711l;
        this.f5699m = aVar.f5712m;
        this.f5700n = aVar.f5713n;
        this.f5701o = aVar.f5714o;
        this.f5702p = aVar.f5715p;
        this.f5703q = aVar.f5716q;
    }

    public final Context a() {
        return this.f5691a;
    }

    public final String b() {
        return this.f5692b;
    }

    public final float c() {
        return this.f5694d;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final View f() {
        return this.h;
    }

    public final List<CampaignEx> g() {
        return this.f5695i;
    }

    public final int h() {
        return this.f5693c;
    }

    public final int i() {
        return this.f5696j;
    }

    public final int j() {
        return this.g;
    }

    public final boolean k() {
        return this.f5697k;
    }

    public final List<String> l() {
        return this.f5698l;
    }

    public final int m() {
        return this.f5701o;
    }

    public final int n() {
        return this.f5702p;
    }

    public final String o() {
        return this.f5703q;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private Context f5704a;

        /* renamed from: b, reason: collision with root package name */
        private String f5705b;

        /* renamed from: c, reason: collision with root package name */
        private int f5706c;

        /* renamed from: d, reason: collision with root package name */
        private float f5707d;
        private float e;
        private int f;
        private int g;
        private View h;

        /* renamed from: i, reason: collision with root package name */
        private List<CampaignEx> f5708i;

        /* renamed from: j, reason: collision with root package name */
        private int f5709j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f5710k;

        /* renamed from: l, reason: collision with root package name */
        private List<String> f5711l;

        /* renamed from: m, reason: collision with root package name */
        private int f5712m;

        /* renamed from: n, reason: collision with root package name */
        private String f5713n;

        /* renamed from: o, reason: collision with root package name */
        private int f5714o;

        /* renamed from: p, reason: collision with root package name */
        private int f5715p = 1;

        /* renamed from: q, reason: collision with root package name */
        private String f5716q;

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(Context context) {
            this.f5704a = context.getApplicationContext();
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(float f) {
            this.e = f;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b c(int i10) {
            this.g = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b d(int i10) {
            this.f5709j = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b e(int i10) {
            this.f5712m = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b f(int i10) {
            this.f5714o = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b g(int i10) {
            this.f5715p = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(int i10) {
            this.f = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b c(String str) {
            this.f5716q = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(List<String> list) {
            this.f5711l = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(String str) {
            this.f5713n = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(String str) {
            this.f5705b = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(int i10) {
            this.f5706c = i10;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(float f) {
            this.f5707d = f;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(View view) {
            this.h = view;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(List<CampaignEx> list) {
            this.f5708i = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(boolean z9) {
            this.f5710k = z9;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final c a() {
            return new c(this);
        }
    }
}
