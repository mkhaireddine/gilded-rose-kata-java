package com.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.stream(items).forEach(item -> {
      switch (item.name) {
        case "Aged Brie":
          if (item.quality < 50) {
            item.quality = item.quality + 1;

          }
          item.sellIn = item.sellIn - 1;
          if (item.sellIn < 0) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
          break;
        case "Backstage passes to a TAFKAL80ETC concert":
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
          break;
        case "Sulfuras, Hand of Ragnaros":
          break;
        default:
          if (item.quality > 0) {
            item.quality = item.quality - 1;
          }

          item.sellIn = item.sellIn - 1;

          if (item.sellIn < 0) {
            if (item.quality > 0) {
              item.quality = item.quality - 1;
            }
          }
          break;
      }

    });
  }

}
