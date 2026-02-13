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

public final class docd
extends doab {
    public docd(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(docd docd2, BluetoothDevice bluetoothDevice, int n) {
        docd docd3 = docd2;
        Intrinsics.checkNotNullParameter((Object)((Object)docd3), (String)"this$0");
        docd3.log(4, "Er1BleManager MTU set to " + n);
    }

    private static final void doab(docd docd2, BluetoothDevice bluetoothDevice, int n) {
        docd docd3 = docd2;
        Intrinsics.checkNotNullParameter((Object)((Object)docd3), (String)"this$0");
        docd3.log(5, "Er1BleManager Requested MTU not supported: " + n);
    }

    private static final void doac(docd docd2, BluetoothDevice bluetoothDevice, int n) {
        docd docd3 = docd2;
        Intrinsics.checkNotNullParameter((Object)((Object)docd3), (String)"this$0");
        docd3.log(5, "Er1BleManager Requested PHY not supported: " + n);
    }

    private static final void doad(docd docd2, BluetoothDevice bluetoothDevice, int n) {
        docd docd3 = docd2;
        Intrinsics.checkNotNullParameter((Object)((Object)docd3), (String)"this$0");
        docd3.log(4, "Er1BleManager MTU set to " + n);
    }

    private static final void doae(docd docd2, BluetoothDevice bluetoothDevice, int n) {
        docd docd3 = docd2;
        Intrinsics.checkNotNullParameter((Object)((Object)docd3), (String)"this$0");
        docd3.log(5, "Er1BleManager Requested MTU not supported: " + n);
    }

    @Override
    public void doal() {
        docd docd2 = object;
        Object object = UUID.fromString("14839ac4-7d7e-415c-9a42-167340cf2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docd2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docd2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docd2.doab((UUID)object);
        doah.doah.doa("Er1BleManager initUUID");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        if (doac.doa.doal()) {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> docd.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> docd.doab(this, arg_0, arg_1))).add((Operation)this.setPreferredPhy(2, 2, 0).fail((arg_0, arg_1) -> docd.doac(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        } else {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> docd.doad(this, arg_0, arg_1)).fail((arg_0, arg_1) -> docd.doae(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        }
        doah.doah.doa("Er1BleManager dealReqQueue");
        return requestQueue;
    }
}
