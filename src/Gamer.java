public class Gamer {
    String name;
    Integer scope;

    public Gamer(String name, Integer scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return name + ' ' + scope;
    }
}
