/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.event;

import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.event.UIEventSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class UIEventBus
implements UIEventSubscriber {
    private Map<EventType, ConcurrentList<UIEventListener>> specificEventListeners = new ConcurrentHashMap<EventType, ConcurrentList<UIEventListener>>();
    private ConcurrentList<UIEventListener> allEventListeners = new ConcurrentList(this, new ArrayList());
    private boolean performingNotifySpecificEvent = false;
    private boolean performingAllNotify = false;
    private EventType currentNotifyEventType;
    private ConcurrentList<UIEventListener> allEventStagingAddList = new ConcurrentList(this, new ArrayList());
    private ConcurrentList<UIEventListener> specificEventStagingAddList = new ConcurrentList(this, new ArrayList());
    private ConcurrentList<UIEventListener> allEventStagingRemoveList = new ConcurrentList(this, new ArrayList());
    private ConcurrentList<UIEventListener> specificEventStagingRemoveList = new ConcurrentList(this, new ArrayList());

    public void cleanupMemory() {
        this.clearUIEventListeners();
        this.specificEventListeners = null;
        this.allEventListeners = null;
        this.allEventStagingAddList = null;
        this.specificEventStagingAddList = null;
        this.allEventStagingRemoveList = null;
        this.specificEventStagingRemoveList = null;
    }

    private void addToSpecificListenersList(UIEventListener uIEventListener, EventType eventType) {
        if (!this.performingNotifySpecificEvent || eventType != this.currentNotifyEventType) {
            ConcurrentList<UIEventListener> concurrentList = this.specificEventListeners.get((Object)eventType);
            if (concurrentList == null) {
                concurrentList = new ConcurrentList(this, new ArrayList());
                this.specificEventListeners.put(eventType, concurrentList);
            }
            concurrentList.add(uIEventListener);
        } else if (this.specificEventStagingRemoveList.contains(uIEventListener) && this.specificEventListeners.get((Object)eventType) != null && this.specificEventListeners.get((Object)eventType).contains(uIEventListener)) {
            this.specificEventStagingRemoveList.remove(uIEventListener);
        } else {
            this.specificEventStagingAddList.add(uIEventListener);
        }
    }

    private void addToAllListenersList(UIEventListener uIEventListener) {
        if (!this.performingAllNotify) {
            this.allEventListeners.add(uIEventListener);
        } else if (this.allEventStagingRemoveList.contains(uIEventListener) && this.allEventListeners.contains(uIEventListener)) {
            this.allEventStagingRemoveList.remove(uIEventListener);
        } else {
            this.allEventStagingAddList.add(uIEventListener);
        }
    }

    @Override
    public void subscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        for (EventType eventType : eventTypeArray) {
            this.addToSpecificListenersList(uIEventListener, eventType);
        }
    }

    @Override
    public void subscribeAllType(UIEventListener uIEventListener) {
        this.addToAllListenersList(uIEventListener);
    }

    private void removeFromSpecificListenersList(UIEventListener uIEventListener, EventType eventType) {
        if (!this.performingNotifySpecificEvent || eventType != this.currentNotifyEventType) {
            ConcurrentList<UIEventListener> concurrentList = this.specificEventListeners.get((Object)eventType);
            if (concurrentList != null) {
                concurrentList.remove(uIEventListener);
                if (concurrentList.size() == 0) {
                    this.specificEventListeners.remove((Object)eventType);
                }
            }
        } else if (this.specificEventStagingAddList.contains(uIEventListener)) {
            this.specificEventStagingAddList.remove(uIEventListener);
        } else {
            this.specificEventStagingRemoveList.add(uIEventListener);
        }
    }

    private void removeFromAllListenersList(UIEventListener uIEventListener) {
        if (!this.performingAllNotify) {
            this.allEventListeners.remove(uIEventListener);
        } else if (this.allEventStagingAddList.contains(uIEventListener)) {
            this.allEventStagingAddList.remove(uIEventListener);
        } else {
            this.allEventStagingRemoveList.add(uIEventListener);
        }
    }

    @Override
    public void unsubscribeAllType(UIEventListener uIEventListener) {
        this.removeFromAllListenersList(uIEventListener);
    }

    @Override
    public void unsubscribeAllListeners() {
        this.clearUIEventListeners();
    }

    @Override
    public void unsubscribe(UIEventListener uIEventListener, EventType ... eventTypeArray) {
        for (EventType eventType : eventTypeArray) {
            this.removeFromSpecificListenersList(uIEventListener, eventType);
        }
    }

    private void processStagingLists() {
        if (this.currentNotifyEventType != null) {
            ConcurrentList<UIEventListener> concurrentList = this.specificEventListeners.get((Object)this.currentNotifyEventType);
            if (concurrentList != null) {
                if (this.specificEventStagingAddList.size() > 0) {
                    concurrentList.addAll((Collection<UIEventListener>)this.specificEventStagingAddList);
                }
                if (this.specificEventStagingRemoveList.size() > 0) {
                    concurrentList.removeAll(this.specificEventStagingRemoveList);
                }
            } else {
                if (this.specificEventStagingRemoveList.size() > 0) {
                    this.specificEventStagingAddList.removeAll(this.specificEventStagingRemoveList);
                }
                if (this.specificEventStagingAddList.size() > 0) {
                    this.specificEventListeners.put(this.currentNotifyEventType, this.specificEventStagingAddList);
                }
            }
            if (this.allEventStagingAddList.size() > 0) {
                this.allEventListeners.addAll((Collection<UIEventListener>)this.allEventStagingAddList);
            }
            if (this.allEventStagingRemoveList.size() > 0) {
                this.allEventListeners.removeAll(this.allEventStagingRemoveList);
            }
        }
        this.allEventStagingAddList.clear();
        this.allEventStagingRemoveList.clear();
        this.specificEventStagingAddList.clear();
        this.specificEventStagingRemoveList.clear();
    }

    @Override
    public void notify(UIEvent uIEvent) {
        ConcurrentList<UIEventListener> concurrentList = this.specificEventListeners.get((Object)uIEvent.getType());
        if (concurrentList != null) {
            this.performingNotifySpecificEvent = true;
            this.currentNotifyEventType = uIEvent.getType();
            for (UIEventListener uIEventListener : concurrentList) {
                uIEventListener.onEvent(uIEvent);
            }
        }
        this.performingNotifySpecificEvent = false;
        if (this.allEventListeners.size() > 0) {
            this.performingAllNotify = true;
            for (UIEventListener uIEventListener : this.allEventListeners) {
                uIEventListener.onEvent(uIEvent);
            }
        }
        this.performingAllNotify = false;
        this.processStagingLists();
    }

    @Override
    public void clearUIEventListeners() {
        this.specificEventListeners.clear();
        this.allEventListeners.clear();
        this.allEventStagingAddList.clear();
        this.specificEventStagingAddList.clear();
        this.allEventStagingRemoveList.clear();
        this.specificEventStagingRemoveList.clear();
    }

    private class ConcurrentList<T>
    implements List<T> {
        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private final List<T> list;

        public ConcurrentList(UIEventBus uIEventBus, List<T> list) {
            this.list = list;
        }

        @Override
        public boolean remove(Object object) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.remove(object);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        @Override
        public boolean add(T t) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.add(t);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        @Override
        public void clear() {
            this.readWriteLock.writeLock().lock();
            try {
                this.list.clear();
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
        }

        @Override
        public int size() {
            this.readWriteLock.readLock().lock();
            try {
                int n = this.list.size();
                return n;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public boolean isEmpty() {
            this.readWriteLock.readLock().lock();
            try {
                boolean bl = this.list.isEmpty();
                return bl;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public boolean contains(Object object) {
            this.readWriteLock.readLock().lock();
            try {
                boolean bl = this.list.contains(object);
                return bl;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public T get(int n) {
            this.readWriteLock.readLock().lock();
            try {
                T t = this.list.get(n);
                return t;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public int indexOf(Object object) {
            this.readWriteLock.readLock().lock();
            try {
                int n = this.list.indexOf(object);
                return n;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public Object[] toArray() {
            this.readWriteLock.readLock().lock();
            try {
                Object[] objectArray = this.list.toArray();
                return objectArray;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            this.readWriteLock.readLock().lock();
            try {
                T[] TArray2 = this.list.toArray(TArray);
                return TArray2;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            this.readWriteLock.readLock().lock();
            try {
                boolean bl = this.list.containsAll(collection);
                return bl;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.addAll(collection);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean addAll(int n, Collection<? extends T> collection) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.addAll(n, collection);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.removeAll(collection);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean bl;
            this.readWriteLock.writeLock().lock();
            try {
                bl = this.list.retainAll(collection);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
            return bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public T set(int n, T t) {
            this.readWriteLock.writeLock().lock();
            try {
                T t2 = this.list.set(n, t);
                return t2;
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
        }

        @Override
        public void add(int n, T t) {
            this.readWriteLock.writeLock().lock();
            try {
                this.list.add(n, t);
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
        }

        @Override
        public T remove(int n) {
            this.readWriteLock.writeLock().lock();
            try {
                T t = this.list.remove(n);
                return t;
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
        }

        @Override
        public int lastIndexOf(Object object) {
            this.readWriteLock.readLock().lock();
            try {
                int n = this.list.lastIndexOf(object);
                return n;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public Iterator<T> iterator() {
            this.readWriteLock.readLock().lock();
            try {
                Iterator<T> iterator = new ArrayList<T>(this.list).iterator();
                return iterator;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public ListIterator<T> listIterator() {
            this.readWriteLock.readLock().lock();
            try {
                ListIterator<T> listIterator = new ArrayList<T>(this.list).listIterator();
                return listIterator;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        @Override
        public ListIterator<T> listIterator(int n) {
            this.readWriteLock.readLock().lock();
            try {
                ListIterator<T> listIterator = new ArrayList<T>(this.list).listIterator(n);
                return listIterator;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public List<T> subList(int n, int n2) {
            this.readWriteLock.readLock().lock();
            try {
                List<T> list = new ArrayList<T>(this.list).subList(n, n2);
                return list;
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }
    }
}

