package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i10, int i11, float f10, int i12, float f11, boolean z9, int i13, int i14) {
        super(charSequence, alignment, f, i10, i11, f10, i12, f11, z9, i13);
        this.priority = i14;
    }

    @Override // java.lang.Comparable
    public final int compareTo(@NonNull Cea708Cue cea708Cue) {
        int i10 = cea708Cue.priority;
        int i11 = this.priority;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }
}
