## Compiling from Source ##

### Checking Out the Source from Subversion ###

Checking out the GWT-Ext source is most useful if you plan to compile GWT-Ext yourself. The pre-built GWT-Ext distribution already contains all the Java source, so you don't actually need to check it out from the repository just to debug through it. Just tweak your IDE to read source from the GWT-Ext jars.

GWT-Ext is hosted on [Google Code](http://code.google.com/hosting/) project hosting, so you check out the source for GWT-Ext using a Subversion client as you would for any other project hosted on Google Code:

` svn checkout http://gwt-ext.googlecode.com/svn/trunk/ trunk `

The [project source code access page](http://code.google.com/p/gwt-ext/source) has additional instructions for browsing the [source online](http://gwt-ext.googlecode.com/svn/) or [getting a Subversion client](http://subversion.tigris.org/links.html#clients) if you don't already have one.

Here's a good writeup if you're using Eclipse : http://wiki.oreade.nl/Wiki.jsp?page=GwtExtSubversionDownloadCompile.

### Compiling from Source ###

Everything is Java source that can be built with the included GWT-Ext [Ant](http://ant.apache.org/) build files.

  * Install [Ant 1.6.5  http://ant.apache.org/bindownload.cgi](Apache.md) or later. We'll assume that the ant command is in your path.

  * Check out the GWT-Ext prerequisite tools and third-party libraries:
> > ` ~/gwt-ext$ svn checkout http://gwt-ext.googlecode.com/svn/tools/ tools `

  * Check out the GWT-Ext source:
> > ` ~/gwt-ext$ svn checkout http://gwt-ext.googlecode.com/svn/trunk/ trunk `

  * Switch to the directory into which you checked out the GWT-Ext source. Let's assume you checked it out into ~/gwt-ext/trunk. Make sure you're in that directory..
> > ` ~/gwt-ext$ cd ~/gwt-ext/trunk `
> > then just invoke Ant
> > > ` ant  `

  * The GWT-Ext build creates a binary distribution in the build/dist  subdirectory of the source root directory. In this example, the distributions would be in ~/gwt-ext/trunk/build.

### Testing ###
  * To perform the tests, simply run

> > ` ant test `
> > and verify that there are no failures.


### Ant JUnit Issues ###
There is a problem, detailed at ant.apache.org, where ant cannot find the JUnit classes. The simple workaround is to either:
  * Delete ant-junit.jar from the ant lib directory (for example, /usr/share/ant/lib/)
  * Copy junit.jar into your ant lib directory

### Ant XSLT issues ###
If you get an error like the one below, please remove the file {ANT\_HOME}\lib\xercesImpl.jar from your Ant installation as the copy of Xerces distrbuted with certain versions on Ant causes conflicts.

```
[java] FATAL ERROR:  'Could not compile stylesheet'

BUILD FAILED
C:\java\gwt-ext-svn\trunk\build.xml:35: The following error occurred while executing this line:
C:\java\gwt-ext-svn\trunk\build.xml:15: The following error occurred while executing this line:
C:\java\gwt-ext-svn\trunk\doc\build.xml:63: java.lang.RuntimeException: Unable to complete the xslt tranform

```