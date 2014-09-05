package org.firefallmarketplace.database.objects;

import org.firefallmarketplace.R;

public enum RarityType {
    COMMON(R.drawable.item_background_uncommon),
    UNCOMMON(R.drawable.item_background_uncommon),
    RARE(R.drawable.item_background_rare),
    EPIC(R.drawable.item_background_epic),
    PRTOTYPE(R.drawable.item_background_prototype);

    private int background;

    private RarityType(int background) {
        this.background = background;
    }

    public int getBackground() {
        return background;
    }

    public static RarityType getByName(String abbr) {
        for (RarityType v : values()) {
            if (RarityType.valueOf("BRIEF") == v) {
                return v;
            }
        }
        return null;
    }
}
