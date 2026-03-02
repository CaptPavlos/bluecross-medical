package com.mbridge.msdk.e;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static int a(int i10, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return i10;
            }
            if (str.startsWith("errorCode: ") && str.length() > 16) {
                return Integer.parseInt(str.substring(11, 15));
            }
            if (str.equals("do not have sorceList")) {
                return i10 + 601;
            }
            if (str.equals("Network error,UnknownHostException")) {
                return i10 + TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
            }
            if (str.equals("v3 is timeout")) {
                return i10 + TypedValues.MotionType.TYPE_EASING;
            }
            if (!str.equals("Current unit is loading!") && !str.equals("current unit is loading")) {
                if (str.equals("Network error,I/O exception response null")) {
                    return i10 + TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO;
                }
                if (str.equals("Network error,ConnectException")) {
                    return i10 + TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO;
                }
                if (str.equals("Network error,socket timeout exception")) {
                    return i10 + TypedValues.MotionType.TYPE_PATHMOTION_ARC;
                }
                if (str.equals("Network error,disconnected network exception")) {
                    return i10 + TypedValues.MotionType.TYPE_DRAW_PATH;
                }
                if (str.equals("Network error,timeout exception")) {
                    return i10 + TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
                }
                if (str.startsWith("Network error,please check state code")) {
                    return i10 + TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
                }
                if (str.equals("Network error,I/O exception contents null")) {
                    return i10 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
                }
                if (str.equals("Network unknown error")) {
                    return i10 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
                }
                if (str.equals("Network error,I/O exception")) {
                    return i10 + 613;
                }
                if (str.equals("web env is not support")) {
                    return i10 + 614;
                }
                if (str.equals("Network error,unknown")) {
                    return i10 + 615;
                }
                if (str.equals("Network error，sslp exception")) {
                    return i10 + 616;
                }
                if (str.startsWith("Cast exception, return data")) {
                    return i10 + 617;
                }
                if (str.equals("REQUEST_TIMEOUT")) {
                    return i10 + TypedValues.TransitionType.TYPE_FROM;
                }
                if (str.startsWith("The server returns an exception")) {
                    return i10 + TypedValues.TransitionType.TYPE_TO;
                }
                if (!str.equals("APP ALREADY INSTALLED") && !str.equals("Need show campaign list is NULL!")) {
                    if (str.startsWith("load no ad")) {
                        return i10 + TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
                    }
                    if (str.equals("EXCEPTION_UNIT_NOT_FOUND_IN_APP")) {
                        return i10 + TypedValues.TransitionType.TYPE_INTERPOLATOR;
                    }
                    if (str.equals("EXCEPTION_UNIT_BIDDING_TYPE_ERROR")) {
                        return i10 + TypedValues.TransitionType.TYPE_STAGGERED;
                    }
                    if (str.equals("No video campaign")) {
                        return i10 + TypedValues.TransitionType.TYPE_TRANSITION_FLAGS;
                    }
                    if (str.equals("EXCEPTION_RETURN_EMPTY")) {
                        return i10 + 708;
                    }
                    if (str.equals("EXCEPTION_APP_PLATFORM_ERROR")) {
                        return i10 + 709;
                    }
                    if (str.equals("EXCEPTION_SERVICE_REQUEST_OS_VERSION_REQUIRED")) {
                        return i10 + 710;
                    }
                    if (str.equals("banner res load failed")) {
                        return i10 + 801;
                    }
                    if (str.equals("resource load timeout is tpl: false")) {
                        return i10 + 802;
                    }
                    if (str.startsWith("resource download failed")) {
                        return i10 + 803;
                    }
                    if (str.equals("temp preload success but isReady false")) {
                        return i10 + 804;
                    }
                    if (str.equals("temp resource download failed")) {
                        return i10 + 805;
                    }
                    if (str.equals("tpl temp resource download failed")) {
                        return i10 + 806;
                    }
                    if (str.equals("resource load timeout is tpl: true")) {
                        return i10 + 807;
                    }
                    if (!str.startsWith("https://") && !str.startsWith("http://")) {
                        return str.equals("mraid resource write fail") ? i10 + 809 : str.startsWith("data save failed:") ? i10 + 810 : str.equals("resource load timeout") ? i10 + 811 : str.startsWith("tpl temp preload failed") ? i10 + 812 : i10;
                    }
                    return i10 + 808;
                }
                return i10 + 703;
            }
            return i10 + TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR;
        } catch (Exception e) {
            e.printStackTrace();
            return i10;
        }
    }
}
