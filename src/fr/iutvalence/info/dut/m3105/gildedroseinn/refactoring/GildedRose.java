package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateAllItems();
	}

	/* Update all items */
	public static void updateAllItems()
	{
		for (int itemNumber = 0; itemNumber < items.size(); itemNumber++)
		{
			Item item = items.get(itemNumber);
			updateItem(item);
		}
	}

	private static void updateItem(Item item) {
		
		int itemQuality = item.getQuality();
		int sellIn = item.getSellIn();
		
		if ((!"Aged Brie".equals(item.getName()))
				&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
		{
			if (itemQuality > 0)
			{
				if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
				{
					item.setQuality(itemQuality - 1);
				}
			}
		}
		else
		{
			if (itemQuality < 50)
			{
				item.setQuality(itemQuality + 1);

				if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
				{
					if (sellIn < 11)
					{
						if (itemQuality < 50)
						{
							item.setQuality(itemQuality + 1);
						}
					}

					if (sellIn < 6)
					{
						if (itemQuality < 50)
						{
							item.setQuality(itemQuality + 1);
						}
					}
				}
			}
		}

		if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
		{
			item.setSellIn(sellIn - 1);
		}

		if (sellIn < 0)
		{
			if (!"Aged Brie".equals(item.getName()))
			{
				if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
				{
					if (itemQuality > 0)
					{
						if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
						{
							item.setQuality(itemQuality - 1);
						}
					}
				}
				else
				{
					item.setQuality(itemQuality - itemQuality);
				}
			}
			else
			{
				if (itemQuality < 50)
				{
					item.setQuality(itemQuality + 1);
				}
			}
		}
	}

}