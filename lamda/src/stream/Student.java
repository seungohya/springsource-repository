package stream;

public class Student {
    private String name;
    private int jumsu;

    public Student(String name, int jumsu) {
        this.name = name;
        this.jumsu = jumsu;
    }

    public int getJumsu() {
        return jumsu;
    }

    public void setJumsu(int jumsu) {
        this.jumsu = jumsu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", jumsu=" + jumsu + "]";
    }
}
