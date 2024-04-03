package ru.sgu;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class Subtask2 {
    private String path;
    private String target;

    private void inputData() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название директории (относительный путь от запуска программы) и целевую строку: ");
        path = in.next();
        target = in.next();

        File f = new File(path);
        if (!f.exists())
            throw new FileNotFoundException("\nДиректория " + path + " не найдена!\n");
        if (!f.isDirectory())
            throw new FileNotFoundException("\nФайл " + path + " не является директорией!\n");

        in.close();
    }

    private void findTargetFile(String path, ZipOutputStream zout) throws IOException {
        File f = new File(path);
        String[] pathDirList = f.list();

        for (String file : pathDirList) {;
            String newFile = path + File.separator + file;

            File f1 = new File(newFile);
            if (f1.isFile()) {
                if (newFile.toLowerCase().contains(target)) {
                    String fileWithoutTopDir = newFile.replace(this.path + File.separator, "");
                    ZipEntry entry = new ZipEntry(fileWithoutTopDir);
                    zout.putNextEntry(entry);

                    FileInputStream fis = new FileInputStream(newFile);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                }
            }
            else if (newFile.toLowerCase().contains(target)) {
                Files.walkFileTree(f1.toPath(), new MyFileVisitor(this.path, zout));
            }
            else
                findTargetFile(newFile, zout);
        }
    }

    public void run() {
        try {
            inputData();

            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(target + ".zip"));
            findTargetFile(path, zout);
            zout.close();
            System.out.println("Архив " + target + ".zip успешно создан");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Subtask2 subtask2 = new Subtask2();
        subtask2.run();
    }
}
