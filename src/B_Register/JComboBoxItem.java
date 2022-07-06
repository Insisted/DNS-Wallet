package B_Register;

import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class JComboBoxItem extends BasicComboBoxRenderer{
	private final ListSelectionModel enabledItems;
	private Color disabledColor = Color.lightGray;

	public JComboBoxItem(ListSelectionModel enabled){
		super();
		this.enabledItems = enabled;
	}

	public void setDisabledColor(Color disabledColor){
		this.disabledColor = disabledColor;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
		if ( !enabledItems.isSelectedIndex(index) ){//not enabled
			if ( isSelected ){
				c.setBackground(Color.CYAN);
                                c.setForeground(Color.black);
			}else{
				c.setBackground(super.getBackground());
                                c.setForeground(Color.black);
			}
		}else{
			c.setBackground(super.getBackground());
			c.setForeground(disabledColor);
		}
                
		return c;
	}
}