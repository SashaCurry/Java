package ru.sgu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private String path;
    ZipOutputStream zout;

    public MyFileVisitor(String path, ZipOutputStream zout) {
        this.path = path;
        this.zout = zout;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileWithoutTopDir = file.toString().replace(path + File.separator, "");
        ZipEntry entry = new ZipEntry(fileWithoutTopDir);
        zout.putNextEntry(entry);

        FileInputStream fis = new FileInputStream(file.toFile());
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();

        return FileVisitResult.CONTINUE;
    }
}