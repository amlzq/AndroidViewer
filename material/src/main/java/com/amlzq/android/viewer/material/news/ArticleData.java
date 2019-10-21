package com.amlzq.android.viewer.material.news;

import com.amlzq.android.viewer.data.CommonData;

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
public class ArticleData {

    /**
     * An array of sample items.
     */
    public static final List<ArticleItem> ITEMS = new ArrayList<ArticleItem>();

    /**
     * A map of sample items, by ID.
     */
    public static final Map<String, ArticleItem> ITEM_MAP = new HashMap<String, ArticleItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }

    private static void addItem(ArticleItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ArticleItem createItem(int position) {
        ArticleItem item = new ArticleItem();
        item.id = "" + position;
        item.title = "Item " + position;
        item.summary = makeDetails(position);
        item.time = System.currentTimeMillis();
        if (position >= CommonData.IPPAWARDS_COUNT) {
            item.cover = CommonData.IPPAWARDS[position - CommonData.IPPAWARDS_COUNT];
        } else {
            item.cover = CommonData.IPPAWARDS[position];
        }
        return item;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\nMore details information here.");
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ArticleItem {
        public String id;
        public String title;
        public String summary;
        public long time;
        public int cover;
    }

}
