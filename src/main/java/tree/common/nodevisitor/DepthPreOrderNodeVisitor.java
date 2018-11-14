package tree.common.nodevisitor;


import tree.common.Node;

import java.util.List;
import java.util.Stack;

/**
 * 非递归实现
 * 遍历规则见: {@link RecursiveDepthPreOrderNodeVisitor}
 * 
 * @author jinli Dec 22, 2015
 */
public class DepthPreOrderNodeVisitor<T extends Node<T>> implements Node.NodeVisitor<T> {

    @Override
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }

        Stack<T> stack = new Stack<T>();
        stack.push(node);

        while (!stack.isEmpty()) {
            T n = stack.pop();
            Node.NodeVisitorState nodeVisitorState = callback.execute(n);
            if (nodeVisitorState == Node.NodeVisitorState.BREAK) {
                continue;
            }
            List<T> children = n.getChildren();
            for (int i = 0; i < children.size(); i++) {
                stack.push(children.get(children.size() - i - 1));
            }
        }
    }

}
