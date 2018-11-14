package tree.common.nodevisitor;


import tree.common.Node;

import java.util.Stack;


/**
 * Created by baiju on 2015/12/22.
 * 1. Root 压人栈顶
 * 2. Repeat 栈顶节点
 *    2.1 取栈顶节点的未处理的子节点;
 *    2.2 不为空则压人栈中;
 *    2.3 否则为空(表示都无子节点或已处理)并弹出栈顶元素，执行回调,标记为已处理
 *
 * 遍历规则见: {@link RecursiveDepthPostOrderNodeVisitor}
 */
public class DepthPostOrderNodeVisitor<T extends Node<T>> implements tree.common.Node.NodeVisitor<T> {

    @Override
    public void visit(T node, Node.NodeVisitorCallback<T> callback) {
        if (node == null || callback == null) {
            return;
        }
        Stack<NodeVisitorState<T>> stack = new Stack<>();
        stack.push(new NodeVisitorState<T>(node));
        while (stack.size() > 0) {
            NodeVisitorState<T> root = stack.peek();
            T nextNode = root.getNextChild();
            if (nextNode != null) {
                stack.push(new NodeVisitorState<T>(nextNode));
                continue;
            }
            NodeVisitorState<T> nodeVisitorState = stack.pop();
            Node.NodeVisitorState visitorState = callback.execute(nodeVisitorState.getNode());
            if (visitorState == Node.NodeVisitorState.BREAK) {
                throw new IllegalStateException("unsupported operator!");
            }
            if (stack.size() > 0)
                stack.peek().moveToNextIndex();
        }
    }

    /**
     * 记录节点遍历位置
     * @param <T>
     */
    public static class NodeVisitorState<T extends Node<T>> {

        private T node;
        private int visitIndex;

        public NodeVisitorState(T node) {
            this.node = node;
        }

        public T getNextChild() {
            if (visitIndex < node.getChildren().size()) {
                return node.getChildren().get(visitIndex);
            }
            return null;
        }

        public int getVisitIndex() {
            return visitIndex;
        }

        public void moveToNextIndex() {
            visitIndex += 1;
        }

        public void setVisitIndex(int visitIndex) {
            this.visitIndex = visitIndex;
        }

        public T getNode() {
            return node;
        }

        public void setNode(T node) {
            this.node = node;
        }
    }
}
