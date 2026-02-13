/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.content.Context
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  no.nordicsemi.android.ble.BleManager
 *  no.nordicsemi.android.ble.BleManager$BleManagerGattCallback
 *  no.nordicsemi.android.ble.Operation
 *  no.nordicsemi.android.ble.RequestQueue
 *  no.nordicsemi.android.ble.callback.RssiCallback
 *  no.nordicsemi.android.ble.data.Data
 */
package doa;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import doa.doad;
import doah.doah;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.Operation;
import no.nordicsemi.android.ble.RequestQueue;
import no.nordicsemi.android.ble.callback.RssiCallback;
import no.nordicsemi.android.ble.data.Data;

public abstract class doab
extends BleManager {
    private int doa;
    private int doab;
    private long doac;
    private long doad;
    private float doae;
    public UUID doaf;
    public UUID doag;
    public UUID doah;
    public UUID doai;
    private BluetoothGattCharacteristic doaj;
    private BluetoothGattCharacteristic doak;
    private BluetoothGattCharacteristic doal;
    private doad doam;
    private boolean doan;

    public doab(Context context) {
        doab doab2 = this;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
        doab2.doal();
    }

    private static final void doa(doab doab2, BluetoothDevice bluetoothDevice, Data data) {
        Unit unit;
        Unit unit2;
        Data data2 = data;
        Intrinsics.checkNotNullParameter((Object)((Object)doab2), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Object object = data2.getValue();
        if (object != null) {
            if (bluetoothDevice.getName() != null) {
                if (doab2.doa == 0) {
                    doab2.doac = System.currentTimeMillis();
                    ++doab2.doa;
                } else {
                    long l;
                    doab doab3 = doab2;
                    doab3.doad = l = System.currentTimeMillis() - doab2.doac;
                    ++doab3.doab;
                    doab3.doae += (float)l;
                    doab3.doa = 0;
                }
                doah.doah.doa("LpBleManager", bluetoothDevice.getName() + " NotificationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            } else {
                doah.doah.doa("LpBleManager", "device.name null NotificationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            }
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            doab2.log(5, "NotificationCallback data.value == null");
        }
        doad doad2 = doab2.doam;
        object = doad2;
        if (doad2 != null) {
            object.doab(bluetoothDevice, data);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doab2.log(5, "NotificationCallback listener == null");
        }
    }

    private static final void doab(doab doab2, BluetoothDevice bluetoothDevice, Data data) {
        Unit unit;
        Unit unit2;
        Data data2 = data;
        Intrinsics.checkNotNullParameter((Object)((Object)doab2), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Object object = data2.getValue();
        if (object != null) {
            if (bluetoothDevice.getName() != null) {
                doah.doah.doa("LpBleManager", bluetoothDevice.getName() + " IndicationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            } else {
                doah.doah.doa("LpBleManager", "device.name null IndicationCallback received==" + doah.doa.doa((byte[])object) + " size=" + doah.doa.doa((byte[])object).length());
            }
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            doab2.log(5, "IndicationCallback data.value == null");
        }
        doad doad2 = doab2.doam;
        object = doad2;
        if (doad2 != null) {
            object.doab(bluetoothDevice, data);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doab2.log(5, "IndicationCallback listener == null");
        }
    }

    private static final void doa(doab doab2, BluetoothDevice bluetoothDevice) {
        doab doab3 = doab2;
        Intrinsics.checkNotNullParameter((Object)((Object)doab3), (String)"this$0");
        doab3.log(4, "Target initialized");
    }

    private static final void doa(doab doab2, BluetoothDevice bluetoothDevice, int n) {
        doab doab3 = doab2;
        Intrinsics.checkNotNullParameter((Object)((Object)doab3), (String)"this$0");
        doab3.log(4, "MTU set to " + n);
    }

    private static final void doab(doab doab2, BluetoothDevice bluetoothDevice, int n) {
        doab doab3 = doab2;
        Intrinsics.checkNotNullParameter((Object)((Object)doab3), (String)"this$0");
        doab3.log(5, "Requested MTU not supported: " + n);
    }

    private static final void doa(RssiCallback rssiCallback, BluetoothDevice bluetoothDevice, int n) {
        Intrinsics.checkNotNullParameter((Object)rssiCallback, (String)"$callback");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        rssiCallback.onRssiRead(bluetoothDevice, n);
    }

    private static final void doa(byte[] byArray, BluetoothDevice bluetoothDevice) {
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$bytes");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice2, (String)"device");
        if (bluetoothDevice2.getName() != null) {
            doah.doah.doab(bluetoothDevice.getName() + " done send cmd:" + doah.doa.doa(byArray));
        } else {
            doah.doah.doab("device.name null done send cmd:" + doah.doa.doa(byArray));
        }
    }

    private static final void doa(byte[] byArray, BluetoothDevice bluetoothDevice, int n) {
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$bytes");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice2, (String)"device");
        if (bluetoothDevice2.getName() != null) {
            doah.doah.doab(bluetoothDevice.getName() + " fail send cmd:" + doah.doa.doa(byArray));
        } else {
            doah.doah.doab("device.name null fail send cmd:" + doah.doa.doa(byArray));
        }
    }

    public final UUID doai() {
        Object object = object.doaf;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"service_uuid");
        return null;
    }

    public final void doac(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.doaf = uUID;
    }

    public final UUID doak() {
        Object object = object.doag;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"write_uuid");
        return null;
    }

    public final void doad(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.doag = uUID;
    }

    public final UUID doah() {
        Object object = object.doah;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"notify_uuid");
        return null;
    }

    public final void doab(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.doah = uUID;
    }

    public final UUID doac() {
        Object object = object.doai;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"indicate_uuid");
        return null;
    }

    public final void doa(UUID uUID) {
        Intrinsics.checkNotNullParameter((Object)uUID, (String)"<set-?>");
        this.doai = uUID;
    }

    public final BluetoothGattCharacteristic doab() {
        return this.doaj;
    }

    public final void doa(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.doaj = bluetoothGattCharacteristic;
    }

    public final BluetoothGattCharacteristic doaj() {
        return this.doak;
    }

    public final void doac(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.doak = bluetoothGattCharacteristic;
    }

    public final BluetoothGattCharacteristic doag() {
        return this.doal;
    }

    public final void doab(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.doal = bluetoothGattCharacteristic;
    }

    public final doad doaf() {
        return this.doam;
    }

    public final void doa(doad doad2) {
        this.doam = doad2;
    }

    public final boolean doam() {
        return this.doan;
    }

    public final void doa(boolean bl) {
        this.doan = bl;
    }

    public abstract void doal();

    protected BleManager.BleManagerGattCallback getGattCallback() {
        if (this.doaf == null || this.doag == null || this.doah == null) {
            doah.doah.doab("LpBleManager", "check uuid !!!");
            doah.doah.doab("LpBleManager", "check uuid !!!");
        }
        return new BleManager.BleManagerGattCallback(){

            protected boolean isRequiredServiceSupported(BluetoothGatt bluetoothGatt) {
                Unit unit;
                doab doab2;
                Intrinsics.checkNotNullParameter((Object)bluetoothGatt, (String)"gatt");
                doah.doah.doa("LpBleManager", "service_uuid = " + this.doai() + ",write_uuid = " + this.doak() + ",notify_uuid = " + this.doah() + ",isUpdater = " + this.doam());
                bluetoothGatt = bluetoothGatt.getService(this.doai());
                doah.doah.doa("LpBleManager", "service ==  " + bluetoothGatt);
                if (bluetoothGatt != null) {
                    doab2 = this;
                    if (doab2.doai != null) {
                        doab2.doa(bluetoothGatt.getCharacteristic(doab2.doac()));
                    }
                    doab doab3 = doab2;
                    doab doab4 = doab2;
                    doab4.doac(bluetoothGatt.getCharacteristic(doab2.doak()));
                    doab3.doab(bluetoothGatt.getCharacteristic(doab4.doah()));
                    if (doab3.doab() != null) {
                        doah.doah.doa("LpBleManager", "indicate_char ==  " + doab2.doab());
                    }
                    doah.doah.doa("LpBleManager", "writeChar ==  " + doab2.doaj());
                    doah.doah.doa("LpBleManager", "notifyChar ==  " + doab2.doag());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null && this.doam()) {
                    return true;
                }
                boolean bl = false;
                doab2 = this.doag();
                if (doab2 != null) {
                    int n = doab2.getProperties();
                    doah.doah.doa("LpBleManager", "notifyChar properties ==  " + n);
                    bl = (n & 0x10) != 0;
                    doah.doah.doa("LpBleManager", "notifyChar notify ==  " + bl);
                }
                int n = 0;
                BluetoothGattCharacteristic bluetoothGattCharacteristic = this.doaj();
                if (bluetoothGattCharacteristic != null) {
                    n = bluetoothGattCharacteristic.getProperties();
                    doah.doah.doa("LpBleManager", "writeChar properties ==  " + n);
                    int n2 = 2;
                    int n3 = n & 4;
                    if (n3 != 0) {
                        n2 = 1;
                    }
                    bluetoothGattCharacteristic.setWriteType(n2);
                    n = (n & 8) == 0 && n3 == 0 ? 0 : 1;
                    doah.doah.doa("LpBleManager", "writeChar writeRequest ==  " + (n != 0));
                }
                return this.doaj() != null && this.doag() != null && bl && n != 0;
            }

            protected void initialize() {
                doa doa2 = this;
                super.initialize();
                doah.doah.doa("LpBleManager", "initialize");
                doa2.this.doa();
                doa2.this.doan();
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
                doa2.this.doa((BluetoothGattCharacteristic)null);
                doa2.this.doac((BluetoothGattCharacteristic)null);
                doa2.this.doab((BluetoothGattCharacteristic)null);
            }

            protected void onServicesInvalidated() {
            }
        };
    }

    public final int doae() {
        return MathKt.roundToInt((float)((float)this.doad / 2.0f));
    }

    public final int doad() {
        return MathKt.roundToInt((float)(this.doae / (float)this.doab));
    }

    public final void doan() {
        doab doab2 = this;
        doah.doah.doa("LpBleManager", "setNotify...");
        doab2.setNotificationCallback(doab2.doal).with((arg_0, arg_1) -> doab.doa(this, arg_0, arg_1));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = doab2.doaj;
        if (bluetoothGattCharacteristic != null) {
            this.setIndicationCallback(bluetoothGattCharacteristic).with((arg_0, arg_1) -> doab.doab(this, arg_0, arg_1));
        }
    }

    public void doa() {
        doab doab2 = this;
        doah.doah.doa("LpBleManager", "buildRequestQueue...");
        doab doab3 = this;
        RequestQueue requestQueue = doab2.beginAtomicRequestQueue().add((Operation)doab3.enableNotifications(doab3.doal)).done(arg_0 -> doab.doa(this, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)requestQueue, (String)"done(...)");
        doab2.doa(requestQueue).enqueue();
    }

    public final void doa(int n) {
        doab doab2 = this;
        doab2.log(4, "setBleMtu");
        doab2.beginAtomicRequestQueue().add((Operation)this.requestMtu(n).with((arg_0, arg_1) -> doab.doa(this, arg_0, arg_1)).fail((arg_0, arg_1) -> doab.doab(this, arg_0, arg_1))).enqueue();
    }

    public final void doa(RssiCallback rssiCallback) {
        Intrinsics.checkNotNullParameter((Object)rssiCallback, (String)"callback");
        this.beginAtomicRequestQueue().add((Operation)this.readRssi().with((arg_0, arg_1) -> doab.doa(rssiCallback, arg_0, arg_1))).enqueue();
    }

    public abstract RequestQueue doa(RequestQueue var1);

    public void doa(byte[] byArray) {
        doab doab2 = this;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bytes");
        try {
            doah.doah.doab("sendCmd--------------" + doah.doa.doa(byArray));
            doab2.writeCharacteristic(doab2.doak, byArray).split().done(arg_0 -> doab.doa(byArray, arg_0)).fail((arg_0, arg_1) -> doab.doa(byArray, arg_0, arg_1)).enqueue();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void log(int n, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        doah.doah.doa("LpBleManager", string);
    }
}
