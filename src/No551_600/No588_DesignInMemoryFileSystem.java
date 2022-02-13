package No551_600;

import java.util.*;

public class No588_DesignInMemoryFileSystem {

    File root;

    public No588_DesignInMemoryFileSystem() {
        this.root = new File();
    }

    public List<String> ls(String path) {
        File f = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")){
            String[] d = path.split("/");
            for(int index = 1; index < d.length; index++){
                f = f.files.get(d[index]);
            }
            if(f.isFile){
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> resFiles = new ArrayList<>(f.files.keySet());
        Collections.sort(resFiles);
        return resFiles;
    }

    public void mkdir(String path) {
        File f = root;
        String[] d = path.split("/");

        for(int index = 1; index < d.length; index++){
            if(!f.files.containsKey(d[index])){
                f.files.put(d[index], new File());
            }
            f = f.files.get(d[index]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File f = root;
        String[] d = filePath.split("/");

        for(int index = 1; index < d.length - 1; index++){
            if(!f.files.containsKey(d[index])){
                f.files.put(d[index], new File());
            }
            f = f.files.get(d[index]);
        }

        if(!f.files.containsKey(d[d.length - 1])){
            f.files.put(d[d.length - 1], new File());
        }

        f = f.files.get(d[d.length - 1]);
        f.isFile = true;
        f.content = f.content + content;
    }

    public String readContentFromFile(String filePath) {
        File f = root;
        String[] d = filePath.split("/");
        for(int index = 1; index <= d.length - 1; index++){
            if(!f.files.containsKey(d[index])){
                return "";
            }
            f = f.files.get(d[index]);
        }
        if(!f.isFile){
            return "";
        }
        return f.content;
    }

    static class File{
        boolean isFile = false;
        Map<String, File> files = new HashMap<>();
        String content = "";
    }
}
