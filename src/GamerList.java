import java.util.*;

public class GamerList {

    private List<Gamer> list;

    public GamerList() {
        this.list = new ArrayList<>();
    }

    public void add(String key, Integer value) {
        list.add(new Gamer(key, value));
    }

    public void remove(String key) {
        if (key.toLowerCase().equals("all")) {
            list = new ArrayList<>();
        } else {
            Gamer removeGamer = list.get(Integer.parseInt(key));
            list.remove(removeGamer);
        }
    }

    public void printBest() {
        Gamer bestGamer = new Gamer(list.get(0).getName(), list.get(0).getScope());
        Map<String, Integer> map = new HashMap<>();
        for (Gamer gamer: list){
            if (map.get(gamer.getName()) != null) {
                map.put(gamer.getName(), map.get(gamer.getName()) + gamer.getScope());
            } else {
                map.put(gamer.getName(), gamer.getScope());
            }
            if (map.get(gamer.getName()) > bestGamer.getScope()){
                bestGamer.setName(gamer.getName());
                bestGamer.setScope(map.get(gamer.getName()));
            }
        }
        System.out.println(bestGamer);
    }

    public void print() {
        list.forEach(gamer -> System.out.println("[" + gamer.getName() + ":" + gamer.getScope() + "]"));
    }
}
