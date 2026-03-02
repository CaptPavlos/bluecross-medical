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

public final class doan
extends doab {
    public doan(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(doan doan2, BluetoothDevice bluetoothDevice, int n) {
        doan doan3 = doan2;
        Intrinsics.checkNotNullParameter((Object)((Object)doan3), (String)"this$0");
        doan3.log(4, "Bp2BleManager MTU set to " + n);
    }

    private static final void doab(doan doan2, BluetoothDevice bluetoothDevice, int n) {
        doan doan3 = doan2;
        Intrinsics.checkNotNullParameter((Object)((Object)doan3), (String)"this$0");
        doan3.log(5, "Bp2BleManager Requested MTU not supported: " + n);
    }

    @Override
    public void doal() {
        doan doan2 = object;
        Object object = UUID.fromString("14839AC4-7D7E-415C-9A42-167340CF2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doan2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doan2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doan2.doab((UUID)object);
        doah.doah.doa("Bp2BleManager initUUID ");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        RequestQueue requestQueue2 = requestQueue;
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        requestQueue2.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> doan.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> doan.doab(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        doah.doah.doa("Bp2BleManager dealReqQueue ");
        return requestQueue2;
    }
}
