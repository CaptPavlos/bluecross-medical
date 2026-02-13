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

public final class docf
extends doab {
    public docf(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(docf docf2, BluetoothDevice bluetoothDevice, int n) {
        docf docf3 = docf2;
        Intrinsics.checkNotNullParameter((Object)((Object)docf3), (String)"this$0");
        docf3.log(4, "Er2BleManager MTU set to " + n);
    }

    private static final void doab(docf docf2, BluetoothDevice bluetoothDevice, int n) {
        docf docf3 = docf2;
        Intrinsics.checkNotNullParameter((Object)((Object)docf3), (String)"this$0");
        docf3.log(5, "Er2BleManager Requested MTU not supported: " + n);
    }

    private static final void doac(docf docf2, BluetoothDevice bluetoothDevice, int n) {
        docf docf3 = docf2;
        Intrinsics.checkNotNullParameter((Object)((Object)docf3), (String)"this$0");
        docf3.log(5, "Er2BleManager Requested PHY not supported: " + n);
    }

    private static final void doad(docf docf2, BluetoothDevice bluetoothDevice, int n) {
        docf docf3 = docf2;
        Intrinsics.checkNotNullParameter((Object)((Object)docf3), (String)"this$0");
        docf3.log(4, "Er2BleManager MTU set to " + n);
    }

    private static final void doae(docf docf2, BluetoothDevice bluetoothDevice, int n) {
        docf docf3 = docf2;
        Intrinsics.checkNotNullParameter((Object)((Object)docf3), (String)"this$0");
        docf3.log(5, "Er2BleManager Requested MTU not supported: " + n);
    }

    @Override
    public void doal() {
        docf docf2 = object;
        Object object = UUID.fromString("14839ac4-7d7e-415c-9a42-167340cf2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docf2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docf2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        docf2.doab((UUID)object);
        doah.doah.doa("Er2BleManager initUUID");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        if (doac.doa.doal()) {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> docf.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> docf.doab(this, arg_0, arg_1))).add((Operation)this.setPreferredPhy(2, 2, 0).fail((arg_0, arg_1) -> docf.doac(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        } else {
            requestQueue.add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> docf.doad(this, arg_0, arg_1)).fail((arg_0, arg_1) -> docf.doae(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        }
        doah.doah.doa("Er2BleManager dealReqQueue");
        return requestQueue;
    }
}
