/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.Slider$ValueOutOfBoundsException
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.ui.Slider
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Slider;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.ui.Slider;

public abstract class ToolbarMenuSlider
extends CssLayout {
    private static final String ITEM_WIDTH = "280px";
    private static final String ITEM_HEIGHT = "44px";
    private static final String TOOLBAR_SLIDER_CSS_SELECTOR_NAME = "toolbar-slider";
    private static final String TOOLBAR_SLIDERBAR_CSS_SELECTOR_NAME = "toolbar-slider-bar";
    protected final App app;
    private Slider slider;
    private int currentItem;
    private final SliderChangeListener sliderListener = new SliderChangeListener();

    public ToolbarMenuSlider(App app) {
        this.app = app;
        this.setWidth(ITEM_WIDTH);
        this.setHeight(ITEM_HEIGHT);
        this.setStyleName(TOOLBAR_SLIDER_CSS_SELECTOR_NAME);
        this.initComponents();
    }

    protected void initComponents() {
        this.slider = new Slider();
        this.slider.addStyleName(TOOLBAR_SLIDERBAR_CSS_SELECTOR_NAME);
        this.slider.setImmediate(true);
        this.slider.addValueChangeListener((Property.ValueChangeListener)this.sliderListener);
        this.slider.setDescription(IWPI18N.get(this.app, "SLIDER_NOTCH_TOOLTIP", new Object[0]), ContentMode.HTML);
        this.addComponent((Component)this.slider);
        if (AppServlet.isAriaCompliantControlEnabled()) {
            IWPUtilities.assignUniqueId(this.app, "b", (Component)this.slider);
            IWPUtilities.setAttributeById(this.app, this.slider.getId(), "role", "slider");
        }
    }

    protected abstract void changeItem(int var1);

    protected void processNumberOfItems(int n) {
        this.slider.removeValueChangeListener((Property.ValueChangeListener)this.sliderListener);
        if (n > 0) {
            this.slider.setMax((double)n);
        }
        if (n > 0) {
            this.slider.setMin(1.0);
            if (!this.isEnabled()) {
                this.setEnabled(true);
            }
            if (AppServlet.isAriaCompliantControlEnabled()) {
                IWPUtilities.setAttributeById(this.app, this.slider.getId(), "aria-valuemin", String.valueOf(1));
                IWPUtilities.setAttributeById(this.app, this.slider.getId(), "aria-valuemax", String.valueOf(n));
            }
        } else {
            this.slider.setMin(0.0);
            if (this.isEnabled()) {
                this.setEnabled(false);
            }
        }
        this.slider.addValueChangeListener((Property.ValueChangeListener)this.sliderListener);
    }

    protected void processItemNumber(int n) {
        try {
            Double d = Math.max(Math.min((double)n, this.slider.getMax()), this.slider.getMin());
            this.slider.setValue(d);
            if (AppServlet.isAriaCompliantControlEnabled()) {
                IWPUtilities.setAttributeById(this.app, this.slider.getId(), "aria-valuenow", String.valueOf(Math.round(d)));
            }
        }
        catch (Slider.ValueOutOfBoundsException valueOutOfBoundsException) {
            throw new AppRuntimeException(valueOutOfBoundsException);
        }
    }

    private class SliderChangeListener
    implements Property.ValueChangeListener {
        private SliderChangeListener() {
        }

        public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
            ToolbarMenuSlider.this.currentItem = (int)Double.parseDouble(valueChangeEvent.getProperty().getValue().toString());
            ToolbarMenuSlider.this.changeItem(ToolbarMenuSlider.this.currentItem);
        }
    }
}

