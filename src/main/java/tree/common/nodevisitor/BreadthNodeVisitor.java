package tree.common.nodevisitor;

import tree.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 非递归实现
 * 遍历规则见: {@link RecursiveBreadthNodeVisitor}
 * 
 * @author jinli Dec 25, 2015
 */
public class BreadthNodeVisitor<T extends Node<T>> implements Node.NodeVisitor<T> {

    @Override
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }

        List<T> nextLevels = new ArrayList<T>();
        nextLevels.add(node);

        while (nextLevels != null && !nextLevels.isEmpty()) {
            List<T> children = new ArrayList<T>();
            for (T n : nextLevels) {
                Node.NodeVisitorState state = callback.execute(n);
                if (Node.NodeVisitorState.BREAK == state) {
                    break;
                }
                if (n != null && !n.getChildren().isEmpty()) {
                    children.addAll(n.getChildren());
                }
            }
            nextLevels = children;
        }

    }

}
