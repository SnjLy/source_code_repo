package tree.common.nodevisitor;


import tree.common.Node;

/**
 * 深度遍历实现 之后序遍历
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
 * [L31, L32, L21, L33, L34, L22, L11, L35, L36, L23, L37, L38, L24, L12, ROOT]
 * 
 * @author jinli Dec 22, 2015
 */
public class RecursiveDepthPostOrderNodeVisitor<T extends Node<T>> implements Node.NodeVisitor<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }
        if (node.getChildren() != null) {
            for (Node<?> n : node.getChildren()) {
                visit((T) n, callback);
            }
        }
        Node.NodeVisitorState visitorState = callback.execute(node);
        if (visitorState == Node.NodeVisitorState.BREAK) {
            throw new IllegalStateException("unsupported operator!");
        }
    }

}
