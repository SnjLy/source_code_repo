package tree.common.nodevisitor;


import tree.common.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 广度遍历实现
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
 * [ROOT, L11, L12, L21, L22, L23, L24, L31, L32, L33, L34, L35, L36, L37, L38]
 * 
 * @author jinli Dec 22, 2015
 */
public class RecursiveBreadthNodeVisitor<T extends Node<T>> implements Node.NodeVisitor<T> {

    @Override
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }
        Collection<T> nodes = new ArrayList<T>();
        nodes.add(node);
        doVisit(nodes, callback);
    }

    protected void doVisit(Collection<T> nodes, Node.NodeVisitorCallback<T> callback) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        Collection<T> nextNodes = new ArrayList<T>();

        Iterator<T> it = nodes.iterator();
        while (it.hasNext()) {
            T node = it.next();
            callback.execute(node);

            nextNodes.addAll(node.getChildren());
        }

        doVisit(nextNodes, callback);
    }

}
