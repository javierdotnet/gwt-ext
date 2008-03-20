package com.gwtext.sample.showcase2.client;

import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;


public class OutlookTreePanel extends TreePanel {

	public OutlookTreePanel() {

		TreeNode root = new TreeNode("Mail");
		root.setIconCls("email-icon");
		root.setExpanded(true);

		TreeNode inbox = new TreeNode("Inbox");
		inbox.setIconCls("inbox-icon");
		root.appendChild(inbox);

		TreeNode drafts = new TreeNode("Drafts");
		drafts.setIconCls("drafts-icon");
		root.appendChild(drafts);

		TreeNode sent = new TreeNode("Sent");
		sent.setIconCls("sent-icon");
		root.appendChild(sent);

		TreeNode junk = new TreeNode("Spam");
		junk.setIconCls("spam-icon");
		root.appendChild(junk);

		TreeNode folders = new TreeNode("Folders");
		folders.setIconCls("folders-icon");
		folders.setExpanded(true);

		TreeNode todo = new TreeNode("ToDo");
		todo.setIconCls("folders-icon");
		folders.appendChild(todo);

		TreeNode resumes = new TreeNode("Resumes");
		resumes.setIconCls("folders-icon");
		folders.appendChild(resumes);

		TreeNode sales = new TreeNode("Sales");
		sales.setIconCls("folders-icon");
		folders.appendChild(sales);

		root.appendChild(folders);

		setTitle("E-Mail");
		setIconCls("email-icon");
		setWidth(200);
		setHeight(400);
		setEnableDD(true);
		setRootNode(root);
	}

}