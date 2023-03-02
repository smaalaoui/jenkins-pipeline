package m2i.formation.utils;

import m2i.formation.Hotel;

import java.util.List;

public class CollectionUtils {

    public static Integer calculateSize(List<Hotel> list) {
        return list.size() * 2;
    }

}
