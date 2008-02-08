/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.state;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * CookieProvider configuration.
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
