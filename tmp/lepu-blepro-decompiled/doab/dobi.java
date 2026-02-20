/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 *  android.os.CountDownTimer
 *  com.jeremyliao.liveeventbus.LiveEventBus
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package doab;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.CountDownTimer;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lepu.blepro.event.InterfaceEvent;
import com.lepu.blepro.ext.checkme.BpRecord;
import com.lepu.blepro.ext.checkme.CheckmeEcgDiagnosis;
import com.lepu.blepro.ext.checkme.DeviceInfo;
import com.lepu.blepro.ext.checkme.DlcRecord;
import com.lepu.blepro.ext.checkme.EcgFile;
import com.lepu.blepro.ext.checkme.EcgRecord;
import com.lepu.blepro.ext.checkme.GluRecord;
import com.lepu.blepro.ext.checkme.OxyRecord;
import com.lepu.blepro.ext.checkme.PedRecord;
import com.lepu.blepro.ext.checkme.RtData;
import com.lepu.blepro.ext.checkme.SlmFile;
import com.lepu.blepro.ext.checkme.SlmRecord;
import com.lepu.blepro.ext.checkme.TempRecord;
import com.lepu.blepro.ext.checkme.UserInfo;
import doab.doen;
import doac.dobm;
import doac.doeb;
import doac.doec;
import doac.doed;
import doac.doef;
import doac.doeg;
import doac.doeh;
import doac.doei;
import doac.doej;
import doac.doek;
import doac.doel;
import doac.doem;
import doac.dof;
import doac.dofa;
import doac.dofb;
import doac.dofc;
import doac.dofd;
import doac.dofe;
import doac.dofg;
import doac.dofh;
import doac.dofi;
import doac.dofj;
import doac.dofk;
import doac.dofl;
import doac.dofm;
import doac.dofn;
import doac.y;
import doag.doa;
import doah.doah;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class dobi
extends doa.doa {
    private final String doc;
    private int doca;
    private String docb = "";
    private String docd = "";
    private byte[] doce = new byte[0];
    private int docf = 1;
    private int docg = -1;
    private int doch;
    private final DeviceInfo doci = new DeviceInfo();
    private final RtData docj = new RtData();
    private final EcgFile dock = new EcgFile();
    private final SlmFile docl = new SlmFile();
    private CountDownTimer docm = new CountDownTimer(){

        public void onTick(long l) {
            doah.doah.doa(doc, "-------cmdTimer-onTick------");
        }

        public void onFinish() {
            doa doa2 = this;
            LiveEventBus.get((String)"com.lepu.ble.cmd.response.timeout").post((Object)this.doai());
            doa2.this.doab(-1);
            doah.doah.doa(doc, "-------cmdTimer-onFinish------");
        }
    };

    public dobi(int n) {
        super(n);
        this.doc = "CheckmeBleInterface";
    }

    private final void doae(int n) {
        block12: {
            byte[] byArray;
            block5: {
                block11: {
                    block10: {
                        block9: {
                            block8: {
                                block7: {
                                    block6: {
                                        block4: {
                                            dobi dobi2 = this;
                                            doah.doah.doa(dobi2.doc, "sendOxyCmd " + n);
                                            if (dobi2.doai() != -1) {
                                                doah.doah.doa(this.doc, "busy: " + n + "$curCmd =>" + String.valueOf(this.doai()));
                                                return;
                                            }
                                            if (n != doeb.doad) break block4;
                                            byArray = doeb.doag();
                                            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readListStart(...)");
                                            break block5;
                                        }
                                        if (n != doeb.doae) break block6;
                                        byArray = doeb.doae();
                                        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readListContent(...)");
                                        break block5;
                                    }
                                    if (n != doeb.doaf) break block7;
                                    byArray = doeb.doaf();
                                    Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readListEnd(...)");
                                    break block5;
                                }
                                if (n != doeb.doac) break block8;
                                byArray = doeb.doad();
                                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileEnd(...)");
                                break block5;
                            }
                            if (n != doeb.doab) break block9;
                            byArray = doeb.doac();
                            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileContent(...)");
                            break block5;
                        }
                        if (n != doeb.doai) break block10;
                        byArray = doeb.doah();
                        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"syncTime(...)");
                        break block5;
                    }
                    if (n != doeb.doag) break block11;
                    byArray = doeb.doa();
                    Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getInfo(...)");
                    break block5;
                }
                if (n != doeb.doah) break block12;
                byArray = doeb.doab();
                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"ping(...)");
            }
            dobi dobi3 = this;
            this.doab(byArray);
            dobi3.doab(n);
            dobi3.docm.start();
            return;
        }
    }

    private final void doa(doec object) {
        doah.doah.doa(this.doc, "onResponseReceived curCmd: " + this.doai() + ", bytes: " + doah.doa.doa(((doec)object).doa()));
        if (((doec)object).doac() == 85) {
            if (this.doai() == -1) {
                doah.doah.doa(this.doc, "onResponseReceived curCmd:" + this.doai());
                return;
            }
            int n = this.doai();
            if (n == doeb.doah) {
                this.docg();
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", OXY_CMD_PING => success");
                this.docf();
            } else if (n == doeb.doai) {
                this.docg();
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", OXY_CMD_PARA_SYNC => success");
                LiveEventBus.get((String)"com.lepu.ble.checkme.set.time").post((Object)new InterfaceEvent(this.dobd(), Boolean.TRUE));
            } else if (n == doeb.doag) {
                doeg doeg2;
                this.docg();
                doeg doeg3 = doeg2;
                doeg2 = new doeg(((doec)object).doab());
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", OXY_CMD_INFO => success " + doeg3);
                this.doci.setRegion(doeg3.doah());
                this.doci.setModel(doeg3.doag());
                this.doci.setHwVersion(doeg3.doae());
                this.doci.setSwVersion(doeg3.doak());
                this.doci.setLgVersion(doeg3.doaf());
                this.doci.setCurLanguage(doeg3.doac());
                this.doci.setSn(doeg3.doai());
                this.doci.setFileVer(doeg3.doad());
                this.doci.setSpcpVer(doeg3.doaj());
                this.doci.setBranchCode(doeg3.doab());
                this.doci.setApplication(doeg3.doa());
                LiveEventBus.get((String)"com.lepu.ble.checkme.device.info").post((Object)new InterfaceEvent(this.dobd(), this.doci));
            } else if (n == doeb.doa) {
                this.docg();
                if (((doec)object).doae()) {
                    this.doca = doah.doa.doah(((doec)object).doab());
                    object = doag.doa.doa;
                    Object object2 = ((doa.doa)object).doa(this.dobd(), this.docb, this.docd);
                    if (this.dobe() == 0) {
                        int n2 = this.dobd();
                        object2 = this.docd;
                        ((doa.doa)object).doa(n2, this.docb, (String)object2, "dat");
                        object2 = new byte[]{};
                    } else if (((byte[])object2).length == 0 || ((byte[])object2).length != this.doca) {
                        int n3 = this.dobd();
                        object2 = this.docd;
                        ((doa.doa)object).doa(n3, "", (String)object2, "dat");
                        object2 = new byte[]{};
                    }
                    this.doce = object2;
                    this.doac(((byte[])object2).length);
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ", \u6587\u4ef6\u5927\u5c0f\uff1a" + this.doca + "  \u6587\u4ef6\u540d\uff1a" + this.docd);
                    if (this.doca > 0 && this.dobe() < this.doca) {
                        this.doae(doeb.doab);
                    } else {
                        this.doae(doeb.doac);
                    }
                } else {
                    if (StringsKt.contains$default((CharSequence)this.docd, (CharSequence)".dat", (boolean)false, (int)2, null)) {
                        LiveEventBus.get((String)"com.lepu.ble.checkme.get.file.list.error").post((Object)new InterfaceEvent(this.dobd(), this.docg));
                    } else {
                        LiveEventBus.get((String)"com.lepu.ble.checkme.read.file.error").post((Object)new InterfaceEvent(this.dobd(), this.doch));
                    }
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ", \u8bfb\u6587\u4ef6\u5931\u8d25\uff1a" + doah.doa.doab(((doec)object).doab()));
                }
            } else if (n == doeb.doab) {
                this.docg();
                this.doce = doah.doa.doa(this.doce, ((doec)object).doab());
                this.doac(this.dobe() + ((doec)object).doad());
                if (StringsKt.contains$default((CharSequence)this.docd, (CharSequence)".dat", (boolean)false, (int)2, null)) {
                    LiveEventBus.get((String)"com.lepu.ble.checkme.get.file.list.progress").post((Object)new InterfaceEvent(this.dobd(), this.dobe() * 100 / this.doca));
                } else {
                    int n4 = this.dobd();
                    String string = this.docb;
                    String string2 = this.docd;
                    byte[] byArray = ((doec)object).doab();
                    doag.doa.doa.doa(n4, string, string2, "dat", byArray);
                    LiveEventBus.get((String)"com.lepu.ble.checkme.reading.file.progress").post((Object)new InterfaceEvent(this.dobd(), this.dobe() * 100 / this.doca));
                }
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", \u8bfb\u6587\u4ef6\u4e2d\uff1a" + this.docd + "   => " + this.dobe() + " / " + this.doca + ' ' + this.dobe() * 100 / this.doca);
                if (this.dobe() < this.doca) {
                    this.doae(doeb.doab);
                } else {
                    this.doae(doeb.doac);
                }
            } else if (n == doeb.doac) {
                this.docg();
                doah.doah.doa(this.doc, "model:" + this.dobd() + ", \u8bfb\u6587\u4ef6\u5b8c\u6210: " + this.docd + " ==> " + this.doca);
                if (this.doca > 0 && this.dobe() == this.doca) {
                    if (StringsKt.contains$default((CharSequence)this.docd, (CharSequence)".dat", (boolean)false, (int)2, null)) {
                        dofa dofa2;
                        object = this.docd;
                        if (Intrinsics.areEqual((Object)object, (Object)"ecg.dat")) {
                            ArrayList<EcgRecord> arrayList;
                            doek doek2;
                            this.docg = 1;
                            object = doek2;
                            ArrayList<EcgRecord> arrayList2 = arrayList;
                            arrayList = new ArrayList<EcgRecord>();
                            int n5 = new doek(this.doce).doab();
                            for (int i = 0; i < n5; ++i) {
                                EcgRecord ecgRecord;
                                EcgRecord ecgRecord2 = ecgRecord;
                                ecgRecord2();
                                ecgRecord2.setTimestamp(((doel)((doek)object).doa().get(i)).doaj());
                                ecgRecord2.setRecordName(((doel)((doek)object).doa().get(i)).doag());
                                ecgRecord2.setYear(((doel)((doek)object).doa().get(i)).doal());
                                ecgRecord2.setMonth(((doel)((doek)object).doa().get(i)).doaf());
                                ecgRecord2.setDay(((doel)((doek)object).doa().get(i)).doa());
                                ecgRecord2.setHour(((doel)((doek)object).doa().get(i)).doab());
                                ecgRecord2.setMinute(((doel)((doek)object).doa().get(i)).doae());
                                ecgRecord2.setSecond(((doel)((doek)object).doa().get(i)).doai());
                                ecgRecord2.setMeasureMode(((doel)((doek)object).doa().get(i)).doac());
                                ecgRecord2.setMeasureModeMess(((doel)((doek)object).doa().get(i)).doad());
                                ecgRecord2.setResult(((doel)((doek)object).doa().get(i)).doah());
                                ecgRecord.setVoice(((doel)((doek)object).doa().get(i)).doak());
                                arrayList2.add(ecgRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.ecg.list").post((Object)new InterfaceEvent(this.dobd(), arrayList2));
                        } else if (Intrinsics.areEqual((Object)object, (Object)"oxi.dat")) {
                            ArrayList<OxyRecord> arrayList;
                            dofb dofb2;
                            this.docg = 2;
                            object = dofb2;
                            ArrayList<OxyRecord> arrayList3 = arrayList;
                            arrayList = new ArrayList<OxyRecord>();
                            int n6 = new dofb(this.doce).doab();
                            for (int i = 0; i < n6; ++i) {
                                OxyRecord oxyRecord;
                                OxyRecord oxyRecord2 = oxyRecord;
                                oxyRecord2();
                                oxyRecord2.setTimestamp(((dofc)((dofb)object).doa().get(i)).doam());
                                oxyRecord2.setRecordName(((dofc)((dofb)object).doa().get(i)).doai());
                                oxyRecord2.setYear(((dofc)((dofb)object).doa().get(i)).doan());
                                oxyRecord2.setMonth(((dofc)((dofb)object).doa().get(i)).doaf());
                                oxyRecord2.setDay(((dofc)((dofb)object).doa().get(i)).doa());
                                oxyRecord2.setHour(((dofc)((dofb)object).doa().get(i)).doab());
                                oxyRecord2.setMinute(((dofc)((dofb)object).doa().get(i)).doae());
                                oxyRecord2.setSecond(((dofc)((dofb)object).doa().get(i)).doak());
                                oxyRecord2.setMeasureMode(((dofc)((dofb)object).doa().get(i)).doac());
                                oxyRecord2.setMeasureModeMess(((dofc)((dofb)object).doa().get(i)).doad());
                                oxyRecord2.setSpo2(((dofc)((dofb)object).doa().get(i)).doal());
                                oxyRecord2.setPr(((dofc)((dofb)object).doa().get(i)).doah());
                                oxyRecord2.setPi(((dofc)((dofb)object).doa().get(i)).doag());
                                oxyRecord.setResult(((dofc)((dofb)object).doa().get(i)).doaj());
                                arrayList3.add(oxyRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.oxy.list").post((Object)new InterfaceEvent(this.dobd(), arrayList3));
                        } else if (Intrinsics.areEqual((Object)object, (Object)"tmp.dat")) {
                            ArrayList<TempRecord> arrayList;
                            dofk dofk2;
                            this.docg = 5;
                            object = dofk2;
                            ArrayList<TempRecord> arrayList4 = arrayList;
                            arrayList = new ArrayList<TempRecord>();
                            int n7 = new dofk(this.doce).doab();
                            for (int i = 0; i < n7; ++i) {
                                TempRecord tempRecord;
                                TempRecord tempRecord2 = tempRecord;
                                tempRecord2();
                                tempRecord2.setTimestamp(((dofl)((dofk)object).doa().get(i)).doaj());
                                tempRecord2.setRecordName(((dofl)((dofk)object).doa().get(i)).doaf());
                                tempRecord2.setYear(((dofl)((dofk)object).doa().get(i)).doak());
                                tempRecord2.setMonth(((dofl)((dofk)object).doa().get(i)).doae());
                                tempRecord2.setDay(((dofl)((dofk)object).doa().get(i)).doa());
                                tempRecord2.setHour(((dofl)((dofk)object).doa().get(i)).doab());
                                tempRecord2.setMinute(((dofl)((dofk)object).doa().get(i)).doad());
                                tempRecord2.setSecond(((dofl)((dofk)object).doa().get(i)).doah());
                                tempRecord2.setMeasureMode(((dofl)((dofk)object).doa().get(i)).doac());
                                tempRecord2.setTemp(((dofl)((dofk)object).doa().get(i)).doai());
                                tempRecord.setResult(((dofl)((dofk)object).doa().get(i)).doag());
                                arrayList4.add(tempRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.temp.list").post((Object)new InterfaceEvent(this.dobd(), arrayList4));
                        } else if (Intrinsics.areEqual((Object)object, (Object)"usr.dat")) {
                            ArrayList<UserInfo> arrayList;
                            dofn dofn2;
                            this.docg = 8;
                            object = dofn2;
                            ArrayList<UserInfo> arrayList5 = arrayList;
                            arrayList = new ArrayList<UserInfo>();
                            int n8 = new dofn(this.doce).doab();
                            for (int i = 0; i < n8; ++i) {
                                UserInfo userInfo;
                                UserInfo userInfo2 = userInfo;
                                userInfo2();
                                userInfo2.setId(((dofm)((dofn)object).doa().get(i)).doad());
                                userInfo2.setName(((dofm)((dofn)object).doa().get(i)).doaf());
                                userInfo2.setIcon(((dofm)((dofn)object).doa().get(i)).doac());
                                userInfo2.setSex(((dofm)((dofn)object).doa().get(i)).doag());
                                userInfo2.setYear(((dofm)((dofn)object).doa().get(i)).doai());
                                userInfo2.setMonth(((dofm)((dofn)object).doa().get(i)).doae());
                                userInfo2.setDay(((dofm)((dofn)object).doa().get(i)).doa());
                                userInfo2.setWeight(((dofm)((dofn)object).doa().get(i)).doah());
                                userInfo.setHeight(((dofm)((dofn)object).doa().get(i)).doab());
                                arrayList5.add(userInfo);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.user.list").post((Object)new InterfaceEvent(this.dobd(), arrayList5));
                        } else if (Intrinsics.areEqual((Object)object, (Object)"slm.dat")) {
                            ArrayList<SlmRecord> arrayList;
                            dofi dofi2;
                            this.docg = 6;
                            object = dofi2;
                            ArrayList<SlmRecord> arrayList6 = arrayList;
                            arrayList = new ArrayList<SlmRecord>();
                            int n9 = new dofi(this.doce).doab();
                            for (int i = 0; i < n9; ++i) {
                                SlmRecord slmRecord;
                                SlmRecord slmRecord2 = slmRecord;
                                slmRecord2();
                                slmRecord2.setTimestamp(((dofj)((dofi)object).doa().get(i)).doam());
                                slmRecord2.setRecordName(((dofj)((dofi)object).doa().get(i)).doaj());
                                slmRecord2.setYear(((dofj)((dofi)object).doa().get(i)).doan());
                                slmRecord2.setMonth(((dofj)((dofi)object).doa().get(i)).doai());
                                slmRecord2.setDay(((dofj)((dofi)object).doa().get(i)).doab());
                                slmRecord2.setHour(((dofj)((dofi)object).doa().get(i)).doad());
                                slmRecord2.setMinute(((dofj)((dofi)object).doa().get(i)).doah());
                                slmRecord2.setSecond(((dofj)((dofi)object).doa().get(i)).doal());
                                slmRecord2.setDuration(((dofj)((dofi)object).doa().get(i)).doac());
                                slmRecord2.setLowSpo2Time(((dofj)((dofi)object).doa().get(i)).doag());
                                slmRecord2.setLowSpo2Count(((dofj)((dofi)object).doa().get(i)).doaf());
                                slmRecord2.setLowSpo2(((dofj)((dofi)object).doa().get(i)).doae());
                                slmRecord2.setAvgSpo2(((dofj)((dofi)object).doa().get(i)).doa());
                                slmRecord.setResult(((dofj)((dofi)object).doa().get(i)).doak());
                                arrayList6.add(slmRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.slm.list").post((Object)new InterfaceEvent(this.dobd(), arrayList6));
                        } else if (Intrinsics.areEqual((Object)object, (Object)(this.docf + "bpcal.dat"))) {
                            this.docg = 9;
                        } else if (Intrinsics.areEqual((Object)object, (Object)(this.docf + "nibp.dat"))) {
                            ArrayList<BpRecord> arrayList;
                            doed doed2;
                            this.docg = 3;
                            object = doed2;
                            ArrayList<BpRecord> arrayList7 = arrayList;
                            arrayList = new ArrayList<BpRecord>();
                            int n10 = new doed(this.doce).doab();
                            for (int i = 0; i < n10; ++i) {
                                BpRecord bpRecord;
                                BpRecord bpRecord2 = bpRecord;
                                bpRecord2();
                                bpRecord2.setTimestamp(((doef)((doed)object).doa().get(i)).doaj());
                                bpRecord2.setRecordName(((doef)((doed)object).doa().get(i)).doag());
                                bpRecord2.setYear(((doef)((doed)object).doa().get(i)).doak());
                                bpRecord2.setMonth(((doef)((doed)object).doa().get(i)).doae());
                                bpRecord2.setDay(((doef)((doed)object).doa().get(i)).doa());
                                bpRecord2.setHour(((doef)((doed)object).doa().get(i)).doac());
                                bpRecord2.setMinute(((doef)((doed)object).doa().get(i)).doad());
                                bpRecord2.setSecond(((doef)((doed)object).doa().get(i)).doah());
                                bpRecord2.setSys(((doef)((doed)object).doa().get(i)).doai());
                                bpRecord2.setDia(((doef)((doed)object).doa().get(i)).doab());
                                bpRecord.setPr(((doef)((doed)object).doa().get(i)).doaf());
                                arrayList7.add(bpRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.bp.list").post((Object)new InterfaceEvent(this.dobd(), arrayList7));
                        } else if (Intrinsics.areEqual((Object)object, (Object)(this.docf + "dlc.dat"))) {
                            ArrayList<DlcRecord> arrayList;
                            doeh doeh2;
                            this.docg = 0;
                            object = doeh2;
                            ArrayList<DlcRecord> arrayList8 = arrayList;
                            arrayList = new ArrayList<DlcRecord>();
                            int n11 = new doeh(this.doce).doab();
                            for (int i = 0; i < n11; ++i) {
                                DlcRecord dlcRecord;
                                DlcRecord dlcRecord2 = dlcRecord;
                                dlcRecord2();
                                dlcRecord2.setTimestamp(((doei)((doeh)object).doa().get(i)).doba());
                                dlcRecord2.setRecordName(((doei)((doeh)object).doa().get(i)).doak());
                                dlcRecord2.setYear(((doei)((doeh)object).doa().get(i)).dobd());
                                dlcRecord2.setMonth(((doei)((doeh)object).doa().get(i)).doai());
                                dlcRecord2.setDay(((doei)((doeh)object).doa().get(i)).doac());
                                dlcRecord2.setHour(((doei)((doeh)object).doa().get(i)).doaf());
                                dlcRecord2.setMinute(((doei)((doeh)object).doa().get(i)).doah());
                                dlcRecord2.setSecond(((doei)((doeh)object).doa().get(i)).doal());
                                dlcRecord2.setHr(((doei)((doeh)object).doa().get(i)).doag());
                                dlcRecord2.setEcgResult(((doei)((doeh)object).doa().get(i)).doae());
                                dlcRecord2.setSpo2(((doei)((doeh)object).doa().get(i)).doam());
                                dlcRecord2.setPi(((doei)((doeh)object).doa().get(i)).doaj());
                                dlcRecord2.setSpo2Result(((doei)((doeh)object).doa().get(i)).doan());
                                dlcRecord2.setBpi(((doei)((doeh)object).doa().get(i)).doa());
                                dlcRecord2.setDia(((doei)((doeh)object).doa().get(i)).doad());
                                dlcRecord2.setSys(((doei)((doeh)object).doa().get(i)).dob());
                                dlcRecord2.setBpiResult(((doei)((doeh)object).doa().get(i)).doab());
                                dlcRecord.setVoice(((doei)((doeh)object).doa().get(i)).dobc());
                                arrayList8.add(dlcRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.dlc.list").post((Object)new InterfaceEvent(this.dobd(), arrayList8));
                        } else if (Intrinsics.areEqual((Object)object, (Object)(this.docf + "ped.dat"))) {
                            ArrayList<PedRecord> arrayList;
                            dofd dofd2;
                            this.docg = 7;
                            object = dofd2;
                            ArrayList<PedRecord> arrayList9 = arrayList;
                            arrayList = new ArrayList<PedRecord>();
                            int n12 = new dofd(this.doce).doab();
                            for (int i = 0; i < n12; ++i) {
                                PedRecord pedRecord;
                                PedRecord pedRecord2 = pedRecord;
                                pedRecord2();
                                pedRecord2.setTimestamp(((dofe)((dofd)object).doa().get(i)).doam());
                                pedRecord2.setRecordName(((dofe)((dofd)object).doa().get(i)).doaj());
                                pedRecord2.setYear(((dofe)((dofd)object).doa().get(i)).doan());
                                pedRecord2.setMonth(((dofe)((dofd)object).doa().get(i)).doai());
                                pedRecord2.setDay(((dofe)((dofd)object).doa().get(i)).doac());
                                pedRecord2.setHour(((dofe)((dofd)object).doa().get(i)).doag());
                                pedRecord2.setMinute(((dofe)((dofd)object).doa().get(i)).doah());
                                pedRecord2.setSecond(((dofe)((dofd)object).doa().get(i)).doak());
                                pedRecord2.setStep(((dofe)((dofd)object).doa().get(i)).doal());
                                pedRecord2.setDistance(((dofe)((dofd)object).doa().get(i)).doad());
                                pedRecord2.setAvgSpeed(((dofe)((dofd)object).doa().get(i)).doa());
                                pedRecord2.setCalorie(((dofe)((dofd)object).doa().get(i)).doab());
                                pedRecord2.setFat(((dofe)((dofd)object).doa().get(i)).doaf());
                                pedRecord.setDuration(((dofe)((dofd)object).doa().get(i)).doae());
                                arrayList9.add(pedRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.ped.list").post((Object)new InterfaceEvent(this.dobd(), arrayList9));
                        } else if (Intrinsics.areEqual((Object)object, (Object)(this.docf + "glu.dat"))) {
                            ArrayList<GluRecord> arrayList;
                            doac.doen doen2;
                            this.docg = 4;
                            object = doen2;
                            ArrayList<GluRecord> arrayList10 = arrayList;
                            arrayList = new ArrayList<GluRecord>();
                            int n13 = new doac.doen(this.doce).doab();
                            for (int i = 0; i < n13; ++i) {
                                GluRecord gluRecord;
                                GluRecord gluRecord2 = gluRecord;
                                gluRecord2();
                                gluRecord2.setTimestamp(((dof)((doac.doen)object).doa().get(i)).doah());
                                gluRecord2.setRecordName(((dof)((doac.doen)object).doa().get(i)).doaf());
                                gluRecord2.setYear(((dof)((doac.doen)object).doa().get(i)).doai());
                                gluRecord2.setMonth(((dof)((doac.doen)object).doa().get(i)).doae());
                                gluRecord2.setDay(((dof)((doac.doen)object).doa().get(i)).doa());
                                gluRecord2.setHour(((dof)((doac.doen)object).doa().get(i)).doac());
                                gluRecord2.setMinute(((dof)((doac.doen)object).doa().get(i)).doad());
                                gluRecord2.setSecond(((dof)((doac.doen)object).doa().get(i)).doag());
                                gluRecord.setGlu(((dof)((doac.doen)object).doa().get(i)).doab());
                                arrayList10.add(gluRecord);
                            }
                            LiveEventBus.get((String)"com.lepu.ble.checkme.get.glu.list").post((Object)new InterfaceEvent(this.dobd(), arrayList10));
                        }
                        object = dofa2;
                        dofa2 = new dofa(this.docf, this.docg, this.doce);
                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", ListContent : " + object);
                    } else {
                        doem doem2;
                        object = doem2;
                        doem2 = new doem(this.docd, this.docf, this.doch, this.doce);
                        if (this.doch == 1) {
                            dofh dofh2;
                            dofh dofh3 = dofh2;
                            dofh2 = new dofh(this.doce);
                            this.docl.setPrs(CollectionsKt.toIntArray((Collection)dofh3.doa()));
                            this.docl.setSpo2s(CollectionsKt.toIntArray((Collection)dofh3.doab()));
                            LiveEventBus.get((String)"com.lepu.ble.checkme.read.slm.file.complete").post((Object)new InterfaceEvent(this.dobd(), this.docl));
                        } else {
                            CheckmeEcgDiagnosis checkmeEcgDiagnosis;
                            doej doej2 = new doej(this.doce);
                            this.dock.setHrsDataSize(doej2.doae());
                            this.dock.setRecordingTime(doej2.doam());
                            this.dock.setWaveDataSize(doej2.dobe());
                            this.dock.setHr(doej2.doac());
                            this.dock.setSt(doej2.dob());
                            this.dock.setQrs(doej2.doaj());
                            this.dock.setPvcs(doej2.doai());
                            this.dock.setQtc(doej2.doal());
                            this.dock.setResult(doej2.doan());
                            CheckmeEcgDiagnosis checkmeEcgDiagnosis2 = checkmeEcgDiagnosis;
                            new CheckmeEcgDiagnosis().setData(doej2.doa().doa());
                            checkmeEcgDiagnosis2.setRegular(doej2.doa().doak());
                            checkmeEcgDiagnosis2.setPoorSignal(doej2.doa().doai());
                            checkmeEcgDiagnosis2.setHighHr(doej2.doa().doac());
                            checkmeEcgDiagnosis2.setLowHr(doej2.doa().doag());
                            checkmeEcgDiagnosis2.setIrregular(doej2.doa().doaf());
                            checkmeEcgDiagnosis2.setHighQrs(doej2.doa().doad());
                            checkmeEcgDiagnosis2.setHighSt(doej2.doa().doae());
                            checkmeEcgDiagnosis2.setLowSt(doej2.doa().doah());
                            checkmeEcgDiagnosis2.setPrematureBeat(doej2.doa().doaj());
                            this.dock.setDiagnosis(checkmeEcgDiagnosis2);
                            this.dock.setMeasureMode(doej2.doag());
                            this.dock.setMeasureModeMess(doej2.doah());
                            this.dock.setFilterMode(doej2.doab());
                            this.dock.setQt(doej2.doak());
                            this.dock.setHrsData(doej2.doad());
                            this.dock.setHrsIntData(doej2.doaf());
                            this.dock.setWaveData(doej2.dobd());
                            this.dock.setWaveShortData(doej2.dobg());
                            this.dock.setWaveDecompress(doej2.dobf());
                            this.dock.setwFs(doej2.doba());
                            this.dock.setwFsDecompress(doej2.dobc());
                            LiveEventBus.get((String)"com.lepu.ble.checkme.read.ecg.file.complete").post((Object)new InterfaceEvent(this.dobd(), this.dock));
                        }
                        doah.doah.doa(this.doc, "model:" + this.dobd() + ", FileContent : " + object);
                    }
                } else {
                    if (StringsKt.contains$default((CharSequence)this.docd, (CharSequence)".dat", (boolean)false, (int)2, null)) {
                        LiveEventBus.get((String)"com.lepu.ble.checkme.get.file.list.error").post((Object)new InterfaceEvent(this.dobd(), this.docg));
                    } else {
                        LiveEventBus.get((String)"com.lepu.ble.checkme.read.file.error").post((Object)new InterfaceEvent(this.dobd(), this.doch));
                    }
                    doah.doah.doa(this.doc, "model:" + this.dobd() + ",  curFile error!!");
                }
            } else {
                this.docg();
            }
        } else {
            dofg dofg2;
            this.docg();
            dofg dofg3 = dofg2;
            dofg2 = new dofg(((doec)object).doab());
            this.docj.setEcgData(dofg3.doac());
            this.docj.setEcgShortData(dofg3.doae());
            this.docj.setEcgFloatData(dofg3.doad());
            this.docj.setHr(dofg3.doaf());
            this.docj.setQrs(dofg3.doal());
            this.docj.setSt(dofg3.dobc());
            this.docj.setPvcs(dofg3.doak());
            object = this.docj;
            boolean bl = dofg2.doag() == 1;
            ((RtData)object).setRWaveMark(bl);
            this.docj.setEcgNote(dofg3.doab());
            this.docj.setSpo2Data(dofg3.dob());
            this.docj.setSpo2IntData(dofg3.doba());
            this.docj.setPr(dofg3.doai());
            this.docj.setSpo2(dofg3.doam());
            this.docj.setPi(dofg3.doah());
            object = this.docj;
            bl = dofg3.doaj() == 1;
            ((RtData)object).setPulseMark(bl);
            this.docj.setSpo2Note(dofg3.doan());
            this.docj.setBattery(dofg3.doa());
            LiveEventBus.get((String)"com.lepu.ble.checkme.rt.data").post((Object)new InterfaceEvent(this.dobd(), this.docj));
            doah.doah.doa(this.doc, "model:" + this.dobd() + ", RtData : " + dofg3);
        }
    }

    private final void docg() {
        dobi dobi2 = this;
        dobi2.doab(-1);
        dobi2.docm.cancel();
    }

    private static final void doa(dobi dobi2, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter((Object)dobi2, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"it");
        doah.doah.doa(dobi2.doc, "manager.connect done");
    }

    @Override
    public void doa(Context context, BluetoothDevice bluetoothDevice, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)bluetoothDevice, (String)"device");
        if (this.dobn()) {
            if (this.dobc().getBluetoothDevice() == null) {
                dobi dobi2 = this;
                dobi2.doa(new doen(context));
                doah.doah.doa(dobi2.doc, "isManagerInitialized, manager.bluetoothDevice == null");
                doah.doah.doa(dobi2.doc, "isManagerInitialized, manager.create done");
            } else {
                doah.doah.doa(this.doc, "isManagerInitialized, manager.bluetoothDevice != null");
            }
        } else {
            dobi dobi3 = this;
            dobi3.doa(new doen(context));
            doah.doah.doa(dobi3.doc, "!isManagerInitialized, manager.create done");
        }
        dobi dobi4 = this;
        dobi4.dobc().doa(bl);
        dobi4.dobc().setConnectionObserver(this);
        dobi4.dobc().doa(this);
        dobi4.dobc().connect(bluetoothDevice).useAutoConnect(false).timeout(10000L).retry(3, 100).done(arg_0 -> dobi.doa(this, arg_0)).enqueue();
    }

    @Override
    public byte[] doa(byte[] byArray) {
        if (byArray != null && byArray.length >= 8) {
            int n = byArray.length - 7;
            for (int i = 0; i < n; ++i) {
                int n2 = byArray[i];
                if (n2 == 85 && byArray[i + 1] == (byte)(~byArray[i + 2])) {
                    y y2;
                    byte[] byArray2;
                    int n3 = i;
                    n2 = i + 7;
                    n2 = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)(n3 + 5), (int)n2));
                    if ((n2 = n3 + 8 + n2) > byArray.length || (byArray2 = ArraysKt.copyOfRange((byte[])byArray, (int)i, (int)n2)).length < 8) continue;
                    if (ArraysKt.last((byte[])byArray2) == dobm.doa(byArray2)) {
                        this.doa(new doec(byArray2));
                        if (n2 == byArray.length) {
                            byArray = null;
                        } else {
                            i = byArray.length;
                            byArray = ArraysKt.copyOfRange((byte[])byArray, (int)n2, (int)i);
                        }
                        return this.doa(byArray);
                    }
                    y y3 = y2;
                    y3();
                    y3.doab(this.dobd());
                    y2.doa(this.doai());
                    y2.doad(2);
                    LiveEventBus.get((String)"com.lepu.ble.cmd.response.error").post((Object)y3);
                    continue;
                }
                if (n2 != -91 || byArray[i + 1] != 90) continue;
                int n4 = i;
                n2 = i + 3;
                n2 = doah.doa.doah(ArraysKt.copyOfRange((byte[])byArray, (int)(n4 + 2), (int)n2));
                doah.doah.doa(this.doc, "want bytes length: " + n2);
                n2 = n4 + n2;
                if (n2 > byArray.length) continue;
                byte[] byArray3 = ArraysKt.copyOfRange((byte[])byArray, (int)i, (int)n2);
                this.doa(new doec(byArray3));
                if (n2 == byArray.length) {
                    byArray = null;
                } else {
                    int n5 = byArray.length;
                    byArray = ArraysKt.copyOfRange((byte[])byArray, (int)n2, (int)n5);
                }
                return this.doa(byArray);
            }
            return byArray;
        }
        return byArray;
    }

    @Override
    public void doab(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        if (this.doai() != -1) {
            doah.doah.doa(this.doc, "busy: " + doeb.doa + "$curCmd =>" + String.valueOf(this.doai()));
            return;
        }
        dobi dobi2 = this;
        this.docb = string;
        this.docd = string2;
        doah.doah.doa(this.doc, string + " \u5c06\u8981\u8bfb\u53d6\u6587\u4ef6 " + this.docd);
        byte[] byArray = doeb.doa(string2);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileStart(...)");
        dobi2.doab(byArray);
        dobi2.doab(doeb.doa);
        doah.doah.doab(dobi2.doc, "dealReadFile");
    }

    public final void doac(String string, String string2, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        if (this.doai() != -1) {
            doah.doah.doa(this.doc, "busy: " + doeb.doa + "$curCmd =>" + String.valueOf(this.doai()));
            return;
        }
        this.doch = n;
        this.doab(string, string2);
    }

    @Override
    public void docf() {
        dobi dobi2 = this;
        dobi2.doae(doeb.doai);
        doah.doah.doab(dobi2.doc, "syncTime");
    }

    @Override
    public void doal() {
        if (this.doai() != -1) {
            doah.doah.doa(this.doc, "busy: " + doeb.doa + "$curCmd =>" + String.valueOf(this.doai()));
            return;
        }
        dobi dobi2 = this;
        dobi2.doac(0);
        dobi2.docd = "1dlc.dat";
        doah.doah.doa(dobi2.doc, "\u5c06\u8981\u8bfb\u53d6\u6587\u4ef6 " + this.docd);
        byte[] byArray = doeb.doa(dobi2.docd);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileStart(...)");
        dobi2.doab(byArray);
        dobi2.doab(doeb.doa);
        doah.doah.doab(dobi2.doc, "getFileList");
    }

    public final void doa(int n, int n2) {
        if (this.doai() != -1) {
            doah.doah.doa(this.doc, "busy: " + doeb.doa + "$curCmd =>" + String.valueOf(this.doai()));
            return;
        }
        this.doac(0);
        this.docf = n2;
        this.docg = n;
        switch (n) {
            default: {
                break;
            }
            case 9: {
                this.docd = n2 + "bpcal.dat";
                break;
            }
            case 8: {
                this.docd = "usr.dat";
                break;
            }
            case 7: {
                this.docd = n2 + "ped.dat";
                break;
            }
            case 6: {
                this.docd = "slm.dat";
                break;
            }
            case 5: {
                this.docd = "tmp.dat";
                break;
            }
            case 4: {
                this.docd = n2 + "glu.dat";
                break;
            }
            case 3: {
                this.docd = n2 + "nibp.dat";
                break;
            }
            case 2: {
                this.docd = "oxi.dat";
                break;
            }
            case 1: {
                this.docd = "ecg.dat";
                break;
            }
            case 0: {
                this.docd = n2 + "dlc.dat";
            }
        }
        byte[] byArray = doeb.doa(this.docd);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readFileStart(...)");
        this.doab(byArray);
        this.doab(doeb.doa);
        doah.doah.doab(this.doc, "getFileList type:" + n + ", id:" + n2 + ", curFileName:" + this.docd);
    }

    @Override
    public void doam() {
        dobi dobi2 = this;
        dobi2.doae(doeb.doag);
        doah.doah.doab(dobi2.doc, "getInfo");
    }

    @Override
    public void dobh() {
        doah.doah.doab(this.doc, "getRtData Not yet implemented");
    }

    @Override
    public void doad() {
        doah.doah.doab(this.doc, "factoryReset Not yet implemented");
    }

    @Override
    public void doae() {
        doah.doah.doab(this.doc, "factoryResetAll Not yet implemented");
    }

    @Override
    public void docd() {
        doah.doah.doab(this.doc, "reset Not yet implemented");
    }

    @Override
    public void doa(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"userId");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"fileName");
        doah.doah.doab(this.doc, "dealContinueRF Not yet implemented");
    }
}
