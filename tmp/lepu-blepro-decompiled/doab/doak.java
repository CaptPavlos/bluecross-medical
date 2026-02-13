/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  com.jeremyliao.liveeventbus.LiveEventBus
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package doab;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lepu.blepro.event.InterfaceEvent;
import com.lepu.blepro.ext.bioland.DeviceInfo;
import com.lepu.blepro.ext.bioland.GluData;
import doa.doa;
import doab.doal;
import doac.dobi;
import doac.dobj;
import doac.dobk;
import doac.dobl;
import doac.y;
import doah.doab;
import doah.doah;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

public final class doak
extends doa {
    private final String doc;
    private DeviceInfo doca;
    private GluData docb;

    public doak(int n) {
        super(n);
        GluData gluData;
        DeviceInfo deviceInfo;
        ((doak)object).doc = "BiolandBgmBleInterface";
        Object object = deviceInfo;
        deviceInfo = new DeviceInfo();
        v1.doca = object;
        object = gluData;
        gluData = new GluData();
        v1.docb = object;
    }

    private final void doa(dobj dobj2) {
        doah.doah.doa(this.doc, "onResponseReceived received : " + doah.doa.doa(dobj2.doa()));
        int n = dobj2.doab();
        if (n != 0) {
            if (n != 5) {
                if (n != 9) {
                    if (n != 2) {
                        if (n == 3) {
                            dobl dobl2;
                            if (dobj2.doac().length < 8) {
                                doah.doah.doab(this.doc, "response.size:" + dobj2.doac().length + " error");
                                return;
                            }
                            dobl dobl3 = dobl2;
                            dobl2 = new dobl(dobj2.doac());
                            doah.doah.doa(this.doc, "model:" + this.dobd() + ",GET_DATA => success " + dobl3);
                            this.docb.setYear(dobl3.doag());
                            this.docb.setMonth(dobl3.doad());
                            this.docb.setDay(dobl3.doa());
                            this.docb.setHour(dobl3.doab());
                            this.docb.setMinute(dobl3.doac());
                            this.docb.setResultMg(dobl3.doae());
                            this.docb.setResultMmol(dobl3.doaf());
                            LiveEventBus.get((String)"com.lepu.ble.bioland.bgm.glu.data").post((Object)new InterfaceEvent(this.dobd(), this.docb));
                        }
                    } else {
                        if (dobj2.doac().length < 2) {
                            doah.doah.doab(this.doc, "response.size:" + dobj2.doac().length + " error");
                            return;
                        }
                        int n2 = doab.doa(dobj2.doac()[1]);
                        doah.doah.doa(this.doc, "model:" + this.dobd() + ",MSG_ING => success " + n2);
                        int n3 = this.dobd();
                        LiveEventBus.get((String)"com.lepu.ble.bioland.bgm.count.down").post((Object)new InterfaceEvent(n3, n2));
                    }
                } else {
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ",HAND_SHAKE => success");
                }
            } else {
                doah.doah.doa(this.doc, "model:" + this.dobd() + ",MSG_END => success");
                LiveEventBus.get((String)"com.lepu.ble.bioland.bgm.no.glu.data").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
            }
        } else {
            dobk dobk2;
            if (dobj2.doac().length < 5) {
                doah.doah.doab(this.doc, "response.size:" + dobj2.doac().length + " error");
                return;
            }
            dobk dobk3 = dobk2;
            dobk2 = new dobk(dobj2.doac());
            doah.doah.doa(this.doc, "model:" + this.dobd() + ",GET_INFO => success " + dobk3);
            this.doca.setVersion(dobk3.doaf());
            this.doca.setCustomerType(dobk3.doab());
            this.doca.setBattery(dobk3.doa());
            this.doca.setDeviceType(dobk3.doad());
            this.doca.setDeviceCode(dobk3.doac());
            this.doca.setSn(dobk3.doae());
            LiveEventBus.get((String)"com.lepu.ble.bioland.bgm.device.info").post((Object)new InterfaceEvent(this.dobd(), this.doca));
        }
    }

    private static final void doa(doak doak2, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter((Object)doak2, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"it");
        doah.doah.doa(doak2.doc, "manager.connect done");
    }

    @Override
    public void doa(Context context, BluetoothDevice bluetoothDevice, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        if (this.dobn()) {
            if (this.dobc().getBluetoothDevice() == null) {
                doak doak2 = this;
                doak2.doa(new doal(context));
                doah.doah.doa(doak2.doc, "isManagerInitialized, manager.bluetoothDevice == null");
                doah.doah.doa(doak2.doc, "isManagerInitialized, manager.create done");
            } else {
                doah.doah.doa(this.doc, "isManagerInitialized, manager.bluetoothDevice != null");
            }
        } else {
            doak doak3 = this;
            doak3.doa(new doal(context));
            doah.doah.doa(doak3.doc, "!isManagerInitialized, manager.create done");
        }
        doak doak4 = this;
        doak4.dobc().doa(bl);
        doak4.dobc().setConnectionObserver(this);
        doak4.dobc().doa(this);
        doak4.dobc().connect(bluetoothDevice).useAutoConnect(false).timeout(10000L).retry(3, 100).done(arg_0 -> doak.doa(this, arg_0)).enqueue();
    }

    @Override
    public byte[] doa(byte[] object) {
        if (object != null && ((byte[])object).length >= 4) {
            int n = ((byte[])object).length - 3;
            for (int i = 0; i < n; ++i) {
                y y2;
                byte[] byArray;
                int n2;
                if (object[i] != 85 || (n2 = i + doab.doa(object[i + 1])) > ((byte[])object).length || (byArray = ArraysKt.copyOfRange((byte[])object, (int)i, (int)n2)).length < 4) continue;
                if (ArraysKt.last((byte[])byArray) == dobi.doa(byArray)) {
                    this.doa(new dobj(byArray));
                    object = n2 == ((byte[])object).length ? null : ArraysKt.copyOfRange((byte[])object, (int)n2, (int)((byte[])object).length);
                    return this.doa((byte[])object);
                }
                y y3 = y2;
                y3();
                y3.doab(this.dobd());
                y2.doa(doab.doa(byArray[2]));
                y2.doad(2);
                LiveEventBus.get((String)"com.lepu.ble.cmd.response.error").post((Object)y3);
            }
            return object;
        }
        return object;
    }

    @Override
    public void docf() {
    }

    @Override
    public void doam() {
        doak doak2 = this;
        byte[] byArray = dobi.doab();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getInfo(...)");
        doak2.doab(byArray);
        doah.doah.doab(doak2.doc, "getInfo");
    }

    @Override
    public void doal() {
        doak doak2 = this;
        byte[] byArray = dobi.doa();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getData(...)");
        doak2.doab(byArray);
        doah.doah.doab(doak2.doc, "getFileList");
    }

    @Override
    public void doab(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        doah.doah.doab(this.doc, "dealReadFile not yet implemented");
    }

    @Override
    public void docd() {
        doah.doah.doab(this.doc, "reset not yet implemented");
    }

    @Override
    public void doad() {
        doah.doah.doab(this.doc, "factoryReset not yet implemented");
    }

    @Override
    public void doae() {
        doah.doah.doab(this.doc, "factoryResetAll not yet implemented");
    }

    @Override
    public void doa(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        doah.doah.doab(this.doc, "dealContinueRF not yet implemented");
    }

    @Override
    public void dobh() {
        doah.doah.doab(this.doc, "getRtData not yet implemented");
    }
}
