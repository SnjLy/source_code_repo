package tree.common;


import tree.common.nodevisitor.BreadthNodeVisitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static tree.common.Node.NodeVisitorState.BREAK;
import static tree.common.Node.NodeVisitorState.CONTINUE;

/**
 * 树节点
 * 利用树节点数据结构, 可以构建类似如下的树
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
 * @author jinli Dec 22, 2015
 * @author baiju
 */
public class Node<T extends Node<T>> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;                                // 节点ID
    private Long parentId;                          // 父节点ID
    private Long rootId;                            // 祖宗节点ID
    private T parent;                               // 父节点
    private List<T> children = new ArrayList<T>();  // 子节点

    /**
     *
     * 添加节点到父节点中
     *
     * @param parent
     */
    @SuppressWarnings("unchecked")
    public void addToParent(T parent) {
        this.parent = parent;
        if (getParent() != null) {
            getParent().getChildren().add((T) this);
        }
    }

    /**
     * 删除节点
     */
    public void delete() {
        if (this == getRoot()) {
            throw new IllegalArgumentException("root node can't be deleted.");
        }
        Iterator<T> it = getParent().getChildren().iterator();
        while (it.hasNext()) {
            T c = it.next();
            if (this == c) {
                it.remove();
                break;
            }
        }
        this.setParentId(-1L);
        this.setRootId(-1L);
        this.setParent(null);
    }

    @SuppressWarnings("unchecked")
    public T getRoot() {
        T cur = (T) this;
        while (true) {
            if (cur.getParent() == null) {
                return cur;
            }
            cur = cur.getParent();
        }
    }

    public T getNode(final Long id) {
        if (id == null) {
            return null;
        }

        final List<T> ret = new ArrayList<>();
        new BreadthNodeVisitor<T>().visit(getRoot(), new NodeVisitorCallback<T>() {
            @Override
            public NodeVisitorState execute(T node) {
                if (node != null && id.equals(node.getId())) {
                    ret.add(node);
                    return BREAK;
                }
                return CONTINUE;
            }
        });

        return ret.isEmpty() ? null : ret.get(0);

    }

    /**
     * 获得当前节点所在的层级
     *
     * @return
     */
    public Integer getLevel() {
        int level = 0;
        Node<T> cur = this;
        while ((cur = cur.getParent()) != null) {
            level++;
        }
        return level;
    }

    @SuppressWarnings("unchecked")
    public List<T> getChildrenByNextLevel(final int level) {
        final List<T> children = new ArrayList<T>();
        final T current = (T) this;

        new BreadthNodeVisitor<T>().visit((T) this, new NodeVisitorCallback<T>() {
            @Override
            public NodeVisitorState execute(T node) {
                if (node.getLevel() - current.getLevel() == level) {
                    children.add(node);
                }
                return node.getLevel() - current.getLevel() <= level ? CONTINUE : BREAK;
            }
        });

        return children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    /**
     * <pre>
     * visit状态
     * CONTINUE: 继续
     * BREAK:    中断
     * </pre>
     *
     * @author jinli Dec 31, 2015
     */
    public enum NodeVisitorState {
        CONTINUE, BREAK;
    }

    /**
     * Visitor回调
     *
     * @author jinli Dec 22, 2015
     */
    public interface NodeVisitorCallback<T extends Node<T>> {

        NodeVisitorState execute(T node);

    }

    /**
     * Visitor模式
     *
     * @author jinli Dec 22, 2015
     */
    public interface NodeVisitor<T extends Node<T>> {

        void visit(T node, NodeVisitorCallback<T> callback);

    }

}
