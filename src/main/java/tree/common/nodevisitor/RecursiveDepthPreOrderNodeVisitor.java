package tree.common.nodevisitor;


import tree.common.Node;

/**
 * 深度遍历实现 之先序排序
 * 
 * <code>
 *  ROOT
 *   |-- L11
 *        |-- L21
 *             |-- L31
 *             |-- L32
 *        |-- L22
 *             |-- L33
 *             |-- L34
 *   |-- L12
 *        |-- L23
 *             |-- L35
 *             |-- L36
 *        |-- L24
 *             |-- L37
 *             |-- L38
 * </code>
 * 
 * 按照上面的树结构, 遍历出来的顺序就是:
 * [ROOT, L11, L21, L31, L32, L22, L33, L34, L12, L23, L35, L36, L24, L37, L38]
 * 
 * @author jinli Dec 22, 2015
 */
public class RecursiveDepthPreOrderNodeVisitor<T extends Node<T>> implements Node.NodeVisitor<T> {

    @Override
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }

        Node.NodeVisitorState nodeVisitorState = callback.execute(node);
        if (nodeVisitorState == Node.NodeVisitorState.BREAK) {
            return;
        }
        if (node.getChildren() != null) {
            for (T n : node.getChildren()) {
                visit((T) n, callback);
            }
        }
    }

}
