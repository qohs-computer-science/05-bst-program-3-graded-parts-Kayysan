import java.lang.Comparable;
import java.time.format.FormatStyle;

import org.w3c.dom.Node;

public class BST implements BSTInterface
{
    private TreeNode root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (root==null)
            return true;
        else
            return false;
    }


    public void add(Comparable newVal){
        size++;
        if (root==null){
            root = new TreeNode(newVal);
        }
        else if (newVal.compareTo(root.getValue())<=0){
            addHelper(newVal, root.getLeft(),root );
        }
        else{
            addHelper(newVal, root.getRight(),root );
        }
    }

    private void addHelper(Comparable value, TreeNode child, TreeNode parent){
        if (child==null){
            if (value.compareTo(parent.getValue())<=0){
                    parent.setLeft(new TreeNode(value, null, null));
            }
            else
                parent.setRight(new TreeNode(value, null, null));
            
        }
        else if(value.compareTo(parent.getValue())<=0){
            addHelper(value,child.getLeft(),child);
        }
        else{
            addHelper(value,child.getRight(),child);
        }
    }
    
	public void printInOrder(){
        if(root!=null){
            printInHelp(root.getLeft());
            System.out.print(root.getValue() + ", ");
            printInHelp(root.getRight());

        }
    }//end inorder
    public void printInHelp(TreeNode temp){
        if(temp!=null){
            printInHelp(temp.getLeft());
            System.out.print(temp.getValue() + ", ");
            printInHelp(temp.getRight());

        }
    }//    Helper for inorder
	// prints the tree using an In Order traversal - recursion

	public void printPreOrder(){
        if(root!=null){
            System.out.print(root.getValue() + ", ");
            printPreHelp(root.getLeft());
            printPreHelp(root.getRight());

        }

    }// end pre
	// prints the tree using a Pre Order traversal - recursion
    public void printPreHelp(TreeNode temp){
        if(temp!=null){
            System.out.print(temp.getValue() + ", ");
            printPreHelp(temp.getLeft());
            printPreHelp(temp.getRight());

        }
    }//    Helper for pre ord helper

	public void printPostOrder(){
        
        if(root!=null){
            
            printPostHelp(root.getLeft());
            printPostHelp(root.getRight());
            System.out.print(root.getValue() + ", ");

        }
    }
    public void printPostHelp(TreeNode temp){
        if(temp!=null){
            
            printPostHelp(temp.getLeft());
            printPostHelp(temp.getRight());
            System.out.print(temp.getValue() + ", ");

        }
    }//    Helper for post ord helper
    
    public boolean find(Comparable toFind) {
        // TODO Auto-generated method stub
        
        return true;
    }
    
    public boolean replace(Comparable old, Comparable toAdd) {
        // TODO Auto-generated method stub
        return true;
    }
    
    public boolean delete(Comparable old) {
        boolean boo= false;
        // TODO Auto-generated method stub
        if(root==null){
            return false;
        }
        if(old.compareTo(root.getValue())<0){
            return delHelp(old, root, root.getLeft());

        }//end for finding old on left side
        
        else  if (old.compareTo(root.getValue())==0){
            if (root.getRight()!=null && root.getLeft()==null){
                TreeNode temp = root.getRight();
                temp.setRight(null);
                root=temp;
    
            }//end else if for right
            else if (root.getRight()==null && root.getLeft()!=null){
                TreeNode temp = root.getLeft();
                temp.setLeft(null);
                root=temp;
    
            }//end else if for left
            else if (root.getRight()!=null && root.getLeft()!=null){
                TreeNode temp = root.getLeft();
                TreeNode temp1 = root.getLeft();
                while(temp1.getRight()!=null){
                    temp1=temp1.getRight();
                }//end while
                temp1.setRight(root.getRight());
                root.setRight(null);
                root.setLeft(null);
                root=temp;
    
            }// end if both left and right r not null
           
            else {
                root=null;
                
            }
            return true;
            
            
        }//end if the node is found
        else {
            return delHelp(old, root, root.getRight());

        }//end for finding old on right side
        
    }//end del
    

        
    public boolean delHelp(Comparable old, TreeNode nod, TreeNode side){
        if(side==null){
            return false;
        }
        if(old.compareTo(side.getValue())<0){
            return delHelp(old, side, side.getLeft());

        }//end for finding old on left side
        else if (old.compareTo(side.getValue())>0){
            return delHelp(old, side, side.getRight());

        }//end for finding old on right side
        
        else {
            if (side.getRight()!=null && side.getLeft()==null){
                if(old.compareTo(nod.getValue())<0)
                    nod.setLeft(side.getRight());
                else    
                    nod.setRight(side.getRight());

    
            }//end else if for right
            else if (side.getRight()==null && side.getLeft()!=null){
                if(old.compareTo(nod.getValue())<0)
                    nod.setLeft(side.getLeft());
                else    
                    nod.setRight(side.getLeft());
    
            }//end else if for left
            else if (root.getRight()!=null && root.getLeft()!=null){
                TreeNode temp = root.getLeft();
                if(old.compareTo(nod.getValue())<0)
                    nod.setLeft(temp);
                else
                    nod.setLeft(temp);
                while (temp.getRight()!=null){
                    temp=temp.getRight();
                }//end while
                temp.setRight(side.getRight());
    
            }// end if both left and right r not null
           
            else {
                root=null;
                
            }
            return true;
            
            
        }//end if the node is found
        
    }
  
    






}// end class