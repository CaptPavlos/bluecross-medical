/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothManager
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 *  android.bluetooth.le.ScanSettings
 *  android.bluetooth.le.ScanSettings$Builder
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.CountDownTimer
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  com.jeremyliao.liveeventbus.LiveEventBus
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.GlobalScope
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 */
package doa;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.SparseArray;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lepu.blepro.ext.BleServiceHelper;
import com.lepu.blepro.objs.Bluetooth;
import com.lepu.blepro.objs.BluetoothController;
import com.lepu.blepro.utils.HexString;
import doa.doa;
import doab.doad;
import doab.doae;
import doab.doaf;
import doab.doaj;
import doab.doak;
import doab.doam;
import doab.dob;
import doab.doba;
import doab.dobd;
import doab.dobf;
import doab.dobh;
import doab.dobi;
import doab.dobj;
import doab.dobk;
import doab.dobl;
import doab.dobn;
import doab.doc;
import doab.docb;
import doab.doce;
import doab.docg;
import doab.doch;
import doab.docj;
import doab.docl;
import doab.docn;
import doab.doea;
import doab.doeb;
import doab.doed;
import doab.doef;
import doab.doeh;
import doab.doei;
import doab.doej;
import doab.doem;
import doab.dofa;
import doab.dofc;
import doab.dofe;
import doab.dofg;
import doab.dofi;
import doab.dofl;
import doab.dofn;
import doab.doga;
import doab.dogc;
import doab.dogd;
import doab.dogf;
import doab.dogi;
import doab.dogj;
import doab.dogk;
import doab.dogl;
import doab.dogm;
import doah.doah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class doac {
    public static final doac doa = new doac();
    private static final String doab = "LpWorkManager";
    private static Application doac;
    private static SparseArray doad;
    private static SparseArray doae;
    private static int[] doaf;
    private static boolean doag;
    private static boolean doah;
    private static String doai;
    private static String doaj;
    private static boolean doak;
    private static boolean doal;
    private static String doam;
    private static boolean doan;
    private static ArrayList dob;
    private static ArrayList doba;
    private static boolean dobc;
    private static boolean dobd;
    private static boolean dobe;
    private static int dobf;
    private static boolean dobg;
    private static CountDownTimer dobh;
    private static Job dobi;
    private static boolean dobj;
    private static BluetoothAdapter dobk;
    private static BluetoothLeScanner dobl;
    private static final ScanCallback dobm;

    private doac() {
    }

    private final void doba() {
        BluetoothAdapter bluetoothAdapter;
        int n;
        Object object = doac;
        Object object2 = object != null ? object.getSystemService("bluetooth") : null;
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        object = ((BluetoothManager)object2).getAdapter();
        dobk = object;
        dobl = object != null ? object.getBluetoothLeScanner() : null;
        object = doab;
        doah.doah.doa((String)object, "initBle success");
        if (dobl == null) {
            doah.doah.doa((String)object, "leScanner is null");
        }
        if ((n = Build.VERSION.SDK_INT) >= 26 && n <= 31 && (bluetoothAdapter = dobk) != null) {
            dobe = bluetoothAdapter.isLe2MPhySupported();
        }
    }

    public static /* synthetic */ void doa(doac doac2, int[] nArray, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 1) != 0) {
            nArray = null;
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        doac2.doa(nArray, bl, bl2);
    }

    public static /* synthetic */ void doa(doac doac2, int[] nArray, String[] stringArray, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 1) != 0) {
            nArray = null;
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            bl2 = false;
        }
        doac2.doa(nArray, stringArray, bl, bl2);
    }

    public static /* synthetic */ void doab(doac doac2, int[] nArray, String[] stringArray, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 1) != 0) {
            nArray = null;
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            bl2 = false;
        }
        doac2.doab(nArray, stringArray, bl, bl2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void doa(boolean var1_1) {
        block21: {
            block22: {
                try {
                    v0 = var1_1;
                    this = doa.doac.doab;
                }
                catch (Exception v1) {
                    break block21;
                }
                {
                    doah.doah.doa(this, "scanDevice => " + var1_1);
                    doa.doac.dobh.cancel();
                    doah.doah.doa(this, "scanDevice scanTimer.cancel()");
                    if (!v0) ** GOTO lbl59
                    var1_2 /* !! */  = doa.doac.dobk;
                    if (var1_2 /* !! */  == null) ** GOTO lbl46
                }
                {
                    if (!var1_2 /* !! */ .isEnabled()) ** GOTO lbl39
                    if (Build.VERSION.SDK_INT < 23) break block22;
                    var1_2 /* !! */  = new ScanSettings.Builder().setScanMode(2).setCallbackType(1).build();
                }
                Intrinsics.checkNotNull((Object)var1_2 /* !! */ );
                ** GOTO lbl21
            }
            var1_2 /* !! */  = new ScanSettings.Builder().setScanMode(2).build();
            {
                Intrinsics.checkNotNull((Object)var1_2 /* !! */ );
lbl21:
                // 2 sources

                if (doa.doac.dobl != null) ** GOTO lbl25
                var2_4 /* !! */  = doa.doac.dobk;
                var2_4 /* !! */  = var2_4 /* !! */  != null ? var2_4 /* !! */ .getBluetoothLeScanner() : null;
            }
            {
                doa.doac.dobl = var2_4 /* !! */ ;
lbl25:
                // 2 sources

                doa.doac.dobg = true;
                doah.doah.doa(this, "scanDevice isWaitingScanResult = true");
                var2_4 /* !! */  = doa.doac.dobl;
                if (var2_4 /* !! */  == null) ** GOTO lbl33
                v2 = var2_4 /* !! */ ;
                var2_4 /* !! */  = null;
            }
            {
                var3_5 = doa.doac.dobm;
                v2.startScan((List)var2_4 /* !! */ , (ScanSettings)var1_2 /* !! */ , var3_5);
lbl33:
                // 2 sources

                v3 = this;
                doa.doac.dobj = true;
                doa.doac.dobh.start();
            }
            {
                doah.doah.doa(v3, "scanDevice scanTimer.start()");
                ** GOTO lbl44
lbl39:
                // 1 sources

                var1_2 /* !! */  = doa.doac.dobk;
                if (var1_2 /* !! */  == null) ** GOTO lbl-1000
            }
            {
                var1_2 /* !! */ .enable();
            }
lbl-1000:
            // 2 sources

            {
                block23: {
                    doah.doah.doa(this, "scanDevice bluetoothAdapter disable");
lbl44:
                    // 2 sources

                    var1_2 /* !! */  = Unit.INSTANCE;
                    break block23;
lbl46:
                    // 1 sources

                    var1_2 /* !! */  = null;
                }
                if (var1_2 /* !! */  != null) return;
                var1_2 /* !! */  = doa.doac.doac;
                var1_2 /* !! */  = var1_2 /* !! */  != null ? var1_2 /* !! */ .getSystemService("bluetooth") : null;
            }
            {
                v4 = var1_2 /* !! */ ;
                Intrinsics.checkNotNull((Object)v4, (String)"null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                var1_2 /* !! */  = ((BluetoothManager)v4).getAdapter();
            }
            {
                doa.doac.dobk = var1_2 /* !! */ ;
                var1_2 /* !! */  = var1_2 /* !! */  != null ? var1_2 /* !! */ .getBluetoothLeScanner() : null;
                doa.doac.dobl = var1_2 /* !! */ ;
                doah.doah.doa(this, "scanDevice bluetoothAdapter null");
                return;
lbl59:
                // 1 sources

                var1_3 /* !! */  = doa.doac.dobk;
                if (var1_3 /* !! */  == null) ** GOTO lbl79
            }
            {
                if (!var1_3 /* !! */ .isEnabled()) ** GOTO lbl72
                if (doa.doac.dobl != null) ** GOTO lbl66
                var1_3 /* !! */  = doa.doac.dobk;
                var1_3 /* !! */  = var1_3 /* !! */  != null ? var1_3 /* !! */ .getBluetoothLeScanner() : null;
            }
            {
                doa.doac.dobl = var1_3 /* !! */ ;
lbl66:
                // 2 sources

                if ((var1_3 /* !! */  = doa.doac.dobl) == null) ** GOTO lbl79
            }
            {
                var1_3 /* !! */ .stopScan(doa.doac.dobm);
                v5 = Unit.INSTANCE;
lbl69:
                // 2 sources

                while (true) {
                    var1_3 /* !! */  = v5;
                    ** GOTO lbl80
                    break;
                }
lbl72:
                // 1 sources

                var1_3 /* !! */  = doa.doac.dobk;
                if (var1_3 /* !! */  == null) ** GOTO lbl-1000
            }
            {
                var1_3 /* !! */ .enable();
            }
lbl-1000:
            // 2 sources

            {
                doah.doah.doa(this, "scanDevice bluetoothAdapter disable");
                v5 = Unit.INSTANCE;
                ** continue;
lbl79:
                // 2 sources

                var1_3 /* !! */  = null;
lbl80:
                // 2 sources

                if (var1_3 /* !! */  != null) ** GOTO lbl90
                var1_3 /* !! */  = doa.doac.doac;
                var1_3 /* !! */  = var1_3 /* !! */  != null ? var1_3 /* !! */ .getSystemService("bluetooth") : null;
            }
            {
                v6 = var1_3 /* !! */ ;
                Intrinsics.checkNotNull((Object)v6, (String)"null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                var1_3 /* !! */  = ((BluetoothManager)v6).getAdapter();
            }
            {
                doa.doac.dobk = var1_3 /* !! */ ;
                var1_3 /* !! */  = var1_3 /* !! */  != null ? var1_3 /* !! */ .getBluetoothLeScanner() : null;
                doa.doac.dobl = var1_3 /* !! */ ;
                doah.doah.doa(this, "scanDevice bluetoothAdapter null");
lbl90:
                // 2 sources

                doa.doac.dobj = false;
                doa.doac.dobg = false;
                doah.doah.doa(this, "scanDevice isWaitingScanResult = false");
                return;
            }
        }
        v1.printStackTrace();
    }

    private final boolean doa(Bluetooth bluetooth) {
        Object object = doaf;
        if (doaf != null) {
            return ArraysKt.contains((int[])object, (int)bluetooth.getModel());
        }
        return false;
    }

    static {
        doad = new SparseArray();
        doae = new SparseArray();
        doai = "";
        doaj = "";
        doam = "0000";
        dob = new ArrayList();
        doba = new ArrayList();
        dobh = new CountDownTimer(){

            public void onTick(long l) {
                doah.doah.doa(doa.doam(), "-------scanTimer-onTick------");
                LiveEventBus.get((String)"com.lepu.ble.start").post((Object)Boolean.FALSE);
            }

            public void onFinish() {
                Object object = doa;
                ((doac)object).doa(((doac)object).doae() + 1);
                if (((doac)object).doae() > 3) {
                    LiveEventBus.get((String)"com.lepu.ble.error").post((Object)Boolean.TRUE);
                } else {
                    doab doab2 = object;
                    object = ((doac)((Object)doab2)).doaj();
                    boolean bl = ((doac)((Object)doab2)).doad();
                    boolean bl2 = ((doac)((Object)doab2)).dobe();
                    ((doac)((Object)doab2)).doa((int[])object, bl, bl2);
                    doah.doah.doa(((doac)((Object)doab2)).doam(), "-------scanTimer-onFinish------");
                    LiveEventBus.get((String)"com.lepu.ble.start").post((Object)Boolean.TRUE);
                }
            }
        };
        dobm = new ScanCallback(){

            public void onScanResult(int n, ScanResult object) {
                Bluetooth bluetooth;
                int n2;
                Intrinsics.checkNotNullParameter((Object)object, (String)"result");
                super.onScanResult(n, object);
                Object object2 = doa;
                if (((doac)object2).dobh()) {
                    ((doac)object2).doad(false);
                    doah.doah.doa(((doac)object2).doam(), "onScanResult \u626b\u63cf\u6709\u7ed3\u679c\u8fd4\u56de");
                    ((doac)object2).doak().cancel();
                    doah.doah.doa(((doac)object2).doam(), "onScanResult \u53d6\u6d88\u5b9a\u65f6\u91cd\u626b\u673a\u5236");
                }
                ScanResult scanResult = object;
                BluetoothDevice bluetoothDevice = scanResult.getDevice();
                String string = scanResult.getDevice().getName();
                String string2 = scanResult.getDevice().getAddress();
                Object object3 = scanResult.getScanRecord();
                if (object3 != null && !TextUtils.isEmpty((CharSequence)(string = object3.getDeviceName()))) {
                    string = HexString.trimStr(string);
                }
                if (TextUtils.isEmpty((CharSequence)string)) {
                    string = BluetoothController.getDeviceName(string2);
                }
                if ((n2 = Bluetooth.getDeviceModel(string)) == 0) {
                    if (((doac)object2).doaj() == null) {
                        if (((doac)object2).doad() && (string = object.getScanRecord()) != null) {
                            HashMap<String, Object> hashMap;
                            HashMap<String, Object> hashMap2 = hashMap;
                            hashMap2();
                            Intrinsics.checkNotNull((Object)bluetoothDevice);
                            hashMap.put("com.lepu.ble.device.found.device", bluetoothDevice);
                            hashMap.put("com.lepu.ble.device.found.scanResult", string);
                            doah.doah.doa(((doac)object2).doam(), "post paring..." + bluetoothDevice.getName());
                            LiveEventBus.get((String)"com.lepu.ble.device.found.scanResult.unregister").post(hashMap2);
                        }
                        doah.doah.doa(((doac)object2).doam(), "onScanResult \u5916\u53d1sdk\u672a\u80fd\u8bc6\u522bmodel\u7684\u4fe1\u606f " + object);
                        LiveEventBus.get((String)"com.lepu.ble.device.found.unregister").post(object);
                    }
                    return;
                }
                object3 = bluetooth;
                int n3 = object.getRssi();
                bluetooth = new Bluetooth(n2, string, bluetoothDevice, n3);
                if (((doac)object2).doaj() != null && !((doac)object2).doa((Bluetooth)object3)) {
                    doah.doah.doa(((doac)object2).doam(), "filterResult \u672a\u626b\u63cf\u5230\u6307\u5b9amodel\u7684\u8bbe\u5907");
                    return;
                }
                if (((doac)object2).dobg()) {
                    if (((doac)object2).dobf()) {
                        if (!((Bluetooth)object3).getName().equals(((doac)object2).doai())) {
                            doah.doah.doa(((doac)object2).doam(), "isScanDefineDevice \u672a\u626b\u63cf\u5230\u6307\u5b9a\u84dd\u7259\u540d\u7684\u8bbe\u5907");
                            return;
                        }
                        doah.doah.doa(((doac)object2).doam(), "b.name == " + ((Bluetooth)object3).getName());
                        doah.doah.doa(((doac)object2).doam(), "scanByName == " + ((doac)object2).doai());
                    } else {
                        if (!((Bluetooth)object3).getMacAddr().equals(((doac)object2).doah())) {
                            doah.doah.doa(((doac)object2).doam(), "isScanDefineDevice \u672a\u626b\u63cf\u5230\u6307\u5b9a\u84dd\u7259\u5730\u5740\u7684\u8bbe\u5907");
                            return;
                        }
                        doah.doah.doa(((doac)object2).doam(), "b.macAddr == " + ((Bluetooth)object3).getMacAddr());
                        doah.doah.doa(((doac)object2).doam(), "scanByAddress == " + ((doac)object2).doah());
                    }
                }
                if (((doac)object2).doad() && (bluetoothDevice = object.getScanRecord()) != null) {
                    HashMap<String, Object> hashMap;
                    object = hashMap;
                    new HashMap<String, Object>().put("com.lepu.ble.device.found.device", object3);
                    object.put("com.lepu.ble.device.found.scanResult", bluetoothDevice);
                    doah.doah.doa(((doac)object2).doam(), "post paring..." + ((Bluetooth)object3).getName());
                    LiveEventBus.get((String)"com.lepu.ble.device.found.scanResult").post(object);
                }
                if (BluetoothController.addDevice((Bluetooth)object3)) {
                    doah.doah.doa(((doac)object2).doam(), "model = " + ((Bluetooth)object3).getModel() + ", isReconnectScan::" + ((doac)object2).dobe() + ", b= " + ((Bluetooth)object3).getName() + ", recName = " + CollectionsKt.joinToString$default((Iterable)((doac)object2).doag(), null, null, null, (int)0, null, null, (int)63, null) + ", toConnectUpdater = " + ((doac)object2).doan() + ",  isReconnectByAddress = " + ((doac)object2).dobd() + " ,  recAddress:" + CollectionsKt.joinToString$default((Iterable)((doac)object2).doaf(), null, null, null, (int)0, null, null, (int)63, null));
                    LiveEventBus.get((String)"com.lepu.ble.device.found").post(object3);
                    boolean bl = ((doac)object2).dobd() ? ((doac)object2).doaf().contains(((Bluetooth)object3).getDevice().getAddress()) : ((doac)object2).doag().contains(((Bluetooth)object3).getName());
                    if (((doac)object2).dobe() && bl) {
                        ((doac)object2).dobj();
                        if (n2 != 18 && n2 != 44 && n2 != 71 && n2 != 78) {
                            doa doa2 = (doa)((doac)object2).dob().get(((Bluetooth)object3).getModel());
                            if (doa2 != null) {
                                doa doa3 = doa2;
                                doa2 = ((doac)object2).doa();
                                Intrinsics.checkNotNull((Object)doa2);
                                object = ((Bluetooth)object3).getDevice();
                                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getDevice(...)");
                                boolean bl2 = ((doac)object2).doan();
                                doa3.doa((Context)doa2, (BluetoothDevice)object, true, bl2);
                            }
                            doah.doah.doa(((doac)object2).doam(), "\u53d1\u73b0\u9700\u8981\u91cd\u8fde\u7684\u8bbe\u5907....\u53bb\u8fde\u63a5 model = " + ((Bluetooth)object3).getModel() + " name = " + ((Bluetooth)object3).getName() + "  address = " + ((Bluetooth)object3).getMacAddr());
                        } else {
                            Function2 function2;
                            object2 = function2;
                            function2 = new Function2((Bluetooth)object3, null){
                                int doa;
                                final /* synthetic */ Bluetooth doab;
                                {
                                    this.doab = bluetooth;
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
                                        if (DelayKt.delay((long)2000L, (Continuation)this) == object2) {
                                            return object2;
                                        }
                                    }
                                    object = doa;
                                    object2 = (doa)((doac)object).dob().get(this.doab.getModel());
                                    if (object2 != null) {
                                        Object object3 = object2;
                                        object2 = ((doac)object).doa();
                                        Intrinsics.checkNotNull((Object)object2);
                                        BluetoothDevice bluetoothDevice = this.doab.getDevice();
                                        Intrinsics.checkNotNullExpressionValue((Object)bluetoothDevice, (String)"getDevice(...)");
                                        boolean bl = ((doac)object).doan();
                                        ((doa)object3).doa((Context)object2, bluetoothDevice, true, bl);
                                    }
                                    doah.doah.doa(((doac)object).doam(), "\u53d1\u73b0\u9700\u8981\u91cd\u8fde\u7684\u8bbe\u5907....\u53bb\u8fde\u63a5 model = " + this.doab.getModel() + " name = " + this.doab.getName() + "  address = " + this.doab.getMacAddr());
                                    return Unit.INSTANCE;
                                }

                                public final Continuation create(Object object, Continuation continuation) {
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public final Object doa(CoroutineScope coroutineScope, Continuation continuation) {
                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            };
                            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)object2, (int)3, null);
                        }
                    }
                }
            }

            public void onBatchScanResults(List list) {
                Intrinsics.checkNotNullParameter((Object)list, (String)"results");
            }

            public void onScanFailed(int n) {
                doac doac2 = doa;
                doah.doah.doab(doac2.doam(), "scan error: " + n);
                LiveEventBus.get((String)"com.lepu.ble.device.found.error").post((Object)n);
                if (n == 1) {
                    doah.doah.doab(doac2.doam(), "Fails to start scan as BLE scan with the same settings is already started by the app.");
                }
                if (n == 2) {
                    doah.doah.doab(doac2.doam(), "Fails to start scan as app cannot be registered.");
                }
                if (n == 3) {
                    doah.doah.doab(doac2.doam(), "Fails to start scan due an internal error");
                }
                if (n == 4) {
                    doah.doah.doab(doac2.doam(), "Fails to start power optimized scan as this feature is not supported.");
                }
                if (n == 5) {
                    doah.doah.doab(doac2.doam(), "Fails to start scan as it is out of hardware resources.");
                }
                if (n == 6) {
                    doah.doah.doab(doac2.doam(), "Fails to start scan as application tries to scan too frequently.");
                }
            }
        };
    }

    public final String doam() {
        return doab;
    }

    public final Application doa() {
        return doac;
    }

    public final void doa(Application application) {
        doac = application;
    }

    public final SparseArray dob() {
        return doad;
    }

    public final int[] doaj() {
        return doaf;
    }

    public final boolean dobg() {
        return doag;
    }

    public final boolean dobf() {
        return doah;
    }

    public final String doai() {
        return doai;
    }

    public final String doah() {
        return doaj;
    }

    public final boolean doad() {
        return doak;
    }

    public final void doac(boolean bl) {
        doak = bl;
    }

    public final boolean doac() {
        return doal;
    }

    public final void doab(boolean bl) {
        doal = bl;
    }

    public final String doab() {
        return doam;
    }

    public final void doa(String string) {
        String string2 = string;
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<set-?>");
        doam = string2;
    }

    public final boolean dobe() {
        return doan;
    }

    public final ArrayList doag() {
        return dob;
    }

    public final ArrayList doaf() {
        return doba;
    }

    public final boolean dobd() {
        return dobc;
    }

    public final boolean doan() {
        return dobd;
    }

    public final boolean doal() {
        return dobe;
    }

    public final int doae() {
        return dobf;
    }

    public final void doa(int n) {
        dobf = n;
    }

    public final boolean dobh() {
        return dobg;
    }

    public final void doad(boolean bl) {
        dobg = bl;
    }

    public final CountDownTimer doak() {
        return dobh;
    }

    public final void dobi() {
        this.doba();
        doah.doah.doa(doab, "reInitBle");
    }

    public final doa doa(int n, boolean bl) {
        doem doem2;
        doah.doah.doa(doab, "initInterfaces start..." + doad.size() + ',' + n);
        Object object = (doa)doad.get(n);
        if (object != null) {
            return object;
        }
        switch (n) {
            default: {
                return null;
            }
            case 179: {
                doad doad2;
                object = doad2;
                doad2 = new doad(n);
                doad.put(n, object);
                return doad2;
            }
            case 173: {
                dobn dobn2;
                object = dobn2;
                dobn2 = new dobn(n);
                doad.put(n, object);
                return dobn2;
            }
            case 172: {
                doab.doac doac2;
                object = doac2;
                doac2 = new doab.doac(n);
                doad.put(n, object);
                return doac2;
            }
            case 161: {
                dobk dobk2;
                object = dobk2;
                new dobk(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 154: {
                doei doei2;
                object = doei2;
                doei2 = new doei(n);
                doad.put(n, object);
                return doei2;
            }
            case 153: {
                doae doae2;
                object = doae2;
                doae2 = new doae(n);
                doad.put(n, object);
                return doae2;
            }
            case 143: 
            case 185: {
                doaj doaj2;
                object = doaj2;
                doaj2 = new doaj(n);
                doad.put(n, object);
                return doaj2;
            }
            case 125: 
            case 131: 
            case 132: 
            case 142: 
            case 167: 
            case 188: 
            case 189: {
                dogf dogf2;
                object = dogf2;
                dogf2 = new dogf(n);
                doad.put(n, object);
                return dogf2;
            }
            case 124: 
            case 144: 
            case 175: 
            case 180: {
                dofa dofa2;
                object = dofa2;
                dofa2 = new dofa(n);
                doad.put(n, object);
                return dofa2;
            }
            case 123: 
            case 126: 
            case 133: 
            case 134: 
            case 181: {
                dofn dofn2;
                object = dofn2;
                new dofn(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 118: 
            case 119: 
            case 135: 
            case 136: 
            case 137: 
            case 155: 
            case 156: 
            case 157: 
            case 158: 
            case 159: 
            case 164: {
                doba doba2;
                object = doba2;
                doba2 = new doba(n);
                doad.put(n, object);
                return doba2;
            }
            case 110: {
                doc doc2;
                object = doc2;
                doc2 = new doc(n);
                doad.put(n, object);
                return doc2;
            }
            case 107: 
            case 108: 
            case 115: 
            case 116: 
            case 117: {
                dogj dogj2;
                object = dogj2;
                dogj2 = new dogj(n);
                doad.put(n, object);
                return dogj2;
            }
            case 105: {
                dobh dobh2;
                object = dobh2;
                dobh2 = new dobh(n);
                doad.put(n, object);
                return dobh2;
            }
            case 103: {
                dogl dogl2;
                object = dogl2;
                dogl2 = new dogl(n);
                doad.put(n, object);
                return dogl2;
            }
            case 96: 
            case 151: {
                doed doed2;
                object = doed2;
                new doed(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 95: 
            case 152: 
            case 176: {
                docg docg2;
                object = docg2;
                new docg(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 91: {
                dobi dobi2;
                object = dobi2;
                new dobi(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 82: {
                doak doak2;
                object = doak2;
                new doak(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 79: {
                doga doga2;
                object = doga2;
                new doga(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 78: {
                doej doej2;
                object = doej2;
                new doej(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 59: {
                doea doea2;
                object = doea2;
                new doea(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 56: 
            case 183: {
                dobj dobj2;
                object = dobj2;
                new dobj(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 55: 
            case 94: 
            case 104: 
            case 111: 
            case 122: 
            case 128: 
            case 186: 
            case 187: 
            case 191: {
                dofe dofe2;
                object = dofe2;
                new dofe(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 54: {
                dofi dofi2;
                object = dofi2;
                new dofi(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 52: 
            case 177: 
            case 178: {
                doeh doeh2;
                object = doeh2;
                new doeh(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 51: 
            case 93: 
            case 99: {
                dogd dogd2;
                object = dogd2;
                new dogd(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 49: 
            case 169: {
                docn docn2;
                object = docn2;
                docn2 = new docn(n);
                doad.put(n, object);
                return docn2;
            }
            case 47: 
            case 53: 
            case 106: 
            case 121: 
            case 129: {
                doch doch2;
                object = doch2;
                new doch(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 46: {
                dobf dobf2;
                object = dobf2;
                new dobf(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 45: 
            case 61: {
                dogk dogk2;
                object = dogk2;
                new dogk(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 44: 
            case 71: {
                doef doef2;
                object = doef2;
                new doef(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 43: 
            case 92: 
            case 102: {
                dofl dofl2;
                object = dofl2;
                new dofl(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 41: 
            case 100: {
                doab.doah doah2;
                object = doah2;
                new doab.doah(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 40: 
            case 62: {
                docj docj2;
                object = docj2;
                new docj(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 32: {
                dob dob2;
                object = dob2;
                new dob(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 28: {
                docl docl2;
                object = docl2;
                new docl(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 27: {
                doeb doeb2;
                object = doeb2;
                new doeb(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 26: {
                dobd dobd2;
                object = dobd2;
                new dobd(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 22: 
            case 114: {
                dobl dobl2;
                object = dobl2;
                new dobl(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 21: {
                dogi dogi2;
                object = dogi2;
                new dogi(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 19: 
            case 23: 
            case 31: 
            case 138: 
            case 192: {
                doam doam2;
                object = doam2;
                new doam(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 18: {
                doaf doaf2;
                object = doaf2;
                new doaf(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 17: {
                dofc dofc2;
                object = dofc2;
                new dofc(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 15: {
                dogm dogm2;
                object = dogm2;
                new dogm(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 14: 
            case 30: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 42: 
            case 57: 
            case 58: 
            case 60: 
            case 70: 
            case 80: 
            case 81: 
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 97: 
            case 98: 
            case 109: 
            case 139: 
            case 140: 
            case 141: 
            case 150: 
            case 162: 
            case 190: 
            case 215: {
                dofg dofg2;
                object = dofg2;
                new dofg(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 12: 
            case 50: {
                doab.doa doa2;
                object = doa2;
                new doab.doa(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 9: 
            case 76: {
                dogc dogc2;
                object = dogc2;
                new dogc(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 8: 
            case 33: 
            case 74: 
            case 75: 
            case 77: 
            case 149: 
            case 165: 
            case 168: {
                doce doce2;
                object = doce2;
                new doce(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 7: 
            case 16: 
            case 34: 
            case 73: 
            case 127: 
            case 145: 
            case 146: 
            case 147: 
            case 148: 
            case 184: {
                docb docb2;
                object = docb2;
                new docb(n).doae(bl);
                doad.put(n, object);
                return object;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 10: 
            case 11: 
            case 13: 
            case 20: 
            case 25: 
            case 29: 
            case 48: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 69: 
            case 72: 
            case 101: 
            case 112: 
            case 113: 
            case 120: 
            case 130: 
            case 170: 
            case 171: 
            case 174: 
            case 182: 
            case 193: 
            case 197: 
            case 199: 
            case 203: 
            case 213: 
            case 217: 
        }
        object = doem2;
        new doem(n).doae(bl);
        doad.put(n, object);
        return object;
    }

    public final void doa(boolean bl, boolean bl2, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"defineDevice");
        doah.doah.doa(doab, "setScanDefineDevice isScanDefineDevice:" + bl + ", isScanByName:" + bl2 + ", defineDevice:" + string);
        doag = bl;
        doah = bl2;
        if (bl) {
            if (bl2) {
                doai = string;
            } else {
                doaj = string;
            }
        } else {
            doai = "";
            doaj = "";
        }
    }

    public final void doa(int[] object, boolean bl, boolean bl2) {
        Function2 function2;
        doac doac2 = string;
        String string = doab;
        doah.doah.doa(string, "start discover.....vailFace.size = " + doad.size() + ", needPair = " + bl + ", isReconnectScan = " + bl2);
        doac2.dobj();
        if (doad.size() == 0 && bl2) {
            doah.doah.doa(string, "startDiscover vailFace.isEmpty(), isReconnectScan:" + bl2);
            return;
        }
        BluetoothController.clear();
        doak = bl;
        doaf = object;
        doan = bl2;
        Object object2 = dobi;
        if (object2 != null) {
            Job.DefaultImpls.cancel$default((Job)object2, null, (int)1, null);
        }
        object2 = function2;
        function2 = new Function2(null){
            int doa;

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
                    if (DelayKt.delay((long)1000L, (Continuation)this) == object2) {
                        return object2;
                    }
                }
                doa.doa(true);
                return Unit.INSTANCE;
            }

            public final Continuation create(Object object, Continuation continuation) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object doa(CoroutineScope coroutineScope, Continuation continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        };
        dobi = BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)object2, (int)3, null);
        object2 = new StringBuilder().append("startScan...., scanModel:");
        object = object != null ? (Object)ArraysKt.joinToString$default((int[])object, null, null, null, (int)0, null, null, (int)63, null) : null;
        doah.doah.doa(string, ((StringBuilder)object2).append((String)object).append(", needPair:").append(bl).toString());
    }

    public final void dobj() {
        doah.doah.doa(doab, "stopDiscover...");
        Job job = dobi;
        if (job != null) {
            Job.DefaultImpls.cancel$default((Job)job, null, (int)1, null);
        }
        this.doa(false);
    }

    public final void doa(int[] object, String[] stringArray, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"reconnectDeviceName");
        if (doad.size() == 0) {
            doah.doah.doa(doab, "reconnect vailFace.isEmpty()");
            return;
        }
        boolean bl3 = false;
        if (BleServiceHelper.Companion.getBleServiceHelper().hasUnConnected()) {
            doah.doah.doa(doab, "reconnectByName \u6709\u672a\u8fde\u63a5\u7684\u8bbe\u5907....");
            bl3 = true;
        }
        if (bl3) {
            dob.addAll(ArraysKt.asList((Object[])stringArray));
            dobc = false;
            dobd = bl2;
            doak = bl;
            ((doac)((Object)string)).doa(false, false, "");
            ((doac)((Object)string)).doa((int[])object, bl, true);
        }
        String string = doab;
        StringBuilder stringBuilder = new StringBuilder().append("reconnect: scanModel=> ");
        object = object != null ? (Object)ArraysKt.joinToString$default((int[])object, null, null, null, (int)0, null, null, (int)63, null) : null;
        doah.doah.doa(string, stringBuilder.append((String)object).append(" reconnectDeviceName=> ").append(ArraysKt.joinToString$default((Object[])stringArray, null, null, null, (int)0, null, null, (int)63, null)).append(" ReScan: ").append(bl3).toString());
    }

    public final void doab(int[] nArray, String[] stringArray, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"reconnectDeviceAddress");
        if (doad.size() == 0) {
            doah.doah.doa(doab, "reconnectByAddress vailFace.isEmpty()");
            return;
        }
        boolean bl3 = false;
        if (BleServiceHelper.Companion.getBleServiceHelper().hasUnConnected()) {
            doah.doah.doa(doab, "reconnectByAddress \u6709\u672a\u8fde\u63a5\u7684\u8bbe\u5907");
            bl3 = true;
        }
        if (bl3) {
            doba.addAll(ArraysKt.toList((Object[])stringArray));
            dobc = true;
            doak = bl;
            dobd = bl2;
            this.doa(false, false, "");
            doa.doac.doa(this, nArray, false, true, 2, null);
        }
        doah.doah.doa(doab, "reconnectByAddress: => " + ArraysKt.joinToString$default((Object[])stringArray, null, null, null, (int)0, null, null, (int)63, null) + " => ReScan: " + bl3);
    }

    public final boolean dobc() {
        return dobj;
    }
}
