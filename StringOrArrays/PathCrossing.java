package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String key = x + "_" + y;
        set.add(key);

        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
            } else if (ch == 'W') {
                x--;
            } else if (ch == 'E') {
                x++;
            } else {
                y--;
            }
            key = x + "_" + y;
            if (set.contains(key)) {
                return true;
            }
            set.add(key);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NESWW"));
    }
}
