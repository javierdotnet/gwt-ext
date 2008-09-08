package com.gwtext.sample.showcase2.client;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;


public class SampleTree extends TreePanel {

	public SampleTree() {

		TreeNode root = new TreeNode("Company Heirarchy");

		TreeNode ceo = new TreeNode("Julie W. Walker");
		ceo.setExpanded(true);

		TreeNode manager1 = new TreeNode("William J. Vear");
		manager1.setExpanded(true);
		TreeNode manager2 = new TreeNode("Dennis E. Walker");
		manager2.setExpanded(true);
		TreeNode manager3 = new TreeNode("Joann R. Williams");
		manager3.setExpanded(true);

		ceo.appendChild(manager1);
		ceo.appendChild(manager2);
		ceo.appendChild(manager3);

		TreeNode director1 = new TreeNode("Robert L. Carbaugh");
		director1.setExpanded(true);

		TreeNode director2 = new TreeNode("Agnes H. Keene");
		director2.setExpanded(true);

		manager1.appendChild(director1);
		manager1.appendChild(director2);

		TreeNode director3 = new TreeNode("Erin T. Marks");
		manager2.appendChild(director3);

		manager3.appendChild(new TreeNode("Harry L. Krieger"));

		director1.appendChild(new TreeNode("Jim H. Baker"));
		director1.appendChild(new TreeNode("Randy M. Smith"));
		director1.appendChild(new TreeNode("Annie P. Burke"));
		director2.appendChild(new TreeNode("Shirley P. Tanaka"));
		director2.appendChild(new TreeNode("Anthony C. Decarlo"));
		director2.appendChild(new TreeNode("Katherine D. Saenz"));
		director3.appendChild(new TreeNode("Carolyn M. Gauna"));
		director3.appendChild(new TreeNode("Johanna E. Armistead"));
		director3.appendChild(new TreeNode("Duane E. Ashe"));
		director3.appendChild(new TreeNode("Norman N. Gardner"));
		root.appendChild(ceo);

		setRootVisible(false);

		setTitle("Company");
		setWidth(200);
		setHeight(400);
		setRootNode(root);
		root.setExpanded(true);
	}

}
