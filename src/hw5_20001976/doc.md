<!-- For better experiment, view with MD rendered mode -->

# Package: hw5_20001976.bai1

## Binary Tree Framework

### Interface: BinaryTreeInterface<E,T>

#### Implementing Classes

- ArrayBinaryTree
- LinkedBinaryTree

#### Type Parameters:

- E: type of elements in this tree
- T: type of tree's node
  - Array-base binary tree: Integer index in array
  - Linked-base binary tree: Node object

#### Functions:

|  type   |          Method          | Description                                   |
|:-------:|:------------------------:|:----------------------------------------------|
|    T    |    addRoot(E element)    | Add element to root of an empty tree          |
|    T    | addLeft(T p, E element)  | Add element to left child node of p if empty  |
|    T    | addRight(T p, E element) | Add element to right child node of p if empty |
|  void   |   set(T p, E element)    | set element to node p                         |
|  void   | setLeft(T p, E element)  | Set left child of p (at index 2p+1)           |
|  void   | setRight(T p, E element) | Set right child of p (at index 2p+2)          |
|    T    |          root()          | return root's address of tree                 |
|   int   |          size()          | return size of tree                           |
| boolean |        isEmpty()         | return true if tree is empty                  |
|   int   |     numChildren(T p)     | number of children of element p               |
|    T    |       parent(T p)        | return parent of p                            |
|    T    |        left(T p)         | return left child of p                        |
|    T    |        right(T p)        | return right child of p                       |
|    T    |       sibling(T p)       | return sibling of p                           |
|    E    |        value(T p)        | return value of p                             |
|   int   |       height(T p)        | height of tree from p                         |

### LinkedBinaryTree<E>

#### Implementation

- Implements BinaryTreeInterface<E,Node<E>>

#### Type Parameters:

- E: type of elements in this tree

#### Field

|        Modifier and Type         | Field | Description        |
|:--------------------------------:|:-----:|:-------------------|
| private LinkedBinaryTree.Node<E> | node  | store root of tree |
|           private int            | size  | size of tree       |

#### Functions:

|  type   |             Method             | Description                                                       |
|:-------:|:------------------------------:|:------------------------------------------------------------------|
| Node<E> |       addRoot(E element)       | Add element to root of an empty tree and return the node          |
| Node<E> | addLeft(Node<E> p, E element)  | Add element to left child node of p if empty and return the node  |
| Node<E> | addRight(Node<E> p, E element) | Add element to right child node of p if empty and return the node |
|  void   |   set(Node<E> p, E element)    | set element to node p                                             |
|  void   | setLeft(Node<E> p, E element)  | Set left child of p (at index 2p+1)                               |
|  void   | setRight(Node<E> p, E element) | Set right child of p (at index 2p+2)                              |
| Node<E> |             root()             | return root's address of tree                                     |
|   int   |             size()             | return size of tree                                               |
| boolean |           isEmpty()            | return true if tree is empty                                      |
|   int   |     numChildren(Node<E> p)     | number of children of element p                                   |
| Node<E> |       parent(Node<E> p)        | return parent of p                                                |
| Node<E> |        left(Node<E> p)         | return left child of p                                            |
| Node<E> |        right(Node<E> p)        | return right child of p                                           |
| Node<E> |       sibling(Node<E> p)       | return sibling of p                                               |
|    E    |        value(Node<E> p)        | return value of p                                                 |
|   int   |       height(Node<E> p)        | height of tree from p                                             |

#### Constructor

LinkedBinaryTree()

#### Sub Classes

##### Node

###### Field

| Modifier and Type | Field  | Description                    |
|:-----------------:|:------:|:-------------------------------|
|     private E     |  data  | store data in node             |
|  private Node<E>  |  left  | link to left element of node   |
|  private Node<E>  | right  | link to right element of node  |
|  private Node<E>  | parent | link to parent element of node |

###### Constructor

Node(E data,Node<E> parent,Node<E> left,Node<E> right)

### ArrayBinaryTree<E>

#### Implementation

- Implements BinaryTreeInterface<E,Integer>

#### Type Parameters:

- E: type of elements in this tree

#### Field

| Modifier and Type |    Field     | Description           |
|:-----------------:|:------------:|:----------------------|
|    private E[]    |    array     | store data of tree    |
| private final int | DEFAULT_SIZE | default size of array |
|    private int    |     size     | size of tree          |

#### Functions:

|  type   |             Method             | Description                                                             |
|:-------:|:------------------------------:|:------------------------------------------------------------------------|
| Integer |       addRoot(E element)       | Add element to root of an empty tree and return the index in array      |
| Integer | addLeft(Integer p, E element)  | Add element to left child node of p if empty and return index in array  |
| Integer | addRight(Integer p, E element) | Add element to right child node of p if empty and return index in array |
|  void   |   set(Integer p, E element)    | set element to node p                                                   |
|  void   | setLeft(Integer p, E element)  | Set left child of p (at index 2p+1)                                     |
|  void   | setRight(Integer p, E element) | Set right child of p (at index 2p+2)                                    |
| Integer |             root()             | return root's address of tree                                           |
|   int   |             size()             | return size of tree                                                     |
| boolean |           isEmpty()            | return true if tree is empty                                            |
|   int   |     numChildren(Integer p)     | number of children of element p                                         |
| Integer |       parent(Integer p)        | return parent's index in array of p                                     |
| Integer |        left(Integer p)         | return left child's index in array of p                                 |
| Integer |        right(Integer p)        | return right child's index in array of p                                |
| Integer |       sibling(Integer p)       | return sibling's index in array of p                                    |
|    E    |        value(Integer p)        | return value of p                                                       |
|   int   |       height(Integer p)        | height of tree from p                                                   |

#### Constructor

ArrayBinaryTree()

### Class Bai1Y3Array

#### Field

| Modifier and Type |   Field   | Description           |
|:-----------------:|:---------:|:----------------------|
| static Formatter  | formatter | export to file        |
|    static File    |   file    | file will be exported |
|    private int    |     n     | size of tree          |

#### Functions:

|    type     |                                              Method                                               | Description                                                                   |
|:-----------:|:-------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------|
| static void |                                        main(String[] args)                                        | main function for fill data and print                                         |
| static void | add(int startPosition, int startValue, ArrayBinaryTree<Integer> array, int height, int maxHeight) | Fill data from position with height is maxHeight (input height always 0 and ) |
| static void |                  print(int position, int space, ArrayBinaryTree<Integer> array)                   | Print tree to file from position                                              |

Reference: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/

### Class Bai1Y3Array (similar as Bai1Y3Array)

### P869

#### Sub Classes

##### TreeView

###### Field

|       Modifier and Type       |   Field    | Description        |
|:-----------------------------:|:----------:|:-------------------|
| protected LinkedBinaryTree<E> |    tree    | tree will be print |
|          private int          | treeHeight | height of tree     |

###### Method

| Modifier and Type |                                                       Method                                                        | Description                                                         |
|:-----------------:|:-------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------|
|  protected void   | drawTree(Graphics g, int minX, int maxX, int y, int yStep, LinkedBinaryTree.Node<E> node, LinkedBinaryTree<E> tree) | draw a tree from node with node data and line to children node data |
|  protected void   |                                             paintComponent(Graphics g)                                              | draw tree in frame                                                  |
