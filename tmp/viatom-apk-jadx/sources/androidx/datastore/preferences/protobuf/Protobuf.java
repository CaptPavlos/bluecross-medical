package androidx.datastore.preferences.protobuf;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@CheckReturnValue
/* loaded from: classes.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    static boolean assumeLiteRuntime = false;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int schemaSize = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                schemaSize += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return schemaSize;
    }

    public <T> boolean isInitialized(T t) {
        return schemaFor((Protobuf) t).isInitialized(t);
    }

    public <T> void makeImmutable(T t) {
        schemaFor((Protobuf) t).makeImmutable(t);
    }

    public <T> void mergeFrom(T t, Reader reader) throws IOException {
        mergeFrom(t, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schemaCreateSchema = (Schema) this.schemaCache.get(cls);
        if (schemaCreateSchema == null) {
            schemaCreateSchema = this.schemaFactory.createSchema(cls);
            Schema<T> schema = (Schema<T>) registerSchema(cls, schemaCreateSchema);
            if (schema != null) {
                return schema;
            }
        }
        return schemaCreateSchema;
    }

    public <T> void writeTo(T t, Writer writer) throws IOException {
        schemaFor((Protobuf) t).writeTo(t, writer);
    }

    public <T> void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor((Protobuf) t).mergeFrom(t, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t) {
        return schemaFor((Class) t.getClass());
    }
}
