package da.Util;

import com.sun.org.apache.xpath.internal.CachedXPathAPI;

import java.io.File;
import java.io.IOException;

public class Desktop {
    // 获取当前系统桌面扩展

    private static java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

    public static boolean OpenBrowser(String url) {
        try {
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                java.net.URI uri = java.net.URI.create(url);
                desktop.browse(uri);
                return true;
            } else
                return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static void EditFile(String filename) {
        try {
            File file = new File(filename);
            desktop.edit(file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void OpenFile(String filename) {
        File file = new File(filename);
        try {
            desktop.open(file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void PrintFile(String filename) {
        File file = new File(filename);
        try {
            desktop.edit(file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
