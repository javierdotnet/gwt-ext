/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.animation;

/**
 * Easing animation constants.
 *
 * @author Sanjiv Jivan
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
