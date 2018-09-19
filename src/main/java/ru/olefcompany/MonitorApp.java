package ru.olefcompany;

import org.hyperic.sigar.*;
import java.io.File;


public class MonitorApp {
    public static void main(String[] args) throws SigarException {
        System.setProperty("java.library.path", "./lib");
        StringBuilder sb = new StringBuilder();
        Sigar sigar = new Sigar();
        CpuInfo cpu = sigar.getCpuInfoList()[0];
        Mem memory = sigar.getMem();
        sb.append("Info \n");
        sb.append("Core model: " + cpu.getVendor() + " " +cpu.getModel()+"\n");
        sb.append("Cores: " + cpu.getTotalCores()+"\n");
        sb.append("RAM: "+memory.getRam()/1000 + " Gb"+"\n");
        sb.append("OS: "+System.getProperty("os.name")+"\n");
        for (FileSystem hdd: sigar.getFileSystemList()) {
            File file = new File(hdd.getDevName());
            sb.append("HDD "+hdd.getDevName()+" Total space: "+file.getTotalSpace()+" bytes \n");
        }
        System.out.println(sb);
    }
}
