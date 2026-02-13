package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import androidx.annotation.NonNull;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class Template302 extends BaseTemplate {
    public Template302(@NonNull Context context) {
        super(context);
        PlayTemplePresenter playTemplePresenter = new PlayTemplePresenter(this);
        this.presenter = playTemplePresenter;
        playTemplePresenter.getView();
    }
}
