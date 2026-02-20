package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    private static final Class[] f = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> g = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private static String f2889j = "com.mbridge.msdk.dycreator.baseview.MB";

    /* renamed from: a, reason: collision with root package name */
    protected final Context f2890a;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0022a f2892c;

    /* renamed from: d, reason: collision with root package name */
    private b f2893d;
    private HashMap<String, Boolean> h;

    /* renamed from: i, reason: collision with root package name */
    private long f2894i;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2891b = true;
    private final Object[] e = new Object[2];

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0022a {
        View a(String str, Context context, AttributeSet attributeSet);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        boolean a(Class cls);
    }

    public a(Context context) {
        this.f2890a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View] */
    private View a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z9) {
        int next;
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
        synchronized (this.e) {
            try {
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.e[0] = this.f2890a;
                do {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                }
                String name = xmlPullParser.getName();
                System.out.println("**************************");
                System.out.println("Creating root view: " + name);
                System.out.println("**************************");
                if (!"merge".equals(name)) {
                    View viewA = a(name, attributeSetAsAttributeSet);
                    if (viewGroup != 0) {
                        System.out.println("Creating params from root: " + ((Object) viewGroup));
                        layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSetAsAttributeSet);
                        if (!z9) {
                            viewA.setLayoutParams(layoutParamsGenerateLayoutParams);
                        }
                    } else {
                        layoutParamsGenerateLayoutParams = null;
                    }
                    System.out.println("-----> start inflating children");
                    a(xmlPullParser, viewA, attributeSetAsAttributeSet);
                    System.out.println("-----> done inflating children");
                    if (viewGroup != 0 && z9) {
                        viewGroup.addView(viewA, layoutParamsGenerateLayoutParams);
                    }
                    if (viewGroup == 0 || !z9) {
                        viewGroup = viewA;
                    }
                } else {
                    if (viewGroup == 0 || !z9) {
                        throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                    }
                    a(xmlPullParser, (View) viewGroup, attributeSetAsAttributeSet);
                }
            } catch (IOException e) {
                InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e.getMessage());
                inflateException.initCause(e);
                throw inflateException;
            } catch (XmlPullParserException e3) {
                InflateException inflateException2 = new InflateException(e3.getMessage());
                inflateException2.initCause(e3);
                throw inflateException2;
            } finally {
            }
        }
        return viewGroup;
    }

    private void b(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
        int next2;
        if (!(view instanceof ViewGroup)) {
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, TtmlNode.TAG_LAYOUT, 0);
        if (attributeResourceValue == 0) {
            String attributeValue = attributeSet.getAttributeValue(null, TtmlNode.TAG_LAYOUT);
            if (attributeValue != null) {
                throw new InflateException(androidx.constraintlayout.core.widgets.analyzer.a.x("You must specifiy a valid layout reference. The layout ID ", attributeValue, " is not valid."));
            }
            throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
        }
        XmlResourceParser layout = this.f2890a.getResources().getLayout(attributeResourceValue);
        try {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
            do {
                next = layout.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
            }
            String name = layout.getName();
            if ("merge".equals(name)) {
                a(layout, view, attributeSetAsAttributeSet);
            } else {
                View viewA = a(name, attributeSetAsAttributeSet);
                ViewGroup viewGroup = (ViewGroup) view;
                try {
                    layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                } catch (RuntimeException unused) {
                    layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSetAsAttributeSet);
                    if (layoutParamsGenerateLayoutParams != null) {
                    }
                }
                if (layoutParamsGenerateLayoutParams != null) {
                    viewA.setLayoutParams(layoutParamsGenerateLayoutParams);
                }
                a(layout, viewA, attributeSetAsAttributeSet);
                viewGroup.addView(viewA);
            }
            layout.close();
            int depth = xmlPullParser.getDepth();
            do {
                next2 = xmlPullParser.next();
                if (next2 == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } while (next2 != 1);
        } catch (Throwable th) {
            layout.close();
            throw th;
        }
    }

    private void b(String str, String str2, AttributeSet attributeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(attributeSet.getPositionDescription());
        sb.append(": Class not allowed to be inflated ");
        if (str2 != null) {
            str = a3.a.C(str2, str);
        }
        sb.append(str);
        throw new InflateException(sb.toString());
    }

    private XmlPullParser a(String str) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        try {
            xmlPullParserNewPullParser.setInput(new FileInputStream(str), "utf-8");
            return xmlPullParserNewPullParser;
        } catch (Exception e) {
            e.printStackTrace();
            return xmlPullParserNewPullParser;
        }
    }

    private View a(String str, String str2, AttributeSet attributeSet) throws InflateException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        String str3;
        String str4;
        HashMap<String, Constructor> map = g;
        Constructor<?> constructor = map.get(str);
        Class<?> clsLoadClass = null;
        try {
            if (constructor == null) {
                ClassLoader classLoader = this.f2890a.getClassLoader();
                if (str2 != null) {
                    str4 = str2 + str;
                } else {
                    str4 = str;
                }
                clsLoadClass = classLoader.loadClass(str4);
                b bVar = this.f2893d;
                if (bVar != null && clsLoadClass != null && !bVar.a(clsLoadClass)) {
                    b(str, str2, attributeSet);
                }
                constructor = clsLoadClass.getConstructor(f);
                map.put(str, constructor);
            } else if (this.f2893d != null) {
                Boolean bool = this.h.get(str);
                if (bool == null) {
                    ClassLoader classLoader2 = this.f2890a.getClassLoader();
                    if (str2 != null) {
                        str3 = str2 + str;
                    } else {
                        str3 = str;
                    }
                    clsLoadClass = classLoader2.loadClass(str3);
                    boolean z9 = clsLoadClass != null && this.f2893d.a(clsLoadClass);
                    this.h.put(str, Boolean.valueOf(z9));
                    if (!z9) {
                        b(str, str2, attributeSet);
                    }
                } else if (bool.equals(Boolean.FALSE)) {
                    b(str, str2, attributeSet);
                }
            }
            Object[] objArr = this.e;
            objArr[1] = attributeSet;
            return (View) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (NoSuchMethodException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append(attributeSet.getPositionDescription());
            sb.append(": Error inflating class ");
            if (str2 != null) {
                str = a3.a.C(str2, str);
            }
            sb.append(str);
            InflateException inflateException = new InflateException(sb.toString());
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e7) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attributeSet.getPositionDescription());
            sb2.append(": Error inflating class ");
            sb2.append(clsLoadClass == null ? "<unknown>" : clsLoadClass.getName());
            InflateException inflateException2 = new InflateException(sb2.toString());
            inflateException2.initCause(e7);
            throw inflateException2;
        }
    }

    private View a(String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        System.out.println("******** Creating view: " + str);
        try {
            InterfaceC0022a interfaceC0022a = this.f2892c;
            View viewA = interfaceC0022a == null ? null : interfaceC0022a.a(str, this.f2890a, attributeSet);
            if (viewA == null) {
                if (-1 == str.indexOf(46)) {
                    if (!str.equals("MBStarLevelLayoutView") && !str.equals("LuckPan")) {
                        viewA = a(str, f2889j, attributeSet);
                    } else {
                        viewA = a(str, "", attributeSet);
                    }
                } else {
                    viewA = a(str, (String) null, attributeSet);
                }
            }
            System.out.println("Created view is: " + viewA);
            return viewA;
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e7) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e7);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next2 = xmlPullParser.next();
            if ((next2 == 3 && xmlPullParser.getDepth() <= depth) || next2 == 1) {
                return;
            }
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    view.requestFocus();
                    int depth2 = xmlPullParser.getDepth();
                    do {
                        next = xmlPullParser.next();
                        if (next != 3 || xmlPullParser.getDepth() > depth2) {
                        }
                    } while (next != 1);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() != 0) {
                        b(xmlPullParser, view, attributeSet);
                    } else {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                } else if (!"merge".equals(name)) {
                    View viewA = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    a(xmlPullParser, viewA, attributeSet);
                    viewGroup.addView(viewA, layoutParamsGenerateLayoutParams);
                } else {
                    throw new InflateException("<merge /> must be the root element");
                }
            }
        }
    }

    public final View a(String str, ViewGroup viewGroup) {
        boolean z9 = viewGroup != null;
        this.f2894i = System.currentTimeMillis();
        System.out.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z9);
    }
}
