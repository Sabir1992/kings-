package Util;

import java.util.List;

import javax.swing.JComboBox;

import Model.Menu;

public class ComboPopulate {

	public static JComboBox getMenuProducTypeListCombo(JComboBox combo,List<Menu> list) {
		
		for (Menu menu : list) {
			combo.addItem(menu);
		}
		return combo;
	}
}
