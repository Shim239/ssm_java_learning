package Lesson11;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class SearchFiles {
    Path path = Paths.get("C:\\Users\\shimg\\IdeaProjects\\ssm_java_learning\\files");

    Collection<File> files = org.apache.commons.io.FileUtils.listFiles
            (new File(String.valueOf(path)), new String[]{"log"}, true);

    public void getFiles() {
    }

    public void setFiles(Collection<File> files) {
        this.files = files;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
