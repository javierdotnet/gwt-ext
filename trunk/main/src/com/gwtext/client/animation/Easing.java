/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.animation;

/**
 * Easing animation constants.
 *
 * @see com.gwtext.client.core.AnimationConfig
 */
public class Easing {
    private String method;

    private Easing(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    /**
     * Backtracks slightly, then reverses direction, overshoots end, then reverses and comes back to end.
     */
    public static Easing BACK_BOTH = new Easing("backBoth");

    /**
     * Backtracks slightly, then reverses direction and moves to end.
     */
    public static Easing BACK_IN = new Easing("backIn");

    /**
     * Overshoots end, then reverses and comes back to end.
     */
    public static Easing BACK_OUT = new Easing("backOut");

    /**
     * Bounces off start and end.
     */
    public static Easing BOUNCE_BOTH = new Easing("bounceBoth");

    /**
     * Bounce off of start.
     */
    public static Easing BOUNCE_IN = new Easing("bounceIn");


    /**
     * Bounces off end.
     */
    public static Easing BOUNCE_OUT = new Easing("bounceOut");

    /**
     * Begins slowly and decelerates towards end. (quadratic)
     */
    public static Easing EASE_BOTH = new Easing("easeBoth");

    /**
     * Begins slowly and decelerates towards end. (quartic)
     */
    public static Easing EASE_BOTH_STRONG = new Easing("easeBothStrong");

    /**
     * Begins slowly and accelerates towards end. (quadratic)
     */
    public static Easing EASE_IN = new Easing("easeIn");

    /**
     * Begins slowly and accelerates towards end. (quartic)
     */
    public static Easing EASE_IN_STRONG = new Easing("easeInStrong");

    /**
     * Uniform speed between points.
     */
    public static Easing EASE_NONE = new Easing("easeNone");

    /**
     * Begins quickly and decelerates towards end. (quadratic)
     */
    public static Easing EASE_OUT = new Easing("easeOut");

    /**
     * Begins quickly and decelerates towards end. (quartic)
     */
    public static Easing EASE_OUT_STRONG = new Easing("easeOutStrong");

    /**
     * Snap both elastic effect.
     */
    public static Easing ELASTIC_BOTH = new Easing("elasticBoth");

    /**
     * Snap in elastic effect.
     */
    public static Easing ELASTIC_IN = new Easing("elasticIn");

    /**
     * Snap out elastic effect.
     */
    public static Easing ELASTIC_OUT = new Easing("elasticOut");
}
