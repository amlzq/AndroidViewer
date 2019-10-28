package com.amlzq.android.viewer.material.complex;

/**
 * 列表项类型
 * ItemType/ListItemType/MultiItemEntity
 */
public class ListItemType {

    public int itemTypeId = 0; // 类型ID
    public String itemTypeIcon = ""; // 类型图标资源地址
    public int itemTypeIconResId = 0; // 类型图标资源ID
    public String itemTypeName = ""; // 类型名称
    public boolean itemHasMore = false; // 是否有更多
    public boolean itemHasTopDivider = false; // 是否有顶部分隔器
    public boolean itemHasBottomDivider = false; // 是否有底部分隔器
    public int spanSize = 1; // 项的跨度

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemTypeIcon() {
        return itemTypeIcon;
    }

    public void setItemTypeIcon(String itemTypeIcon) {
        this.itemTypeIcon = itemTypeIcon;
    }

    public int getItemTypeIconResId() {
        return itemTypeIconResId;
    }

    public void setItemTypeIconResId(int itemTypeIconResId) {
        this.itemTypeIconResId = itemTypeIconResId;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public boolean isItemHasMore() {
        return itemHasMore;
    }

    public void setItemHasMore(boolean itemHasMore) {
        this.itemHasMore = itemHasMore;
    }

    public boolean isItemHasTopDivider() {
        return itemHasTopDivider;
    }

    public void setItemHasTopDivider(boolean itemHasTopDivider) {
        this.itemHasTopDivider = itemHasTopDivider;
    }

    public boolean isItemHasBottomDivider() {
        return itemHasBottomDivider;
    }

    public void setItemHasBottomDivider(boolean itemHasBottomDivider) {
        this.itemHasBottomDivider = itemHasBottomDivider;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

}