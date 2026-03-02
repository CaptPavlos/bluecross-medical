package com.mbridge.msdk.newreward.player.iview;

import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IWebTemplateView extends IBaseWebView, IPlayTempleView {
    void changeVideoViewPosition(JSONObject jSONObject);

    void playOrPauseVideo(int i10);

    void seekToPlay(int i10);

    void setMuteState(int i10, int i11);
}
