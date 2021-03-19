package com.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.stream(items).forEach(this::updateItemQuality);
  }

  private void updateItemQuality(Item item) {
    if (item.name.equals("Aged Brie")) {
      updateAgedBrie(item);
    } else {
      if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        updateConcert(item);
      } else {
        if (item.quality > 0) {
          if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
          }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
          if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
              item.quality = item.quality - 1;
            }
          }
        }
      }

    }

  }

  private void updateConcert(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;

      if (item.sellIn < 11) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }

      if (item.sellIn < 6) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < 0) {
      item.quality = 0;
    }
  }

  private void updateAgedBrie(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;

    }
    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
      }
    }
  }

}
