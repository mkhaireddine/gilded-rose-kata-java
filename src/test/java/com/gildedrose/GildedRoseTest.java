package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.jupiter.api.Test;

@UseReporter(IntelliJReporter.class)
class GildedRoseTest {

  @Test
  void updateQuality() {
    CombinationApprovals.verifyAllCombinations(
        this::doUpdateQuality,
        new String[]{"foo"},
        new Integer[]{0},
        new Integer[]{0}
    );
  }

  private String doUpdateQuality(String name, int sellIn, int quality) {
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    String itemString = app.items[0].toString();
    return itemString;
  }

}
