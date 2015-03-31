**Please go to [http://www.gwt-ext.com/wiki](http://www.gwt-ext.com/wiki) for the GWT-Ext 2.0 Getting Started Guide.**


# Getting Started with GWT-Ext 0.9 #

A guide to using GWT-Ext in your GWT application. You must be familiar with the basics of how GWT works. If you're new to GWT, please read the GWT [Getting Started Guide](http://code.google.com/webtoolkit/gettingstarted.html) first.

# Details #

  * Download the latest GWT-Ext jar file. Add it you your classpath just like you normally add the gwt-user.jar file in your classpath for compiling and running your app.

> Add the line

> `<inherits name='com.gwtext.GwtExt'/>`

> to your GWT application module file.

  * Download the appropriate version of Ext from [here](http://extjs.com/download). Check the release notes of GWT-Ext for the supported version of Ext. You will need to include the relevant Ext Javascript and resources (like CSS and images) under the "public" directory of your GWT application. Ext comes with a build tool that allows you to select the components that you're using in your app and will custom build a single compressed Javascript file with only the relevant code. However I would suggest you start off with including the entire Ext Javascript and resources in your "public" directory and once you get everything working and ready to deploy you can worry about minifying Ext to only the required Javascript and CSS. You do this by copying  **ext-all.js** and the entire **resources** and **adapter** directories from the Ext distribution into a directory under your "public" directory. For example copy the files to **/main/src/com/foo/public/js/ext/**

  * You now need to include the Ext Javascript files and CSS in your applicaitons GWT host page (like /main/src/com/foo/client/public/MyApp.html).

```
<html>
<head>
    <title>My App</title>
    <meta name='gwt:module' content='com.foo.MyApp'>
    <link rel=stylesheet href="MyApp.css">

    <link rel="stylesheet" type="text/css" href="js/ext/resources/css/ext-all.css"/>
    <link rel="stylesheet" type="text/css" href="js/ext/resources/css/xtheme-aero.css" />

    <script type="text/javascript" src="js/ext/adapter/yui/yui-utilities.js"></script>
    <script type="text/javascript" src="js/ext/adapter/yui/ext-yui-adapter.js"></script>
    <script type="text/javascript" src="js/ext/ext-all.js"></script>

</head>
<body class="xtheme-aero">
<script language="javascript" src="gwt.js"></script>
<iframe id="__gwt_historyFrame" style="width:0;height:0;border:0"></iframe>

</body>
</html>

```

> As I mentioned earlier, I would suggest that you include the full version of Ext's  Javascript file **ext-all.js** and CSS file **ext-all.css** during developement. Once you get started and are familiar with how things work, you can look into selectively including only the required Ext Javascript and CSS files.

  * Thats it, you should now be able to build and run you app that uses GWT-Ext API's. Take a look at the code of the samples that are available in the GWT-Ext bundle.