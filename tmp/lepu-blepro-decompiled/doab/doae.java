/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  com.jeremyliao.liveeventbus.LiveEventBus
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 */
package doab;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lepu.blepro.event.InterfaceEvent;
import com.lepu.blepro.ext.airbp.Battery;
import com.lepu.blepro.ext.airbp.DeviceInfo;
import com.lepu.blepro.ext.airbp.RtResult;
import doa.doa;
import doab.doan;
import doac.doac;
import doac.doad;
import doac.doaf;
import doac.doag;
import doac.doai;
import doac.dobm;
import doac.y;
import doad.doeh;
import doah.doab;
import doah.doah;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public final class doae
extends doa {
    private final String doc;
    private int doca;
    private String docb = "";
    private String docd = "";
    private byte[] doce = new byte[0];
    private Battery docf = new Battery();
    private DeviceInfo docg = new DeviceInfo();
    private RtResult doch = new RtResult();

    public doae(int n) {
        super(n);
        this.doc = "AirBpBleInterface";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void doa(doad object) {
        doah.doah.doa(this.doc, "onResponseReceived bytes: " + doah.doa.doa(((doad)object).doa()));
        int n = ((doad)object).doab();
        if (n != 234) {
            if (n != 236) {
                if (n != 238) {
                    switch (n) {
                        default: {
                            switch (n) {
                                default: {
                                    switch (n) {
                                        default: {
                                            return;
                                        }
                                        case 244: {
                                            if (!this.dobk() && !this.doc()) {
                                                doac doac2;
                                                if (this.doca <= 0 || this.dobe() != this.doca) return;
                                                if (((doad)object).doae() != 0) return;
                                                object = doac2;
                                                doac2 = new doac(this.doce);
                                                doah.doah.doa(this.doc, "model:" + this.dobd() + ",READ_FILE_END => data: " + object);
                                                return;
                                            }
                                            doah.doah.doa(this.doc, "READ_FILE_END isCancelRF: " + this.dobk() + ", isPausedRF: " + this.doc() + ", offset: " + this.dobe() + ", fileSize: " + this.doca);
                                            return;
                                        }
                                        case 243: {
                                            if (!this.dobk() && !this.doc() && ((doad)object).doae() == 0) {
                                                this.doac(this.dobe() + ((doad)object).doad());
                                                doag.doa.doa.doa(this.dobd(), this.docb, this.docd, "dat", ((doad)object).doac());
                                                this.doce = doah.doa.doa(this.doce, ((doad)object).doac());
                                                int cfr_ignored_0 = this.dobe() * 100 / this.doca;
                                                doah.doah.doa(this.doc, "model:" + this.dobd() + ",READ_FILE_DATA => offset: " + this.dobe() + ", fileSize: " + this.doca);
                                                if (this.dobe() < this.doca) {
                                                    byte[] byArray = doac.doab.doab(this.dobe());
                                                    object = byArray;
                                                    Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileData(...)");
                                                    this.doab((byte[])object);
                                                    return;
                                                }
                                                byte[] byArray = doac.doab.doai();
                                                object = byArray;
                                                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileEnd(...)");
                                                this.doab((byte[])object);
                                                return;
                                            }
                                            byte[] byArray = doac.doab.doai();
                                            object = byArray;
                                            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileEnd(...)");
                                            this.doab((byte[])object);
                                            doah.doah.doa(this.doc, "READ_FILE_DATA isCancelRF: " + this.dobk() + ", isPausedRF: " + this.doc());
                                            return;
                                        }
                                        case 242: {
                                            if (!this.dobk() && !this.doc()) {
                                                this.doca = 0;
                                                this.doce = new byte[0];
                                                if (((doad)object).doad() >= 4 && ((doad)object).doae() == 0) {
                                                    byte[] byArray;
                                                    if (this.dobe() == 0) {
                                                        doag.doa.doa.doa(this.dobd(), this.docb, this.docd, "dat");
                                                        byArray = new byte[]{};
                                                    } else {
                                                        byArray = doag.doa.doa.doa(this.dobd(), this.docb, this.docd);
                                                    }
                                                    this.doce = byArray;
                                                    this.doac(byArray.length);
                                                    this.doca = doah.doa.doah(((doad)object).doac());
                                                    if (this.doca > 0 && this.dobe() < this.doca) {
                                                        byte[] byArray2 = doac.doab.doab(this.dobe());
                                                        object = byArray2;
                                                        Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"readFileData(...)");
                                                        this.doab((byte[])object);
                                                    } else {
                                                        byte[] byArray3 = doac.doab.doai();
                                                        object = byArray3;
                                                        Intrinsics.checkNotNullExpressionValue((Object)byArray3, (String)"readFileEnd(...)");
                                                        this.doab((byte[])object);
                                                    }
                                                    doah.doah.doa(this.doc, "model:" + this.dobd() + ",READ_FILE_START => fileName: " + this.docd + ", offset: " + this.dobe() + ", fileSize: " + this.doca);
                                                    return;
                                                }
                                                doah.doah.doa(this.doc, "model:" + this.dobd() + ",READ_FILE_START => response.len < 4");
                                                byte[] byArray = doac.doab.doai();
                                                object = byArray;
                                                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileEnd(...)");
                                                this.doab((byte[])object);
                                                return;
                                            }
                                            byte[] byArray = doac.doab.doai();
                                            object = byArray;
                                            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileEnd(...)");
                                            this.doab((byte[])object);
                                            doah.doah.doa(this.doc, "READ_FILE_START isCancelRF: " + this.dobk() + ", isPausedRF: " + this.doc());
                                            return;
                                        }
                                        case 241: {
                                            doag doag2;
                                            if (((doad)object).doac().length == 0 || ((doad)object).doae() != 0) {
                                                doah.doah.doab(this.doc, "GET_FILE_LIST response.size:" + ((doad)object).doac().length + " error");
                                                return;
                                            }
                                            doag doag3 = doag2;
                                            doag2 = new doag(((doad)object).doac());
                                            doah.doah.doa(this.doc, "model:" + this.dobd() + ", GET_FILE_LIST => success, data : " + doag3);
                                            return;
                                        }
                                    }
                                }
                                case 228: {
                                    if (((doad)object).doad() >= 4 && ((doad)object).doae() == 0) {
                                        doeh doeh2;
                                        doeh doeh3 = doeh2;
                                        doeh2 = new doeh(((doad)object).doac());
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ",GET_BATTERY => success, data: " + doeh3);
                                        this.docf.setState(doeh3.doab());
                                        this.docf.setPercent(doeh3.doa());
                                        this.docf.setVol(doeh3.doad());
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.get.battery").post((Object)new InterfaceEvent(this.dobd(), this.docf));
                                        return;
                                    }
                                    doah.doah.doa(this.doc, "model:" + this.dobd() + ",GET_BATTERY => response.len < 4");
                                    return;
                                }
                                case 227: {
                                    if (((doad)object).doae() == 0) {
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", FACTORY_RESET => success");
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.factory.reset").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
                                        return;
                                    } else {
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", FACTORY_RESET => failed");
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.factory.reset").post((Object)new InterfaceEvent(this.dobd(), Boolean.FALSE));
                                    }
                                    return;
                                }
                                case 226: {
                                    if (((doad)object).doae() == 0) {
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", RESET => success");
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.reset").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
                                        return;
                                    } else {
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", RESET => failed");
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.reset").post((Object)new InterfaceEvent(this.dobd(), Boolean.FALSE));
                                    }
                                    return;
                                }
                                case 225: {
                                    if (((doad)object).doac().length >= 20 && ((doad)object).doae() == 0) {
                                        doaf doaf2;
                                        doaf doaf3 = doaf2;
                                        doaf2 = new doaf(((doad)object).doac());
                                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", GET_INFO => success, data: " + doaf3);
                                        this.docg.setHwV(doaf3.doah());
                                        this.docg.setFwV(doaf3.doaf());
                                        this.docg.setBtlV(doaf3.doab());
                                        this.docg.setSn(doaf3.doan());
                                        this.docg.setDeviceType(doaf3.doae());
                                        this.docg.setProtocolV(doaf3.doal());
                                        this.docg.setYear(doaf3.dob());
                                        this.docg.setMonth(doaf3.doaj());
                                        this.docg.setDay(doaf3.doad());
                                        this.docg.setHour(doaf3.doag());
                                        this.docg.setMinute(doaf3.doai());
                                        this.docg.setSecond(doaf3.doam());
                                        this.docg.setCommunicateMaxLen(doaf3.doac());
                                        this.docg.setProtocolMaxLen(doaf3.doak());
                                        this.docg.setBranchCode(doaf3.doa());
                                        LiveEventBus.get((String)"com.lepu.ble.air.bp.get.info").post((Object)new InterfaceEvent(this.dobd(), this.docg));
                                        return;
                                    }
                                    doah.doah.doab(this.doc, "GET_INFO response.size:" + ((doad)object).doac().length + " error");
                                    return;
                                }
                            }
                        }
                        case 9: {
                            if (((doad)object).doae() == 0) {
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", SET_CONFIG => success");
                                LiveEventBus.get((String)"com.lepu.ble.air.bp.set.config").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
                                return;
                            } else {
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", SET_CONFIG => failed");
                                LiveEventBus.get((String)"com.lepu.ble.air.bp.set.config").post((Object)new InterfaceEvent(this.dobd(), Boolean.FALSE));
                            }
                            return;
                        }
                        case 7: {
                            if (((doad)object).doac().length >= 16 && ((doad)object).doae() == 0) {
                                doai doai2;
                                doai doai3 = doai2;
                                doai2 = new doai(((doad)object).doac());
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", RT_RESULT => success, data : " + doai3);
                                this.doch.setYear(doai3.doak());
                                this.doch.setMonth(doai3.doaf());
                                this.doch.setDay(doai3.doa());
                                this.doch.setHour(doai3.doac());
                                this.doch.setMinute(doai3.doae());
                                this.doch.setSecond(doai3.doah());
                                this.doch.setStateCode(doai3.doai());
                                this.doch.setSys(doai3.doaj());
                                this.doch.setDia(doai3.doab());
                                this.doch.setMean(doai3.doad());
                                this.doch.setPr(doai3.doag());
                                LiveEventBus.get((String)"com.lepu.ble.air.bp.rt.result").post((Object)new InterfaceEvent(this.dobd(), this.doch));
                                return;
                            }
                            doah.doah.doab(this.doc, "RT_RESULT response.size:" + ((doad)object).doac().length + " error");
                            return;
                        }
                        case 6: {
                            if (((doad)object).doac().length == 0 || ((doad)object).doae() != 0) {
                                doah.doah.doab(this.doc, "RT_STATE response.size:" + ((doad)object).doac().length + " error");
                                return;
                            }
                            int n2 = doah.doa.doah(((doad)object).doac());
                            doah.doah.doa(this.doc, "model:" + this.dobd() + ", RT_STATE => success, data : " + n2);
                            int n3 = this.dobd();
                            LiveEventBus.get((String)"com.lepu.ble.air.bp.rt.state").post((Object)new InterfaceEvent(n3, n2));
                            return;
                        }
                        case 5: {
                            if (((doad)object).doae() == 0) {
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", STOP_BP => success");
                                return;
                            } else {
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", STOP_BP => failed");
                            }
                            return;
                        }
                        case 4: 
                        case 8: {
                            if (((doad)object).doac().length >= 4 && ((doad)object).doae() == 0) {
                                doac.doah doah2;
                                doac.doah doah3 = doah2;
                                doah2 = new doac.doah(((doad)object).doac());
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", START_BP, START_BP_TEST => success, data : " + doah3);
                                LiveEventBus.get((String)"com.lepu.ble.air.bp.rt.data").post((Object)new InterfaceEvent(this.dobd(), doah3.doa()));
                                return;
                            }
                            doah.doah.doab(this.doc, "START_BP, START_BP_TEST response.size:" + ((doad)object).doac().length + " error");
                            return;
                        }
                        case 3: {
                            ((doad)object).doae();
                            return;
                        }
                        case 2: {
                            if (((doad)object).doae() != 0) return;
                            if (((doad)object).doac().length < 2) {
                                doah.doah.doab(this.doc, "CALIBRATION_SLOPE response.size:" + ((doad)object).doac().length + " error");
                                return;
                            }
                            int n4 = doah.doa.doah(((doad)object).doac());
                            doah.doah.doa(this.doc, "model:" + this.dobd() + ", CALIBRATION_SLOPE => success, data : " + n4);
                            return;
                        }
                        case 1: {
                            if (((doad)object).doae() != 0) return;
                            if (((doad)object).doac().length < 2) {
                                doah.doah.doab(this.doc, "CALIBRATION_ZERO response.size:" + ((doad)object).doac().length + " error");
                                return;
                            }
                            int n5 = doah.doa.doah(((doad)object).doac());
                            doah.doah.doa(this.doc, "model:" + this.dobd() + ", CALIBRATION_ZERO => success, data : " + n5);
                            return;
                        }
                        case 0: {
                            if (((doad)object).doac().length >= 24 && ((doad)object).doae() == 0) {
                                doac.doae doae2;
                                doac.doae doae3 = doae2;
                                doae2 = new doac.doae(((doad)object).doac());
                                doah.doah.doa(this.doc, "model:" + this.dobd() + ", GET_CONFIG => success, data : " + doae3);
                                LiveEventBus.get((String)"com.lepu.ble.air.bp.get.config").post((Object)new InterfaceEvent(this.dobd(), doae3.doa()));
                                return;
                            }
                            doah.doah.doab(this.doc, "GET_CONFIG response.size:" + ((doad)object).doac().length + " error");
                            return;
                        }
                    }
                }
                if (((doad)object).doae() == 0) {
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ", FACTORY_RESET_ALL => success");
                    return;
                } else {
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ", FACTORY_RESET_ALL => failed");
                }
                return;
            }
            if (((doad)object).doae() == 0) {
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", SET_TIME => success");
                LiveEventBus.get((String)"com.lepu.ble.air.bp.set.time").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
                return;
            } else {
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", SET_TIME => failed");
                LiveEventBus.get((String)"com.lepu.ble.air.bp.set.time").post((Object)new InterfaceEvent(this.dobd(), Boolean.FALSE));
            }
            return;
        }
        if (((doad)object).doae() == 0) {
            doah.doah.doa(this.doc, "model:" + this.dobd() + ", BURN_FACTORY_INFO => success");
            return;
        } else {
            doah.doah.doa(this.doc, "model:" + this.dobd() + ", BURN_FACTORY_INFO => failed");
        }
    }

    private static final void doa(doae doae2, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter((Object)doae2, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"it");
        doah.doah.doa(doae2.doc, "manager.connect done");
    }

    @Override
    public void doa(Context context, BluetoothDevice bluetoothDevice, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        if (this.dobn()) {
            if (this.dobc().getBluetoothDevice() == null) {
                doae doae2 = this;
                doae2.doa(new doan(context));
                doah.doah.doa(doae2.doc, "isManagerInitialized, manager.bluetoothDevice == null");
                doah.doah.doa(doae2.doc, "isManagerInitialized, manager.create done");
            } else {
                doah.doah.doa(this.doc, "isManagerInitialized, manager.bluetoothDevice != null");
            }
        } else {
            doae doae3 = this;
            doae3.doa(new doan(context));
            doah.doah.doa(doae3.doc, "!isManagerInitialized, manager.create done");
        }
        doae doae4 = this;
        doae4.dobc().doa(bl);
        doae4.dobc().setConnectionObserver(this);
        doae4.dobc().doa(this);
        doae4.dobc().connect(bluetoothDevice).useAutoConnect(false).timeout(10000L).retry(3, 100).done(arg_0 -> doae.doa(this, arg_0)).enqueue();
    }

    @Override
    public byte[] doa(byte[] object) {
        if (object != null && ((byte[])object).length >= 9) {
            int n = ((byte[])object).length - 8;
            for (int i = 0; i < n; ++i) {
                y y2;
                byte[] byArray;
                if (object[i] != -91 || object[i + 1] != 0) continue;
                int n2 = doah.doa.doah(ArraysKt.copyOfRange((byte[])object, (int)(i + 4), (int)(i + 8))) & Integer.MAX_VALUE;
                if ((n2 = i + 9 + n2) > ((byte[])object).length || (byArray = ArraysKt.copyOfRange((byte[])object, (int)i, (int)n2)).length < 8) continue;
                if (ArraysKt.last((byte[])byArray) == dobm.doa(byArray)) {
                    this.doa(new doad(byArray));
                    object = n2 == ((byte[])object).length ? null : ArraysKt.copyOfRange((byte[])object, (int)n2, (int)((byte[])object).length);
                    return this.doa((byte[])object);
                }
                y y3 = y2;
                y3();
                y3.doab(this.dobd());
                y2.doa(doab.doa(byArray[3]));
                y2.doad(2);
                LiveEventBus.get((String)"com.lepu.ble.cmd.response.error").post((Object)y3);
            }
            return object;
        }
        return object;
    }

    public final void doch() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doad();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBattery(...)");
        doae2.doab(byArray);
        doah.doah.doa(doae2.doc, "getBattery");
    }

    @Override
    public void doam() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doag();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getInfo(...)");
        doae2.doab(byArray);
        doah.doah.doa(doae2.doc, "getInfo");
    }

    @Override
    public void docf() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doak();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"setTime(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "syncTime");
    }

    @Override
    public void dobh() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doah();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getRtState(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "getRtData");
    }

    public final void doci() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doae();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getConfig(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "getConfig");
    }

    public final void docg() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doa();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"calibrationZero(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "calibrationZero");
    }

    public final void doae(int n) {
        doae doae2 = this;
        byte[] byArray = doac.doab.doa(n);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"calibrationSlope(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "calibrationSlope");
    }

    public final void doaf(int n) {
        doae doae2 = this;
        byte[] byArray = doac.doab.doac(n);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"setStopPressure(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "setStopPressure");
    }

    public final void docj() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doal();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"startBpTest(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "startBpTest");
    }

    public final void doaf(boolean bl) {
        doae doae2 = this;
        byte[] byArray = doac.doab.doa(bl);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"setConfig(...)");
        doae2.doab(byArray);
        doah.doah.doa(doae2.doc, "setConfig : " + bl);
    }

    @Override
    public void doal() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doaf();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getFileList(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "getFileList");
    }

    @Override
    public void doab(String string, String string2) {
        doae doae2 = this;
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        this.docb = string;
        this.docd = string2;
        byte[] byArray = string2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
        byte[] byArray2 = doac.doab.doa(byArray, (byte)0);
        Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"readFileStart(...)");
        doae2.doab(byArray2);
        doah.doah.doab(doae2.doc, "dealReadFile");
    }

    @Override
    public void docd() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doaj();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"reset(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "reset");
    }

    @Override
    public void doad() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doab();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"factoryReset(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "factoryReset");
    }

    @Override
    public void doae() {
        doae doae2 = this;
        byte[] byArray = doac.doab.doac();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"factoryResetAll(...)");
        doae2.doab(byArray);
        doah.doah.doab(doae2.doc, "factoryResetAll");
    }

    @Override
    public void doa(String string, String string2) {
        doae doae2 = this;
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        doae2.doab(string, string2);
        doah.doah.doab(doae2.doc, "dealContinueRF");
    }
}
