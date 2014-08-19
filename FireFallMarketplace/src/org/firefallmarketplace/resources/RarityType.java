package org.firefallmarketplace.resources;

import org.firefallmarketplace.R;

public enum RarityType {
    COMMON {
        @Override
        public int getBackground() {
            return R.drawable.item_background_common;
        }
    },
    UNCOMMON {
        @Override
        public int getBackground() {
            return R.drawable.item_background_uncommon;
        }
    },
    RARE {
        @Override
        public int getBackground() {
            return R.drawable.item_background_rare;
        }
    },
    EPIC {
        @Override
        public int getBackground() {
            return R.drawable.item_background_epic;
        }
    },
    PRTOTYPE {
        @Override
        public int getBackground() {
            return R.drawable.item_background_prototype;
        }
    };

    public abstract int getBackground();
}
