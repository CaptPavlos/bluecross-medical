package com.mbridge.msdk.newreward.player.imodel;

import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IMoreOfferModel extends IModel {
    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_initiate", reportType = "1")
    void onMoreOfferReq(String str);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_req_result", reportType = "1")
    void onMoreOfferRes(String str, String str2);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_req_result", reportType = "1")
    void onMoreOfferRes(String str, String str2, String str3);

    @ReportAnnotation.MethodInfo(isParameter = true, key = "m_mof_scenes", reportType = "1")
    void onMoreOfferShow(String str);
}
