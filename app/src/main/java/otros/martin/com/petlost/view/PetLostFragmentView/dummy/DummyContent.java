package otros.martin.com.petlost.view.PetLostFragmentView.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 100;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem("Animalito "+ position, makeUrl(position));
    }

    private static String makeUrl(int position) {
        if (position%6==0)
            return "https://d17fnq9dkz9hgj.cloudfront.net/uploads/2012/11/92246580-lost-dog-632x475.jpg";
        else if (position%5==0)
            return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV0MyOIqpsZZQz6urBvUgxjZNUNHANcMPqwM4Papcx_Unw3wHpSg";
        else if (position%4==0)
            return "https://www.petmd.com/sites/default/files/petmd-lost-dog.jpg";
        else if (position%3==0)
            return "https://www.homeagain.com/static/images/articles/find-a-lost-dog-using-personality-clues.jpg";
        else if (position%2==0){
            return "https://www.dogingtonpost.com/wp-content/uploads/2018/06/LostDog_FB.jpg";
        } else
            return "https://www.edch.org.uk/sites/default/files/styles/2_column_header/public/lostdog.jpg?itok=wI8YLRCc";
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String urlImage;

        public DummyItem(String id, String urlImage) {
            this.id = id;
            this.urlImage = urlImage;
        }

        @Override
        public String toString() {
            return id;
        }
    }
}
