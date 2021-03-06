package com.amlzq.android.viewer.common.data;

import com.amlzq.android.viewer.common.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Moment数据
 */
public class MomentData {

    /**
     * An array of sample items.
     */
    public static final List<MomentInfo> ITEMS = new ArrayList<MomentInfo>();

    /**
     * A map of sample items, by ID.
     */
    public static final Map<String, MomentInfo> ITEM_MAP = new HashMap<String, MomentInfo>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }

    private static void addItem(MomentInfo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MomentInfo createItem(int position) {
        MomentInfo info = new MomentInfo();
        info.id = "" + position;
        info.avatar = R.drawable.ic_avatar;
        info.name = "Item " + new DecimalFormat("00").format(position);
        info.text = makeDetails(position);
        if (position >= CommonData.getIppawardsCount()) {
            info.image = CommonData.IPPAWARDS[position - CommonData.getIppawardsCount()];
        } else {
            info.image = CommonData.IPPAWARDS[position];
        }
        info.time = System.currentTimeMillis();
        info.liked = position % 2 == 0;
        return info;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\nMore details information here.");
        return builder.toString();
    }

}
