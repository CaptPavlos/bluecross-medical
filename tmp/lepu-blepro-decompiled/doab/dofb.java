/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattService
 *  android.content.Context
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  no.nordicsemi.android.ble.BleManager$BleManagerGattCallback
 *  no.nordicsemi.android.ble.Operation
 *  no.nordicsemi.android.ble.RequestQueue
 *  no.nordicsemi.android.ble.data.Data
 */
package doab;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import doa.doab;
import doa.doae;
import doah.doah;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.Operation;
import no.nordicsemi.android.ble.RequestQueue;
import no.nordicsemi.android.ble.data.Data;

public final class dofb
extends doab {
    public UUID dob;
    public UUID doba;
    public UUID dobc;
    private BluetoothGattCharacteristic dobd;
    private BluetoothGattCharacteristic dobe;
    private doae dobf;

    public dofb(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
    }

    private static final void doa(dofb dofb2, BluetoothDevice bluetoothDevice, int n) {
        dofb dofb3 = dofb2;
        Intrinsics.checkNotNullParameter((Object)((Object)dofb3), (String)"this$0");
        dofb3.log(4, "OxySiBleManager MTU set to " + n);
    }

    private static final void doab(dofb dofb2, BluetoothDevice bluetoothDevice, int n) {
        dofb dofb3 = dofb2;
        Intrinsics.checkNotNullParameter((Object)((Object)dofb3), (String)"this$0");
        dofb3.log(5, "OxySiBleManager Requested MTU not supported: " + n);
    }

    private static final void doa(dofb dofb2, BluetoothDevice bluetoothDevice, Data data) {
        Unit unit;
        Unit unit2;
        Data data2 = data;
        Intrinsics.checkNotNullParameter((Object)((Object)dofb2), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Object object = data2.getValue();
        if (object != null) {
            if (bluetoothDevice.getName() != null) {
                doah.doah.doa("LpBleManager", bluetoothDevice.getName() + " NotificationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            } else {
                doah.doah.doa("LpBleManager", "device.name null NotificationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            }
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            dofb2.log(5, "NotificationCallback data.value == null");
        }
        doae doae2 = dofb2.dobf;
        object = doae2;
        if (doae2 != null) {
            object.doa(bluetoothDevice, data);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            dofb2.log(5, "NotificationCallback listener == null");
        }
    }

    private static final void doab(byte[] byArray, BluetoothDevice bluetoothDevice) {
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$bytes");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice2, (String)"device");
        if (bluetoothDevice2.getName() != null) {
            doah.doah.doab(bluetoothDevice.getName() + " done send cmd:" + doah.doa.doa(byArray));
        } else {
            doah.doah.doab("device.name null done send cmd:" + doah.doa.doa(byArray));
        }
    }

    private static final void doab(byte[] byArray, BluetoothDevice bluetoothDevice, int n) {
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$bytes");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice2, (String)"device");
        if (bluetoothDevice2.getName() != null) {
            doah.doah.doab(bluetoothDevice.getName() + " fail send cmd:" + doah.doa.doa(byArray));
        } else {
            doah.doah.doab("device.name null fail send cmd:" + doah.doa.doa(byArray));
        }
    }

    public final UUID dobc() {
        Object object = object.dob;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"service_uuid2");
        return null;
    }

    public final void doaf(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.dob = uUID;
    }

    public final UUID dobe() {
        Object object = object.doba;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"write_uuid2");
        return null;
    }

    public final void doag(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.doba = uUID;
    }

    public final UUID doba() {
        Object object = object.dobc;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"notify_uuid2");
        return null;
    }

    public final void doae(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.dobc = uUID;
    }

    public final BluetoothGattCharacteristic dobd() {
        return this.dobd;
    }

    public final void doae(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.dobd = bluetoothGattCharacteristic;
    }

    public final BluetoothGattCharacteristic dob() {
        return this.dobe;
    }

    public final void doad(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.dobe = bluetoothGattCharacteristic;
    }

    public final void doa(doae doae2) {
        this.dobf = doae2;
    }

    @Override
    public void doal() {
        dofb dofb2 = object;
        Object object = UUID.fromString("14839ac4-7d7e-415c-9a42-167340cf2339");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doac((UUID)object);
        object = UUID.fromString("8B00ACE7-EB0B-49B0-BBE9-9AEE0A26E1A3");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doad((UUID)object);
        object = UUID.fromString("0734594A-A8E7-4B1A-A6B1-CD5243059A57");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doab((UUID)object);
        object = UUID.fromString("E8FB0001-A14B-98F9-831B-4E2941D01248");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doaf((UUID)object);
        object = UUID.fromString("E8FB0002-A14B-98F9-831B-4E2941D01248");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doag((UUID)object);
        object = UUID.fromString("E8FB0003-A14B-98F9-831B-4E2941D01248");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromString(...)");
        dofb2.doae((UUID)object);
        doah.doah.doa("OxySiBleManager initUUID");
    }

    @Override
    public RequestQueue doa(RequestQueue requestQueue) {
        RequestQueue requestQueue2 = requestQueue;
        dofb dofb2 = this;
        Intrinsics.checkNotNullParameter((Object)requestQueue, (String)"requestQueue");
        requestQueue2.add((Operation)dofb2.enableNotifications(dofb2.dobe)).add((Operation)this.requestMtu(247).with((arg_0, arg_1) -> dofb.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> dofb.doab(this, arg_0, arg_1))).add((Operation)this.requestConnectionPriority(1));
        doah.doah.doa("OxySiBleManager dealReqQueue");
        return requestQueue2;
    }

    @Override
    protected BleManager.BleManagerGattCallback getGattCallback() {
        return new BleManager.BleManagerGattCallback(){

            protected boolean isRequiredServiceSupported(BluetoothGatt bluetoothGatt) {
                Unit unit;
                int n;
                Unit unit2;
                dofb dofb2;
                BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                Intrinsics.checkNotNullParameter((Object)bluetoothGatt2, (String)"gatt");
                doah.doah.doa("LpBleManager", "service_uuid = " + this.doai() + ",write_uuid = " + this.doak() + ",notify_uuid = " + this.doah() + ",isUpdater = " + this.doam());
                doah.doah.doa("LpBleManager", "service_uuid2 = " + this.dobc() + ",write_uuid2 = " + this.dobe() + ",notify_uuid2 = " + this.doba() + ",isUpdater = " + this.doam());
                BluetoothGattService bluetoothGattService = bluetoothGatt2.getService(this.doai());
                doah.doah.doa("LpBleManager", "service ==  " + bluetoothGattService);
                if (bluetoothGattService != null) {
                    dofb dofb3 = dofb2 = this;
                    dofb3.doac(bluetoothGattService.getCharacteristic(dofb2.doak()));
                    dofb2.doab(bluetoothGattService.getCharacteristic(dofb3.doah()));
                    doah.doah.doa("LpBleManager", "writeChar ==  " + dofb2.doaj());
                    doah.doah.doa("LpBleManager", "notifyChar ==  " + dofb2.doag());
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null && this.doam()) {
                    return true;
                }
                boolean bl = false;
                dofb2 = this.doag();
                if (dofb2 != null) {
                    int n2 = dofb2.getProperties();
                    doah.doah.doa("LpBleManager", "notifyChar properties ==  " + n2);
                    bl = (n2 & 0x10) != 0;
                    doah.doah.doa("LpBleManager", "notifyChar notify ==  " + bl);
                }
                int n3 = 0;
                Object object = this.doaj();
                if (object != null) {
                    n3 = object.getProperties();
                    doah.doah.doa("LpBleManager", "writeChar properties ==  " + n3);
                    int n4 = 2;
                    n = n3 & 4;
                    if (n != 0) {
                        n4 = 1;
                    }
                    object.setWriteType(n4);
                    n3 = (n3 & 8) == 0 && n == 0 ? 0 : 1;
                    doah.doah.doa("LpBleManager", "writeChar writeRequest ==  " + (n3 != 0));
                }
                bluetoothGatt = bluetoothGatt.getService(this.dobc());
                doah.doah.doa("LpBleManager", "service2 ==  " + bluetoothGatt);
                if (bluetoothGatt != null) {
                    Object object2 = object = this;
                    ((dofb)((Object)object2)).doae(bluetoothGatt.getCharacteristic(((dofb)((Object)object)).dobe()));
                    ((dofb)((Object)object)).doad(bluetoothGatt.getCharacteristic(((dofb)((Object)object2)).doba()));
                    doah.doah.doa("LpBleManager", "writeChar2 ==  " + ((dofb)((Object)object)).dobd());
                    doah.doah.doa("LpBleManager", "notifyChar2 ==  " + ((dofb)((Object)object)).dob());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null && this.doam()) {
                    return true;
                }
                boolean bl2 = false;
                object = this.dob();
                if (object != null) {
                    int n5 = object.getProperties();
                    doah.doah.doa("LpBleManager", "notifyChar2 properties ==  " + n5);
                    bl2 = (n5 & 0x10) != 0;
                    doah.doah.doa("LpBleManager", "notifyChar2 notify2 ==  " + bl2);
                }
                int n6 = 0;
                BluetoothGattCharacteristic bluetoothGattCharacteristic = this.dobd();
                if (bluetoothGattCharacteristic != null) {
                    n6 = bluetoothGattCharacteristic.getProperties();
                    doah.doah.doa("LpBleManager", "writeChar2 properties ==  " + n6);
                    n = 2;
                    int n7 = n6 & 4;
                    if (n7 != 0) {
                        n = 1;
                    }
                    bluetoothGattCharacteristic.setWriteType(n);
                    n6 = (n6 & 8) == 0 && n7 == 0 ? 0 : 1;
                    doah.doah.doa("LpBleManager", "writeChar2 writeRequest ==  " + (n3 != 0));
                }
                return this.doaj() != null && this.doag() != null && bl && n3 != 0 && this.dobd() != null && this.dob() != null && bl2 && n6 != 0;
            }

            protected void initialize() {
                doa doa2 = this;
                super.initialize();
                doah.doah.doa("LpBleManager", "initialize");
                doa2.this.doa();
                doa2.this.doan();
                doa2.this.dobf();
            }

            protected void onMtuChanged(BluetoothGatt bluetoothGatt, int n) {
                doa doa2 = this;
                BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                Intrinsics.checkNotNullParameter((Object)bluetoothGatt2, (String)"gatt");
                super.onMtuChanged(bluetoothGatt2, n);
                doa2.this.log(4, "onMtuChanged mtu == " + n);
            }

            protected void onConnectionUpdated(BluetoothGatt bluetoothGatt, int n, int n2, int n3) {
                doa doa2 = this;
                BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                Intrinsics.checkNotNullParameter((Object)bluetoothGatt2, (String)"gatt");
                super.onConnectionUpdated(bluetoothGatt2, n, n2, n3);
                doa2.this.log(4, "onConnectionUpdated interval == " + n + ", latency == " + n2 + ", timeout == " + n3);
            }

            protected void onDeviceDisconnected() {
                doa doa2 = this;
                doa2.this.doac((BluetoothGattCharacteristic)null);
                doa2.this.doab((BluetoothGattCharacteristic)null);
                doa2.this.doae((BluetoothGattCharacteristic)null);
                doa2.this.doad((BluetoothGattCharacteristic)null);
            }

            protected void onServicesInvalidated() {
            }
        };
    }

    public final void dobf() {
        dofb dofb2 = this;
        doah.doah.doa("LpBleManager", "setNotifySi...");
        dofb2.setNotificationCallback(dofb2.dobe).with((arg_0, arg_1) -> dofb.doa(this, arg_0, arg_1));
    }

    public final void doab(byte[] byArray) {
        dofb dofb2 = this;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        try {
            doah.doah.doab("sendCmd--------------" + doah.doa.doa(byArray));
            dofb2.writeCharacteristic(dofb2.dobd, byArray).split().done(arg_0 -> dofb.doab(byArray, arg_0)).fail((arg_0, arg_1) -> dofb.doab(byArray, arg_0, arg_1)).enqueue();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
