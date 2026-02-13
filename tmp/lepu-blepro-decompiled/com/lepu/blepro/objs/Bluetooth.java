/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.lepu.blepro.objs;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public class Bluetooth
implements Parcelable {
    public static final String BT_NAME_O2 = "O2";
    public static final String BT_NAME_O2S = "O2S";
    public static final String BT_NAME_SNO2 = "O2BAND";
    public static final String BT_NAME_SPO2 = "SleepO2";
    public static final String BT_NAME_O2RING = "O2Ring";
    public static final String BT_NAME_O2RING_S = "O2Ring S";
    public static final String BT_NAME_S8_AW = "S8-AW";
    public static final String BT_NAME_OXYRING = "OxyRing";
    public static final String BT_NAME_WEARO2 = "WearO2";
    public static final String BT_NAME_SLEEPU = "SleepU";
    public static final String BT_NAME_LEPU_ER1 = "LEPU ER1";
    public static final String BT_NAME_ER1 = "ER1";
    public static final String BT_NAME_ER1S = "ER1S";
    public static final String BT_NAME_ER1_S = "ER1-S";
    public static final String BT_NAME_ER1_SP = "ER1-SP";
    public static final String BT_NAME_ER1_H = "ER1-H";
    public static final String BT_NAME_ER1_W = "ER1-W";
    public static final String BT_NAME_ER1_L = "ER1-L";
    public static final String BT_NAME_ER1_N = "VBeat";
    public static final String BT_NAME_DUOEK = "DuoEK";
    public static final String BT_NAME_PULSEBIT_EX = "Pulsebit";
    public static final String BT_NAME_CHECKME_EX = "Checkme EX";
    public static final String BT_NAME_OXY_LINK = "Oxylink";
    public static final String BT_NAME_KIDS_O2 = "KidsO2";
    public static final String BT_NAME_KIDS_O2_WPS = "KidsO2-WPS";
    public static final String FETAL_DEVICE_NAME = "MD1000AF4";
    public static final String BT_NAME_BABY_O2 = "BabyO2";
    public static final String BT_NAME_OXY_SMART = "OxySmart";
    public static final String BT_NAME_TV221U = "VTM 20F";
    public static final String BT_NAME_PC100 = "PC-100";
    public static final String BT_NAME_PC60FW = "PC-60F_SN";
    public static final String BT_NAME_KS60FW = "KS-60FW";
    public static final String BT_NAME_AOJ20A = "AOJ-20A";
    public static final String BT_NAME_BP2 = "BP2";
    public static final String BT_NAME_AURA_BP2 = "Aura_BP2";
    public static final String BT_NAME_OXYFIT = "Oxyfit";
    public static final String BT_NAME_OXYFIT_WPS = "Oxyfit-WPS";
    public static final String BT_NAME_VCOMIN = "VCOMIN";
    public static final String BT_NAME_CHECK_POD = "Checkme Pod";
    public static final String BT_NAME_CHECKME_POD_WPS = "Checkme Pod-WPS";
    public static final String BT_NAME_BP2A = "BP2A";
    public static final String BT_NAME_BODY_FAT = "Viatom";
    public static final String BT_NAME_O2M = "O2M";
    public static final String BT_NAME_O2M_WPS = "O2M-WPS";
    public static final String BT_NAME_BPM = "BPM-188";
    public static final String BT_NAME_LEM = "LEM1";
    public static final String BT_NAME_FHR = "FHR-666(BLE)";
    public static final String BT_NAME_BABYO2N = "BabyO2N";
    public static final String BT_NAME_BBSM_S1 = "BBSM S1";
    public static final String BT_NAME_BBSM_S2 = "BBSM S2";
    public static final String BT_NAME_BBSM_S3 = "BBSM S3";
    public static final String BT_NAME_BP2T = "BP2T";
    public static final String BT_NAME_BP2W = "BP2W";
    public static final String BT_NAME_DEVICES_ER2 = "ER2";
    public static final String BT_NAME_ER2_S = "ER2-S";
    public static final String BT_NAME_LP_ER2 = "LP ER2";
    public static final String BT_NAME_LEPU_ER2 = "LEPU-ER2";
    public static final String BT_NAME_CM_TOUCH = "CMTouch";
    public static final String BT_NAME_STATION = "Station";
    public static final String BT_NAME_POD2B = "POD-2B_SN";
    public static final String BT_NAME_PC_60NW_BLE = "PC-60NW_BLE";
    public static final String BT_NAME_PC_60NW_NO_SN = "PC-60NW";
    public static final String BT_NAME_PC_60NW = "PC-60NW_SN";
    public static final String BT_NAME_PC_60NW_1 = "PC-60NW-1_SN";
    public static final String BT_NAME_PC_60NW_WPS = "PC-60NW-WPS";
    public static final String BT_NAME_POD_1W = "POD-1_SN";
    public static final String BT_NAME_PC_60B = "PC-60B_SN";
    public static final String BT_NAME_PO6B_WE = "PO6B-WE";
    public static final String BT_NAME_POD_1W_WU = "POD-1W-WU";
    public static final String BT_NAME_S5W_VU = "S5W-VU";
    public static final String BT_NAME_RINGO2 = "O2NCI";
    public static final String BT_NAME_KCA = "KCA";
    public static final String BT_NAME_KCB = "KCB";
    public static final String BT_NAME_PC80B = "PC80B";
    public static final String BT_NAME_PC80B_BLE = "PC80B-BLE";
    public static final String BT_NAME_PC80B_BLE2 = "PC80B_BLE:";
    public static final String BT_NAME_BPW1 = "BPW1";
    public static final String BT_NAME_F4_SCALE = "F4";
    public static final String BT_NAME_MY_SCALE = "MY_SCALE";
    public static final String BT_NAME_F5_SCALE = "F5";
    public static final String BT_NAME_F8_SCALE = "F8";
    public static final String BT_NAME_PC66B = "PC-66B";
    public static final String BT_NAME_PC66B_VE = "PC66B-VE";
    public static final String BT_NAME_LEW = "Le-W";
    public static final String BT_NAME_AP20 = "AP-20";
    public static final String BT_NAME_AP20_WPS = "AP-20-WPS";
    public static final String BT_NAME_SP20 = "SP-20";
    public static final String BT_NAME_SP20_BLE = "SP-20-BLE";
    public static final String BT_NAME_SP20_WPS = "SP-20-WPS";
    public static final String BT_NAME_VETCORDER = "Vetcorder";
    public static final String BT_NAME_VTM_AD5 = "VTM AD5";
    public static final String BT_NAME_LP_BP2W = "LP-BP2W";
    public static final String BT_NAME_BP2B = "BP2B";
    public static final String BT_NAME_BP2V = "BP2V";
    public static final String BT_NAME_PC_68B = "PC-68B";
    public static final String BT_NAME_PC_300 = "PC_300SNT";
    public static final String BT_NAME_PC_300_BLE = "PC_300SNT-BLE";
    public static final String BT_NAME_CHECKME_LE = "CheckmeLE";
    public static final String BT_NAME_PF_10 = "PF-10";
    public static final String BT_NAME_PF_20 = "PF-20";
    public static final String BT_NAME_LES1 = "le S1";
    public static final String BT_NAME_VSCALE_HR = "VScale HR";
    public static final String BT_NAME_CHECK_ADV = "CheckADV";
    public static final String BT_NAME_CMRING = "CMRing";
    public static final String BT_NAME_LPRE = "LPRE";
    public static final String BT_NAME_LE_B1 = "le B1";
    public static final String BT_NAME_OXYU = "OxyU";
    public static final String BT_NAME_S5W = "S5W_SN";
    public static final String BT_NAME_W12C = "W12c";
    public static final String BT_NAME_AI_S100 = "AI-S100";
    public static final String BT_NAME_HHM1 = "HHM1";
    public static final String BT_NAME_HHM2 = "HHM2";
    public static final String BT_NAME_HHM3 = "HHM3";
    public static final String BT_NAME_HHM4 = "HHM4";
    public static final String BT_NAME_LPM311 = "LPM311";
    public static final String BT_NAME_POCTOR_M3102 = "PoctorM3102";
    public static final String BT_NAME_S6W = "S6W";
    public static final String BT_NAME_S6W1 = "S6W1";
    public static final String BT_NAME_S7W = "S7W";
    public static final String BT_NAME_BIOLAND_BGM = "Bioland-BGM";
    public static final String BT_NAME_S7BW = "S7BW";
    public static final String BT_NAME_PF_10AW = "PF-10AW";
    public static final String BT_NAME_PF_10AW1 = "PF-10AW1";
    public static final String BT_NAME_PF_10AW_1 = "PF-10AW-1";
    public static final String BT_NAME_PF_10BW = "PF-10BW";
    public static final String BT_NAME_PF_10BWS = "PF-10BWS";
    public static final String BT_NAME_PF_10BW1 = "PF-10BW1";
    public static final String BT_NAME_PF_20AW = "PF-20AW";
    public static final String BT_NAME_PF_20B = "PF-20B";
    public static final String BT_NAME_CHECKME = "Checkme";
    public static final String BT_NAME_CHECKME_LP = "CheckmeLP";
    public static final String BT_NAME_BUZUD_CML = "BUZUD-CML";
    public static final String BT_NAME_ER3 = "ER3";
    public static final String BT_NAME_M5 = "M5";
    public static final String BT_NAME_M12 = "M12";
    public static final String BT_NAME_LEPOD = "Lepod";
    public static final String BT_NAME_LEPOD_PRO = "LepodPro";
    public static final String BT_NAME_VTM01 = "VTM01";
    public static final String BT_NAME_PC200 = "PC-200";
    public static final String BT_NAME_PC200_BLE = "PC-200-BLE";
    public static final String BT_NAME_QC200 = "QC-200";
    public static final String BT_NAME_BTP = "BTP";
    public static final String BT_NAME_S5_SCALE = "Le S5";
    public static final String BT_NAME_R20 = "R20";
    public static final String BT_NAME_R200 = "R200";
    public static final String BT_NAME_R21 = "R21";
    public static final String BT_NAME_R10 = "R10";
    public static final String BT_NAME_R11 = "R11";
    public static final String BT_NAME_LERES = "LeRes";
    public static final String BT_NAME_ECN = "ECN";
    public static final String BT_NAME_GM_300SNT = "GM_300SNT";
    public static final String BT_NAME_GM_300SNT_BLE = "GM_300SNT-BLE";
    public static final String BT_NAME_SI_PO6 = "SI PO6";
    public static final String BT_NAME_SI_PO2 = "SI PO2";
    public static final String BT_NAME_SI_PO4 = "SI PO4";
    public static final String BT_NAME_LESCALE_P3 = "Lescale P3";
    public static final String BT_NAME_CMI_PC303 = "CMI_PC303";
    public static final String BT_NAME_TMB_2088 = "TMB_2088";
    public static final String BT_NAME_TMB_2288 = "TMB-2288";
    public static final String BT_NAME_LESCALE_F4P = "Lescale F4P";
    public static final String BT_NAME_LESCALE_F4L = "Lescale F4L";
    public static final String BT_NAME_LESCALE_F3 = "Lescale F3";
    public static final String BT_NAME_BP3_C1 = "BP3-C1";
    public static final String BT_NAME_BP3_C2 = "BP3-C2";
    public static final String BT_NAME_BP3_B = "BP3-B";
    public static final String BT_NAME_BP2A_NEXUS = "BP2A Nexus";
    public static final String BT_NAME_BP4_FLEX = "BP4 Flex";
    public static final String BT_NAME_SA10AW_PU = "SA10AW-PU";
    public static final String BT_NAME_PF10BW_VE = "PF10BW-VE";
    public static final String BT_NAME_PF10AW_ME = "PF10AW-ME";
    public static final String BT_NAME_BP3 = "BP3";
    public static final String BT_NAME_BP3A = "BP3A";
    public static final String BT_NAME_BP3B = "BP3B";
    public static final String BT_NAME_BP3C = "BP3C";
    public static final String BT_NAME_HDM3D = "HDM3D";
    public static final String BT_NAME_BP3D = "BP3D";
    public static final String BT_NAME_BP3E = "BP3E";
    public static final String BT_NAME_BP3F = "BP3F";
    public static final String BT_NAME_BP3G = "BP3G";
    public static final String BT_NAME_BP3H = "BP3H";
    public static final String BT_NAME_BP3K = "BP3K";
    public static final String BT_NAME_BP3L = "BP3L";
    public static final String BT_NAME_BP3Z = "BP3Z";
    public static final String BT_NAME_CMB590840 = "CMB590840";
    public static final String BT_NAME_BBSM_P1 = "BBSM P1";
    public static final String BT_NAME_BBSM_BS1 = "BBSM BS1";
    public static final String BT_NAME_CMB590611 = "CMB590611";
    public static final String BT_NAME_AIRBP = "AirBP";
    public static final String BT_NAME_LPW30 = "BPWATCH";
    public static final String BT_NAME_LE_F2_PRO = "Le-F2 Pro";
    public static final String BT_NAME_LEPU_PO6 = "Lepu PO6";
    public static final String BT_NAME_LEPU_AED = "LEPU AED";
    public static final String BT_NAME_CPR_FEEDBACK = "CPR Feedback";
    public static final String BT_NAME_CPR_01 = "CPR-01";
    public static final String BT_NAME_CPR_02 = "CPR-02";
    public static final String BT_NAME_BAND_WU = "Band-WU";
    public static final String BT_NAME_AED_BOX = "aed_box";
    public static final String BT_NAME_SHQO2_PRO = "SHQO2Pro";
    public static final String BT_NAME_BM10 = "BM10";
    public static final String BT_NAME_CHECKME_LITE_A = "Checkme lite A";
    public static final String BT_NAME_DUAL_SPP = "DUAL-SPP";
    public static final String BT_NAME_JFR1001 = "JFR1001";
    public static final String BT_NAME_JFK1001 = "JFK1001";
    public static final String BT_NAME_MY_SS2501 = "MY-SS2501";
    public static final String BT_NAME_AITELE = "AITele";
    public static final String BT_NAME_O2RINGF = "O2RingF";
    public static final String BT_NAME_AIVIEW_VS = "AIView VS";
    public static final String BT_NAME_ZH_SG = "ZH-SG";
    public static final String BT_NAME_ZH_SG_A606 = "ZH-SG-A606";
    public static final String BT_NAME_WBP02 = "WBP-02";
    public static final String BT_NAME_T31 = "Genial-T31";
    public static final String BT_NAME_IGATE = "iGate";
    public static final String BT_NAME_LBM_1 = "LBM-1";
    public static final String BT_NAME_OMP = "OMP";
    public static final String BT_NAME_LDT = "LDT";
    public static final String BT_NAME_LD_TECK = "LD-TECK";
    public static final String BT_NAME_HDM3G = "HDM3G";
    public static final String BT_NAME_O2RING_RE = "O2Ring-RE";
    public static final int MODEL_UNRECOGNIZED = 0;
    public static final int MODEL_CHECKO2 = 1;
    public static final int MODEL_SNOREO2 = 2;
    public static final int MODEL_SLEEPO2 = 3;
    public static final int MODEL_O2RING = 4;
    public static final int MODEL_WEARO2 = 5;
    public static final int MODEL_SLEEPU = 6;
    public static final int MODEL_ER1 = 7;
    public static final int MODEL_DUOEK = 8;
    public static final int MODEL_PULSEBITEX = 9;
    public static final int MODEL_OXYLINK = 10;
    public static final int MODEL_KIDSO2 = 11;
    public static final int MODEL_FETAL = 12;
    public static final int MODEL_BABYO2 = 13;
    public static final int MODEL_OXYSMART = 14;
    public static final int MODEL_TV221U = 15;
    public static final int MODEL_ER1_N = 16;
    public static final int MODEL_PC100 = 17;
    public static final int MODEL_AOJ20A = 18;
    public static final int MODEL_BP2 = 19;
    public static final int MODEL_OXYFIT = 20;
    public static final int MODEL_VCOMIN = 21;
    public static final int MODEL_CHECK_POD = 22;
    public static final int MODEL_BP2A = 23;
    public static final int MODEL_BODY_FAT = 24;
    public static final int MODEL_O2M = 25;
    public static final int MODEL_BPM = 26;
    public static final int MODEL_LEM = 27;
    public static final int MODEL_FHR = 28;
    public static final int MODEL_BABYO2N = 29;
    public static final int MODEL_PC60FW = 30;
    public static final int MODEL_BP2T = 31;
    public static final int MODEL_BP2W = 32;
    public static final int MODEL_ER2 = 33;
    public static final int MODEL_STATION = 34;
    public static final int MODEL_POD2B = 35;
    public static final int MODEL_PC_60NW_1 = 36;
    public static final int MODEL_POD_1W = 37;
    public static final int MODEL_PC_60B = 38;
    public static final int MODEL_BPM_NO_BLE = 39;
    public static final int MODEL_MY_SCALE = 40;
    public static final int MODEL_AP20 = 41;
    public static final int MODEL_PC66B = 42;
    public static final int MODEL_PC80B = 43;
    public static final int MODEL_LEW = 44;
    public static final int MODEL_VETCORDER = 45;
    public static final int MODEL_BPW1 = 46;
    public static final int MODEL_F4_SCALE = 47;
    public static final int MODEL_RINGO2 = 48;
    public static final int MODEL_KCA = 49;
    public static final int MODEL_VTM_AD5 = 50;
    public static final int MODEL_SP20 = 51;
    public static final int MODEL_LP_BP2W = 52;
    public static final int MODEL_F8_SCALE = 53;
    public static final int MODEL_PC_68B = 54;
    public static final int MODEL_PC300 = 55;
    public static final int MODEL_CHECKME_LE = 56;
    public static final int MODEL_PF_10 = 57;
    public static final int MODEL_PF_20 = 58;
    public static final int MODEL_LES1 = 59;
    public static final int MODEL_PC_60NW = 60;
    public static final int MODEL_CHECK_ADV = 61;
    public static final int MODEL_F5_SCALE = 62;
    public static final int MODEL_OXYRING = 63;
    public static final int MODEL_BBSM_S1 = 64;
    public static final int MODEL_BBSM_S2 = 65;
    public static final int MODEL_CMRING = 66;
    public static final int MODEL_LPRE = 67;
    public static final int MODEL_LE_B1 = 68;
    public static final int MODEL_OXYU = 69;
    public static final int MODEL_S5W = 70;
    public static final int MODEL_W12C = 71;
    public static final int MODEL_AI_S100 = 72;
    public static final int MODEL_HHM1 = 73;
    public static final int MODEL_HHM2 = 74;
    public static final int MODEL_HHM3 = 75;
    public static final int MODEL_HHM4 = 76;
    public static final int MODEL_LP_ER2 = 77;
    public static final int MODEL_LPM311 = 78;
    public static final int MODEL_POCTOR_M3102 = 79;
    public static final int MODEL_S6W = 80;
    public static final int MODEL_S7W = 81;
    public static final int MODEL_BIOLAND_BGM = 82;
    public static final int MODEL_S7BW = 83;
    public static final int MODEL_S6W1 = 84;
    public static final int MODEL_PF_10AW = 85;
    public static final int MODEL_PF_10AW1 = 86;
    public static final int MODEL_PF_10BW = 87;
    public static final int MODEL_PF_10BW1 = 88;
    public static final int MODEL_PF_20AW = 89;
    public static final int MODEL_PF_20B = 90;
    public static final int MODEL_CHECKME = 91;
    public static final int MODEL_PC80B_BLE = 92;
    public static final int MODEL_SP20_BLE = 93;
    public static final int MODEL_PC300_BLE = 94;
    public static final int MODEL_ER3 = 95;
    public static final int MODEL_LEPOD = 96;
    public static final int MODEL_PC60NW_BLE = 97;
    public static final int MODEL_PC60NW_WPS = 98;
    public static final int MODEL_SP20_WPS = 99;
    public static final int MODEL_AP20_WPS = 100;
    public static final int MODEL_O2M_WPS = 101;
    public static final int MODEL_PC80B_BLE2 = 102;
    public static final int MODEL_VTM01 = 103;
    public static final int MODEL_PC200_BLE = 104;
    public static final int MODEL_BTP = 105;
    public static final int MODEL_S5_SCALE = 106;
    public static final int MODEL_R20 = 107;
    public static final int MODEL_LERES = 108;
    public static final int MODEL_PC_60NW_NO_SN = 109;
    public static final int MODEL_ECN = 110;
    public static final int MODEL_GM_300SNT = 111;
    public static final int MODEL_OXYFIT_WPS = 112;
    public static final int MODEL_KIDSO2_WPS = 113;
    public static final int MODEL_CHECKME_POD_WPS = 114;
    public static final int MODEL_R21 = 115;
    public static final int MODEL_R10 = 116;
    public static final int MODEL_R11 = 117;
    public static final int MODEL_BP3A = 118;
    public static final int MODEL_BP3B = 119;
    public static final int MODEL_SI_PO6 = 120;
    public static final int MODEL_LESCALE_P3 = 121;
    public static final int MODEL_CMI_PC303 = 122;
    public static final int MODEL_PF_10AW_1 = 123;
    public static final int MODEL_O2RING_S = 124;
    public static final int MODEL_TMB_2088 = 125;
    public static final int MODEL_PF_10BWS = 126;
    public static final int MODEL_ER1S = 127;
    public static final int MODEL_GM_300SNT_BLE = 128;
    public static final int MODEL_LESCALE_F4P = 129;
    public static final int MODEL_SI_PO2 = 130;
    public static final int MODEL_BP3_C1 = 131;
    public static final int MODEL_BP3_C2 = 132;
    public static final int MODEL_SA10AW_PU = 133;
    public static final int MODEL_PF10BW_VE = 134;
    public static final int MODEL_BP3D = 135;
    public static final int MODEL_BP3F = 136;
    public static final int MODEL_BP3G = 137;
    public static final int MODEL_CMB590840 = 138;
    public static final int MODEL_PO6B_WE = 139;
    public static final int MODEL_POD_1W_WU = 140;
    public static final int MODEL_S5W_VU = 141;
    public static final int MODEL_TMB_2288 = 142;
    public static final int MODEL_BBSM_P1 = 143;
    public static final int MODEL_S8_AW = 144;
    public static final int MODEL_ER1_S = 145;
    public static final int MODEL_ER1_H = 146;
    public static final int MODEL_ER1_W = 147;
    public static final int MODEL_ER1_L = 148;
    public static final int MODEL_ER2_S = 149;
    public static final int MODEL_CMB590611 = 150;
    public static final int MODEL_LEPOD_PRO = 151;
    public static final int MODEL_M12 = 152;
    public static final int MODEL_AIRBP = 153;
    public static final int MODEL_LPW30 = 154;
    public static final int MODEL_BP3C = 155;
    public static final int MODEL_BP3E = 156;
    public static final int MODEL_BP3H = 157;
    public static final int MODEL_BP3K = 158;
    public static final int MODEL_BP3Z = 159;
    public static final int MODEL_LESCALE_F4L = 160;
    public static final int MODEL_CHECKME_LP = 161;
    public static final int MODEL_PC66B_VE = 162;
    public static final int MODEL_LE_F2_PRO = 163;
    public static final int MODEL_BP3L = 164;
    public static final int MODEL_CM_TOUCH = 165;
    public static final int MODEL_LESCALE_F3 = 166;
    public static final int MODEL_BP3_B = 167;
    public static final int MODEL_LEPU_ER2 = 168;
    public static final int MODEL_KCB = 169;
    public static final int MODEL_O2S = 170;
    public static final int MODEL_LEPU_PO6 = 171;
    public static final int MODEL_LEPU_AED = 172;
    public static final int MODEL_CPR_FEEDBACK = 173;
    public static final int MODEL_SI_PO4 = 174;
    public static final int MODEL_BAND_WU = 175;
    public static final int MODEL_M5 = 176;
    public static final int MODEL_BP2B = 177;
    public static final int MODEL_BP2V = 178;
    public static final int MODEL_AED_BOX = 179;
    public static final int MODEL_SHQO2_PRO = 180;
    public static final int MODEL_PF10AW_ME = 181;
    public static final int MODEL_BM10 = 182;
    public static final int MODEL_CHECKME_LITE_A = 183;
    public static final int MODEL_LEPU_ER1 = 184;
    public static final int MODEL_BBSM_BS1 = 185;
    public static final int MODEL_PC200 = 186;
    public static final int MODEL_QC200 = 187;
    public static final int MODEL_BP2A_NEXUS = 188;
    public static final int MODEL_BP4_FLEX = 189;
    public static final int MODEL_KS60FW = 190;
    public static final int MODEL_DUAL_SPP = 191;
    public static final int MODEL_AURA_BP2 = 192;
    public static final int MODEL_JFR1001 = 193;
    public static final int MODEL_MY_SS2501 = 194;
    public static final int MODEL_BP3 = 195;
    public static final int MODEL_HDM3D = 196;
    public static final int MODEL_JFK1001 = 197;
    public static final int MODEL_AITELE = 198;
    public static final int MODEL_BBSM_S3 = 199;
    public static final int MODEL_R200 = 200;
    public static final int MODEL_CPR_01 = 201;
    public static final int MODEL_CPR_02 = 202;
    public static final int MODEL_O2RINGF = 203;
    public static final int MODEL_AIVIEW_VS = 204;
    public static final int MODEL_ZH_SG = 205;
    public static final int MODEL_ZH_SG_A606 = 206;
    public static final int MODEL_CHECKME_EX = 207;
    public static final int MODEL_WBP02 = 208;
    public static final int MODEL_T31 = 209;
    public static final int MODEL_ER1_SP = 210;
    public static final int MODEL_IGATE = 211;
    public static final int MODEL_LBM_1 = 212;
    public static final int MODEL_OMP = 213;
    public static final int MODEL_LDT = 214;
    public static final int MODEL_LD_TECK = 215;
    public static final int MODEL_HDM3G = 216;
    public static final int MODEL_O2RING_RE = 217;
    private static final Set<Integer> ENCRYPT_DEVICES;
    public static final Parcelable.Creator<Bluetooth> CREATOR;
    private int model;
    private String name;
    private BluetoothDevice device;
    private String macAddr;
    private int rssi;

    /*
     * Enabled aggressive block sorting
     */
    public static int getDeviceModel(String string) {
        int n;
        block268: {
            int n2;
            if (string == null) return 0;
            if (string.length() == 0) {
                return 0;
            }
            if (string.contains(BT_NAME_PC60FW)) {
                return 30;
            }
            if (FETAL_DEVICE_NAME.equals(string)) {
                return 12;
            }
            if (BT_NAME_TV221U.equals(string)) {
                return 15;
            }
            if (string.contains(BT_NAME_PC100)) {
                return 17;
            }
            if (BT_NAME_AOJ20A.equals(string)) {
                return 18;
            }
            if (string.contains(BT_NAME_VCOMIN)) {
                return 21;
            }
            if (string.contains(BT_NAME_CHECKME_LITE_A)) {
                return 183;
            }
            if (string.contains(BT_NAME_CHECKME)) {
                if (string.contains(BT_NAME_CHECK_POD)) {
                    if (!string.contains(BT_NAME_CHECKME_POD_WPS)) return 22;
                    return 114;
                }
                if (string.contains(BT_NAME_CHECKME_LE)) {
                    return 56;
                }
                if (string.contains(BT_NAME_CHECKME_LP)) {
                    return 161;
                }
                if (!string.contains(BT_NAME_CHECKME_EX)) return 91;
                return 207;
            }
            if (BT_NAME_BODY_FAT.equals(string)) {
                return 24;
            }
            if (string.contains(BT_NAME_POD2B)) {
                return 35;
            }
            if (string.contains(BT_NAME_PC_60NW_NO_SN)) {
                if (string.contains(BT_NAME_PC_60NW_1)) {
                    return 36;
                }
                if (string.contains(BT_NAME_PC_60NW)) {
                    return 60;
                }
                if (string.contains(BT_NAME_PC_60NW_BLE)) {
                    return 97;
                }
                if (!string.contains(BT_NAME_PC_60NW_WPS)) return 109;
                return 98;
            }
            if (string.contains(BT_NAME_POD_1W)) {
                return 37;
            }
            if (string.contains(BT_NAME_PC_60B)) {
                return 38;
            }
            if (string.contains(BT_NAME_KCA)) {
                return 49;
            }
            if (string.contains(BT_NAME_KCB)) {
                return 169;
            }
            if (string.contains(BT_NAME_PC80B)) {
                if (string.contains(BT_NAME_PC80B_BLE2)) {
                    return 102;
                }
                if (!string.contains(BT_NAME_PC80B_BLE)) return 43;
                return 92;
            }
            if (string.contains(BT_NAME_PC66B)) {
                return 42;
            }
            if (string.contains(BT_NAME_PC66B_VE)) {
                return 162;
            }
            if (string.contains(BT_NAME_AP20)) {
                if (!string.contains(BT_NAME_AP20_WPS)) return 41;
                return 100;
            }
            if (string.contains(BT_NAME_VTM_AD5)) {
                return 50;
            }
            if (string.contains(BT_NAME_SP20)) {
                if (string.contains(BT_NAME_SP20_BLE)) {
                    return 93;
                }
                if (!string.contains(BT_NAME_SP20_WPS)) return 51;
                return 99;
            }
            if (string.contains(BT_NAME_PC_68B)) {
                return 54;
            }
            if (string.contains(BT_NAME_PC_300)) {
                if (!string.contains(BT_NAME_PC_300_BLE)) return 55;
                return 94;
            }
            if (string.contains(BT_NAME_PF_10)) {
                if (string.contains(BT_NAME_PF_10AW)) {
                    if (string.contains(BT_NAME_PF_10AW1)) {
                        return 86;
                    }
                    if (!string.contains(BT_NAME_PF_10AW_1)) return 85;
                    return 123;
                }
                if (!string.contains(BT_NAME_PF_10BW)) return 57;
                if (string.contains(BT_NAME_PF_10BW1)) {
                    return 88;
                }
                if (!string.contains(BT_NAME_PF_10BWS)) return 87;
                return 126;
            }
            if (string.contains(BT_NAME_PF_20)) {
                if (string.contains(BT_NAME_PF_20AW)) {
                    return 89;
                }
                if (!string.contains(BT_NAME_PF_20B)) return 58;
                return 90;
            }
            if (string.contains(BT_NAME_LES1)) {
                return 59;
            }
            if (string.contains(BT_NAME_CHECK_ADV)) {
                return 61;
            }
            if (string.contains(BT_NAME_BBSM_S1)) {
                return 64;
            }
            if (string.contains(BT_NAME_BBSM_S2)) {
                return 65;
            }
            if (string.contains(BT_NAME_BBSM_S3)) {
                return 199;
            }
            if (string.contains(BT_NAME_LEW)) {
                return 44;
            }
            if (string.contains(BT_NAME_CMRING)) {
                return 66;
            }
            if (string.contains(BT_NAME_LPRE)) {
                return 67;
            }
            if (string.contains(BT_NAME_LE_B1)) {
                return 68;
            }
            if (string.contains(BT_NAME_OXYU)) {
                return 69;
            }
            if (string.contains(BT_NAME_S5W)) {
                return 70;
            }
            if (string.contains(BT_NAME_W12C)) {
                return 71;
            }
            if (string.contains(BT_NAME_AI_S100)) {
                return 72;
            }
            if (string.contains(BT_NAME_HHM1)) {
                return 73;
            }
            if (string.contains(BT_NAME_HHM2)) {
                return 74;
            }
            if (string.contains(BT_NAME_HHM3)) {
                return 75;
            }
            if (string.contains(BT_NAME_HHM4)) {
                return 76;
            }
            if (string.contains(BT_NAME_LPM311)) {
                return 78;
            }
            if (string.contains(BT_NAME_POCTOR_M3102)) {
                return 79;
            }
            if (string.contains(BT_NAME_S6W)) {
                if (!string.contains(BT_NAME_S6W1)) return 80;
                return 84;
            }
            if (string.contains(BT_NAME_S7W)) {
                return 81;
            }
            if (string.contains(BT_NAME_S7BW)) {
                return 83;
            }
            if (string.contains(BT_NAME_BIOLAND_BGM)) {
                return 82;
            }
            if (string.contains(BT_NAME_LEPOD)) {
                if (!string.contains(BT_NAME_LEPOD_PRO)) return 96;
                return 151;
            }
            if (string.contains(BT_NAME_O2M_WPS)) {
                return 101;
            }
            if (string.contains(BT_NAME_PC200)) {
                if (!string.contains(BT_NAME_PC200_BLE)) return 186;
                return 104;
            }
            if (string.contains(BT_NAME_QC200)) {
                return 187;
            }
            if (string.contains(BT_NAME_S5_SCALE)) {
                return 106;
            }
            if (string.contains(BT_NAME_LERES)) {
                return 108;
            }
            if (string.contains(BT_NAME_GM_300SNT)) {
                if (!string.contains(BT_NAME_GM_300SNT_BLE)) return 111;
                return 128;
            }
            if (string.contains(BT_NAME_KIDS_O2_WPS)) {
                return 113;
            }
            if (string.contains(BT_NAME_R20)) {
                if (!string.contains(BT_NAME_R200)) return 107;
                return 200;
            }
            if (string.contains(BT_NAME_R21)) {
                return 115;
            }
            if (string.contains(BT_NAME_R10)) {
                if (!string.contains(BT_NAME_JFR1001)) return 116;
                return 193;
            }
            if (string.contains(BT_NAME_JFK1001)) {
                return 197;
            }
            if (string.contains(BT_NAME_R11)) {
                return 117;
            }
            if (string.contains(BT_NAME_BP3)) {
                if (string.contains(BT_NAME_BP3A)) {
                    return 118;
                }
                if (string.contains(BT_NAME_BP3B)) {
                    return 119;
                }
                if (string.contains(BT_NAME_BP3C)) {
                    return 155;
                }
                if (string.contains(BT_NAME_BP3_C1)) {
                    return 131;
                }
                if (string.contains(BT_NAME_BP3_C2)) {
                    return 132;
                }
                if (string.contains(BT_NAME_BP3_B)) {
                    return 167;
                }
                if (string.contains(BT_NAME_BP3D)) {
                    return 135;
                }
                if (string.contains(BT_NAME_BP3F)) {
                    return 136;
                }
                if (string.contains(BT_NAME_BP3G)) {
                    return 137;
                }
                if (string.contains(BT_NAME_BP3E)) {
                    return 156;
                }
                if (string.contains(BT_NAME_BP3H)) {
                    return 157;
                }
                if (string.contains(BT_NAME_BP3K)) {
                    return 158;
                }
                if (string.contains(BT_NAME_BP3Z)) {
                    return 159;
                }
                if (!string.contains(BT_NAME_BP3L)) return 195;
                return 164;
            }
            if (string.contains(BT_NAME_HDM3D)) {
                return 196;
            }
            if (string.contains(BT_NAME_SI_PO6)) {
                return 120;
            }
            if (string.contains(BT_NAME_LESCALE_P3)) {
                return 121;
            }
            if (string.contains(BT_NAME_CMI_PC303)) {
                return 122;
            }
            if (string.contains(BT_NAME_O2RING)) {
                if (string.contains(BT_NAME_O2RING_S)) {
                    return 124;
                }
                if (string.contains(BT_NAME_O2RINGF)) {
                    return 203;
                }
                if (!string.contains(BT_NAME_O2RING_RE)) return 4;
                return 217;
            }
            if (string.contains(BT_NAME_TMB_2088)) {
                return 125;
            }
            if (string.contains(BT_NAME_ER1)) {
                if (string.contains(BT_NAME_ER1S)) {
                    return 127;
                }
                if (string.contains(BT_NAME_ER1_S)) {
                    if (!string.contains(BT_NAME_ER1_SP)) return 145;
                    return 210;
                }
                if (string.contains(BT_NAME_ER1_H)) {
                    return 146;
                }
                if (string.contains(BT_NAME_ER1_W)) {
                    return 147;
                }
                if (string.contains(BT_NAME_ER1_L)) {
                    return 148;
                }
                if (!string.contains(BT_NAME_LEPU_ER1)) return 7;
                return 184;
            }
            if (string.contains(BT_NAME_LESCALE_F4P)) {
                return 129;
            }
            if (string.contains(BT_NAME_LESCALE_F4L)) {
                return 160;
            }
            if (string.contains(BT_NAME_LESCALE_F3)) {
                return 166;
            }
            if (string.contains(BT_NAME_SI_PO2)) {
                return 130;
            }
            if (string.contains(BT_NAME_SA10AW_PU)) {
                return 133;
            }
            if (string.contains(BT_NAME_PF10BW_VE)) {
                return 134;
            }
            if (string.contains(BT_NAME_CMB590840)) {
                return 138;
            }
            if (string.contains(BT_NAME_PO6B_WE)) {
                return 139;
            }
            if (string.contains(BT_NAME_POD_1W_WU)) {
                return 140;
            }
            if (string.contains(BT_NAME_S5W_VU)) {
                return 141;
            }
            if (string.contains(BT_NAME_TMB_2288)) {
                return 142;
            }
            if (string.contains(BT_NAME_BBSM_P1)) {
                return 143;
            }
            if (string.contains(BT_NAME_BBSM_BS1)) {
                return 185;
            }
            if (string.contains(BT_NAME_S8_AW)) {
                return 144;
            }
            if (string.contains(BT_NAME_DEVICES_ER2)) {
                if (string.contains(BT_NAME_ER2_S)) {
                    return 149;
                }
                if (string.contains(BT_NAME_LP_ER2)) {
                    return 77;
                }
                if (!string.contains(BT_NAME_LEPU_ER2)) return 33;
                return 168;
            }
            if (string.contains(BT_NAME_CMB590611)) {
                return 150;
            }
            if (string.contains(BT_NAME_AIRBP)) {
                return 153;
            }
            if (string.contains(BT_NAME_LPW30)) {
                return 154;
            }
            if (string.contains(BT_NAME_LE_F2_PRO)) {
                return 163;
            }
            if (string.contains(BT_NAME_CM_TOUCH)) {
                return 165;
            }
            if (string.contains(BT_NAME_OXYFIT)) {
                if (!string.contains(BT_NAME_OXYFIT_WPS)) return 20;
                return 112;
            }
            if (string.contains(BT_NAME_LEPU_PO6)) {
                return 171;
            }
            if (string.contains(BT_NAME_LEPU_AED)) {
                return 172;
            }
            if (string.contains(BT_NAME_CPR_FEEDBACK)) {
                return 173;
            }
            if (string.contains(BT_NAME_CPR_01)) {
                return 201;
            }
            if (string.contains(BT_NAME_CPR_02)) {
                return 202;
            }
            if (string.contains(BT_NAME_SI_PO4)) {
                return 174;
            }
            if (string.contains(BT_NAME_BAND_WU)) {
                return 175;
            }
            if (string.contains(BT_NAME_M5)) {
                return 176;
            }
            if (string.contains(BT_NAME_BP2)) {
                if (string.contains(BT_NAME_BP2A)) {
                    if (!string.contains(BT_NAME_BP2A_NEXUS)) return 23;
                    return 188;
                }
                if (string.contains(BT_NAME_BP2B)) {
                    return 177;
                }
                if (string.contains(BT_NAME_BP2T)) {
                    return 31;
                }
                if (string.contains(BT_NAME_BP2W)) {
                    if (!string.contains(BT_NAME_LP_BP2W)) return 32;
                    return 52;
                }
                if (string.contains(BT_NAME_BP2V)) {
                    return 178;
                }
                if (!string.contains(BT_NAME_AURA_BP2)) return 19;
                return 192;
            }
            if (string.contains(BT_NAME_AED_BOX)) {
                return 179;
            }
            if (string.contains(BT_NAME_SHQO2_PRO)) {
                return 180;
            }
            if (string.contains(BT_NAME_PF10AW_ME)) {
                return 181;
            }
            if (string.contains(BT_NAME_BM10)) {
                return 182;
            }
            if (string.contains(BT_NAME_BP4_FLEX)) {
                return 189;
            }
            if (string.contains(BT_NAME_KS60FW)) {
                return 190;
            }
            if (string.contains(BT_NAME_DUAL_SPP)) {
                return 191;
            }
            if (string.contains(BT_NAME_MY_SS2501)) {
                return 194;
            }
            if (string.contains(BT_NAME_AITELE)) {
                return 198;
            }
            if (string.contains(BT_NAME_AIVIEW_VS)) {
                return 204;
            }
            if (string.contains(BT_NAME_ZH_SG)) {
                if (!string.contains(BT_NAME_ZH_SG_A606)) return 205;
                return 206;
            }
            if (string.contains(BT_NAME_WBP02)) {
                return 208;
            }
            if (string.contains(BT_NAME_T31)) {
                return 209;
            }
            if (string.contains(BT_NAME_BUZUD_CML)) {
                return 56;
            }
            if (string.contains(BT_NAME_IGATE)) {
                return 211;
            }
            if (string.contains(BT_NAME_LBM_1)) {
                return 212;
            }
            if (string.contains(BT_NAME_HDM3G)) {
                return 216;
            }
            if (string.split(" ").length == 0) {
                return 0;
            }
            string = string.split(" ")[0];
            string.hashCode();
            n = -1;
            int n3 = -1;
            switch (string.hashCode()) {
                case 1982143801: {
                    if (!string.equals(BT_NAME_BABY_O2)) break;
                    n3 = 1;
                    break;
                }
                case 1919427728: {
                    if (!string.equals(BT_NAME_VETCORDER)) break;
                    n3 = 2;
                    break;
                }
                case 1650881268: {
                    if (!string.equals(BT_NAME_PULSEBIT_EX)) break;
                    n3 = 3;
                    break;
                }
                case 1316915765: {
                    if (!string.equals(BT_NAME_BABYO2N)) break;
                    n3 = 4;
                    break;
                }
                case 1234341079: {
                    if (!string.equals(BT_NAME_MY_SCALE)) break;
                    n3 = 5;
                    break;
                }
                case 808533475: {
                    if (!string.equals(BT_NAME_BPM)) break;
                    n3 = 6;
                    break;
                }
                case 721714638: {
                    if (!string.equals(BT_NAME_LD_TECK)) break;
                    n3 = 7;
                    break;
                }
                case 648912778: {
                    if (!string.equals(BT_NAME_OXY_LINK)) break;
                    n3 = 8;
                    break;
                }
                case 648138208: {
                    if (!string.equals(BT_NAME_OXYRING)) break;
                    n3 = 9;
                    break;
                }
                case 82000784: {
                    if (!string.equals(BT_NAME_VTM01)) break;
                    n3 = 10;
                    break;
                }
                case 81489196: {
                    if (!string.equals(BT_NAME_ER1_N)) break;
                    n3 = 11;
                    break;
                }
                case 74524817: {
                    if (!string.equals(BT_NAME_RINGO2)) break;
                    n3 = 12;
                    break;
                }
                case 66393860: {
                    if (!string.equals(BT_NAME_DUOEK)) break;
                    n3 = 13;
                    break;
                }
                case 2332861: {
                    if (!string.equals(BT_NAME_LEM)) break;
                    n3 = 14;
                    break;
                }
                case 2045832: {
                    if (!string.equals(BT_NAME_BPW1)) break;
                    n3 = 15;
                    break;
                }
                case 78386: {
                    if (!string.equals(BT_NAME_OMP)) break;
                    n3 = 16;
                    break;
                }
                case 77552: {
                    if (!string.equals(BT_NAME_O2S)) break;
                    n3 = 17;
                    break;
                }
                case 77546: {
                    if (!string.equals(BT_NAME_O2M)) break;
                    n3 = 18;
                    break;
                }
                case 75566: {
                    if (!string.equals(BT_NAME_M12)) break;
                    n3 = 19;
                    break;
                }
                case 75228: {
                    if (!string.equals(BT_NAME_LDT)) break;
                    n3 = 20;
                    break;
                }
                case 68902: {
                    if (!string.equals(BT_NAME_ER3)) break;
                    n3 = 21;
                    break;
                }
                case 68464: {
                    if (!string.equals(BT_NAME_ECN)) break;
                    n3 = 22;
                    break;
                }
                case 66110: {
                    if (!string.equals(BT_NAME_BTP)) break;
                    n3 = 23;
                    break;
                }
                case 2499: {
                    if (!string.equals(BT_NAME_O2)) break;
                    n3 = 24;
                    break;
                }
                case 2226: {
                    if (!string.equals(BT_NAME_F8_SCALE)) break;
                    n3 = 25;
                    break;
                }
                case 2223: {
                    if (!string.equals(BT_NAME_F5_SCALE)) break;
                    n3 = 26;
                    break;
                }
                case 2222: {
                    if (!string.equals(BT_NAME_F4_SCALE)) break;
                    n3 = 27;
                    break;
                }
                case -232482540: {
                    if (!string.equals(BT_NAME_STATION)) break;
                    n3 = 28;
                    break;
                }
                case -458262854: {
                    if (!string.equals(BT_NAME_SPO2)) break;
                    n3 = 29;
                    break;
                }
                case -1157908451: {
                    if (!string.equals(BT_NAME_FHR)) break;
                    n3 = 30;
                    break;
                }
                case -1381521383: {
                    if (!string.equals(BT_NAME_OXY_SMART)) break;
                    n3 = 31;
                    break;
                }
                case -1707953758: {
                    if (!string.equals(BT_NAME_WEARO2)) break;
                    n3 = 32;
                    break;
                }
                case -1815897986: {
                    if (!string.equals(BT_NAME_SLEEPU)) break;
                    n3 = 33;
                    break;
                }
                case -1985057160: {
                    if (!string.equals(BT_NAME_SNO2)) break;
                    n3 = 34;
                    break;
                }
                case -2047719152: {
                    if (!string.equals(BT_NAME_KIDS_O2)) break;
                    n3 = 35;
                    break;
                }
            }
            switch (n3) {
                default: {
                    break block268;
                }
                case 1: {
                    n2 = 34;
                    break;
                }
                case 2: {
                    n2 = 33;
                    break;
                }
                case 3: {
                    n2 = 32;
                    break;
                }
                case 4: {
                    n2 = 31;
                    break;
                }
                case 5: {
                    n2 = 30;
                    break;
                }
                case 6: {
                    n2 = 29;
                    break;
                }
                case 7: {
                    n2 = 28;
                    break;
                }
                case 8: {
                    n2 = 27;
                    break;
                }
                case 9: {
                    n2 = 26;
                    break;
                }
                case 10: {
                    n2 = 25;
                    break;
                }
                case 11: {
                    n2 = 24;
                    break;
                }
                case 12: {
                    n2 = 23;
                    break;
                }
                case 13: {
                    n2 = 22;
                    break;
                }
                case 14: {
                    n2 = 21;
                    break;
                }
                case 15: {
                    n2 = 20;
                    break;
                }
                case 16: {
                    n2 = 19;
                    break;
                }
                case 17: {
                    n2 = 18;
                    break;
                }
                case 18: {
                    n2 = 17;
                    break;
                }
                case 19: {
                    n2 = 16;
                    break;
                }
                case 20: {
                    n2 = 15;
                    break;
                }
                case 21: {
                    n2 = 14;
                    break;
                }
                case 22: {
                    n2 = 13;
                    break;
                }
                case 23: {
                    n2 = 12;
                    break;
                }
                case 24: {
                    n2 = 11;
                    break;
                }
                case 25: {
                    n2 = 10;
                    break;
                }
                case 26: {
                    n2 = 9;
                    break;
                }
                case 27: {
                    n2 = 8;
                    break;
                }
                case 28: {
                    n2 = 7;
                    break;
                }
                case 29: {
                    n2 = 6;
                    break;
                }
                case 30: {
                    n2 = 5;
                    break;
                }
                case 31: {
                    n2 = 4;
                    break;
                }
                case 32: {
                    n2 = 3;
                    break;
                }
                case 33: {
                    n2 = 2;
                    break;
                }
                case 34: {
                    n2 = 1;
                    break;
                }
                case 35: {
                    n2 = 0;
                }
            }
            n = n2;
        }
        switch (n) {
            default: {
                return 0;
            }
            case 34: {
                return 13;
            }
            case 33: {
                return 45;
            }
            case 32: {
                return 9;
            }
            case 31: {
                return 29;
            }
            case 30: {
                return 40;
            }
            case 29: {
                return 26;
            }
            case 28: {
                return 215;
            }
            case 27: {
                return 10;
            }
            case 26: {
                return 63;
            }
            case 25: {
                return 103;
            }
            case 24: {
                return 16;
            }
            case 23: {
                return 48;
            }
            case 22: {
                return 8;
            }
            case 21: {
                return 27;
            }
            case 20: {
                return 46;
            }
            case 19: {
                return 213;
            }
            case 18: {
                return 170;
            }
            case 17: {
                return 25;
            }
            case 16: {
                return 152;
            }
            case 15: {
                return 214;
            }
            case 14: {
                return 95;
            }
            case 13: {
                return 110;
            }
            case 12: {
                return 105;
            }
            case 11: {
                return 1;
            }
            case 10: {
                return 53;
            }
            case 9: {
                return 62;
            }
            case 8: {
                return 47;
            }
            case 7: {
                return 34;
            }
            case 6: {
                return 3;
            }
            case 5: {
                return 28;
            }
            case 4: {
                return 14;
            }
            case 3: {
                return 5;
            }
            case 2: {
                return 6;
            }
            case 1: {
                return 2;
            }
            case 0: 
        }
        return 11;
    }

    public static String getDeviceName(int n) {
        switch (n) {
            default: {
                return "";
            }
            case 217: {
                return BT_NAME_O2RING_RE;
            }
            case 216: {
                return BT_NAME_HDM3G;
            }
            case 215: {
                return BT_NAME_LD_TECK;
            }
            case 214: {
                return BT_NAME_LDT;
            }
            case 213: {
                return BT_NAME_OMP;
            }
            case 212: {
                return BT_NAME_LBM_1;
            }
            case 211: {
                return BT_NAME_IGATE;
            }
            case 210: {
                return BT_NAME_ER1_SP;
            }
            case 209: {
                return BT_NAME_T31;
            }
            case 208: {
                return BT_NAME_WBP02;
            }
            case 207: {
                return BT_NAME_CHECKME_EX;
            }
            case 206: {
                return BT_NAME_ZH_SG_A606;
            }
            case 205: {
                return BT_NAME_ZH_SG;
            }
            case 204: {
                return BT_NAME_AIVIEW_VS;
            }
            case 203: {
                return BT_NAME_O2RINGF;
            }
            case 202: {
                return BT_NAME_CPR_02;
            }
            case 201: {
                return BT_NAME_CPR_01;
            }
            case 200: {
                return BT_NAME_R200;
            }
            case 199: {
                return BT_NAME_BBSM_S3;
            }
            case 198: {
                return BT_NAME_AITELE;
            }
            case 197: {
                return BT_NAME_JFK1001;
            }
            case 196: {
                return BT_NAME_HDM3D;
            }
            case 195: {
                return BT_NAME_BP3;
            }
            case 194: {
                return BT_NAME_MY_SS2501;
            }
            case 193: {
                return BT_NAME_JFR1001;
            }
            case 192: {
                return BT_NAME_AURA_BP2;
            }
            case 191: {
                return BT_NAME_DUAL_SPP;
            }
            case 190: {
                return BT_NAME_KS60FW;
            }
            case 189: {
                return BT_NAME_BP4_FLEX;
            }
            case 188: {
                return BT_NAME_BP2A_NEXUS;
            }
            case 187: {
                return BT_NAME_QC200;
            }
            case 186: {
                return BT_NAME_PC200;
            }
            case 185: {
                return BT_NAME_BBSM_BS1;
            }
            case 184: {
                return BT_NAME_LEPU_ER1;
            }
            case 183: {
                return BT_NAME_CHECKME_LITE_A;
            }
            case 182: {
                return BT_NAME_BM10;
            }
            case 181: {
                return BT_NAME_PF10AW_ME;
            }
            case 180: {
                return BT_NAME_SHQO2_PRO;
            }
            case 179: {
                return BT_NAME_AED_BOX;
            }
            case 178: {
                return BT_NAME_BP2V;
            }
            case 177: {
                return BT_NAME_BP2B;
            }
            case 176: {
                return BT_NAME_M5;
            }
            case 175: {
                return BT_NAME_BAND_WU;
            }
            case 174: {
                return BT_NAME_SI_PO4;
            }
            case 173: {
                return BT_NAME_CPR_FEEDBACK;
            }
            case 172: {
                return BT_NAME_LEPU_AED;
            }
            case 171: {
                return BT_NAME_LEPU_PO6;
            }
            case 170: {
                return BT_NAME_O2S;
            }
            case 169: {
                return BT_NAME_KCB;
            }
            case 168: {
                return BT_NAME_LEPU_ER2;
            }
            case 167: {
                return BT_NAME_BP3_B;
            }
            case 166: {
                return BT_NAME_LESCALE_F3;
            }
            case 165: {
                return BT_NAME_CM_TOUCH;
            }
            case 164: {
                return BT_NAME_BP3L;
            }
            case 163: {
                return BT_NAME_LE_F2_PRO;
            }
            case 162: {
                return BT_NAME_PC66B_VE;
            }
            case 161: {
                return BT_NAME_CHECKME_LP;
            }
            case 160: {
                return BT_NAME_LESCALE_F4L;
            }
            case 159: {
                return BT_NAME_BP3Z;
            }
            case 158: {
                return BT_NAME_BP3K;
            }
            case 157: {
                return BT_NAME_BP3H;
            }
            case 156: {
                return BT_NAME_BP3E;
            }
            case 155: {
                return BT_NAME_BP3C;
            }
            case 154: {
                return BT_NAME_LPW30;
            }
            case 153: {
                return BT_NAME_AIRBP;
            }
            case 152: {
                return BT_NAME_M12;
            }
            case 151: {
                return BT_NAME_LEPOD_PRO;
            }
            case 150: {
                return BT_NAME_CMB590611;
            }
            case 149: {
                return BT_NAME_ER2_S;
            }
            case 148: {
                return BT_NAME_ER1_L;
            }
            case 147: {
                return BT_NAME_ER1_W;
            }
            case 146: {
                return BT_NAME_ER1_H;
            }
            case 145: {
                return BT_NAME_ER1_S;
            }
            case 144: {
                return BT_NAME_S8_AW;
            }
            case 143: {
                return BT_NAME_BBSM_P1;
            }
            case 142: {
                return BT_NAME_TMB_2288;
            }
            case 141: {
                return BT_NAME_S5W_VU;
            }
            case 140: {
                return BT_NAME_POD_1W_WU;
            }
            case 139: {
                return BT_NAME_PO6B_WE;
            }
            case 138: {
                return BT_NAME_CMB590840;
            }
            case 137: {
                return BT_NAME_BP3G;
            }
            case 136: {
                return BT_NAME_BP3F;
            }
            case 135: {
                return BT_NAME_BP3D;
            }
            case 134: {
                return BT_NAME_PF10BW_VE;
            }
            case 133: {
                return BT_NAME_SA10AW_PU;
            }
            case 132: {
                return BT_NAME_BP3_C2;
            }
            case 131: {
                return BT_NAME_BP3_C1;
            }
            case 130: {
                return BT_NAME_SI_PO2;
            }
            case 129: {
                return BT_NAME_LESCALE_F4P;
            }
            case 128: {
                return BT_NAME_GM_300SNT_BLE;
            }
            case 127: {
                return BT_NAME_ER1S;
            }
            case 126: {
                return BT_NAME_PF_10BWS;
            }
            case 125: {
                return BT_NAME_TMB_2088;
            }
            case 124: {
                return BT_NAME_O2RING_S;
            }
            case 123: {
                return BT_NAME_PF_10AW_1;
            }
            case 122: {
                return BT_NAME_CMI_PC303;
            }
            case 121: {
                return BT_NAME_LESCALE_P3;
            }
            case 120: {
                return BT_NAME_SI_PO6;
            }
            case 119: {
                return BT_NAME_BP3B;
            }
            case 118: {
                return BT_NAME_BP3A;
            }
            case 117: {
                return BT_NAME_R11;
            }
            case 116: {
                return BT_NAME_R10;
            }
            case 115: {
                return BT_NAME_R21;
            }
            case 114: {
                return BT_NAME_CHECKME_POD_WPS;
            }
            case 113: {
                return BT_NAME_KIDS_O2_WPS;
            }
            case 112: {
                return BT_NAME_OXYFIT_WPS;
            }
            case 111: {
                return BT_NAME_GM_300SNT;
            }
            case 110: {
                return BT_NAME_ECN;
            }
            case 109: {
                return BT_NAME_PC_60NW_NO_SN;
            }
            case 108: {
                return BT_NAME_LERES;
            }
            case 107: {
                return BT_NAME_R20;
            }
            case 106: {
                return BT_NAME_S5_SCALE;
            }
            case 105: {
                return BT_NAME_BTP;
            }
            case 104: {
                return BT_NAME_PC200_BLE;
            }
            case 103: {
                return BT_NAME_VTM01;
            }
            case 102: {
                return BT_NAME_PC80B_BLE2;
            }
            case 101: {
                return BT_NAME_O2M_WPS;
            }
            case 100: {
                return BT_NAME_AP20_WPS;
            }
            case 99: {
                return BT_NAME_SP20_WPS;
            }
            case 98: {
                return BT_NAME_PC_60NW_WPS;
            }
            case 97: {
                return BT_NAME_PC_60NW_BLE;
            }
            case 96: {
                return BT_NAME_LEPOD;
            }
            case 95: {
                return BT_NAME_ER3;
            }
            case 94: {
                return BT_NAME_PC_300_BLE;
            }
            case 93: {
                return BT_NAME_SP20_BLE;
            }
            case 92: {
                return BT_NAME_PC80B_BLE;
            }
            case 91: {
                return BT_NAME_CHECKME;
            }
            case 90: {
                return BT_NAME_PF_20B;
            }
            case 89: {
                return BT_NAME_PF_20AW;
            }
            case 88: {
                return BT_NAME_PF_10BW1;
            }
            case 87: {
                return BT_NAME_PF_10BW;
            }
            case 86: {
                return BT_NAME_PF_10AW1;
            }
            case 85: {
                return BT_NAME_PF_10AW;
            }
            case 84: {
                return BT_NAME_S6W1;
            }
            case 83: {
                return BT_NAME_S7BW;
            }
            case 82: {
                return BT_NAME_BIOLAND_BGM;
            }
            case 81: {
                return BT_NAME_S7W;
            }
            case 80: {
                return BT_NAME_S6W;
            }
            case 79: {
                return BT_NAME_POCTOR_M3102;
            }
            case 78: {
                return BT_NAME_LPM311;
            }
            case 77: {
                return BT_NAME_LP_ER2;
            }
            case 76: {
                return BT_NAME_HHM4;
            }
            case 75: {
                return BT_NAME_HHM3;
            }
            case 74: {
                return BT_NAME_HHM2;
            }
            case 73: {
                return BT_NAME_HHM1;
            }
            case 72: {
                return BT_NAME_AI_S100;
            }
            case 71: {
                return BT_NAME_W12C;
            }
            case 70: {
                return BT_NAME_S5W;
            }
            case 69: {
                return BT_NAME_OXYU;
            }
            case 68: {
                return BT_NAME_LE_B1;
            }
            case 67: {
                return BT_NAME_LPRE;
            }
            case 66: {
                return BT_NAME_CMRING;
            }
            case 65: {
                return BT_NAME_BBSM_S2;
            }
            case 64: {
                return BT_NAME_BBSM_S1;
            }
            case 63: {
                return BT_NAME_OXYRING;
            }
            case 62: {
                return BT_NAME_F5_SCALE;
            }
            case 61: {
                return BT_NAME_CHECK_ADV;
            }
            case 60: {
                return BT_NAME_PC_60NW;
            }
            case 59: {
                return BT_NAME_LES1;
            }
            case 58: {
                return BT_NAME_PF_20;
            }
            case 57: {
                return BT_NAME_PF_10;
            }
            case 56: {
                return BT_NAME_CHECKME_LE;
            }
            case 55: {
                return BT_NAME_PC_300;
            }
            case 54: {
                return BT_NAME_PC_68B;
            }
            case 53: {
                return BT_NAME_F8_SCALE;
            }
            case 52: {
                return BT_NAME_LP_BP2W;
            }
            case 51: {
                return BT_NAME_SP20;
            }
            case 50: {
                return BT_NAME_VTM_AD5;
            }
            case 49: {
                return BT_NAME_KCA;
            }
            case 48: {
                return BT_NAME_RINGO2;
            }
            case 47: {
                return BT_NAME_F4_SCALE;
            }
            case 46: {
                return BT_NAME_BPW1;
            }
            case 45: {
                return BT_NAME_VETCORDER;
            }
            case 44: {
                return BT_NAME_LEW;
            }
            case 43: {
                return BT_NAME_PC80B;
            }
            case 42: {
                return BT_NAME_PC66B;
            }
            case 41: {
                return BT_NAME_AP20;
            }
            case 40: {
                return BT_NAME_MY_SCALE;
            }
            case 38: {
                return BT_NAME_PC_60B;
            }
            case 37: {
                return BT_NAME_POD_1W;
            }
            case 36: {
                return BT_NAME_PC_60NW_1;
            }
            case 35: {
                return BT_NAME_POD2B;
            }
            case 34: {
                return BT_NAME_STATION;
            }
            case 33: {
                return BT_NAME_DEVICES_ER2;
            }
            case 32: {
                return BT_NAME_BP2W;
            }
            case 31: {
                return BT_NAME_BP2T;
            }
            case 30: {
                return BT_NAME_PC60FW;
            }
            case 29: {
                return BT_NAME_BABYO2N;
            }
            case 28: {
                return BT_NAME_FHR;
            }
            case 27: {
                return BT_NAME_LEM;
            }
            case 26: {
                return BT_NAME_BPM;
            }
            case 25: {
                return BT_NAME_O2M;
            }
            case 24: {
                return BT_NAME_BODY_FAT;
            }
            case 23: {
                return BT_NAME_BP2A;
            }
            case 22: {
                return BT_NAME_CHECK_POD;
            }
            case 21: {
                return BT_NAME_VCOMIN;
            }
            case 20: {
                return BT_NAME_OXYFIT;
            }
            case 19: {
                return BT_NAME_BP2;
            }
            case 18: {
                return BT_NAME_AOJ20A;
            }
            case 17: {
                return BT_NAME_PC100;
            }
            case 16: {
                return BT_NAME_ER1_N;
            }
            case 15: {
                return BT_NAME_TV221U;
            }
            case 14: {
                return BT_NAME_OXY_SMART;
            }
            case 13: {
                return BT_NAME_BABY_O2;
            }
            case 12: {
                return FETAL_DEVICE_NAME;
            }
            case 11: {
                return BT_NAME_KIDS_O2;
            }
            case 10: {
                return BT_NAME_OXY_LINK;
            }
            case 9: {
                return BT_NAME_PULSEBIT_EX;
            }
            case 8: {
                return BT_NAME_DUOEK;
            }
            case 7: {
                return BT_NAME_ER1;
            }
            case 6: {
                return BT_NAME_SLEEPU;
            }
            case 5: {
                return BT_NAME_WEARO2;
            }
            case 4: {
                return BT_NAME_O2RING;
            }
            case 3: {
                return BT_NAME_SPO2;
            }
            case 2: {
                return BT_NAME_SNO2;
            }
            case 1: 
        }
        return BT_NAME_O2;
    }

    public static boolean isEncryptDevice(int n) {
        return ENCRYPT_DEVICES.contains(n);
    }

    public Bluetooth(int n, String string, BluetoothDevice bluetoothDevice, int n2) {
        this.model = n;
        if (string == null) {
            string = "";
        }
        this.name = string;
        this.device = bluetoothDevice;
        this.macAddr = bluetoothDevice.getAddress();
        this.rssi = n2;
    }

    private Bluetooth(Parcel parcel) {
        this.model = parcel.readInt();
        this.name = parcel.readString();
        this.device = (BluetoothDevice)parcel.readParcelable(Bluetooth.class.getClassLoader());
        this.macAddr = parcel.readString();
        this.rssi = parcel.readInt();
    }

    static {
        Integer n = 4;
        Integer n2 = 13;
        Integer n3 = 182;
        Integer n4 = 29;
        Integer n5 = 1;
        Integer n6 = 25;
        Integer n7 = 3;
        Integer n8 = 2;
        Integer n9 = 5;
        Integer n10 = 6;
        Integer n11 = 10;
        Integer n12 = 11;
        Integer n13 = 20;
        Integer n14 = 63;
        Integer n15 = 64;
        Integer n16 = 65;
        Integer n17 = 199;
        Integer n18 = 66;
        Integer n19 = 69;
        Integer n20 = 72;
        Integer n21 = 101;
        Integer n22 = 112;
        Integer n23 = 113;
        Integer n24 = 120;
        Integer n25 = 130;
        Integer n26 = 48;
        Integer n27 = 170;
        Integer n28 = 171;
        Integer n29 = 174;
        Integer n30 = 193;
        Integer n31 = 197;
        Integer n32 = 203;
        Integer n33 = 213;
        Integer n34 = 217;
        Integer n35 = 124;
        Integer n36 = 144;
        Integer n37 = 175;
        Integer n38 = 180;
        Integer n39 = 30;
        Integer n40 = 42;
        Integer n41 = 14;
        Integer n42 = 37;
        Integer n43 = 35;
        Integer n44 = 36;
        Integer n45 = 38;
        Integer n46 = 57;
        Integer n47 = 85;
        Integer n48 = 86;
        Integer n49 = 87;
        Integer n50 = 88;
        Integer n51 = 58;
        Integer n52 = 60;
        Integer n53 = 89;
        Integer n54 = 90;
        Integer n55 = 70;
        Integer n56 = 80;
        Integer n57 = 81;
        Integer n58 = 83;
        Integer n59 = 84;
        Integer n60 = 97;
        Integer n61 = 98;
        Integer n62 = 109;
        Integer n63 = 139;
        Integer n64 = 140;
        Integer n65 = 141;
        Integer n66 = 150;
        Integer n67 = 162;
        Integer n68 = 190;
        Integer n69 = 215;
        Integer n70 = 51;
        Integer n71 = 93;
        Integer n72 = 99;
        Object[] objectArray = new Integer[72];
        Object[] objectArray2 = objectArray;
        objectArray[0] = n;
        objectArray2[1] = n2;
        objectArray2[2] = n3;
        objectArray2[3] = n4;
        objectArray2[4] = n5;
        objectArray2[5] = n6;
        objectArray2[6] = n7;
        objectArray2[7] = n8;
        objectArray2[8] = n9;
        objectArray2[9] = n10;
        objectArray2[10] = n11;
        objectArray2[11] = n12;
        objectArray2[12] = n13;
        objectArray2[13] = n14;
        objectArray2[14] = n15;
        objectArray2[15] = n16;
        objectArray2[16] = n17;
        objectArray2[17] = n18;
        objectArray2[18] = n19;
        objectArray2[19] = n20;
        objectArray2[20] = n21;
        objectArray2[21] = n22;
        objectArray2[22] = n23;
        objectArray2[23] = n24;
        objectArray2[24] = n25;
        objectArray2[25] = n26;
        objectArray2[26] = n27;
        objectArray2[27] = n28;
        objectArray2[28] = n29;
        objectArray2[29] = n30;
        objectArray2[30] = n31;
        objectArray2[31] = n32;
        objectArray2[32] = n33;
        objectArray2[33] = n34;
        objectArray2[34] = n35;
        objectArray2[35] = n36;
        objectArray2[36] = n37;
        objectArray2[37] = n38;
        objectArray2[38] = n39;
        objectArray2[39] = n40;
        objectArray2[40] = n41;
        objectArray2[41] = n42;
        objectArray2[42] = n43;
        objectArray2[43] = n44;
        objectArray2[44] = n45;
        objectArray2[45] = n46;
        objectArray2[46] = n47;
        objectArray2[47] = n48;
        objectArray2[48] = n49;
        objectArray2[49] = n50;
        objectArray2[50] = n51;
        objectArray2[51] = n52;
        objectArray2[52] = n53;
        objectArray2[53] = n54;
        objectArray2[54] = n55;
        objectArray2[55] = n56;
        objectArray2[56] = n57;
        objectArray2[57] = n58;
        objectArray2[58] = n59;
        objectArray2[59] = n60;
        objectArray2[60] = n61;
        objectArray2[61] = n62;
        objectArray2[62] = n63;
        objectArray2[63] = n64;
        objectArray2[64] = n65;
        objectArray2[65] = n66;
        objectArray2[66] = n67;
        objectArray2[67] = n68;
        objectArray2[68] = n69;
        objectArray2[69] = n70;
        objectArray2[70] = n71;
        objectArray2[71] = n72;
        ENCRYPT_DEVICES = Set.of((Object[])objectArray2);
        CREATOR = new Parcelable.Creator<Bluetooth>(){

            public Bluetooth createFromParcel(Parcel parcel) {
                return new Bluetooth(parcel);
            }

            public Bluetooth[] newArray(int n) {
                return new Bluetooth[n];
            }
        };
    }

    public boolean equals(Object object) {
        if (object instanceof Bluetooth) {
            object = (Bluetooth)object;
            return this.name.equals(((Bluetooth)object).name) && this.macAddr.equals(((Bluetooth)object).getMacAddr());
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.model);
        parcel.writeString(this.name);
        parcel.writeParcelable((Parcelable)this.device, n);
        parcel.writeString(this.macAddr);
        parcel.writeInt(this.rssi);
    }

    public String toString() {
        return "Bluetooth{model=" + this.model + ", name='" + this.name + '\'' + ", device=" + this.device + ", macAddr='" + this.macAddr + '\'' + ", rssi=" + this.rssi + '}';
    }

    public String getMacAddr() {
        return this.macAddr;
    }

    public void setMacAddr(String string) {
        this.macAddr = string;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getModel() {
        return this.model;
    }

    public void setModel(int n) {
        this.model = n;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int n) {
        this.rssi = n;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface DEVICE_NAME {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface MODEL {
    }
}
