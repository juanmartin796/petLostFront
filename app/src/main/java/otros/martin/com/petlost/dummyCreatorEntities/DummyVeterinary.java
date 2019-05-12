package otros.martin.com.petlost.dummyCreatorEntities;

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
public class DummyVeterinary {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

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
        return new DummyItem("Clinica veterinada " + position, "Colon 60, Resistencia Chaco " + position, makeDetails(position), makeUrlLogo(position));
    }

    private static String makeUrlLogo(int position) {
        if (position%6==0)
            return "https://us.123rf.com/450wm/maudis60/maudis601510/maudis60151000249/46911978-stock-vector-vector-sign-veterinary.jpg?ver=6";
        else if (position%5==0)
            return "https://crazyleafdesign.com/blog/wp-content/uploads/2016/10/f97fc514064819.5627cb35030ce-600x463.jpg";
        else if (position%4==0)
            return "https://dcassetcdn.com/design_img/3136635/606087/606087_17349263_3136635_50b8542e_image.png";
        else if (position%3==0)
            return "https://www.designevo.com/res/templates/thumb_small/animal-heart-and-cross.png";
        else if (position%2==0)
            return "https://image.shutterstock.com/image-vector/dogs-cats-pet-veterinary-care-260nw-1039080679.jpg";
        else
            return "https://image.shutterstock.com/image-vector/veterinary-symbol-vector-design-260nw-350701649.jpg";
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final String urlVerinaryLogo;

        public DummyItem(String id, String content, String details, String urlVerinaryLogo) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.urlVerinaryLogo = urlVerinaryLogo;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
