package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.jupiter.api.Test;

@UseReporter(IntelliJReporter.class)
class GildedRoseTest {

  @Test
  void updateQuality() {
    String itemString = doUpdateQuality("foo", 0, 0);
    Approvals.verify(itemString);
  }

  private String doUpdateQuality(String name, int sellIn, int quality) {
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    String itemString = app.items[0].toString();
    return itemString;
  }

}
