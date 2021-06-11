import java.util.HashMap;
import java.util.Map;

public class GamerMap {

    private Map<String, Integer> map;

    public GamerMap() {
        this.map = new HashMap<>();
    }

    public void add(String key, Integer value) {
        if (map.get(key) != null) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }

    public void remove(String key) {
        if (key.toLowerCase().equals("all")) {
            map = new HashMap<>();
        } else {
            map.remove(key);
        }
    }

    public void printBest() {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(1).forEach(e->  System.out.println("[" + e.getKey() + ":" + e.getValue() + "]"));
    }

    public void print() {
        map.forEach((key, value) -> System.out.println("[" + key + ":" + value + "]"));
    }
}
