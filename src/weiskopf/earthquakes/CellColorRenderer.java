package weiskopf.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class CellColorRenderer extends DefaultListCellRenderer {
	// JList calls this every time it adds an item to the list (you do not call
	// it at all)
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// list = list that called it, value = the object being added to the
		// list
		Component c = super.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);

		Earthquake e = (Earthquake) value;
		double magnitude = Double.valueOf(e.getMagnitude());
		if (magnitude < 2) {
			c.setBackground(Color.MAGENTA);
		} else {
			if (magnitude < 3) {
				c.setBackground(Color.BLUE);
			} else {
				if (magnitude < 6) {
					c.setBackground(Color.GREEN);
				} else {
					if (magnitude < 7) {
						c.setBackground(Color.YELLOW);
					} else {
						if (magnitude < 9) {
							c.setBackground(Color.PINK);
						} else {
							c.setBackground(Color.RED);
						}

					}
				}
			}
		}
		return c;

	}
}
