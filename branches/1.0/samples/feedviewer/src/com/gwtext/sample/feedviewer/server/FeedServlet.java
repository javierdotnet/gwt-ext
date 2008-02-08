package com.gwtext.sample.feedviewer.server;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class FeedServlet extends HttpServlet {

    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        String feedURL = request.getParameter("feed");

        URL rssFeed = new URL(feedURL);

        //google rss returs 403 if thinks robot is reading
        URLConnection conn = rssFeed.openConnection();
        conn.setRequestProperty("User-agent", "Mozilla/4.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));

        StringBuffer feedXML = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            feedXML.append(inputLine);
        }
        in.close();
        response.setContentType("text/xml");
        ServletOutputStream out = response.getOutputStream();
        String feedStr = feedXML.toString();
        feedStr = feedStr.replaceAll("dc:creator", "author");
        //some feeds dont have author
        if (feedStr.indexOf("authod") == -1) {
            feedStr = feedStr.replaceAll("</title>", "</title><author></author>");
        }
        out.write(feedStr.getBytes());
        out.flush();
    }
}