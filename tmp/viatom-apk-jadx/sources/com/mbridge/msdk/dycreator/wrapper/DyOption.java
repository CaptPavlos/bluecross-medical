package com.mbridge.msdk.dycreator.wrapper;

import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DyOption {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f3272a;

    /* renamed from: b, reason: collision with root package name */
    private File f3273b;

    /* renamed from: c, reason: collision with root package name */
    private CampaignEx f3274c;

    /* renamed from: d, reason: collision with root package name */
    private DyAdType f3275d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3276i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3277j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3278k;

    /* renamed from: l, reason: collision with root package name */
    private int f3279l;

    /* renamed from: m, reason: collision with root package name */
    private int f3280m;

    /* renamed from: n, reason: collision with root package name */
    private int f3281n;

    /* renamed from: o, reason: collision with root package name */
    private int f3282o;

    /* renamed from: p, reason: collision with root package name */
    private int f3283p;

    /* renamed from: q, reason: collision with root package name */
    private int f3284q;

    /* renamed from: r, reason: collision with root package name */
    private DyCountDownListenerWrapper f3285r;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder implements IViewOptionBuilder {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f3286a;

        /* renamed from: b, reason: collision with root package name */
        private File f3287b;

        /* renamed from: c, reason: collision with root package name */
        private CampaignEx f3288c;

        /* renamed from: d, reason: collision with root package name */
        private DyAdType f3289d;
        private boolean e;
        private String f;
        private boolean g;
        private boolean h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f3290i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f3291j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3292k;

        /* renamed from: l, reason: collision with root package name */
        private int f3293l;

        /* renamed from: m, reason: collision with root package name */
        private int f3294m;

        /* renamed from: n, reason: collision with root package name */
        private int f3295n;

        /* renamed from: o, reason: collision with root package name */
        private int f3296o;

        /* renamed from: p, reason: collision with root package name */
        private int f3297p;

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder adChoiceLink(String str) {
            this.f = str;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public DyOption build() {
            return new DyOption(this);
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder campaignEx(CampaignEx campaignEx) {
            this.f3288c = campaignEx;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder canSkip(boolean z9) {
            this.e = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder countDownTime(int i10) {
            this.f3296o = i10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder dyAdType(DyAdType dyAdType) {
            this.f3289d = dyAdType;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder file(File file) {
            this.f3287b = file;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder fileDirs(List<String> list) {
            this.f3286a = list;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isApkInfoVisible(boolean z9) {
            this.f3291j = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isClickButtonVisible(boolean z9) {
            this.h = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isLogoVisible(boolean z9) {
            this.f3292k = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isScreenClick(boolean z9) {
            this.g = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder isShakeVisible(boolean z9) {
            this.f3290i = z9;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder orientation(int i10) {
            this.f3295n = i10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeStrenght(int i10) {
            this.f3293l = i10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder shakeTime(int i10) {
            this.f3294m = i10;
            return this;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DyOption.IViewOptionBuilder
        public IViewOptionBuilder templateType(int i10) {
            this.f3297p = i10;
            return this;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface IViewOptionBuilder {
        IViewOptionBuilder adChoiceLink(String str);

        DyOption build();

        IViewOptionBuilder campaignEx(CampaignEx campaignEx);

        IViewOptionBuilder canSkip(boolean z9);

        IViewOptionBuilder countDownTime(int i10);

        IViewOptionBuilder dyAdType(DyAdType dyAdType);

        IViewOptionBuilder file(File file);

        IViewOptionBuilder fileDirs(List<String> list);

        IViewOptionBuilder isApkInfoVisible(boolean z9);

        IViewOptionBuilder isClickButtonVisible(boolean z9);

        IViewOptionBuilder isLogoVisible(boolean z9);

        IViewOptionBuilder isScreenClick(boolean z9);

        IViewOptionBuilder isShakeVisible(boolean z9);

        IViewOptionBuilder orientation(int i10);

        IViewOptionBuilder shakeStrenght(int i10);

        IViewOptionBuilder shakeTime(int i10);

        IViewOptionBuilder templateType(int i10);
    }

    public DyOption(Builder builder) {
        this.f3272a = builder.f3286a;
        this.f3273b = builder.f3287b;
        this.f3274c = builder.f3288c;
        this.f3275d = builder.f3289d;
        this.g = builder.e;
        this.e = builder.f;
        this.f = builder.g;
        this.h = builder.h;
        this.f3277j = builder.f3291j;
        this.f3276i = builder.f3290i;
        this.f3278k = builder.f3292k;
        this.f3279l = builder.f3293l;
        this.f3280m = builder.f3294m;
        this.f3281n = builder.f3295n;
        this.f3282o = builder.f3296o;
        this.f3284q = builder.f3297p;
    }

    public String getAdChoiceLink() {
        return this.e;
    }

    public CampaignEx getCampaignEx() {
        return this.f3274c;
    }

    public int getCountDownTime() {
        return this.f3282o;
    }

    public int getCurrentCountDown() {
        return this.f3283p;
    }

    public DyAdType getDyAdType() {
        return this.f3275d;
    }

    public File getFile() {
        return this.f3273b;
    }

    public List<String> getFileDirs() {
        return this.f3272a;
    }

    public int getOrientation() {
        return this.f3281n;
    }

    public int getShakeStrenght() {
        return this.f3279l;
    }

    public int getShakeTime() {
        return this.f3280m;
    }

    public int getTemplateType() {
        return this.f3284q;
    }

    public boolean isApkInfoVisible() {
        return this.f3277j;
    }

    public boolean isCanSkip() {
        return this.g;
    }

    public boolean isClickButtonVisible() {
        return this.h;
    }

    public boolean isClickScreen() {
        return this.f;
    }

    public boolean isLogoVisible() {
        return this.f3278k;
    }

    public boolean isShakeVisible() {
        return this.f3276i;
    }

    public void setDyCountDownListener(int i10) {
        DyCountDownListenerWrapper dyCountDownListenerWrapper = this.f3285r;
        if (dyCountDownListenerWrapper != null) {
            dyCountDownListenerWrapper.getCountDownValue(i10);
        }
        this.f3283p = i10;
    }

    public void setDyCountDownListenerWrapper(DyCountDownListenerWrapper dyCountDownListenerWrapper) {
        this.f3285r = dyCountDownListenerWrapper;
    }
}
