/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.jeremyliao.liveeventbus.LiveEventBus
 *  com.jeremyliao.liveeventbus.core.Observable
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.GlobalScope
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  no.nordicsemi.android.ble.callback.RssiCallback
 *  no.nordicsemi.android.ble.data.Data
 *  no.nordicsemi.android.ble.observer.ConnectionObserver
 */
package doa;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.lepu.blepro.constants.ExternalEncryptKey;
import com.lepu.blepro.ext.BleServiceHelper;
import com.lepu.blepro.objs.Bluetooth;
import com.lepu.blepro.observer.BleChangeObserver;
import doa.doad;
import doac.ifgj;
import doah.doae;
import doah.doah;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import no.nordicsemi.android.ble.callback.RssiCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.observer.ConnectionObserver;

public abstract class doa
implements ConnectionObserver,
doad {
    private final int doa;
    private final String doab;
    private String doac;
    private boolean doad;
    private boolean doae;
    private boolean doaf;
    private boolean doag;
    public doa.doab doah;
    public BluetoothDevice doai;
    private byte[] doaj;
    private final Handler doak;
    private doa doal;
    private long doam;
    private boolean doan;
    private boolean dob;
    private boolean doba;
    private int dobc;
    private Job dobd;
    private int dobe;
    private boolean dobf;
    private byte[] dobg;
    private byte[] dobh;
    private boolean dobi;
    private byte[] dobj;
    private boolean dobk;
    private boolean dobl;
    private int dobm;
    private HashSet dobn;

    public doa(int n) {
        doa doa2 = this;
        doa2.doa = n;
        doa2.doab = "BleInterface";
        doa2.doac = "";
        doa2.doak = new Handler(Looper.getMainLooper());
        doa2.doal = new doa();
        doa2.doam = 500L;
        doa2.doan = true;
        doa2.dobe = -1;
        doa2.dobg = doah.doae.doa();
        doa2.dobh = new byte[0];
        doa2.dobj = new byte[0];
        doa2.dobn = new HashSet();
    }

    private final void docb() {
        doa doa2 = this;
        doah.doah.doa(doa2.doab, "publish=>" + this.dobn.size());
        Iterator iterator = doa2.dobn.iterator();
        while (iterator.hasNext()) {
            doa doa3 = this;
            int n = doa3.doa;
            ((BleChangeObserver)iterator.next()).onBleStateChanged(n, doa3.doa());
            doah.doah.doa(this.doab, "calBleState() : " + this.doa());
        }
    }

    public static /* synthetic */ void doa(doa doa2, Function0 function0, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                function0 = doa.doa$doab.doa;
            }
            doa2.doa(function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopRtTask");
    }

    public static /* synthetic */ void doa(doa doa2, String string, String string2, int n, int n2, Object object) {
        if (object == null) {
            if ((n2 & 4) != 0) {
                n = 0;
            }
            doa2.doab(string, string2, n);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFile");
    }

    public final int dobd() {
        return this.doa;
    }

    public final boolean dobi() {
        return this.doad;
    }

    public final boolean dobg() {
        return this.doae;
    }

    public final boolean doah() {
        return this.doaf;
    }

    public final doa.doab dobc() {
        Object object = object.doah;
        if (object != null) {
            return object;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"manager");
        return null;
    }

    public final void doa(doa.doab doab2) {
        Intrinsics.checkNotNullParameter((Object)((Object)doab2), (String)"<set-?>");
        this.doah = doab2;
    }

    public final BluetoothDevice doak() {
        doa doa2 = doa2.doai;
        if (doa2 != null) {
            return doa2;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"device");
        return null;
    }

    public final void doa(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"<set-?>");
        this.doai = bluetoothDevice;
    }

    public final long doaj() {
        return this.doam;
    }

    public final void doa(long l) {
        this.doam = l;
    }

    public final boolean doca() {
        return this.doan;
    }

    public final void doae(boolean bl) {
        this.dob = bl;
    }

    public final int dobf() {
        return this.dobc;
    }

    public final void doad(int n) {
        this.dobc = n;
    }

    public final int doai() {
        return this.dobe;
    }

    public final void doab(int n) {
        this.dobe = n;
    }

    public final boolean dobl() {
        return this.dobf;
    }

    public final void doac(boolean bl) {
        this.dobf = bl;
    }

    public final byte[] doba() {
        return this.dobg;
    }

    public final byte[] doaf() {
        return this.dobh;
    }

    public final boolean dobm() {
        return this.dobi;
    }

    public final byte[] doag() {
        return this.dobj;
    }

    public final void doac(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<set-?>");
        this.dobj = byArray;
    }

    public final void dobj() {
        ExternalEncryptKey externalEncryptKey = ExternalEncryptKey.INSTANCE;
        if (!(externalEncryptKey.getLepuEncryptKey().length == 0)) {
            this.dobg = externalEncryptKey.getLepuEncryptKey();
        }
        if (!(externalEncryptKey.getAccessToke().length == 0)) {
            this.dobh = externalEncryptKey.getAccessToke();
        }
        this.dobi = externalEncryptKey.isExternalEncrypt();
    }

    public final boolean doc() {
        return this.dobk;
    }

    public final void doad(boolean bl) {
        this.dobk = bl;
    }

    public final boolean dobk() {
        return this.dobl;
    }

    public final void doab(boolean bl) {
        this.dobl = bl;
    }

    public final int dobe() {
        return this.dobm;
    }

    public final void doac(int n) {
        this.dobm = n;
    }

    public abstract void doa(Context var1, BluetoothDevice var2, boolean var3);

    public final boolean dobn() {
        return this.doah != null;
    }

    public final void doab(BleChangeObserver bleChangeObserver) {
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)bleChangeObserver, (String)"observer");
        doa2.dobn.add(bleChangeObserver);
        doah.doah.doa(doa2.doab, "model=>" + this.doa + ", \u603b\u6570" + this.dobn.size() + "\u6210\u529f\u6dfb\u52a0\u4e86\u4e00\u4e2a\u8ba2\u9605\u8005");
    }

    public final void doa(BleChangeObserver bleChangeObserver) {
        Intrinsics.checkNotNullParameter((Object)bleChangeObserver, (String)"observer");
        if (!this.dobn.isEmpty()) {
            this.dobn.remove(bleChangeObserver);
        }
        doah.doah.doa(this.doab, "model=>" + this.doa + ", \u603b\u6570" + this.dobn.size() + "\u6210\u529f\u5c06\u8981\u79fb\u9664\u4e00\u4e2a\u8ba2\u9605\u8005");
    }

    @Override
    public void doab(BluetoothDevice object, Data data) {
        if (data != null) {
            byte[] byArray = data.getValue();
            object = byArray;
            if (byArray != null) {
                this.doaj = doah.doa.doa(this.doaj, (byte[])object);
            }
        }
        object = this.doaj;
        if (this.doaj != null) {
            this.doaj = this.doa((byte[])object);
        }
    }

    public final void doa(Context context, BluetoothDevice bluetoothDevice, boolean bl, boolean bl2) {
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        doah.doah.doa(doa2.doab, "into connect ");
        if (!doa2.doaf && !this.doad) {
            Unit unit;
            String string;
            if (!this.doan) {
                doa.doa.doa(this, null, 1, null);
            }
            if ((string = bluetoothDevice.getName()) != null) {
                doah.doah.doa(this.doab, "try connect: " + string + "\uff0cisAutoReconnect = " + bl + ", toConnectUpdater = " + bl2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                doah.doah.doa(this.doab, "try connect: device.name null\uff0cisAutoReconnect = " + bl + ", toConnectUpdater = " + bl2);
            }
            doa doa3 = this;
            doa3.doa(bluetoothDevice);
            doa3.doag = bl;
            doa3.doba = bl2;
            doa3.doa(context, bluetoothDevice, bl2);
            return;
        }
        doah.doah.doa(this.doab, "connect connecting:" + this.doaf + ", state:" + this.doad);
    }

    public final void doa(boolean bl) {
        doa doa2 = this;
        doah.doah.doa(doa2.doab, "into disconnect ");
        if (doa2.doah == null) {
            doah.doah.doa(this.doab, "manager unInitialized");
            return;
        }
        doa doa3 = this;
        doa3.doag = bl;
        doah.doah.doa(doa3.doab, "try disconnect..., isAutoReconnect = " + bl);
        doa3.dobc().disconnect();
        doa3.dobc().close();
        if (doa3.doai == null) {
            doah.doah.doa(this.doab, "device unInitialized");
            return;
        }
        doa doa4 = this;
        doa4.onDeviceDisconnected(doa4.doak(), 0);
    }

    public abstract byte[] doa(byte[] var1);

    public void onDeviceConnected(BluetoothDevice object) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)object, (String)"device");
        doah.doah.doa(this.doab, "into onDeviceConnected ");
        BleServiceHelper.Companion companion = BleServiceHelper.Companion;
        if (companion.getBleServiceHelper().isScanning()) {
            companion.getBleServiceHelper().stopScan();
        }
        doa doa2 = this;
        doa2.doad = true;
        doa2.doae = false;
        doa2.doaf = false;
        String string = object.getName();
        if (string != null) {
            companion.getBleServiceHelper().removeReconnectName(string);
            doah.doah.doa(this.doab, "onDeviceConnected " + string + " connected, ready: " + this.doae);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doah.doah.doa(this.doab, "onDeviceConnected device.name null connected, ready: " + this.doae);
        }
        if ((object = object.getAddress()) != null) {
            companion.getBleServiceHelper().removeReconnectAddress((String)object);
        }
        if (companion.getBleServiceHelper().hasUnConnected()) {
            object = doa.doac.doa;
            if (((doa.doac)object).doaf().size() != 0) {
                Object object2 = object;
                doa.doac.doab((doa.doac)object2, ((doa.doac)object2).doaj(), ((doa.doac)object).doaf().toArray(new String[0]), false, false, 12, null);
                doah.doah.doa(this.doab, "onDeviceConnected reconnectDeviceAddress : " + ((doa.doac)object).doaf());
            } else if (((doa.doac)object).doag().size() != 0) {
                Object object3 = object;
                doa.doac.doa((doa.doac)object3, ((doa.doac)object3).doaj(), ((doa.doac)object).doag().toArray(new String[0]), false, false, 12, null);
                doah.doah.doa(this.doab, "onDeviceConnected reconnectDeviceName : " + ((doa.doac)object).doag());
            }
        } else {
            companion.getBleServiceHelper().stopScan();
        }
    }

    public void onDeviceConnecting(BluetoothDevice object) {
        Unit unit;
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)object, (String)"device");
        doah.doah.doa(doa2.doab, "into onDeviceConnecting ");
        doa2.doad = false;
        doa2.doae = false;
        doa2.doaf = true;
        doa2.docb();
        object = object.getName();
        if (object != null) {
            doah.doah.doa(this.doab, (String)object + " Connecting");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doah.doah.doa(this.doab, "device.name null Connecting");
        }
    }

    public void onDeviceDisconnected(BluetoothDevice object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"device");
        if (this.doah == null) {
            doah.doah.doa(this.doab, "manager unInitialized");
        } else {
            this.dobc().close();
            doah.doah.doa(this.doab, "onDeviceDisconnected manager.close()");
        }
        this.doad = false;
        this.doae = false;
        this.doaf = false;
        this.dobf = false;
        this.dobj = new byte[0];
        doa.doa.doa(this, null, 1, null);
        this.docb();
        LiveEventBus.get((String)"com.lepu.ble.device.disconnect.reason").post((Object)n);
        if (object.getName() != null) {
            doah.doah.doa(this.doab, "onDeviceDisconnected==reason:" + n + "===isAutoReconnect:" + this.doag + ' ' + object.getName() + ' ' + object.getAddress());
        } else {
            doah.doah.doa(this.doab, "onDeviceDisconnected==reason:" + n + "===isAutoReconnect:" + this.doag + " device.name null " + object.getAddress());
        }
        if (n != 4) {
            BleServiceHelper.Companion companion = BleServiceHelper.Companion;
            if (companion.getBleServiceHelper().canReconnectByName(this.doa)) {
                Unit unit;
                String string = object.getName();
                if (string != null) {
                    if (this.doag) {
                        doah.doah.doa(this.doab, "onDeviceDisconnected....to do reconnectByName " + string);
                        BleServiceHelper.reconnect$default(companion.getBleServiceHelper(), null, string, false, false, 12, null);
                    } else {
                        companion.getBleServiceHelper().removeReconnectName(string);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Unit unit2;
                    doah.doah.doa(this.doab, "onDeviceDisconnected.... device.name null");
                    object = object.getAddress();
                    if (object != null) {
                        Intrinsics.checkNotNull((Object)object);
                        if (this.doag) {
                            doah.doah.doa(this.doab, "onDeviceDisconnected....to do reconnectByAddress " + (String)object);
                            BleServiceHelper.reconnectByAddress$default(companion.getBleServiceHelper(), null, (String)object, false, false, 12, null);
                        } else {
                            companion.getBleServiceHelper().removeReconnectAddress((String)object);
                        }
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                    }
                    if (unit2 == null) {
                        doah.doah.doa(this.doab, "onDeviceDisconnected.... device.name null & device.address null");
                    }
                }
            } else {
                Unit unit;
                if ((object = object.getAddress()) != null) {
                    if (this.doag) {
                        doah.doah.doa(this.doab, "onDeviceDisconnected....to do reconnectByAddress " + (String)object);
                        BleServiceHelper.reconnectByAddress$default(companion.getBleServiceHelper(), null, (String)object, false, false, 12, null);
                    } else {
                        companion.getBleServiceHelper().removeReconnectAddress((String)object);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    doah.doah.doa(this.doab, "onDeviceDisconnected.... device.address null");
                }
            }
        }
    }

    public void onDeviceDisconnecting(BluetoothDevice object) {
        Unit unit;
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)object, (String)"device");
        doah.doah.doa(doa2.doab, "into onDeviceDisconnecting ");
        doa2.doad = false;
        doa2.doae = false;
        doa2.doaf = false;
        doa2.dobf = false;
        doa2.dobj = new byte[0];
        doa2.docb();
        object = object.getName();
        if (object != null) {
            doah.doah.doa(this.doab, (String)object + " onDeviceDisconnecting");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doah.doah.doa(this.doab, "device.name null onDeviceDisconnecting");
        }
    }

    public void onDeviceFailedToConnect(BluetoothDevice object, int n) {
        Unit unit;
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)object, (String)"device");
        doa2.doad = false;
        doa2.doae = false;
        doa2.doaf = false;
        doa2.dobf = false;
        doa2.dobj = new byte[0];
        doa2.docb();
        doah.doah.doa(doa2.doab, "onDeviceFailedToConnect==reason:" + n + "===isAutoReconnect:" + this.doag);
        LiveEventBus.get((String)"com.lepu.ble.device.disconnect.reason").post((Object)n);
        if (n != 4) {
            BleServiceHelper.Companion companion = BleServiceHelper.Companion;
            if (companion.getBleServiceHelper().canReconnectByName(this.doa)) {
                Unit unit2;
                String string = object.getName();
                if (string != null) {
                    if (this.doag) {
                        doah.doah.doa(this.doab, "onDeviceFailedToConnect....to do reconnectByName " + string);
                        BleServiceHelper.reconnect$default(companion.getBleServiceHelper(), null, string, false, false, 12, null);
                    } else {
                        companion.getBleServiceHelper().removeReconnectName(string);
                    }
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    Unit unit3;
                    doah.doah.doa(this.doab, "onDeviceFailedToConnect.... device.name null");
                    string = object.getAddress();
                    if (string != null) {
                        Intrinsics.checkNotNull((Object)string);
                        if (this.doag) {
                            doah.doah.doa(this.doab, "onDeviceFailedToConnect....to do reconnectByAddress " + string);
                            BleServiceHelper.reconnectByAddress$default(companion.getBleServiceHelper(), null, string, false, false, 12, null);
                        } else {
                            companion.getBleServiceHelper().removeReconnectAddress(string);
                        }
                        unit3 = Unit.INSTANCE;
                    } else {
                        unit3 = null;
                    }
                    if (unit3 == null) {
                        doah.doah.doa(this.doab, "onDeviceFailedToConnect.... device.name null & device.address null");
                    }
                }
            } else {
                Unit unit4;
                String string = object.getAddress();
                if (string != null) {
                    if (this.doag) {
                        doah.doah.doa(this.doab, "onDeviceFailedToConnect....to do reconnectByAddress " + string);
                        BleServiceHelper.reconnectByAddress$default(companion.getBleServiceHelper(), null, string, false, false, 12, null);
                    } else {
                        companion.getBleServiceHelper().removeReconnectAddress(string);
                    }
                    unit4 = Unit.INSTANCE;
                } else {
                    unit4 = null;
                }
                if (unit4 == null) {
                    doah.doah.doa(this.doab, "onDeviceFailedToConnect.... device.address null");
                }
            }
        }
        if ((object = object.getName()) != null) {
            doah.doah.doa(this.doab, (String)object + " onDeviceFailedToConnect");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doah.doah.doa(this.doab, "device.name null onDeviceFailedToConnect");
        }
    }

    public void onDeviceReady(BluetoothDevice bluetoothDevice) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        doah.doah.doa(this.doab, "into onDeviceReady ");
        String string = bluetoothDevice.getName();
        if (string != null) {
            doah.doah.doa(this.doab, string + " onDeviceReady, state: " + this.doad);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            doah.doah.doa(this.doab, "device.name null onDeviceReady, state: " + this.doad);
        }
        doa doa2 = this;
        doa2.doad = true;
        doa2.doae = true;
        doa2.doaf = false;
        doa2.doab();
        doa2.docb();
        int n = doa2.doa;
        if (n != 43 && n != 92 && n != 102 && n != 15 && n != 17 && n != 54 && n != 45 && n != 61 && n != 28 && n != 12 && n != 50 && n != 21 && n != 27 && n != 71 && n != 44 && n != 78 && n != 79 && n != 82 && n != 55 && n != 191 && n != 94 && n != 111 && n != 128 && n != 122 && n != 104 && n != 186 && n != 187 && n != 110 && n != 125 && n != 142 && n != 131 && n != 132 && n != 167 && n != 188 && n != 189 && n != 110 && n != 91 && n != 161 && n != 103) {
            if (this.doba) {
                LiveEventBus.get((String)"com.lepu.ble.updater.ble.connected").post((Object)bluetoothDevice);
            } else if (doa.doac.doa.doac()) {
                this.doac();
            } else {
                if (Bluetooth.isEncryptDevice(this.doa)) {
                    return;
                }
                this.docf();
            }
        } else {
            LiveEventBus.get((String)"com.lepu.ble.device.ready").post((Object)this.doa);
        }
    }

    public boolean doab(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"bs");
        if (!this.doad && !this.doae) {
            doah.doah.doa(this.doab, "send cmd fail\uff0c state = false");
            return false;
        }
        this.dobc().doa(byArray);
        this.doac = doah.doa.doa(byArray);
        return true;
    }

    public final void doa(int n) {
        this.dobc().doa(n);
    }

    public final int dob() {
        return this.dobc().doae();
    }

    public final int doan() {
        return this.dobc().doad();
    }

    public final void doab() {
        this.dobe = -1;
        Job job = this.dobd;
        if (job != null) {
            Job.DefaultImpls.cancel$default((Job)job, null, (int)1, null);
        }
        this.dobd = null;
        doah.doah.doa("clearCmdTimeout");
    }

    public final int doa() {
        doa doa2 = this;
        doah.doah.doa(doa2.doab, "calBleState ---model: " + this.doa + ", state::::" + this.doad + ", ready::::" + this.doae + ", connecting::::" + this.doaf);
        return doa2.doad && this.doae ? 1 : (this.doaf ? 3 : 2);
    }

    public final void doce() {
        doa doa2 = this;
        doah.doah.doa(doa2.doab, "startRtTask");
        doa2.doak.removeCallbacks((Runnable)this.doal);
        doa2.doan = false;
        doa2.doak.postDelayed((Runnable)this.doal, 500L);
        LiveEventBus.get((String)"com.lepu.ble.realtime.start").post((Object)this.doa);
    }

    public final void doa(Function0 function0) {
        Function2 function2;
        doa doa2 = this;
        Intrinsics.checkNotNullParameter((Object)function0, (String)"sendCmd");
        doah.doah.doa(doa2.doab, "stopRtTask start...");
        doa2.doak.removeCallbacks((Runnable)this.doal);
        doa2.doan = true;
        Function2 function22 = function2;
        function2 = new Function2(function0, this, null){
            int doa;
            final /* synthetic */ Function0 doab;
            final /* synthetic */ doa doac;
            {
                this.doab = function0;
                this.doac = doa2;
                super(2, continuation);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int n = this.doa;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    ResultKt.throwOnFailure((Object)object);
                } else {
                    ResultKt.throwOnFailure((Object)object);
                    this.doa = 1;
                    if (DelayKt.delay((long)500L, (Continuation)this) == object2) {
                        return object2;
                    }
                }
                doac doac2 = this;
                doac2.doab.invoke();
                doah.doah.doa(doac2.doac.doab, "stopRtTask invoke start...");
                LiveEventBus.get((String)"com.lepu.ble.realtime.stop").post((Object)Boxing.boxInt((int)this.doac.dobd()));
                return Unit.INSTANCE;
            }

            public final Continuation create(Object object, Continuation continuation) {
                doac doac2 = doac3;
                doac doac3 = doac2.doab;
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object doa(CoroutineScope coroutineScope, Continuation continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        };
        BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)function22, (int)3, null);
    }

    public void doac() {
        doa doa2 = object;
        byte[] byArray = doah.doae.doad(doah.doae.doa(doa.doac.doa.doab()), ((doa)object).dobg);
        doa doa3 = object;
        byte[] byArray2 = ifgj.doac(byArray, new byte[0]);
        Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"encrypt(...)");
        doa3.doab(byArray2);
        String string = doa3.doab;
        StringBuilder stringBuilder = new StringBuilder().append("encrypt...lepuEncryptKey: ");
        Intrinsics.checkNotNull((Object)((doa)object).dobg);
        doah.doah.doa(string, stringBuilder.append(doah.doa.doa(((doa)object).dobg)).toString());
        Observable observable = LiveEventBus.get((String)"com.lepu.ble.encrypt.secret.key");
        Intrinsics.checkNotNull((Object)((doa)object).dobg);
        observable.post((Object)doah.doa.doa(((doa)object).dobg));
        String string2 = doa3.doab;
        StringBuilder stringBuilder2 = new StringBuilder().append("encrypt...encrypt: ");
        Intrinsics.checkNotNull((Object)byArray);
        doah.doah.doa(string2, stringBuilder2.append(doah.doa.doa(byArray)).toString());
        Object object = doah.doae.doac(byArray, doa3.dobg);
        String string3 = doa2.doab;
        StringBuilder stringBuilder3 = new StringBuilder().append("encrypt...decrypt: ");
        Object object2 = object;
        Intrinsics.checkNotNull((Object)object2);
        doah.doah.doa(string3, stringBuilder3.append(doah.doa.doa((byte[])object2)).toString());
    }

    public abstract void doam();

    public abstract void docf();

    public abstract void dobh();

    public abstract void doal();

    public final void doab(String string, String string2, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        this.dobm = n;
        this.dobl = false;
        this.dobk = false;
        this.doab(string, string2);
    }

    public abstract void doab(String var1, String var2);

    public abstract void docd();

    public abstract void doad();

    public abstract void doae();

    public final void doa(String string, String string2, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        this.dobm = n;
        this.doa(string, string2);
    }

    public abstract void doa(String var1, String var2);

    public final void doa(RssiCallback rssiCallback) {
        Intrinsics.checkNotNullParameter((Object)rssiCallback, (String)"callback");
        this.dobc().doa(rssiCallback);
    }

    public final class doa
    implements Runnable {
        @Override
        public void run() {
            doa doa2 = this;
            doah.doah.doa(doa2.doa.this.doab, "rtTask running...");
            if (doa2.doa.this.dobi()) {
                doa doa3 = this;
                doa3.doa.this.doak.postDelayed((Runnable)doa.this.doal, doa.this.doaj());
                if (!doa3.doa.this.doca()) {
                    doa.this.dobh();
                } else {
                    doah.doah.doa(doa.this.doab, "isRtStop = " + doa.this.doca());
                }
            } else {
                doah.doah.doa(doa.this.doab, "ble state = false !!!!");
            }
        }
    }
}
