package com.gildedrose;

public class BackstagePass extends Item {

  public BackstagePass(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  void updateItemQuality() {
    switch (name) {
      case "Aged Brie":
        if (quality < 50) {
          quality = quality + 1;

        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
          if (quality < 50) {
            quality = quality + 1;
          }
        }
        break;
      case "Backstage passes to a TAFKAL80ETC concert":
        if (quality < 50) {
          quality = quality + 1;

          if (sellIn < 11) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }

          if (sellIn < 6) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
          quality = 0;
        }
        break;
      case "Sulfuras, Hand of Ragnaros":
        break;
      default:
        if (quality > 0) {
          quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
          if (quality > 0) {
            quality = quality - 1;
          }
        }
        break;
    }

  }
}
