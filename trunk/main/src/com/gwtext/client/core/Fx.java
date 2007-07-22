/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.gwtext.client.core;

//API returns Fx and not Element because adding not Fx methosd to the chain can result in
//unexpected side effects See http://extjs.com/forum/showthread.php?t=2647
public interface Fx {

    //Ext Fx API's
    Fx fadeIn();

    Fx fadeIn(FxConfig config);

    Fx fadeOut();

    Fx fadeOut(FxConfig config);

    Fx frame();

    Fx frame(String color, int count, FxConfig config);

    Fx ghost();

    Fx ghost(String anchor, FxConfig config);

    boolean hasActiveFx();

    boolean hasFxBlock();

    Fx highlight();

    Fx highlight(String color, FxConfig config);

    Fx highlight(String color, String attr, String endColor, FxConfig config);

    Fx pause(int seconds);

    Fx puff();

    Fx puff(FxConfig config);

    Fx scale(int width, int height);

    Fx scale(int width, int height, FxConfig config);

    Fx sequenceFx();

    Fx shift(int x, int y, int width, int height, FxConfig config);

    Fx slideIn();

    Fx slideIn(String anchor, FxConfig config);

    Fx slideOut();

    Fx slideOut(String anchor, FxConfig config);

    Fx stopFx();

    Fx switchOff();

    Fx switchOff(FxConfig config);

    Fx syncFx();
}
