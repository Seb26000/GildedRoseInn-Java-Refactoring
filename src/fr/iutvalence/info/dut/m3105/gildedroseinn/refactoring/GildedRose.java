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
			if ((!"Aged Brie".equals(items.get(itemNumber).getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName()))
			{
				if (items.get(itemNumber).getQuality() > 0)
				{
					if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
					{
						items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
					}
				}
			}
			else
			{
				if (items.get(itemNumber).getQuality() < 50)
				{
					items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName()))
					{
						if (items.get(itemNumber).getSellIn() < 11)
						{
							if (items.get(itemNumber).getQuality() < 50)
							{
								items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
							}
						}

						if (items.get(itemNumber).getSellIn() < 6)
						{
							if (items.get(itemNumber).getQuality() < 50)
							{
								items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
			{
				items.get(itemNumber).setSellIn(items.get(itemNumber).getSellIn() - 1);
			}

			if (items.get(itemNumber).getSellIn() < 0)
			{
				if (!"Aged Brie".equals(items.get(itemNumber).getName()))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName()))
					{
						if (items.get(itemNumber).getQuality() > 0)
						{
							if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
							{
								items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
							}
						}
					}
					else
					{
						items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - items.get(itemNumber).getQuality());
					}
				}
				else
				{
					if (items.get(itemNumber).getQuality() < 50)
					{
						items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
					}
				}
			}
		}
	}

}