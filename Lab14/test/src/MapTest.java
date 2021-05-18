import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> mapHttpErrors = new HashMap<>();
        mapHttpErrors.put(400,"Bad Request");
        mapHttpErrors.put(301,"Moved Permanently");
        mapHttpErrors.put(404, "Not Found");
        mapHttpErrors.put(500,"Internal Sever Error");
        System.out.println(mapHttpErrors);
    }
}
