package weiskopf.flickr;

import java.util.Arrays;

/**
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {
	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "FlickerFeed [items=" + Arrays.toString(items) + "]";
	}

	// TODO: add code here

}
