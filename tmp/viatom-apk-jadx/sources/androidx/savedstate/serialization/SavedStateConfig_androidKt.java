package androidx.savedstate.serialization;

import a3.q;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import c8.b;
import h0.p;
import j8.f;
import java.util.List;
import kotlin.jvm.internal.y;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateConfig_androidKt {
    public static final f getDefaultSerializersModuleOnPlatform() {
        p pVar = new p();
        pVar.p(y.a(Size.class), SizeSerializer.INSTANCE);
        pVar.p(y.a(SizeF.class), SizeFSerializer.INSTANCE);
        pVar.e(y.a(SparseArray.class), new q(4));
        return pVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List list) {
        list.getClass();
        return new SparseArraySerializer((b) l.c0(list));
    }
}
