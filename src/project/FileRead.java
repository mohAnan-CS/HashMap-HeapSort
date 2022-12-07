package project;

public class FileRead {

    private String path;
    private int year;

    public FileRead(String path, int year) {
        this.path = path;
        this.year = year;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "[" +
                "path='" + path + '\'' +
                ", year='" + year + '\'' +
                ']';
    }
}
