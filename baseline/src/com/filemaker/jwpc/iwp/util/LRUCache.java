/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.util.LRUCacheEntry;
import com.filemaker.jwpc.iwp.util.LRUCacheValue;
import com.filemaker.jwpc.log.JWPCLogger;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LRUCache<Key, Value> {
    private static JWPCLogger logger = JWPCLogger.getLogger(LRUCache.class);
    private final int maxSize;
    private Map<Key, Value> map;
    private CopyOnWriteArrayList<Key> queue;
    private CacheEvictPolicy evictPolicy;

    public LRUCache(int n, CacheEvictPolicy cacheEvictPolicy) {
        this.maxSize = n;
        this.map = new ConcurrentHashMap<Key, Value>(this.maxSize);
        this.queue = new CopyOnWriteArrayList();
        this.evictPolicy = cacheEvictPolicy;
    }

    public boolean put(Key Key, Value Value) {
        Object object;
        if (Key == null || Value == null) {
            return false;
        }
        if (this.map.containsKey(Key)) {
            object = this.map.get(Key);
            if (!object.equals(Value)) {
                this.queue.remove(Key);
                this.destroyCacheEntry(this.map.remove(Key));
            } else {
                this.queue.remove(Key);
                this.queue.add(Key);
                return true;
            }
        }
        if (!this.queue.add(Key)) {
            return false;
        }
        this.map.put(Key, Value);
        switch (this.evictPolicy.ordinal()) {
            case 0: {
                while (this.queue.size() > this.maxSize) {
                    object = this.queue.remove(0);
                    if (object != null) {
                        this.destroyCacheEntry(this.map.remove(object));
                    }
                    object = null;
                }
                break;
            }
            case 1: {
                if (this.queue.size() <= this.maxSize) break;
                object = this.queue.get(0);
                Value Value2 = this.map.get(object);
                if (Value2 instanceof LRUCacheValue) {
                    LRUCacheValue lRUCacheValue = (LRUCacheValue)Value2;
                    if (!lRUCacheValue.canEvict()) break;
                    this.destroyCacheEntry(Value2);
                    this.queue.remove(0);
                    this.map.remove(object);
                    object = null;
                    Value2 = null;
                    break;
                }
                Key Key2 = this.queue.remove(0);
                if (Key2 != null) {
                    this.destroyCacheEntry(this.map.remove(Key2));
                }
                Key2 = null;
                break;
            }
        }
        return true;
    }

    public Value get(Key Key) {
        Value Value = this.map.get(Key);
        if (Value != null && this.queue.size() > 1) {
            this.queue.remove(Key);
            this.queue.add(Key);
        }
        return Value;
    }

    public boolean removeRef(Key Key) {
        Value Value = this.map.get(Key);
        if (Value instanceof LRUCacheValue) {
            LRUCacheValue lRUCacheValue = (LRUCacheValue)Value;
            lRUCacheValue.removeRef();
            if (this.queue.size() > 1) {
                int n = Math.min(this.queue.size(), 9);
                int n2 = lRUCacheValue.getRefCount();
                for (int i = 0; i < n; ++i) {
                    Key Key2 = this.queue.get(i);
                    LRUCacheValue lRUCacheValue2 = (LRUCacheValue)this.map.get(Key2);
                    if (lRUCacheValue2 == null) continue;
                    if (lRUCacheValue2.equals(lRUCacheValue)) break;
                    if (n2 == 0) {
                        if (lRUCacheValue2.getRefCount() != 0) {
                            this.queue.remove(Key);
                            this.queue.add(0, Key);
                            break;
                        }
                        LRUCacheValue lRUCacheValue3 = (LRUCacheValue)this.map.get(this.queue.get(1));
                        if (lRUCacheValue3 != null) {
                            int n3 = lRUCacheValue3.getRefCount();
                            if (n3 > 0) {
                                this.queue.remove(Key);
                                this.queue.add(1, Key);
                                break;
                            }
                            if (lRUCacheValue3.equals(lRUCacheValue)) break;
                            this.queue.remove(Key);
                            this.queue.add(2, Key);
                            break;
                        }
                        logger.debug("NPE for obj2 in LRUCache::removeRef()");
                        break;
                    }
                    if (n2 >= lRUCacheValue2.getRefCount()) continue;
                    this.queue.remove(Key);
                    this.queue.add(i, Key);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public Value remove(Key Key) {
        if (this.removeRef(Key)) {
            return null;
        }
        Value Value = this.map.get(Key);
        if (Value != null) {
            this.destroyCacheEntry(Value);
            this.map.remove(Key);
            this.queue.remove(Key);
            return Value;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int size() {
        return this.queue.size();
    }

    public int removeAll() {
        int n = 0;
        for (Value Value : this.map.values()) {
            ++n;
            this.destroyCacheEntry(Value);
        }
        this.queue.clear();
        this.map.clear();
        return n;
    }

    public Object[] GetKeys() {
        return this.queue.toArray();
    }

    public Collection<Value> GetValues() {
        return this.map.values();
    }

    protected void destroyCacheEntry(Value Value) {
        try {
            LRUCacheEntry lRUCacheEntry = null;
            if (Value instanceof LRUCacheValue) {
                LRUCacheValue lRUCacheValue = (LRUCacheValue)Value;
                lRUCacheEntry = (LRUCacheEntry)lRUCacheValue.getValObj();
            } else {
                lRUCacheEntry = (LRUCacheEntry)Value;
            }
            if (lRUCacheEntry != null) {
                lRUCacheEntry.cleanupMemory();
            }
        }
        catch (ClassCastException classCastException) {
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static enum CacheEvictPolicy {
        EVICTPOLICY_DEFAULT,
        EVICTPOLICY_CHECK_REF,
        EVICTPOLICY_IGNORE;

    }
}

