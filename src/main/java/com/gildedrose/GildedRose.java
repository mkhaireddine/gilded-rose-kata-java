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
    switch (item.name) {
      case "Aged Brie":
        updateAgedBrie(item);
        break;
      case "Backstage passes to a TAFKAL80ETC concert":
        updateConcert(item);
        break;
      case "Sulfuras, Hand of Ragnaros":
        break;
      default:
        updateDefault(item);
        break;
    }

  }

  private void updateDefault(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < 0) {
      if (item.quality > 0) {
        item.quality = item.quality - 1;
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
