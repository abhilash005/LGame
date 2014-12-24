package loon.core.graphics.component.table;

import loon.core.geom.Alignment;
import loon.core.geom.Dimension;
import loon.core.graphics.LColor;
import loon.core.graphics.LFont;
import loon.core.graphics.opengl.GLEx;

public class TextCellRenderer implements ICellRenderer {
	private LFont font = LFont.getDefaultFont();
	private LColor textColor = LColor.white;
	private Alignment alignment = Alignment.LEFT;

	public void paint(GLEx g, Object value, int x, int y, int width, int height) {
		String s = value.toString();

		s = font.confineLength(s, width - 4);

		int entryOffset = 4 + alignment.alignX(width - 4, font.stringWidth(s));

		g.setFont(font);
		g.setColor(textColor);

		g.drawString(s, x + entryOffset, y + font.getHeight() - 4);
	}

	public void setFont(LFont font) {
		this.font = font;
	}

	public void setTextColor(LColor textColor) {
		this.textColor = textColor;
	}

	public Dimension getCellContentSize(Object value) {
		if (value == null) {
			return null;
		}
		String s = value.toString();
		return new Dimension(font.stringWidth(s), font.getHeight());
	}
}