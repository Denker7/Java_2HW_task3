public class Gamer {
    private String name;
    private Integer scope;

    public Gamer(String name, Integer scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return name + ' ' + scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}
