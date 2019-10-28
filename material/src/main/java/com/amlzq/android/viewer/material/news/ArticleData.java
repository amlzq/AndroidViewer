package com.amlzq.android.viewer.material.news;

import com.amlzq.android.viewer.data.CommonData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章数据
 */
public class ArticleData {

    /**
     * An array of sample items.
     */
    private static final List<ArticleItem> ITEMS = new ArrayList<ArticleItem>();

    /**
     * A map of sample items, by ID.
     */
    public static final Map<String, ArticleItem> ITEM_MAP = new HashMap<String, ArticleItem>();

    private static final int COUNT = 25;

    public static List<ArticleItem> generateData() {
        // Add some sample items.
        return generateData(COUNT, VIEW_TYPE_LINEAR);
    }

    public static List<ArticleItem> generateData(int count, String viewType) {
        // Add some sample items.
        ITEMS.clear();
        for (int i = 1; i <= count; i++) {
            addItem(createItem(i, viewType));
        }
        return ITEMS;
    }

    private static void addItem(ArticleItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ArticleItem createItem(int position, String viewType) {
        ArticleItem item = new ArticleItem();
        item.id = "" + position;
        item.title = "Item " + position;
        item.summary = makeDetails(position);
        item.time = System.currentTimeMillis();
        if (position >= CommonData.getIppawardsCount()) {
            item.cover = CommonData.IPPAWARDS[position - CommonData.getIppawardsCount()];
        } else {
            item.cover = CommonData.IPPAWARDS[position];
        }
        item.viewType = viewType;
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
        public String viewType; // [linear,grid,staggered,flexbox]
    }

    public static final String VIEW_TYPE_LINEAR = "linear"; //
    public static final String VIEW_TYPE_GRID = "grid"; //
    public static final String VIEW_TYPE_STAGGERED = "staggered"; //
    public static final String VIEW_TYPE_FLEXBOX = "flexbox"; //

}
