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
import doa.doac;
import doah.doah;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.ble.Operation;
import no.nordicsemi.android.ble.RequestQueue;

public final class doeg
extends doab {
    public doeg(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(doeg doeg2, BluetoothDevice bluetoothDevice, int n) {
        doeg doeg3 = doeg2;
        Intrinsics.checkNotNullParameter((Object)((Object)doeg3), (String)"this$0");
        doeg3.log(4, "LewBleManager MTU set to " + n);
    }

    private static final void doab(doeg doeg2, BluetoothDevice bluetoothDevice, int n) {
        doeg doeg3 = doeg2;
        Intrinsics.checkNotNullParameter((Object)((Object)doeg3), (String)"this$0");
        doeg3.log(5, "LewBleManager Requested MTU not supported: " + n);
    }

    private static final void doac(doeg doeg2, BluetoothDevice bluetoothDevice, int n) {
        doeg doeg3 = doeg2;
        Intrinsics.checkNotNullParameter((Object)((Object)doeg3), (String)"this$0");
        doeg3.log(5, "LewBleManager Requested PHY not supported: " + n);
    }

    private static final void doad(doeg doeg2, BluetoothDevice bluetoothDevice, int n) {
        doeg doeg3 = doeg2;
        Intrinsics.checkNotNullParameter((Object)((Object)doeg3), (String)"this$0");
        doeg3.log(4, "LewBleManager MTU set to " + n);
    }

    private static final void doae(doeg doeg2, BluetoothDevice bluetoothDevice, int n) {
        doeg doeg3 = doeg2;
        Intrinsics.checkNotNullParameter((Object)((Object)doeg3), (String)"this$0");
        doeg3.log(5, "LewBleManager Requested MTU not supported: " + n);
    }

    @Override
    public void doal() {
        doeg doeg2 = object;
        Object object = UUID.fromString("14839ac4-7d7e-415c-9a42-167340cf2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doeg2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doeg2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        doeg2.doab((UUID)object);
        doah.doah.doa("LewBleManager initUUID");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        if (doac.doa.doal()) {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> doeg.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> doeg.doab(this, arg_0, arg_1))).add((Operation)this.setPreferredPhy(2, 2, 0).fail((arg_0, arg_1) -> doeg.doac(this, arg_0, arg_1)));
        } else {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> doeg.doad(this, arg_0, arg_1)).fail((arg_0, arg_1) -> doeg.doae(this, arg_0, arg_1)));
        }
        doah.doah.doa("LewBleManager dealReqQueue");
        return requestQueue;
    }
}
