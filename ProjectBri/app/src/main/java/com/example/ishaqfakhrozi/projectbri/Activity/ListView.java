package com.example.ishaqfakhrozi.projectbri.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


import com.example.ishaqfakhrozi.projectbri.Fragment.MyHolder;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.TreeNode;
import com.example.ishaqfakhrozi.projectbri.view.AndroidTreeView;


public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        //Root
        TreeNode root = TreeNode.root();

        //Parent
        MyHolder.IconTreeItem nodeItem = new MyHolder.IconTreeItem(R.drawable.ic_arrow_drop_down, "Parent");
        TreeNode parent = new TreeNode(nodeItem).setViewHolder(new MyHolder(getApplicationContext(), true, MyHolder.DEFAULT, MyHolder.DEFAULT));

        //Child
        MyHolder.IconTreeItem childItem = new MyHolder.IconTreeItem(R.drawable.ic_folder, "Child");
        TreeNode child = new TreeNode(childItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 25));
        MyHolder.IconTreeItem childItem1 = new MyHolder.IconTreeItem(R.drawable.ic_folder, "Child");
        TreeNode child1 = new TreeNode(childItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 25));
        MyHolder.IconTreeItem childItem2= new MyHolder.IconTreeItem(R.drawable.ic_folder, "Child");
        TreeNode child2 = new TreeNode(childItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 25));

        //Sub Child
//        MyHolder.IconTreeItem subChildItem = new MyHolder.IconTreeItem(R.drawable.ic_folder, "Sub Child");
//        TreeNode subChild = new TreeNode(subChildItem).setViewHolder(new MyHolder(getApplicationContext(), false, R.layout.child, 50));

        //Add sub child.
//        child.addChild(subChild);


        //Add child.
        parent.addChildren(child);
        parent.addChildren(child1);
        parent.addChildren(child2);
        root.addChild(parent);

        //Add AndroidTreeView into view.
        AndroidTreeView tView = new AndroidTreeView(getApplicationContext(), root);
        ((LinearLayout) findViewById(R.id.ll_parent)).addView(tView.getView());
    }
}
