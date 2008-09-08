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
 

package com.gwtext.client.state;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * CookieProvider configuration.
 *
 * @author Sanjiv Jivan
 */
public class CookieProviderConfig extends BaseConfig {

    /**
     * The path for which the cookie is active (defaults to root '/' which makes it active for all pages in the site).
     *
     * @param path the path
     */
    public void setPath(String path) {
        JavaScriptObjectHelper.setAttribute(jsObj, "path", path);
    }

    /**
     * The cookie expiration date (defaults to 7 days from now).
     *
     * @param days number of days
     */
    public void setExpires(int days) {
        Date now = new Date();
        long millis = now.getTime() + (1000 * 60 * 60 * 24 * days);
        JavaScriptObjectHelper.setAttribute(jsObj, "expires", millis);
    }

    /**
     * The domain to save the cookie for. Note that you cannot specify a different domain than your page is on, but you
     * can specify a sub-domain, or simply the domain itself like 'extjs.com' to include all sub-domains if you need to
     * access cookies across different sub-domains (defaults to null which uses the same domain the page is running on including the 'www' like 'www.extjs.com')
     *
     * @param domain the domain
     */
    public void setDomain(String domain) {
        JavaScriptObjectHelper.setAttribute(jsObj, "domain", domain);
    }

    /**
     * True if the site is using SSL (defaults to false).
     *
     * @param secure true if using SSL
     */
    public void setSecure(boolean secure) {
        JavaScriptObjectHelper.setAttribute(jsObj, "secure", secure);
    }
}
