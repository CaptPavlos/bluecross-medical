/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.jvm.internal.Intrinsics
 *  no.nordicsemi.android.ble.RequestQueue
 */
package doab;

import android.content.Context;
import doa.doab;
import doah.doah;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.ble.RequestQueue;

public final class doe
extends doab {
    public doe(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    @Override
    public void doal() {
        doe doe2 = object;
        Object object = UUID.fromString("00001000-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doe2.doac((UUID)object);
        object = UUID.fromString("00001001-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doe2.doad((UUID)object);
        object = UUID.fromString("00001002-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doe2.doab((UUID)object);
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        RequestQueue requestQueue2 = requestQueue;
        Intrinsics.checkNotNullParameter((Object)requestQueue2, (String)"requestQueue");
        doah.doah.doa("KcaBleManager dealReqQueue");
        return requestQueue2;
    }
}
