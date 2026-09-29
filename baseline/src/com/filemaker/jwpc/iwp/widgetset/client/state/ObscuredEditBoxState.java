/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 */
package com.filemaker.jwpc.iwp.widgetset.client.state;

import com.filemaker.jwpc.iwp.widgetset.client.state.EditBoxState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class ObscuredEditBoxState
extends EditBoxState {
    @DelegateToWidget
    public int oebs = 0;
    @DelegateToWidget
    public String obscuredEditBoxDescription;

    public static final class BooleanState
    extends Enum<BooleanState> {
        private static final /* synthetic */ BooleanState[] $VALUES;

        public static BooleanState[] values() {
            return (BooleanState[])$VALUES.clone();
        }

        public static BooleanState valueOf(String string) {
            return Enum.valueOf(BooleanState.class, string);
        }

        private static /* synthetic */ BooleanState[] $values() {
            return new BooleanState[0];
        }

        static {
            $VALUES = BooleanState.$values();
        }
    }
}

