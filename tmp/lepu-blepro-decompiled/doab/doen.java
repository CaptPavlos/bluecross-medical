/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  kotlin.jvm.internal.Intrinsics
 *  no.nordicsemi.android.ble.Operation
 *  no.nordicsemi.android.ble.RequestQueue
 */
package doab;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import doa.doab;
import doah.doah;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.ble.Operation;
import no.nordicsemi.android.ble.RequestQueue;

public final class doen
extends doab {
    public doen(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(doen doen2, BluetoothDevice bluetoothDevice, int n) {
        doen doen3 = doen2;
        Intrinsics.checkNotNullParameter((Object)((Object)doen3), (String)"this$0");
        doen3.log(4, "OxyBleManager MTU set to " + n);
    }

    private static final void doab(doen doen2, BluetoothDevice bluetoothDevice, int n) {
        doen doen3 = doen2;
        Intrinsics.checkNotNullParameter((Object)((Object)doen3), (String)"this$0");
        doen3.log(5, "OxyBleManager Requested MTU not supported: " + n);
    }

    @Override
    public void doal() {
        doen doen2 = object;
        Object object = UUID.fromString("14839ac4-7d7e-415c-9a42-167340cf2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doen2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doen2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doen2.doab((UUID)object);
        doah.doah.doa("OxyBleManager initUUID");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        RequestQueue requestQueue2 = requestQueue;
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        requestQueue2.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> doen.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> doen.doab(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        doah.doah.doa("OxyBleManager dealReqQueue");
        return requestQueue2;
    }
}
