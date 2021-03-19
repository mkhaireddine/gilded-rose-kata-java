package com.gildedrose;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public static Item createItem(String name, int sellIn, int quality) {
    switch (name) {
      case "Aged Brie":
        return new AgedBrie(sellIn, quality);
      case "Backstage passes to a TAFKAL80ETC concert":
        return new BackstagePass(sellIn, quality);
      case "Sulfuras, Hand of Ragnaros":
        return new Sulfuras(sellIn, quality);
      default:
        return new Item(name, sellIn, quality);
    }
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  void updateAgedBrie() {
    if (quality < 50) {
      quality = quality + 1;

    }
    sellIn = sellIn - 1;
    if (sellIn < 0) {
      if (quality < 50) {
        quality = quality + 1;
      }
    }
  }

  void updateConcert() {
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
  }

  void updateDefault() {
    if (quality > 0) {
      quality = quality - 1;
    }

    sellIn = sellIn - 1;

    if (sellIn < 0) {
      if (quality > 0) {
        quality = quality - 1;
      }
    }
  }

  void updateItemQuality() {
    switch (name) {
      case "Aged Brie":
        updateAgedBrie();
        break;
      case "Backstage passes to a TAFKAL80ETC concert":
        updateConcert();
        break;
      case "Sulfuras, Hand of Ragnaros":
        break;
      default:
        updateDefault();
        break;
    }

  }
}
