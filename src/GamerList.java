import java.util.ArrayList;
import java.util.List;

public class GamerList {

    private List<Gamer> list;
    private StringBuilder builder = new StringBuilder();

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
        Gamer bestGamer = list.get(0);
        for (Gamer gamer: list){
            if (gamer.scope> bestGamer.scope){
                bestGamer = gamer;
            }
        }
        System.out.println(bestGamer);
    }

    public void print() {
        for (Gamer gamer : list) {
            System.out.print(builder.append("[").append(gamer.name).append(":").append(gamer.scope).append("]"));
            builder.delete(0, builder.length());
        }
        System.out.println();
    }
}
