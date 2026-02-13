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

public final class doal
extends doab {
    public doal(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    @Override
    public void doal() {
        doal doal2 = object;
        doah.doah.doa("BiolandBgmBleManager initUUID");
        Object object = UUID.fromString("00001000-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doal2.doac((UUID)object);
        object = UUID.fromString("00001001-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doal2.doad((UUID)object);
        object = UUID.fromString("00001002-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doal2.doab((UUID)object);
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        RequestQueue requestQueue2 = requestQueue;
        Intrinsics.checkNotNullParameter((Object)requestQueue2, (String)"requestQueue");
        doah.doah.doa("BiolandBgmBleManager dealReqQueue");
        return requestQueue2;
    }
}
