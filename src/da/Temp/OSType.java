package da.Temp;

import da.Util.OSinfo;

public class OSType {
    public static void main(String args[]) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(OSinfo.isLinux());
        System.out.println(OSinfo.isWindows());
    }
}
