package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeVastEndCardView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f6003m;

    /* renamed from: n, reason: collision with root package name */
    private View f6004n;

    /* renamed from: o, reason: collision with root package name */
    private View f6005o;

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.e) {
            this.f6004n.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVastEndCardView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeVastEndCardView.this.notifyListener.a(104, "");
                }
            });
            this.f6005o.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.module.MBridgeVastEndCardView.2
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) {
                    MBridgeVastEndCardView mBridgeVastEndCardView = MBridgeVastEndCardView.this;
                    mBridgeVastEndCardView.notifyListener.a(108, mBridgeVastEndCardView.d());
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_endcard_vast");
        if (iFindLayout >= 0) {
            this.f5902c.inflate(iFindLayout, this);
            this.f6003m = (ViewGroup) findViewById(findID("mbridge_rl_content"));
            this.f6004n = findViewById(findID("mbridge_iv_vastclose"));
            View viewFindViewById = findViewById(findID("mbridge_iv_vastok"));
            this.f6005o = viewFindViewById;
            this.e = isNotNULL(this.f6003m, this.f6004n, viewFindViewById);
            c();
            if (this.e) {
                setMatchParent();
                setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.f6003m.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.notifyListener.a(111, "");
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void preLoadData(b bVar) {
    }
}
